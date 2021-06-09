package jpa.entidades;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Alumno
 *
 */
@NamedQuery(name = "Alumno.todos", query = "select a from Alumno a")
@Entity

public class Alumno implements Serializable {

	   
	@Id @GeneratedValue
	private Long id;
	private String DNI;
	private String Nombre;
	private String Apellido1;
	private String Apellido2;
	private String emailInst;
	private String emailPers;
	private String telefono;
	private String movil;
	private String direccion;
	private String localidad;
	private String provincia;
	private String codPostal;
	private static final long serialVersionUID = 1L;

	public Alumno() {
		super();
	}   
	
	public Alumno(String dni,String name,String ap1,String ap2,String em1,String em2,String tel,String mov,String dir,String loc,String prov,String codPostal) {
		this.DNI = dni;
		this.Nombre = name;
		this.Apellido1 = ap1;
		this.Apellido2 = ap2;
		this.emailInst = em1;
		this.emailPers = em2;
		this.telefono = tel;
		this.movil = mov;
		this.localidad = loc;
		this.provincia = prov;
		this.codPostal = codPostal;
	}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getDNI() {
		return this.DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public String getApellido1() {
		return this.Apellido1;
	}

	public void setApellido1(String Apellido1) {
		this.Apellido1 = Apellido1;
	}   
	public String getApellido2() {
		return this.Apellido2;
	}

	public void setApellido2(String Apellido2) {
		this.Apellido2 = Apellido2;
	}   
	public String getEmailInst() {
		return this.emailInst;
	}

	public void setEmailInst(String emailInst) {
		this.emailInst = emailInst;
	}   
	public String getEmailPers() {
		return this.emailPers;
	}

	public void setEmailPers(String emailPers) {
		this.emailPers = emailPers;
	}   
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}   
	public String getMovil() {
		return this.movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}   
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}   
	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}   
	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}   
	public String getCodPostal() {
		return this.codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Apellido1 == null) ? 0 : Apellido1.hashCode());
		result = prime * result + ((Apellido2 == null) ? 0 : Apellido2.hashCode());
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((codPostal == null) ? 0 : codPostal.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((emailInst == null) ? 0 : emailInst.hashCode());
		result = prime * result + ((emailPers == null) ? 0 : emailPers.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + ((movil == null) ? 0 : movil.hashCode());
		result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
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
		Alumno other = (Alumno) obj;
		if (Apellido1 == null) {
			if (other.Apellido1 != null)
				return false;
		} else if (!Apellido1.equals(other.Apellido1))
			return false;
		if (Apellido2 == null) {
			if (other.Apellido2 != null)
				return false;
		} else if (!Apellido2.equals(other.Apellido2))
			return false;
		if (DNI == null) {
			if (other.DNI != null)
				return false;
		} else if (!DNI.equals(other.DNI))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (codPostal == null) {
			if (other.codPostal != null)
				return false;
		} else if (!codPostal.equals(other.codPostal))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (emailInst == null) {
			if (other.emailInst != null)
				return false;
		} else if (!emailInst.equals(other.emailInst))
			return false;
		if (emailPers == null) {
			if (other.emailPers != null)
				return false;
		} else if (!emailPers.equals(other.emailPers))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (movil == null) {
			if (other.movil != null)
				return false;
		} else if (!movil.equals(other.movil))
			return false;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", DNI=" + DNI + ", Nombre=" + Nombre + ", Apellido1=" + Apellido1 + ", Apellido2="
				+ Apellido2 + ", emailInst=" + emailInst + ", emailPers=" + emailPers + ", telefono=" + telefono
				+ ", movil=" + movil + ", direccion=" + direccion + ", localidad=" + localidad + ", provincia="
				+ provincia + ", codPostal=" + codPostal + "]";
	}
   
}
