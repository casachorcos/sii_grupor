package ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;

import ejb.excepciones.GrupoNoEncontradoException;
import ejb.excepciones.GrupoExistenteException;
import ejb.excepciones.TrazabilidadException;
import jpa.entidades.Grupo;

@Stateless
public class GrupoEJB implements GestionGrupo{

	@PersistenceContext(name="sii_grupor")
	private EntityManager em;
	
	@Override
	public void insertarGrupo(Grupo grupo) throws GrupoExistenteException {
		Grupo gr = em.find(Grupo.class, grupo.getId());
		if (gr != null) {
			throw new GrupoExistenteException();
		}
		em.persist(grupo);
	}
	
	@Override
	public Grupo obtenerGrupo(String id) throws GrupoNoEncontradoException {
		Grupo gr = em.find(Grupo.class, id);
		if(gr==null) {
			throw new GrupoNoEncontradoException();
		}
		return gr;
	}
	
	@Override
	public void actualizarGrupo(Grupo grupo) throws GrupoNoEncontradoException {
		Grupo gr = em.find(Grupo.class, grupo.getId());
		if (gr==null) {
			throw new GrupoNoEncontradoException();
		}
		gr.setCurso(grupo.getCurso());
		gr.setLetra(grupo.getLetra());
		gr.setTurno(grupo.getTurno());
		gr.setIngles(grupo.getIngles());
		gr.setVisible(grupo.getVisible());
		gr.setAsignar(grupo.getAsignar());
		gr.setPlazas(grupo.getPlazas());
		em.persist(gr);
	}

	@Override
	public void eliminarGrupo(Grupo grupo) throws GrupoNoEncontradoException {
		Grupo gr = em.find(Grupo.class, grupo.getId());
		if (gr==null) {
			throw new GrupoNoEncontradoException();
		}
		em.remove(gr);
	}

	
	
}
