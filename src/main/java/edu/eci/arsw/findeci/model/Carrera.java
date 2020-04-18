package edu.eci.arsw.findeci.model;
import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="carrera")
public class Carrera implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name="id")
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="usuario", nullable = false)
    @Size(min = 1, max = 100)
    private String usuario;

    @Column(name="nombre", nullable = false)
    @Size(min = 1, max = 100)
    private String nombre;

    @Column(name="semestre", nullable = false)
    @NotNull
    private Integer semestre;

    

    public Carrera() {
    }

    public Carrera(String usuario, String nombre, Integer semestre) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.semestre = semestre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUusario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

        
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    @Override
    public String toString() {
        return "Carrera{" + "usuario=" + usuario + ", nombre=" + nombre + ", semestre=" + semestre +  '}';
    }
 
    
}