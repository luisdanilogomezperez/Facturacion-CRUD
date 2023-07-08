<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido</title>

        <link rel="stylesheet" href="estilos/estilos.css">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">


    </head>
    <body>

        <div class="container ">


            <div class="txt_center">
                <h1>Facturación</h1>
                <div id="">
                    <ul class="menu">
                        <li><a href="ClientesController?accion=listar" ><button class="btn btn-info">Listar clientes</button></a> </li>
                        
                        <li><a href="FacturaController?accion=registrar" ><button class="btn btn-info">Crear Factura</button></a></li>

                        <li><a href="FacturaController?accion=listar" ><button class="btn btn-info">Listar Facturas</button></a></li>
                    </ul>

                </div>

                <div></div>

            </div>
        </div>






        <!-- Latest compiled and minified JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
