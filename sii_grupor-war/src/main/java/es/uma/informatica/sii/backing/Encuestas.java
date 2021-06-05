package es.uma.informatica.sii.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ejb.GestionEncuestas;
import jpa.entidades.Encuesta;

@Named(value = "encuestas")
@RequestScoped
public class Encuestas {

	public static enum Modo {
        MODIFICAR, 
        INSERTAR,
        NOACCION
    };
	
    @Inject
    private GestionEncuestas gestion;
    
    private Encuesta encuesta;
    private Modo modo;
    
    public Encuestas() {
        encuesta = new Encuesta();
        modo = Modo.NOACCION;
    }

	public Encuesta getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
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
    
}
