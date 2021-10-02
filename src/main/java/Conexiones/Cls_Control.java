package Conexiones;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Cls_Control {

    //Para conexion
    private Conexion conexion = new Conexion();
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;

    private ArrayList<String> id_vac;

    public ArrayList<String> llenarTabla(JTable tabla, int exp) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();
        id_vac = new ArrayList<String>();

        try {
            String sql = "EXEC mantenimientoControlMed ?,?,?,?,?";
            
            conn = conexion.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "traer");
            pst.setString(2, "" + exp);
            pst.setString(3, null);
            pst.setString(4, null);
            pst.setString(5, null);
            rs = pst.executeQuery();

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getString(2), rs.getString(1)});
                id_vac.add(rs.getString(3));
            }

            tabla.setModel(modelo);
            conn.close();

        } catch (Exception e) {
        }

        return id_vac;
    }

    public void insertarDatos(int exp, String vac, String fecha) {

        try {

            String sql = "EXEC mantenimientoControlMed ?,?,?,?,?";

            conn = conexion.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "insertar");
            pst.setString(2, "" + exp);
            pst.setString(3, vac);
            pst.setString(4, fecha);
            pst.setString(5, null);
            pst.execute();

            conn.close();

        } catch (Exception e) {
        }

    }

    public void editarDatos(int exp, String vac, String fecha, String id_vac) {

        try {

            String sql = "EXEC mantenimientoControlMed ?,?,?,?,?";

            conn = conexion.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "editar");
            pst.setString(2, "" + exp);
            pst.setString(3, vac);
            pst.setString(4, fecha);
            pst.setString(5, id_vac);
            pst.execute();

            conn.close();

        } catch (Exception e) {
        }

    }

    public void eliminarDatos(int exp, String vac) {

        try {

            String sql = "EXEC mantenimientoControlMed ?,?,?,?,?";

            conn = conexion.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "eliminar");
            pst.setString(2, "" + exp);
            pst.setString(3, null);
            pst.setString(4, null);
            pst.setString(5, vac);
            pst.execute();

            conn.close();

        } catch (Exception e) {
        }

    }

}
