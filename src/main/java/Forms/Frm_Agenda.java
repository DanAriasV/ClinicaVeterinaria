/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Conexiones.ProcedimientosAgenda;
import Conexiones.cls_AgendaCita;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Oscar Andrade
 */
public class Frm_Agenda extends javax.swing.JFrame {
    
    private String nombremascota;
    cls_AgendaCita AgendaCita = new cls_AgendaCita();
    SimpleDateFormat FormatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat FormatoHora = new SimpleDateFormat("h:m");
    static ResultSet res;
    
    Vector codigoEmpleado = new Vector();
    
    boolean estadocampos = false;
    
    Date date = new Date();

    

    /**
     * Creates new form Frm_Agenda
     */
    public Frm_Agenda() {
        initComponents();
      
        calendario_agenda.setDate(date);
        String fecha =FormatoFecha.format(date);
        ListaAgenda(fecha);
        
        cb_Doctor.removeAllItems();
        res = Conexiones.Conexion.Consultas("SELECT * FROM Empleados where id_puesto = 1");
        try{
            while(res.next())
            {
                cb_Doctor.addItem(res.getString("nombre"));
                codigoEmpleado.add(res.getInt("id_empleado"));
            }
        }catch(SQLException e) {}
        cb_Doctor.setSelectedIndex(-1);
        
    }
    
    public void ListaAgenda()
    {
        String fecha =FormatoFecha.format(calendario_agenda.getDate());
        
        DefaultTableModel agenda = (DefaultTableModel) table_Agenda.getModel();
        agenda.setRowCount(0);
        res = Conexiones.Conexion.Consultas("Select " +
"	hora," +
"	CC.nombre_cliente," +
"	nombre_mascota," +
"	E.nombre" +
"	FROM Citas C" +
"	INNER JOIN Clientes CC ON C.id_cliente = CC.id_cliente" +
"	INNER JOIN Empleados E ON C.id_empleado = E.id_empleado "+
                "WHERE C.fecha = '"+fecha+"' "+
                "order by hora asc");
        
        
        try{
            while(res.next())
            {
                Vector v = new Vector();
                //v.add(res.getTime("hora"));
                v.add(res.getTime(1));
                v.add(res.getString(2));
                v.add(res.getString(3));
                v.add(res.getString(4));
                
                agenda.addRow(v);
                table_Agenda.setModel(agenda);

            }
        }
        catch(SQLException e){}
    }
    
    public void ListaAgenda(String fecha)
    {
        //String fecha =FormatoFecha.format(calendario_agenda.getDate());
        
        DefaultTableModel agenda = (DefaultTableModel) table_Agenda.getModel();
        agenda.setRowCount(0);
        res = Conexiones.Conexion.Consultas("Select " +
"	hora," +
"	CC.nombre_cliente," +
"	nombre_mascota," +
"	E.nombre" +
"	FROM Citas C" +
"	INNER JOIN Clientes CC ON C.id_cliente = CC.id_cliente" +
"	INNER JOIN Empleados E ON C.id_empleado = E.id_empleado "+
         "WHERE C.fecha = '"+fecha+"' "+
         "order by hora asc");
        
        
        try{
            while(res.next())
            {
                Vector v = new Vector();
                //v.add(res.getTime("hora"));
                v.add(res.getTime(1));
                v.add(res.getString(2));
                v.add(res.getString(3));
                v.add(res.getString(4));
                
                agenda.addRow(v);
                table_Agenda.setModel(agenda);

            }
        }
        catch(SQLException e){}
    }
    
