package edu.eci.arsw.findeci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "mensajes")
public class mensajes {

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

	@Column(name="mensaje", nullable = false)
    @Size(min = 1, max = 1000)
	private String mensaje;

	@NotNull
    @Column(name = "chat")
    private int chat;
	
	@Column(name="fecha",nullable = false)
    private Date fecha;
	
	@Column(name="bandera")
    @NotNull
	private int bandera;

	public mensajes() {

	}

	public mensajes(String usuario,String pareja,String mensaje,int chat) {
		this.mensaje = mensaje;
		this.usuario = usuario;
		this.pareja = pareja;
		this.chat = chat;
	}
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getPareja() {
		return pareja;
	}

	public void setPareja(String pareja) {
		this.pareja = pareja;
	}

	public int getChat() {
		return chat;
	}

	public void setChat(int chat) {
		this.chat = chat;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	

	public int getBandera() {
		return bandera;
	}

	public void setBandera(int bandera) {
		this.bandera = bandera;
	}	

}
