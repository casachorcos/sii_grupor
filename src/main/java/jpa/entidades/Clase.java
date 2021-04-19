package jpa.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;



@Entity
public class Clase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	
	@EmbeddedId
	private ClaseId id;
	@ManyToOne
	private Grupo grupo;
	@Column (name = "Hora_fin")
	@Temporal(TemporalType.DATE)
	private Date horaFin;
	
	@ManyToOne
	private Asignatura asignatura;
	
	
	public Clase(String d, Date hi, Date hf) {
		super();
		id = new ClaseId(d,hi);
		horaFin = hf;
	}
	
	public Clase() {
		
	}


	public Date getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((horaFin == null) ? 0 : horaFin.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Clase other = (Clase) obj;
		if (horaFin == null) {
			if (other.horaFin != null)
				return false;
		} else if (!horaFin.equals(other.horaFin))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Clase [id=" + id + ", horaFin=" + horaFin + "]";
	}
	
	
}
