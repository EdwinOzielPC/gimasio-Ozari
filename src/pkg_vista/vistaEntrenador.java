/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pkg_vista;

public class vistaEntrenador extends javax.swing.JFrame {

    public vistaEntrenador() {
        initComponents();
    }

    // GETTERS
    public javax.swing.JTextField getTxtIdEntrenador() {
        return txtIdEntrenador;
    }

    public javax.swing.JTextField getTxtNombreEntrenador() {
        return txtNombreEntrenador;
    }

    public javax.swing.JTextField getTxtEspecialidadEntrenador() {
        return txtEspecialidadEntrenador;
    }

    public javax.swing.JTextField getTxtTelefonoEntrenador() {
        return txtTelefonoEntrenador;
    }

    public javax.swing.JButton getBtnRegistrarEntrenador() {
        return btnRegistrarEntrenador;
    }

    public javax.swing.JButton getBtnConsultarEntrenador() {
        return btnConsultarEntrenador;
    }

    public javax.swing.JButton getBtnActualizarEntrenador() {
        return btnActualizarEntrenador;
    }

    public javax.swing.JButton getBtnEliminarEntrenador() {
        return btnEliminarEntrenador;
    }

    public javax.swing.JTable getTblEntrenador() {
        return tblEntrenador;
    }

    // AQUÍ VA TU ÚNICO initComponents()
    @SuppressWarnings("unchecked")
     
        // TODO EL CÓDIGO DE DISEÑO QUE YA TENÍAS
        // NO LO CAMBIES
    

   


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblIdEntrenador = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblEspecialidad = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtIdEntrenador = new javax.swing.JTextField();
        txtNombreEntrenador = new javax.swing.JTextField();
        txtEspecialidadEntrenador = new javax.swing.JTextField();
        txtTelefonoEntrenador = new javax.swing.JTextField();
        btnRegistrarEntrenador = new javax.swing.JButton();
        btnConsultarEntrenador = new javax.swing.JButton();
        btnActualizarEntrenador = new javax.swing.JButton();
        btnEliminarEntrenador = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEntrenador = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("REGISTRO ENTRENADORES");

        lblIdEntrenador.setText("Id Entrenador:");

        lblNombre.setText("Nombre:");

        lblEspecialidad.setText("Especialidad:");

        lblTelefono.setText("Telefono:");

        btnRegistrarEntrenador.setText("REGISTRAR");

        btnConsultarEntrenador.setText("CONSULTAR");

        btnActualizarEntrenador.setText("ACTUALIZAR");

        btnEliminarEntrenador.setText("ELIMINAR");

        tblEntrenador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "ESPECIALIDAD", "TELEFONO"
            }
        ));
        jScrollPane1.setViewportView(tblEntrenador);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombre)
                            .addComponent(lblIdEntrenador)
                            .addComponent(lblEspecialidad)
                            .addComponent(lblTelefono))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdEntrenador, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(txtNombreEntrenador)
                            .addComponent(txtEspecialidadEntrenador)
                            .addComponent(txtTelefonoEntrenador))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistrarEntrenador)
                            .addComponent(btnActualizarEntrenador))
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminarEntrenador)
                            .addComponent(btnConsultarEntrenador))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 103, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdEntrenador)
                    .addComponent(txtIdEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarEntrenador)
                    .addComponent(btnConsultarEntrenador))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombreEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEspecialidad)
                            .addComponent(txtEspecialidadEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefono)
                            .addComponent(txtTelefonoEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActualizarEntrenador)
                            .addComponent(btnEliminarEntrenador))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizarEntrenador;
    public javax.swing.JButton btnConsultarEntrenador;
    public javax.swing.JButton btnEliminarEntrenador;
    public javax.swing.JButton btnRegistrarEntrenador;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblEspecialidad;
    public javax.swing.JLabel lblIdEntrenador;
    public javax.swing.JLabel lblNombre;
    public javax.swing.JLabel lblTelefono;
    public javax.swing.JTable tblEntrenador;
    public javax.swing.JTextField txtEspecialidadEntrenador;
    public javax.swing.JTextField txtIdEntrenador;
    public javax.swing.JTextField txtNombreEntrenador;
    public javax.swing.JTextField txtTelefonoEntrenador;
    // End of variables declaration//GEN-END:variables

}