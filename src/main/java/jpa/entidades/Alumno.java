package jpa.entidades;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Alumno
 *
 */
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
   
}
