package it.unirc.twdb.speakin.model;

public class Eiscritto {
	private int studente;
	private int classe;
	public Eiscritto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Eiscritto(int studente, int classe) {
		super();
		this.studente = studente;
		this.classe = classe;
	}
	public int getStudente() {
		return studente;
	}
	public void setStudente(int studente) {
		this.studente = studente;
	}
	public int getClasse() {
		return classe;
	}
	public void setClasse(int classe) {
		this.classe = classe;
	}
	@Override
	public String toString() {
		return "Eiscritto [studente=" + studente + ", classe=" + classe + "]";
	}
	
	

	
}
