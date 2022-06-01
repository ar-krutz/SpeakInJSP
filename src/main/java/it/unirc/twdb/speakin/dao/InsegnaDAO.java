package it.unirc.twdb.speakin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;
import it.unirc.twdb.speakin.model.Insegna;
import it.unirc.twdb.speakin.utils.DBManager;

public class InsegnaDAO {
	private static Connection conn = null;

	public boolean salva(Insegna insegna) {
		String query = "INSERT INTO insegna (docente, corso, datainizio, datafine) VALUES (?, ?, ?, ?)";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, insegna.getDocente());
			ps.setInt(2, insegna.getCorso());
			ps.setDate(3, new Date(insegna.getDatainizio().getTime()));
			
			if (insegna.getDatafine() != null) {
				ps.setDate(4, new Date(insegna.getDatafine().getTime()));
			} else
				ps.setNull(4, Types.DATE);

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean aggiorna(Insegna insegna) {
		String query = "UPDATE insegna SET docente=?, corso=?, datainizio=?, datafine=? WHERE codiceinsegna=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, insegna.getDocente());
			ps.setInt(2, insegna.getCorso());
			ps.setDate(3, new Date(insegna.getDatainizio().getTime()));

			if (insegna.getDatafine() != null) {
				ps.setDate(4, new Date(insegna.getDatafine().getTime()));
			} else
				ps.setNull(4, Types.DATE);
			
			ps.setInt(5, insegna.getCodiceinsegna());		
			
			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBManager.closeConnection();
		return esito;
	}

	public Vector<Insegna> get(Insegna insegnamento, int operation) {
		String query = "SELECT * FROM insegna";
		if (operation == 0) {
			query += " WHERE codiceinsegna=?";
		} else if (operation == 1) {
			query += " WHERE docente=?";
		} else if (operation == 2) {
			query += " WHERE corso=?";
		}

		Vector<Insegna> res = new Vector<Insegna>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			if (operation == 0) {
				ps.setInt(1, insegnamento.getCodiceinsegna());
			} else if (operation == 1) {
				ps.setInt(1, insegnamento.getDocente());
			} else if (operation == 2) {
				ps.setInt(1, insegnamento.getCorso());
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Insegna insegnares = recordToInsegna(rs);
				res.add(insegnares);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public Vector<Insegna> getAll() {
		return get(new Insegna(), -1);
	}

	private Insegna recordToInsegna(ResultSet rs) throws SQLException {
		Insegna res = new Insegna();
		res.setCodiceinsegna(rs.getInt("codiceinsegna"));
		res.setDocente(rs.getInt(2));
		res.setCorso(rs.getInt(3));
		res.setDatainizio(rs.getDate(4));
		res.setDatafine(rs.getDate(5));
		return res;
	}

}
