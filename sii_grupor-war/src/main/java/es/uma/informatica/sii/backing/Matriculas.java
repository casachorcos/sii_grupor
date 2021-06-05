package es.uma.informatica.sii.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ejb.GestionMatricula;
import ejb.excepciones.TrazabilidadException;
import jpa.entidades.Matricula;

@Named(value = "matriculas")
@RequestScoped
public class Matriculas {

    public static enum Modo {
        MODIFICAR,
        NOACCION
    };

    @Inject
    private GestionMatricula gestionMatricula;

    private Matricula matricula;
    private Modo modo;

    public Matriculas() {
        matricula = new Matricula();
        modo = Modo.NOACCION;
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
        }
        return null;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public String modificar(Matricula m) {
    	matricula = m;
        setModo(Modo.MODIFICAR);
        return "edicionMatricula.xhtml";
    }

    public String ejecutarAccion() {
        try {
            switch (modo) {
                case MODIFICAR:
                	gestionMatricula.actualizarMatricula(matricula);
                    break;
            }
            return "matriculas.xhtml";
        } catch (TrazabilidadException e) {
            return "login.xhtml";
		}
    }
    
    public String menu() {
        return "menuSecretaria.xhtml";
    }
}
