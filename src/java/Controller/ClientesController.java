/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Facade.Facade;
import Mediador.Mediador_Factura;
import VO.Cliente;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dan
 */
@WebServlet(name = "ClientesController", urlPatterns = "/ClientesController")
public class ClientesController extends HttpServlet {

    String listar = "Vistas/clientes.jsp";
    String registrar = "Vistas/reg_cli.jsp";

    Facade facade = new Facade();
    Cliente cliente = new Cliente();
    List<Cliente> clientes = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acceso = "";
        String accion = request.getParameter("accion");

        if (accion.equalsIgnoreCase("listar")) {
            clientes = facade.listarClientes();
            request.setAttribute("clientes", clientes);
            acceso = listar;
        } else if (accion.equalsIgnoreCase("registrar")) {
            acceso = registrar;
        } else if (accion.equalsIgnoreCase("Agregar")) {
            String documento = request.getParameter("documento");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String tlefono = request.getParameter("telefono");
            cliente.setDocumento(documento);
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setTelefono(tlefono);
            facade.registrarCLiente(cliente);
            clientes = facade.listarClientes();
            request.setAttribute("clientes", clientes);
            acceso = listar;
        } else if(accion.equalsIgnoreCase("Eliminar")){
            String documento = request.getParameter("cliente_id");
            facade.eliminarCliente(documento);
            clientes = facade.listarClientes();
            request.setAttribute("clientes", clientes);
            acceso = listar;
        } else if(accion.equalsIgnoreCase("Editar")){
            
        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

}
