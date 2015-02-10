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


public class ConversorMonedas extends JFrame {
	
	private JPanel contentPane;
	private JTextField ValorEuros;
	private JTextField ValorConversion;
	private JTextField MensajeControl;
	private JComboBox moneda;

	DatosGenerales datos;
	private String textoMonedas[];
	
	// los datos de las monedas
	
	DatosGenerales d=new DatosGenerales();
	
	//los datos de seleccion de las monedas
	
	private float valorMonedaSelecc=0f;
	
	

	/**
	 * Create the frame.
	 */
	public ConversorMonedas() {
		
		{
			setTitle("Ventana Conversi\u00f3n Dolares");
			setResizable(false);
		}

		
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
		ValorEuros.setBounds(29, 72, 185, 20);
		contentPane.add(ValorEuros);
		ValorEuros.setColumns(10);
		
		//COMBOBOX
		moneda = new JComboBox();
		moneda.setBounds(29, 103, 86, 20);
		contentPane.add(moneda);
		moneda.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent arg0){
				ValorEuros.setText("SELECCIONADA LA MONEDA: "+moneda.getSelectedItem());
				switch((String)moneda.getSelectedItem()){
				case DatosGenerales.MONEDA_DOL:
					valorMonedaSelecc=d.getValoresAEuro()[0];
					break;
				case DatosGenerales.MONEDA_EUR:
					valorMonedaSelecc=d.getValoresAEuro()[1];
					break;
				case DatosGenerales.MONEDA_LIB:
					valorMonedaSelecc=d.getValoresAEuro()[2];
					break;
				case DatosGenerales.MONEDA_YEN:
					valorMonedaSelecc=d.getValoresAEuro()[3];
					break;
						
				}
			}
		});
			
		for(int i=0;i<d.getMonedas().length;i++)
			moneda.addItem((String)d.getMonedas()[i]);
	
		//VALOR CONVERSION
		ValorConversion = new JTextField();
		ValorConversion.setBounds(29, 134, 185, 20);
		contentPane.add(ValorConversion);
		ValorConversion.setColumns(10);
		
		//BOTON
		JButton Boton = new JButton("Convertir");
		Boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					float euros;
					euros=Float.parseFloat(ValorEuros.getText());//se convierte de string a float.
					
					if(euros<0){//si ponemos mas de 500 euros
						MensajeControl.setText("LOS EUROS DEBEN ESTAR ENTRE 0 Y 500");// en el textocontrol nos saldra este mensaje
						
					}else if(euros>500){
						MensajeControl.setText("LOS EUROS DEBEN ESTAR ENTRE 0 Y 500");
						
					}else{
						
					MensajeControl.setText("todo ok");
							ValorEuros.setText(String.valueOf(euros*valorMonedaSelecc));
					}
					
				}catch (Exception e1){
					MensajeControl.setText("error en la conversion");
				}
			
			}
		});
		Boton.setBounds(225, 133, 89, 23);
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
	