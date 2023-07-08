<%@page import="VO.Factura"%>
<%@page import="java.util.Iterator"%>
<%@page import="VO.Factuta_Articulo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editando Factura</title>

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
                    <form  action="FacturaController">
                    <%
                        Factura factura = new Factura();
                        factura = (Factura) request.getAttribute("factura");
                    %>

                    <h1>Editando la factura #<%= factura.getFactura_id()%></h1>
                     <li style="list-style: none"><a href="FacturaController?accion=listar" ><button class="btn btn-info">Volver</button></a></li>  
                     <hr>
                    <table class="table table-responsive table-bordered table-sm txt_center">
                        <thead >
                            <tr>
                                <th>Numero de Factura</th>
                                <th>Cliente</th>
                                <th>Subotal</th>
                                <th>Iva</th>
                                <th>Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>

                                <td>
                                    <%= factura.getFactura_id()%> 
                                    <input type="text" hidden id="factura_id" name="factura_id" value="<%= factura.getFactura_id()%>">
                                </td>
                                <td>
                                    <%= factura.getCliente().getNombre()%>  <%= factura.getCliente().getApellido()%>
                                    <input type="text" hidden id="cliente_id" name="cliente_id" value="<%= factura.getCliente().getDocumento() %>">
                                </td>
                                <td><%= factura.getSubtotal()%></td>
                                <td><%= factura.getIva()%></td>
                                <td><%= factura.getTotal()%></td>
                            </tr>

                        </tbody>
                    </table>
                    <hr>
                    <h2>Artículos relacionados a la factura</h2>
                    
                        <table class="table table-responsive table-bordered table-sm txt_center">
                            <thead>
                                <tr>
                                    <th>Artículo</th>
                                    <th>Cantidad</th>
                                    <th>Precio Unitario</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    List<Factuta_Articulo> factuta_Articulo = new ArrayList<>();

                                    factuta_Articulo = (List<Factuta_Articulo>) request.getAttribute("articulos");
                                    Iterator<Factuta_Articulo> it2 = factuta_Articulo.iterator();
                                    Factuta_Articulo c2 = null;
                                    while (it2.hasNext()) {
                                        c2 = it2.next();
                                %>
                                <tr>
                                    <td><%= c2.getNombreArticulo()%></td>
                                    <td> 
                                        <input type="text" hidden id="Id_Articulo" name="Id_Articulo" value="<%= c2.getArticulo().getArticulo_id()%>">
                                        <input style="width: 60px; margin-left: 5px;" name="cantidadArticulos" type="number" id="cantidadArticulos" value="<%= c2.getCantidadArticulo()%>" >
                                    </td>

                                    <td><%= c2.getPrecioArticulo()%></td>
                                </tr>
                                <%}%>

                            </tbody>
                        </table>
                                 <input type="submit" class="btn btn-info" name="accion" value="Actualizar Factura">
                    </form>

                   </div> 
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</body>
</html>
