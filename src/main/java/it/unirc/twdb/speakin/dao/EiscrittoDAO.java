package it.unirc.twdb.speakin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.unirc.twdb.speakin.model.Eiscritto;
import it.unirc.twdb.speakin.model.Studente;
import it.unirc.twdb.speakin.model.Classe;
import it.unirc.twdb.speakin.utils.DBManager;

public class EiscrittoDAO {
	private static Connection conn = null;

	public boolean salva(Eiscritto eiscritto) {
		String query = "INSERT INTO eiscritto VALUES (? , ?)";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, eiscritto.getStudente());
			ps.setInt(2, eiscritto.getClasse());

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean checkIscritto(Studente studente, Classe classe) {
		String query = "SELECT * FROM eiscritto WHERE studente=? AND classe=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, studente.getMatricola());
			ps.setInt(2, classe.getCodiceClasse());

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				esito=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return esito;
	}
	
	public Vector<Eiscritto> get(Eiscritto iscrizione, int operation) {
		String query = "SELECT * FROM eiscritto";
		if (operation == 0) {
			query += " WHERE studente=?";
		} else if (operation == 1) {
			query += " WHERE classe=?";
		}
		
		Vector<Eiscritto> res = new Vector<Eiscritto>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			if (operation == 0) {
				ps.setInt(1, iscrizione.getStudente());
			} else if (operation == 1) {
				ps.setInt(1, iscrizione.getClasse());
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Eiscritto presenzeres = recordToEiscritto(rs);
				res.add(presenzeres);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public Vector<Eiscritto> getAll() {
		return get(new Eiscritto(), -1);
	}

	public boolean cancella(Eiscritto iscritto) {
		String query = "DELETE FROM eiscritto WHERE studente=? AND classe=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, iscritto.getStudente());
			ps.setInt(2, iscritto.getClasse());

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	private Eiscritto recordToEiscritto(ResultSet rs) throws SQLException {
		Eiscritto res = new Eiscritto();
		res.setStudente(rs.getInt(1));
		res.setClasse(rs.getInt(2));
		return res;
	}

}
