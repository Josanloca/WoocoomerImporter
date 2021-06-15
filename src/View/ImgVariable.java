package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logic.logicaGeneral;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ImgVariable extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	public static JButton btAmarillo;
	public static JLabel imgAmarillo;
	
	public static JLabel imgAzul;
	public static JButton btAzul;
	
	public static JLabel imgRojo;
	public static JButton btRojo;
	
	public static JLabel imgVerde;
	public static JButton btVerde;
	
	public static JLabel imgBlanco;
	public static JButton btBlanco;
	
	public static JLabel imgGris;
	public static JButton btGris;
	
	public static JLabel imgMorado;
	public static JButton btMorado;
	
	public static JLabel imgNegro;
	public static JButton btNegro;
	
	public static JLabel lbRutaSAmarillo;
	public static JLabel lbRutaLAmarillo;
	public static JLabel lbRutaLAzul;
	public static JLabel lbRutaSAzul;
	public static JLabel lbRutaLRojo;
	public static JLabel lbRutaSRojo;
	public static JLabel lbRutaLVerde;
	public static JLabel lbRutaSVerde;
	public static JLabel lbRutaLBlanco;
	public static JLabel lbRutaSBlanco;
	public static JLabel lbRutaLGris;
	public static JLabel lbRutaSGris;
	public static JLabel lbRutaLMorado;
	public static JLabel lbRutaSMorado;
	public static JLabel lbRutaLNegro;
	public static JLabel lbRutaSNegro;
	

	public ImgVariable() {
		setTitle("Imagen variable");
		
		setBounds(0, 89, 600, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btAmarillo = new JButton("Cargar imagen");
		btAmarillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logicaGeneral.VariableImgOneXOne(Principal.frame,"Amarillo", btAmarillo,imgAmarillo);
			}
		});
		
		btAmarillo.setBounds(10, 90, 132, 23);
		contentPanel.add(btAmarillo);

		JPanel PanelImgAmarillo = new JPanel();
		PanelImgAmarillo.setBounds(49, 27, 50, 50);
		contentPanel.add(PanelImgAmarillo);
		PanelImgAmarillo.setLayout(new BorderLayout(0, 0));
			
		imgAmarillo = new JLabel("");
		PanelImgAmarillo.add(imgAmarillo, BorderLayout.CENTER);

		JPanel PanelImgAzul = new JPanel();
		PanelImgAzul.setBounds(191, 27, 50, 50);
		contentPanel.add(PanelImgAzul);
		PanelImgAzul.setLayout(new BorderLayout(0, 0));
			
		imgAzul = new JLabel("");
		PanelImgAzul.add(imgAzul, BorderLayout.CENTER);
		
		
		btAzul = new JButton("Cargar imagen");
		btAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logicaGeneral.VariableImgOneXOne(Principal.frame,"Azul",btAzul,imgAzul);
			}
		});
		
		btAzul.setBounds(152, 90, 132, 23);
		contentPanel.add(btAzul);

		JPanel PanelImgRojo = new JPanel();
		PanelImgRojo.setBounds(333, 27, 50, 50);
		contentPanel.add(PanelImgRojo);
		PanelImgRojo.setLayout(new BorderLayout(0, 0));
			
		imgRojo = new JLabel("");
		PanelImgRojo.add(imgRojo, BorderLayout.CENTER);

		btRojo = new JButton("Cargar imagen");
		btRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logicaGeneral.VariableImgOneXOne(Principal.frame,"Rojo",btRojo,imgRojo);
			}
		});
		
		btRojo.setBounds(294, 90, 132, 23);
		contentPanel.add(btRojo);

		JPanel PanelImgVerde = new JPanel();
		PanelImgVerde.setBounds(481, 27, 50, 50);
		contentPanel.add(PanelImgVerde);
		PanelImgVerde.setLayout(new BorderLayout(0, 0));
			
		imgVerde = new JLabel("");
		PanelImgVerde.add(imgVerde, BorderLayout.CENTER);
		
		
		btVerde = new JButton("Cargar imagen");
		btVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logicaGeneral.VariableImgOneXOne(Principal.frame,"Verde",btVerde,imgVerde);
			}
		});
		
		btVerde.setBounds(442, 90, 132, 23);
		contentPanel.add(btVerde);
		
		
		JPanel PanelImgBlanco = new JPanel();
		PanelImgBlanco.setBounds(49, 145, 50, 50);
		contentPanel.add(PanelImgBlanco);
		PanelImgBlanco.setLayout(new BorderLayout(0, 0));
			
		imgBlanco = new JLabel("");
		PanelImgBlanco.add(imgBlanco, BorderLayout.CENTER);

		btBlanco = new JButton("Cargar imagen");
		btBlanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logicaGeneral.VariableImgOneXOne(Principal.frame,"Blanco",btBlanco,imgBlanco);
			}
		});
		
		btBlanco.setBounds(10, 206, 132, 23);
		contentPanel.add(btBlanco);

		JPanel PanelImgGris = new JPanel();
		PanelImgGris.setBounds(191, 145, 50, 50);
		contentPanel.add(PanelImgGris);
		PanelImgGris.setLayout(new BorderLayout(0, 0));
		
		imgGris = new JLabel("");
		PanelImgGris.add(imgGris, BorderLayout.CENTER);

		btGris = new JButton("Cargar imagen");
		btGris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logicaGeneral.VariableImgOneXOne(Principal.frame,"Gris",btGris,imgGris);
			}
		});
		
		btGris.setBounds(152, 206, 132, 23);
		contentPanel.add(btGris);

		JPanel PanelImgMorado = new JPanel();
		PanelImgMorado.setBounds(333, 145, 50, 50);
		contentPanel.add(PanelImgMorado);
		PanelImgMorado.setLayout(new BorderLayout(0, 0));
			
		imgMorado = new JLabel("");
		PanelImgMorado.add(imgMorado, BorderLayout.CENTER);

		btMorado = new JButton("Cargar imagen");
		btMorado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logicaGeneral.VariableImgOneXOne(Principal.frame,"Morado",btMorado,imgMorado);
			}
		});
		
		btMorado.setBounds(294, 206, 132, 23);
		contentPanel.add(btMorado);
		
		JPanel PanelImgNegro = new JPanel();
		PanelImgNegro.setBounds(481, 145, 50, 50);
		contentPanel.add(PanelImgNegro);
		PanelImgNegro.setLayout(new BorderLayout(0, 0));
		
		imgNegro = new JLabel("");
		PanelImgNegro.add(imgNegro, BorderLayout.CENTER);

		btNegro = new JButton("Cargar imagen");
		btNegro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logicaGeneral.VariableImgOneXOne(Principal.frame,"Negro",btNegro,imgNegro);
			}
		});
		
		btNegro.setBounds(442, 206, 132, 23);
		contentPanel.add(btNegro);

		JLabel lblProductoAmarrillo = new JLabel("Producto Amarillo");
		lblProductoAmarrillo.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductoAmarrillo.setBounds(10, 11, 132, 14);
		contentPanel.add(lblProductoAmarrillo);
		
		JLabel lblProductoAzul = new JLabel("Producto Azul");
		lblProductoAzul.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductoAzul.setBounds(152, 11, 132, 14);
		contentPanel.add(lblProductoAzul);
		
		JLabel lblProductoRojo = new JLabel("Producto Rojo");
		lblProductoRojo.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductoRojo.setBounds(294, 11, 132, 14);
		contentPanel.add(lblProductoRojo);
		
		JLabel lblProductoVerde = new JLabel("Producto Verde");
		lblProductoVerde.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductoVerde.setBounds(442, 11, 132, 14);
		contentPanel.add(lblProductoVerde);
		
		JLabel lblProductoBlanco = new JLabel("Producto Blanco");
		lblProductoBlanco.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductoBlanco.setBounds(10, 125, 132, 14);
		contentPanel.add(lblProductoBlanco);
		
		JLabel lblProductoGris = new JLabel("Producto Gris");
		lblProductoGris.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductoGris.setBounds(152, 125, 132, 14);
		contentPanel.add(lblProductoGris);
		
		JLabel lblProductoMorado = new JLabel("Producto Morado");
		lblProductoMorado.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductoMorado.setBounds(294, 125, 132, 14);
		contentPanel.add(lblProductoMorado);
		
		JLabel lblProductoNegro = new JLabel("Producto Negro");
		lblProductoNegro.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductoNegro.setBounds(442, 125, 132, 14);
		contentPanel.add(lblProductoNegro);
		
		
		lbRutaSAmarillo = new JLabel("");
		lbRutaSAmarillo.setEnabled(false);
		lbRutaSAmarillo.setVisible(false);
		lbRutaSAmarillo.setBounds(109, 27, 46, 14);
		contentPanel.add(lbRutaSAmarillo);
		
		lbRutaLAmarillo = new JLabel("");
		lbRutaLAmarillo.setEnabled(false);
		lbRutaLAmarillo.setVisible(false);
		lbRutaLAmarillo.setBounds(109, 52, 46, 14);
		contentPanel.add(lbRutaLAmarillo);
		
		lbRutaLAzul = new JLabel("");
		lbRutaLAzul.setEnabled(false);
		lbRutaLAzul.setVisible(false);
		lbRutaLAzul.setBounds(251, 52, 46, 14);
		contentPanel.add(lbRutaLAzul);
		
		lbRutaSAzul = new JLabel("");
		lbRutaSAzul.setEnabled(false);
		lbRutaSAzul.setVisible(false);
		lbRutaSAzul.setBounds(251, 27, 46, 14);
		contentPanel.add(lbRutaSAzul);
		
		lbRutaLRojo = new JLabel("");
		lbRutaLRojo.setEnabled(false);
		lbRutaLRojo.setVisible(false);
		lbRutaLRojo.setBounds(393, 52, 46, 14);
		contentPanel.add(lbRutaLRojo);
		
		lbRutaSRojo = new JLabel("");
		lbRutaSRojo.setEnabled(false);
		lbRutaSRojo.setVisible(false);
		lbRutaSRojo.setBounds(393, 27, 46, 14);
		contentPanel.add(lbRutaSRojo);
		
		lbRutaLVerde = new JLabel("");
		lbRutaLVerde.setEnabled(false);
		lbRutaLVerde.setVisible(false);
		lbRutaLVerde.setBounds(541, 52, 46, 14);
		contentPanel.add(lbRutaLVerde);
		
		lbRutaSVerde = new JLabel("");
		lbRutaSVerde.setEnabled(false);
		lbRutaSVerde.setVisible(false);
		lbRutaSVerde.setBounds(541, 27, 46, 14);
		contentPanel.add(lbRutaSVerde);
		
		lbRutaLBlanco = new JLabel("");
		lbRutaLBlanco.setEnabled(false);
		lbRutaLBlanco.setVisible(false);
		lbRutaLBlanco.setBounds(109, 167, 46, 14);
		contentPanel.add(lbRutaLBlanco);
		
		lbRutaSBlanco = new JLabel("");
		lbRutaSBlanco.setEnabled(false);
		lbRutaSBlanco.setVisible(false);
		lbRutaSBlanco.setBounds(109, 142, 46, 14);
		contentPanel.add(lbRutaSBlanco);
		
		lbRutaLGris = new JLabel("");
		lbRutaLGris.setEnabled(false);
		lbRutaLGris.setVisible(false);
		lbRutaLGris.setBounds(251, 170, 46, 14);
		contentPanel.add(lbRutaLGris);
		
		lbRutaSGris = new JLabel("");
		lbRutaSGris.setEnabled(false);
		lbRutaSGris.setVisible(false);
		lbRutaSGris.setBounds(251, 145, 46, 14);
		contentPanel.add(lbRutaSGris);
		
		lbRutaLMorado = new JLabel("");
		lbRutaLMorado.setEnabled(false);
		lbRutaLMorado.setVisible(false);
		lbRutaLMorado.setBounds(393, 170, 46, 14);
		contentPanel.add(lbRutaLMorado);
		
		lbRutaSMorado = new JLabel("");
		lbRutaSMorado.setEnabled(false);
		lbRutaSMorado.setVisible(false);
		lbRutaSMorado.setBounds(393, 145, 46, 14);
		contentPanel.add(lbRutaSMorado);
		
		lbRutaLNegro = new JLabel("");
		lbRutaLNegro.setEnabled(false);
		lbRutaLNegro.setVisible(false);
		lbRutaLNegro.setBounds(541, 170, 46, 14);
		contentPanel.add(lbRutaLNegro);
		
		lbRutaSNegro = new JLabel("");
		lbRutaSNegro.setEnabled(false);
		lbRutaSNegro.setVisible(false);
		lbRutaSNegro.setBounds(541, 145, 46, 14);
		contentPanel.add(lbRutaSNegro);
		
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			PrincipalJFrame.iv.setVisible(false);
					}
			});
			
			okButton.setActionCommand("OK");
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
	}
}
