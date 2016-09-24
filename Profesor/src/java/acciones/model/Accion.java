/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.model;

/**
 *
 * @author tyrrang
 */
public class Accion {
    private int idAccion;
    private String nombre;
    private String activo;
    private String materia;
    private int cuatrimestre;
    private String maestro;
    
    public Accion(int idAccion, String nombre, String activo, String materia,
            int cuatrimestre, String maestro){
        this.idAccion=idAccion;
        this.nombre=nombre;
        this.activo=activo;
        this.materia=materia;
        this.cuatrimestre=cuatrimestre;
        this.maestro=maestro;
    }
    public Accion(){
        this(0,"","","",0,"");
    }

    

    public void setIdAccion(int idAccion) {
        this.idAccion = idAccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public void setCuatrimestre(int cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public void setMaestro(String maestro) {
        this.maestro = maestro;
    }

    public int getIdAccion() {
        return idAccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getActivo() {
        return activo;
    }

    public String getMateria() {
        return materia;
    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public String getMaestro() {
        return maestro;
    }

    @Override
    public String toString() {
        return "Accion{" + "idAccion=" + idAccion + ", nombre=" + nombre + ", activo=" + activo + ", materia=" + materia + ", cuatrimestre=" + cuatrimestre + ", maestro=" + maestro + '}';
    }
    
    
}
