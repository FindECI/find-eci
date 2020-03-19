/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Andrés Quintero
 */
@Entity
public class Match implements Serializable{
    
    @Id
    @ManyToOne
    @JoinColumn(name="correo", nullable = false)
    private Usuario usuario;
    
    @Column 
    private Usuario pareja;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaMatch;

    public Match(Usuario usuario, Usuario pareja, Date fechaMatch) {
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
    
    
    
}
