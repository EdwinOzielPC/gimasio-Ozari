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
public class EntrenadorDAO {


    public void insertar(Entrenador entrenador) throws SQLException {

        String sql = "INSERT INTO Entrenador "
                + "(id_entrenador, nombre, especialidad, telefono) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, entrenador.getId());
            ps.setString(2, entrenador.getNombre());
            ps.setString(3, entrenador.getEspecialidad());
            ps.setString(4, entrenador.getTelefono());

            ps.executeUpdate();
        }
    }

    public List<Entrenador> consultar() throws SQLException {

        List<Entrenador> lista = new ArrayList<>();

        String sql = "SELECT * FROM Entrenador";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Entrenador entrenador = new Entrenador(
                        rs.getInt("id_entrenador"),
                        rs.getString("nombre"),
                        rs.getString("especialidad"),
                        rs.getString("telefono")
                );

                lista.add(entrenador);
            }
        }

        return lista;
    }

    public void actualizar(Entrenador entrenador) throws SQLException {

        String sql = "UPDATE Entrenador SET "
                + "nombre=?, especialidad=?, telefono=? "
                + "WHERE id_entrenador=?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, entrenador.getNombre());
            ps.setString(2, entrenador.getEspecialidad());
            ps.setString(3, entrenador.getTelefono());
            ps.setInt(4, entrenador.getId());

            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {

        String sql = "DELETE FROM Entrenador "
                + "WHERE id_entrenador=?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();
        }
    }
}


