package ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import javax.ejb.Stateless;

import ejb.excepciones.MatriculaNoEncontradoException;
import ejb.excepciones.TrazabilidadException;
import jpa.entidades.Matricula;

@Stateless
public class MatriculaEJB implements GestionMatricula{

	@PersistenceContext(name="sii_grupor")
	private EntityManager em;
	
	@Override
	public void actualizarMatricula(Matricula matricula) throws MatriculaNoEncontradoException {
		Matricula mat = em.find(Matricula.class, new Matricula.MatriculaId(matricula.getCurso(),matricula.getExpediente()));
		if(mat == null) {
			throw new MatriculaNoEncontradoException();
		}
		mat.setCurso(matricula.getCurso());
		mat.setEstado(matricula.getEstado());
		mat.setFecha_matr(matricula.getFecha_matr());
		mat.setListaAsig(matricula.getListaAsig());
		mat.setnArchivo(matricula.getnArchivo());
		mat.setNuevoIngreso(matricula.getNuevoIngreso());
		mat.setTurno(matricula.getTurno());
		em.persist(mat);
	}
	
	@Override
	public List<Matricula> listaMatricula() throws TrazabilidadException {
		return em.createNamedQuery("Matricula.todos", Matricula.class).getResultList();
	}
}
