package it.unirc.twdb.speakin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.unirc.twdb.speakin.model.Ordina;
import it.unirc.twdb.speakin.utils.DBManager;

public class OrdinaDAO {
	private static Connection conn = null;

	public boolean salva(Ordina ordina) {
		String query = "INSERT INTO ordina (data, numerolibri, libro, fornitore, segretario) VALUES (?, ?, ?, ?, ?)";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setDate(1, new Date(ordina.getData().getTime()));
			ps.setInt(2, ordina.getNumerolibri());
			ps.setInt(3, ordina.getLibro());
			ps.setInt(4, ordina.getFornitore());
			ps.setInt(5, ordina.getSegretario());

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean aggiorna(Ordina ordina) {
		String query = "UPDATE ordina SET data=?, numerolibri=?, libro=?, fornitore=?, segretario=? WHERE codiceordina=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setDate(1, new Date(ordina.getData().getTime()));
			ps.setInt(2, ordina.getNumerolibri());
			ps.setInt(3, ordina.getLibro());
			ps.setInt(4, ordina.getFornitore());
			ps.setInt(5, ordina.getSegretario());
			ps.setInt(6, ordina.getCodiceOrdine());
			
			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBManager.closeConnection();
		return esito;
	}

	public Vector<Ordina> get(Ordina ordine, int operation) {
		String query = "SELECT * FROM ordina";
		if (operation == 0) {
			query += " WHERE codiceordina=?";
		} else if (operation == 1) {
			query += " WHERE data=?";			
		} else if (operation == 2) {
			query += " WHERE libro=?";
		} else if (operation == 3) {
			query += " WHERE fornitore=?";
		} else if (operation == 4) {
			query += " WHERE segretario=?";
		}

		Vector<Ordina> res = new Vector<Ordina>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			if (operation == 0) {
				ps.setInt(1, ordine.getCodiceOrdine());
			} else if (operation == 1) {
				ps.setDate(1, new Date(ordine.getData().getTime()));			
			} else if (operation == 2) {
				ps.setInt(1, ordine.getLibro());
			} else if (operation == 3) {
				ps.setInt(1, ordine.getFornitore());
			} else if (operation == 4) {
				ps.setInt(1, ordine.getSegretario());
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Ordina studenteres = recordToOrdina(rs);
				res.add(studenteres);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public Vector<Ordina> getAll() {
		return get(new Ordina(), -1);
	}

	private Ordina recordToOrdina(ResultSet rs) throws SQLException {
		Ordina res = new Ordina();
		res.setCodiceOrdine(rs.getInt("codiceordina"));
		res.setData(rs.getDate(2));
		res.setNumerolibri(rs.getInt(3));
		res.setLibro(rs.getInt(4));
		res.setFornitore(rs.getInt(5));
		res.setSegretario(rs.getInt(6));
		return res;
	}

}
