package es.uma.informatica.sii.backing;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ejb.GestionGrupo;
import ejb.excepciones.TrazabilidadException;
import jpa.entidades.Grupo;

@Named(value = "grupos")
@RequestScoped
public class Grupos {

	public static enum Modo {
		MODIFICAR, INSERTAR, NOACCION
	};

	@Inject
	private GestionGrupo gestion;

	private Grupo grupo;
	private Modo modo;

	public Grupos() {
		grupo = new Grupo();
		modo = Modo.NOACCION;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Modo getModo() {
		return modo;
	}

	public void setModo(Modo modo) {
		this.modo = modo;
	}

	public String getAccion() {
        switch (modo) {
            case MODIFICAR:
                return "Modificar";
            case INSERTAR:
                return "Insertar";

        }
        return null;
    }
	
	public String modificar(Grupo g) {
        grupo = g;
        setModo(Modo.MODIFICAR);
        return "edicionGrupos.xhtml";
    }

    public String ejecutarAccion() {
        try {
            switch (modo) {
                case MODIFICAR:
                    gestion.actualizarGrupo(grupo);
                    break;
                case INSERTAR:
                    gestion.insertarGrupo(grupo);
                    break;
            }
            return "grupos.xhtml";
        } catch (TrazabilidadException e) {
            return "errores.xhtml";
		}
    }
    
    public String getMenu() {
        return "menuSecretaria.xhtml";
    }

    public String eliminar(Grupo g) {
        try {
            gestion.eliminarGrupo(g);
        } catch (TrazabilidadException e) {
            return "errores.xhtml";
        }
        return null;
    }

    public String insertarGrupo() {
        setModo(Modo.INSERTAR);
        return "edicionGrupos.xhtml";
    }
    
    public List<Grupo> getLista() {
    	try {
    		return gestion.listaGrupo();
    	} catch (TrazabilidadException e) {
    		return null;
    	}
    }
}
