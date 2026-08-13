/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gimasio.ozari;

import pkg_controlador.gimasioControl;
import pkg_vista.vistaCliente;
import pkg_vista.vistaEntrenador;
import pkg_vista.vistaPago;

public class Main {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {

            vistaCliente cliente = new vistaCliente();

            vistaEntrenador entrenador =
                    new vistaEntrenador();

            vistaPago pago =
                    new vistaPago();

            gimasioControl controlador =
                    new gimasioControl(
                            cliente,
                            entrenador,
                            pago
                    );

            cliente.setLocation(50, 100);
            entrenador.setLocation(500, 100);
            pago.setLocation(950, 100);

            cliente.setVisible(true);
            entrenador.setVisible(true);
            pago.setVisible(true);
        });
    }
}