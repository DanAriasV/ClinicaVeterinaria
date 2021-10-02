
package Forms;

import Conexiones.Cls_AbrirExpediente;
import Conexiones.Cls_Expedientes;
import javax.swing.JOptionPane;

/**
 *
 * @author Walter Amador
 */
public class Frm_AbrirExpediente extends javax.swing.JFrame {

    private int id_expediente;
    private Cls_AbrirExpediente abrir = new Cls_AbrirExpediente();
    
    Cls_Expedientes plantilla = new Cls_AbrirExpediente();
    
   
    public Frm_AbrirExpediente() {
        initComponents();
        this.id_expediente = abrir.getExpediente();
        abrir.telefonoCliente();
        llenarTabla();
        llenarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        lbl_numExpediente = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnMinimizar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_archivoExpediente = new javax.swing.JTable();
        btnAbrirArchivo = new javax.swing.JButton();
        btnNuevoArchivo = new javax.swing.JButton();
        btnControlMedicamentos = new javax.swing.JButton();
        panel_visualizar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_tipoAnimal = new javax.swing.JLabel();
        lbl_NombreDueno = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_identidad = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_nombreMascota = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_telefonoCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        panelPrincipal.setBackground(new java.awt.Color(112, 244, 129));
        panelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_numExpediente.setFont(new java.awt.Font("Open Sans", 1, 46)); // NOI18N
        lbl_numExpediente.setText("###");

        jLabel2.setFont(new java.awt.Font("Open Sans", 1, 46)); // NOI18N
        jLabel2.setText("Expediente N°");

        btnVolver.setBackground(new java.awt.Color(255, 161, 161));
        btnVolver.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.setToolTipText("Volver a ventana anterior");
        btnVolver.setBorderPainted(false);
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
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

        table_archivoExpediente = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        table_archivoExpediente.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        table_archivoExpediente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_archivoExpediente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(table_archivoExpediente);

        btnAbrirArchivo.setBackground(new java.awt.Color(157, 187, 255));
        btnAbrirArchivo.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        btnAbrirArchivo.setText("Abrir Archivo");
        btnAbrirArchivo.setBorderPainted(false);
        btnAbrirArchivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAbrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirArchivoActionPerformed(evt);
            }
        });

        btnNuevoArchivo.setBackground(new java.awt.Color(255, 241, 110));
        btnNuevoArchivo.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        btnNuevoArchivo.setText("Nuevo Archivo");
        btnNuevoArchivo.setBorderPainted(false);
        btnNuevoArchivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoArchivoActionPerformed(evt);
            }
        });

        btnControlMedicamentos.setBackground(new java.awt.Color(176, 255, 182));
        btnControlMedicamentos.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        btnControlMedicamentos.setText("Control de Medicamento");
        btnControlMedicamentos.setBorderPainted(false);
        btnControlMedicamentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnControlMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlMedicamentosActionPerformed(evt);
            }
        });

        panel_visualizar.setBackground(new java.awt.Color(255, 251, 206));
        panel_visualizar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel3.setText("Información General");
        panel_visualizar.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, -1, -1));

        jLabel4.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel4.setText("Nombre dueño:");
        panel_visualizar.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel5.setText("Tipo de animal:");
        panel_visualizar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        lbl_tipoAnimal.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        lbl_tipoAnimal.setText("XYZ");
        panel_visualizar.add(lbl_tipoAnimal, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 140, -1));

        lbl_NombreDueno.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        lbl_NombreDueno.setText("XYZ");
        panel_visualizar.add(lbl_NombreDueno, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 180, -1));

        jLabel8.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel8.setText("N° Identidad:");
        panel_visualizar.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, -1, -1));

        lbl_identidad.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        lbl_identidad.setText("XYZ");
        panel_visualizar.add(lbl_identidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 150, -1));

        jLabel10.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel10.setText("Nombre mascota:");
        panel_visualizar.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 130, -1));

        lbl_nombreMascota.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        lbl_nombreMascota.setText("XYZ");
        panel_visualizar.add(lbl_nombreMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 210, -1));

        jLabel12.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel12.setText("Teléfono:");
        panel_visualizar.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, 70, -1));

        lbl_telefonoCliente.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        lbl_telefonoCliente.setText("XYZ");
        panel_visualizar.add(lbl_telefonoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, 120, -1));

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_numExpediente)
                .addGap(105, 105, 105)
                .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnControlMedicamentos)
                .addGap(45, 45, 45)
                .addComponent(btnNuevoArchivo)
                .addGap(47, 47, 47)
                .addComponent(btnAbrirArchivo)
                .addContainerGap())
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 948, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 953, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(lbl_numExpediente))
                    .addComponent(btnVolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnControlMedicamentos)
                    .addComponent(btnNuevoArchivo)
                    .addComponent(btnAbrirArchivo))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Frm_Expedientes expediente = new Frm_Expedientes();
        expediente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(this.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        Frm_Expedientes expediente = new Frm_Expedientes();
        expediente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnControlMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControlMedicamentosActionPerformed
        Frm_ControlMedicamentos control = new Frm_ControlMedicamentos(id_expediente);
        control.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnControlMedicamentosActionPerformed

    private void btnNuevoArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoArchivoActionPerformed
        Frm_Archivo archivo = new Frm_Archivo(id_expediente);
        archivo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNuevoArchivoActionPerformed

    private void btnAbrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirArchivoActionPerformed
        
        if(table_archivoExpediente.getSelectedRow() != -1){
            
            int row = table_archivoExpediente.getSelectedRow();
            int col = 0;
            int value = Integer.parseInt(table_archivoExpediente.getModel().getValueAt(row, col).toString());
            
            Frm_Archivo archivo = new Frm_Archivo(id_expediente, value);
            archivo.setVisible(true);
            this.dispose();
            
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar el archivo que desea"
                    + " abrir","Archivo no seleccionado",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAbrirArchivoActionPerformed

    private void llenarDatos() {

        lbl_numExpediente.setText("#" + id_expediente);
        abrir.llenarDatos(lbl_NombreDueno, lbl_identidad, lbl_telefonoCliente,
                lbl_tipoAnimal, lbl_nombreMascota);
    }

    private void llenarTabla() {
        
        abrir.llenarTabla(table_archivoExpediente, id_expediente);

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
            java.util.logging.Logger.getLogger(Frm_AbrirExpediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_AbrirExpediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_AbrirExpediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_AbrirExpediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_AbrirExpediente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirArchivo;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnControlMedicamentos;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnNuevoArchivo;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_NombreDueno;
    private javax.swing.JLabel lbl_identidad;
    private javax.swing.JLabel lbl_nombreMascota;
    private javax.swing.JLabel lbl_numExpediente;
    private javax.swing.JLabel lbl_telefonoCliente;
    private javax.swing.JLabel lbl_tipoAnimal;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panel_visualizar;
    private javax.swing.JTable table_archivoExpediente;
    // End of variables declaration//GEN-END:variables
}
