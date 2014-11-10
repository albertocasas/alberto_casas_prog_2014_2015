import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaConversor extends JFrame {

	private JPanel contentPane;
	private JTextField ValorEuros;
	private JTextField ValorDolares;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @param valorConversion 
	 */
	public VentanaConversor(float valorConversion) {
		setTitle ("Ventana Conversi\u00f3n Dolares");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 229, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ValorEuros = new JTextField();
		ValorEuros.setBounds(10, 36, 86, 20);
		contentPane.add(ValorEuros);
		ValorEuros.setColumns(10);
		
		JLabel lblEuros = new JLabel("Euros");
		lblEuros.setBounds(10, 11, 46, 14);
		contentPane.add(lblEuros);
		
		JLabel lblDolares = new JLabel("Dolares");
		lblDolares.setBounds(10, 87, 46, 14);
		contentPane.add(lblDolares);
		
		ValorDolares = new JTextField();
		ValorDolares.setColumns(10);
		ValorDolares.setBounds(10, 112, 86, 20);
		contentPane.add(ValorDolares);
		
		//BOTON
		JButton btnNewButton = new JButton("Convertir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				float euros;
				euros=Float.parseFloat(ValorEuros.getText());//se convierte de string a float,aqui meteresmos los euros(que son string)
				ValorDolares.setText(String.valueOf(euros*valorConversion));//y de float a string
				
			}
		});
		btnNewButton.setBounds(117, 111, 89, 23);
		contentPane.add(btnNewButton);
	}
}
