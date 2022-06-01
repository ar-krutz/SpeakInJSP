package it.unirc.twdb.speakin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.unirc.twdb.speakin.model.Corso;
import it.unirc.twdb.speakin.utils.DBManager;

public class CorsoDAO {
	private static Connection conn = null;

	private Corso recordToCorso(ResultSet rs) throws SQLException {
		Corso res = new Corso();
		res.setCodiceCorso(rs.getInt("codicecorso"));
		res.setLingua(rs.getString(2));
		res.setLivello(rs.getString(3));
		res.setPrezzo(rs.getDouble(4));
		return res;
	}
	
	public Vector<Corso> get(Corso corso, int operation) {
		String query = "SELECT * FROM corso";
		if (operation == 0) {
			query += " WHERE codiceCorso=?";
		} else if (operation == 1) {
			query += " WHERE lingua=?";
		} else if (operation == 2) {
			query += " WHERE livello=?";
		}
		Vector<Corso> res = new Vector<Corso>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			if (operation == 0) {
				ps.setInt(1, corso.getCodiceCorso());
			} else if (operation == 1) {
				ps.setString(1, corso.getLingua());
			} else if (operation == 2) {
				ps.setString(1, corso.getLivello());
			}

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Corso corsores = recordToCorso(rs);
				res.add(corsores);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public Vector<Corso> getAll() {
		return get(new Corso(), -1);
	}

	public boolean salva(Corso corso) {
		String query = "INSERT INTO corso (lingua, livello, prezzo) VALUES (?, ?, ?) ";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, corso.getLingua());
			ps.setString(2, corso.getLivello());
			ps.setDouble(3, corso.getPrezzo());

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBManager.closeConnection();
		return esito;
	}

	public boolean aggiorna(Corso corso) {

		String query = "UPDATE corso SET lingua=?, livello=?, prezzo=? WHERE codicecorso=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, corso.getLingua());
			ps.setString(2, corso.getLivello());
			ps.setDouble(3, corso.getPrezzo());
			ps.setInt(4, corso.getCodiceCorso());

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
