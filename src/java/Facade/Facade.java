/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

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
public class Facade {

    Factura factura = new Factura();

    Articulo a = new Articulo();

    Cliente cliente = new Cliente();

    Factuta_Articulo factuta_Articulo = new Factuta_Articulo();

    Mediador_Factura mediador_Factura = new Mediador_Factura();

    public Facade() {
    }

    /**
     * Metodo para buscar facturas
     *
     * @param factura_id
     * @return
     */
    public Factura buscarFactura(int factura_id) {
        Factura factura;

        factura = mediador_Factura.buscarFactura(factura_id);

        return factura;
    }

    /**
     * Metodo para listar articulos
     *
     * @param factura_id
     * @return
     */
    public List<Factuta_Articulo> listarArticulosXFactura(int factura_id) {
        List<Factuta_Articulo> articulos = new ArrayList<>();

        articulos = mediador_Factura.buscarArticuloPosFactura(factura_id);

        return articulos;
    }

    /**
     * Metodo que llama a ClienteDAO para registrar un cliente
     *
     * @param cli
     * @return
     */
    public String registrarCLiente(Cliente cli) {
        String msg;
        boolean existe = mediador_Factura.existeCliente(cli.getDocumento());

        if (existe) {
            msg = "Ya existe un cliente registrado con esete mismo numero de documento";
        } else {
            msg = mediador_Factura.registrarCLiente(cli);
        }
        return msg;
    }

    /**
     * Metodo que llama a ClienteDAO para listar todos clientes
     *
     * @return
     */
    public List<Cliente> listarClientes() {

        List<Cliente> clientes;

        clientes = mediador_Factura.listarClientes();

        return clientes;
    }

    /**
     * Metodo para registrar Facturas
     *
     * @param cliente
     * @param articulos
     * @return
     */
    public String registrarFactura(Cliente cliente, List<Articulo> articulos) {
        String msg = "";
        Factura factura = new Factura();
        if (articulos.isEmpty() || cliente == null) {
            msg = "Ingrese todos los valores necesarios para crear la factura";
        } else {

            msg = mediador_Factura.registrarFactura(cliente, articulos);

        }

        return msg;
    }

    public List<Factura> listarFacturas() {

        List<Factura> facturas = new ArrayList<>();

        facturas = mediador_Factura.listarFacturas();

        return facturas;

    }

    public List<Articulo> listarArticulos() {
        List<Articulo> articulos = new ArrayList<>();

        articulos = mediador_Factura.listarArticulos();

        return articulos;
    }

    public Articulo buscarArticulo(int articulo_id) {
        Articulo articulo = new Articulo();

        articulo = mediador_Factura.buscarArticulo(articulo_id);

        return articulo;
    }

    public List<Factuta_Articulo> buscarArticuloPosFactura(int factura_id) {
        List<Factuta_Articulo> articulos = new ArrayList<>();

        articulos = mediador_Factura.listarArticulosXFactura(factura_id);

        return articulos;
    }

    public Cliente buscarCliente(String clietnte_id) {
        Cliente cliente = new Cliente();

        cliente = mediador_Factura.buscarCliente(clietnte_id);

        return cliente;
    }

    public void eliminarFactura(int factura_id) {
        mediador_Factura.eliminarFactura(factura_id);
    }

    public boolean actualizarProductos(List<Articulo> articulos) {

        boolean msg = mediador_Factura.actualizarProductos(articulos);

        return msg;
    }

    public String modificarFactura(Cliente cliente, List<Factuta_Articulo> articulos, Factura factura) {

        String msg = "";

        msg = mediador_Factura.modificarFactura(cliente, articulos, factura);

        return msg;
    }
    
    public void eliminarCliente(String documento){
        mediador_Factura.eliminarCliente(documento);
    }
}
