package pktutkimus.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pktutkimus.model.Henkilo;
import pktutkimus.model.dao.HenkiloDAO;

@WebServlet("/listaa-henkilot")
public class ListaaHenkilotServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * L�hett�� tietoa selaimelle:
	 * 
	 * Tietokannasta haetaan henkilolista
	 * ja v�litet��n lista jsp:lle
	 * 
	 * @param request
	 * 		pyynt�
	 * @param response 
	 * 		vastaus
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Luodaan henkiloDAO ja k�sket��n hakemaan kaikki henkilot tietokannasta
		HenkiloDAO henkilodao = new HenkiloDAO();
		ArrayList<Henkilo> henkilot = henkilodao.findAll();

		// Talletetaan request-olion alle henkil�lista, jotta tiedot ovat k�yt�ss� jsp:ll�
		request.setAttribute("henkilot", henkilot);
		
		// l�het� selaimelta tullut pyynt� servletilt� edelleen jsp:lle
		String jsp = "/view/listaa-henkilot.jsp"; 
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);
	
	}

}
