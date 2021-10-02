/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Conexiones.Cls_Mail;
import Conexiones.Conexion;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Walter Amador
 */
public class Frm_Login extends javax.swing.JFrame {

    public Frm_Login() {
        initComponents();
    }

    private String empleado = "";
    public static String nivelAcceso = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        btnMinimizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        btnOlvido = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        passField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(112, 244, 129));

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

        jLabel1.setFont(new java.awt.Font("Open Sans", 1, 46)); // NOI18N
        jLabel1.setText("Inicio de Sesión");

        jLabel2.setFont(new java.awt.Font("Open Sans", 0, 26)); // NOI18N
        jLabel2.setText("Usuario");

        jLabel3.setFont(new java.awt.Font("Open Sans", 0, 26)); // NOI18N
        jLabel3.setText("Contraseña");

        txt_usuario.setFont(new java.awt.Font("Open Sans", 0, 26)); // NOI18N
        txt_usuario.setToolTipText("Ingresa tu usuario aquí");

        btnOlvido.setBackground(new java.awt.Color(255, 161, 161));
        btnOlvido.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        btnOlvido.setText("Olvidó contraseña");
        btnOlvido.setToolTipText("Solicitar tu contraseña");
        btnOlvido.setBorderPainted(false);
        btnOlvido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOlvido.setPreferredSize(new java.awt.Dimension(170, 50));
        btnOlvido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOlvidoActionPerformed(evt);
            }
        });

        btnIngresar.setBackground(new java.awt.Color(255, 211, 89));
        btnIngresar.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.setToolTipText("Ingresar al sistema");
        btnIngresar.setBorderPainted(false);
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.setPreferredSize(new java.awt.Dimension(170, 50));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        passField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        passField.setToolTipText("Ingresa tu contraseña aquí");
        passField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(314, 314, 314))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(txt_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                            .addComponent(passField)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(btnOlvido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(244, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOlvido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(64, 64, 64))
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

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(this.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed

        accederSistema();
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnOlvidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOlvidoActionPerformed

        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea iniciar con el proceso de recuperación de "
                + "contraseña?", "Olvidó Contraseña", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (respuesta == 0) {
            String identidad = JOptionPane.showInputDialog(this, "Ingrese su número de identidad",
                    "Olvidó contraseña", JOptionPane.INFORMATION_MESSAGE);
            String correo = JOptionPane.showInputDialog(this, "Ingrese su correo con enlazado a su cuenta",
                    "Olvidó contraseña", JOptionPane.INFORMATION_MESSAGE);

            try {
                while (!ValEmail(correo)) {
                    JOptionPane.showMessageDialog(this, "Ingrese un correo válido",
                            "Error con el correo", JOptionPane.ERROR_MESSAGE);
                    correo = JOptionPane.showInputDialog(this, "Ingrese su correo con enlazado a su cuenta",
                            "Olvidó contraseña", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {

            }

            if (!verificarUsuario(identidad, correo).equals("")) {

                try {

                    String[] info = recurperarDatos(identidad);
                    String usuario = info[0];
                    String contra = info[1];
                    String nombre = info[2];

                    new Cls_Mail().sendMail(correo, nombre, usuario, contra);

                    JOptionPane.showMessageDialog(this, "Se ha enviado su usuario y contraseña al correo",
                            "Proceso Exitoso", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Algo resultó mal con el envìo del correo"
                            + "\nVuelve a intentar en unos minutos...",
                            "Error inseperado", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Posibles motivos:"
                        + "\n1) Su identidad no concuerda con el correo de la cuenta"
                        + "\n2) Correo y/o identidad no existentes en el sistema"
                        + "\n3) Usted es un empleado inactivo",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnOlvidoActionPerformed

    private void passFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passFieldKeyTyped
        char cadena;
        cadena = evt.getKeyChar();
        if (cadena == KeyEvent.VK_ENTER) {
            accederSistema();
        }
    }//GEN-LAST:event_passFieldKeyTyped

    private void accederSistema() {
        if (!ingresarSistema(txt_usuario.getText(), passField.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(this, "Bienvenid@ " + empleado, "Ingresando al sistema", JOptionPane.INFORMATION_MESSAGE);

            Frm_Menu menu = new Frm_Menu(nivelAcceso);
            menu.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No se puede ingresar al sistema"
                    + "\nSu usuario o su contraseña está incorrecta."
                    + "\nIngrese la información correcta o solicite que le envien su"
                    + " contraseña y usuario a su correo: "
                    + "\nPresione el botón OLVIDÓ CONTRASEÑA",
                    "Usuario o contraseña incorrecta",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private String ingresarSistema(String user, char[] pass) {

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;

        String contra = "";

        for (int i = 0; i < pass.length; i++) {
            contra += pass[i];
        }

        String sql = "SELECT "
                + "nombre,"
                + "id_puesto "
                + "FROM Empleados "
                + "WHERE usuario COLLATE Latin1_General_CS_AS = '" + user + "' "
                + "AND contrasenia COLLATE Latin1_General_CS_AS = '" + contra + "' "
                + "AND estado_activo = 1";

        try {

            conn = Conexion.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                empleado = rs.getString("nombre");
                nivelAcceso = rs.getString("id_puesto");
            }

        } catch (Exception e) {
        }

        return empleado;
    }

    private String verificarUsuario(String identidad, String correo) {

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;

        String empleado = "";

        String sql = "SELECT \n"
                + "nombre\n"
                + "FROM Empleados\n"
                + "WHERE correo = '" + correo + "'\n"
                + "AND identidad = '" + identidad + "' "
                + "AND estado_activo = 1";

        try {
            conn = Conexion.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                empleado = rs.getString("nombre");
            }

        } catch (Exception e) {
        }

        return empleado;
    }

    private String[] recurperarDatos(String identidad) {
        String[] info = new String[3];

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;

        String sql = "SELECT \n"
                + "usuario,\n"
                + "contrasenia,\n"
                + "nombre\n"
                + "FROM Empleados\n"
                + "WHERE identidad = '" + identidad + "'";

        try {
            conn = Conexion.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                info[0] = rs.getString("usuario");
                info[1] = rs.getString("contrasenia");
                info[2] = rs.getString("nombre");
            }

        } catch (Exception e) {
        }

        return info;
    }

    private boolean ValEmail(String email) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPatr = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher emailMatc = emailPatr.matcher(email);
        return emailMatc.find();
    }

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
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnOlvido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passField;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
