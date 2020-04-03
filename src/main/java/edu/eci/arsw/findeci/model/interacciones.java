package edu.eci.arsw.findeci.model;

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

@Entity
@Table(name="interacciones")
public class interacciones {

	@Id
	@Column(name="id",nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Size(min = 1, max = 1000)
	private int id;
	
	
	@Column(name="usuario", nullable = false)
    @Size(min = 1, max = 100)
    private String usuario;
	
	@Column(name="pareja", nullable = false)
    @Size(min = 1, max = 100)
    private String pareja;
	
	@Column(name="likes",nullable = false)
	@NotNull
	private int likes;
	
	
	public interacciones(int id,int likes) {
		
		this.id=id;
		this.likes=likes;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public int getLikes() {
		return likes;
	}


	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	
	
	
}
