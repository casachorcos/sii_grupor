package jpa.entidades;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
/**
 * Entity implementation class for Entity: Grupo
 *
 */
@Entity

public class Grupo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9L;
	@Id @Column(name = "ID")
	private String id;
	@Column (name = "Curso",unique = true, nullable = false)
	private Integer curso;
	@Column (name = "Letra",unique = true, nullable = false)
	private char letra;
	@Column (name = "Turno _Mañana_Tarde", nullable = false)
	private String turno;
	@Column (name = "Ingles", nullable = false)
	private String ingles; //"S�"/"No"
	@Column (name = "Visible", nullable = true)
	private String visible; //"S�"/"No"
	@Column (name = "Asignar", nullable = true)
	private String asignar;
	@Column (name = "Plazas", nullable = true)
	private Integer plazas;
	@ManyToOne
	private Titulacion titulacion;
	@OneToMany (mappedBy="grupo", cascade = CascadeType.PERSIST)
	private List <Grupos_por_asignatura> gruposAsig;
	@OneToMany (mappedBy="grupo", cascade = CascadeType.PERSIST)
	private List<Asignaturas_Matricula> asignaturasMat;
	@OneToMany (mappedBy="grupo", cascade = CascadeType.PERSIST)
	private List <Clase> clase;
	@OneToMany (mappedBy="grupoRefle", cascade = CascadeType.PERSIST)
	private List<Grupo> gruposRefl;
	@ManyToOne
	private Grupo grupoRefle;
	

	public Grupo(String id, Integer c, char l, String t, String i, String v, String a, Integer p) {
		super();
		this.id = id;
		curso = c;
		letra = l;
		turno = t;
		ingles = i;
		visible = v;
		asignar = a;
		plazas = p;
	}
	
	public Grupo() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getIngles() {
		return ingles;
	}

	public void setIngles(String ingles) {
		this.ingles = ingles;
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

	public String getAsignar() {
		return asignar;
	}

	public void setAsignar(String asignar) {
		this.asignar = asignar;
	}

	public Integer getPlazas() {
		return plazas;
	}

	public void setPlazas(Integer plazas) {
		this.plazas = plazas;
	}

	public Titulacion getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
	}

	public List<Grupos_por_asignatura> getGruposAsig() {
		return gruposAsig;
	}

	public void setGruposAsig(List<Grupos_por_asignatura> gruposAsig) {
		this.gruposAsig = gruposAsig;
	}

	public List<Asignaturas_Matricula> getAsignaturasMat() {
		return asignaturasMat;
	}

	public void setAsignaturasMat(List<Asignaturas_Matricula> asignaturasMat) {
		this.asignaturasMat = asignaturasMat;
	}

	public List<Clase> getClase() {
		return clase;
	}

	public void setClase(List<Clase> clase) {
		this.clase = clase;
	}

	public List<Grupo> getGruposRefl() {
		return gruposRefl;
	}

	public void setGruposRefl(List<Grupo> gruposRefl) {
		this.gruposRefl = gruposRefl;
	}

	public Grupo getGrupoRefle() {
		return grupoRefle;
	}

	public void setGrupoRefle(Grupo grupoRefle) {
		this.grupoRefle = grupoRefle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asignar == null) ? 0 : asignar.hashCode());
		result = prime * result + ((asignaturasMat == null) ? 0 : asignaturasMat.hashCode());
		result = prime * result + ((clase == null) ? 0 : clase.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((grupoRefle == null) ? 0 : grupoRefle.hashCode());
		result = prime * result + ((gruposAsig == null) ? 0 : gruposAsig.hashCode());
		result = prime * result + ((gruposRefl == null) ? 0 : gruposRefl.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ingles == null) ? 0 : ingles.hashCode());
		result = prime * result + letra;
		result = prime * result + ((plazas == null) ? 0 : plazas.hashCode());
		result = prime * result + ((titulacion == null) ? 0 : titulacion.hashCode());
		result = prime * result + ((turno == null) ? 0 : turno.hashCode());
		result = prime * result + ((visible == null) ? 0 : visible.hashCode());
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
		Grupo other = (Grupo) obj;
		if (asignar == null) {
			if (other.asignar != null)
				return false;
		} else if (!asignar.equals(other.asignar))
			return false;
		if (asignaturasMat == null) {
			if (other.asignaturasMat != null)
				return false;
		} else if (!asignaturasMat.equals(other.asignaturasMat))
			return false;
		if (clase == null) {
			if (other.clase != null)
				return false;
		} else if (!clase.equals(other.clase))
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (grupoRefle == null) {
			if (other.grupoRefle != null)
				return false;
		} else if (!grupoRefle.equals(other.grupoRefle))
			return false;
		if (gruposAsig == null) {
			if (other.gruposAsig != null)
				return false;
		} else if (!gruposAsig.equals(other.gruposAsig))
			return false;
		if (gruposRefl == null) {
			if (other.gruposRefl != null)
				return false;
		} else if (!gruposRefl.equals(other.gruposRefl))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ingles == null) {
			if (other.ingles != null)
				return false;
		} else if (!ingles.equals(other.ingles))
			return false;
		if (letra != other.letra)
			return false;
		if (plazas == null) {
			if (other.plazas != null)
				return false;
		} else if (!plazas.equals(other.plazas))
			return false;
		if (titulacion == null) {
			if (other.titulacion != null)
				return false;
		} else if (!titulacion.equals(other.titulacion))
			return false;
		if (turno == null) {
			if (other.turno != null)
				return false;
		} else if (!turno.equals(other.turno))
			return false;
		if (visible == null) {
			if (other.visible != null)
				return false;
		} else if (!visible.equals(other.visible))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Grupo [id=" + id + ", curso=" + curso + ", letra=" + letra + ", turno=" + turno + ", ingles=" + ingles
				+ ", visible=" + visible + ", asignar=" + asignar + ", plazas=" + plazas + ", titulacion=" + titulacion
				+ ", gruposAsig=" + gruposAsig + ", asignaturasMat=" + asignaturasMat + ", clase=" + clase
				+ ", gruposRefl=" + gruposRefl + ", grupoRefle=" + grupoRefle + "]";
	}
}
