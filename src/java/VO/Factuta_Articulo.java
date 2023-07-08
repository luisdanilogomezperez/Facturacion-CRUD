/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author dan
 */
public class Factuta_Articulo {
    
    
    private int id_factura_articulo;
    private Factura factura;
    private Articulo articulo;
    private String nombreArticulo;
    private int cantidadArticulo;
    private int precioArticulo;

    public Factuta_Articulo() {
    }

    public Factuta_Articulo(Factura factura, Articulo articulo, String nombreArticulo, int cantidadArticulo, int precioArticulo) {
        this.factura = factura;
        this.articulo = articulo;
        this.nombreArticulo = nombreArticulo;
        this.cantidadArticulo = cantidadArticulo;
        this.precioArticulo = precioArticulo;
    }

    public int getId_factura_articulo() {
        return id_factura_articulo;
    }

    public void setId_factura_articulo(int id_factura_articulo) {
        this.id_factura_articulo = id_factura_articulo;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public int getCantidadArticulo() {
        return cantidadArticulo;
    }

    public void setCantidadArticulo(int cantidadArticulo) {
        this.cantidadArticulo = cantidadArticulo;
    }

    public int getPrecioArticulo() {
        return precioArticulo;
    }

    public void setPrecioArticulo(int precioArticulo) {
        this.precioArticulo = precioArticulo;
    }
}
