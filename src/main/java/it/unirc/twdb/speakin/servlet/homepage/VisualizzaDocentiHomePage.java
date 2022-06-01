package it.unirc.twdb.speakin.servlet.homepage;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unirc.twdb.speakin.dao.DocenteDAO;
import it.unirc.twdb.speakin.model.Docente;

/**
 * Servlet implementation class VisualizzaDocentiHomePage
 */
@WebServlet("/VisualizzaDocentiHomePage")
public class VisualizzaDocentiHomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaDocentiHomePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DocenteDAO docenteDAO = new DocenteDAO();
		Vector<Integer> ids = new Vector<Integer>();
		Vector<Docente> docenti = docenteDAO.getAll();
		request.setAttribute("docenti", docenti);
		for(Docente d : docenti) {
			ids.add(d.getCodiceDocente());
		}
		
		request.setAttribute("id", ids);
		request.getRequestDispatcher(request.getContextPath()+"/docenti.jsp").forward(request, response);
	}

}
