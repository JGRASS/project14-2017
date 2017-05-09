package hotel;

import java.util.GregorianCalendar;

/**
 * 
 * @author Veljko
 *
 */
public class SobaPodaci {
	int idRezervacije;
	String imeGosta;
	String prezimeGosta;
	GregorianCalendar datumOd;
	GregorianCalendar datumDo;

	int idSobe;
	int brojKreveta;
	int cena;
	int sprat;
	boolean terasa;

	public int getIdRezervacije() {
		return idRezervacije;
	}

	public void setIdRezervacije(int idRezervacije) {
		this.idRezervacije = idRezervacije;
	}

	public String getImeGosta() {
		return imeGosta;
	}

	public void setImeGosta(String imeGosta) {
		this.imeGosta = imeGosta;
	}

	public String getPrezimeGosta() {
		return prezimeGosta;
	}

	public void setPrezimeGosta(String prezimeGosta) {
		this.prezimeGosta = prezimeGosta;
	}

	public GregorianCalendar getDatumOd() {
		return datumOd;
	}

	public void setDatumOd(GregorianCalendar datumOd) {
		this.datumOd = datumOd;
	}

	public GregorianCalendar getDatumDo() {
		return datumDo;
	}

	public void setDatumDo(GregorianCalendar datumDo) {
		this.datumDo = datumDo;
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
