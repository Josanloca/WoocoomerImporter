package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ayuda extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	
	public Ayuda() {
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBackground(SystemColor.control);
		contentPanel.setBackground(SystemColor.control);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Manual de usuario:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(142, 11, 178, 32);
			contentPanel.add(lblNewLabel);
		}
		{
			JButton btnNewButton = new JButton(">>");
			btnNewButton.setEnabled(false);
			btnNewButton.setBounds(10, 58, 55, 23);
			contentPanel.add(btnNewButton);
		}
		
		JTextArea txtrLosBotonesDireccionales = new JTextArea();
		txtrLosBotonesDireccionales.setBackground(SystemColor.control);
		txtrLosBotonesDireccionales.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrLosBotonesDireccionales.setText("Los botones direccionales le permitir\u00E1n ir\r\nalternando entre productos:\r\n<</>>: Anterior/Siguiente producto\r\n|</>|: Primer/\u00DAltimo producto");
		txtrLosBotonesDireccionales.setEditable(false);
		txtrLosBotonesDireccionales.setBounds(75, 57, 349, 96);
		contentPanel.add(txtrLosBotonesDireccionales);
		
		JTextArea txtrParaSeleccionarVarios = new JTextArea();
		txtrParaSeleccionarVarios.setEditable(false);
		txtrParaSeleccionarVarios.setBackground(SystemColor.control);
		txtrParaSeleccionarVarios.setText("Para seleccionar varias opciones de Talla, Color\r\no Categor\u00EDa haga Ctrl + Click sobre ellas.");
		txtrParaSeleccionarVarios.setBounds(10, 155, 414, 62);
		contentPanel.add(txtrParaSeleccionarVarios);
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
