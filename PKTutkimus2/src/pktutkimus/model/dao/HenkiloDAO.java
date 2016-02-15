package pktutkimus.model.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import pktutkimus.model.Henkilo;
import pktutkimus.model.dao.DataAccessObject;


/**
 * Henkilo-tietokohteen tietokantakäsittelypalvelut kuten
  add() - lisää Henkilö tietokantaan
* findAll() - hae kaikki Henkilöt tietokannasta
* find() - hae yhden henkilön tiedot annetulla henkiloid:llä
* update() - päivitä Henkilön tiedot tietokantaan
* remove() - poista Henkilön tiedot tietokannasta
 *
 */

public class HenkiloDAO extends DataAccessObject {

	/**
	 * lisää Henkilön tiedot tietokantaan
	 * 
	 * @param henkilo
	 *            Henkilo-luokan olio
	 * @throws SQLException 
	 */
	public void add(Henkilo henkilo) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtInsert = null;
	

		try {
			// Luodaan yhteys ja aloitetaan transaktio:
			connection = getConnection();
			//Luodaan uusi henkilo tietokantaan:
			String sqlInsert = "INSERT INTO person(id, weight, height, age, homecountry, sex) VALUES (?, ?, ?, ?, ?, ?)";
			stmtInsert = connection.prepareStatement(sqlInsert);
			stmtInsert.setInt(1, henkilo.getId());
			stmtInsert.setInt(2, henkilo.getPaino());
			stmtInsert.setDouble(3, henkilo.getPituus());
			stmtInsert.setInt(4, henkilo.getIka());
			stmtInsert.setString(5, henkilo.getKotimaa());
			stmtInsert.setString(6, henkilo.getSukupuoli());
			stmtInsert.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtInsert, connection); // Suljetaan statement ja yhteys
		}
	}


	
	/**
	 * Hakee tietokannan taulusta kaikki henkilöt ja luo 
	 * ja palauttaa tiedot Henkilö-tyyppisten olioiden listana (ArrayList) 
	 * 
	 * @return ArrayList<Henkilo> Lista henkilöitä
	 */
	public ArrayList<Henkilo> findAll() {	
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Henkilo> henkilot = new ArrayList<Henkilo>();
		Henkilo henkilo = null; 
		try {
			// Luodaan yhteys
			conn = getConnection();
			// Luodaan komento: haetaan kaikki rivit henkilo-taulusta
			String sqlSelect = "SELECT id, weight, height, age, homecountry, sex FROM person;";
			// Valmistellaan komento:
			stmt = conn.prepareStatement(sqlSelect);
			// Lähetetään komento:
			rs = stmt.executeQuery(sqlSelect);
			// Käydään tulostaulun rivit läpi ja luetaan readHenkilo()-metodilla:
			while (rs.next()) {
				henkilo = readHenkilo(rs);
				// lisätään henkilö listaan
				henkilot.add(henkilo);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs, stmt, conn); // Suljetaan
		}
	
		return henkilot;
	}
	
	
	
	/**
	 * Lukee tietokannasta taulusta yhden tietorivin (henkilon tiedot). Luo ja palauttaa tietojen perusteella Henkilo-tyyppisen olion
	 * 
	 * @param rs
	 *            tietokannasta kyselyllä haettu tulostaulu
	 * @return Henkilo henkilo-olio
	 */
	private Henkilo readHenkilo(ResultSet rs) {	
		try {
			// Haetaan yhden henkilön tiedot kyselyn tulostaulun (ResultSet-tyyppinen rs-olion) aktiiviselta tietoriviltä
			int id = rs.getInt("id");
			int paino = rs.getInt("weight");
			double pituus = rs.getDouble("height");
			int ika = rs.getInt("age");
			String kotimaa = rs.getString("homecountry");
			String sukupuoli = rs.getString("sex");
		
			//  Luodaan ja palautetaan uusi henkilo
			return new Henkilo(id, paino, pituus, ika, kotimaa, sukupuoli);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}

