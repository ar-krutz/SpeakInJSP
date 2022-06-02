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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		AccountDAO accountDAO = new AccountDAO();
		int type = accountDAO.login(new Account(email, password, 1));
		if(type==-1) { //errore
			System.out.println("Non funziona un cazzo");
			return;
		} else if(type==0){ // studente
			StudenteDAO studenteDAO = new StudenteDAO();
			Studente temp = new Studente();
			temp.setIndirizzoEMail(email);
			Studente attributi = studenteDAO.get(temp, 2).get(0);
			session.setAttribute("attributi", attributi);
		} else if(type==1) { // segretario
			SegretarioDAO segretarioDAO = new SegretarioDAO();
			Segretario temp = new Segretario();
			temp.setIndirizzoEMail(email);
			Segretario attributi = segretarioDAO.get(temp, 2).get(0);
			session.setAttribute("attributi", attributi);
		} else { //docente
			DocenteDAO docenteDAO = new DocenteDAO();
			Docente temp = new Docente();
			temp.setIndirizzoEMail(email);
			Docente attributi = docenteDAO.get(temp, 4).get(0);
			session.setAttribute("attributi", attributi);
		}
		session.setAttribute("account", new Account(email, password, type));
		request.getRequestDispatcher("/WEB-INF/Account/AreaRiservata.jsp").forward(request,
				response);
	}

}
