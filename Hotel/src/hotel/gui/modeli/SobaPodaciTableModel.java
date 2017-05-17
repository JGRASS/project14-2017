package hotel.gui.modeli;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import hotel.SobaPodaci;

/**
 *  Klasa koja predstavlja tabelu sa atributima klase SobaPodaci 
 *  (takva tabela ne postoji konkretno u bazi, vec je mi sami formiramo na osnovu podataka iz ostale 2 tabele baze(Soba i Rezervacija))
 * @author jelica
 *
 */

@SuppressWarnings("serial")
public class SobaPodaciTableModel extends AbstractTableModel {
	/*
	 * kolone tabele
	 */
	private final String[] kolone = new String[] { "Broj sobe", "Broj kreveta", "Sprat", "Terasa","Broj rezervacije", "DatumOd", "DatumDo" };
	
	/*
	 * lista soba ciji podaci odgovaraju kolonama
	 */
	private LinkedList<SobaPodaci> sobe;

	/*
	 * konstruktor tabele
	 */
	public SobaPodaciTableModel(LinkedList<SobaPodaci> sobe) {
		if (sobe == null) {
			this.sobe = new LinkedList<>();
		} else {
			this.sobe = sobe;
		}
	}

	/*
	 * @return broj kolona
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	/*
	 * @return broj soba, odnosno redova u tabeli
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return sobe.size();
	}

	/*
	 * @return odgovarajucu vrednost polja u tabeli
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		SobaPodaci s = sobe.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return s.getIdSobe();
		case 1:
			return s.getBrojKreveta();
		case 2:
			return s.getSprat();
		case 3:
			if(s.isTerasa()) return "Ima"; else return "Nema";
		case 4:
			if(s.getIdRezervacije()==0) return "Ne postoji"; else return s.getIdRezervacije();
		case 5:
			return s.getDatumOdFancy();
		case 6:
			return s.getDatumDoFancy();
		default:
			return "/";
		}
	}
	
	/*
	 * @return ime kolone
	 * @see javax.swing.table.AbstractTableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}

	/*
	 * ucitavanje soba
	 */
	public void ucitajSobe(LinkedList<SobaPodaci> sobe) {
		this.sobe = sobe;
		fireTableDataChanged();
	}

	/*
	 * @return odgovarajucu sobu
	 */
	public SobaPodaci getSobaByIndex(int index) {
		return sobe.get(index);
	}
}
