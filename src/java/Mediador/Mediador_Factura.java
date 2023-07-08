/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mediador;

import VO.*;
import DAO.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dan
 */
public class Mediador_Factura {

    Factura factura = new Factura();
    FacturaDAO facturaDAO = new FacturaDAO();

    Articulo a = new Articulo();
    ArticuloDAO adao = new ArticuloDAO();

    Cliente cliente = new Cliente();
    ClienteDAO cdao = new ClienteDAO();

    Factuta_Articulo factuta_Articulo = new Factuta_Articulo();

    public Mediador_Factura() {
    }
    
    /**
     * Metodo para buscar facturas
     * @param factura_id
     * @return 
     */
    public Factura buscarFactura(int factura_id){
        Factura factura;
        
        factura = facturaDAO.buscarFactura(factura_id);
        
        return factura;
    }
    /**
     * Metodo para listar articulos
     * @param factura_id
     * @return 
     */
    public List<Factuta_Articulo> listarArticulosXFactura(int factura_id){
        List<Factuta_Articulo> articulos = new ArrayList<>();
        
        articulos = facturaDAO.listarArticulosPorFactura(factura_id);
        
        return articulos;
    }
            
    
    /**
     * Metodo que llama a ClienteDAO para registrar un cliente
     * @param cli
     * @return 
     */
    public String registrarCLiente(Cliente cli) {
        String msg;
        boolean existe = cdao.existeCliente(cli.getDocumento());

        if (existe) {
            msg = "Ya existe un cliente registrado con esete mismo numero de documento";
        } else {
            msg = cdao.registrarCliente(cli);
        }
        return msg;
    }
    
    /**
     * Metodo que llama a ClienteDAO para listar todos clientes
     * @return 
     */
    public List<Cliente> listarClientes() {

        List<Cliente> clientes;

        clientes = cdao.listarClientes();

        return clientes;
    }
    
    /**
     * Metodo para eliminar clientes
     */
    public void eliminarCliente(String documento){
        cdao.eliminarCliente(documento);
    }
    /**
     * Metodo para registrar Facturas
     * @param cliente
     * @param articulos
     * @return 
     */
    public String registrarFactura(Cliente cliente, List<Articulo> articulos){
        String msg = "";
        Factura factura = new Factura();
        if(articulos.isEmpty() || cliente==null){
            msg = "Ingrese todos los valores necesarios para crear la factura";
        }else{
            
        int subtotal=0;
        for(Articulo art : articulos){
            subtotal += art.getCantidad()*art.getPrecio();
        }
        
        int iva = (subtotal * 19) / 100;
        int total = iva + subtotal;

        factura.setSubtotal(subtotal);
        factura.setIva(iva);
        factura.setTotal(total);
            
            msg = facturaDAO.crearFactura(cliente, articulos, factura);
            
        }
        
        return msg;
    }
    
    public List<Factura> listarFacturas(){
        
        List<Factura> facturas = new ArrayList<>();
        
        facturas = facturaDAO.listarFacturas();
        
        return facturas;
        
    } 
    
    public List<Articulo> listarArticulos(){
        List<Articulo> articulos = new ArrayList<>();
        
        articulos = adao.listarArticulos();
        
        return articulos;
    }
    
    public Articulo buscarArticulo(int articulo_id){
        Articulo articulo = new Articulo();
        
        articulo = adao.buscarArticulo(articulo_id);
        
        return articulo;
    }
    
    public List<Factuta_Articulo> buscarArticuloPosFactura(int factura_id){
        List<Factuta_Articulo> articulos = new ArrayList<>();
        
        articulos = facturaDAO.listarArticulosPorFactura(factura_id);
        
        return articulos;
    }
    
    public Cliente buscarCliente(String clietnte_id){
        Cliente cliente = new Cliente();
        
        cliente = cdao.buscarCliente(clietnte_id);
        
        return cliente;
    }
    
    public boolean existeCliente(String documento){
        boolean existe=false;
        
        if(cdao.existeCliente(documento)){
            existe=true;
        }else{
            existe=false;
        }
        return existe;
        
    }
    
    public void eliminarFactura(int factura_id){
        facturaDAO.eliminarFactura(factura_id);
    }
    
    public boolean actualizarProductos(List<Articulo> articulos){
        boolean msg = false;
        
        for (Articulo articulo : articulos){
            Articulo articulo1 = new Articulo();
            int cantidadNueva=0;
            
            articulo1 = adao.buscarArticulo(articulo.getArticulo_id());
            
            int cantidadComprada = articulo.getCantidad();
            
            if(articulo1.getCantidad() > cantidadComprada){
                
                cantidadNueva = articulo1.getCantidad() - cantidadComprada;
            
                articulo1.setCantidad(cantidadNueva);
            
                adao.actualizarArticulo(articulo1);
                
                msg = true;
            }else{
                msg = false;
            }       
        }
        return msg;
    }
    
    public String modificarFactura(Cliente cliente, List<Factuta_Articulo> articulos, Factura factura) {
        
        String msg = "";
        if(articulos.isEmpty() || cliente==null){
            msg = "Ingrese todos los valores necesarios para crear la factura";
        }else{
            
        int subtotal=0;
        for(Factuta_Articulo art : articulos){
            subtotal += art.getCantidadArticulo()*art.getPrecioArticulo();
        }
        
        int iva = (subtotal * 19) / 100;
        int total = iva + subtotal;

        factura.setSubtotal(subtotal);
        factura.setIva(iva);
        factura.setTotal(total);
        factura.setCliente(cliente);
            
            msg = facturaDAO.modificarFactura(articulos, factura);
            
        }
        
    return msg;
    }
}
