<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="VO.Cliente"%>
<%@page import="DAO.ClienteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido</title>

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
                    <h1>Clientes</h1>
                    <a style="none" href="ClientesController?accion=registrar" ><button class="btn btn-primary">Registrar clientes</button></a>  
                    <a href="FacturaController?accion=inicio" ><button class="btn btn-info">Volver al inicio</button></a>
                    <br>
                    <br>
                    <table class="table table-responsive table-bordered table-sm">
                        <thead>
                            <tr>
                                <th>Documento</th>
                                <th>Nombre completo</th>
                                <th>Telefono</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<Cliente> clientes2 = new ArrayList<>();
                                clientes2 = (List<Cliente>) request.getAttribute("clientes");
                                Iterator<Cliente> it2 = clientes2.iterator();
                                Cliente c2 = null;
                                while (it2.hasNext()) {
                                    c2 = it2.next();
                            %>
                            <tr>
                                <td><%= c2.getDocumento()%>
                                    <form ClientesController>
                                        <input type="text" hidden id="cliente_id" name="cliente_id" value="<%= c2.getDocumento()%>">


                                        </td>
                                        <td><%= c2.getNombre()%>  <%= c2.getApellido()%></td>
                                        <td><%= c2.getTelefono()%></td>
                                        <td> <input type="submit" name="accion" class="btn btn-danger" value="Eliminar"> <a style="none" href="ClientesController?accion=Editar" ><button class="btn btn-primary">Editar</button></a></td>
                                    </form>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>


        <!-- Latest compiled and minified JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    </body>
</html>
