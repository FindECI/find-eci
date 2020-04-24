package edu.eci.arsw.findeci.model;

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

	@Column(name="mensaje", nullable = false)
    @Size(min = 1, max = 1000)
	private String mensaje;

	@NotNull
    @Column(name = "chat")
    private int chat;
	
	

	public mensajes() {

	}

	public mensajes(String usuario,String mensaje,int chat) {
		this.mensaje = mensaje;
		this.usuario = usuario;
		this.chat = chat;
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

}
