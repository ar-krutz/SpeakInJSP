package it.unirc.twdb.speakin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.unirc.twdb.speakin.model.Lezione;
import it.unirc.twdb.speakin.utils.DBManager;

public class LezioneDAO {
	private static Connection conn = null;

	private Lezione recordToLezione(ResultSet rs) throws SQLException {
		Lezione res = new Lezione();
		res.setCodiceLezione(rs.getInt("codicelezione"));
		res.setData(new Timestamp(rs.getTimestamp(2).getTime()));
		res.setNumeroOre(rs.getInt(3));
		res.setAula(rs.getString(4));
		res.setArgomento(rs.getString(5));
		res.setModulo(rs.getString(6));
		res.setClasse(rs.getInt(7));
		res.setDocente(rs.getInt(8));
		return res;
	}

	public Vector<Lezione> get(Lezione lezioni, int operation) {
		String query = "SELECT * FROM lezione";
		if (operation == 0) {
			query += " WHERE codicelezione=?";
		} else if (operation == 1) {
			query += " WHERE data LIKE CONCAT( '%',?,'%')";
		} else if (operation == 2) {
			query += " WHERE classe=?";
		} else if (operation == 3) {
			query += " WHERE docente=?";
		}

		Vector<Lezione> res = new Vector<Lezione>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			if (operation == 0) {
				ps.setInt(1, lezioni.getCodiceLezione());
			} else if (operation == 1) {
				Date dataNascita = new Date(lezioni.getData().getTime());
				ps.setDate(1, dataNascita);
			} else if (operation == 2) {
				ps.setInt(1, lezioni.getClasse());
			} else if (operation == 3) {
				ps.setInt(1, lezioni.getDocente());
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Lezione studenteres = recordToLezione(rs);
				res.add(studenteres);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public Vector<Lezione> getAll() {
		return get(new Lezione(), -1);
	}

	public boolean salva(Lezione lezione) {
		String query = "INSERT INTO lezione (data, numeroore, aula, argomento, modulo, classe, docente) VALUES (?, ?, ?, ?, ?, ?, ?)";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setObject(1, new java.sql.Timestamp(lezione.getData().getTime()));
			ps.setInt(2, lezione.getNumeroOre());
			ps.setString(3, lezione.getAula());
			ps.setString(4, lezione.getArgomento());
			ps.setString(5, lezione.getModulo());
			ps.setInt(6, lezione.getClasse());
			ps.setInt(7, lezione.getDocente());

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBManager.closeConnection();
		return esito;
	}

	public boolean aggiorna(Lezione lezione) {

		String query = "UPDATE lezione SET data=?, numeroore=?, aula=?, argomento=?, modulo=?, classe=?, docente=? WHERE codicelezione=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setObject(1, new java.sql.Timestamp(lezione.getData().getTime()));
			ps.setInt(2, lezione.getNumeroOre());
			ps.setString(3, lezione.getAula());
			ps.setString(4, lezione.getArgomento());
			ps.setString(5, lezione.getModulo());
			ps.setInt(6, lezione.getClasse());
			ps.setInt(7, lezione.getDocente());
			ps.setInt(8, lezione.getCodiceLezione());

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
