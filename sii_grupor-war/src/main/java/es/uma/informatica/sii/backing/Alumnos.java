package es.uma.informatica.sii.backing;

import jpa.entidades.Alumno;
import ejb.excepciones.AlumnoNoEncontradoException;
import ejb.excepciones.TrazabilidadException;
import ejb.GestionAlumnos;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "alumnos")
@RequestScoped
public class Alumnos {

    public static enum Modo {
        MODIFICAR,
        INSERTAR,
        NOACCION
    };

    @Inject
    private GestionAlumnos gestionAlumnos;

    private Alumno alumno;
    private Modo modo;

    public Alumnos() {
        alumno = new Alumno();
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
            case INSERTAR:
                return "Insertar";

        }
        return null;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public String modificar(Alumno a) {
        alumno = a;
        setModo(Modo.MODIFICAR);
        return "edicionAlumnos.xhtml";

    }

    public String ejecutarAccion() {
        try {
            switch (modo) {
                case MODIFICAR:
                    gestionAlumnos.actualizarAlumno(alumno);
                    break;
            }
            return "alumnos.xhtml";
        } catch (TrazabilidadException e) {
            return "login.xhtml";
		}
    }
    
    public String getMenu() {
        return "menuSecretaria.xhtml";
    }
}
