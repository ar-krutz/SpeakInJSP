package it.unirc.twdb.speakin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.unirc.twdb.speakin.model.Hafrequentato;
import it.unirc.twdb.speakin.utils.DBManager;

public class HafrequentatoDAO {
	private static Connection conn = null;

	public boolean salva(Hafrequentato hafrequentato) {
		String query = "INSERT INTO hafrequentato VALUES (?, ?)";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, hafrequentato.getStudente());
			ps.setInt(2, hafrequentato.getLezione());

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public Vector<Hafrequentato> get(Hafrequentato presenze, int operation) {
		String query = "SELECT * FROM hafrequentato";
		if (operation == 0) {
			query += " WHERE studente=?";
		} else if (operation == 1) {
			query += " WHERE lezione=?";
		}
		
		Vector<Hafrequentato> res = new Vector<Hafrequentato>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			if (operation == 0) {
				ps.setInt(1, presenze.getStudente());
			} else if (operation == 1) {
				ps.setInt(1, presenze.getLezione());
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Hafrequentato presenzeres = recordToHafrequentato(rs);
				res.add(presenzeres);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public Vector<Hafrequentato> getAll() {
		return get(new Hafrequentato(), -1);
	}

	private Hafrequentato recordToHafrequentato(ResultSet rs) throws SQLException {
		Hafrequentato res = new Hafrequentato();
		res.setStudente(rs.getInt(1));
		res.setLezione(rs.getInt(2));
		return res;
	}

	public boolean cancella(Hafrequentato iscritto) {
		String query = "DELETE FROM hafrequentato WHERE studente=? AND lezione=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, iscritto.getStudente());			
			ps.setInt(2, iscritto.getLezione());

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
}
