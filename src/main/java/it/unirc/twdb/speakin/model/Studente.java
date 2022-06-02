package it.unirc.twdb.speakin.model;
import java.io.File;
import java.util.Date;

public class Studente {
	private int matricola;
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String codiceFiscale;
	private String indirizzo;
	private String indirizzoEMail;
	private String numeroTelefono;
	
	public Studente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Studente(int matricola, String nome, String cognome, Date dataNascita, String codiceFiscale,
			String indirizzo, String indirizzoEmail, String numeroTelefono) {
		super();
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.codiceFiscale = codiceFiscale;
		this.indirizzo = indirizzo;
		this.indirizzoEMail = indirizzoEmail;
		this.numeroTelefono = numeroTelefono;
	}

	
	
	public Studente(String nome, String cognome, Date dataNascita, String codiceFiscale, String indirizzo,
			String indirizzoEMail, String numeroTelefono) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.codiceFiscale = codiceFiscale;
		this.indirizzo = indirizzo;
		this.indirizzoEMail = indirizzoEMail;
		this.numeroTelefono = numeroTelefono;
	}

	public Studente(int matricola) {
		this.matricola=matricola;
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
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

	public void setIndirizzoEMail(String indirizzoEmail) {
		this.indirizzoEMail = indirizzoEmail;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	
	public String getPicPath(String realPath) {
		String path = "images/Studenti/" + this.matricola;
		File check = new File(realPath + path);
		if(check.exists()==false) path = "images/standard.jpg";
		return path;
	}

	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita="
				+ dataNascita + ", codicefiscale=" + codiceFiscale + ", indirizzo=" + indirizzo + ", indirizzoemail="
				+ indirizzoEMail + ", numerotelefono=" + numeroTelefono + "]";
	}
}
	
	






