package it.unirc.twdb.speakin.model;

import java.util.Date;

public class Lezione {
	private int codiceLezione;
	private Date data;
	
	private int numeroOre;
	private String aula;
	private String modulo;
	private String argomento;
	private int classe;
	private int docente;

	public int getCodiceLezione() {
		return codiceLezione;
	}

	public void setCodiceLezione(int codiceLezione) {
		this.codiceLezione = codiceLezione;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getNumeroOre() {
		return numeroOre;
	}

	public void setNumeroOre(int numeroOre) {
		this.numeroOre = numeroOre;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getArgomento() {
		return argomento;
	}

	public void setArgomento(String argomento) {
		this.argomento = argomento;
	}

	public int getClasse() {
		return classe;
	}

	public void setClasse(int classe) {
		this.classe = classe;
	}

	public int getDocente() {
		return docente;
	}

	public void setDocente(int docente) {
		this.docente = docente;
	}

	@Override
	public String toString() {
		return "Lezione [codiceLezione=" + codiceLezione + ", data=" + data + ", numeroOre=" + numeroOre + ", aula="
				+ aula + ", modulo=" + modulo + ", argomento=" + argomento + ", classe=" + classe + ", docente="
				+ docente + "]";
	}

	public Lezione(int codiceLezione, Date data, int numeroOre, String aula, String modulo, String argomento,
			int classe, int docente) {
		super();
		this.codiceLezione = codiceLezione;
		this.data = data;
		this.numeroOre = numeroOre;
		this.aula = aula;
		this.modulo = modulo;
		this.argomento = argomento;
		this.classe = classe;
		this.docente = docente;
	}

	public Lezione() {
		super();
		// TODO Auto-generated constructor stub
	}

}
