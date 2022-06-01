package it.unirc.twdb.speakin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.unirc.twdb.speakin.model.Fornitore;
import it.unirc.twdb.speakin.utils.DBManager;

public class FornitoreDAO {
	private static Connection conn = null;

	private Fornitore recordToFornitore(ResultSet rs) throws SQLException {
		Fornitore res = new Fornitore();
		res.setCodiceFornitore(rs.getInt("codicefornitore"));
		res.setNome(rs.getString(2));
		res.setIndirizzo(rs.getString(3));
		res.setIndirizzoEMail(rs.getString(4));
		res.setTelefono(rs.getString(5));
		res.setFax(rs.getString(6));
		res.setPartitaIVA(rs.getString(7));
		return res;
	}

	public Vector<Fornitore> get(Fornitore fornitore, int operation) {
		String query = "SELECT * FROM fornitore";
		if (operation == 0) {
			query += " WHERE codicefornitore=?";
		} else if (operation == 1) {
			query += " WHERE nome=?";
		} else if (operation == 2) {
			query += " WHERE partitaiva=?";
		}
		
		Vector<Fornitore> res = new Vector<Fornitore>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			if (operation == 0) {
				ps.setInt(1, fornitore.getCodiceFornitore());
			} else if (operation == 1) {
				ps.setString(1, fornitore.getNome());
			} else if (operation == 2) {
				ps.setString(1, fornitore.getPartitaIVA());
			}

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Fornitore fornitoreres = recordToFornitore(rs);
				res.add(fornitoreres);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public Vector<Fornitore> getAll() {
		return get(new Fornitore(), -1);
	}

	public boolean salva(Fornitore fornitore) {
		String query = "INSERT INTO fornitore (nome, indirizzo, indirizzoemail, numerotelefono, fax, partitaiva) VALUES (?, ?, ?, ?, ?, ?)";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, fornitore.getNome());
			ps.setString(2, fornitore.getIndirizzo());
			ps.setString(3, fornitore.getIndirizzoEMail());
			ps.setString(4, fornitore.getTelefono());
			ps.setString(5, fornitore.getFax());
			ps.setString(6, fornitore.getPartitaIVA());

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBManager.closeConnection();
		return esito;
	}

	public boolean aggiorna(Fornitore fornitore) {

		String query = "UPDATE fornitore SET nome=?, indirizzo=?, indirizzoemail=?, numerotelefono=?, fax=?, partitaiva=? WHERE codicefornitore=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, fornitore.getNome());
			ps.setString(2, fornitore.getIndirizzo());
			ps.setString(3, fornitore.getIndirizzoEMail());
			ps.setString(4, fornitore.getTelefono());
			ps.setString(5, fornitore.getFax());
			ps.setString(6, fornitore.getPartitaIVA());
			ps.setInt(7, fornitore.getCodiceFornitore());

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
