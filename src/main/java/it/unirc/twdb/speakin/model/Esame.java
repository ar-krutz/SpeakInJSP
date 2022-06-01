package it.unirc.twdb.speakin.model;

import java.util.Date;

public class Esame {
	private int codiceEsame;
	private Date data;
	private String ente;
	private int Corso;

	public int getCodiceEsame() {
		return codiceEsame;
	}

	public void setCodiceEsame(int codiceEsame) {
		this.codiceEsame = codiceEsame;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getEnte() {
		return ente;
	}

	public void setEnte(String ente) {
		this.ente = ente;
	}

	public int getCorso() {
		return Corso;
	}

	public void setCorso(int corso) {
		Corso = corso;
	}

	@Override
	public String toString() {
		return "Esame [codiceEsame=" + codiceEsame + ", data=" + data + ", ente=" + ente + ", Corso=" + Corso + "]";
	}

	public Esame(int codiceEsame, Date data, String ente, int corso) {
		super();
		this.codiceEsame = codiceEsame;
		this.data = data;
		this.ente = ente;
		Corso = corso;
	}

	public Esame() {
		super();
		// TODO Auto-generated constructor stub
	}

}
