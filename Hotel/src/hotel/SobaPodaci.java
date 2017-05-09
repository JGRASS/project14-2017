package hotel;

import java.util.GregorianCalendar;

/**
 * klasa koja sluzi za potrebe metode vratiSveSobe
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
		if(datumOd==null) throw new RuntimeException();
		this.datumOd = datumOd;
	}

	public GregorianCalendar getDatumDo() {
		return datumDo;
	}

	public void setDatumDo(GregorianCalendar datumDo) {
		if(datumDo==null) throw new RuntimeException();
		this.datumDo = datumDo;
	}

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
