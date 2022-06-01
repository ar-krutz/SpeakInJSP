package it.unirc.twdb.speakin.servlet.account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twdb.speakin.dao.AccountDAO;
import it.unirc.twdb.speakin.dao.DocenteDAO;
import it.unirc.twdb.speakin.dao.SegretarioDAO;
import it.unirc.twdb.speakin.dao.StudenteDAO;
import it.unirc.twdb.speakin.model.Account;
import it.unirc.twdb.speakin.model.Docente;
import it.unirc.twdb.speakin.model.Segretario;
import it.unirc.twdb.speakin.model.Studente;

/**
 * Servlet implementation class EliminaAccount
 */
@WebServlet("/Account/EliminaAccount")
public class EliminaAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EliminaAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		AccountDAO accountDAO = new AccountDAO();

		if (account.getType() == 1) {
			Studente studente = (Studente) session.getAttribute("studente");
			StudenteDAO studenteDAO = new StudenteDAO();
		} else if (account.getType() == 1) {
			Docente docente = (Docente) session.getAttribute("docente");
			DocenteDAO docenteDAO = new DocenteDAO();
		} else {
			Segretario segretario = (Segretario) session.getAttribute("segretario");
			SegretarioDAO segretarioDAO = new SegretarioDAO();
		}

		session.invalidate();
	}

}
