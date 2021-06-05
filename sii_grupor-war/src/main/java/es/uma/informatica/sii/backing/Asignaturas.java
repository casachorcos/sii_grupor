package es.uma.informatica.sii.backing;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ejb.GestionAsignaturas;
import ejb.excepciones.TrazabilidadException;
import jpa.entidades.Asignatura;

@Named(value = "asignaturas")
@RequestScoped
public class Asignaturas {

	public static enum Modo {
		MODIFICAR, INSERTAR, NOACCION
	};

	@Inject
	private GestionAsignaturas gestion;

	private Asignatura asignatura;
	private Modo modo;

	public Asignaturas() {
		asignatura = new Asignatura();
		modo = Modo.NOACCION;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
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
	
	public String modificar(Asignatura a) {
        asignatura = a;
        setModo(Modo.MODIFICAR);
        return "edicionAsignatura.xhtml";
    }

    public String ejecutarAccion() {
        try {
            switch (modo) {
                case MODIFICAR:
                    gestion.actualizarAsignatura(asignatura);
                    break;
                case INSERTAR:
                    gestion.insertarAsignatura(asignatura);
                    break;
            }
            return "asignaturas.xhtml";
        } catch (TrazabilidadException e) {
            return "login.xhtml";
		}
    }
    
    public String getMenu() {
        return "menuSecretaria.xhtml";
    }

    public String eliminar(Asignatura a) {
        try {
            gestion.eliminarAsignatura(a);
        } catch (TrazabilidadException e) {
            return "login.xhtml";
        }
        return null;
    }

    public String insertarAsignatura() {
        setModo(Modo.INSERTAR);
        return "edicionAsignatura.xhtml";
    }
    
    public List<Asignatura> getLista() {
    	try {
    		return gestion.listaAsignatura();
    	} catch (TrazabilidadException e) {
    		return null;
    	}
    }
}
