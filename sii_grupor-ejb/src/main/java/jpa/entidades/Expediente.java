package jpa.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
public class Expediente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8L;
	@Id @Column (name = "Num_Expediente")
	private Integer num_exp;
	@Column (name = "Activo")
	private char activo;
	@Column (name = "Nota_Media_Provisional")
	private Double notaMedia;
	@Column (name = "Creditos_superados", nullable = false)
	private Double cr_sup;
	@Column (name = "Creditos_fb", nullable = false)
	private Double cr_fb;
	@Column (name = "Creditos_op", nullable = false)
	private Double cr_op;
	@Column (name = "Creditos_ob", nullable = false)
	private Double cr_ob;
	@Column (name = "Creditos_cf", nullable = false)
	private Double cr_cf;
	@Column (name = "Creditos_pe", nullable = false)
	private Double cr_pe;
	@Column (name = "Creditos_tf", nullable = false)
	private Double cr_tf;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Titulacion titulacion; //Relacion ManyToOne entre Expediente y Titulacion
	@OneToMany (mappedBy="expediente", cascade = CascadeType.PERSIST )
	private List<Encuesta> encuestas;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Alumno alumno;
	@OneToMany (mappedBy = "expediente", cascade = CascadeType.PERSIST)
	private List<Matricula> matricula;		//Relacion OneToMany entre Expediente y Matricula
	

	
	
	public Expediente(Integer ne, char a, Double nm, Double csup, Double cfb, 
			Double cop, Double cob, Double ccf, Double cpe, Double ctf) {
		super();
		num_exp = ne;
		activo = a;
		notaMedia= nm;
		cr_sup = csup;
		cr_fb = cfb;
		cr_op = cop;
		cr_ob = cob;
		cr_cf = ccf;
		cr_pe = cpe;
		cr_tf = ctf;
	}
	
	public Expediente() {
		
	}

	public Integer getNum_exp() {
		return num_exp;
	}

	public void setNum_exp(Integer num_exp) {
		this.num_exp = num_exp;
	}

	public char getActivo() {
		return activo;
	}

	public void setActivo(char activo) {
		this.activo = activo;
	}

	public Double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(Double notaMedia) {
		this.notaMedia = notaMedia;
	}

	public Double getCr_sup() {
		return cr_sup;
	}

	public void setCr_sup(Double cr_sup) {
		this.cr_sup = cr_sup;
	}

	public Double getCr_fb() {
		return cr_fb;
	}

	public void setCr_fb(Double cr_fb) {
		this.cr_fb = cr_fb;
	}

	public Double getCr_op() {
		return cr_op;
	}

	public void setCr_op(Double cr_op) {
		this.cr_op = cr_op;
	}

	public Double getCr_ob() {
		return cr_ob;
	}

	public void setCr_ob(Double cr_ob) {
		this.cr_ob = cr_ob;
	}

	public Double getCr_cf() {
		return cr_cf;
	}

	public void setCr_cf(Double cr_cf) {
		this.cr_cf = cr_cf;
	}

	public Double getCr_pe() {
		return cr_pe;
	}

	public void setCr_pe(Double cr_pe) {
		this.cr_pe = cr_pe;
	}

	public Double getCr_tf() {
		return cr_tf;
	}

	public void setCr_tf(Double cr_tf) {
		this.cr_tf = cr_tf;
	}

	public Titulacion getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
	}

	public List<Encuesta> getEncuestas() {
		return encuestas;
	}

	public void setEncuestas(List<Encuesta> encuestas) {
		this.encuestas = encuestas;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public List<Matricula> getMatricula() {
		return matricula;
	}

	public void setMatricula(List<Matricula> matricula) {
		this.matricula = matricula;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + activo;
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
		result = prime * result + ((cr_cf == null) ? 0 : cr_cf.hashCode());
		result = prime * result + ((cr_fb == null) ? 0 : cr_fb.hashCode());
		result = prime * result + ((cr_ob == null) ? 0 : cr_ob.hashCode());
		result = prime * result + ((cr_op == null) ? 0 : cr_op.hashCode());
		result = prime * result + ((cr_pe == null) ? 0 : cr_pe.hashCode());
		result = prime * result + ((cr_sup == null) ? 0 : cr_sup.hashCode());
		result = prime * result + ((cr_tf == null) ? 0 : cr_tf.hashCode());
		result = prime * result + ((encuestas == null) ? 0 : encuestas.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((notaMedia == null) ? 0 : notaMedia.hashCode());
		result = prime * result + ((num_exp == null) ? 0 : num_exp.hashCode());
		result = prime * result + ((titulacion == null) ? 0 : titulacion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expediente other = (Expediente) obj;
		if (activo != other.activo)
			return false;
		if (alumno == null) {
			if (other.alumno != null)
				return false;
		} else if (!alumno.equals(other.alumno))
			return false;
		if (cr_cf == null) {
			if (other.cr_cf != null)
				return false;
		} else if (!cr_cf.equals(other.cr_cf))
			return false;
		if (cr_fb == null) {
			if (other.cr_fb != null)
				return false;
		} else if (!cr_fb.equals(other.cr_fb))
			return false;
		if (cr_ob == null) {
			if (other.cr_ob != null)
				return false;
		} else if (!cr_ob.equals(other.cr_ob))
			return false;
		if (cr_op == null) {
			if (other.cr_op != null)
				return false;
		} else if (!cr_op.equals(other.cr_op))
			return false;
		if (cr_pe == null) {
			if (other.cr_pe != null)
				return false;
		} else if (!cr_pe.equals(other.cr_pe))
			return false;
		if (cr_sup == null) {
			if (other.cr_sup != null)
				return false;
		} else if (!cr_sup.equals(other.cr_sup))
			return false;
		if (cr_tf == null) {
			if (other.cr_tf != null)
				return false;
		} else if (!cr_tf.equals(other.cr_tf))
			return false;
		if (encuestas == null) {
			if (other.encuestas != null)
				return false;
		} else if (!encuestas.equals(other.encuestas))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (notaMedia == null) {
			if (other.notaMedia != null)
				return false;
		} else if (!notaMedia.equals(other.notaMedia))
			return false;
		if (num_exp == null) {
			if (other.num_exp != null)
				return false;
		} else if (!num_exp.equals(other.num_exp))
			return false;
		if (titulacion == null) {
			if (other.titulacion != null)
				return false;
		} else if (!titulacion.equals(other.titulacion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Expediente [num_exp=" + num_exp + ", activo=" + activo + ", notaMedia=" + notaMedia + ", cr_sup="
				+ cr_sup + ", cr_fb=" + cr_fb + ", cr_op=" + cr_op + ", cr_ob=" + cr_ob + ", cr_cf=" + cr_cf
				+ ", cr_pe=" + cr_pe + ", cr_tf=" + cr_tf + ", titulacion=" + titulacion + ", encuestas=" + encuestas
				+ ", alumno=" + alumno + ", matricula=" + matricula + "]";
	}
}