    private boolean  TablaCitas()
    {
        boolean agenda= false;
        DefaultTableModel datosCita = new DefaultTableModel();
        datosCita.setRowCount(0);
        
        String fecha =FormatoFecha.format(calendar_cita.getDate());
        
        res = Conexiones.Conexion.Consultas("SELECT " +
        "id_cita [Cita]," +
        "E.nombre [Empleado]," +
        "hora [Inicio]," +
        "hora_final [Final] " +
        "FROM [dbo].[Citas] C " +
        "JOIN [dbo].[Empleados] E ON C.id_empleado = E.id_empleado " +
        "WHERE E.id_empleado = "+ AgendaCita.getCodigoEmpleado()+
        " and '"+ AgendaCita.getHora()+
        "' between hora and hora_final AND fecha = '"+fecha+"'");
        try {
            while(res.next())
            {
                if(res.wasNull())
                {
                    agenda = false;
                }
                else
                {
                   JOptionPane.showMessageDialog(null, "El Dr. "+res.getString(2)+" está ocupado"+
                " entre las "+res.getTime(3)+" y "+res.getTime(4)); 
                   agenda = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Frm_Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return agenda;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Superior = new javax.swing.JPanel();
        btnMinimizar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        b_Volver = new javax.swing.JButton();
        tabpane_agendacita = new javax.swing.JTabbedPane();
        panel_agenda = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Agenda = new javax.swing.JTable();
        label_TituloAgenda = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        calendario_agenda = new com.toedter.calendar.JDateChooser();
        panel_Cita = new javax.swing.JPanel();
        label_TituloCita = new javax.swing.JLabel();
        lb_Cliente = new javax.swing.JLabel();
        lb_Mascota = new javax.swing.JLabel();
        lb_DNI = new javax.swing.JLabel();
        txt_Cliente = new javax.swing.JTextField();
        cb_Mascota = new javax.swing.JComboBox<>();
        cb_Doctor = new javax.swing.JComboBox<>();
        calendar_cita = new com.toedter.calendar.JCalendar();
        txt_DNI = new javax.swing.JTextField();
        lb_Doctor1 = new javax.swing.JLabel();
        lb_Doctor2 = new javax.swing.JLabel();
        b_Guardar = new javax.swing.JButton();
        b_Limpiar = new javax.swing.JButton();
        time_hora = new com.github.lgooddatepicker.components.TimePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1000, 660));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 660));

        panel_Superior.setBackground(new java.awt.Color(112, 244, 129));

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

        b_Volver.setBackground(new java.awt.Color(255, 161, 161));
        b_Volver.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        b_Volver.setText("Volver");
        b_Volver.setBorder(null);
        b_Volver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_VolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_SuperiorLayout = new javax.swing.GroupLayout(panel_Superior);
        panel_Superior.setLayout(panel_SuperiorLayout);
        panel_SuperiorLayout.setHorizontalGroup(
            panel_SuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_SuperiorLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(b_Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel_SuperiorLayout.setVerticalGroup(
            panel_SuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_SuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_SuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_agenda.setBackground(new java.awt.Color(112, 244, 129));
        panel_agenda.setMaximumSize(new java.awt.Dimension(1000, 660));
        panel_agenda.setPreferredSize(new java.awt.Dimension(1000, 660));
        panel_agenda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_Agenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hora", "Nombre", "Mascota", "Empleado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Agenda.setColumnSelectionAllowed(true);
        table_Agenda.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        table_Agenda.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_Agenda.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table_Agenda);
        table_Agenda.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (table_Agenda.getColumnModel().getColumnCount() > 0) {
            table_Agenda.getColumnModel().getColumn(0).setResizable(false);
            table_Agenda.getColumnModel().getColumn(1).setResizable(false);
            table_Agenda.getColumnModel().getColumn(2).setResizable(false);
            table_Agenda.getColumnModel().getColumn(3).setResizable(false);
        }

        panel_agenda.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 870, 260));

