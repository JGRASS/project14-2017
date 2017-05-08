package hotel;
/**
 * @author jelica
 *
 */
public class Soba {
	int idSobe;
	int brojKreveta;
	int cena;
	int sprat;
	boolean terasa;

	public Soba() {
	}

	public Soba(int idSobe, int brojKreveta, int cena, int sprat, boolean terasa) {
		super();
		this.idSobe = idSobe;
		this.brojKreveta = brojKreveta;
		this.cena = cena;
		this.sprat = sprat;
		this.terasa = terasa;
	}

	public int getIdSobe() {
		return idSobe;
	}

	public void setIdSobe(int idSobe) {
		this.idSobe = idSobe;
	}

	public int getBrojKreveta() {
		return brojKreveta;
	}

	public void setBrojKreveta(int brojKreveta) {
		this.brojKreveta = brojKreveta;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public int getSprat() {
		return sprat;
	}

	public void setSprat(int sprat) {
		this.sprat = sprat;
	}

	public boolean isTerasa() {
		return terasa;
	}

	public void setTerasa(boolean terasa) {
		this.terasa = terasa;
	}

}
