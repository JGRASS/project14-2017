package hotel;

import java.util.GregorianCalendar;
/**
 * @author jelica
 *
 */
public class Rezervacija {
	int idRezervacije;
	int idSobe;
	String imeGosta;
	String prezimeGosta;
	GregorianCalendar datumOd;
	GregorianCalendar datumDo;

	public Rezervacija() {
	}

	public Rezervacija(int idRezervacije, int idSobe, String imeGosta, String prezimeGosta, GregorianCalendar datumOd,
			GregorianCalendar datumDo) {
		super();
		this.idRezervacije = idRezervacije;
		this.idSobe = idSobe;
		this.imeGosta = imeGosta;
		this.prezimeGosta = prezimeGosta;
		this.datumOd = datumOd;
		this.datumDo = datumDo;
	}

	public int getIdRezervacije() {
		return idRezervacije;
	}

	public void setIdRezervacije(int idRezervacije) {
		this.idRezervacije = idRezervacije;
	}

	public int getIdSobe() {
		return idSobe;
	}

	public void setIdSobe(int idSobe) {
		this.idSobe = idSobe;
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

}
