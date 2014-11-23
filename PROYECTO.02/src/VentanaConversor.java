import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaConversor extends JFrame {

	private JPanel contentPane;
	private JTextField ValorEuros;
	private JTextField ValorDolares;
	private JTextField TextoControl;

	


	/**
	 * Create the frame.
	 */
	public VentanaConversor(float valorConversion) {
		setTitle ("Ventana Conversi\u00f3n Dolares");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INTRODUCIR UN VALOR EN EUROS ENTRE 0 Y 500 EUROS");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(10, 35, 330, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblEuros = new JLabel("Euros");
		lblEuros.setBounds(10, 82, 46, 14);
		contentPane.add(lblEuros);
		
		ValorEuros = new JTextField();
		ValorEuros.setBounds(10, 104, 63, 20);
		contentPane.add(ValorEuros);
		ValorEuros.setColumns(10);
		
		JLabel lblDolares = new JLabel("Dolares");
		lblDolares.setBounds(10, 141, 46, 14);
		contentPane.add(lblDolares);
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
				float euros;
				euros=Float.parseFloat(ValorEuros.getText());//se convierte de string a float,aqui meteresmos los euros(que son string)
				ValorDolares.setText(String.valueOf(euros*valorConversion));//y de float a string
				TextoControl.setText("OK");// txtOp es la variable del jtexfield
				
				if(euros>500)//si ponemos mas de 500 euros
				{
					TextoControl.setText("LOS EUROS DEBEN ESTAR ENTRE 0 Y 500");// en el textocontrol nos saldra este mensaje
					ValorDolares.setText("0");//si ponemos mas de 500 en valor dolares saldra un cero.
					
				}
				
				if(euros<0)
				{
					TextoControl.setText("LOS EUROS DEBEN ESTAR ENTRE 0 Y 500");//en el textocontrol nos saldra este mensaje
					ValorDolares.setText("0");//si ponemos menos de 0 en valor dolares 
				}
				}catch(Exception e){//y si se produce una excepcion...
					
					TextoControl.setText("SE HA PRODUCIDO 1 ERROR EN LA CONVERSION");		
				}	
			}
			
		
			
		});
		btnConvertir.setBounds(104, 132, 89, 23);
		contentPane.add(btnConvertir);
		
		JLabel lblMensajeDeControl = new JLabel("MENSAJE DE CONTROL");
		lblMensajeDeControl.setForeground(Color.BLUE);
		lblMensajeDeControl.setBounds(10, 210, 134, 14);
		contentPane.add(lblMensajeDeControl);
		
		ValorDolares = new JTextField();
		ValorDolares.setColumns(10);
		ValorDolares.setBounds(10, 169, 63, 20);
		contentPane.add(ValorDolares);
		
		TextoControl = new JTextField();
		TextoControl.setColumns(10);
		TextoControl.setBounds(10, 230, 354, 20);
		contentPane.add(TextoControl);
	}

}
