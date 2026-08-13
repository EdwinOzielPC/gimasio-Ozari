/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg_controlador;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import pkg_modelo.Cliente;
import pkg_modelo.ClienteDAO;
import pkg_modelo.Entrenador;
import pkg_modelo.EntrenadorDAO;
import pkg_modelo.Pago;
import pkg_modelo.PagoDao;
import pkg_modelo.ReglaNegocioException;

import pkg_vista.vistaCliente;
import pkg_vista.vistaEntrenador;
import pkg_vista.vistaPago;


public class gimasioControl {
   private ClienteDAO clienteDAO;
    private EntrenadorDAO entrenadorDAO;
    private PagoDao pagoDao;

    private vistaCliente vistaCliente;
    private vistaEntrenador vistaEntrenador;
    private vistaPago vistaPago;


    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    public gimasioControl(
            vistaCliente vistaCliente,
            vistaEntrenador vistaEntrenador,
            vistaPago vistaPago) {

        this.vistaCliente = vistaCliente;
        this.vistaEntrenador = vistaEntrenador;
        this.vistaPago = vistaPago;

        clienteDAO = new ClienteDAO();
        entrenadorDAO = new EntrenadorDAO();
        pagoDao = new PagoDao();

        agregarListeners();

        cargarClientes();
        cargarEntrenadores();
        cargarPagos();
    }


    // =====================================================
    // LISTENERS
    // =====================================================

    private void agregarListeners() {

        // CLIENTES

        vistaCliente.getBtnRegistrar()
                .addActionListener(e -> registrarCliente());

        vistaCliente.getBtnConsultar()
                .addActionListener(e -> consultarClientes());

        vistaCliente.getBtnActualizar()
                .addActionListener(e -> actualizarCliente());

        vistaCliente.getBtnEliminar()
                .addActionListener(e -> eliminarCliente());


        // ENTRENADORES

        vistaEntrenador.getBtnRegistrarEntrenador()
                .addActionListener(e -> registrarEntrenador());

        vistaEntrenador.getBtnConsultarEntrenador()
                .addActionListener(e -> consultarEntrenadores());

        vistaEntrenador.getBtnActualizarEntrenador()
                .addActionListener(e -> actualizarEntrenador());

        vistaEntrenador.getBtnEliminarEntrenador()
                .addActionListener(e -> eliminarEntrenador());


        // PAGOS

        vistaPago.getBtnRegistrarPago()
                .addActionListener(e -> registrarPago());

        vistaPago.getBtnConsultarPago()
                .addActionListener(e -> consultarPagos());

        vistaPago.getBtnActualizarPago()
                .addActionListener(e -> actualizarPago());

        vistaPago.getBtnEliminarPago()
                .addActionListener(e -> eliminarPago());
    }


    // =====================================================
    // CLIENTES
    // =====================================================

