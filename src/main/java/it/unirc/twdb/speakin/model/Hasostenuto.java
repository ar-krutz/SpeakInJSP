package it.unirc.twdb.speakin.model;

public class Hasostenuto {
	private int codicehasostenuto;
	private int studente;
	private int esame;
	private String esito;
	private int punteggio;
	public Hasostenuto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hasostenuto(int codicehasostenuto, int studente, int esame, String esito, int punteggio) {
		super();
		this.codicehasostenuto = codicehasostenuto;
		this.studente = studente;
		this.esame = esame;
		this.esito = esito;
		this.punteggio = punteggio;
	}
	public int getCodicehasostenuto() {
		return codicehasostenuto;
	}
	public void setCodicehasostenuto(int codicehasostenuto) {
		this.codicehasostenuto = codicehasostenuto;
	}
	public int getStudente() {
		return studente;
	}
	public void setStudente(int studente) {
		this.studente = studente;
	}
	public int getEsame() {
		return esame;
	}
	public void setEsame(int esame) {
		this.esame = esame;
	}
	public String getEsito() {
		return esito;
	}
	public void setEsito(String esito) {
		this.esito = esito;
	}
	public int getPunteggio() {
		return punteggio;
	}
	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}
	@Override
	public String toString() {
		return "Hasostenuto [codicehasostenuto=" + codicehasostenuto + ", studente=" + studente + ", esame=" + esame
				+ ", esito=" + esito + ", punteggio=" + punteggio + "]";
	}
	

}
