/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "registro")
@RequestScoped
public class Registro {
	
	public String crearUsuario() {    
    	return "login.xhtml";  
    }

}
