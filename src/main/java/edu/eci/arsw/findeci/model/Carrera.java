package edu.eci.arsw.findeci.model;
import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Carrera implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name="correo", nullable = false)
    private Usuario usuario;

    @Column
    private String nombre;

    @Column
    private Integer semestre;

    @Column
    private Integer anoIngreso;

    public Carrera() {
    }

    public Carrera(Usuario usuario, String nombre, Integer semestre, Integer anoIngreso) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.semestre = semestre;
        this.anoIngreso = anoIngreso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUusario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getAnoIngreso() {
        return anoIngreso;
    }

    public void setAnoIngreso(Integer anoIngreso) {
        this.anoIngreso = anoIngreso;
    }
}