<%-- 
    Document   : ver_fact
    Created on : 7/07/2023, 04:56:43 PM
    Author     : dan
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="VO.Factura"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Facturas</title>
        
        <link rel="stylesheet" href="../estilos/estilos.css">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">


    </head>
    <body>
    <div class="container">
        <div class="row wrappertxt_center">
            <div class="col-md-2"> 
                
            </div>
            <div class="col-md-8">
                <h1>Facturas GNososft</h1>
                <a style="none" href="FacturaController?accion=registrar" ><button class="btn btn-primary">Crear factura</button></a>  
                <a href="FacturaController?accion=inicio" ><button class="btn btn-info">Volver al inicio</button></a>
                <br>
                <br>
                <table class="table table-responsive table-bordered table-sm txt_center">
                    <thead >
                        <tr>
                            <th>Numero de Factura</th>
                            <th>Cliente</th>
                            <th>Subotal</th>
                            <th>Iva</th>
                            <th>Total</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<Factura> facturas = new ArrayList<>();
                            facturas = (List<Factura>) request.getAttribute("facturas");
                            Iterator<Factura> it2 = facturas.iterator();
                            Factura c2 = null;
                            while (it2.hasNext()) {
                                c2 = it2.next();
                        %>
                        <tr>
                            <td><%= c2.getFactura_id() %></td>
                            <td><%= c2.getCliente().getNombre() %>  <%= c2.getCliente().getApellido() %></td>
                            <td><%= c2.getSubtotal() %></td>
                            <td><%= c2.getIva() %></td>
                            <td><%= c2.getTotal() %></td>
                            <td>
                                <form action="FacturaController">
                                    <input type="text" id="factura_id" name="factura_id" hidden value="<%= c2.getFactura_id() %>">
                                    
                                    <input type="submit" name="accion" class="btn btn-primary" value="Ver detalles">
                                
                                    <input type="submit"  name="accion" class="btn btn-primary" value="Editar" >
                                
                                    <input type="submit" name="accion" class="btn btn-danger" value="Eliminar">
                                </form>
                              </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

       <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
