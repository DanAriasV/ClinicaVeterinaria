/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import javax.swing.JOptionPane;

/**
 *
 * @author Walter Amador
 */
public class Frm_Menu extends javax.swing.JFrame {

    /**
     * Creates new form Frm_Menu
     */
    public Frm_Menu() {
        initComponents();
    }

    public Frm_Menu(String nivel){
        initComponents();
        Frm_Menu.nivel = nivel;
        accederPantallas();
    }
    
    private static String nivel;
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnMinimizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAgendaCitas = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnExpedientes = new javax.swing.JButton();
        btnFactura = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnEmpleados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(112, 244, 129));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 161, 161));
        jButton1.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jButton1.setText("Cerrar Sesión");
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 560, 186, -1));

        btnCerrar.setBackground(new java.awt.Color(255, 87, 87));
        btnCerrar.setFont(new java.awt.Font("Open Sans", 0, 11)); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.setBorderPainted(false);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.setPreferredSize(new java.awt.Dimension(90, 30));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, -1, -1));

        btnMinimizar.setBackground(new java.awt.Color(82, 113, 255));
        btnMinimizar.setFont(new java.awt.Font("Open Sans", 0, 11)); // NOI18N
        btnMinimizar.setText("Minimizar");
        btnMinimizar.setBorderPainted(false);
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimizar.setPreferredSize(new java.awt.Dimension(90, 30));
        btnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(814, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Open Sans", 1, 46)); // NOI18N
        jLabel1.setText("Menú Principal");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, -1));

        btnAgendaCitas.setBackground(new java.awt.Color(186, 234, 242));
        btnAgendaCitas.setFont(new java.awt.Font("Open Sans", 0, 21)); // NOI18N
        btnAgendaCitas.setText("Agenda & Cita");
        btnAgendaCitas.setActionCommand("Agenda & Citas");
        btnAgendaCitas.setBorderPainted(false);
        btnAgendaCitas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgendaCitas.setPreferredSize(new java.awt.Dimension(180, 120));
        btnAgendaCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendaCitasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgendaCitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, -1, -1));

        btnClientes.setBackground(new java.awt.Color(255, 192, 77));
        btnClientes.setFont(new java.awt.Font("Open Sans", 0, 21)); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.setBorderPainted(false);
        btnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClientes.setPreferredSize(new java.awt.Dimension(180, 120));
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        jPanel1.add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, -1));

        btnExpedientes.setBackground(new java.awt.Color(255, 246, 131));
        btnExpedientes.setFont(new java.awt.Font("Open Sans", 0, 21)); // NOI18N
        btnExpedientes.setText("Expedientes");
        btnExpedientes.setBorderPainted(false);
        btnExpedientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExpedientes.setPreferredSize(new java.awt.Dimension(180, 120));
        btnExpedientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpedientesActionPerformed(evt);
            }
        });
        jPanel1.add(btnExpedientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 260, -1, -1));

        btnFactura.setBackground(new java.awt.Color(176, 255, 182));
        btnFactura.setFont(new java.awt.Font("Open Sans", 0, 21)); // NOI18N
        btnFactura.setText("Factura");
        btnFactura.setBorderPainted(false);
        btnFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFactura.setPreferredSize(new java.awt.Dimension(180, 120));
        btnFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturaActionPerformed(evt);
            }
        });
        jPanel1.add(btnFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, -1, -1));

        btnInventario.setBackground(new java.awt.Color(198, 182, 132));
        btnInventario.setFont(new java.awt.Font("Open Sans", 0, 21)); // NOI18N
        btnInventario.setText("Inventario");
        btnInventario.setBorderPainted(false);
        btnInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInventario.setPreferredSize(new java.awt.Dimension(180, 120));
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, -1, -1));

        btnEmpleados.setBackground(new java.awt.Color(255, 255, 255));
        btnEmpleados.setFont(new java.awt.Font("Open Sans", 0, 21)); // NOI18N
        btnEmpleados.setText("Empleados");
        btnEmpleados.setBorderPainted(false);
        btnEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmpleados.setPreferredSize(new java.awt.Dimension(180, 120));
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });
        jPanel1.add(btnEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

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

    private void accederPantallas(){
        
        if(Frm_Menu.nivel.equals("2")){
            btnExpedientes.setEnabled(false);
            btnEmpleados.setEnabled(false);
            btnExpedientes.setVisible(false);
            btnEmpleados.setVisible(false);
            
            btnAgendaCitas.setLocation(280, 170);
            btnClientes.setLocation(610, 170);
            btnInventario.setLocation(280,350);
            btnFactura.setLocation(610, 350);
            
        }
    }
    
    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        int salir = JOptionPane.showConfirmDialog(null, "Al cerrar la ventana la sesión se cierra... ¿Salir de todos modos?", "Cerrando ventana", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(salir == 0){
        Frm_Login login = new Frm_Login();
        login.setVisible(true);
        this.dispose();
        }
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(this.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int salir = JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión?", "Cerrando Sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(salir == 0){
        Frm_Login login = new Frm_Login();
        this.dispose();
        login.setVisible(true);
        Frm_Login.nivelAcceso = "";
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAgendaCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendaCitasActionPerformed
        Frm_Agenda agenda = new Frm_Agenda();
        agenda.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgendaCitasActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        Frm_Clientes cliente = new Frm_Clientes();
        cliente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnExpedientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpedientesActionPerformed
        Frm_Expedientes expediente = new Frm_Expedientes();
        expediente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExpedientesActionPerformed

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
        Frm_Empleados empleado = new Frm_Empleados();
        empleado.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEmpleadosActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        Frm_Inventario inventario = new Frm_Inventario();
        inventario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturaActionPerformed
        Frm_Factura factura = new Frm_Factura();
        factura.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnFacturaActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendaCitas;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnExpedientes;
    private javax.swing.JButton btnFactura;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
