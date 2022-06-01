package it.unirc.twdb.speakin.model;

import java.util.Date;

public class Calendario {
	private int CodiceLezione;
	private Date Data;
	private int NumeroOre;
	private String Aula;
	private String Sigla;
	private String Lingua;
	private String Livello;
	private String Nome;
	private String Cognome;

	public int getCodiceLezione() {
		return CodiceLezione;
	}

	public void setCodiceLezione(int codiceLezione) {
		CodiceLezione = codiceLezione;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

	public int getNumeroOre() {
		return NumeroOre;
	}

	public void setNumeroOre(int numeroOre) {
		NumeroOre = numeroOre;
	}

	public String getAula() {
		return Aula;
	}

	public void setAula(String aula) {
		Aula = aula;
	}

	public String getSigla() {
		return Sigla;
	}

	public void setSigla(String sigla) {
		Sigla = sigla;
	}

	public String getLingua() {
		return Lingua;
	}

	public void setLingua(String lingua) {
		Lingua = lingua;
	}

	public String getLivello() {
		return Livello;
	}

	public void setLivello(String livello) {
		Livello = livello;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String cognome) {
		Cognome = cognome;
	}

	@Override
	public String toString() {
		return "Calendario [CodiceLezione=" + CodiceLezione + ", Data=" + Data + ", NumeroOre=" + NumeroOre + ", Aula="
				+ Aula + ", Sigla=" + Sigla + ", Lingua=" + Lingua + ", Livello=" + Livello + ", Nome=" + Nome
				+ ", Cognome=" + Cognome + "]";
	}

	public Calendario(int codiceLezione, Date data, int numeroOre, String aula, String sigla, String lingua,
			String livello, String nome, String cognome) {
		super();
		CodiceLezione = codiceLezione;
		Data = data;
		NumeroOre = numeroOre;
		Aula = aula;
		Sigla = sigla;
		Lingua = lingua;
		Livello = livello;
		Nome = nome;
		Cognome = cognome;
	}

	public Calendario() {
		super();
		// TODO Auto-generated constructor stub
	}

}
