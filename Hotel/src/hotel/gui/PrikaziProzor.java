package hotel.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hotel.gui.modeli.SobaTableModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
				
					table = new JTable();
					SobaTableModel model;
					if(GUIKontroler.vratiSaTerasom() == null || GUIKontroler.vratiSaTerasom().isEmpty()) {
						JOptionPane.showMessageDialog(contentPane, "Ne postoji soba sa terasom! ", "Greska!!!",
								JOptionPane.ERROR_MESSAGE);
					} else {
						model = new SobaTableModel(GUIKontroler.vratiSaTerasom());
						table.setModel(model);
						scrollPane.setViewportView(table);
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

				table = new JTable();
				SobaTableModel model;
				int brojKreveta = ((int) comboBoxKreveti.getSelectedItem());

				if (GUIKontroler.vratiSaKrevetom(brojKreveta) == null
						|| GUIKontroler.vratiSaKrevetom(brojKreveta).isEmpty()) {
					JOptionPane.showMessageDialog(contentPane,
							"Ne postoji soba sa datim brojem kreveta(" + brojKreveta + ")! ", "Greska!!!",
							JOptionPane.ERROR_MESSAGE);

				} else {
					model = new SobaTableModel(GUIKontroler.vratiSaKrevetom(brojKreveta));
					table.setModel(model);
					scrollPane.setViewportView(table);
				}

			}
		});

		btnPrikaziNaSpratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				table = new JTable();
				SobaTableModel model;
				int sprat = ((int) comboBoxSprat.getSelectedItem());

				if (GUIKontroler.vratiSprat(sprat) == null || GUIKontroler.vratiSprat(sprat).isEmpty()) {
					JOptionPane.showMessageDialog(contentPane,
							"Ne postoji soba na " + (int) comboBoxSprat.getSelectedItem() + " spratu!", "Greska!!!",
							JOptionPane.ERROR_MESSAGE);

				} else {
					model = new SobaTableModel(GUIKontroler.vratiSprat(sprat));
					table.setModel(model);
					scrollPane.setViewportView(table);
				}

			}
		});
	}

	

}
