package ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;

import ejb.excepciones.AlumnoNoEncontradoException;
import ejb.excepciones.AsignaturaExistenteException;
import ejb.excepciones.TrazabilidadException;
import jpa.entidades.Alumno;
import jpa.entidades.Asignatura;

@Stateless
public class AlumnoEJB implements GestionAlumnos {
	
	@PersistenceContext(name="sii_grupor")
	private EntityManager em;
	
	@Override
	public void insertarAlumno(Alumno alumno) throws AlumnoNoEncontradoException{
		Alumno al = em.find(Alumno.class, alumno.getId());
		if (al==null) {
			throw new AlumnoNoEncontradoException();
		}
		em.persist(al);
	}
	
	@Override
	public void actualizarAlumno(Alumno alumno) throws AlumnoNoEncontradoException{
		Alumno al = em.find(Alumno.class, alumno.getId());
		if (al==null) {
			throw new AlumnoNoEncontradoException();
		}
		al.setNombre(alumno.getNombre());
		al.setApellido(alumno.getApellido());
		al.setApellido2(alumno.getApellido2());
		al.setEmailInst(alumno.getEmailInst());
		al.setEmailPers(alumno.getEmailPers());
		al.setCodPostal(alumno.getCodPostal());
		al.setDireccion(alumno.getDireccion());
		al.setLocalidad(alumno.getLocalidad());
		al.setProvincia(alumno.getProvincia());
		al.setTelefono(alumno.getTelefono());
		al.setMovil(alumno.getMovil());
		em.persist(al);
	}

	
	
}