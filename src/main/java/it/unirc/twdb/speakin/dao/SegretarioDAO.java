package it.unirc.twdb.speakin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.unirc.twdb.speakin.model.Segretario;
import it.unirc.twdb.speakin.utils.DBManager;

public class SegretarioDAO {
	private static Connection conn = null;

	private Segretario recordToSegretario(ResultSet rs) throws SQLException {
		Segretario res = new Segretario();
		res.setCodiceSegretario(rs.getInt("CodiceSegretario"));
		res.setNome(rs.getString(2));
		res.setCognome(rs.getString(3));
		res.setDataNascita(rs.getDate(4));
		res.setCodiceFiscale(rs.getString(5));
		res.setIndirizzo(rs.getString(6));
		res.setIndirizzoEMail(rs.getString(7));
		res.setNumeroTelefono(rs.getString(8));
		res.setStipendio(rs.getDouble(9));
		return res;
	}

	public Vector<Segretario> get(Segretario segretario, int operation) {
		String query = "SELECT * FROM segretario";
		if (operation == 0) {
			query += " WHERE codicesegretario=?";
		} else if (operation == 1) {
			query += " WHERE cognome=?";
		} else if (operation == 2) {
			query += " WHERE indirizzoemail=?";
		} else if (operation == 3) {
			query += " WHERE codicefiscale=?";
		}

		Vector<Segretario> res = new Vector<Segretario>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			if (operation == 0) {
				ps.setInt(1, segretario.getCodiceSegretario());
			} else if (operation == 1) {
				ps.setString(1, segretario.getCognome());
			} else if (operation == 2) {
				ps.setString(1, segretario.getIndirizzoEMail());
			} else if (operation == 3) {
				ps.setString(1, segretario.getCodiceFiscale());
			}

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Segretario segretariores = recordToSegretario(rs);
				res.add(segretariores);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public Vector<Segretario> getAll() {
		return get(new Segretario(), -1);
	}

	public boolean salva(Segretario segretario) {
		String query = "INSERT INTO segretario (nome, cognome, datanascita, codicefiscale, indirizzo, indirizzoemail, numerotelefono, stipendio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, segretario.getNome());
			ps.setString(2, segretario.getCognome());
			ps.setDate(3, new Date(segretario.getDataNascita().getTime()));
			ps.setString(4, segretario.getCodiceFiscale());
			ps.setString(5, segretario.getIndirizzo());
			ps.setString(6, segretario.getIndirizzoEMail());
			ps.setString(7, segretario.getNumeroTelefono());
			ps.setDouble(8, segretario.getStipendio());

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBManager.closeConnection();
		return esito;
	}

	public boolean aggiorna(Segretario segretario) {

		String query = "UPDATE segretario SET nome=?, cognome=?, datanascita=?, codicefiscale=?, indirizzo=?, indirizzoemail=?, numerotelefono=?, stipendio=? WHERE codicesegretario=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, segretario.getNome());
			ps.setString(2, segretario.getCognome());
			ps.setDate(3, new Date(segretario.getDataNascita().getTime()));
			ps.setString(4, segretario.getCodiceFiscale());
			ps.setString(5, segretario.getIndirizzo());
			ps.setString(6, segretario.getIndirizzoEMail());
			ps.setString(7, segretario.getNumeroTelefono());
			ps.setDouble(8, segretario.getStipendio());
			ps.setInt(9, segretario.getCodiceSegretario());

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
