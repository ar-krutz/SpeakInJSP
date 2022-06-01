package it.unirc.twdb.speakin.servlet.studente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unirc.twdb.speakin.dao.StudenteDAO;
import it.unirc.twdb.speakin.model.Studente;

/**
 * Servlet implementation class MostraStudente
 */
@WebServlet("/MostraStudente")
public class MostraStudente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostraStudente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mode = Integer.parseInt(request.getParameter("mode"));
		StudenteDAO studenteDAO = new StudenteDAO();
		Studente stud = new Studente(); 
		String parameter = request.getParameter("parameter");
		
		if(mode==0) stud.setMatricola(Integer.parseInt(parameter));
		else if(mode==1) stud.setCognome(parameter);
		else if(mode==2) stud.setIndirizzoEMail(parameter);
		else stud.setCodiceFiscale(parameter);
		
		Studente studente = studenteDAO.get(stud, mode).get(0);
		request.setAttribute("sres", studente);
		request.getRequestDispatcher(request.getContextPath()+"/WEB-INF/Admin/studente.jsp").forward(request, response);
	}

}
