package Conexiones;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Cls_Expedientes {

    private static String cliente;
    private static String identidad;
    private static String telefono;
    private static String mascota;
    private static String tipoMascota;
    private static int expediente;
    
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public String getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(String tipoMascota) {
        this.tipoMascota = tipoMascota;
    }
    
    public void setExpediente(int expediente){
        this.expediente = expediente;
    }
    
    public int getExpediente(){
        return expediente;
    }
    
    //Para conexion
    private Conexion conexion = new Conexion();
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;

    public void llenarTabla(JTable tabla) {

        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();

        try {

            String sql = "exec listadoExpedientes";
            conn = conexion.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getString("id_expediente"),
                rs.getString("nombre_cliente"), rs.getString("identidad"),
                rs.getString("nombre_mascota"), rs.getString("descripcion_tipo_mascota"),
                rs.getString("fecha_nacimiento_mascota")});
            }

            
            tabla.setModel(modelo);
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void filtrarDatos(JTable tabla, String texto){
        
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();

        try {

            String sql = "EXEC filtroExpedientes ?";
            conn = conexion.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, texto);
            rs = pst.executeQuery();

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getString("id_expediente"),
                rs.getString("nombre_cliente"), rs.getString("identidad"),
                rs.getString("nombre_mascota"), rs.getString("descripcion_tipo_mascota"),
                rs.getString("fecha_nacimiento_mascota")});
            }

            
            tabla.setModel(modelo);
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public void ordenarExpedientes(JTable tabla, String texto){
        
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();

        try {

            String sql = "EXEC ordenarExpedientes ?";
            conn = conexion.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, texto);
            rs = pst.executeQuery();

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getString("id_expediente"),
                rs.getString("nombre_cliente"), rs.getString("identidad"),
                rs.getString("nombre_mascota"), rs.getString("descripcion_tipo_mascota"),
                rs.getString("fecha_nacimiento_mascota")});
            }

            
            tabla.setModel(modelo);
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
}
