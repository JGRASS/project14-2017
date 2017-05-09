package hotel.gui.modeli;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import hotel.SobaPodaci;

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
			return s.isTerasa();
		case 4:
			return s.getIdRezervacije();
		case 5:
			return s.getDatumOd();
		case 6:
			return s.getDatumDo();
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
