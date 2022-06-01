package it.unirc.twdb.speakin.model;

import java.util.Date;

public class Paga {
	private int codicepaga;
	private int studente;
	private int corso;
	private Date data;
	public Paga() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Paga(int codicepaga, int studente, int corso, Date data) {
		super();
		this.codicepaga = codicepaga;
		this.studente = studente;
		this.corso = corso;
		this.data = data;
	}
	public int getCodicepaga() {
		return codicepaga;
	}
	public void setCodicepaga(int codicepaga) {
		this.codicepaga = codicepaga;
	}
	public int getStudente() {
		return studente;
	}
	public void setStudente(int studente) {
		this.studente = studente;
	}
	public int getCorso() {
		return corso;
	}
	public void setCorso(int corso) {
		this.corso = corso;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Paga [codicepaga=" + codicepaga + ", studente=" + studente + ", corso=" + corso + ", data=" + data
				+ "]";
	}
	

	

}