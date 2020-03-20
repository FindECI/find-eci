/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Andrés Quintero
 */
@Entity
@Table(name = "usuario")

    
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellido")
    private String apellido;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "correo")
    private String correo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "contraseña")
    private String contraseña;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaNacimiento")
    private Date fechaNacimiento;
    
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
    
    @OneToMany(mappedBy = "usuario")
    private List<Carrera> carrera;
    
    @OneToMany(mappedBy = "usuario")
    private List<Fetiches> fetiches;
    
    @OneToMany(mappedBy = "usuario")
    private List<GustosComida> gustosComida;
    
    @OneToMany(mappedBy = "usuario")
    private List<GustosPeliculas> gustosPeliculas;
    
    @OneToMany(mappedBy = "usuario")
    private List<GustosMusica> gustosMusica;
    
    @OneToMany(mappedBy = "usuario")
    private List<Intereses> intereses;
    
    @OneToMany(mappedBy = "usuario")
    private List<Match> matches;

    public Usuario() {
    }

    public Usuario(String correo) {
        this.correo = correo;
    }

    public Usuario(String correo, String nombre, String contraseña, Date fechaNacimiento, String sexo, short altura, long celular, String cuentaig) {
        this.correo = correo;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.fechaNacimiento = fechaNacimiento;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public List<Carrera> getCarrera() {
        return carrera;
    }

    public void setCarrera(List<Carrera> carrera) {
        this.carrera = carrera;
    }

    public List<Fetiches> getFetiches() {
        return fetiches;
    }

    public void setFetiches(List<Fetiches> fetiches) {
        this.fetiches = fetiches;
    }

    public List<GustosComida> getGustosComida() {
        return gustosComida;
    }

    public void setGustosComida(List<GustosComida> gustosComida) {
        this.gustosComida = gustosComida;
    }

    public List<GustosPeliculas> getGustosPeliculas() {
        return gustosPeliculas;
    }

    public void setGustosPeliculas(List<GustosPeliculas> gustosPeliculas) {
        this.gustosPeliculas = gustosPeliculas;
    }

    public List<GustosMusica> getGustosMusica() {
        return gustosMusica;
    }

    public void setGustosMusica(List<GustosMusica> gustosMusica) {
        this.gustosMusica = gustosMusica;
    }

    public List<Intereses> getIntereses() {
        return intereses;
    }

    public void setIntereses(List<Intereses> intereses) {
        this.intereses = intereses;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    
   
}