        label_TituloAgenda.setFont(new java.awt.Font("SansSerif", 0, 48)); // NOI18N
        label_TituloAgenda.setText("Agenda");
        panel_agenda.add(label_TituloAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 170, -1));

        jButton1.setText("Refresh");
        jButton1.setToolTipText("Refresca tu agenda");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel_agenda.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 90, 40));
        panel_agenda.add(calendario_agenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 230, 40));

        tabpane_agendacita.addTab("Agenda", panel_agenda);

        panel_Cita.setBackground(new java.awt.Color(112, 244, 129));
        panel_Cita.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_TituloCita.setFont(new java.awt.Font("SansSerif", 0, 48)); // NOI18N
        label_TituloCita.setText("Cita");
        panel_Cita.add(label_TituloCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 96, -1));

        lb_Cliente.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lb_Cliente.setText("Cliente");
        panel_Cita.add(lb_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 95, 20));

        lb_Mascota.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lb_Mascota.setText("Mascota");
        panel_Cita.add(lb_Mascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 80, -1));

        lb_DNI.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lb_DNI.setText("DNI");
        panel_Cita.add(lb_DNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 59, -1));

        txt_Cliente.setEnabled(false);
        txt_Cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ClienteKeyPressed(evt);
            }
        });
        panel_Cita.add(txt_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 152, 30));

        panel_Cita.add(cb_Mascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 156, 30));

        panel_Cita.add(cb_Doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 156, 30));

        calendar_cita.setPreferredSize(new java.awt.Dimension(350, 200));
        panel_Cita.add(calendar_cita, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 600, -1));

        txt_DNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DNIActionPerformed(evt);
            }
        });
        txt_DNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_DNIKeyPressed(evt);
            }
        });
        panel_Cita.add(txt_DNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 152, 30));

        lb_Doctor1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lb_Doctor1.setText("Doctor");
        panel_Cita.add(lb_Doctor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 80, -1));

        lb_Doctor2.setText("Hora");
        lb_Doctor2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        panel_Cita.add(lb_Doctor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 60, -1));

        b_Guardar.setBackground(new java.awt.Color(255, 246, 131));
        b_Guardar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        b_Guardar.setText("Guardar");
        b_Guardar.setToolTipText("Guardar nueva cita");
        b_Guardar.setBorder(null);
        b_Guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_GuardarActionPerformed(evt);
            }
        });
        panel_Cita.add(b_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 330, 90, 50));

        b_Limpiar.setBackground(new java.awt.Color(186, 234, 242));
        b_Limpiar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        b_Limpiar.setText("Borrar");
        b_Limpiar.setToolTipText("Borrar cita");
        b_Limpiar.setBorder(null);
        b_Limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_LimpiarActionPerformed(evt);
            }
        });
        panel_Cita.add(b_Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 400, 90, 50));

        time_hora.setEnabled(false);
        panel_Cita.add(time_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, 150, -1));

        tabpane_agendacita.addTab("Cita", panel_Cita);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabpane_agendacita, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addComponent(panel_Superior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panel_Superior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(tabpane_agendacita, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
        );

        tabpane_agendacita.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        Frm_Menu menu = new Frm_Menu(Frm_Login.nivelAcceso);
        menu.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txt_DNIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_DNIKeyPressed
        // TODO add your handling code here:
        String  dni = txt_DNI.getText();
        int longitud = dni.length()+1;
       // System.out.println("Longitud: "+longitud);
        int key = evt.getKeyCode();
        if(key>=KeyEvent.VK_0 && key<=KeyEvent.VK_9||key>=KeyEvent.VK_NUMPAD0 && key<=KeyEvent.VK_NUMPAD9 || key==KeyEvent.VK_BACK_SPACE)
        {
            if(longitud <= 13)
            {
                txt_DNI.setEditable(true);
                txt_DNI.setForeground(Color.red);
            }
            else
            {
                txt_DNI.setEditable(false);
                txt_DNI.setForeground(Color.BLUE);
            }
                       
                   
        }
        else
        {
            txt_DNI.setEditable(false);
        }
        
        
        if(longitud >= 13 && key==KeyEvent.VK_BACK_SPACE) 
        {
                txt_DNI.setEditable(true);
                txt_DNI.setForeground(Color.red);
        }
        if(longitud == 13)
        {
            txt_DNI.setForeground(Color.BLUE);
        }
        
        
    }//GEN-LAST:event_txt_DNIKeyPressed

    private void txt_ClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ClienteKeyPressed
        // TODO add your handling code here:
        String  nombre = txt_Cliente.getText();
        int longitud = nombre.length();
        int key = evt.getKeyCode();
        if(Character.isLetter(key)||Character.isWhitespace(key)||Character.isISOControl(key))
        {
            if(longitud <20)
            {
              txt_Cliente.setEditable(true);
            }
            else
            {
              txt_Cliente.setEditable(false);
            }

        }
        else
        {
            txt_Cliente.setEditable(false);
        }
    }//GEN-LAST:event_txt_ClienteKeyPressed

    private void b_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_GuardarActionPerformed
        // TODO add your handling code here:
        String input = txt_DNI.getText();
        if(input.trim().isBlank())
        {
            JOptionPane.showMessageDialog(null, "Ingrese DNI");
        }
        else
        {
            AgendaCita.setNombre(txt_Cliente.getText());
        }
        
        input = txt_Cliente.getText();
        if(input.trim().isBlank())
        {
            JOptionPane.showMessageDialog(null, "Ingrese Nombre");
        }   
        else
        {
            AgendaCita.setIdentidad(txt_DNI.getText());
        }
        
        
        String fecha =FormatoFecha.format(calendar_cita.getDate());
        
        
        AgendaCita.setHora(time_hora.getTime());
        AgendaCita.setHorafinal(time_hora.getTime().plusMinutes(30));
        nombremascota = (String) cb_Mascota.getSelectedItem();
        AgendaCita.setCodigoEmpleado((int)codigoEmpleado.get(cb_Doctor.getSelectedIndex()));
        
        
         if(estadocampos && !TablaCitas())
         {
            try {
                ProcedimientosAgenda.IngresoDatosCita(
                        AgendaCita.getIdentidad(), 
                        fecha,
                        AgendaCita.getHora(),
                        AgendaCita.getCodigoEmpleado(),
                        nombremascota,
                        AgendaCita.getHorafinal());

                txt_Cliente.setText("");
                txt_DNI.setText("");
                cb_Doctor.setSelectedIndex(-1);
                time_hora.clear();
                cb_Mascota.removeAllItems();
                estadocampos = false;
                time_hora.setEnabled(false);
                AgendaCita.setCodigoCliente(0);

                JOptionPane.showMessageDialog(null,"Datos Ingresados");
            } catch (SQLException ex) {
                Logger.getLogger(Frm_Agenda.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         
         
            
    }//GEN-LAST:event_b_GuardarActionPerformed

    private void b_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_LimpiarActionPerformed
        // TODO add your handling code here:
            txt_Cliente.setText("");
            txt_DNI.setText("");
            cb_Mascota.setSelectedIndex(-1);
            cb_Doctor.setSelectedIndex(-1);
            time_hora.clear();
            cb_Mascota.removeAllItems();
            
            estadocampos=false;
            time_hora.setEnabled(false);
            AgendaCita.setCodigoCliente(0);
        //System.out.println("LA CONEXION SE REALIZO CORRECTAMENTE");
    }//GEN-LAST:event_b_LimpiarActionPerformed

    private void txt_DNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DNIActionPerformed
        // TODO add your handling code here:
        
        res = Conexiones.Conexion.Consultas("SELECT * FROM Clientes WHERE identidad = "+txt_DNI.getText());
        try{
            while(res.next())
            {
                
                txt_Cliente.setText(res.getString("nombre_cliente"));
                AgendaCita.setCodigoCliente(res.getInt("id_cliente"));
               
            }
        }catch(SQLException e){}
        

        
        cb_Mascota.removeAllItems();
        res = Conexiones.Conexion.Consultas("SELECT nombre_mascota FROM [dbo].[Mascota_Expediente] where id_cliente = "+AgendaCita.getCodigoCliente());
        try{
            while(res.next())
            {
                cb_Mascota.addItem(res.getString("nombre_mascota"));
            }
        }catch(SQLException e){}
      
        
        
        time_hora.setEnabled(true);
        time_hora.setTimeToNow();
        cb_Doctor.setSelectedIndex(0);
        estadocampos = true;
        //System.out.println("Codigo:"+codigoEmpleado);
        
    }//GEN-LAST:event_txt_DNIActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ListaAgenda();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void b_VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_VolverActionPerformed
        // TODO add your handling code here:
        Frm_Menu menu = new Frm_Menu(Frm_Login.nivelAcceso);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_b_VolverActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        // TODO add your handling code here:
        this.setExtendedState(this.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Agenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_Guardar;
    private javax.swing.JButton b_Limpiar;
    private javax.swing.JButton b_Volver;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnMinimizar;
    private com.toedter.calendar.JCalendar calendar_cita;
    private com.toedter.calendar.JDateChooser calendario_agenda;
    private javax.swing.JComboBox<String> cb_Doctor;
    private javax.swing.JComboBox<String> cb_Mascota;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_TituloAgenda;
    private javax.swing.JLabel label_TituloCita;
    private javax.swing.JLabel lb_Cliente;
    private javax.swing.JLabel lb_DNI;
    private javax.swing.JLabel lb_Doctor1;
    private javax.swing.JLabel lb_Doctor2;
    private javax.swing.JLabel lb_Mascota;
    private javax.swing.JPanel panel_Cita;
    private javax.swing.JPanel panel_Superior;
    private javax.swing.JPanel panel_agenda;
    private javax.swing.JTable table_Agenda;
    private javax.swing.JTabbedPane tabpane_agendacita;
    private com.github.lgooddatepicker.components.TimePicker time_hora;
    private javax.swing.JTextField txt_Cliente;
    private javax.swing.JTextField txt_DNI;
    // End of variables declaration//GEN-END:variables
}
