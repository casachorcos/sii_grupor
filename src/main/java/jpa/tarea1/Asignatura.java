package jpa.tarea1;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Asignatura
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Asignatura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	@Id @Column (name = "Referencia")
	private int referencia;
	@Column (name = "Código", nullable = false)
	private int codigo;
	@Column (name = "Créditos", nullable = false)
	private double creditos;
	@Column (name = "Ofertada", nullable = false)
	private char ofertada;
	@Column (name = "Nombre", nullable = false, length = 100)
	private String nombre;
	@Column (name = "Curso")
	private int curso;
	@Column (name = "Carácter", length = 20)
	private String caracter;
	@Column (name = "Duración", length = 20)
	private String duracion;
	@Column (name = "Unidad_Temporal(Cuatrimestre)", nullable = false, length = 10)
	private String unidad_temporal;
	@Column (name = "Idiomas_de_impartición", nullable = false, length = 20)
	private String idiomas;
	
	@ManyToOne
	private Titulacion titulacion; //Relacion ManyToOne entre Asignatura y Titulacion
	@OneToMany (mappedBy="asignatura")
	private List<Clase> clase;
	
	
	
	public Asignatura(int referencia, int codigo, double creditos, char ofertada, String nombre, int curso, String caracter, String duracion, String unidad_temporal, String idiomas) {
		super();
		this.referencia = referencia;
		this.codigo = codigo;
		this.creditos = creditos;
		this.ofertada = ofertada;
		this.nombre = nombre;
		this.curso = curso;
		this.caracter = caracter;
		this.duracion = duracion;
		this.unidad_temporal = unidad_temporal;
		this.idiomas = idiomas;
	}
	
	public Asignatura() {
	}
	
	public int getReferencia() {
		return referencia;
	}
	public void setReferencia(int referencia) {
		this.referencia = referencia;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getCreditos() {
		return creditos;
	}
	public void setCreditos(double creditos) {
		this.creditos = creditos;
	}
	public char getOfertada() {
		return ofertada;
	}
	public void setOfertada(char ofertada) {
		this.ofertada = ofertada;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	public String getCaracter() {
		return caracter;
	}
	public void setCaracter(String caracter) {
		this.caracter = caracter;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public String getUnidad_temporal() {
		return unidad_temporal;
	}
	public void setUnidad_temporal(String unidad_temporal) {
		this.unidad_temporal = unidad_temporal;
	}
	public String getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caracter == null) ? 0 : caracter.hashCode());
		result = prime * result + codigo;
		long temp;
		temp = Double.doubleToLongBits(creditos);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + curso;
		result = prime * result + ((duracion == null) ? 0 : duracion.hashCode());
		result = prime * result + ((idiomas == null) ? 0 : idiomas.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ofertada;
		result = prime * result + referencia;
		result = prime * result + ((unidad_temporal == null) ? 0 : unidad_temporal.hashCode());
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
		Asignatura other = (Asignatura) obj;
		if (caracter == null) {
			if (other.caracter != null)
				return false;
		} else if (!caracter.equals(other.caracter))
			return false;
		if (codigo != other.codigo)
			return false;
		if (Double.doubleToLongBits(creditos) != Double.doubleToLongBits(other.creditos))
			return false;
		if (curso != other.curso)
			return false;
		if (duracion == null) {
			if (other.duracion != null)
				return false;
		} else if (!duracion.equals(other.duracion))
			return false;
		if (idiomas == null) {
			if (other.idiomas != null)
				return false;
		} else if (!idiomas.equals(other.idiomas))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (ofertada != other.ofertada)
			return false;
		if (referencia != other.referencia)
			return false;
		if (unidad_temporal == null) {
			if (other.unidad_temporal != null)
				return false;
		} else if (!unidad_temporal.equals(other.unidad_temporal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Asignatura [referencia=" + referencia + ", codigo=" + codigo + ", creditos=" + creditos + ", ofertada="
				+ ofertada + ", nombre=" + nombre + ", curso=" + curso + ", caracter=" + caracter + ", duracion="
				+ duracion + ", unidad_temporal=" + unidad_temporal + ", idiomas=" + idiomas + "]";
	}
}
