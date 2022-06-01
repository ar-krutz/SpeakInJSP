package it.unirc.twdb.speakin.model;

import java.util.Date;

public class Insegna {
	private int codiceinsegna;
	private int docente;
	private int corso;
	private Date datainizio;
	private Date datafine;
	public Insegna() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Insegna(int codiceinsegna, int docente, int corso, Date datainizio, Date datafine) {
		super();
		this.codiceinsegna = codiceinsegna;
		this.docente = docente;
		this.corso = corso;
		this.datainizio = datainizio;
		this.datafine = datafine;
	}
	public int getCodiceinsegna() {
		return codiceinsegna;
	}
	public void setCodiceinsegna(int codiceinsegna) {
		this.codiceinsegna = codiceinsegna;
	}
	public int getDocente() {
		return docente;
	}
	public void setDocente(int docente) {
		this.docente = docente;
	}
	public int getCorso() {
		return corso;
	}
	public void setCorso(int corso) {
		this.corso = corso;
	}
	public Date getDatainizio() {
		return datainizio;
	}
	public void setDatainizio(Date datainizio) {
		this.datainizio = datainizio;
	}
	public Date getDatafine() {
		return datafine;
	}
	public void setDatafine(Date datafine) {
		this.datafine = datafine;
	}
	@Override
	public String toString() {
		return "Insegna [codiceinsegna=" + codiceinsegna + ", docente=" + docente + ", corso=" + corso + ", datainizio="
				+ datainizio + ", datafine=" + datafine + "]";
	}

	

}
