package jpa.entidades;


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
	private Integer referencia;
	@Column (name = "Código", nullable = false)
	private Integer codigo;
	@Column (name = "Créditos", nullable = false, length = 5)
	private String creditos;
	@Column (name = "Ofertada", nullable = false, length = 3)
	private String ofertada;
	@Column (name = "Nombre", nullable = false, length = 100)
	private String nombre;
	@Column (name = "Curso")
	private Integer curso;
	@Column (name = "Carácter", length = 20)
	private String caracter;
	@Column (name = "Duración", length = 20)
	private String duracion;
	@Column (name = "Unidad_Temporal", nullable = false, length = 10)
	private String unidad_temporal;
	@Column (name = "Idiomas_de_impartición", nullable = false, length = 20)
	private String idiomas;
	
	@ManyToOne
	private Titulacion titulacion; 							//Relacion ManyToOne entre Asignatura y Titulacion
	@OneToMany (mappedBy="asignatura", cascade = CascadeType.PERSIST)
	private List<Clase> clase;								//Relacion OneToMany entre Asignatura y Clase
	@OneToMany (mappedBy = "asignatura", cascade = CascadeType.PERSIST)
	private List<Asignaturas_Matricula> asig_matricula;		//Relacion OneToMany entre Asignatura y Asignaturas_Matricula
	@OneToMany (mappedBy = "asignatura", cascade = CascadeType.PERSIST)
	private List<Grupos_por_asignatura> grupos_asig;		//Relacion OneToMany entre Asignatura y Grupos_por_asignatura
	
	
	
	public Asignatura(Integer referencia, Integer codigo, String creditos, String ofertada, String nombre, Integer curso, String caracter, String duracion, String unidad_temporal, String idiomas) {
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

	public Integer getReferencia() {
		return referencia;
	}

	public void setReferencia(Integer referencia) {
		this.referencia = referencia;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCreditos() {
		return creditos;
	}

	public void setCreditos(String creditos) {
		this.creditos = creditos;
	}

	public String getOfertada() {
		return ofertada;
	}

	public void setOfertada(String ofertada) {
		this.ofertada = ofertada;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
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

	public Titulacion getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
	}

	public List<Clase> getClase() {
		return clase;
	}

	public void setClase(List<Clase> clase) {
		this.clase = clase;
	}

	public List<Asignaturas_Matricula> getAsig_matricula() {
		return asig_matricula;
	}

	public void setAsig_matricula(List<Asignaturas_Matricula> asig_matricula) {
		this.asig_matricula = asig_matricula;
	}

	public List<Grupos_por_asignatura> getGrupos_asig() {
		return grupos_asig;
	}

	public void setGrupos_asig(List<Grupos_por_asignatura> grupos_asig) {
		this.grupos_asig = grupos_asig;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caracter == null) ? 0 : caracter.hashCode());
		result = prime * result + ((clase == null) ? 0 : clase.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((creditos == null) ? 0 : creditos.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((duracion == null) ? 0 : duracion.hashCode());
		result = prime * result + ((grupos_asig == null) ? 0 : grupos_asig.hashCode());
		result = prime * result + ((idiomas == null) ? 0 : idiomas.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((ofertada == null) ? 0 : ofertada.hashCode());
		result = prime * result + ((referencia == null) ? 0 : referencia.hashCode());
		result = prime * result + ((titulacion == null) ? 0 : titulacion.hashCode());
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
		if (clase == null) {
			if (other.clase != null)
				return false;
		} else if (!clase.equals(other.clase))
			return false;
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
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (duracion == null) {
			if (other.duracion != null)
				return false;
		} else if (!duracion.equals(other.duracion))
			return false;
		if (grupos_asig == null) {
			if (other.grupos_asig != null)
				return false;
		} else if (!grupos_asig.equals(other.grupos_asig))
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
		if (ofertada == null) {
			if (other.ofertada != null)
				return false;
		} else if (!ofertada.equals(other.ofertada))
			return false;
		if (referencia == null) {
			if (other.referencia != null)
				return false;
		} else if (!referencia.equals(other.referencia))
			return false;
		if (titulacion == null) {
			if (other.titulacion != null)
				return false;
		} else if (!titulacion.equals(other.titulacion))
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
				+ duracion + ", unidad_temporal=" + unidad_temporal + ", idiomas=" + idiomas + ", titulacion="
				+ titulacion + ", clase=" + clase + ", asig_matricula=" + asig_matricula + ", grupos_asig="
				+ grupos_asig + "]";
	}
}
