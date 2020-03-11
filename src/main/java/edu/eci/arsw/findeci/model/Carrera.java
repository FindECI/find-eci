/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.model;

import java.io.Serializable;

public class Carrera implements Serializable{

    private String nombreCarrera;
    private int Semestre;
    private int anoIngreso;

    /**
     *
     * @param nombreCarrera
     * @param Semestre
     * @param a
     */
    public Carrera(String nombreCarrera, int Semestre, int anoIngreso) {
        this.nombreCarrera = nombreCarrera;
        this.Semestre = Semestre;
        this.anoIngreso = anoIngreso;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getSemestre() {
        return Semestre;
    }

    public void setSemestre(int Semestre) {
        this.Semestre = Semestre;
    }

    public int getAnoIngreso() {
        return anoIngreso;
    }

    public void setAnoIngreso(int anoIngreso) {
        this.anoIngreso = anoIngreso;
    }
    
    
}
