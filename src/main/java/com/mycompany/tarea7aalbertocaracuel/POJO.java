/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarea7aalbertocaracuel;

/**
 *
 * @author alber
 */
public class POJO {
    private String empleado;
    private String dni;
    private String puesto;
    private String fechaDeToma;
    private String fechaDeCese;
    private String telefono;
    private String evaluador;
    private String coordinador;

    public POJO() {
    }
    
    

    public POJO(String empleado, String dni, String puesto, String fechaDeToma, String fechaDeCese, String telefono, String evaluador, String coordinador) {
        this.empleado = empleado;
        this.dni = dni;
        this.puesto = puesto;
        this.fechaDeToma = fechaDeToma;
        this.fechaDeCese = fechaDeCese;
        this.telefono = telefono;
        this.evaluador = evaluador;
        this.coordinador = coordinador;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getFechaDeToma() {
        return fechaDeToma;
    }

    public void setFechaDeToma(String fechaDeToma) {
        this.fechaDeToma = fechaDeToma;
    }

    public String getFechaDeCese() {
        return fechaDeCese;
    }

    public void setFechaDeCese(String fechaDeCese) {
        this.fechaDeCese = fechaDeCese;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEvaluador() {
        return evaluador;
    }

    public void setEvaluador(String evaluador) {
        this.evaluador = evaluador;
    }

    public String getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(String coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public String toString() {
        return "POJO{" + "" + empleado + "," + dni + ", " + puesto + ", " + fechaDeToma + ", " + fechaDeCese + ", " + telefono + ", " + evaluador + "," + coordinador + '}';
    }
    
    
}
