package jpa.tarea1;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: Grupo
 *
 */
@Entity

public class Grupo  {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column (name = "Curso",unique = true, nullable = false)
	private int curso;
	@Column (name = "Letra",unique = true, nullable = false)
	private char letra;
	@Column (name = "Turno _Mañana_Tarde", nullable = false)
	private String turno;
	@Column (name = "Ingles", nullable = false)
	private char ingles;
	@Column (name = "Visible", nullable = true)
	private char visible;
	@Column (name = "Asignar", nullable = true)
	private String asignar;
	@Column (name = "Plazas", nullable = true)
	private int plazas;

	public Grupo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
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

	public char getIngles() {
		return ingles;
	}

	public void setIngles(char ingles) {
		this.ingles = ingles;
	}

	public char getVisible() {
		return visible;
	}

	public void setVisible(char visible) {
		this.visible = visible;
	}

	public String getAsignar() {
		return asignar;
	}

	public void setAsignar(String asignar) {
		this.asignar = asignar;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asignar == null) ? 0 : asignar.hashCode());
		result = prime * result + curso;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ingles;
		result = prime * result + letra;
		result = prime * result + plazas;
		result = prime * result + ((turno == null) ? 0 : turno.hashCode());
		result = prime * result + visible;
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
		if (curso != other.curso)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ingles != other.ingles)
			return false;
		if (letra != other.letra)
			return false;
		if (plazas != other.plazas)
			return false;
		if (turno == null) {
			if (other.turno != null)
				return false;
		} else if (!turno.equals(other.turno))
			return false;
		if (visible != other.visible)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Grupo [id=" + id + ", curso=" + curso + ", letra=" + letra + ", turno=" + turno + ", ingles=" + ingles
				+ ", visible=" + visible + ", asignar=" + asignar + ", plazas=" + plazas + "]";
	}
	
   
}
