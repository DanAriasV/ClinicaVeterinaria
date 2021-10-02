package Conexiones;

import java.sql.*;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Cls_Archivo {

    private int frecuenciaCardiaca = 0;
    private double peso = 0;
    private double temp = 0;
    private String motivo;
    private String descripcion;
    private String receta = "";
    private int expediente;

    public int getExpediente() {
        return expediente;
    }

    public void setExpediente(int expediente) {
        this.expediente = expediente;
    }

    public int getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(int frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    private Conexion conexion = new Conexion();
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;

    public boolean guardarArchivo() {

        try {
            String sql = "EXEC nuevoArchivo ?,?,?,?,?,?,?";
            conn = Conexion.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "" + expediente);
            pst.setString(2, motivo);
            pst.setString(3, descripcion);
            pst.setString(4, "" + frecuenciaCardiaca);
            pst.setString(5, "" + peso);
            pst.setString(6, "" + temp);
            pst.setString(7, "" + receta);
            pst.execute();
            
            conn.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public void recuperarDatos(int exp, int arch, JSpinner fc, JSpinner peso,
            JSpinner temp, JTextField motivo, JTextArea desc, JTextArea receta) {

        try {
            String sql = "EXEC recuperarDatosArchivo ?,?";

            conn = conexion.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "" + exp);
            pst.setString(2, "" + arch);
            rs = pst.executeQuery();

            while (rs.next()) {
                
                motivo.setText(rs.getString(7) + " | " + rs.getString(1));
                desc.setText(rs.getString(2));
                receta.setText(rs.getString(6));
                fc.setValue(Integer.parseInt(rs.getString(3)));
                peso.setValue(Double.parseDouble(rs.getString(4)));
                temp.setValue(Double.parseDouble(rs.getString(5)));
                
            }
            conn.close();
        } catch (Exception e) {
        }
    }

}
