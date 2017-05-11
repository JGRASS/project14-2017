package hotel;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * klasa koja sluzi za potrebe metode vratiSveSobe
 * 
 * @author Veljko
 *
 */
public class SobaPodaci {

	/**
	 * Jedinstveni broj rezervacije
	 */
	private int idRezervacije;
	/**
	 * Ime gosta koji rezervise sobu
	 */
	private String imeGosta;
	/**
	 * Prezime gosta koji rezervise sobu
	 */
	private String prezimeGosta;
	/**
	 * Pocetak rezervacije
	 */
	private GregorianCalendar datumOd;
	/**
	 * Kraj rezervacije
	 */
	private GregorianCalendar datumDo;

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
	public SobaPodaci() {
	}

	/**
	 * konstruktor sobe sa svim atributima
	 */
	public SobaPodaci(int idRezervacije, String imeGosta, String prezimeGosta, GregorianCalendar datumOd,
			GregorianCalendar datumDo, int idSobe, int brojKreveta, int cena, int sprat, boolean terasa) {
		super();
		this.idRezervacije = idRezervacije;
		this.imeGosta = imeGosta;
		this.prezimeGosta = prezimeGosta;
		this.datumOd = datumOd;
		this.datumDo = datumDo;
		this.idSobe = idSobe;
		this.brojKreveta = brojKreveta;
		this.cena = cena;
		this.sprat = sprat;
		this.terasa = terasa;
	}

	/**
	 * get i set metode
	 */
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

	public static String format(GregorianCalendar calendar) {
		SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
		fmt.setCalendar(calendar);
		String dateFormatted = fmt.format(calendar.getTime());
		return dateFormatted;
	}

	public String getDatumOdFancy() {
		if (datumOd != null)
			return format(datumOd);
		return "/";
	}

	public void setDatumOd(GregorianCalendar datumOd) {
		if (datumOd == null)
			throw new RuntimeException();
		this.datumOd = datumOd;
	}

	public GregorianCalendar getDatumDo() {
		return datumDo;
	}

	public String getDatumDoFancy() {
		if (datumOd != null)
			return format(datumOd);
		return "/";
	}

	public void setDatumDo(GregorianCalendar datumDo) {
		if (datumDo == null)
			throw new RuntimeException();
		this.datumDo = datumDo;
	}

	public int getIdSobe() {
		return idSobe;
	}

	public void setIdSobe(int idSobe) {
		if (idSobe < 0)
			throw new RuntimeException();
		this.idSobe = idSobe;
	}

	public int getBrojKreveta() {
		return brojKreveta;
	}

	public void setBrojKreveta(int brojKreveta) {
		if (brojKreveta < 0)
			throw new RuntimeException();
		this.brojKreveta = brojKreveta;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		if (cena < 0)
			throw new RuntimeException();
		this.cena = cena;
	}

	public int getSprat() {
		return sprat;
	}

	public void setSprat(int sprat) {
		if (sprat < 0)
			throw new RuntimeException();
		this.sprat = sprat;
	}

	public boolean isTerasa() {
		return terasa;
	}

	public void setTerasa(boolean terasa) {
		this.terasa = terasa;
	}

}
