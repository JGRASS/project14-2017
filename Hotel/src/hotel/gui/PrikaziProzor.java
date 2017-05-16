package hotel.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hotel.gui.modeli.SobaTableModel;
import hotel.model.Hotel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Toolkit;
/**
 * @author jelica
 *
 */
@SuppressWarnings("serial")
public class PrikaziProzor extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrikaziProzor frame = new PrikaziProzor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrikaziProzor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrikaziProzor.class.getResource("/icon/hotel.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 609, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);

		JButton btnPrikaziSaTerasom = new JButton("Prikazi sa terasom");
		btnPrikaziSaTerasom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					table = getTableT();
					scrollPane.setViewportView(table);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		panel_1.add(btnPrikaziSaTerasom);

		JButton btnPrikaziNaSpratu = new JButton("Prikazi na spratu:");
		panel_1.add(btnPrikaziNaSpratu);

		JComboBox<Integer> comboBoxSprat = new JComboBox<Integer>();
		panel_1.add(comboBoxSprat);
		comboBoxSprat.addItem(1);
		comboBoxSprat.addItem(2);
		comboBoxSprat.addItem(3);
		comboBoxSprat.addItem(4);
		comboBoxSprat.addItem(5);

		JButton btnPrikaziSaBrojem = new JButton("Prikazi sa brojem kreveta:");
		panel_1.add(btnPrikaziSaBrojem);

		JComboBox<Integer> comboBoxKreveti = new JComboBox<Integer>();
		panel_1.add(comboBoxKreveti);
		comboBoxKreveti.addItem(1);
		comboBoxKreveti.addItem(2);
		comboBoxKreveti.addItem(3);
		comboBoxKreveti.addItem(4);
		comboBoxKreveti.addItem(5);
		btnPrikaziSaBrojem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Hotel hotel = new Hotel();

				table = new JTable();
				SobaTableModel model;
				try {
					if (hotel.vratiSaKrevetom((int) comboBoxKreveti.getSelectedItem()) == null
							|| hotel.vratiSaKrevetom((int) comboBoxKreveti.getSelectedItem()).isEmpty()) {
						JOptionPane.showMessageDialog(
								contentPane, "Ne postoji soba sa datim brojem kreveta("
										+ (int) comboBoxKreveti.getSelectedItem() + ")! ",
								"Greska!!!", JOptionPane.ERROR_MESSAGE);

					} else {
						model = new SobaTableModel(hotel.vratiSaKrevetom((int) comboBoxKreveti.getSelectedItem()));
						table.setModel(model);
						scrollPane.setViewportView(table);
					}
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(
							contentPane, "Ne postoji soba sa datim brojem kreveta("
									+ (int) comboBoxKreveti.getSelectedItem() + ")! ",
							"Greska!!!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnPrikaziNaSpratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Hotel hotel = new Hotel();

				table = new JTable();
				SobaTableModel model;
				try {
					if (hotel.vratiSprat((int) comboBoxSprat.getSelectedItem()) == null
							|| hotel.vratiSprat((int) comboBoxSprat.getSelectedItem()).isEmpty()) {
						JOptionPane.showMessageDialog(contentPane,
								"Ne postoji soba na " + (int) comboBoxSprat.getSelectedItem() + " spratu!", "Greska!!!",
								JOptionPane.ERROR_MESSAGE);

					} else {
						model = new SobaTableModel(hotel.vratiSprat((int) comboBoxSprat.getSelectedItem()));
						table.setModel(model);
						scrollPane.setViewportView(table);
					}
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(contentPane,
							"Ne postoji soba na " + (int) comboBoxSprat.getSelectedItem() + " spratu!", "Greska!!!",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
	}

	private JTable getTableT() throws SQLException {
		Hotel hotel = new Hotel();

		table = new JTable();
		SobaTableModel model = new SobaTableModel(hotel.vratiSaTerasom());
		table.setModel(model);

		return table;
	}

}
