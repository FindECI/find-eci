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
@Table(name="intereses")
public class Intereses implements Serializable {

	@Column(name="usuario", nullable = false)
    @Size(min = 1, max = 100)
    private String usuario;
    
    @Id
	@Column(name="id")
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;	
    
	@Column(name="tipoRelacion",nullable = false)
	@Size(min = 1, max = 100)
    private String tipoRel;
    
	@Column(name="aspectosImportantes",nullable = false)
	@Size(min = 1, max = 100)
    private String apectosImportantes;
	
	@Column(name="sexoInteres",nullable = false)
	@Size(min = 1, max = 100)
    private String sexoInteres;

    public Intereses() {
    }

    public Intereses(String usuario, String sexoInteres, String tipoRel, String apectosImportantes) {
        this.usuario = usuario;
        this.sexoInteres = sexoInteres;
        this.tipoRel = tipoRel;
        this.apectosImportantes = apectosImportantes;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSexoInteres() {
        return sexoInteres;
    }

    public void setSexoInteres(String sexoInteres) {
        this.sexoInteres = sexoInteres;
    }

    public String getTipoRel() {
        return tipoRel;
    }

    public void setTipoRel(String tipoRel) {
        this.tipoRel = tipoRel;
    }

    public String getApectosImportantes() {
        return apectosImportantes;
    }

    public void setApectosImportantes(String apectosImportantes) {
        this.apectosImportantes = apectosImportantes;
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


    @Override
    public String toString() {
        return "Intereses{" + "id=" + id + "usuario=" + usuario + ", sexoInteres=" + sexoInteres + ", tipoRel=" + tipoRel + ", apectosImportantes=" + apectosImportantes + '}';
    }
    
    
   
}
