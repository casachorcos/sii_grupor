package jpa.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Titulacion
 *
 */
@Entity
public class Titulacion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 12L;
	@Id @Column (name = "Código")
	private Integer codigo;
	@Column (name = "Nombre", nullable = false, length = 50)
	private String nombre;
	@Column (name = "Créditos", nullable = false)
	private Double creditos;
	
	@OneToMany (mappedBy="titulacion")//, cascade = CascadeType.PERSIST)
	private List<Asignatura> asignaturas; 	//Relación OneToMany de Titulacion a Asignaturas
	@OneToMany (mappedBy="titulacion")//, cascade = CascadeType.PERSIST)
	private List<Expediente> expediente; 	//Relación OneToMany de Titulacion a Expediente
	@OneToMany (mappedBy="titulacion")//, cascade = CascadeType.PERSIST)
	private List<Grupo> grupo; 				//Relación OneToMany de Titulacion a Grupo
	@ManyToMany (mappedBy = "titulacion")//, cascade = CascadeType.PERSIST)
	private List<Centro> centro; 			//Relacion ManyToMany con Centro
	
	public Titulacion(Integer codigo, String nombre, Double creditos) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.creditos = creditos;
		
	}
	
	public Titulacion() {
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getCreditos() {
		return creditos;
	}
	public void setCreditos(Double creditos) {
		this.creditos = creditos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((creditos == null) ? 0 : creditos.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Titulacion other = (Titulacion) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (creditos == null) {
			if (other.creditos != null)
				return false;
		} else if (!creditos.equals(other.creditos))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Titulacion [codigo=" + codigo + ", nombre=" + nombre + ", creditos=" + creditos + "]";
	}
	
}
