/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author andres.quintero-d
 */
@Entity
public class GustosMusica implements Serializable {
    
    @ManyToOne
    @JoinColumn(name="correo", nullable = false)
    private Usuario usuario;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGenMusic;
    
    @Column 
    private String nombre;
    
    @Column
    private String descripcion;

    public GustosMusica() {
    }

    public GustosMusica(Usuario usuario, Integer idGenMusic, String nombre, String descripcion) {
        this.usuario = usuario;
        this.idGenMusic = idGenMusic;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getIdGenMusic() {
        return idGenMusic;
    }

    public void setIdGenMusic(Integer idGenMusic) {
        this.idGenMusic = idGenMusic;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "GustosComida{" + "usuario=" + usuario + ", idGenMusic=" + idGenMusic + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
    
}
