package edu.eci.arsw.findeci.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="gustos")
public class gustos implements Serializable {

	
	@Column(name="descripciongusto", nullable = false)
	@Size(min = 1, max = 1000)
	private String descripciongusto;
	
	@Id
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Usuario usuario;
	
	@Id
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private tipoGusto tipgusto;
	
	
	public gustos(String descripciongusto) {
		this.descripciongusto = descripciongusto;
	}


	public String getDescripciongusto() {
		return descripciongusto;
	}


	public void setDescripciongusto(String descripciongusto) {
		this.descripciongusto = descripciongusto;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public tipoGusto getTipgusto() {
		return tipgusto;
	}


	public void setTipgusto(tipoGusto tipgusto) {
		this.tipgusto = tipgusto;
	}
	
	
	
}
