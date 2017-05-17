package hotel.gui.modeli;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import hotel.Soba;

/**
 * Klasa koja predstavlja tabelu sa atributima klase Soba
 * 
 * @author jelica
 *
 */
@SuppressWarnings("serial")
public class SobaTableModel extends AbstractTableModel {

	/*
	 * kolone tabele
	 */
	private final String[] kolone = new String[] { "Broj sobe", "Cena nocenja", "Broj kreveta", "Terasa", "Sprat" };

	/*
	 * lista soba ciji podaci odgovaraju kolonama
	 */
	private LinkedList<Soba> sobe;

	/*
	 * konstruktor tabele
	 */
	public SobaTableModel(LinkedList<Soba> sobe) {
		if (sobe == null) {
			this.sobe = new LinkedList<>();
		} else {
			this.sobe = sobe;
		}
	}

	/*
	 * @return broj kolona
	 * 
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	/*
	 * @return broj soba, odnosno redova u tabeli
	 * 
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return sobe.size();
	}

	/*
	 * @return odgovarajucu vrednost polja u tabeli
	 * 
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
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
			if (s.isTerasa())
				return "Ima";
			else
				return "Nema";
		case 4:
			return s.getSprat();
		default:
			return "/";
		}
	}

	/*
	 * @return ime kolone
	 * 
	 * @see javax.swing.table.AbstractTableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}

	/*
	 * ucitavanje soba
	 */
	public void ucitajSobe(LinkedList<Soba> sobe) {
		this.sobe = sobe;
		fireTableDataChanged();
	}

	/*
	 * @return odgovarajucu sobu
	 */
	public Soba getSobaByIndex(int index) {
		return sobe.get(index);
	}

}
