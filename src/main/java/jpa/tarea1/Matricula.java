package jpa.tarea1;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
/**
 * Entity implementation class for Entity: Matricula
 *
 */
@Entity

@IdClass(Matricula.MatriculaId.class)
public class Matricula implements Serializable {

	
	public static class MatriculaId implements Serializable {
		private int curso;
		private int expediente;
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + curso;
			result = prime * result + expediente;
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
			MatriculaId other = (MatriculaId) obj;
			if (curso != other.curso)
				return false;
			if (expediente != other.expediente)
				return false;
			return true;
		}
	}
	
	private static final long serialVersionUID = 10L;
	@Id @Column (name = "Curso_academico")
	private int curso;
	@Column (name = "Estado", nullable = false)
	private char estado;
	@Column (name = "Num_Archivo")
	private int nArchivo;
	@Column (name = "Turno_preferente", length=10)
	private String turno;
	@Column (name = "Fecha_de_matricula", nullable = false)
	@Temporal (TemporalType.DATE)
	private Date fecha_matr;
	@Column (name = "Nuevo_Ingreso")
	private char nuevoIngreso;
	@Column (name = "Listado_Asignaturas", length=50)
	private String listaAsig;
	
	@OneToMany (mappedBy = "matricula")
	private List<Asignaturas_Matricula> asig_matricula;		//Relacion OneToMany entre Matricula y Asignaturas_Matricula
	
	@Id
	@ManyToOne
	private Expediente expediente;
	
	public Matricula(int c, char e, int na, String t, Date fm, char ni, String la) {
		super();
		curso = c;
		estado = e;
		nArchivo = na;
		turno = t;
		fecha_matr = fm;
		nuevoIngreso = ni;
		listaAsig = la;
	}
	
	public Matricula() {
		
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public int getnArchivo() {
		return nArchivo;
	}

	public void setnArchivo(int nArchivo) {
		this.nArchivo = nArchivo;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Date getFecha_matr() {
		return fecha_matr;
	}

	public void setFecha_matr(Date fecha_matr) {
		this.fecha_matr = fecha_matr;
	}

	public char getNuevoIngreso() {
		return nuevoIngreso;
	}

	public void setNuevoIngreso(char nuevoIngreso) {
		this.nuevoIngreso = nuevoIngreso;
	}

	public String getListaAsig() {
		return listaAsig;
	}

	public void setListaAsig(String listaAsig) {
		this.listaAsig = listaAsig;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + curso;
		result = prime * result + estado;
		result = prime * result + ((fecha_matr == null) ? 0 : fecha_matr.hashCode());
		result = prime * result + ((listaAsig == null) ? 0 : listaAsig.hashCode());
		result = prime * result + nArchivo;
		result = prime * result + nuevoIngreso;
		result = prime * result + ((turno == null) ? 0 : turno.hashCode());
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
		Matricula other = (Matricula) obj;
		if (curso != other.curso)
			return false;
		if (estado != other.estado)
			return false;
		if (fecha_matr == null) {
			if (other.fecha_matr != null)
				return false;
		} else if (!fecha_matr.equals(other.fecha_matr))
			return false;
		if (listaAsig == null) {
			if (other.listaAsig != null)
				return false;
		} else if (!listaAsig.equals(other.listaAsig))
			return false;
		if (nArchivo != other.nArchivo)
			return false;
		if (nuevoIngreso != other.nuevoIngreso)
			return false;
		if (turno == null) {
			if (other.turno != null)
				return false;
		} else if (!turno.equals(other.turno))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Matricula [curso=" + curso + ", estado=" + estado + ", nArchivo=" + nArchivo + ", turno=" + turno
				+ ", fecha_matr=" + fecha_matr + ", nuevoIngreso=" + nuevoIngreso + ", listaAsig=" + listaAsig + "]";
	}
   
	
	
}
