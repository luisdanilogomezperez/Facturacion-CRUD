<%-- 
    Document   : reg_fact
    Created on : 7/07/2023, 04:56:06 PM
    Author     : dan
--%>

<%@page import="VO.Articulo"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="VO.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Facturando</title>


        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <link rel="stylesheet" href="../estilos/estilos.css">


    </head>
    <body>

        <div class="container">
            <div class="row txt_center">

                <div class="col-md-2"></div>

                <div class="col-md-8">
                    <div><h1>Registro de Facturas</h1></div>
                     <li style="list-style: none"><a href="FacturaController?accion=listar" ><button class="btn btn-info">Ver a Facturas</button></a></li>
                    <hr>
                    <form action="FacturaController" class="">

                        <p>
                        <div class="">
                            <h2>Listado de clientes</h2>
                            <p>Seleccione el cliente que va a hacer la compra.</p>
                            <br>
                            <select class="" name="cliente_id" id="cliente_id">
                                <%
                                    List<Cliente> clientes2 = new ArrayList<>();
                                    clientes2 = (List<Cliente>) request.getAttribute("clientes");
                                    Iterator<Cliente> it2 = clientes2.iterator();
                                    Cliente c2 = null;
                                    while (it2.hasNext()) {
                                        c2 = it2.next();
                                %>
                                <option value="<%=c2.getDocumento()%>"><%= c2.getDocumento()%> - <%= c2.getNombre()%>  <%= c2.getApellido()%></option>
                                <%}%>

                            </select>
                        </div>
                        </p>
                        <hr>
                        <p>
                        <h2>Listado de Articulos</h2>
                        <p>Seleccione los artículos y la cantidad que desea agregar a la factura.</p>
                        <table class="table table-responsive table-bordered table-sm txt_center">
                            <thead >
                                <tr>
                                    <th>Artículo</th>
                                    <th>Precio (kg)</th>
                                    <th>Cantidad disponible</th>
                                    <th>Seleccinar</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    List<Articulo> articulos = new ArrayList<>();
                                    articulos = (List<Articulo>) request.getAttribute("articulos");
                                    Iterator<Articulo> it = articulos.iterator();
                                    Articulo a = null;
                                    while (it.hasNext()) {
                                        a = it.next();
                                %>
                                <tr>
                                    <td><%= a.getNombre()%></td>
                                    <td><%= a.getPrecio()%></td>
                                    <td><%= a.getCantidad()%></td>
                                    <td> 
                                        <div class="input-group-text" style="display: flex">
                                            <input type="checkbox" id="Id_Articulo" name="Id_Articulo" value="<%= a.getArticulo_id()%>">
                                            <input style="width: 60px; margin-left: 5px;" name="cantidadArticulos" type="number" id="cantidadArticulos" value="0" >

                                        </div> 
                                    </td>
                                    <td>
                                        <form action="FacturaController">
                                            <input type="text" id="Id_Articulo" name="Id_Articulo" hidden value="<%= a.getArticulo_id()%>">

                                            <input type="submit"  name="accion" class="btn btn-primary" value="Editar" >

                                            <input type="submit" name="accion" class="btn btn-danger" value="Eliminar">
                                        </form>
                                    </td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                        </p>

                        <p>
                            <input class="btn btn-primary" type="submit" name="accion" value="Agregar">

                        </p>

                    </form>
                    
                </div>

                <div class="col-md-4">
                    
                </div>
            </div>

        </div>

        <script src="../operacionesJS/operaciones.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    </body>
</html>
