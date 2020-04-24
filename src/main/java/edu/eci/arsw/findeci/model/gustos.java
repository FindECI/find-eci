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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="gustos")
public class gustos implements Serializable {

	
	@Id
	@Column(name="id")
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	@Column(name="descripciongusto", nullable = false)
	@Size(min = 1, max = 1000)
	private String descripciongusto;

	
	@Column(name="usuario", nullable = false)
    @Size(min = 1, max = 100)
    private String usuario;
	
	
	@Column(name="tipogusto", nullable = false)
	@NotNull
    private int tipogusto;
	
	
	public gustos() {
	}
	
	
	public gustos(String descripciongusto, String usuario,int tipogusto ) {
		this.descripciongusto = descripciongusto;
		this.tipogusto = tipogusto;
		this.usuario = usuario;
	}

	public String getDescripciongusto() {
		return descripciongusto;
	}


	public void setDescripciongusto(String descripciongusto) {
		this.descripciongusto = descripciongusto;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public int getTipgusto() {
		return tipogusto;
	}


	public void setTipgusto(int tipogusto) {
		this.tipogusto = tipogusto;
	}
	
	
	
}
