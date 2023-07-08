package DAO;

import VO.*;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dan
 */
public class FacturaDAO {

    Conexion cone = new Conexion();
    Connection con = cone.Conexion();

    PreparedStatement ps = null;
    ResultSet rs = null;

    public FacturaDAO() {
    }

    /**
     * Metodo para crear Facturas
     * recibe un cliente, un listado de articulos, una factura y retorna un mensaje de exito o error
     * @param cliente 
     * @param articulos 
     * @param factura 
     * @return  
     */
    public String crearFactura(Cliente cliente, List<Articulo> articulos, Factura factura) {
        String msg = null;
        Date fechaActual = new Date();
        try {
            ps = cone.Conexion().prepareStatement("INSERT INTO factura (Fecha, Cliente_Cliente, subtotal, IVA, Total) VALUES (?, ?, ?, ?, ?)");
            ps.setDate(1, new java.sql.Date(fechaActual.getTime()));
            ps.setString(2, cliente.getDocumento());
            ps.setInt(3, factura.getSubtotal());
            ps.setInt(4, factura.getIva());
            ps.setInt(5, factura.getTotal());
            ps.executeUpdate();

            // Obtener el ID de la factura recién guardada
            ps = cone.Conexion().prepareStatement("SELECT MAX(Id_factura) FROM factura");
            rs = ps.executeQuery();
            int facturaId;
            if (rs.next()) {
                facturaId = rs.getInt(1);
            } else {
                throw new SQLException("No se pudo obtener el ID de la factura");
            }

            for (Articulo articulo : articulos) {
                ps = cone.Conexion().prepareStatement("INSERT INTO factura_articulo (articulo_id, factura_id, nombre, cantidad, precio) VALUES (?, ?, ?, ?, ?)");
                ps.setInt(1, articulo.getArticulo_id());
                ps.setInt(2, facturaId);
                ps.setString(3, articulo.getNombre());
                ps.setInt(4, articulo.getCantidad());
                ps.setInt(5, articulo.getPrecio());
                ps.executeUpdate();
            }

            msg = "Factura creada con exito";
            return msg;
        } catch (SQLException e) {
            msg = "Error " + e;
            return msg;
        }

    }

    /**
     * Metodo para modificar Facturas
     * recibe un cliente, un listado de articulos, una factura y retorna un mensaje de exito o error
     * @param cliente 
     * @param articulos 
     * @param factura 
     * @return  
     */
    public String modificarFactura(List<Factuta_Articulo> articulos, Factura factura) {
        String msg = null;
        Date fechaActual = new Date();
        try {
            //Este código actualiza la informacion de la Factura
            ps = cone.Conexion().prepareStatement("UPDATE factura SET Fecha=?, Cliente_Cliente=?, subtotal=?, IVA=?, Total=? WHERE Id_factura=?");
            ps.setDate(1, new java.sql.Date(fechaActual.getTime()));
            ps.setString(2, factura.getCliente().getDocumento());
            ps.setInt(3, factura.getSubtotal());
            ps.setInt(4, factura.getIva());
            ps.setInt(5, factura.getTotal());
            ps.setInt(6, factura.getFactura_id());
            ps.executeUpdate();

            //Este código actualiza la informacion de la los articulos relacionados a dicha factura
            for (Factuta_Articulo articulo : articulos) {
                ps = cone.Conexion().prepareStatement("UPDATE factura_articulo SET  nombre=?, cantidad=?, precio=? WHERE factura_id=?");
                ps.setString(1, articulo.getNombreArticulo());
                ps.setInt(2, articulo.getCantidadArticulo());
                ps.setInt(3, articulo.getPrecioArticulo());
                ps.setInt(4, factura.getFactura_id());
                ps.executeUpdate();
            }

            msg = "Factura modificada con exito";
            return msg;
        } catch (SQLException e) {
            msg = "Error " + e;
            return msg;
        }
    }

    /** metodo para buscar una factura por el ID
     * 
     * @param factura_id
     * @return 
     */
    public Factura buscarFactura(int factura_id) {
        Factura factura = new Factura();
        Cliente cliente;
        ClienteDAO cdao = new ClienteDAO();
        try {
            // Este código me trae la información de la factura
            ps = cone.Conexion().prepareStatement("SELECT Id_factura, Fecha, Cliente_Cliente, subtotal, IVA, total FROM factura WHERE Id_factura=?");
            ps.setInt(1, factura_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                factura.setFactura_id(rs.getInt(1));
                factura.setFecha(rs.getDate(2));
                cliente = cdao.buscarCliente(rs.getString(3));
                factura.setCliente(cliente);
                factura.setSubtotal(rs.getInt(4));
                factura.setIva(rs.getInt(5));
                factura.setTotal(rs.getInt(6));
            }
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
        return factura;
    }
    
    /**
     * Este metodo ma trae todo el listado de artículos relacionados a una factura
     * @param factura_id
     * @return 
     */
    public List<Factuta_Articulo> listarArticulosPorFactura(int factura_id) {
        List articulosXFactura = new ArrayList();
        ArticuloDAO adao = new ArticuloDAO();
        Articulo articulo = new Articulo();
        Factura factura = new Factura();
        FacturaDAO facturaDAO = new FacturaDAO();
        try {
            // Este código me trae la informacion de los articulos relacionados a la factura
            ps = cone.Conexion().prepareStatement("SELECT id_factura_articulo, articulo_id, factura_id, nombre, cantidad, precio FROM factura_articulo WHERE factura_id=?");
            ps.setInt(1, factura_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Factuta_Articulo articuloF = new Factuta_Articulo();
                articuloF.setId_factura_articulo(rs.getInt(1));
                articulo = adao.buscarArticulo(rs.getInt(2));
                articuloF.setArticulo(articulo);
                factura = facturaDAO.buscarFactura(rs.getInt(3));
                articuloF.setFactura(factura);
                articuloF.setNombreArticulo(rs.getString(4));
                articuloF.setCantidadArticulo(rs.getInt(5));
                articuloF.setPrecioArticulo(rs.getInt(6));
                articulosXFactura.add(articuloF);
            }
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
        return articulosXFactura;
    }

    public List<Factura> listarFacturas(){
        List<Factura> facturas = new ArrayList<>();
        ClienteDAO cdao = new ClienteDAO();
        Cliente cliente = new Cliente();
        
        try {
            // Este código me trae la información de la factura
            ps = cone.Conexion().prepareStatement("SELECT * FROM factura");
            rs = ps.executeQuery();
            while (rs.next()) {
                Factura factura = new Factura();
                factura.setFactura_id(rs.getInt(1));
                factura.setFecha(rs.getDate(2));
                cliente = cdao.buscarCliente(rs.getString(3));
                factura.setCliente(cliente);
                factura.setSubtotal(rs.getInt(4));
                factura.setIva(rs.getInt(5));
                factura.setTotal(rs.getInt(6));
                
                facturas.add(factura);
            }
        } catch (SQLException e) {
        }
        
        return facturas;
    }
    
    /**
     * Metodo para eliminar facturas
     * @param factura_id 
     */
    public void eliminarFactura(int factura_id) {
        try {
            ps = cone.Conexion().prepareStatement("DELETE FROM factura WHERE Id_factura=?");
            ps.setInt(1, factura_id);
            ps.execute();
        } catch (SQLException e) {

        } finally {
            cone.Desconectar();
        }
    }
    
    
    
}
