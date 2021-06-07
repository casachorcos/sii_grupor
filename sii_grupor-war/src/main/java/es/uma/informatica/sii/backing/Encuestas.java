package es.uma.informatica.sii.backing;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ejb.GestionEncuestas;
import ejb.excepciones.TrazabilidadException;
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
	
	public String ejecutarAccion() {
        try {
            switch (modo) {
                case MODIFICAR:
                	Date date = encuesta.getFecha_de_envio();
                	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
                	String strDate = dateFormat.format(date);
                	encuesta.setFecha_de_envio(new Date(Integer.parseInt(strDate.substring(0,4))-1900,Integer.parseInt(strDate.substring(5,7))-1,Integer.parseInt(strDate.substring(8,10)),Integer.parseInt(strDate.substring(11,13)),Integer.parseInt(strDate.substring(14,16)),Integer.parseInt(strDate.substring(17,19))));
                	//Para la fecha se ha restado 1900 al año y 1 al mes para que coincida con la fecha actual, puesto que nos devolvía el año 3921 y el mes 7 para el dato 2021-06-06
                	gestion.actualizarEncuesta(encuesta);
                	
                    break;
                case INSERTAR:
                	Calendar mydate = new GregorianCalendar(TimeZone.getTimeZone("Europa/Madrid"),new Locale("ES"));
        			encuesta.setFecha_de_envio(new Date(mydate.get(Calendar.YEAR)-1900, mydate.get(Calendar.MONTH), mydate.get(Calendar.DAY_OF_MONTH), mydate.get(Calendar.HOUR)+2, mydate.get(Calendar.MINUTE), mydate.get(Calendar.SECOND)));
                    gestion.insertarEncuesta(encuesta);
                    break;
            }
            return "encuesta.xhtml";
        } catch (TrazabilidadException e) {
            return "errores.xhtml";
		}
    }
	
	public String guardar() {
		try { 
			Calendar mydate = new GregorianCalendar(TimeZone.getTimeZone("Europa/Madrid"),new Locale("ES"));
			encuesta.setFecha_de_envio(new Date(mydate.get(Calendar.YEAR)-1900, mydate.get(Calendar.MONTH), mydate.get(Calendar.DAY_OF_MONTH), mydate.get(Calendar.HOUR)+2, mydate.get(Calendar.MINUTE), mydate.get(Calendar.SECOND)));
			gestion.insertarEncuesta(encuesta);
			return "encuestaRealizada.xhtml";
		} catch (TrazabilidadException e) {
            return "errores.xhtml";
		}
	}
	
	 public String eliminar(Encuesta en) {
	        try {
	            gestion.eliminarEncuesta(en);
	        } catch (TrazabilidadException e) {
	            return "errores.xhtml";
	        }
	        return null;
	    }
	 
	 public String modificar(Encuesta en) {
	        encuesta = en;
	        setModo(Modo.MODIFICAR);
	        return "edicionEncuesta.xhtml";
	    }
	 
	 public String insertarEncuesta() {
	        setModo(Modo.INSERTAR);
	        return "edicionEncuesta.xhtml";
	    }
	
	 public List<Encuesta> getLista() {
    	try {
    		return gestion.listaEncuesta();
    	} catch (TrazabilidadException e) {
    		return null;
    	}
	 }
}
