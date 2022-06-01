package it.unirc.twdb.speakin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.unirc.twdb.speakin.model.Account;
import it.unirc.twdb.speakin.utils.DBManager;

public class AccountDAO {
	private static Connection conn = null;

	public Account getAccount(Account account) {
		PreparedStatement ps;
		Account res = new Account();
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement("SELECT * FROM account WHERE email = ?");
			ps.setString(1, account.getEmail());
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				res = recordToAccount(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public int login(Account account) {
		PreparedStatement ps;
		int res = -1;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement("SELECT * FROM account WHERE email = ? AND password = ?");
			ps.setString(1, account.getEmail());
			ps.setString(2, account.getPassword());
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				res = rs.getInt("type");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}	
	
	public Vector<Account> get(Account account) {
		Vector<Account> res = new Vector<Account>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement("SELECT * FROM account");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Account ares = recordToAccount(rs);
				res.add(ares);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public boolean salva(Account account) {
		String query = "INSERT INTO account (email, password, type) VALUES (?, ?, ?)";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, account.getEmail());
			ps.setString(2, account.getPassword());
			ps.setInt(3, account.getType());

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
	
	public boolean cancella(Account account) {
		String query = "DELETE FROM account WHERE email=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, account.getEmail());
			
			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	private Account recordToAccount(ResultSet rs) throws SQLException {
		Account res = new Account();
		res.setEmail(rs.getString("email"));
		res.setPassword(rs.getString(2));
		res.setType(rs.getInt(3));
		return res;
	}
}
