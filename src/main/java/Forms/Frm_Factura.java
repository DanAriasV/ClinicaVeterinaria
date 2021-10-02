package Forms;

import Conexiones.Factura;
import Conexiones.Conexion;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kenia Martinez
 */
public class Frm_Factura extends javax.swing.JFrame {

    /**
     * Creates new form Frm_Factura
     */
    public Frm_Factura() {
        initComponents();
    }

    Factura fact = new Factura();
    DecimalFormat nd = new DecimalFormat("#.00");
    private DefaultTableModel model;

    public static String FechaFact() {
        Date fecha = new Date();
        SimpleDateFormat f = new SimpleDateFormat("YYYY-MM-dd");

        return f.format(fecha);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel7 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbConcepto = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtImporte = new java.awt.TextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rbEfvo = new javax.swing.JRadioButton();
        rbTarjeta = new javax.swing.JRadioButton();
        lblRef = new javax.swing.JLabel();
        txtRef = new java.awt.TextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtDesc = new java.awt.TextField();
        txtTotal = new java.awt.TextField();
        btnCalcular = new javax.swing.JButton();
        txtSubTotal = new java.awt.TextField();
        txtCodCliente = new javax.swing.JTextField();
        spQty = new javax.swing.JSpinner();
        btnOk_ = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblFecha = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnAyuda = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnMinimizar = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(112, 244, 129));
        setMaximumSize(new java.awt.Dimension(1000, 593));
        setMinimumSize(new java.awt.Dimension(1000, 593));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1000, 593));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel7.setText("Cantidad:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, 95, -1));

        btnVolver.setBackground(new java.awt.Color(255, 161, 161));
        btnVolver.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.setBorderPainted(false);
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel2.setText("Fecha de Facturación:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 62, 180, -1));

        cbConcepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbConceptoActionPerformed(evt);
            }
        });
        getContentPane().add(cbConcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 113, 284, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel3.setText("Código del Cliente:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 67, -1, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel4.setText("Concepto:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 112, 81, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel1.setText("Importe:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 67, -1));

        txtImporte.setEnabled(false);
        txtImporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtImporteKeyPressed(evt);
            }
        });
        getContentPane().add(txtImporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 150, -1));

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel9.setText("Conceptos a Facturar:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 165, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel6.setText("Tipo de Pago:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 369, 140, -1));

        rbEfvo.setBackground(new java.awt.Color(112, 244, 129));
        buttonGroup1.add(rbEfvo);
        rbEfvo.setText("Efectivo");
        rbEfvo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEfvoActionPerformed(evt);
            }
        });
        getContentPane().add(rbEfvo, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 396, -1, -1));

        rbTarjeta.setBackground(new java.awt.Color(112, 244, 129));
        buttonGroup1.add(rbTarjeta);
        rbTarjeta.setText("Tarjeta");
        rbTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTarjetaActionPerformed(evt);
            }
        });
        getContentPane().add(rbTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 422, -1, -1));

        lblRef.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lblRef.setText("N° Referencia:");
        getContentPane().add(lblRef, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 479, 140, -1));

        txtRef.setEnabled(false);
        txtRef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRefActionPerformed(evt);
            }
        });
        txtRef.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRefKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRefKeyTyped(evt);
            }
        });
        getContentPane().add(txtRef, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 479, 149, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel11.setText("SubTotal:");

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel12.setText("Descuento:");

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel13.setText("Total:");

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel14.setText("L.");

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel15.setText("L.");

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel16.setText("L.");

        txtDesc.setText("0.00");
        txtDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescActionPerformed(evt);
            }
        });
        txtDesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescKeyPressed(evt);
            }
        });

        txtTotal.setEnabled(false);
        txtTotal.setText("0.00");
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        btnCalcular.setBackground(new java.awt.Color(176, 255, 182));
        btnCalcular.setText("Calcular");
        btnCalcular.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        txtSubTotal.setEnabled(false);
        txtSubTotal.setText("0.00");
        txtSubTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(140, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel16))
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel14))
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel15))
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 369, -1, -1));

        txtCodCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodClienteKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodClienteKeyTyped(evt);
            }
        });
        getContentPane().add(txtCodCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 69, 191, -1));

        spQty.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));
        getContentPane().add(spQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 110, 48, -1));

        btnOk_.setBackground(new java.awt.Color(255, 255, 204));
        btnOk_.setText("ok");
        btnOk_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOk_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOk_ActionPerformed(evt);
            }
        });
        getContentPane().add(btnOk_, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 109, 75, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N° Item", "Concepto", "Qty", "Importe", "SubTotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoscrolls(false);
        jTable1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jTable1ComponentAdded(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 803, 132));

        lblFecha.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lblFecha.setText("-");
        getContentPane().add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 62, 168, -1));

        jPanel1.setBackground(new java.awt.Color(112, 244, 129));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAyuda.setBackground(new java.awt.Color(186, 234, 242));
        btnAyuda.setFont(new java.awt.Font("Open Sans", 0, 10)); // NOI18N
        btnAyuda.setText("¿?");
        btnAyuda.setToolTipText("Ayuda");
        btnAyuda.setBorderPainted(false);
        btnAyuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAyuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, -1, 40));

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
        jPanel1.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        Frm_Menu menu = new Frm_Menu(Frm_Login.nivelAcceso);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        txtSubTotal.setText("0.00");
        txtDesc.setText("0.00");
        txtTotal.setText("0.00");
        lblFecha.setText(FechaFact());
        //Cargar el combo box
        fact.LlenarConcepto(cbConcepto);
        btnCalcular.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:

        Frm_Menu menu = new Frm_Menu(Frm_Login.nivelAcceso);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtRefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRefActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRefActionPerformed

    private void btnOk_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOk_ActionPerformed
        //PARTE DE ENCABEZADO DE LA FACTURA
        if (cbConcepto.getSelectedItem().equals("Seleccione una opción") || txtCodCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No puede dejar campos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            fact.setFecha(lblFecha.getText());
            fact.setCliente(txtCodCliente.getText());

            fact.setQty(Integer.parseInt(spQty.getValue().toString()));
            fact.BuscarCliente();
            
            Object[] columns = {"N° Item", "Concepto", "Qty", "Importe", "SubTotal"};
            model = new DefaultTableModel();
            model.setColumnIdentifiers(columns);
            jTable1.setModel(model);

            Object[] row = new Object[5];
            row[0] = 1;
            row[1] = cbConcepto.getSelectedItem();
            row[2] = fact.getQty();
            row[3] = fact.getImporte();
            row[4] = fact.CalculoSubTotal();

            model.addRow(row);
            btnCalcular.setVisible(true);
        }
    }//GEN-LAST:event_btnOk_ActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        fact.BuscarProducto();
        if ((!rbEfvo.isSelected() && !rbTarjeta.isSelected())) {
            JOptionPane.showMessageDialog(null, "No puede dejar campos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            fact.setDesc(Double.parseDouble(txtDesc.getText()));

            if (rbEfvo.isSelected()) {
                fact.setTipoPago(1);
            } else {
                fact.setTipoPago(2);
            }

            fact.setRef(txtRef.getText());

            txtSubTotal.setText(String.valueOf(fact.CalculoSubTotal()));
            txtTotal.setText(String.valueOf(fact.CalculoTotal()));
            txtDesc.setText(String.valueOf(fact.getDesc()));

            try {
                fact.InsertarFact();
                fact.RestarProductos();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar datos" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            

            try {
                fact.InsertarDetalle();
                JOptionPane.showMessageDialog(null, "Datos guardados con éxito", "", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(Frm_Factura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        txtCodCliente.setText("");
        txtImporte.setText("");
        txtDesc.setText("0.00");
        txtRef.setText("");
        txtRef.setEnabled(false);
        txtSubTotal.setText("0.00");
        txtTotal.setText("0.00");
        rbEfvo.setSelected(false);
        rbTarjeta.setSelected(false);
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtSubTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubTotalActionPerformed

    private void txtDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescActionPerformed

    private void jTable1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jTable1ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1ComponentAdded

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void rbEfvoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEfvoActionPerformed
        txtRef.setEnabled(false);
    }//GEN-LAST:event_rbEfvoActionPerformed

    private void rbTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTarjetaActionPerformed
        txtRef.setEnabled(true);
    }//GEN-LAST:event_rbTarjetaActionPerformed

    private void txtCodClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodClienteKeyPressed
        char c = evt.getKeyChar();
        
        if(!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c == KeyEvent.VK_SPACE){
            evt.consume();
        }
    }//GEN-LAST:event_txtCodClienteKeyPressed

    private void txtImporteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImporteKeyPressed
        char c = evt.getKeyChar();
        
        if(c < '0' || c > '9'){
            evt.consume();
        }
    }//GEN-LAST:event_txtImporteKeyPressed

    private void txtDescKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescKeyPressed
        char c = evt.getKeyChar();
        
        if(c < '0' || c > '9' && c != KeyEvent.VK_BACK_SPACE && c == KeyEvent.VK_SPACE){
            evt.consume();
        }
    }//GEN-LAST:event_txtDescKeyPressed

    private void txtRefKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRefKeyPressed
        char c = evt.getKeyChar();
        
        if(c < '0' || c > '9' && c != KeyEvent.VK_BACK_SPACE && c == KeyEvent.VK_SPACE){
            evt.consume();
        }
    }//GEN-LAST:event_txtRefKeyPressed

    private void txtCodClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodClienteKeyTyped
        // TODO add your handling code here:
        if(txtCodCliente.getText().length() >= 13){
            evt.consume();
        }
    }//GEN-LAST:event_txtCodClienteKeyTyped

    private void txtRefKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRefKeyTyped
        // TODO add your handling code here:
        if(txtRef.getText().length() >= 5){
            evt.consume();
        }
    }//GEN-LAST:event_txtRefKeyTyped

    private void cbConceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbConceptoActionPerformed
        fact.setIdConcepto(cbConcepto.getSelectedItem().toString());
        fact.BuscarImporte();
        txtImporte.setText("" + fact.getImporte());
    }//GEN-LAST:event_cbConceptoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
            Conexion.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(Frm_Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosed

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        JOptionPane.showMessageDialog(this, "1) Ingresa la identidad del cliente en el campo CODIGO DE CLIENTE"
            + "\n2) Escoge el producto a comprar en CONCEPTO"
            + "\n3) Elige la cantidad que deseas comprar de ese producto"
                + "\n4) Presiona el botón OK"
                + "\n5) Repite el proceso de escoger producto hasta que hayas terminado"
                + "\n6) Escoge el tipo de pago "
                + "\n7) En caso de que el tipo de pago sea con tarjeta insertar N° REFERENCIA"
                + "\n8) Presiona el botón calcular para finalizar la compra",
            "Información de ayuda", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAyudaActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnOk_;
    private javax.swing.JButton btnVolver;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbConcepto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblRef;
    private javax.swing.JRadioButton rbEfvo;
    private javax.swing.JRadioButton rbTarjeta;
    private javax.swing.JSpinner spQty;
    private javax.swing.JTextField txtCodCliente;
    private java.awt.TextField txtDesc;
    private java.awt.TextField txtImporte;
    private java.awt.TextField txtRef;
    private java.awt.TextField txtSubTotal;
    private java.awt.TextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
