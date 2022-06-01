package it.unirc.twdb.speakin.servlet.studente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unirc.twdb.speakin.dao.AccountDAO;
import it.unirc.twdb.speakin.dao.StudenteDAO;
import it.unirc.twdb.speakin.model.Account;
import it.unirc.twdb.speakin.model.Studente;

/**
 * Servlet implementation class EliminaStudente
 */
@WebServlet("/Admin/EliminaStudente")
public class EliminaStudente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaStudente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int matricola = Integer.parseInt(request.getParameter("matricola"));
		
		StudenteDAO studenteDAO = new StudenteDAO();
		AccountDAO accountDAO = new AccountDAO();
		
		Studente studente = studenteDAO.get(new Studente(matricola), 0).get(0);
		accountDAO.cancella(new Account(studente.getIndirizzoEMail(), null, (Integer) null));
		studenteDAO.cancella(new Studente(matricola));
	}

}
