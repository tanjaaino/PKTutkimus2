


package pktutkimus.model;
/**
 * Henkilo -luokka
 * Painokerrointutkimuksen tutkittava Henkilö 
 * 
 */
public class Henkilo{
	// attribuutit
	private int id; // henkilon tutkimustunnus
	private int paino;   // kg
	private double pituus;   // m
	private int ika; // vuotta
	private String kotimaa;  // Suomi, Italia, USA
	private String sukupuoli; // N=nainen, M=mies

	// konstruktorit
	public Henkilo(){
		this.id = 0;
		this.paino = 0;
		this.pituus = 0;
		this.ika = 0;
		this.kotimaa = null;
		this.sukupuoli = null; 
	}
	
	public Henkilo(int id, int paino, double pituus, int ika, String kotimaa, String sukupuoli){
		this.id = id;
		this.paino = paino;
		this.pituus = pituus;
		this.ika = ika;
		this.kotimaa = kotimaa;
		this.sukupuoli = sukupuoli; 
	}
	
	// setit
	
	public void setId(int id) {
		this.id = id;
	}
	public void setPaino(int paino) {
		this.paino = paino;
	}
	public void setPituus(double pituus) {
		this.pituus = pituus;
	}
	public void setIka(int ika) {
		this.ika = ika;
	}
	public void setKotimaa(String kotimaa) {
		this.kotimaa = kotimaa;
	}
	public void setSukupuoli(String sukupuoli) {
		this.sukupuoli = sukupuoli;
	}
	
	
	// getit
	public int getId() {
		return this.id;
	}
	public int getPaino() {
		return this.paino;
	}
	public double getPituus() {
		return this.pituus;
	}
	public int getIka() {
		return this.ika;
	}
	public String getKotimaa() {
		return this.kotimaa;
	}
	public String getSukupuoli() {
		return this.sukupuoli;
	}
	
	public double getPainokerroin(){
		double painokerroin;
		painokerroin = this.paino/ (this.pituus*this.pituus);
		return painokerroin;
	}
	
	// toString tekstikäyttöön
	public String toString(){
		return "id: "+this.id + " , paino: "+this.paino  + " , pituus: "+this.pituus + " , ika: "+this.ika + 
				" , kotimaa: "+this.kotimaa +
				" , sukupuoli: "+this.sukupuoli;
	}
	

}
