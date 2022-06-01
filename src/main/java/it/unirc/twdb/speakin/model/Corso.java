package it.unirc.twdb.speakin.model;

public class Corso {
	private int codiceCorso;
	private String lingua;
	private String livello;
	private double prezzo;

	public Corso(int codiceCorso, String lingua, String livello, double prezzo) {
		super();
		this.codiceCorso = codiceCorso;
		this.lingua = lingua;
		this.livello = livello;
		this.prezzo = prezzo;
	}

	public Corso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Corso(int codiceCorso) {
		this.codiceCorso = codiceCorso;
	}

	@Override
	public String toString() {
		return "Corso [codiceCorso=" + codiceCorso + ", lingua=" + lingua + ", livello=" + livello + ", prezzo="
				+ prezzo + "]";
	}

	public int getCodiceCorso() {
		return codiceCorso;
	}

	public void setCodiceCorso(int codiceCorso) {
		this.codiceCorso = codiceCorso;
	}

	public String getLingua() {
		return lingua;
	}

	public void setLingua(String lingua) {
		this.lingua = lingua;
	}

	public String getLivello() {
		return livello;
	}

	public void setLivello(String livello) {
		this.livello = livello;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

}
