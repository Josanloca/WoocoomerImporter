package View;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Dimensiones extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	public static JTextField tfPeso;
	public static JTextField tfLargo;
	public static JTextField tfAncho;
	public static JTextField tfAlto;

	public Dimensiones() {
		
		
		setModal(true);
		setTitle("Opciones de envio");
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		setBounds(100, 100, 250, 305);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Env\u00EDo:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(40, 11, 108, 23);
		contentPanel.add(lblNewLabel);
		{
			JLabel lblNewLabel_1 = new JLabel("Peso (kg):");
			lblNewLabel_1.setBounds(30, 53, 69, 14);
			contentPanel.add(lblNewLabel_1);
		}
		
		tfPeso = new JTextField();
		tfPeso.setBounds(108, 50, 86, 20);
		contentPanel.add(tfPeso);
		tfPeso.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Dimensiones (cm):");
		lblNewLabel_2.setBounds(30, 100, 98, 14);
		contentPanel.add(lblNewLabel_2);
		
		tfLargo = new JTextField();
		tfLargo.setBounds(108, 120, 86, 20);
		contentPanel.add(tfLargo);
		tfLargo.setColumns(10);
		
		tfAncho = new JTextField();
		tfAncho.setBounds(108, 150, 86, 20);
		contentPanel.add(tfAncho);
		tfAncho.setColumns(10);
		
		tfAlto = new JTextField();
		tfAlto.setBounds(108, 180, 86, 20);
		contentPanel.add(tfAlto);
		tfAlto.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Largo:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(40, 120, 69, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ancho:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setBounds(40, 150, 46, 14);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Alto:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setBounds(40, 180, 68, 14);
		contentPanel.add(lblNewLabel_5);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
