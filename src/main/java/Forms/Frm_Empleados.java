/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import static Conexiones.Conexion.Consultas;
import com.github.lgooddatepicker.zinternaltools.Convert;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexander Martinez
 */
public class Frm_Empleados extends javax.swing.JFrame {

    /**
     * Creates new form Frm_Empleados
     */
    public Frm_Empleados() {
        initComponents();
        dcNaci.setDate(RestarFecha(date, -18));
        dcNaci.setMaxSelectableDate(RestarFecha(date, -18));
        CargarDatos();
    }
    
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    Date date = new Date(System.currentTimeMillis());
    
    static ResultSet res;
    int cont;
    static String query = "SELECT identidad ID, nombre Nombre, telefono Teléfono, correo Correo, fecha_nacimiento [Fecha Nacimiento], descripcion_puesto Puesto, usuario Usuario  FROM Empleados e join Puesto p on e.id_puesto = p.id_puesto";
    
    public void CargarDatos() {
        DefaultTableModel modelo = (DefaultTableModel) tbEmpleados.getModel();
        modelo.setRowCount(0);
        res = Conexiones.Conexion.Consultas(query);
        try {
            while (res.next()) {
                Vector v = new Vector();
                v.add(res.getString(1));
                v.add(res.getString(2));
                v.add(res.getString(3));
                v.add(res.getString(4));
                v.add(res.getString(5));
                v.add(res.getString(6));
                v.add(res.getString(7));
                modelo.addRow(v);
                tbEmpleados.setModel(modelo);
            }
        } catch (SQLException e) {
        }
        reiniciarCampos();
    }
    
