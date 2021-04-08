package jpa.tarea1;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * Entity implementation class for Entity: Datos_Excel
 */

@Entity
public class Datos_Excel implements Serializable {
	private static final long serialVersionUID = 13L;
	
	@Id @Column (name = "Documento", nullable = false)
	private String documento;
	
	@Column (name = "Nombre", nullable = false)
	private String nombre;
	
	@Column (name = "Apellido1", nullable = false)
	private String apellido1;
	
	@Column (name = "Apellido2", nullable = false)
	private String apellido2;
	
	@Column (name = "Numero_expediente", nullable = false)
	private int numExpediente;
	
	@Column (name = "Numero_Archivo", nullable = false)
	private int numArchivo;
	
	@Column (name = "Email_institucional", nullable = false)
	private String emailInstitucinal;
	
	@Column (name = "Email_Personal")
	private String email_personal;
	
	@Column (name = "Telefono", nullable = false)
	private String telefono;
	
	@Column (name = "Movil")
	private String movil;
	
	@Column (name = "Direccion_Notificacion", nullable = false)
	private String direccionNotificacion;
	
	@Column (name = "Localidad_Notificacion", nullable = false)
	private String localidadNotificacion;
	
	@Column (name = "Provincia_Notificacion", nullable = false)
	private String provinciaNotificacion;
	
	@Column (name = "CodigoPostal_Notificacion", nullable = false)
	private int codPostalNotificacion;
	
	@Column (name = "Fecha_Matriculacion", nullable = false)
	@Temporal (TemporalType.DATE)
	private Date fechaMatriculacion;
	
	@Column (name = "Turno_Preferente", nullable = false)
	private String turnoPreferente;
	
	@Column (name = "Grupos_Asignados", nullable = false)
	private String gruposAsignados;
	
	@Column (name = "Nota_Media", nullable = false)
	private double notaMedia;
	
	@Column (name = "Creditos_Superados", nullable = false)
	private double creditosSuperados;
	
	@Column (name = "Creditos_FB", nullable = false)
	private double creditosFB;
	
	@Column (name = "Creditos_OB", nullable = false)
	private double creditosOB;
	
	@Column (name = "Creditos_OP", nullable = false)
	private double creditosOP;
	
	@Column (name = "Creditos_CF", nullable = false)
	private double creditos_CF;
	
	@Column (name = "Creditos_PE", nullable = false)
	private double creditosPE;
	
	@Column (name = "Creditos_TF", nullable = false)
	private double creditosTF;
	
	

