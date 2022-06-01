package it.unirc.twdb.speakin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Vector;

import it.unirc.twdb.speakin.model.Paga;
import it.unirc.twdb.speakin.utils.DBManager;

public class PagaDAO {
	private static Connection conn = null;

	public boolean salva(Paga paga) {
		String query = "INSERT INTO paga (studente, corso, data) VALUES (?, ?, ?)";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, paga.getStudente());
			ps.setInt(2, paga.getCorso());
			ps.setDate(3, new Date(paga.getData().getTime()));

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean aggiorna(Paga paga) {
		String query = "UPDATE paga SET studente=?, corso=?, data=? WHERE codicepaga=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, paga.getStudente());
			ps.setInt(2, paga.getCorso());
			ps.setDate(3, new Date(paga.getData().getTime()));
			ps.setInt(4, paga.getCodicepaga());
			
			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBManager.closeConnection();
		return esito;
	}

	public Vector<Paga> get(Paga pagamento, int operation) {
		String query = "SELECT * FROM paga";
		if (operation == 0) {
			query += " WHERE codicepaga=?";
		} else if (operation == 1) {
			query += " WHERE studente=?";
		} else if (operation == 2) {
			query += " WHERE corso=?";
		}
		
		Vector<Paga> res = new Vector<Paga>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			if (operation == 0) {
				ps.setInt(1, pagamento.getCodicepaga());
			} else if (operation == 1) {
				ps.setInt(1, pagamento.getStudente());
			} else if (operation == 2) {
				ps.setInt(1, pagamento.getCorso());
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Paga insegnares = recordToPaga(rs);
				res.add(insegnares);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public Vector<Paga> getAll() {
		return get(new Paga(), -1);
	}


	private Paga recordToPaga(ResultSet rs) throws SQLException {
		Paga res = new Paga();
		res.setCodicepaga(rs.getInt("codicepaga"));
		res.setStudente(rs.getInt(2));
		res.setCorso(rs.getInt(3));
		res.setData(rs.getDate(4));
		return res;
	}

}
