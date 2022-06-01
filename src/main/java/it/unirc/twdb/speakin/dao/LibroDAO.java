package it.unirc.twdb.speakin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.unirc.twdb.speakin.model.Libro;
import it.unirc.twdb.speakin.utils.DBManager;

public class LibroDAO {
	private static Connection conn = null;

	private Libro recordToLibro(ResultSet rs) throws SQLException {
		Libro res = new Libro();
		res.setCodicelibro(rs.getInt("codicelibro"));
		res.setCodiceISBN(rs.getString(2));
		res.setTitolo(rs.getString(3));
		res.setAutore(rs.getString(4));
		res.setCasaEditrice(rs.getString(5));
		res.setPrezzo(rs.getDouble(6));
		return res;
	}

	public Vector<Libro> get(Libro libri, int operation) {
		String query = "SELECT * FROM libro";
		if (operation == 0) {
			query += " WHERE codiceisbn=?";
		} else if (operation == 1) {
			query += " WHERE titolo=?";
		} else if (operation == 2) {
			query += " WHERE autore=?";
		} else if (operation == 3) {
			query += " WHERE casaeditrice=?";
		}
		
		Vector<Libro> res = new Vector<Libro>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			if (operation == 0) {
				ps.setString(1, libri.getCodiceISBN());
			} else if (operation == 1) {
				ps.setString(1, libri.getTitolo());
			} else if (operation == 2) {
				ps.setString(1, libri.getAutore());
			} else if (operation == 3) {
				ps.setString(1, libri.getCasaEditrice());
			}

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Libro librores = recordToLibro(rs);
				res.add(librores);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public Vector<Libro> getAll() {
		return get(new Libro(), -1);
	}

	public boolean salva(Libro libro) {
		String query = "INSERT INTO libro (codiceisbn, titolo, autore, casaeditrice, prezzo) VALUES (?, ?, ?, ?, ?)";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, libro.getCodiceISBN());
			ps.setString(2, libro.getTitolo());
			ps.setString(3, libro.getAutore());
			ps.setString(4, libro.getCasaEditrice());
			ps.setDouble(5, libro.getPrezzo());
			
			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBManager.closeConnection();
		return esito;
	}

	public boolean aggiorna(Libro libro) {
		String query = "UPDATE libro SET codiceisbn=?, titolo=?, autore=?, casaeditrice=?, prezzo=? WHERE codicelibro=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, libro.getCodiceISBN());
			ps.setString(2, libro.getTitolo());
			ps.setString(3, libro.getAutore());
			ps.setString(4, libro.getCasaEditrice());
			ps.setDouble(5, libro.getPrezzo());
			ps.setInt(6, libro.getCodicelibro());

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
