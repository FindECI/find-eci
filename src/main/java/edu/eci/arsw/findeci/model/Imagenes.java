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
import javax.validation.constraints.Size;

@Entity
@Table(name="imagenes")
public class Imagenes  implements Serializable{
	
	@Id
	@Column(name="id",nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Size(min = 1, max = 1000)
	private int id;
	
	
	@Column(name="imagen",nullable = false)
	@Size(min = 1, max = 1000)
	private String imagen;
	
	@Column(name="usuario", nullable = false)
    @Size(min = 1, max = 100)
    private String usuario;
	
	
	public Imagenes (String imagen, String usuario) {
		
		this.imagen = imagen;
		this.usuario = usuario;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
