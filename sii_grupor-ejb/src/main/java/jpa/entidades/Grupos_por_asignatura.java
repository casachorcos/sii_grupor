package jpa.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Grupo_por_asignatura
 *
 */
@Entity

@IdClass(Grupos_por_asignatura.Grupos_por_asignaturaId.class)
public class Grupos_por_asignatura implements Serializable {

	public static class Grupos_por_asignaturaId implements Serializable {
		private int curso_academico;
		private int asignatura;
		private String grupo;
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + asignatura;
			result = prime * result + curso_academico;
			result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
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
			Grupos_por_asignaturaId other = (Grupos_por_asignaturaId) obj;
			if (asignatura != other.asignatura)
				return false;
			if (curso_academico != other.curso_academico)
				return false;
			if (grupo == null) {
				if (other.grupo != null)
					return false;
			} else if (!grupo.equals(other.grupo))
				return false;
			return true;
		}
	}
	
	private static final long serialVersionUID = 13L;
	
	@Id @Column (name = "Curso_académico")
	private int curso_academico;
	@Column (name = "Oferta", length = 10)
	private String oferta;

	@Id
	@ManyToOne
	private Asignatura asignatura;
	
	@Id
	@ManyToOne
	private Grupo grupo;
	
	@ManyToMany (mappedBy = "grupo_asig")//, cascade = CascadeType.PERSIST)
	private List<Encuesta> encuesta;

	public Grupos_por_asignatura() {
		super();
	}

	public int getCurso_academico() {
		return curso_academico;
	}

	public void setCurso_academico(int curso_academico) {
		this.curso_academico = curso_academico;
	}

	public String getOferta() {
		return oferta;
	}

	public void setOferta(String oferta) {
		this.oferta = oferta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + curso_academico;
		result = prime * result + ((oferta == null) ? 0 : oferta.hashCode());
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
		Grupos_por_asignatura other = (Grupos_por_asignatura) obj;
		if (curso_academico != other.curso_academico)
			return false;
		if (oferta == null) {
			if (other.oferta != null)
				return false;
		} else if (!oferta.equals(other.oferta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Grupos_por_asignatura [curso_academico=" + curso_academico + ", oferta=" + oferta + "]";
	}
	
	
	
}
