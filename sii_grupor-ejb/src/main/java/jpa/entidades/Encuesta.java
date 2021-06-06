package jpa.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Encuesta
 *
 */
@NamedQuery(name = "Encuesta.todos", query = "select e from Encuesta e")
@Entity
public class Encuesta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7L;

	@Id @Column (name = "Fecha_de_envio")
	@Temporal (TemporalType.TIMESTAMP)
	private Date fecha_de_envio;
	@Column (name = "Num_Expediente")
	private String nexpediente;
	@Column (name = "Asignaturas")
	private String asignaturas;
	@Column (name = "Grupo_Preferente")
	private String gr_preferente;
	@Column (name = "Asignaturas_Ingles")
	private String asig_ingles;
	
	@ManyToOne //(cascade = CascadeType.PERSIST)
	private Expediente expediente;
	
	@ManyToMany
	@JoinTable(name = "jnd_encuesta_grupo_asig")
	private List<Grupos_por_asignatura> grupo_asig;

	public Encuesta(Date fecha_envio,String n_expediente, String asig, String gr_pref, String asig_in) {
		super();
		fecha_de_envio = fecha_envio;
		nexpediente = n_expediente;
		asignaturas = asig;
		gr_preferente = gr_pref;
		asig_ingles = asig_in;
	}
	
	public Encuesta() {
		
	}

	public Date getFecha_de_envio() {
		return fecha_de_envio;
	}

	public void setFecha_de_envio(Date fecha_de_envio) {
		this.fecha_de_envio = fecha_de_envio;
	}

	public String getNexpediente() {
		return nexpediente;
	}

	public void setNexpediente(String nexpediente) {
		this.nexpediente = nexpediente;
	}

	public String getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(String asignaturas) {
		this.asignaturas = asignaturas;
	}

	public String getGr_preferente() {
		return gr_preferente;
	}

	public void setGr_preferente(String gr_preferente) {
		this.gr_preferente = gr_preferente;
	}

	public String getAsig_ingles() {
		return asig_ingles;
	}

	public void setAsig_ingles(String asig_ingles) {
		this.asig_ingles = asig_ingles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asig_ingles == null) ? 0 : asig_ingles.hashCode());
		result = prime * result + ((asignaturas == null) ? 0 : asignaturas.hashCode());
		result = prime * result + ((fecha_de_envio == null) ? 0 : fecha_de_envio.hashCode());
		result = prime * result + ((gr_preferente == null) ? 0 : gr_preferente.hashCode());
		result = prime * result + ((nexpediente == null) ? 0 : nexpediente.hashCode());
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
		Encuesta other = (Encuesta) obj;
		if (asig_ingles == null) {
			if (other.asig_ingles != null)
				return false;
		} else if (!asig_ingles.equals(other.asig_ingles))
			return false;
		if (asignaturas == null) {
			if (other.asignaturas != null)
				return false;
		} else if (!asignaturas.equals(other.asignaturas))
			return false;
		if (fecha_de_envio == null) {
			if (other.fecha_de_envio != null)
				return false;
		} else if (!fecha_de_envio.equals(other.fecha_de_envio))
			return false;
		if (gr_preferente == null) {
			if (other.gr_preferente != null)
				return false;
		} else if (!gr_preferente.equals(other.gr_preferente))
			return false;
		if (nexpediente == null) {
			if (other.nexpediente != null)
				return false;
		} else if (!nexpediente.equals(other.nexpediente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Encuesta [fecha_de_envio=" + fecha_de_envio + ", nexpediente=" + nexpediente + ", asignaturas="
				+ asignaturas + ", gr_preferente=" + gr_preferente + ", asig_ingles=" + asig_ingles + "]";
	}
}
