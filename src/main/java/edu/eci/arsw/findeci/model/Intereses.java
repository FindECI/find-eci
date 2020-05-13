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
    
	@Column(name="tipo_relacion",nullable = false)
	@Size(min = 1, max = 100)
    private String tipo_relacion;
    
	@Column(name="aspectos_importantes",nullable = false)
	@Size(min = 1, max = 100)
    private String aspectos_importantes;
	
	@Column(name="sexo_interes",nullable = false)
	@Size(min = 1, max = 100)
    private String sexo_interes;

    public Intereses() {
    }

    public Intereses(String usuario, String sexoInteres, String tipoRel, String apectosImportantes) {
        this.usuario = usuario;
        this.sexo_interes = sexoInteres;
        this.tipo_relacion = tipoRel;
        this.aspectos_importantes = apectosImportantes;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSexoInteres() {
        return sexo_interes;
    }

    public void setSexoInteres(String sexoInteres) {
        this.sexo_interes = sexoInteres;
    }

    public String getTipoRel() {
        return tipo_relacion;
    }

    public void setTipoRel(String tipoRel) {
        this.tipo_relacion = tipoRel;
    }

    public String getApectosImportantes() {
        return aspectos_importantes;
    }

    public void setApectosImportantes(String apectosImportantes) {
        this.aspectos_importantes = apectosImportantes;
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


    @Override
    public String toString() {
        return "Intereses{" + "id=" + id + "usuario=" + usuario + ", sexoInteres=" + sexo_interes + ", tipoRel=" + tipo_relacion + ", apectosImportantes=" + aspectos_importantes + '}';
    }
    
    
   
}
