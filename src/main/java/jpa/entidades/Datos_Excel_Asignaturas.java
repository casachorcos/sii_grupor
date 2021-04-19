package jpa.entidades;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: Datos_Excel_Asignaturas
 *
 */
@Entity

public class Datos_Excel_Asignaturas {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column (name = "Titulación", nullable = false)
	private int titulacion;
	@Column (name = "Ofertada", nullable = false)
	private char ofertada;
	@Column (name = "Codigo", nullable = false)
	private int codigo;
	@Column (name = "Referencia",unique = true, nullable = false)
	private int referencia;
	@Column (name = "Asignatura", nullable = false)
	private String asignatura;
	@Column (name = "Curso", nullable = false)
	private int curso;
	@Column (name = "Creditos_teoría", nullable = false)
	private double credTeoria;
	@Column (name = "Creditos_práctica", nullable = false)
	private double credPractica;
	@Column (name = "Total_Créditos", nullable = false)
	private double credTotal;
	@Column (name = "Duración", nullable = false)
	private String duracion;
	@Column (name = "Plazas", nullable = true)
	private int plazas;
	@Column (name = "Otro_idioma", nullable = true)
	private String otrosIdiomas;
	

	public Datos_Excel_Asignaturas() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getTitulacion() {
		return titulacion;
	}


	public void setTitulacion(int titulacion) {
		this.titulacion = titulacion;
	}


	public char getOfertada() {
		return ofertada;
	}


	public void setOfertada(char ofertada) {
		this.ofertada = ofertada;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public int getReferencia() {
		return referencia;
	}


	public void setReferencia(int referencia) {
		this.referencia = referencia;
	}


	public String getAsignatura() {
		return asignatura;
	}


	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}


	public int getCurso() {
		return curso;
	}


	public void setCurso(int curso) {
		this.curso = curso;
	}


	public double getCredTeoria() {
		return credTeoria;
	}


	public void setCredTeoria(double credTeoria) {
		this.credTeoria = credTeoria;
	}


	public double getCredPractica() {
		return credPractica;
	}


	public void setCredPractica(double credPractica) {
		this.credPractica = credPractica;
	}


	public double getCredTotal() {
		return credTotal;
	}


	public void setCredTotal(double credTotal) {
		this.credTotal = credTotal;
	}


	public String getDuracion() {
		return duracion;
	}


	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}


	public int getPlazas() {
		return plazas;
	}


	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}


	public String getOtrosIdiomas() {
		return otrosIdiomas;
	}


	public void setOtrosIdiomas(String otrosIdiomas) {
		this.otrosIdiomas = otrosIdiomas;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asignatura == null) ? 0 : asignatura.hashCode());
		result = prime * result + codigo;
		long temp;
		temp = Double.doubleToLongBits(credPractica);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(credTeoria);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(credTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + curso;
		result = prime * result + ((duracion == null) ? 0 : duracion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ofertada;
		result = prime * result + ((otrosIdiomas == null) ? 0 : otrosIdiomas.hashCode());
		result = prime * result + plazas;
		result = prime * result + referencia;
		result = prime * result + titulacion;
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
		Datos_Excel_Asignaturas other = (Datos_Excel_Asignaturas) obj;
		if (asignatura == null) {
			if (other.asignatura != null)
				return false;
		} else if (!asignatura.equals(other.asignatura))
			return false;
		if (codigo != other.codigo)
			return false;
		if (Double.doubleToLongBits(credPractica) != Double.doubleToLongBits(other.credPractica))
			return false;
		if (Double.doubleToLongBits(credTeoria) != Double.doubleToLongBits(other.credTeoria))
			return false;
		if (Double.doubleToLongBits(credTotal) != Double.doubleToLongBits(other.credTotal))
			return false;
		if (curso != other.curso)
			return false;
		if (duracion == null) {
			if (other.duracion != null)
				return false;
		} else if (!duracion.equals(other.duracion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ofertada != other.ofertada)
			return false;
		if (otrosIdiomas == null) {
			if (other.otrosIdiomas != null)
				return false;
		} else if (!otrosIdiomas.equals(other.otrosIdiomas))
			return false;
		if (plazas != other.plazas)
			return false;
		if (referencia != other.referencia)
			return false;
		if (titulacion != other.titulacion)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Datos_Excel_Asignaturas [id=" + id + ", titulacion=" + titulacion + ", ofertada=" + ofertada
				+ ", codigo=" + codigo + ", referencia=" + referencia + ", asignatura=" + asignatura + ", curso="
				+ curso + ", credTeoria=" + credTeoria + ", credPractica=" + credPractica + ", credTotal=" + credTotal
				+ ", duracion=" + duracion + ", plazas=" + plazas + ", otrosIdiomas=" + otrosIdiomas + "]";
	}
	
   
}
