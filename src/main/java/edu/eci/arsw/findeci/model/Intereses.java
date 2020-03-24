/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author andres.quintero-d
 */
@Entity
public class Intereses implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name="correo", nullable = false)
    private Usuario usuario;
    
    @Column 
    private Genero sexoInteres;
    
    @Column
    private TipoRelacion tipoRel;
    
    @Column 
    private String apectosImportantes;

    public Intereses() {
    }

    public Intereses(Usuario usuario, Genero sexoInteres, TipoRelacion tipoRel, String apectosImportantes) {
        this.usuario = usuario;
        this.sexoInteres = sexoInteres;
        this.tipoRel = tipoRel;
        this.apectosImportantes = apectosImportantes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Genero getSexoInteres() {
        return sexoInteres;
    }

    public void setSexoInteres(Genero sexoInteres) {
        this.sexoInteres = sexoInteres;
    }

    public TipoRelacion getTipoRel() {
        return tipoRel;
    }

    public void setTipoRel(TipoRelacion tipoRel) {
        this.tipoRel = tipoRel;
    }

    public String getApectosImportantes() {
        return apectosImportantes;
    }

    public void setApectosImportantes(String apectosImportantes) {
        this.apectosImportantes = apectosImportantes;
    }

    @Override
    public String toString() {
        return "Intereses{" + "usuario=" + usuario + ", sexoInteres=" + sexoInteres + ", tipoRel=" + tipoRel + ", apectosImportantes=" + apectosImportantes + '}';
    }
   
}
