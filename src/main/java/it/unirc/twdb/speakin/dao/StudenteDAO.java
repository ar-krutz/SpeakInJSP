package it.unirc.twdb.speakin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.unirc.twdb.speakin.model.Studente;
import it.unirc.twdb.speakin.utils.DBManager;

public class StudenteDAO {
	private static Connection conn = null;

	private Studente recordToStudente(ResultSet rs) throws SQLException {
		Studente res = new Studente();
		res.setMatricola(rs.getInt("matricola"));
		res.setNome(rs.getString(2));
		res.setCognome(rs.getString(3));
		res.setDataNascita(rs.getDate(4));
		res.setCodiceFiscale(rs.getString(5));
		res.setIndirizzo(rs.getString(6));
		res.setIndirizzoEMail(rs.getString(7));
		res.setNumeroTelefono(rs.getString(8));
		return res;
	}

	public Vector<Studente> get(Studente studenti, int operation) {
		String query = "SELECT * FROM studente";
		if (operation == 0) {
			query += " WHERE matricola=?";
		} else if (operation == 1) {
			query += " WHERE cognome=?";
		} else if (operation == 2) {
			query += " WHERE indirizzoemail=?";	
		} else if (operation == 3) {
			query += " WHERE codicefiscale=?";
		}

		Vector<Studente> res = new Vector<Studente>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			if (operation == 0) {
				ps.setInt(1, studenti.getMatricola());
			} else if (operation == 1) {
				ps.setString(1, studenti.getCognome());
			} else if (operation == 2) {
				ps.setString(1, studenti.getIndirizzoEMail());				
			} else if (operation == 3) {
				ps.setString(1, studenti.getCodiceFiscale());
			}

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Studente studenteres = recordToStudente(rs);
				res.add(studenteres);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public Vector<Studente> getAll() {
		return get(new Studente(), -1);
	}

	public boolean salva(Studente studente) {
		String query = "INSERT INTO studente (nome, cognome, datanascita, codicefiscale, indirizzo, indirizzoemail, numerotelefono) VALUES (?, ?, ?, ?, ?, ?, ?)";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, studente.getNome());
			ps.setString(2, studente.getCognome());
			ps.setDate(3, new Date(studente.getDataNascita().getTime()));
			ps.setString(4, studente.getCodiceFiscale());
			ps.setString(5, studente.getIndirizzo());
			ps.setString(6, studente.getIndirizzoEMail());
			ps.setString(7, studente.getNumeroTelefono());

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBManager.closeConnection();
		return esito;
	}

	public boolean aggiorna(Studente studente) {

		String query = "UPDATE studente SET nome=?, cognome=?, datanascita=?, codicefiscale=?, indirizzo=?, indirizzoemail=?, numerotelefono=? WHERE matricola=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, studente.getNome());
			ps.setString(2, studente.getCognome());
			ps.setDate(3, new Date(studente.getDataNascita().getTime()));
			ps.setString(4, studente.getCodiceFiscale());
			ps.setString(5, studente.getIndirizzo());
			ps.setString(6, studente.getIndirizzoEMail());
			ps.setString(7, studente.getNumeroTelefono());
			ps.setInt(8, studente.getMatricola());

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBManager.closeConnection();
		return esito;
	}
	
	public boolean cancella(Studente studente) {
		String query = "DELETE FROM studente WHERE matricola=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, studente.getMatricola());
			
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
