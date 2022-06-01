package it.unirc.twdb.speakin.model;

public class Hafrequentato {
	
	private int studente;
	private int lezione;
	public Hafrequentato() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hafrequentato(int studente, int lezione) {
		super();
		this.studente = studente;
		this.lezione = lezione;
	}
	public int getStudente() {
		return studente;
	}
	public void setStudente(int studente) {
		this.studente = studente;
	}
	public int getLezione() {
		return lezione;
	}
	public void setLezione(int lezione) {
		this.lezione = lezione;
	}
	@Override
	public String toString() {
		return "Hafrequentato [studente=" + studente + ", lezione=" + lezione + "]";
	}
	
		

}
