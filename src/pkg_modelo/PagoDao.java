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
public class PagoDao {




    public void insertar(Pago pago) throws SQLException {

        String sql = "INSERT INTO Pago "
                + "(id_pago, fecha_pago, monto, metodo_pago, id_cliente) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, pago.getIdPago());
            ps.setString(2, pago.getFechaPago());
            ps.setDouble(3, pago.getMonto());
            ps.setString(4, pago.getMetodoPago());
            ps.setInt(5, pago.getIdCliente());

            ps.executeUpdate();
        }
    }

    public List<Pago> consultar() throws SQLException {

        List<Pago> lista = new ArrayList<>();

        String sql = "SELECT * FROM Pago";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Pago pago = new Pago(
                        rs.getInt("id_pago"),
                        rs.getString("fecha_pago"),
                        rs.getDouble("monto"),
                        rs.getString("metodo_pago"),
                        rs.getInt("id_cliente")
                );

                lista.add(pago);
            }
        }

        return lista;
    }

    public void actualizar(Pago pago) throws SQLException {

        String sql = "UPDATE Pago SET "
                + "fecha_pago=?, monto=?, metodo_pago=?, "
                + "id_cliente=? WHERE id_pago=?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, pago.getFechaPago());
            ps.setDouble(2, pago.getMonto());
            ps.setString(3, pago.getMetodoPago());
            ps.setInt(4, pago.getIdCliente());
            ps.setInt(5, pago.getIdPago());

            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {

        String sql = "DELETE FROM Pago WHERE id_pago=?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();
        }
    }
}   

