package hotel.gui.modeli;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import hotel.SobaPodaci;

/**
 *  Klasa koja predstavlja tabelu sa atributima klase SobaPodaci
 * @author jelica
 *
 */

@SuppressWarnings("serial")
public class SobaPodaciTableModel extends AbstractTableModel {
	private final String[] kolone = new String[] { "Broj sobe", "Broj kreveta", "Sprat", "Terasa","Broj rezervacije", "DatumOd", "DatumDo" };
	private LinkedList<SobaPodaci> sobe;

	public SobaPodaciTableModel(LinkedList<SobaPodaci> sobe) {
		if (sobe == null) {
			this.sobe = new LinkedList<>();
		} else {
			this.sobe = sobe;
		}
	}

	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		return sobe.size();
	}

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
	
	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}

	public void ucitajSobe(LinkedList<SobaPodaci> sobe) {
		this.sobe = sobe;
		fireTableDataChanged();
	}

	public SobaPodaci getSobaByIndex(int index) {
		return sobe.get(index);
	}
}
