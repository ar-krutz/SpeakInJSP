package it.unirc.twdb.speakin.servlet.segretario;

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
 * Servlet implementation class VisualizzaDocenti
 */
@WebServlet("/VisualizzaDocenti")
public class VisualizzaDocenti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaDocenti() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DocenteDAO docenteDAO = new DocenteDAO();
		Vector<Docente> docenti = docenteDAO.getAll();
		request.setAttribute("docenti", docenti);
		request.getRequestDispatcher(request.getContextPath()+"/WEB-INF/segretario/amministrazione/docente.jsp").forward(request, response);
	}

}
