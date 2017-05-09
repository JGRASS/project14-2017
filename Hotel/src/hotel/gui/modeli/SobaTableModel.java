package hotel.gui.modeli;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import hotel.Soba;

@SuppressWarnings("serial")
public class SobaTableModel extends AbstractTableModel {

	private final String[] kolone = new String[] { "Broj sobe", "Cena nocenja", "Broj kreveta", "Terasa", "Sprat" };
	private LinkedList<Soba> sobe;

	public SobaTableModel(LinkedList<Soba> sobe) {
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
		Soba s = sobe.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return s.getIdSobe();
		case 1:
			return s.getCena();
		case 2:
			return s.getBrojKreveta();
		case 3:
			return s.isTerasa();
		case 4:
			return s.getSprat();
		default:
			return "/";
		}
	}

	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}

	public void ucitajSobe(LinkedList<Soba> sobe) {
		this.sobe = sobe;
		fireTableDataChanged();
	}

	public Soba getSobaByIndex(int index) {
		return sobe.get(index);
	}

}
