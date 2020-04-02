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
import javax.validation.constraints.Size;

/**
 *
 * @author Andrés Quintero
 */


@Entity
@Table(name="Matches")
public class Matches implements Serializable{
   
    
	
	
	@Id
	@Column(name="id",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Size(min = 1, max = 1000)
	private int id;
	    

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Usuario usuario;
    
    
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Usuario pareja;
    
    @Column(name="fecha",nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaMatch;

    public Matches(Usuario usuario, Usuario pareja, Date fechaMatch) {
        this.usuario = usuario;
        this.pareja = pareja;
        this.fechaMatch = fechaMatch;
    }

    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getPareja() {
        return pareja;
    }

    public void setPareja(Usuario pareja) {
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
