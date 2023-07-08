/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.Cliente;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dan
 */
public class ClienteDAO {

    Conexion cone = new Conexion();

    PreparedStatement ps = null;
    ResultSet rs = null;

    public ClienteDAO() {
    }

    public String registrarCliente(Cliente cliente) {
        String msg;
        try {
            ps = cone.Conexion().prepareStatement("INSERT INTO cliente(Cedula, Nombre, Apellido, Telefono) VALUES (?,?,?,?)");
            ps.setString(1, cliente.getDocumento());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setString(4, cliente.getTelefono());
            ps.executeUpdate();

            return msg = "Cliente Registrado exitosamente";
        } catch (SQLException e) {
            msg = "Error ";
            return msg + e;
        } finally {
            cone.Desconectar();
        }
    }

    public String actualizarCliente(Cliente cliente) {
        String msg = "";
        try {
            ps = cone.Conexion().prepareStatement("UPDATE cliente SET Cedula=?, Nombre=?, Apellido=?, Telefono=? WHERE Cedula=?");
            ps.setString(1, cliente.getDocumento());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getDocumento());
            ps.executeUpdate();

            return msg = "Cliente actulizado exitosamente";
        } catch (SQLException e) {
            msg = "Error ";
            return msg + e;
        } finally {
            cone.Desconectar();
        }
    }

    public List<Cliente> listarClientes() {
        List clientes = new ArrayList();

        try {
            ps = cone.Conexion().prepareStatement("SELECT * FROM cliente");
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setDocumento(rs.getString(1));
                cliente.setNombre(rs.getString(2));
                cliente.setApellido(rs.getString(3));
                cliente.setTelefono(rs.getString(4));

                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
        return clientes;
    }

    public Cliente buscarCliente(String documento) {
        Cliente cliente = new Cliente();
        try {
            ps = cone.Conexion().prepareStatement("SELECT Cedula, Nombre, Apellido, Telefono FROM cliente WHERE Cedula=?");
            ps.setString(1, documento);
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente.setDocumento(rs.getString(1));
                cliente.setNombre(rs.getString(2));
                cliente.setApellido(rs.getString(3));
                cliente.setTelefono(rs.getString(4));
            }
        } catch (SQLException e) {

        } finally {
            cone.Desconectar();
        }
        return cliente;
    }

    public boolean existeCliente(String documento) {
        Cliente cliente = new Cliente();
        boolean existe = false;
        try {
            ps = cone.Conexion().prepareStatement("SELECT Cedula, Nombre, Apellido, Telefono FROM cliente WHERE Cedula=?");
            ps.setString(1, documento);
            rs = ps.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        } catch (SQLException e) {

        } finally {
            cone.Desconectar();
        }
        return existe;
    }

    public void eliminarCliente(String documento) {
        try {
            ps = cone.Conexion().prepareStatement("DELETE FROM cliente WHERE Cedula=?");
            ps.setString(1, documento);
            ps.execute();
        } catch (SQLException e) {

        } finally {
            cone.Desconectar();
        }
    }
}
