/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Andrés Quintero
 */


@Entity
@Table(name="Matches")
public class Matches implements Serializable{
   
    
	
	
	@Id
	@Column(name="id")
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	    

	@Column(name="usuario", nullable = false)
    @Size(min = 1, max = 100)
    private String usuario;
	
	@Column(name="pareja", nullable = false)
    @Size(min = 1, max = 100)
    private String pareja;
    
    @Column(name="fecha",nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaMatch;

    public Matches(String usuario, String pareja, Date fechaMatch) {
        this.usuario = usuario;
        this.pareja = pareja;
        this.fechaMatch = fechaMatch;
    }

    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPareja() {
        return pareja;
    }

    public void setPareja(String pareja) {
        this.pareja = pareja;
    }

    public Date getFechaMatch() {
        return fechaMatch;
    }

    public void setFechaMatch(Date fechaMatch) {
        this.fechaMatch = fechaMatch;
    }

    @Override
    public String toString() {
        return "Match{" + "usuario=" + usuario + ", pareja=" + pareja + ", fechaMatch=" + fechaMatch + '}';
    }
    
    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
    
    
    
}
