package jpa.tarea1;

import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Encuesta
 *
 */
@Entity
public class Encuesta {

	
	@Id @GeneratedValue
	@Column (nullable = false)
	private Long id;
	@Column (name = "FECHA_ENVIO")
	@Temporal (TemporalType.DATE)
	private Date fecha_de_envio;

	public Encuesta() {
		super();
	}
   
}
