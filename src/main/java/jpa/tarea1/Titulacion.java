package jpa.tarea1;

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
	private int codigo;
	@Column (name = "Nombre", nullable = false, length = 50)
	private String nombre;
	@Column (name = "Créditos", nullable = false)
	private double creditos;
	
	@OneToMany (mappedBy="titulacion")
	private List<Asignatura> asignaturas; 	//Relación OneToMany de Titulacion a Asignaturas
	@OneToMany (mappedBy="titulacion")
	private List<Expediente> expediente; 	//Relación OneToMany de Titulacion a Expediente
	@OneToMany (mappedBy="titulacion")
	private List<Grupo> grupo; 				//Relación OneToMany de Titulacion a Grupo
	@ManyToMany(mappedBy = "titulacion")
	private List<Centro> centro; 			//Relacion ManyToMany con Centro
	
	public Titulacion(int codigo, String nombre, double creditos) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.creditos = creditos;
		
	}
	
	public Titulacion() {
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getCreditos() {
		return creditos;
	}
	public void setCreditos(double creditos) {
		this.creditos = creditos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		long temp;
		temp = Double.doubleToLongBits(creditos);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (codigo != other.codigo)
			return false;
		if (Double.doubleToLongBits(creditos) != Double.doubleToLongBits(other.creditos))
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
