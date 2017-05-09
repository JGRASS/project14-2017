package hotel;
/**
 * Klasa koja predstavlja sobu
 * @author jelica
 *
 */
public class Soba {
	
	/**
	 * Jedinstveni broj sobe
	 */
	private int idSobe;
	
	/**
	 * Broj kreveta u sobi
	 */
	private int brojKreveta;
	
	/**
	 * Cena sobe po nocenju
	 */
	private int cena;
	
	/**
	 * Sprat na kome je soba
	 */
	private int sprat;
	
	/**
	 * Da li soba ima terasu, true ako ima, false ako nema
	 */
	private boolean terasa;
	
	/**
	 * prazan konstruktor sobe
	 */
	public Soba() {
	}
	
	/**
	 * konstruktor sobe sa svim atributima
	 */
	public Soba(int idSobe, int brojKreveta, int cena, int sprat, boolean terasa) {
		super();
		this.idSobe = idSobe;
		this.brojKreveta = brojKreveta;
		this.cena = cena;
		this.sprat = sprat;
		this.terasa = terasa;
	}

	/**
	 * get i set metode za atribute sobe
	 */
	
	public int getIdSobe() {
		return idSobe;
	}

	public void setIdSobe(int idSobe) {
		if(idSobe<0) throw new RuntimeException();
		this.idSobe = idSobe;
	}

	public int getBrojKreveta() {
		return brojKreveta;
	}

	public void setBrojKreveta(int brojKreveta) {
		if(brojKreveta<0) throw new RuntimeException();
		this.brojKreveta = brojKreveta;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		if(cena<0) throw new RuntimeException();
		this.cena = cena;
	}

	public int getSprat() {
		return sprat;
	}

	public void setSprat(int sprat) {
		if(sprat<0) throw new RuntimeException();
		this.sprat = sprat;
	}

	public boolean isTerasa() {
		return terasa;
	}

	public void setTerasa(boolean terasa) {
		this.terasa = terasa;
	}

}
