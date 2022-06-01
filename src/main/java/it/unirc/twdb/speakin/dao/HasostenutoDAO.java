package it.unirc.twdb.speakin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.unirc.twdb.speakin.model.Hasostenuto;
import it.unirc.twdb.speakin.utils.DBManager;

public class HasostenutoDAO {
	private static Connection conn = null;

	public boolean salva(Hasostenuto hasostenuto) {
		String query = "INSERT INTO hasostenuto VALUES (?, ?, ?, ?, ?)";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, hasostenuto.getCodicehasostenuto());
			ps.setInt(2, hasostenuto.getStudente());
			ps.setInt(3, hasostenuto.getEsame());
			ps.setString(4, hasostenuto.getEsito());
			ps.setInt(5, hasostenuto.getPunteggio());

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean aggiorna(Hasostenuto hasostenuto) {
		String query = "UPDATE hasostenuto SET studente=?, esame=?, esito=?, punteggio=? WHERE codicehasostenuto=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, hasostenuto.getStudente());
			ps.setInt(2, hasostenuto.getEsame());
			ps.setString(3, hasostenuto.getEsito());
			ps.setInt(4, hasostenuto.getPunteggio());
			ps.setInt(5, hasostenuto.getCodicehasostenuto());

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBManager.closeConnection();
		return esito;
	}
	
	
	public Vector<Hasostenuto> get(Hasostenuto sostenuto, int operation) {
		String query = "SELECT * FROM hasostenuto";
		if (operation == 0) {
			query += " WHERE codicehasostenuto=?";
		} else if (operation == 1) {
			query += " WHERE studente=?";
		} else if (operation == 2) {
			query += " WHERE esame=?";
		}
		
		Vector<Hasostenuto> res = new Vector<Hasostenuto>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			if (operation == 0) {
				ps.setInt(1, sostenuto.getCodicehasostenuto());
			} else if (operation == 1) {
				ps.setInt(1, sostenuto.getStudente());
			} else if (operation == 2) {
				ps.setInt(1, sostenuto.getEsame());
			}

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Hasostenuto Hasostenutores = recordToHasostenuto(rs);
				res.add(Hasostenutores);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public Vector<Hasostenuto> getAll() {
		return get(new Hasostenuto(), -1);
	}

	private Hasostenuto recordToHasostenuto(ResultSet rs) throws SQLException {
		Hasostenuto res = new Hasostenuto();
		res.setCodicehasostenuto(rs.getInt("codicehasostenuto"));
		res.setStudente(rs.getInt(2));
		res.setEsame(rs.getInt(3));
		res.setEsito(rs.getString(4));
		res.setPunteggio(rs.getInt(5));
		return res;
	}
}
