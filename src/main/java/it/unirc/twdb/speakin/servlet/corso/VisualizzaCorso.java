package it.unirc.twdb.speakin.servlet.corso;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twdb.speakin.dao.CorsoDAO;
import it.unirc.twdb.speakin.dao.DocenteInsegnaCorsoDAO;
import it.unirc.twdb.speakin.dao.StudenteIscrittoCorsoDAO;
import it.unirc.twdb.speakin.model.Account;
import it.unirc.twdb.speakin.model.Corso;
import it.unirc.twdb.speakin.model.Docente;
import it.unirc.twdb.speakin.model.Studente;

/**
 * Servlet implementation class VisualizzaCorso
 */
@WebServlet("/VisualizzaCorso")
public class VisualizzaCorso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaCorso() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		Corso temp = new Corso(id);
		
		CorsoDAO corsoDAO = new CorsoDAO();		
		Corso corso = corsoDAO.get(temp, 0).get(0);
		
		DocenteInsegnaCorsoDAO dicDAO = new DocenteInsegnaCorsoDAO();
		Vector<Docente> docenti = dicDAO.getDocenteCorso(corso);
		
		StudenteIscrittoCorsoDAO sicDAO = new StudenteIscrittoCorsoDAO();
		Vector<Studente> iscritti = sicDAO.getListIscritti(temp);
		
		request.setAttribute("iscritto", false);
		
		if(session.getAttribute("account")!=null && ((Account) session.getAttribute("account")).getType()==0) {
			boolean iscritto = sicDAO.isIscritto((Studente) session.getAttribute("attributi"), temp);
			request.setAttribute("iscritto", iscritto);
		}
		
		request.setAttribute("corso", corso);
		request.setAttribute("iscritti", iscritti);
		request.setAttribute("docenti", docenti);
		request.getRequestDispatcher("corso.jsp").forward(request, response);
	}

}
