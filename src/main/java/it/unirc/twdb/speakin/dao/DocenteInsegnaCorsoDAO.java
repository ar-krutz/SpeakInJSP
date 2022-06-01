package it.unirc.twdb.speakin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;

import it.unirc.twdb.speakin.model.Corso;
import it.unirc.twdb.speakin.model.Docente;
import it.unirc.twdb.speakin.utils.DBManager;

public class DocenteInsegnaCorsoDAO {
	private static Connection conn = null;

	public Vector<Docente> getDocenteCorso(Corso corso){
		String query = "SELECT docente.* FROM insegna JOIN docente ON docente.codicedocente=insegna.docente WHERE insegna.corso=?";
		Vector<Docente> res = new Vector<Docente>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, corso.getCodiceCorso());
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
	
	public HashMap<Integer, Vector<Docente>> getDocentiCorsi() {
		String query = "SELECT docente.*, corso.codicecorso FROM corso JOIN insegna ON corso.codicecorso=insegna.corso JOIN docente ON docente.codicedocente=insegna.docente";
		HashMap<Integer, Vector<Docente>> res = new HashMap<Integer, Vector<Docente>>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Docente docenteres = recordToDocente(rs);
				if(res.get(rs.getInt(11))==null) {
					Vector<Docente> temp = new Vector<Docente>();
					temp.add(docenteres);
					res.put(rs.getInt(11), temp);
				} else {
					Vector<Docente> temp = res.get(rs.getInt(11));
					temp.add(docenteres);
					res.put(rs.getInt(11), temp);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

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
	
}
