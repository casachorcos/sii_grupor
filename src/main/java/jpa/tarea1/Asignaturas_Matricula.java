package jpa.tarea1;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Asignaturas_Matricula
 *
 */
@Entity

@IdClass(Asignaturas_Matricula.Asignaturas_MatriculaId.class)
public class Asignaturas_Matricula implements Serializable {

	public static class Asignaturas_MatriculaId implements Serializable {
		private int matricula;
		private int asignatura;
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + asignatura;
			result = prime * result + matricula;
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
			Asignaturas_MatriculaId other = (Asignaturas_MatriculaId) obj;
			if (asignatura != other.asignatura)
				return false;
			if (matricula != other.matricula)
				return false;
			return true;
		}
	}
	
	private static final long serialVersionUID = 1L;
	
	@Column (name = "Grupos_asignados", length = 150)
	private String grupos_asignados;
	
	@Id
	@ManyToOne
	private Asignatura asignatura;
	
	@Id
	@ManyToOne
	private Matricula matricula;

	public String getGrupos_asignados() {
		return grupos_asignados;
	}

	public void setGrupos_asignados(String grupos_asignados) {
		this.grupos_asignados = grupos_asignados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grupos_asignados == null) ? 0 : grupos_asignados.hashCode());
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
		Asignaturas_Matricula other = (Asignaturas_Matricula) obj;
		if (grupos_asignados == null) {
			if (other.grupos_asignados != null)
				return false;
		} else if (!grupos_asignados.equals(other.grupos_asignados))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Asignaturas_Matricula [grupos_asignados=" + grupos_asignados + "]";
	}
}
