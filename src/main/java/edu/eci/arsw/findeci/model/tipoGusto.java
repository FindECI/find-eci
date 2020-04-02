package edu.eci.arsw.findeci.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="tipo_gusto")
public class tipoGusto {
	
	@Id
	@Column(name="id_tipoGusto")
	@Size(min = 1, max = 100)
	private int id_tipoGusto;
	
	
	@Column(name="tipogusto")
	private TipoGustos tipogusto;
	
	
    
    public tipoGusto(int id,TipoGustos tipogusto) {
    	
    	this.id_tipoGusto = id;
    	this.tipogusto = tipogusto;
    }

	public int getId_tipoGusto() {
		return id_tipoGusto;
	}

	public void setId_tipoGusto(int id_tipoGusto) {
		this.id_tipoGusto = id_tipoGusto;
	}

	public TipoGustos getTipogusto() {
		return tipogusto;
	}

	public void setTipogusto(TipoGustos tipogusto) {
		this.tipogusto = tipogusto;
	}

	
}
