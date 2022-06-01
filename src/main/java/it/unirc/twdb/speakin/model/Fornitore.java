package it.unirc.twdb.speakin.model;

public class Fornitore {
	private int codiceFornitore;
	private String Nome;
	private String indirizzo;
	private String indirizzoEMail;
	private String telefono;
	private String fax;
	private String partitaIVA;

	public Fornitore(int codiceFornitore, String nome, String indirizzo, String indirizzoEMail, String telefono,
			String fax, String partitaIVA) {
		super();
		this.codiceFornitore = codiceFornitore;
		Nome = nome;
		this.indirizzo = indirizzo;
		this.indirizzoEMail = indirizzoEMail;
		this.telefono = telefono;
		this.fax = fax;
		this.partitaIVA = partitaIVA;
	}

	public Fornitore() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Fornitore [codiceFornitore=" + codiceFornitore + ", Nome=" + Nome + ", indirizzo=" + indirizzo
				+ ", indirizzoEMail=" + indirizzoEMail + ", telefono=" + telefono + ", fax=" + fax + ", partitaIVA="
				+ partitaIVA + "]";
	}

	public int getCodiceFornitore() {
		return codiceFornitore;
	}

	public void setCodiceFornitore(int codiceFornitore) {
		this.codiceFornitore = codiceFornitore;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPartitaIVA() {
		return partitaIVA;
	}

	public void setPartitaIVA(String partitaIVA) {
		this.partitaIVA = partitaIVA;
	}

}
