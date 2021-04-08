package jpa.tarea1;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.persistence.Embeddable;

@Embeddable
public class ClaseId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;
	@Column(name = "Dia", length=10)
	private String dia;
	@Column(name = "Hora_inicio")
	@Temporal (TemporalType.DATE)
	private Date horaInicio;
	
	public ClaseId(String d, Date hi) {
		super();
		dia = d;
		horaInicio = hi;
	}
	
	public ClaseId() {
		
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((horaInicio == null) ? 0 : horaInicio.hashCode());
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
		ClaseId other = (ClaseId) obj;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		if (horaInicio == null) {
			if (other.horaInicio != null)
				return false;
		} else if (!horaInicio.equals(other.horaInicio))
			return false;
		return true;
	}
	
}