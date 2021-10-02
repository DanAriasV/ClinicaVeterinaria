/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;
import java.util.Date;
import java.time.LocalTime;



/**
 *
 * @author Oscar Andrade
 */
public class cls_AgendaCita {

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getIdentidad() {
        return _identidad;
    }

    public void setIdentidad(String _identidad) {
        this._identidad = _identidad;
    }

    public String getMascota() {
        return _mascota;
    }

    public void setMascota(String _mascota) {
        this._mascota = _mascota;
    }

    public String getDoctor() {
        return _doctor;
    }

    public void setDoctor(String _doctor) {
        this._doctor = _doctor;
    }

    public Date getFecha() {
        return _fecha;
    }

    public void setFecha(Date _fecha) {
        this._fecha = _fecha;
    }

    public LocalTime getHora() {
        return _hora;
    }

    public void setHora(LocalTime _hora) {
        this._hora = _hora;
    }
    
     public int getCodigoCliente() {
        return _codigoCliente;
    }

    public void setCodigoCliente(int _codigoCliente) {
        this._codigoCliente = _codigoCliente;
    }
    
    public int getCodigoEmpleado() {
        return _codigoEmpleado;
    }

    public void setCodigoEmpleado(int _codigoEmpleado) {
        this._codigoEmpleado = _codigoEmpleado;
    }
     public LocalTime getHorafinal() {
        return _horafinal;
    }

    public void setHorafinal(LocalTime _horafinal) {
        this._horafinal = _horafinal;
    }
    
    
    private String _nombre;
    private String _identidad;
    private String _mascota;
    private String _doctor;
    private Date _fecha;
    private LocalTime _hora;
  
    private LocalTime _horafinal;
    private int _codigoCliente;
    private int _codigoEmpleado;
    
    
    
}
