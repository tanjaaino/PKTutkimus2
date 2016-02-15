package pktutkimus.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pktutkimus.model.Henkilo;
import pktutkimus.model.dao.HenkiloDAO;

@WebServlet("/lisaa-henkilo")
public class LisaaHenkiloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * Lähettää  selaimelle henkilötietojen lisäyslomake
	 * 
	 * @param request
	 *            pyyntö
	 * @param response
	 *            vastaus
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String jsp = "/view/lisaa-henkilo.jsp"; 
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);
	}

	/**
	 * Vastaanottaa henkilolomakkeella syötetyt tiedot selaimelta:
	 * 
	 * Haetaan lomakkeella syötetyn henkilön tiedot  request (pyyntö)-olion parametritiedoista
	 * ja lisätään henkilön tiedot tietokantaan.
	 * tietokantaan
	 * 
	 * @param request
	 *            pyyntö
	 * @param response
	 *            vastaus
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		try{

			// Haetaan lomakkeella syötetyn henkilon tiedot request-oliolta
			String idStr = request.getParameter("id"); // Id
			int id = new Integer(idStr);
			String painoStr = request.getParameter("paino"); // paino 
			int paino = new Integer(painoStr);
			String pituusStr = request.getParameter("pituus"); // pituus
			pituusStr = pituusStr.replace(",", ".");
			double pituus = new Double(pituusStr);
			
			String ikaStr = request.getParameter("ika"); // ikä
			int ika = new Integer(ikaStr);
			
			String kotimaa = request.getParameter("kotimaa"); // kotimaa
			String sukupuoli = request.getParameter("sukupuoli"); // kotimaa
			
		
			// Luodaan uusi henkilo edellisillä parametreillä
			Henkilo henkilo = new Henkilo(id, paino, pituus, ika , kotimaa, sukupuoli);
	
			// Luodaan henkilodao
			HenkiloDAO henkilodao = new HenkiloDAO();
			// Lisätään henkilön tiedot tietokantaan
			henkilodao.add(henkilo);
		} catch (SQLException e) {
			// TODO: muuta virheilmoitus
			System.out.println("Sovelluksessa tapahtui virhe "+ e.getMessage());
		}

		// uudelleenohjataan selain listaa-henkilot-servlettiin!
		response.sendRedirect("listaa-henkilot");
	}

}
