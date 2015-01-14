import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class VentanaConversorMejorado extends JFrame {
	
	private JPanel contentPane;
	private JTextField ValorEuros;
	private JTextField ValorConversion;
	private JTextField MensajeControl;



	/**
	 * Create the frame.
	 */
	public VentanaConversorMejorado() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 369, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INTRODUCIR UN VALOR EN EUROS ENTRE 0\u20AC Y 500\u20AC  ");
		lblNewLabel.setBounds(29, 11, 343, 14);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Euros");
		lblNewLabel_1.setBounds(29, 47, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		//VALOR EUROS
		ValorEuros = new JTextField();
		ValorEuros.setBounds(29, 72, 86, 20);
		contentPane.add(ValorEuros);
		ValorEuros.setColumns(10);
		
		//COMBOBOX
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(29, 103, 86, 20);
		contentPane.add(comboBox);
		
		//añadimos elementos al combobox
		//definimos un array 	
		
		String monedas[]=new String[3];//dentro del corchete meteremos todos los strings que consideremos.
		
		//ponemos el contenido del array
		
		 monedas[0]="libras";//siempre se empieza por cero.... asta llegar a 3 posicienes contando el cero.
		 monedas[1]="dolares";
		 monedas[2]="yen";
		comboBox.addItem(monedas[0]);
		comboBox.addItem(monedas[1]);
		comboBox.addItem(monedas[2]);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				switch((String)comboBox.getSelectedItem())
				{
				case "libras":
					MensajeControl.setText("SELECCIONADA LA MONEDA:Libras");
					float euros;
					euros=Float.parseFloat(ValorEuros.getText());//se convierte de string a float,aqui meteresmos los euros(que son string)
					float valorConversionLibras = (float) 10.00;
					ValorConversion.setText(String.valueOf(euros*valorConversionLibras));//y de float a string
				break;
				case "dolares":
					MensajeControl.setText("SELECCIONADA LA MONEDA:Dolares");
					float dolares;
					euros=Float.parseFloat(ValorEuros.getText());//se convierte de string a float,aqui meteresmos los euros(que son string)
					float valorConversiondolares = (float) 20.00;
					ValorConversion.setText(String.valueOf(euros*valorConversiondolares));//y de float a string
					break;
				case "yen":
					MensajeControl.setText("SELECCIONADA LA MONEDA:Yen");
					float yen;
					euros=Float.parseFloat(ValorEuros.getText());//se convierte de string a float,aqui meteresmos los euros(que son string)
					float valorConversionyen = (float) 30.00;
					ValorConversion.setText(String.valueOf(euros*valorConversionyen));//y de float a string
					break;
					default:MensajeControl.setText("TIENES QUE ELEGIR UNA MONEDA");//PONEMOS DEFAULT PARA LAS COSAS QUE NO PONEMOS EN CASE.
						break;
				}
			}
		});
		
		//VALOR CONVERSION
		ValorConversion = new JTextField();
		ValorConversion.setBounds(29, 134, 86, 20);
		contentPane.add(ValorConversion);
		ValorConversion.setColumns(10);
		
		//BOTON
		JButton Boton = new JButton("Convertir");
		Boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					float euros;
					euros=Float.parseFloat(ValorEuros.getText());//se convierte de string a float.
					
					if(euros>500)//si ponemos mas de 500 euros
					{
						MensajeControl.setText("LOS EUROS DEBEN ESTAR ENTRE 0 Y 500");// en el textocontrol nos saldra este mensaje
						ValorConversion.setText("0");//si ponemos mas de 500 en valor dolares saldra un cero.
						
					}
					
					if(euros<0)
					{
						MensajeControl.setText("LOS EUROS DEBEN ESTAR ENTRE 0 Y 500");//en el textocontrol nos saldra este mensaje
						ValorConversion.setText("0");//si ponemos menos de 0 en valor dolares 
					}
					}catch(Exception e1){//y si se produce una excepcion...
						
						MensajeControl.setText("SE HA PRODUCIDO 1 ERROR EN LA CONVERSION");		
					}	
				}
				
			
			
		});
		Boton.setBounds(125, 134, 89, 23);
		contentPane.add(Boton);
		
		JLabel lblNewLabel_2 = new JLabel("Mensaje de control");
		lblNewLabel_2.setBounds(29, 183, 132, 14);
		contentPane.add(lblNewLabel_2);
		
		//MENSAJE CONTROL
		MensajeControl = new JTextField();
		MensajeControl.setForeground(Color.RED);
		MensajeControl.setBounds(29, 210, 309, 20);
		contentPane.add(MensajeControl);
		MensajeControl.setColumns(10);
	}
}