    public static boolean ValEmail(String email) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPatr = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher emailMatc = emailPatr.matcher(email);
        return emailMatc.find();
    }
    
    public Date RestarFecha(Date fecha, int anio) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.YEAR, anio);
        return calendar.getTime();
    }
    
    public void IngresarDatos() {
        try {
            res = Conexiones.Conexion.Consultas("SELECT COUNT(identidad) "
                    + "FROM Empleados where identidad = '" + ftxtId.getText() + "' "
                    + "OR usuario = '" + txtUsuario.getText() + "' OR correo = '" + txtCorreo.getText() + "'");
            try {
                while (res.next()) {
                    cont = res.getInt(1);
                }
            } catch (SQLException e) {
            }
            if (cont >= 1) {
                JOptionPane.showMessageDialog(null, "Error al intentar registrar. "
                        + "\nPosibles motivos:"
                        + "\n-Ya existe un registro con esa identidad"
                        + "\n-Ya existe un registro con ese usuario"
                        + "\n-Ya existe un registro con ese correo",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String url = "jdbc:sqlserver://localhost:1433;databaseName=ClinicaVeterinaria";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con = Conexiones.Conexion.getConnection();
                try {
                    String insert = "INSERT INTO Empleados values(?,?,?,?,?,?,?,?,?)";
                    PreparedStatement pst = con.prepareStatement(insert);
                    pst.setString(1, ftxtId.getText());
                    pst.setString(2, txtNombre.getText());
                    pst.setString(3, ftxtTelefono.getText());
                    pst.setString(4, txtCorreo.getText());
                    Date dateFromDateChooser = dcNaci.getDate();
                    String dateString = String.format("%1$tm-%1$td-%1$tY", dateFromDateChooser);
                    pst.setString(5, dateString);
                    pst.setString(6, txtUsuario.getText());
                    String pass = pfContrasenia.getText();
                    pst.setString(7, pass);
                    if (cbPuesto.getSelectedItem() == "Medico") {
                        pst.setInt(8, 1);
                    } else if (cbPuesto.getSelectedItem() == "Enfermero") {
                        pst.setInt(8, 2);
                    }
                    
                    pst.setInt(9, 1);
                    pst.executeUpdate();
                    JOptionPane.showInternalMessageDialog(null, "Se ingreso con exito!");
                    reiniciarCampos();
                    CargarDatos();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
        }
    }
    
    private void reiniciarCampos() {
        ftxtId.setText("");
        txtNombre.setText("");
        ftxtTelefono.setText("");
        txtCorreo.setText("");
        dcNaci.setDate(RestarFecha(date, -18));
        txtUsuario.setText("");
        pfContrasenia.setText("");
        pfConfirmacion.setText("");
        tbEmpleados.clearSelection();
        btnAgregar.setEnabled(true);
        btnEditar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        btnMinimizar = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        ftxtId = new javax.swing.JFormattedTextField();
        txtNombre = new javax.swing.JTextField();
        ftxtTelefono = new javax.swing.JFormattedTextField();
        txtCorreo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEmpleados = new javax.swing.JTable();
        lblFecha = new javax.swing.JLabel();
        dcNaci = new com.toedter.calendar.JDateChooser();
        btnAgregar = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblContrania = new javax.swing.JLabel();
        lblConfrmacion = new javax.swing.JLabel();
        pfContrasenia = new javax.swing.JPasswordField();
        pfConfirmacion = new javax.swing.JPasswordField();
        lblPuesto = new javax.swing.JLabel();
        cbPuesto = new javax.swing.JComboBox<>();
        btnVolver = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

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

        lblId.setFont(new java.awt.Font("SansSerif", 0, 21)); // NOI18N
        lblId.setText("Identidad:");

        lblTitulo.setFont(new java.awt.Font("Open Sans", 1, 46)); // NOI18N
        lblTitulo.setText("Registro de Empleados");

        lblNombre.setFont(new java.awt.Font("SansSerif", 0, 21)); // NOI18N
        lblNombre.setText("Nombre:");

        lblTelefono.setFont(new java.awt.Font("SansSerif", 0, 21)); // NOI18N
        lblTelefono.setText("Teléfono:");

        lblCorreo.setFont(new java.awt.Font("SansSerif", 0, 21)); // NOI18N
        lblCorreo.setText("Correo:");

        try {
            ftxtId.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#############")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftxtId.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        try {
            ftxtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftxtTelefono.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N

        txtCorreo.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N

        tbEmpleados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identidad", "Nombre", "Teléfono", "Correo", "Fecha Nacimineto", "Puesto", "Usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbEmpleados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbEmpleados);

        lblFecha.setFont(new java.awt.Font("SansSerif", 0, 21)); // NOI18N
        lblFecha.setText("Fecha Nac:");

        dcNaci.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N

        btnAgregar.setBackground(new java.awt.Color(255, 241, 110));
        btnAgregar.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        btnAgregar.setText("Nuevo Empleado");
        btnAgregar.setToolTipText("Guardar el empleado en la base de datos");
        btnAgregar.setBorderPainted(false);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setPreferredSize(new java.awt.Dimension(90, 30));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblUsuario.setFont(new java.awt.Font("SansSerif", 0, 21)); // NOI18N
        lblUsuario.setText("Usuario:");

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N

        lblContrania.setFont(new java.awt.Font("SansSerif", 0, 21)); // NOI18N
        lblContrania.setText("Contraseña:");

        lblConfrmacion.setFont(new java.awt.Font("SansSerif", 0, 21)); // NOI18N
        lblConfrmacion.setText("Confirmacion:");

        pfContrasenia.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N

        pfConfirmacion.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N

        lblPuesto.setFont(new java.awt.Font("SansSerif", 0, 21)); // NOI18N
        lblPuesto.setText("Puesto:");

        cbPuesto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Medico", "Enfermero" }));
        cbPuesto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        btnEditar.setBackground(new java.awt.Color(255, 241, 110));
        btnEditar.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        btnEditar.setText("Editar Empleado");
        btnEditar.setToolTipText("Editar el empleado seleccionado");
        btnEditar.setBorderPainted(false);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setPreferredSize(new java.awt.Dimension(90, 30));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(255, 241, 110));
        btnLimpiar.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setToolTipText("Editar el empleado seleccionado");
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.setPreferredSize(new java.awt.Dimension(90, 30));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(lblId))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblFecha)
                                .addComponent(lblCorreo)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblNombre)
                                    .addComponent(lblTelefono))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ftxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblContrania)
                                            .addComponent(lblUsuario)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(ftxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pfContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(dcNaci, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(176, 176, 176)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblConfrmacion)
                                            .addComponent(lblPuesto)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(pfConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 25, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(56, 56, 56)
                .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnVolver)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitulo)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(ftxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPuesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCorreo)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsuario)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblContrania)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pfContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblConfrmacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pfConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ftxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTelefono))))
                        .addGap(18, 18, 18)
                        .addComponent(cbPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(lblFecha))
                        .addComponent(dcNaci, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        Frm_Menu menu = new Frm_Menu(Frm_Login.nivelAcceso);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(this.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here: 
        if (ftxtId.getText().isBlank() || txtNombre.getText().isEmpty() || ftxtTelefono.getText().isBlank()
                || txtCorreo.getText().isEmpty() || txtUsuario.getText().isEmpty()
                || pfContrasenia.getText().isEmpty() || pfConfirmacion.getText().isEmpty()
                || cbPuesto.getSelectedIndex() == -1) {
            JOptionPane.showInternalMessageDialog(null, "Falta ingresar datos.");
        } else {
            if (ValEmail(txtCorreo.getText())) {
                String pass = pfConfirmacion.getText();
                String conf = pfConfirmacion.getText();
                if (conf == null ? pass == null : conf.equals(pass)) {
                    IngresarDatos();
                } else {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un correo valido.");
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        char boton = evt.getKeyChar();
        if (!Character.isLetter(boton) && boton != KeyEvent.VK_SPACE) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Frm_Menu menu = new Frm_Menu(Frm_Login.nivelAcceso);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (ftxtId.getText().isBlank() || txtNombre.getText().isEmpty() || ftxtTelefono.getText().isBlank()
                || txtCorreo.getText().isEmpty() || txtUsuario.getText().isEmpty()
                || pfContrasenia.getText().isEmpty() || pfConfirmacion.getText().isEmpty()
                || cbPuesto.getSelectedIndex() == -1) {
            JOptionPane.showInternalMessageDialog(null, "Falta ingresar datos.");
        } else {
            if (ValEmail(txtCorreo.getText())) {
                
                String pass = pfConfirmacion.getText();
                String conf = pfConfirmacion.getText();
                
                if (conf == null ? pass == null : conf.equals(pass)) {
                    actualizarDatos(ftxtId.getText());
                    reiniciarCampos();
                    CargarDatos();
                } else {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un correo valido.");
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed
    
    private void actualizarDatos(String id) {
        
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        Date date = dcNaci.getDate();
        long d = date.getTime();
        java.sql.Date fecha = new java.sql.Date(d);
        
        char[] contra = pfContrasenia.getPassword();
        String pass = "";
        for (int i = 0; i < contra.length; i++) {
            pass += contra[i];
        }
        
        int puesto = 1;
        
        if (cbPuesto.getSelectedItem() == "Medico") {
            puesto = 1;
        } else if (cbPuesto.getSelectedItem() == "Enfermero") {
            puesto = 2;
        }
        
        String sql = "UPDATE Empleados\n"
                + "SET [nombre] = '" + txtNombre.getText() + "',\n"
                + "[telefono] = '" + ftxtTelefono.getText() + "',\n"
                + "[correo] = '" + txtCorreo.getText() + "',\n"
                + "[fecha_nacimiento] = '" + fecha + "',\n"
                + "[usuario] = '" + txtUsuario.getText() + "',\n"
                + "[contrasenia] = '" + pass + "',\n"
                + "[id_puesto] = " + puesto + " ,\n"
                + "[estado_activo] = 1\n"
                + "WHERE identidad = '" + id + "' ";
        
        try {
            
            conn = Conexiones.Conexion.getConnection();
            pst = conn.prepareStatement(sql);
            pst.execute();
            
        } catch (SQLException e) {
            
        }
    }

    private void tbEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmpleadosMouseClicked
        int row = tbEmpleados.getSelectedRow();
        
        btnEditar.setEnabled(true);
        btnAgregar.setEnabled(false);
        
        ftxtId.setText(tbEmpleados.getValueAt(row, 0).toString());
        txtNombre.setText(tbEmpleados.getValueAt(row, 1).toString());
        ftxtTelefono.setText(tbEmpleados.getValueAt(row, 2).toString());
        txtCorreo.setText(tbEmpleados.getValueAt(row, 3).toString());
        try {
            Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(tbEmpleados.getValueAt(row, 4).toString());
            
            dcNaci.setDate(d1);
        } catch (ParseException ex) {
            
        }
        txtUsuario.setText(tbEmpleados.getValueAt(row, 6).toString());
        
        String puesto = tbEmpleados.getValueAt(row, 5).toString();
        
        switch (puesto) {
            case "Medico":
                cbPuesto.setSelectedIndex(0);
                break;
            case "Enfermero":
                cbPuesto.setSelectedIndex(1);
                break;
        }
        
        pfContrasenia.setText(traerPassword(ftxtId.getText()));
        pfConfirmacion.setText(traerPassword(ftxtId.getText()));

    }//GEN-LAST:event_tbEmpleadosMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        reiniciarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed
    
    private String traerPassword(String iden) {
        String contra = "";
        String sql = "SELECT contrasenia FROM Empleados WHERE identidad = '" + iden + "'";
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            
            conn = Conexiones.Conexion.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                contra = rs.getString("contrasenia");
            }
            
        } catch (Exception e) {
        }
        
        return contra;
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
            java.util.logging.Logger.getLogger(Frm_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Empleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cbPuesto;
    private com.toedter.calendar.JDateChooser dcNaci;
    private javax.swing.JFormattedTextField ftxtId;
    private javax.swing.JFormattedTextField ftxtTelefono;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblConfrmacion;
    private javax.swing.JLabel lblContrania;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPuesto;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField pfConfirmacion;
    private javax.swing.JPasswordField pfContrasenia;
    private javax.swing.JTable tbEmpleados;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
