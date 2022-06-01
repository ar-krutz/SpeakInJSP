package it.unirc.twdb.speakin.model;

public class Libro {
	private int codicelibro;
	private String codiceISBN;
	private String titolo;
	private String autore;
	private String casaEditrice;
	private double prezzo;

	public int getCodicelibro() {
		return codicelibro;
	}

	public void setCodicelibro(int codicelibro) {
		this.codicelibro = codicelibro;
	}

	public String getCodiceISBN() {
		return codiceISBN;
	}

	public void setCodiceISBN(String codiceISBN) {
		this.codiceISBN = codiceISBN;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getCasaEditrice() {
		return casaEditrice;
	}

	public void setCasaEditrice(String casaEditrice) {
		this.casaEditrice = casaEditrice;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "Libro [codicelibro=" + codicelibro + ", codiceISBN=" + codiceISBN + ", titolo=" + titolo + ", autore="
				+ autore + ", casaEditrice=" + casaEditrice + ", prezzo=" + prezzo + "]";
	}

	public Libro(int codicelibro, String codiceISBN, String titolo, String autore, String casaEditrice, double prezzo) {
		super();
		this.codicelibro = codicelibro;
		this.codiceISBN = codiceISBN;
		this.titolo = titolo;
		this.autore = autore;
		this.casaEditrice = casaEditrice;
		this.prezzo = prezzo;
	}

	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}

}
