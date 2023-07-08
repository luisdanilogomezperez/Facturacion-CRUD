/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Facade.Facade;
import Mediador.Mediador_Factura;
import VO.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dan
 */
public class FacturaController extends HttpServlet {

    String listar = "Vistas/ver_fact.jsp";
    String registrar = "Vistas/reg_fact.jsp";
    String detalles = "Vistas/detall_fac.jsp";
    String editar = "Vistas/edi_fact.jsp";
    String inicio = "index.jsp"; 
    
    Facade facade = new Facade();
    Cliente cliente = new Cliente();
    Factura factura = new Factura();
    Articulo articulo = new Articulo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acceso = "";
        String accion = request.getParameter("accion");
        
        if (accion.equalsIgnoreCase("inicio")){
            acceso=inicio;
        }else if (accion.equalsIgnoreCase("listar")) {
            List<Factura> facturas = new ArrayList<>();

            facturas = facade.listarFacturas();
            request.setAttribute("facturas", facturas);
            acceso = listar;

        } else if (accion.equalsIgnoreCase("registrar")) {
            List<Articulo> articulos = new ArrayList<>();
            List<Cliente> clientes = new ArrayList<>();
            articulos = facade.listarArticulos();
            clientes = facade.listarClientes();
            request.setAttribute("clientes", clientes);
            request.setAttribute("articulos", articulos);

            acceso = registrar;

        } else if (accion.equalsIgnoreCase("Agregar")) {
            String[] articulosSeleccionados = request.getParameterValues("Id_Articulo");
            String[] cantidadArticulo = request.getParameterValues("cantidadArticulos");
            String cliente = request.getParameter("cliente_id");
            List<Articulo> listaArticulos = new ArrayList<>();
            // Verificar si se seleccionaron artículos
            if (Integer.parseInt(cantidadArticulo[0])>=1) {
                

                for (int i = 0; i < articulosSeleccionados.length; i++) {

                    System.out.println("can art: " + cantidadArticulo[i]);

                    Articulo articulo = new Articulo();
                    // Agregar el objeto Articulo a la lista
                    articulo = facade.buscarArticulo(Integer.parseInt(articulosSeleccionados[i]));
                    
                    articulo.setCantidad(Integer.parseInt(cantidadArticulo[i]));
                    
                    listaArticulos.add(articulo);
                    
                    if (facade.actualizarProductos(listaArticulos) == false) {
                        List<Factura> facturas;
                        facturas = facade.listarFacturas();
                        request.setAttribute("facturas", facturas);
                        acceso = registrar;
                    }
                }
                Cliente cliente1 = facade.buscarCliente(cliente);

                String secreo = facade.registrarFactura(cliente1, listaArticulos);
                System.out.println(secreo);
                

            }else{
                List<Factura> facturas;
                facturas = facade.listarFacturas();
                request.setAttribute("facturas", facturas);
                acceso = listar;
            }

        } else if (accion.equalsIgnoreCase("Ver detalles")) {
            String factura_id = request.getParameter("factura_id");

            System.out.println("id de la factura que estoy viendo los detalles: " + factura_id);

            List<Factuta_Articulo> factuta_Articulos = new ArrayList<>();
            Factura factura = new Factura();
            factura = facade.buscarFactura(Integer.parseInt(factura_id));

            factuta_Articulos = facade.listarArticulosXFactura(factura.getFactura_id());
            request.setAttribute("articulos", factuta_Articulos);
            request.setAttribute("factura", factura);
            acceso = detalles;
            
        } else if (accion.equalsIgnoreCase("Eliminar")) {
            String factura_id = request.getParameter("factura_id");
            facade.eliminarFactura(Integer.parseInt(factura_id));
            List<Factura> facturas;
            facturas = facade.listarFacturas();
            request.setAttribute("facturas", facturas);
            acceso = listar;
        }else if(accion.equalsIgnoreCase("Editar")){
            String factura_id = request.getParameter("factura_id");

            System.out.println("id de la factura que estoy viendo los detalles: " + factura_id);

            List<Factuta_Articulo> factuta_Articulos = new ArrayList<>();
            Factura factura = new Factura();
            
            factura = facade.buscarFactura(Integer.parseInt(factura_id));

            factuta_Articulos = facade.listarArticulosXFactura(factura.getFactura_id());
            
            request.setAttribute("articulos", factuta_Articulos);
            request.setAttribute("factura", factura);
             acceso = editar;
             
        }else if(accion.equalsIgnoreCase("Actualizar Factura")){
            
            String[] articulosSeleccionados = request.getParameterValues("Id_Articulo");
            String[] cantidadArticulo = request.getParameterValues("cantidadArticulos");
            
            String cliente = request.getParameter("cliente_id");
            String factura = request.getParameter("factura_id");

            List<Articulo> listaArticulos = new ArrayList<>();
            List<Factuta_Articulo> listaArticulos_factura = new ArrayList<>();
            Factura factura1 = facade.buscarFactura(Integer.parseInt(factura));
            
            listaArticulos_factura = facade.buscarArticuloPosFactura(Integer.parseInt(factura));
            
                for (int i = 0; i < listaArticulos_factura.size(); i++) {

                    System.out.println("can art: " + cantidadArticulo[i]);
                    
                    listaArticulos_factura.get(i).setCantidadArticulo(Integer.parseInt(cantidadArticulo[i]));
                    
                    System.out.println("Esta es la nueva cantidad de articulos: "+ listaArticulos_factura.get(i).getCantidadArticulo());

                    Factuta_Articulo factuta_Articulo = new Factuta_Articulo();
                    
                }
                Cliente cliente1 = facade.buscarCliente(cliente);
                System.out.println("Cliente: " + cliente1.getNombre() + "Documento: " + cliente1.getDocumento() + "-------");
                factura1.setCliente(cliente1);
                
                String seactualizo = facade.modificarFactura(cliente1, listaArticulos_factura, factura1);
                System.out.println(seactualizo);
                List<Factura> facturas;
                facturas = facade.listarFacturas();
                request.setAttribute("facturas", facturas);
                acceso = listar;

        }
        

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);

    }
}
