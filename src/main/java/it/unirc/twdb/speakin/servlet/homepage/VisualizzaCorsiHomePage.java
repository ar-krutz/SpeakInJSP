package it.unirc.twdb.speakin.servlet.homepage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unirc.twdb.speakin.dao.CorsoDAO;
import it.unirc.twdb.speakin.dao.DocenteInsegnaCorsoDAO;
import it.unirc.twdb.speakin.dao.StudenteIscrittoCorsoDAO;
import it.unirc.twdb.speakin.model.Corso;
import it.unirc.twdb.speakin.model.Docente;

/**
 * Servlet implementation class VisualizzaCorsiHomePage
 */
@WebServlet("/VisualizzaCorsiHomePage")
public class VisualizzaCorsiHomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaCorsiHomePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CorsoDAO corsoDAO = new CorsoDAO();
		DocenteInsegnaCorsoDAO dicDAO = new DocenteInsegnaCorsoDAO();
		StudenteIscrittoCorsoDAO sicDAO = new StudenteIscrittoCorsoDAO();
		
		Vector<Integer> ids = new Vector<Integer>();
		Vector<Corso> corsi = corsoDAO.getAll();
		Vector<String> lingue = new Vector<String>();
		HashMap<Integer, Vector<Docente>> docenti = dicDAO.getDocentiCorsi();
		HashMap<Integer, Integer> iscritti = sicDAO.getIscritti();

		for(Corso c : corsi) {
			ids.add(c.getCodiceCorso());
			if(!lingue.contains(c.getLingua())) lingue.add(c.getLingua());
			if(iscritti.get(c.getCodiceCorso())==null) iscritti.put(c.getCodiceCorso(), 0);
		}
		
		request.setAttribute("corsi", corsi);
		request.setAttribute("docenti", docenti);
		request.setAttribute("id", ids);
		request.setAttribute("lingue", lingue);
		request.setAttribute("iscritti", iscritti);
		
		request.getRequestDispatcher(request.getContextPath()+"corsi.jsp").forward(request, response);
	}

}
