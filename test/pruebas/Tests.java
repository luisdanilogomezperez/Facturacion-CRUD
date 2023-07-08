/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import DAO.ArticuloDAO;
import DAO.ClienteDAO;
import DAO.FacturaDAO;
import Mediador.Mediador_Factura;
import VO.Articulo;
import VO.Cliente;
import VO.Factura;
import VO.Factuta_Articulo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dan
 */
public class Tests {

    public static void main(String[] args) {
//        Articulo a = new Articulo();
//        ArticuloDAO adao = new ArticuloDAO();
//        Cliente cliente = new Cliente();
//        ClienteDAO cdao = new ClienteDAO();
//        Factura factura = new Factura();
//        FacturaDAO facturaDAO = new FacturaDAO();
//        List<Factuta_Articulo> articulos1 = new ArrayList();
//        List<Articulo> articulosActualizar = new ArrayList();
//
//        facturaDAO.eliminarFactura(90935);
//        Mediador_Factura mediador_Factura = new Mediador_Factura();
//
//        
//        factura = facturaDAO.buscarFactura(90934);
//            System.out.println(factura.getFactura_id());
//            articulos1 = facturaDAO.listarArticulosPorFactura(factura.getFactura_id());
//
//            for (Factuta_Articulo factura1 : articulos1) {
//                System.out.println(factura1.getArticulo().getNombre() + "  -  " + factura1.getFactura().getFactura_id());
//            }
//        
//        
//        cliente = new Cliente("365f4", "Camilo", "Hernandez Patarrollo", "231231412");
//        List<Factura> facturas = new ArrayList<>();
//        facturas = facturaDAO.listarFacturas();
//        clientes = mediador_Factura.listarClientes();
//
//        for (Factura cli : facturas) {
//            
//            System.out.println("Factura ID: " + cli.getFactura_id() + " - Cliente: " + cli.getCliente().getNombre() + " - producto: " + cli.getFecha());
//        }

//        System.out.println(mediador_Factura.registrarCLiente(cliente));
//        factura2 = facturaDAO.buscarFactura(90936);
//        System.out.println(factura2.getFactura_id());
//        articulos1 = facturaDAO.listarArticulosPorFactura(factura2.getFactura_id());
//
//        for (Factuta_Articulo factura1 : articulos1) {
//            System.out.println(factura1.getArticulo().getNombre() + "  -  " + factura1.getFactura().getFactura_id());
//        }

//        System.out.println("2");
//        List<Factuta_Articulo> articulosFactura = new ArrayList();
//        
//        System.out.println("3");
//            for (Factuta_Articulo art1 : articulos1) {
//
//                art1.getId_factura_articulo();
//                art1.getFactura().getFactura_id();
//                art1.getArticulo().getArticulo_id();
//                art1.setCantidadArticulo(8);
//                art1.getPrecioArticulo();
//                
//                
//                articulosFactura.add(art1);
//            }
//            
//            System.out.println("Saliendo del foreach");
//        int subtotal=0;
//        for(Factuta_Articulo art : articulosFactura){
//        System.out.println("id: " + art.getId_factura_articulo() + " - id articulo: " + art.getArticulo().getArticulo_id() +  " - id factura: " + art.getFactura().getFactura_id() + " - Nombre: " + art.getNombreArticulo() + " - Cantidad: " + art.getCantidadArticulo());
//            
//            subtotal += art.getCantidadArticulo()*art.getPrecioArticulo();
//        }
//        
//        int iva = (subtotal * 19) / 100;
//        int total = iva + subtotal;
//
//        factura.setSubtotal(subtotal);
//        factura.setIva(iva);
//        factura.setTotal(total);
//        
//        cliente = cdao.buscarCliente("1090493388");
//  
//        
//        String sehizo = facturaDAO.modificarFactura(cliente, articulosFactura, factura);
//        System.out.println(sehizo);
//        
//        cliente = cdao.buscarCliente("1234");
//        System.out.println("Documento: " + cliente.getDocumento() + " - Nombre: " + cliente.getNombre());
//        
//        int iva = (subtotal * 19) / 100;
//        int total = iva + subtotal;
//        
//        factura.setFactura_id(90935);
//        factura.setCliente(cliente);
//        factura.setSubtotal(subtotal);
//        factura.setIva(iva);
//        factura.setTotal(total);
//        
//        String sehizo = facturaDAO.modificarFactura(cliente, articulosFactura, factura);
//        System.out.println(sehizo);
//        List<Cliente> clientes = new ArrayList();
//        clientes = cdao.listarClientes();
//        cliente = cdao.buscarCliente("1090493388");
//        a.setNombre("Papaya");
//        a.setCantidad(100);
//        a.setPrecio(2000);
//        cliente.setDocumento("10904234");
//        cliente.setNombre("Jose");
//        cliente.setApellido("Perez");
//        cliente.setTelefono("312350");
//        cdao.registrarCliente(cliente);
//        adao.registrarArticulo(a);
//        adao.eliminarArticulo(25);
//        a = adao.buscarArticuloByName("papaya");
//          
//        System.out.println("ID: " + a.getArticulo_id() + " - Nombre: " + a.getNombre() + " - Cantidad: " + a.getCantidad());
//        cdao.actualizarCliente(cliente);
//        cdao.eliminarCliente("10904234");
    }
}
