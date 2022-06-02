package it.unirc.twdb.speakin.servlet.studente;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unirc.twdb.speakin.dao.StudenteDAO;
import it.unirc.twdb.speakin.model.Studente;

/**
 * Servlet implementation class MostraStudenti
 */
@WebServlet("/Admin/MostraTutti")
public class MostraTutti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostraTutti() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudenteDAO sDao = new StudenteDAO();
		Integer[] ids = {};
		
		Vector<Studente> studenti = sDao.getAll();
		request.setAttribute("studenti", studenti);
		for(Studente s : studenti) {
			ids[ids.length] = s.getMatricola();
		}
		
		request.setAttribute("id", ids);
		request.getRequestDispatcher("/WEB-INF/Admin/mostraTutti.jsp").forward(request, response);
		//response.getWriter().append("Studenti: " + studenti);
	}
}
