package ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;

import ejb.excepciones.GrupoNoEncontradoException;
import ejb.excepciones.TrazabilidadException;
import jpa.entidades.Grupo;

@Stateless
public class GrupoEJB implements GestionGrupo{

	@PersistenceContext(name="sii_grupor")
	private EntityManager em;
	
	@Override
	public void crearGrupo(Grupo grupo) throws TrazabilidadException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarGrupo(Grupo grupo) throws GrupoNoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarGrupo(Grupo grupo) throws GrupoNoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	
	
}
