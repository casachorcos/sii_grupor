package jpa.tarea1;

import javax.persistence.*;

@Entity
public class Expediente {

	@Id @Column (name = "Num_Expediente")
	private int num_exp;
	@Column (name = "Activo")
	private char activo;
	@Column (name = "Nota_Media_Provisional")
	private double notaMedia;
	@Column (name = "Creditos_superados", nullable = false)
	private double cr_sup;
	@Column (name = "Creditos_fb", nullable = false)
	private double cr_fb;
	@Column (name = "Creditos_op", nullable = false)
	private double cr_op;
	@Column (name = "Creditos_ob", nullable = false)
	private double cr_ob;
	@Column (name = "Creditos_cf", nullable = false)
	private double cr_cf;
	@Column (name = "Creditos_pe", nullable = false)
	private double cr_pe;
	@Column (name = "Creditos_tf", nullable = false)
	private double cr_tf;
	
	public Expediente(int ne, char a, double nm, double csup, double cfb, 
			double cop, double cob, double ccf, double cpe, double ctf) {
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

	public int getNum_exp() {
		return num_exp;
	}

	public void setNum_exp(int num_exp) {
		this.num_exp = num_exp;
	}

	public char getActivo() {
		return activo;
	}

	public void setActivo(char activo) {
		this.activo = activo;
	}

	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	public double getCr_sup() {
		return cr_sup;
	}

	public void setCr_sup(double cr_sup) {
		this.cr_sup = cr_sup;
	}

	public double getCr_fb() {
		return cr_fb;
	}

	public void setCr_fb(double cr_fb) {
		this.cr_fb = cr_fb;
	}

	public double getCr_op() {
		return cr_op;
	}

	public void setCr_op(double cr_op) {
		this.cr_op = cr_op;
	}

	public double getCr_ob() {
		return cr_ob;
	}

	public void setCr_ob(double cr_ob) {
		this.cr_ob = cr_ob;
	}

	public double getCr_cf() {
		return cr_cf;
	}

	public void setCr_cf(double cr_cf) {
		this.cr_cf = cr_cf;
	}

	public double getCr_pe() {
		return cr_pe;
	}

	public void setCr_pe(double cr_pe) {
		this.cr_pe = cr_pe;
	}

	public double getCr_tf() {
		return cr_tf;
	}

	public void setCr_tf(double cr_tf) {
		this.cr_tf = cr_tf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + activo;
		long temp;
		temp = Double.doubleToLongBits(cr_cf);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(cr_fb);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(cr_ob);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(cr_op);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(cr_pe);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(cr_sup);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(cr_tf);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(notaMedia);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + num_exp;
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
		if (Double.doubleToLongBits(cr_cf) != Double.doubleToLongBits(other.cr_cf))
			return false;
		if (Double.doubleToLongBits(cr_fb) != Double.doubleToLongBits(other.cr_fb))
			return false;
		if (Double.doubleToLongBits(cr_ob) != Double.doubleToLongBits(other.cr_ob))
			return false;
		if (Double.doubleToLongBits(cr_op) != Double.doubleToLongBits(other.cr_op))
			return false;
		if (Double.doubleToLongBits(cr_pe) != Double.doubleToLongBits(other.cr_pe))
			return false;
		if (Double.doubleToLongBits(cr_sup) != Double.doubleToLongBits(other.cr_sup))
			return false;
		if (Double.doubleToLongBits(cr_tf) != Double.doubleToLongBits(other.cr_tf))
			return false;
		if (Double.doubleToLongBits(notaMedia) != Double.doubleToLongBits(other.notaMedia))
			return false;
		if (num_exp != other.num_exp)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Expediente [num_exp=" + num_exp + ", activo=" + activo + ", notaMedia=" + notaMedia + ", cr_sup="
				+ cr_sup + ", cr_fb=" + cr_fb + ", cr_op=" + cr_op + ", cr_ob=" + cr_ob + ", cr_cf=" + cr_cf
				+ ", cr_pe=" + cr_pe + ", cr_tf=" + cr_tf + "]";
	}
	
	
	
}
