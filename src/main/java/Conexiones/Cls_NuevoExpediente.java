package Conexiones;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Cls_NuevoExpediente{

    private Conexion conexion = new Conexion();
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;

    private ArrayList<String> identidadCliente = new ArrayList<String>();
    private ArrayList<String> cliente = new ArrayList<String>();
    private ArrayList<String> idTipo = new ArrayList<String>();

    public void llenarComboBoxCliente(JComboBox cb) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();

        try {
            String sql = "EXEC llenarComboboxCliente";
            conn = conexion.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                modelo.addElement(rs.getString(1));
                identidadCliente.add(rs.getString(2));
                cliente.add(rs.getString(3));
            }

            conn.close();
            rs.close();
            cb.setModel(modelo);

        } catch (Exception e) {
        }

    }

    public void llenarComboBoxTipoMascota(JComboBox cb) {

        DefaultComboBoxModel modelo = new DefaultComboBoxModel();

        try {
            String sql = "EXEC llenarComboboxTipoMascota";
            conn = conexion.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                modelo.addElement(rs.getString(1));
                idTipo.add(rs.getString(2));
            }

            conn.close();
            rs.close();
            cb.setModel(modelo);

        } catch (Exception e) {
        }

    }

    public String traerIdentidad(int id) {
        return identidadCliente.get(id);
    }

    public String traerIDcliente(int id) {
        return cliente.get(id);
    }
    
    public String traerIDtipoMascota(int id){
        return idTipo.get(id);
    }

    public void guardarExpediente(String id_cliente, String mascota, String id_tipo, String nacimiento) {

        try {
            
            conn = conexion.getConnection();
            pst = conn.prepareStatement("EXEC nuevoExpediente ?,?,?,?");
            pst.setString(1, id_cliente);
            pst.setString(2, mascota);
            pst.setString(3, id_tipo);
            pst.setString(4, nacimiento);
            pst.execute();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

}
