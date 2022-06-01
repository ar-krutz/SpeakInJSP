package it.unirc.twdb.speakin.model;

import java.util.Date;

public class Ordina {
	private int codiceordine;
	private int segretario;
	private int fornitore;
	private int libro;
	private Date data;
	private int numerolibri;
	public Ordina() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ordina(int codiceordina, int segretario, int fornitore, int libro, Date data, int numerolibri) {
		super();
		this.codiceordine = codiceordina;
		this.segretario = segretario;
		this.fornitore = fornitore;
		this.libro = libro;
		this.data = data;
		this.numerolibri = numerolibri;
	}
	public int getCodiceOrdine() {
		return codiceordine;
	}
	public void setCodiceOrdine(int codiceordine) {
		this.codiceordine = codiceordine;
	}
	public int getSegretario() {
		return segretario;
	}
	public void setSegretario(int segretario) {
		this.segretario = segretario;
	}
	public int getFornitore() {
		return fornitore;
	}
	public void setFornitore(int fornitore) {
		this.fornitore = fornitore;
	}
	public int getLibro() {
		return libro;
	}
	public void setLibro(int libro) {
		this.libro = libro;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getNumerolibri() {
		return numerolibri;
	}
	public void setNumerolibri(int numerolibri) {
		this.numerolibri = numerolibri;
	}
	@Override
	public String toString() {
		return "Ordina [codiceordina=" + codiceordine + ", segretario=" + segretario + ", fornitore=" + fornitore
				+ ", libro=" + libro + ", data=" + data + ", numerolibri=" + numerolibri + "]";
	}
	
	
}
