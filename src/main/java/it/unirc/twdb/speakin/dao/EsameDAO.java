package it.unirc.twdb.speakin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;

import it.unirc.twdb.speakin.model.Esame;
import it.unirc.twdb.speakin.utils.DBManager;

public class EsameDAO {
	private static Connection conn = null;

	private Esame recordToEsame(ResultSet rs) throws SQLException {
		Esame res = new Esame();
		res.setCodiceEsame(rs.getInt("codiceesame"));
		res.setData(new Timestamp(rs.getTimestamp(2).getTime()));
		res.setEnte(rs.getString(3));
		res.setCorso(rs.getInt(4));
		return res;
	}

	public Vector<Esame> get(Esame esami, int operation) {
		String query = "SELECT * FROM esame";
		if (operation == 0) {
			query += " WHERE codiceesame=?";
		} else if (operation == 1) {
			query += " WHERE data LIKE CONCAT( '%',?,'%')";
		} else if (operation == 2) {
			query += " WHERE ente=?";
		} else if (operation == 3) {
			query += " WHERE corso=?";
		}
		
		Vector<Esame> res = new Vector<Esame>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			if (operation == 0) {
				ps.setInt(1, esami.getCodiceEsame());
			} else if (operation == 1) {
				Date data = new Date(esami.getData().getTime());
				ps.setDate(1, data);
			} else if (operation == 2) {
				ps.setString(1, esami.getEnte());
			} else if (operation == 3) {
				ps.setInt(1, esami.getCorso());
			}

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Esame esameres = recordToEsame(rs);
				res.add(esameres);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public Vector<Esame> getAll() {
		return get(new Esame(), -1);
	}

	public boolean salva(Esame esame) {
		String query = "INSERT INTO esame (data, ente, corso) VALUES (?, ?, ?)";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setObject(1, new java.sql.Timestamp(esame.getData().getTime()));
			ps.setString(2, esame.getEnte());
			ps.setInt(3, esame.getCorso());

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBManager.closeConnection();
		return esito;
	}

	public boolean aggiorna(Esame esame) {

		String query = "UPDATE esame SET data=?, ente=?, corso=? WHERE codiceesame=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setObject(1, new java.sql.Timestamp(esame.getData().getTime()));
			ps.setString(2, esame.getEnte());
			ps.setInt(3, esame.getCorso());
			ps.setInt(4, esame.getCodiceEsame());

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
