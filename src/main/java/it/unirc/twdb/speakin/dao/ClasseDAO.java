package it.unirc.twdb.speakin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.Types;

import it.unirc.twdb.speakin.model.Classe;
import it.unirc.twdb.speakin.utils.DBManager;

public class ClasseDAO {
	private static Connection conn = null;

	private Classe recordToClasse(ResultSet rs) throws SQLException {
		Classe res = new Classe();
		res.setCodiceClasse(rs.getInt("codiceclasse"));
		res.setSigla(rs.getString(2));
		res.setAnno(rs.getInt(3));
		res.setCorso(rs.getInt(4));
		res.setLibro(rs.getInt(5));
		return res;
	}

	public Vector<Classe> get(Classe classe, int operation) {
		String query = "SELECT * FROM classe";
		if (operation == 0) {
			query += " WHERE codiceclasse=?";
		} else if (operation == 1) {
			query += " WHERE sigla=?";
		}
		Vector<Classe> res = new Vector<Classe>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			if (operation == 0) {
				ps.setInt(1, classe.getCodiceClasse());
			} else if (operation == 1) {
				ps.setString(1, classe.getSigla());
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Classe corso = recordToClasse(rs);
				res.add(corso);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public Vector<Classe> getAll() {
		return get(new Classe(), -1);
	}

	public boolean salva(Classe classe) {
		String query = "INSERT INTO classe (sigla, anno, corso, libro) VALUES (?, ?, ?, ?)";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, classe.getSigla());
			ps.setInt(2, classe.getAnno());
			ps.setInt(3, classe.getCorso());

			if (classe.getLibro() != 0)
				ps.setInt(4, classe.getLibro());
			else
				ps.setNull(4, Types.INTEGER);

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBManager.closeConnection();
		return esito;
	}

	public boolean aggiorna(Classe classe) {

		String query = "UPDATE classe SET sigla=?, anno=?, corso=?, libro=? WHERE codiceClasse=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, classe.getSigla());
			ps.setInt(2, classe.getAnno());
			ps.setInt(3, classe.getCorso());

			if (classe.getLibro() != 0)
				ps.setInt(4, classe.getLibro());
			else
				ps.setNull(4, Types.INTEGER);

			ps.setInt(5, classe.getCodiceClasse());

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
