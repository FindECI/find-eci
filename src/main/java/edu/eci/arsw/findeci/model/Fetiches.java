/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author andres.quintero-d
 */
@Entity
@Table(name="fetiches")
public class Fetiches implements Serializable {

	@Column(name="usuario", nullable = false)
    @Size(min = 1, max = 100)
    private String usuario;
    
	@Id
	@Column(name="id")
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idFetiche;
    
    @Column(name="nombre", nullable = false)
    @Size(min = 1, max = 100)
    private String nombre;
    
    @Column(name="descripcion", nullable = false)
    @Size(min = 1, max = 100)
    private String descripcion;

    public Fetiches() {
    }

    public Fetiches(String usuario, Integer idFetiche, String nombre, String descripcion) {
        this.usuario = usuario;
        this.idFetiche = idFetiche;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getIdFetiche() {
        return idFetiche;
    }

    public void setIdFetiche(Integer idFetiche) {
        this.idFetiche = idFetiche;
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
        return "Fetiches{" + "usuario=" + usuario + ", idFetiche=" + idFetiche + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    

}
