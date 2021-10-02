package Conexiones;

import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Cls_AbrirExpediente extends Cls_Expedientes {

    private Conexion conexion = new Conexion();
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;

    
    
    public void llenarTabla(JTable tabla, int expediente) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID Archivo", "Fecha", "Motivo"});

        try {

            String sql = "EXEC listadoArchivos ?";

            conn = conexion.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, ""+expediente);
            rs = pst.executeQuery();

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getString("id_archivo"),
                    rs.getString("fecha"), rs.getString("motivo_visita")});
            }

            tabla.setModel(modelo);
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void llenarDatos(JLabel dueno, JLabel identidad, JLabel telefono,
            JLabel tipoAnimal, JLabel mascota) {

        dueno.setText(getCliente());
        identidad.setText(getIdentidad());
        telefono.setText(getTelefono());
        tipoAnimal.setText(getTipoMascota());
        mascota.setText(getMascota());
    }

    public void telefonoCliente() {
        
        try {
            String sql = "SELECT telefono_cliente FROM Clientes WHERE identidad = " + getIdentidad();
            Statement st = null;
            
            conn = conexion.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                setTelefono(rs.getString(1));
            }
            
            conn.close();
            
        } catch (Exception e) {
        }

    }
}
