/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg_modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CC_Laboratorio
 */


public class ClienteDAO {

    public void insertar(Cliente cliente) throws SQLException {

        String sql = "INSERT INTO Cliente "
                + "(id_cliente, nombre, apellido, telefono, fecha_ingreso, id_plan, id_entrenador) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cliente.getId());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getFechaIngreso());
            ps.setInt(6, cliente.getIdPlan());
            ps.setInt(7, cliente.getIdEntrenador());

            ps.executeUpdate();
        }
    }

    public List<Cliente> consultar() throws SQLException {

        List<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM Cliente";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Cliente cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("telefono"),
                        rs.getString("fecha_ingreso"),
                        rs.getInt("id_plan"),
                        rs.getInt("id_entrenador")
                );

                lista.add(cliente);
            }
        }

        return lista;
    }

    public void actualizar(Cliente cliente) throws SQLException {

        String sql = "UPDATE Cliente SET "
                + "nombre=?, apellido=?, telefono=?, "
                + "fecha_ingreso=?, id_plan=?, id_entrenador=? "
                + "WHERE id_cliente=?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getFechaIngreso());
            ps.setInt(5, cliente.getIdPlan());
            ps.setInt(6, cliente.getIdEntrenador());
            ps.setInt(7, cliente.getId());

            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {

        String sql = "DELETE FROM Cliente WHERE id_cliente=?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();
        }
    }
}