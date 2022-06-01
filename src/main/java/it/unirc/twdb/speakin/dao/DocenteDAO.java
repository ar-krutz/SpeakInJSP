package it.unirc.twdb.speakin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.unirc.twdb.speakin.model.Docente;
import it.unirc.twdb.speakin.utils.DBManager;

public class DocenteDAO {
	private static Connection conn = null;

	private Docente recordToDocente(ResultSet rs) throws SQLException {
		Docente res = new Docente();
		res.setCodiceDocente(rs.getInt("codicedocente"));
		res.setNome(rs.getString(2));
		res.setCognome(rs.getString(3));
		res.setDataNascita(rs.getDate(4));
		res.setCodiceFiscale(rs.getString(5));
		res.setIndirizzo(rs.getString(6));
		res.setIndirizzoEMail(rs.getString(7));
		res.setNumeroTelefono(rs.getString(8));
		res.setStipendio(rs.getDouble(9));
		res.setLingua(rs.getString(10));
		return res;
	}
	
	public Vector<Docente> get(Docente docenti, int operation) {
		String query = "SELECT * FROM docente";
		if (operation == 0) {
			query += " WHERE codicedocente=?";
		} else if (operation == 1) {
			query += " WHERE cognome=?";
		} else if (operation == 2) {
			query += " WHERE codicefiscale=?";
		} else if (operation == 3) {
			query += " WHERE lingua=?";
		} else if (operation == 4) {
			query += " WHERE indirizzoemail=?";
		}
		
		Vector<Docente> res = new Vector<Docente>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			if (operation == 0) {
				ps.setInt(1, docenti.getCodiceDocente());
			} else if (operation == 1) {
				ps.setString(1, docenti.getCognome());
			} else if (operation == 2) {
				ps.setString(1, docenti.getCodiceFiscale());
			} else if (operation == 3) {
				ps.setString(1, docenti.getLingua());
			} else if (operation == 4) {
				ps.setString(1, docenti.getIndirizzoEMail());
			}

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Docente docenteres = recordToDocente(rs);
				res.add(docenteres);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
	
	public Vector<Docente> getAll() {
		return get(new Docente(), -1);
	}

	public boolean salva(Docente docente) {
		String query = "INSERT INTO docente (nome, cognome, datanascita, codicefiscale, indirizzo, indirizzoemail, numerotelefono, stipendio, lingua) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, docente.getNome());
			ps.setString(2, docente.getCognome());
			ps.setDate(3, new Date(docente.getDataNascita().getTime()));
			ps.setString(4, docente.getCodiceFiscale());
			ps.setString(5, docente.getIndirizzo());
			ps.setString(6, docente.getIndirizzoEMail());
			ps.setString(7, docente.getNumeroTelefono());
			ps.setDouble(8, docente.getStipendio());
			ps.setString(9, docente.getLingua());

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBManager.closeConnection();
		return esito;
	}

	public boolean aggiorna(Docente docente) {

		String query = "UPDATE docente SET nome=?, cognome=?, datanascita=?, codicefiscale=?, indirizzo=?, indirizzoemail=?, numerotelefono=?, stipendio=?, lingua=? WHERE codicedocente=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, docente.getNome());
			ps.setString(2, docente.getCognome());
			ps.setDate(3, new Date(docente.getDataNascita().getTime()));			
			ps.setString(4, docente.getCodiceFiscale());
			ps.setString(5, docente.getIndirizzo());
			ps.setString(6, docente.getIndirizzoEMail());
			ps.setString(7, docente.getNumeroTelefono());
			ps.setDouble(8, docente.getStipendio());
			ps.setString(9, docente.getLingua());
			ps.setInt(10, docente.getCodiceDocente());


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
