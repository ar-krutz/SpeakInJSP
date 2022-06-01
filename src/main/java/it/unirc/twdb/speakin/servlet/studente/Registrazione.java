package it.unirc.twdb.speakin.servlet.studente;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twdb.speakin.dao.AccountDAO;
import it.unirc.twdb.speakin.dao.StudenteDAO;
import it.unirc.twdb.speakin.model.Account;
import it.unirc.twdb.speakin.model.Studente;

/**
 * Servlet implementation class Registrazione
 */
@WebServlet("/Registrazione")
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registrazione() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		String nome = (String) request.getParameter("nome");
		String cognome = (String) request.getParameter("cognome");
		System.out.println((String) request.getParameter("datanascita"));
		Date datanascita = null;
		try {
			datanascita = new SimpleDateFormat("yyyy-MM-dd").parse((String) request.getParameter("datanascita"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String codicefiscale = (String) request.getParameter("codicefiscale");
		String indirizzo = (String) request.getParameter("indirizzo");
		String mail = (String) request.getParameter("email");
		String tel = (String) request.getParameter("tel");

		Account account = new Account(email, password, 0);
		Studente studente = new Studente(nome, cognome, datanascita, codicefiscale, indirizzo, mail, tel);
		AccountDAO accountDAO = new AccountDAO();
		StudenteDAO studenteDAO = new StudenteDAO();
		accountDAO.salva(account);
		studenteDAO.salva(studente);

		session.setAttribute("account", account);
		session.setAttribute("attributi", studente);
		request.getRequestDispatcher(request.getContextPath() + "/WEB-INF/Account/AreaRiservata.jsp").forward(request,
				response);
	}

}
