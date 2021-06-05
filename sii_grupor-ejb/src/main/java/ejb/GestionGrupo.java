package ejb;

import ejb.excepciones.TrazabilidadException;
import jpa.entidades.Grupo;

import java.util.List;

import javax.ejb.Local;

@Local
public interface GestionGrupo {

	/*
	 * A�ade el grupo a la base de datos.
	 * Si el grupo se encuentra ya en la base de datos, lanza la excepci�on GrupoExistenteException
	 * @param grupo Grupo que se va a a�adir.
	 */
	public void insertarGrupo(Grupo grupo) throws TrazabilidadException;
	
	/*
	 * Obtiene un Grupo de la base de datos.
	 * Si no se encuentra, lanza la excepcion GrupoNoEncontradoException.
	 * @param id ID del Grupo que se quiere buscar. 
	 * */
	public Grupo obtenerGrupo(String id) throws TrazabilidadException;
	
	/*
	 * Actualiza un grupo en la base de datos.
	 * Si no se encuentra el grupo en la base de datos, lanza la excepci�n GrupoNoEncontradoException.
	 * @param grupo Grupo a actualizar.
	 */
	public void actualizarGrupo(Grupo grupo) throws TrazabilidadException;
	
	/*
	 * Elimina un grupo de la base de datos.
	 * Si no se encuentra el grupo en la base de datos, lanza la excepci�n GrupoNoEncontradoException.
	 * @param grupo Grupo a eliminar.*/
	public void eliminarGrupo(Grupo grupo) throws TrazabilidadException;

	public List<Grupo> listaGrupo() throws TrazabilidadException;
	
}
