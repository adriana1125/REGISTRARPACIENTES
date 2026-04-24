package datosglucosa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
public class MAIIN extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	List<registro> registros=new ArrayList<>();// creo mi arraylist
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboDia;
	private JComboBox comboMes;
	private JComboBox comboAño;
	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public MAIIN() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(229, 74, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNOMBRE = new JLabel("Nombre: ");
		lblNOMBRE.setBounds(127, 77, 92, 14);
		contentPane.add(lblNOMBRE);
		
		JLabel lblGLUCOSA = new JLabel("Glucosa:");
		lblGLUCOSA.setBounds(127, 111, 92, 14);
		contentPane.add(lblGLUCOSA);
		
		comboDia = new JComboBox();
		comboDia.setBounds(285, 136, 60, 22);
		contentPane.add(comboDia);

		comboMes = new JComboBox();
		comboMes.setBounds(285, 164, 60, 22);
		contentPane.add(comboMes);

		comboAño = new JComboBox();
		comboAño.setBounds(285, 197, 70, 22);
		contentPane.add(comboAño);
		
		//dia
		for(int i=1;i<=31;i++){
		    comboDia.addItem(String.valueOf(i));
		}

		//mes
		for(int i=1;i<=12;i++){
		    comboMes.addItem(String.valueOf(i));
		} 

		//año
		for(int i=2020;i<=2030;i++){
		    comboAño.addItem(String.valueOf(i));
		}
		
		java.time.LocalDate hoy = java.time.LocalDate.now();

		comboDia.setSelectedItem(String.valueOf(hoy.getDayOfMonth()));
		comboMes.setSelectedItem(String.valueOf(hoy.getMonthValue()));
		comboAño.setSelectedItem(String.valueOf(hoy.getYear()));
		
		textField_1 = new JTextField();
		textField_1.setBounds(229, 108, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnGUARDAR = new JButton("Guardar");
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
				System.out.println("Guardado");
			}
		});
		btnGUARDAR.setBounds(167, 227, 89, 23);
		contentPane.add(btnGUARDAR);
		
		JLabel lblDIA = new JLabel("Día:");
		lblDIA.setBounds(127, 140, 129, 14);
		contentPane.add(lblDIA);
		
		JLabel lblMES = new JLabel("Mes:");
		lblMES.setBounds(127, 168, 148, 14);
		contentPane.add(lblMES);
		
		JLabel lblAÑO = new JLabel("Año:");
		lblAÑO.setBounds(127, 187, 148, 14);
		contentPane.add(lblAÑO);

	}
}