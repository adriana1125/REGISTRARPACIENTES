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
		
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(229, 108, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnGUARDAR = new JButton("Guardar");
		btnGUARDAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nombre = textField.getText();
				double glucosa = Double.parseDouble(textField_1.getText());

			

			registro nuevo = new registro(nombre, glucosa);
			registros.add(nuevo);
				System.out.println("Guardado");
			}
		});
		btnGUARDAR.setBounds(167, 227, 89, 23);
		contentPane.add(btnGUARDAR);
		
		

	}
}