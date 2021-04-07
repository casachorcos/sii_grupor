package jpa.tarea1;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Centro
 *
 */
@Entity
public class Centro {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column (name = "Nombre", nullable = false)
	private String nombre;
	@Column (name = "Dirección", nullable = false)
	private String direccion;
	@Column (name = "TLF_Consejería")
	private String tlf_consegeria;
	
	
	public Centro(String nombre, String direccion, String tlf_consejeria) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.tlf_consegeria = tlf_consejeria;
	}
	
	public Centro() {
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTlf_consegeria() {
		return tlf_consegeria;
	}


	public void setTlf_consegeria(String tlf_consegeria) {
		this.tlf_consegeria = tlf_consegeria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((tlf_consegeria == null) ? 0 : tlf_consegeria.hashCode());
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
		Centro other = (Centro) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tlf_consegeria == null) {
			if (other.tlf_consegeria != null)
				return false;
		} else if (!tlf_consegeria.equals(other.tlf_consegeria))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Centro [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", tlf_consegeria="
				+ tlf_consegeria + "]";
	}
}
