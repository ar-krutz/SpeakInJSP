package it.unirc.twdb.speakin.model;

public class Classe {
	private int codiceClasse;
	private String sigla;
	private int anno;
	private int libro;
	private int corso;

	public int getCodiceClasse() {
		return codiceClasse;
	}

	public void setCodiceClasse(int codiceClasse) {
		this.codiceClasse = codiceClasse;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public int getLibro() {
		return libro;
	}

	public void setLibro(int libro) {
		this.libro = libro;
	}

	public int getCorso() {
		return corso;
	}

	public void setCorso(int corso) {
		this.corso = corso;
	}

	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Classe(int codiceClasse, String sigla, int anno, int libro, int corso) {
		super();
		this.codiceClasse = codiceClasse;
		this.sigla = sigla;
		this.anno = anno;
		this.libro = libro;
		this.corso = corso;
	}

	@Override
	public String toString() {
		return "Classe [codiceClasse=" + codiceClasse + ", sigla=" + sigla + ", anno=" + anno + ", libro=" + libro
				+ ", corso=" + corso + "]";
	}
}
