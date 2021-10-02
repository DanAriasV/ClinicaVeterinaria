/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Conexiones.*;
import javax.swing.JOptionPane;

public class Frm_Expedientes extends javax.swing.JFrame {

    /**
     * Creates new form Frm_Expedientes
     */
    public Frm_Expedientes() {
        initComponents();
        llenarTabla();
    }

    private Cls_Expedientes exp = new Cls_Expedientes();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        btnMinimizar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        cb_ordenarPor = new javax.swing.JComboBox<>();
        txt_busqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Expedientes = new javax.swing.JTable();
        btnAbrirExpediente = new javax.swing.JButton();
        btnNuevoExpediente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(112, 244, 129));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Open Sans", 1, 46)); // NOI18N
        jLabel1.setText("Expedientes");

        btnCerrar.setBackground(new java.awt.Color(255, 87, 87));
        btnCerrar.setFont(new java.awt.Font("Open Sans", 0, 11)); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.setToolTipText("Cerrar ventana");
        btnCerrar.setBorderPainted(false);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.setPreferredSize(new java.awt.Dimension(90, 30));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnMinimizar.setBackground(new java.awt.Color(82, 113, 255));
        btnMinimizar.setFont(new java.awt.Font("Open Sans", 0, 11)); // NOI18N
        btnMinimizar.setText("Minimizar");
        btnMinimizar.setToolTipText("Minimizar ventana");
        btnMinimizar.setBorderPainted(false);
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimizar.setPreferredSize(new java.awt.Dimension(90, 30));
        btnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarActionPerformed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(255, 161, 161));
        btnVolver.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.setToolTipText("Volver al menú principal");
        btnVolver.setBorderPainted(false);
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        cb_ordenarPor.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        cb_ordenarPor.setToolTipText("Ordenar la tabla por la opción seleccionada");
        cb_ordenarPor.setPreferredSize(new java.awt.Dimension(230, 32));
        cb_ordenarPor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ordenarPorActionPerformed(evt);
            }
        });

        txt_busqueda.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        txt_busqueda.setToolTipText("Busqueda: nombre cliente, nombre mascota o por identidad");
        txt_busqueda.setMinimumSize(new java.awt.Dimension(32, 700));
        txt_busqueda.setPreferredSize(new java.awt.Dimension(700, 32));
        txt_busqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_busquedaMouseClicked(evt);
            }
        });
        txt_busqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_busquedaKeyTyped(evt);
            }
        });

        table_Expedientes.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        table_Expedientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Expediente", "Cliente", "Identidad", "Mascota", "Tipo de Mascota", "Fecha de Nacimiento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Expedientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_Expedientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table_Expedientes);

        btnAbrirExpediente.setBackground(new java.awt.Color(157, 187, 255));
        btnAbrirExpediente.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        btnAbrirExpediente.setText("Abrir Expediente");
        btnAbrirExpediente.setBorderPainted(false);
        btnAbrirExpediente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAbrirExpediente.setPreferredSize(new java.awt.Dimension(190, 35));
        btnAbrirExpediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirExpedienteActionPerformed(evt);
            }
        });

        btnNuevoExpediente.setBackground(new java.awt.Color(255, 246, 131));
        btnNuevoExpediente.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        btnNuevoExpediente.setText("Nuevo Expediente");
        btnNuevoExpediente.setBorderPainted(false);
        btnNuevoExpediente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoExpediente.setPreferredSize(new java.awt.Dimension(190, 35));
        btnNuevoExpediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoExpedienteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        jLabel2.setText("Ordenar por:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(182, 182, 182)
                .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNuevoExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAbrirExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 948, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(cb_ordenarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(btnVolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_ordenarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrirExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevoExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void llenarTabla() {
        exp.llenarTabla(table_Expedientes);
        
        cb_ordenarPor.addItem("Expediente");
        cb_ordenarPor.addItem("Cliente");
        cb_ordenarPor.addItem("Mascota");
        cb_ordenarPor.addItem("Tipo Animal");
    }

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        Frm_Menu menu = new Frm_Menu(Frm_Login.nivelAcceso);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(this.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Frm_Menu menu = new Frm_Menu(Frm_Login.nivelAcceso);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAbrirExpedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirExpedienteActionPerformed
        if (table_Expedientes.getSelectedRow() != -1) {
            
            int row = table_Expedientes.getSelectedRow();
            exp.setExpediente(Integer.parseInt(table_Expedientes.getModel().getValueAt(row, 0).toString()));
            exp.setCliente(table_Expedientes.getModel().getValueAt(row, 1).toString());
            exp.setIdentidad(table_Expedientes.getModel().getValueAt(row, 2).toString());
            exp.setMascota(table_Expedientes.getModel().getValueAt(row, 3).toString());
            exp.setTipoMascota(table_Expedientes.getModel().getValueAt(row, 4).toString());
            
            Frm_AbrirExpediente expediente = new Frm_AbrirExpediente();
            expediente.setVisible(true);
            this.dispose();
            
        }else{
            JOptionPane.showMessageDialog(null, "No se seleccionó ningún expediente", "Error!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAbrirExpedienteActionPerformed

    private void btnNuevoExpedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoExpedienteActionPerformed
        Frm_NuevoExpediente nuevo = new Frm_NuevoExpediente();
        nuevo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNuevoExpedienteActionPerformed

    private void txt_busquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busquedaKeyTyped
        if(!txt_busqueda.getText().isBlank()){
            exp.filtrarDatos(table_Expedientes, txt_busqueda.getText());
        }else{
            exp.llenarTabla(table_Expedientes);
        }
    }//GEN-LAST:event_txt_busquedaKeyTyped

    private void cb_ordenarPorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ordenarPorActionPerformed
        
        String texto = "";
        txt_busqueda.setText("");
        
        switch(cb_ordenarPor.getItemAt(cb_ordenarPor.getSelectedIndex())){
            case "Expediente":
                texto = "expe";
                break;
                
            case "Cliente":
                texto = "clie";
                break;
                
            case "Mascota":
                texto = "masc";
                break;
                
            case "Tipo Animal":
                texto = "tipo";
                break;
                
        }
        
        exp.ordenarExpedientes(table_Expedientes, texto);
    }//GEN-LAST:event_cb_ordenarPorActionPerformed

    private void txt_busquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_busquedaMouseClicked
        cb_ordenarPor.setSelectedIndex(0);
    }//GEN-LAST:event_txt_busquedaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_Expedientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Expedientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Expedientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Expedientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Expedientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirExpediente;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnNuevoExpediente;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cb_ordenarPor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_Expedientes;
    private javax.swing.JTextField txt_busqueda;
    // End of variables declaration//GEN-END:variables
}
