package es.uma.informatica.sii.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Login {

    public String entrarAlumnos() {    
    	return "menuAlumnos.xhtml";  
    }
    
    public String entrarSecretaria() {    
    	return "menuSecretaria.xhtml";  
    }  
}
