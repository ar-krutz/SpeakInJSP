package it.unirc.twdb.speakin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;

import it.unirc.twdb.speakin.model.Calendario;
import it.unirc.twdb.speakin.utils.DBManager;

public class CalendarioDAO {
	private static Connection conn = null;

	private Calendario recordToCalendario(ResultSet rs) throws SQLException {
		Calendario res = new Calendario();
		res.setCodiceLezione(rs.getInt("CodiceLezione"));
		res.setData(new Timestamp(rs.getTimestamp(2).getTime()));
		res.setNumeroOre(rs.getInt(3));
		res.setAula(rs.getString(4));
		res.setSigla(rs.getString(5));
		res.setLingua(rs.getString(6));
		res.setLivello(rs.getString(7));
		res.setNome(rs.getString(8));
		res.setCognome(rs.getString(9));
		return res;
	}
	
	public Vector<Calendario> get() {
		Vector<Calendario> res = new Vector<Calendario>();
		String query = "SELECT lezione.codicelezione, lezione.data, lezione.numeroore, lezione.aula, classe.sigla, corso.lingua, corso.livello, docente.nome, docente.cognome FROM lezione\r\n" + 
				"JOIN classe ON lezione.classe=classe.codiceclasse\r\n" + 
				"JOIN docente ON lezione.docente=docente.codicedocente\r\n" + 
				"JOIN corso ON classe.corso=corso.codicecorso WHERE lezione.data>=CURDATE()";
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Calendario calendario = recordToCalendario(rs);
				res.add(calendario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
}
