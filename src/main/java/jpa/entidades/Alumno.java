package jpa.entidades;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: Alumno
 *
 */

@Entity
public class Alumno  {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "DNI",unique = true, nullable = false)
	private String DNI;
	@Column(name = "Nombre", nullable = false)
	private String Nombre;
	@Column(name = "Apellido1",nullable = false)
	private String Apellido;
	@Column(name = "Apellido2",nullable = false)
	private String Apellido2;
	@Column(name = "Email Institucional",nullable = false)
	private String emailInst;
	@Column(name = "Email Personal",nullable = true)
	private String emailPers;
	@Column(name = "Teléfono",nullable = true)
	private String telefono;
	@Column(name = "Movil",nullable = true)
	private String movil;
	@Column(name = "Dirección",nullable = false)
	private String direccion;
	@Column(name = "Localidad",nullable = false)
	private String localidad;
	@Column(name = "Provincia",nullable = false)
	private String provincia;
	@Column(name = "CódigoPostal",nullable = false)
	private Long codPostal;
	
	
	public Alumno() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDNI() {
		return DNI;
	}


	public void setDNI(String dNI) {
		DNI = dNI;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getApellido() {
		return Apellido;
	}


	public void setApellido(String apellido) {
		Apellido = apellido;
	}


	public String getApellido2() {
		return Apellido2;
	}


	public void setApellido2(String apellido2) {
		Apellido2 = apellido2;
	}


	public String getEmailInst() {
		return emailInst;
	}


	public void setEmailInst(String emailInst) {
		this.emailInst = emailInst;
	}


	public String getEmailPers() {
		return emailPers;
	}


	public void setEmailPers(String emailPers) {
		this.emailPers = emailPers;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getMovil() {
		return movil;
	}


	public void setMovil(String movil) {
		this.movil = movil;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public Long getCodPostal() {
		return codPostal;
	}


	public void setCodPostal(Long codPostal) {
		this.codPostal = codPostal;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Apellido == null) ? 0 : Apellido.hashCode());
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
		if (Apellido == null) {
			if (other.Apellido != null)
				return false;
		} else if (!Apellido.equals(other.Apellido))
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
		return "Alumno [id=" + id + ", DNI=" + DNI + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Apellido2="
				+ Apellido2 + ", emailInst=" + emailInst + ", emailPers=" + emailPers + ", telefono=" + telefono
				+ ", movil=" + movil + ", direccion=" + direccion + ", localidad=" + localidad + ", provincia="
				+ provincia + ", codPostal=" + codPostal + "]";
	}
	
   
}
