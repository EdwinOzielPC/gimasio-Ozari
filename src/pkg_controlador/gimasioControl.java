/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg_controlador;
import java.sql.SQLException;
import java.util.List;

import pkg_modelo.Cliente;
import pkg_modelo.ClienteDAO;
import pkg_modelo.Entrenador;
import pkg_modelo.EntrenadorDAO;
import pkg_modelo.Pago;
import pkg_modelo.PagoDao;
import pkg_modelo.ReglaNegocioException;


public class gimasioControl {



public class GimnasioControl {

    private ClienteDAO clienteDAO;
    private EntrenadorDAO entrenadorDAO;
    private PagoDao pagoDao;

    public GimnasioControl() {

        clienteDAO = new ClienteDAO();
        entrenadorDAO = new EntrenadorDAO();
        pagoDao = new PagoDao();
    }

    // =========================
    // CLIENTES
    // =========================

    public void registrarCliente(Cliente cliente)
            throws SQLException {

        clienteDAO.insertar(cliente);
    }

    public List<Cliente> consultarClientes()
            throws SQLException {

        return clienteDAO.consultar();
    }

    public void actualizarCliente(Cliente cliente)
            throws SQLException {

        clienteDAO.actualizar(cliente);
    }

    public void eliminarCliente(int id)
            throws SQLException {

        clienteDAO.eliminar(id);
    }

    // =========================
    // ENTRENADORES
    // =========================

    public void registrarEntrenador(Entrenador entrenador)
            throws SQLException {

        entrenadorDAO.insertar(entrenador);
    }

    public List<Entrenador> consultarEntrenadores()
            throws SQLException {

        return entrenadorDAO.consultar();
    }

    public void actualizarEntrenador(Entrenador entrenador)
            throws SQLException {

        entrenadorDAO.actualizar(entrenador);
    }

    public void eliminarEntrenador(int id)
            throws SQLException {

        entrenadorDAO.eliminar(id);
    }

    // =========================
    // PAGOS
    // =========================

    public void registrarPago(Pago pago)
            throws SQLException, ReglaNegocioException {

        if (pago.getMonto() <= 0) {

            throw new ReglaNegocioException(
                    "El monto del pago debe ser mayor a $0."
            );
        }

        pagoDao.insertar(pago);
    }

    public List<Pago> consultarPagos()
            throws SQLException {

        return pagoDao.consultar();
    }

    public void actualizarPago(Pago pago)
            throws SQLException, ReglaNegocioException {

        if (pago.getMonto() <= 0) {

            throw new ReglaNegocioException(
                    "El monto del pago debe ser mayor a $0."
            );
        }

        pagoDao.actualizar(pago);
    }

    public void eliminarPago(int id)
            throws SQLException {

        pagoDao.eliminar(id);
    }
}
}