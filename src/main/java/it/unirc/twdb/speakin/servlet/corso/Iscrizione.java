package it.unirc.twdb.speakin.servlet.corso;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twdb.speakin.dao.EiscrittoDAO;
import it.unirc.twdb.speakin.dao.StudenteIscrittoCorsoDAO;
import it.unirc.twdb.speakin.model.Corso;
import it.unirc.twdb.speakin.model.Eiscritto;
import it.unirc.twdb.speakin.model.Studente;

/**
 * Servlet implementation class Iscrizione
 */
@WebServlet("/Iscrizione")
public class Iscrizione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Iscrizione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("account")==null) {
			request.getRequestDispatcher(request.getContextPath()+"/login.jsp").forward(request, response);
			return;
		}
		int id = Integer.parseInt(request.getParameter("id"));
		StudenteIscrittoCorsoDAO sicDAO = new StudenteIscrittoCorsoDAO();
		int classe = sicDAO.getMinStudentClass(new Corso(id));
		EiscrittoDAO eiscrittoDAO = new EiscrittoDAO();
		int matricola = ((Studente) session.getAttribute("attributi")).getMatricola();
		Eiscritto obj = new Eiscritto(matricola, classe);
		System.out.println(obj.toString());
		eiscrittoDAO.salva(obj);
	}


}
