package datosglucosa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JList;
import javax.swing.JTextArea;

public class MAIIN extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	List<registro> registros=new ArrayList<>();
	private DefaultListModel<String> listModel = new DefaultListModel<>();

	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboDia;
	private JComboBox comboMes;
	private JComboBox comboAño;

	private JTabbedPane tabbedPane;
	private JToolBar toolBar;
	private JToolBar toolBar_1;
	private JPanel panel;
	private JPanel panel_1;
	private JList list;
	private JButton btnMostrarhistorial;

	private JTextField txtnombre;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MAIIN frame = new MAIIN();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MAIIN() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 37, 426, 226);
		contentPane.add(tabbedPane);

		toolBar = new JToolBar();
		tabbedPane.addTab("Registro", null, toolBar, null);

		panel = new JPanel();
		toolBar.add(panel);
		panel.setLayout(null);

		JLabel lblNOMBRE = new JLabel("Nombre: ");
		lblNOMBRE.setBounds(103, 10, 92, 14);
		panel.add(lblNOMBRE);

		textField = new JTextField();
		textField.setBounds(202, 8, 86, 20);
		panel.add(textField);

		JLabel lblGLUCOSA = new JLabel("Glucosa:");
		lblGLUCOSA.setBounds(103, 34, 92, 14);
		panel.add(lblGLUCOSA);

		textField_1 = new JTextField();
		textField_1.setBounds(202, 32, 86, 20);
		panel.add(textField_1);

		JLabel lblDIA = new JLabel("Día:");
		lblDIA.setBounds(159, 66, 36, 14);
		panel.add(lblDIA);

		comboDia = new JComboBox();
		comboDia.setBounds(212, 62, 60, 22);
		panel.add(comboDia);

		comboMes = new JComboBox();
		comboMes.setBounds(212, 93, 60, 22);
		panel.add(comboMes);

		JLabel lblMES = new JLabel("Mes:");
		lblMES.setBounds(157, 97, 36, 14);
		panel.add(lblMES);

		JLabel lblAÑO = new JLabel("Año:");
		lblAÑO.setBounds(159, 129, 46, 14);
		panel.add(lblAÑO);

		comboAño = new JComboBox();
		comboAño.setBounds(202, 125, 70, 22);
		panel.add(comboAño);

		for(int i=1;i<=31;i++){
		    comboDia.addItem(String.valueOf(i));
		}

		for(int i=1;i<=12;i++){
		    comboMes.addItem(String.valueOf(i));
		}

		for(int i=2020;i<=2030;i++){
		    comboAño.addItem(String.valueOf(i));
		}

		java.time.LocalDate hoy = java.time.LocalDate.now();

		comboDia.setSelectedItem(String.valueOf(hoy.getDayOfMonth()));
		comboMes.setSelectedItem(String.valueOf(hoy.getMonthValue()));
		comboAño.setSelectedItem(String.valueOf(hoy.getYear()));

		JButton btnGUARDAR = new JButton("Guardar");
		btnGUARDAR.setBounds(142, 156, 89, 23);
		panel.add(btnGUARDAR);

		btnGUARDAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nombre = textField.getText();
				double glucosa = Double.parseDouble(textField_1.getText());

				int dia = Integer.parseInt(comboDia.getSelectedItem().toString());
				int mes = Integer.parseInt(comboMes.getSelectedItem().toString());
				int año = Integer.parseInt(comboAño.getSelectedItem().toString());

				java.time.LocalDate fecha = java.time.LocalDate.of(año, mes, dia);

				registro nuevo = new registro(nombre, glucosa, fecha);
				registros.add(nuevo);
			}
		});

		toolBar_1 = new JToolBar();
		tabbedPane.addTab("Historial", null, toolBar_1, null);

		panel_1 = new JPanel();
		toolBar_1.add(panel_1);
		panel_1.setLayout(null);

		JList<String> list = new JList<>(listModel);
		list.setBounds(10, 10, 388, 140);
		panel_1.add(list);

		btnMostrarhistorial = new JButton("Mostrar historial");
		btnMostrarhistorial.setBounds(122, 160, 152, 20);
		panel_1.add(btnMostrarhistorial);

		btnMostrarhistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.clear();
				registros.sort(Comparator.comparing(registro::getNombre));

				String persona = "";

				for(registro x: registros) {
					if(!x.getNombre().equals(persona)) {
						persona = x.getNombre();
						listModel.addElement(persona);
					}
					listModel.addElement("Fecha:"+String.valueOf(x.getFecha()));
					listModel.addElement("Toma glucosa:"+String.valueOf(x.getGlucosa()));
				}
			}
		});

		JTextArea textArea = new JTextArea();
		textArea.setBounds(516, 122, 250, 220);
		contentPane.add(textArea);

		txtnombre = new JTextField();
		txtnombre.setBounds(516, 42, 236, 20);
		contentPane.add(txtnombre);

		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(570, 73, 89, 23);
		contentPane.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String buscaNom = txtnombre.getText();
				textArea.setText("");

				for(registro r: registros) {
					if(r.getNombre().equals(buscaNom)) {
						textArea.append(r.toString() + "\n");
					}
				}
			}
		});
	}
}