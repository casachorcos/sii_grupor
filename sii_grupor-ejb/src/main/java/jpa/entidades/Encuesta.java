package jpa.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Encuesta
 *
 */
@Entity
public class Encuesta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7L;

	@Id @Column (name = "Fecha_de_envio")
	@Temporal (TemporalType.TIMESTAMP)
	private Date fecha_de_envio;
	
	@ManyToOne //(cascade = CascadeType.PERSIST)
	private Expediente expediente;
	
	@ManyToMany
	@JoinTable(name = "jnd_encuesta_grupo_asig")
	private List<Grupos_por_asignatura> grupo_asig;

	public Encuesta(Date fecha_envio) {
		super();
		fecha_de_envio = fecha_envio;
	}
	
	public Encuesta() {
		
	}

	public Date getFecha_de_envio() {
		return fecha_de_envio;
	}

	public void setFecha_de_envio(Date fecha_de_envio) {
		this.fecha_de_envio = fecha_de_envio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha_de_envio == null) ? 0 : fecha_de_envio.hashCode());
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
		if (fecha_de_envio == null) {
			if (other.fecha_de_envio != null)
				return false;
		} else if (!fecha_de_envio.equals(other.fecha_de_envio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Encuesta [fecha_de_envio=" + fecha_de_envio + "]";
	}
   
	
	
}