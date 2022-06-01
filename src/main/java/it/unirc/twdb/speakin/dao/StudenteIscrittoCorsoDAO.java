package it.unirc.twdb.speakin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;

import it.unirc.twdb.speakin.model.Corso;
import it.unirc.twdb.speakin.model.Studente;
import it.unirc.twdb.speakin.utils.DBManager;


public class StudenteIscrittoCorsoDAO {
	private static Connection conn = null;

	public boolean isIscritto(Studente studente, Corso corso) {
		boolean res = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement("SELECT * FROM eiscritto JOIN classe ON classe.codiceclasse=eiscritto.classe WHERE studente=? AND corso=?");
			ps.setInt(1, studente.getMatricola());
			ps.setInt(2, corso.getCodiceCorso());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) res=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();		
		return res;
	}

	public Vector<Studente> getListIscritti(Corso corso){
		String query = "SELECT studente.* FROM eiscritto JOIN studente ON eiscritto.studente=studente.matricola JOIN classe ON classe.codiceclasse=eiscritto.classe WHERE classe.corso=?";

		Vector<Studente> res = new Vector<Studente>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, corso.getCodiceCorso());

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
	
	public HashMap<Integer, Integer> getIscritti() {
		HashMap<Integer, Integer> res=new HashMap<Integer, Integer>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement("SELECT codiceclasse, COUNT(*) FROM eiscritto JOIN classe ON classe.codiceclasse=eiscritto.classe GROUP BY classe.codiceclasse");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				res.put(rs.getInt(1), rs.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
	
	public int getMinStudentClass(Corso corso) {
		int res=-1;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement("SELECT codiceclasse FROM classe LEFT JOIN eiscritto ON classe.codiceclasse=eiscritto.classe WHERE corso = ? GROUP BY codiceclasse ORDER BY COUNT(*)");
			ps.setInt(1, corso.getCodiceCorso());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				res=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
	
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
	
}