	public Datos_Excel() {
		super();
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public int getNumExpediente() {
		return numExpediente;
	}

	public void setNumExpediente(int numExpediente) {
		this.numExpediente = numExpediente;
	}

	public int getNumArchivo() {
		return numArchivo;
	}

	public void setNumArchivo(int numArchivo) {
		this.numArchivo = numArchivo;
	}

	public String getEmailInstitucinal() {
		return emailInstitucinal;
	}

	public void setEmailInstitucinal(String emailInstitucinal) {
		this.emailInstitucinal = emailInstitucinal;
	}

	public String getEmail_personal() {
		return email_personal;
	}

	public void setEmail_personal(String email_personal) {
		this.email_personal = email_personal;
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

	public String getDireccionNotificacion() {
		return direccionNotificacion;
	}

	public void setDireccionNotificacion(String direccionNotificacion) {
		this.direccionNotificacion = direccionNotificacion;
	}

	public String getLocalidadNotificacion() {
		return localidadNotificacion;
	}

	public void setLocalidadNotificacion(String localidadNotificacion) {
		this.localidadNotificacion = localidadNotificacion;
	}

	public String getProvinciaNotificacion() {
		return provinciaNotificacion;
	}

	public void setProvinciaNotificacion(String provinciaNotificacion) {
		this.provinciaNotificacion = provinciaNotificacion;
	}

	public int getCodPostalNotificacion() {
		return codPostalNotificacion;
	}

	public void setCodPostalNotificacion(int codPostalNotificacion) {
		this.codPostalNotificacion = codPostalNotificacion;
	}

	public Date getFechaMatriculacion() {
		return fechaMatriculacion;
	}

	public void setFechaMatriculacion(Date fechaMatriculacion) {
		this.fechaMatriculacion = fechaMatriculacion;
	}

	public String getTurnoPreferente() {
		return turnoPreferente;
	}

	public void setTurnoPreferente(String turnoPreferente) {
		this.turnoPreferente = turnoPreferente;
	}

	public String getGruposAsignados() {
		return gruposAsignados;
	}

	public void setGruposAsignados(String gruposAsignados) {
		this.gruposAsignados = gruposAsignados;
	}

	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	public double getCreditosSuperados() {
		return creditosSuperados;
	}

	public void setCreditosSuperados(double creditosSuperados) {
		this.creditosSuperados = creditosSuperados;
	}

	public double getCreditosFB() {
		return creditosFB;
	}

	public void setCreditosFB(double creditosFB) {
		this.creditosFB = creditosFB;
	}

	public double getCreditosOB() {
		return creditosOB;
	}

	public void setCreditosOB(double creditosOB) {
		this.creditosOB = creditosOB;
	}

	public double getCreditosOP() {
		return creditosOP;
	}

	public void setCreditosOP(double creditosOP) {
		this.creditosOP = creditosOP;
	}

	public double getCreditos_CF() {
		return creditos_CF;
	}

	public void setCreditos_CF(double creditos_CF) {
		this.creditos_CF = creditos_CF;
	}

	public double getCreditosPE() {
		return creditosPE;
	}

	public void setCreditosPE(double creditosPE) {
		this.creditosPE = creditosPE;
	}

	public double getCreditosTF() {
		return creditosTF;
	}

	public void setCreditosTF(double creditosTF) {
		this.creditosTF = creditosTF;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido1 == null) ? 0 : apellido1.hashCode());
		result = prime * result + ((apellido2 == null) ? 0 : apellido2.hashCode());
		result = prime * result + codPostalNotificacion;
		long temp;
		temp = Double.doubleToLongBits(creditosFB);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(creditosOB);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(creditosOP);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(creditosPE);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(creditosSuperados);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(creditosTF);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(creditos_CF);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((direccionNotificacion == null) ? 0 : direccionNotificacion.hashCode());
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + ((emailInstitucinal == null) ? 0 : emailInstitucinal.hashCode());
		result = prime * result + ((email_personal == null) ? 0 : email_personal.hashCode());
		result = prime * result + ((fechaMatriculacion == null) ? 0 : fechaMatriculacion.hashCode());
		result = prime * result + ((gruposAsignados == null) ? 0 : gruposAsignados.hashCode());
		result = prime * result + ((localidadNotificacion == null) ? 0 : localidadNotificacion.hashCode());
		result = prime * result + ((movil == null) ? 0 : movil.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		temp = Double.doubleToLongBits(notaMedia);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + numArchivo;
		result = prime * result + numExpediente;
		result = prime * result + ((provinciaNotificacion == null) ? 0 : provinciaNotificacion.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		result = prime * result + ((turnoPreferente == null) ? 0 : turnoPreferente.hashCode());
		return result;
	}

	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		Datos_Excel other = (Datos_Excel) obj;
		if (apellido1 == null) {
			if (other.apellido1 != null) return false;
		} 	else if (!apellido1.equals(other.apellido1)) return false;
		if (apellido2 == null) {
			if (other.apellido2 != null) return false;
		} else if (!apellido2.equals(other.apellido2)) return false;
		if (codPostalNotificacion != other.codPostalNotificacion) return false;
		if (Double.doubleToLongBits(creditosFB) != Double.doubleToLongBits(other.creditosFB)) return false;
		if (Double.doubleToLongBits(creditosOB) != Double.doubleToLongBits(other.creditosOB)) return false;
		if (Double.doubleToLongBits(creditosOP) != Double.doubleToLongBits(other.creditosOP)) return false;
		if (Double.doubleToLongBits(creditosPE) != Double.doubleToLongBits(other.creditosPE)) return false;
		if (Double.doubleToLongBits(creditosSuperados) != Double.doubleToLongBits(other.creditosSuperados)) return false;
		if (Double.doubleToLongBits(creditosTF) != Double.doubleToLongBits(other.creditosTF)) return false;
		if (Double.doubleToLongBits(creditos_CF) != Double.doubleToLongBits(other.creditos_CF)) return false;
		if (direccionNotificacion == null) {
			if (other.direccionNotificacion != null) return false;
		} else if (!direccionNotificacion.equals(other.direccionNotificacion)) return false;
		if (documento == null) {
			if (other.documento != null) return false;
		} else if (!documento.equals(other.documento)) return false;
		if (emailInstitucinal == null) {
			if (other.emailInstitucinal != null) return false;
		} else if (!emailInstitucinal.equals(other.emailInstitucinal)) return false;
		if (email_personal == null) {
			if (other.email_personal != null) return false;
		} else if (!email_personal.equals(other.email_personal)) return false;
		if (fechaMatriculacion == null) {
			if (other.fechaMatriculacion != null) return false;
		} else if (!fechaMatriculacion.equals(other.fechaMatriculacion)) return false;
		if (gruposAsignados == null) {
			if (other.gruposAsignados != null) return false;
		} else if (!gruposAsignados.equals(other.gruposAsignados)) return false;
		if (localidadNotificacion == null) {
			if (other.localidadNotificacion != null) return false;
		} else if (!localidadNotificacion.equals(other.localidadNotificacion)) return false;
		if (movil == null) {
			if (other.movil != null) return false;
		} else if (!movil.equals(other.movil)) return false;
		if (nombre == null) {
			if (other.nombre != null) return false;
		} else if (!nombre.equals(other.nombre)) return false;
		if (Double.doubleToLongBits(notaMedia) != Double.doubleToLongBits(other.notaMedia)) return false;
		if (numArchivo != other.numArchivo) return false;
		if (numExpediente != other.numExpediente) return false;
		if (provinciaNotificacion == null) {
			if (other.provinciaNotificacion != null) return false;
		} else if (!provinciaNotificacion.equals(other.provinciaNotificacion)) return false;
		if (telefono == null) {
			if (other.telefono != null) return false;
		} else if (!telefono.equals(other.telefono)) return false;
		if (turnoPreferente == null) {
			if (other.turnoPreferente != null) return false;
		} else if (!turnoPreferente.equals(other.turnoPreferente)) return false;
		
		return true;
	}
}