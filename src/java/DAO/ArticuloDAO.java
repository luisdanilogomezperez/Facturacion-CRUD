/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.Articulo;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dan
 */
public class ArticuloDAO {

    Conexion cone = new Conexion();

    PreparedStatement ps = null;
    ResultSet rs = null;

    public String registrarArticulo(Articulo articulo) {
        String msg = null;
        try {
            ps = cone.Conexion().prepareStatement("INSERT INTO articulo(Nombre, Cantidad, Precio) VALUES (?,?,?)");
            ps.setString(1, articulo.getNombre());
            ps.setInt(2, articulo.getCantidad());
            ps.setInt(3, articulo.getPrecio());
            ps.executeUpdate();
            msg = "Artículo Registrado exitosamente";
            return msg;
        } catch (SQLException e) {
            msg = "Error " + e;
            return msg;
        }
    }

    public String actualizarArticulo(Articulo articulo) {
        String msg;
        try {
            ps = cone.Conexion().prepareStatement("UPDATE articulo SET Nombre=?, Cantidad=?, Precio=? WHERE Id_Articulo=?");
            ps.setString(1, articulo.getNombre());
            ps.setInt(2, articulo.getCantidad());
            ps.setInt(3, articulo.getPrecio());
            ps.setInt(4, articulo.getArticulo_id());
            ps.executeUpdate();
            msg = "Artículo actulizado exitosamente";
            return msg;
        } catch (SQLException e) {
            msg = "Error " + e;
            return msg + e;
        }
    }

    public List<Articulo> listarArticulos() {
        List articulos = new ArrayList();

        try {
            ps = cone.Conexion().prepareStatement("SELECT * FROM articulo");
            rs = ps.executeQuery();
            while (rs.next()) {
                Articulo articulo = new Articulo();
                articulo.setArticulo_id(rs.getInt(1));
                articulo.setNombre(rs.getString(2));
                articulo.setCantidad(rs.getInt(3));
                articulo.setPrecio(rs.getInt(4));

                articulos.add(articulo);
            }
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
        return articulos;
    }

    public Articulo buscarArticulo(int articulo_id) {
        Articulo articulo = new Articulo();
        try {
            ps = cone.Conexion().prepareStatement("SELECT Id_Articulo, Nombre, Cantidad, Precio FROM articulo WHERE Id_Articulo=?");
            ps.setInt(1, articulo_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                articulo.setArticulo_id(rs.getInt(1));
                articulo.setNombre(rs.getString(2));
                articulo.setCantidad(rs.getInt(3));
                articulo.setPrecio(rs.getInt(4));
            }
        } catch (SQLException e) {

        } finally {
            cone.Desconectar();
        }
        return articulo;
    }

    public Articulo buscarArticuloByName(String nombre_articulo) {
        Articulo articulo = new Articulo();
        try {
            ps = cone.Conexion().prepareStatement("SELECT Id_Articulo, Nombre, Cantidad, Precio FROM articulo WHERE Nombre=?");
            ps.setString(1, nombre_articulo);
            rs = ps.executeQuery();
            while (rs.next()) {
                articulo.setArticulo_id(rs.getInt(1));
                articulo.setNombre(rs.getString(2));
                articulo.setCantidad(rs.getInt(3));
                articulo.setPrecio(rs.getInt(4));
            }
        } catch (SQLException e) {

        } finally {
            cone.Desconectar();
        }
        return articulo;
    }

    public void eliminarArticulo(int articulo_id) {
        try {
            ps = cone.Conexion().prepareStatement("DELETE FROM articulo WHERE Id_Articulo=?");
            ps.setInt(1, articulo_id);
            ps.execute();
        } catch (SQLException e) {

        } finally {
            cone.Desconectar();
        }
    }

}
