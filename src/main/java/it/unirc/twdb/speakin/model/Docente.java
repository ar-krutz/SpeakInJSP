package it.unirc.twdb.speakin.model;
import java.util.Date;

public class Docente {
	private int codiceDocente;
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String codiceFiscale;
	private String indirizzo; 
	private String indirizzoEMail;
	private String numeroTelefono; 
	private double stipendio;
	private String lingua;
	
	public Docente(int codiceDocente, String nome, String cognome, Date dataNascita, String codiceFiscale,
			String indirizzo, String indirizzoEMail, String numeroTelefono, double stipendio, String lingua) {
		super();
		this.codiceDocente = codiceDocente;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.codiceFiscale = codiceFiscale;
		this.indirizzo = indirizzo;
		this.indirizzoEMail = indirizzoEMail;
		this.numeroTelefono = numeroTelefono;
		this.stipendio = stipendio;
		this.lingua = lingua;
	}

	public Docente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Docente [codiceDocente=" + codiceDocente + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita="
				+ dataNascita + ", codiceFiscale=" + codiceFiscale + ", indirizzo=" + indirizzo + ", indirizzoEMail="
				+ indirizzoEMail + ", numeroTelefono=" + numeroTelefono + ", stipendio=" + stipendio + ", lingua="
				+ lingua + "]";
	}

	public int getCodiceDocente() {
		return codiceDocente;
	}

	public void setCodiceDocente(int codiceDocente) {
		this.codiceDocente = codiceDocente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getIndirizzoEMail() {
		return indirizzoEMail;
	}

	public void setIndirizzoEMail(String indirizzoEMail) {
		this.indirizzoEMail = indirizzoEMail;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public double getStipendio() {
		return stipendio;
	}

	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}

	public String getLingua() {
		return lingua;
	}

	public void setLingua(String lingua) {
		this.lingua = lingua;
	}
	
}