    private void registrarCliente() {

        try {

            int id = Integer.parseInt(
                    vistaCliente.getTxtIdCliente().getText()
            );

            String nombre =
                    vistaCliente.getTxtNombre().getText();

            String apellido =
                    vistaCliente.getTxtApellido().getText();

            String telefono =
                    vistaCliente.getTxtTelefono().getText();

            String fechaIngreso =
                    vistaCliente.getTxtFechaIngreso().getText();

            int idPlan = Integer.parseInt(
                    vistaCliente.getTxtIdPlan().getText()
            );

            int idEntrenador = Integer.parseInt(
                    vistaCliente.getTxtIdEntrenador().getText()
            );


            Cliente cliente = new Cliente(
                    id,
                    nombre,
                    apellido,
                    telefono,
                    fechaIngreso,
                    idPlan,
                    idEntrenador
            );


            clienteDAO.insertar(cliente);


            JOptionPane.showMessageDialog(
                    vistaCliente,
                    "Cliente registrado correctamente."
            );

            cargarClientes();


        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    vistaCliente,
                    "Los campos ID, PLAN y ENTRENADOR deben ser números."
            );

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    vistaCliente,
                    "Error de base de datos:\n"
                    + e.getMessage()
            );
        }
    }

    private void consultarClientes() {

        cargarClientes();
    }

    private void cargarClientes() {

        try {

            List<Cliente> lista =
                    clienteDAO.consultar();


            DefaultTableModel modelo =
                    (DefaultTableModel)
                    vistaCliente.getTblCliente().getModel();


            modelo.setRowCount(0);


            for (Cliente cliente : lista) {

                modelo.addRow(new Object[]{
                    cliente.getIdCliente(),
                    cliente.getNombre(),
                    cliente.getApellido(),
                    cliente.getTelefono(),
                    cliente.getIdPlan(),
                    cliente.getIdEntrenador()
                });
            }


        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    vistaCliente,
                    "Error al consultar clientes:\n"
                    + e.getMessage()
            );
        }
    }


    private void actualizarCliente() {

        try {

            int id = Integer.parseInt(
                    vistaCliente.getTxtIdCliente().getText()
            );

            String nombre =
                    vistaCliente.getTxtNombre().getText();

            String apellido =
                    vistaCliente.getTxtApellido().getText();

            String telefono =
                    vistaCliente.getTxtTelefono().getText();

            String fechaIngreso =
                    vistaCliente.getTxtFechaIngreso().getText();

            int idPlan = Integer.parseInt(
                    vistaCliente.getTxtIdPlan().getText()
            );

            int idEntrenador = Integer.parseInt(
                    vistaCliente.getTxtIdEntrenador().getText()
            );


            Cliente cliente = new Cliente(
                    id,
                    nombre,
                    apellido,
                    telefono,
                    fechaIngreso,
                    idPlan,
                    idEntrenador
            );


            clienteDAO.actualizar(cliente);


            JOptionPane.showMessageDialog(
                    vistaCliente,
                    "Cliente actualizado correctamente."
            );

            cargarClientes();


        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    vistaCliente,
                    "Los campos ID, PLAN y ENTRENADOR deben ser números."
            );

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    vistaCliente,
                    "Error al actualizar:\n"
                    + e.getMessage()
            );
        }
    }

    private void eliminarCliente() {

        try {

            int id = Integer.parseInt(
                    vistaCliente.getTxtIdCliente().getText()
            );


            int respuesta =
                    JOptionPane.showConfirmDialog(
                            vistaCliente,
                            "¿Seguro que deseas eliminar este cliente?",
                            "Confirmar eliminación",
                            JOptionPane.YES_NO_OPTION
                    );


            if (respuesta ==
                    JOptionPane.YES_OPTION) {

                clienteDAO.eliminar(id);


                JOptionPane.showMessageDialog(
                        vistaCliente,
                        "Cliente eliminado correctamente."
                );


                cargarClientes();
            }


        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    vistaCliente,
                    "Ingresa un ID válido."
            );

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    vistaCliente,
                    "Error al eliminar:\n"
                    + e.getMessage()
            );
        }
    }


    // =====================================================
    // ENTRENADORES
    // =====================================================

    private void registrarEntrenador() {

        try {

            int id = Integer.parseInt(
                    vistaEntrenador
                            .getTxtIdEntrenador()
                            .getText()
            );


            String nombre =
                    vistaEntrenador
                            .getTxtNombreEntrenador()
                            .getText();


            String especialidad =
                    vistaEntrenador
                            .getTxtEspecialidadEntrenador()
                            .getText();


            String telefono =
                    vistaEntrenador
                            .getTxtTelefonoEntrenador()
                            .getText();


            Entrenador entrenador =
                    new Entrenador(
                            id,
                            nombre,
                            especialidad,
                            telefono
                    );


            entrenadorDAO.insertar(entrenador);


            JOptionPane.showMessageDialog(
                    vistaEntrenador,
                    "Entrenador registrado correctamente."
            );


            cargarEntrenadores();


        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    vistaEntrenador,
                    "El ID debe ser un número."
            );

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    vistaEntrenador,
                    "Error de base de datos:\n"
                    + e.getMessage()
            );
        }
    }

    private void consultarEntrenadores() {

        cargarEntrenadores();
    }

    private void cargarEntrenadores() {

        try {

            List<Entrenador> lista =
                    entrenadorDAO.consultar();


            DefaultTableModel modelo =
                    (DefaultTableModel)
                    vistaEntrenador
                            .getTblEntrenador()
                            .getModel();


            modelo.setRowCount(0);


            for (Entrenador entrenador : lista) {

                modelo.addRow(new Object[]{
                    entrenador.getIdEntrenador(),
                    entrenador.getNombre(),
                    entrenador.getEspecialidad(),
                    entrenador.getTelefono()
                });
            }


        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    vistaEntrenador,
                    "Error al consultar entrenadores:\n"
                    + e.getMessage()
            );
        }
    }


    private void actualizarEntrenador() {

        try {

            int id = Integer.parseInt(
                    vistaEntrenador
                            .getTxtIdEntrenador()
                            .getText()
            );


            String nombre =
                    vistaEntrenador
                            .getTxtNombreEntrenador()
                            .getText();


            String especialidad =
                    vistaEntrenador
                            .getTxtEspecialidadEntrenador()
                            .getText();


            String telefono =
                    vistaEntrenador
                            .getTxtTelefonoEntrenador()
                            .getText();


            Entrenador entrenador =
                    new Entrenador(
                            id,
                            nombre,
                            especialidad,
                            telefono
                    );


            entrenadorDAO.actualizar(entrenador);


            JOptionPane.showMessageDialog(
                    vistaEntrenador,
                    "Entrenador actualizado correctamente."
            );


            cargarEntrenadores();


        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    vistaEntrenador,
                    "El ID debe ser un número."
            );

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    vistaEntrenador,
                    "Error al actualizar:\n"
                    + e.getMessage()
            );
        }
    }

    private void eliminarEntrenador() {

        try {

            int id = Integer.parseInt(
                    vistaEntrenador
                            .getTxtIdEntrenador()
                            .getText()
            );


            int respuesta =
                    JOptionPane.showConfirmDialog(
                            vistaEntrenador,
                            "¿Seguro que deseas eliminar este entrenador?",
                            "Confirmar eliminación",
                            JOptionPane.YES_NO_OPTION
                    );


            if (respuesta ==
                    JOptionPane.YES_OPTION) {

                entrenadorDAO.eliminar(id);


                JOptionPane.showMessageDialog(
                        vistaEntrenador,
                        "Entrenador eliminado correctamente."
                );


                cargarEntrenadores();
            }


        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    vistaEntrenador,
                    "Ingresa un ID válido."
            );

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    vistaEntrenador,
                    "Error al eliminar:\n"
                    + e.getMessage()
            );
        }
    }


    // =====================================================
    // PAGOS
    // =====================================================

    private void registrarPago() {

        try {

            int idPago = Integer.parseInt(
                    vistaPago
                            .getTxtIdPago()
                            .getText()
            );


            String fechaPago =
                    vistaPago
                            .getTxtFechaPago()
                            .getText();


            double monto = Double.parseDouble(
                    vistaPago
                            .getTxtMontoPago()
                            .getText()
            );


            String metodoPago =
                    vistaPago
                            .getTxtMetodoPago()
                            .getText();


            int idCliente = Integer.parseInt(
                    vistaPago
                            .getTxtIdClientePago()
                            .getText()
            );


            Pago pago =
                    new Pago(
                            idPago,
                            fechaPago,
                            monto,
                            metodoPago,
                            idCliente
                    );


            // REGLA DE NEGOCIO
            if (pago.getMonto() <= 0) {

                throw new ReglaNegocioException(
                        "El monto del pago debe ser mayor a $0."
                );
            }


            pagoDao.insertar(pago);


            JOptionPane.showMessageDialog(
                    vistaPago,
                    "Pago registrado correctamente."
            );


            cargarPagos();


        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    vistaPago,
                    "ID, monto e ID de cliente deben ser números."
            );

        } catch (ReglaNegocioException e) {

            JOptionPane.showMessageDialog(
                    vistaPago,
                    e.getMessage()
            );

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    vistaPago,
                    "Error de base de datos:\n"
                    + e.getMessage()
            );
        }
    }

    private void consultarPagos() {

        cargarPagos();
    }

    private void cargarPagos() {

        try {

            List<Pago> lista =
                    pagoDao.consultar();


            DefaultTableModel modelo =
                    (DefaultTableModel)
                    vistaPago
                            .getTblPago()
                            .getModel();


            modelo.setRowCount(0);


            for (Pago pago : lista) {

                modelo.addRow(new Object[]{
                    pago.getIdPago(),
                    pago.getFechaPago(),
                    pago.getMonto(),
                    pago.getMetodoPago(),
                    pago.getIdCliente()
                });
            }


        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    vistaPago,
                    "Error al consultar pagos:\n"
                    + e.getMessage()
            );
        }
    }


    private void actualizarPago() {

        try {

            int idPago = Integer.parseInt(
                    vistaPago
                            .getTxtIdPago()
                            .getText()
            );


            String fechaPago =
                    vistaPago
                            .getTxtFechaPago()
                            .getText();


            double monto = Double.parseDouble(
                    vistaPago
                            .getTxtMontoPago()
                            .getText()
            );


            String metodoPago =
                    vistaPago
                            .getTxtMetodoPago()
                            .getText();


            int idCliente = Integer.parseInt(
                    vistaPago
                            .getTxtIdClientePago()
                            .getText()
            );


            Pago pago =
                    new Pago(
                            idPago,
                            fechaPago,
                            monto,
                            metodoPago,
                            idCliente
                    );


            // REGLA DE NEGOCIO
            if (pago.getMonto() <= 0) {

                throw new ReglaNegocioException(
                        "El monto del pago debe ser mayor a $0."
                );
            }


            pagoDao.actualizar(pago);


            JOptionPane.showMessageDialog(
                    vistaPago,
                    "Pago actualizado correctamente."
            );


            cargarPagos();


        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    vistaPago,
                    "ID, monto e ID de cliente deben ser números."
            );

        } catch (ReglaNegocioException e) {

            JOptionPane.showMessageDialog(
                    vistaPago,
                    e.getMessage()
            );

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    vistaPago,
                    "Error al actualizar:\n"
                    + e.getMessage()
            );
        }
    }


    private void eliminarPago() {

        try {

            int idPago = Integer.parseInt(
                    vistaPago
                            .getTxtIdPago()
                            .getText()
            );


            int respuesta =
                    JOptionPane.showConfirmDialog(
                            vistaPago,
                            "¿Seguro que deseas eliminar este pago?",
                            "Confirmar eliminación",
                            JOptionPane.YES_NO_OPTION
                    );


            if (respuesta ==
                    JOptionPane.YES_OPTION) {

                pagoDao.eliminar(idPago);


                JOptionPane.showMessageDialog(
                        vistaPago,
                        "Pago eliminado correctamente."
                );


                cargarPagos();
            }


        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    vistaPago,
                    "Ingresa un ID válido."
            );

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    vistaPago,
                    "Error al eliminar:\n"
                    + e.getMessage()
            );
        }
    }
}