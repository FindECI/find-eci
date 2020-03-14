/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrés Quintero
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuarios.findByCorreo", query = "SELECT u FROM Usuarios u WHERE u.correo = :correo"),
    @NamedQuery(name = "Usuarios.findByContrase\u00f1a", query = "SELECT u FROM Usuarios u WHERE u.contrase\u00f1a = :contrase\u00f1a"),
    @NamedQuery(name = "Usuarios.findByEdad", query = "SELECT u FROM Usuarios u WHERE u.edad = :edad"),
    @NamedQuery(name = "Usuarios.findBySexo", query = "SELECT u FROM Usuarios u WHERE u.sexo = :sexo"),
    @NamedQuery(name = "Usuarios.findByAltura", query = "SELECT u FROM Usuarios u WHERE u.altura = :altura"),
    @NamedQuery(name = "Usuarios.findByCelular", query = "SELECT u FROM Usuarios u WHERE u.celular = :celular"),
    @NamedQuery(name = "Usuarios.findByCuentaig", query = "SELECT u FROM Usuarios u WHERE u.cuentaig = :cuentaig")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "contrase\u00f1a")
    private String contraseña;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private short edad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "altura")
    private short altura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "celular")
    private long celular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cuentaig")
    private String cuentaig;

    public Usuarios() {
    }

    public Usuarios(String correo) {
        this.correo = correo;
    }

    public Usuarios(String correo, String nombre, String contraseña, short edad, String sexo, short altura, long celular, String cuentaig) {
        this.correo = correo;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.edad = edad;
        this.sexo = sexo;
        this.altura = altura;
        this.celular = celular;
        this.cuentaig = cuentaig;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public short getEdad() {
        return edad;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public short getAltura() {
        return altura;
    }

    public void setAltura(short altura) {
        this.altura = altura;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public String getCuentaig() {
        return cuentaig;
    }

    public void setCuentaig(String cuentaig) {
        this.cuentaig = cuentaig;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correo != null ? correo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.correo == null && other.correo != null) || (this.correo != null && !this.correo.equals(other.correo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.eci.arsw.findeci.Usuarios[ correo=" + correo + " ]";
    }
    
}
