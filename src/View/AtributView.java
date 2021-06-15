package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logic.XmlTransformer;
import Logic.logicaAtributos;
import Logic.logicaGeneral;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ListSelectionModel;


public class AtributView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public static JTextField tfTallas;
	public static JTextField tfColores;
	public static JTextField tfCateg;
	@SuppressWarnings("rawtypes")
	public static JList jlTalla;
	@SuppressWarnings("rawtypes")
	public static JList jlColor;
	@SuppressWarnings("rawtypes")
	public static JList jlCateg;
	
	public static JTextField tfIndexTalla;
	public static JTextField tfIndexColor;
	public static JTextField tfIndexCateg;
	
	public static JScrollPane spTalla;
	public static JScrollPane spColor;
	public static JScrollPane spCateg;
	


	@SuppressWarnings("rawtypes")
	public AtributView() {
		setTitle("Atributos");
				
		setBounds(100, 100, 500, 571);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		spTalla = new JScrollPane();
		spTalla.setBounds(357, 50, 100, 120);
		contentPanel.add(spTalla);
		
		jlTalla = new JList();
		spTalla.setViewportView(jlTalla);

		spColor = new JScrollPane();
		spColor.setEnabled(false);
		spColor.setBounds(357, 200, 100, 120);
		contentPanel.add(spColor);
		
		jlColor = new JList();
		jlColor.setEnabled(false);
		spColor.setViewportView(jlColor);
		
		spCateg = new JScrollPane();
		spCateg.setBounds(357, 350, 100, 120);
		contentPanel.add(spCateg);
		
		jlCateg = new JList();
		jlCateg.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		spCateg.setViewportView(jlCateg);
		
		JLabel lblTalla = new JLabel("Tallas:");
		lblTalla.setBounds(307, 30, 46, 14);
		contentPanel.add(lblTalla);
		
		JLabel lblColores = new JLabel("Colores:");
		lblColores.setBounds(307, 180, 89, 14);
		contentPanel.add(lblColores);
		
		JLabel lblCateg = new JLabel("Categ:");
		lblCateg.setBounds(307, 330, 46, 14);
		contentPanel.add(lblCateg);
		
		tfTallas = new JTextField();
		tfTallas.setBounds(32, 116, 236, 20);
		contentPanel.add(tfTallas);
		tfTallas.setColumns(10);
		
		JButton btnAnadirTallas = new JButton("Anadir");
		btnAnadirTallas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PrincipalJFrame.tallas = logicaAtributos.addElement(tfTallas,PrincipalJFrame.tallas);
				logicaGeneral.actAtribs();
				logicaGeneral.Actualizador();
				tfTallas.setText("");
				tfIndexTalla.setText("");
				logicaAtributos.GuardadorAtributs();
				XmlTransformer.guardadorEnXML(PrincipalJFrame.lListaProduct);
			}
		});
		
		btnAnadirTallas.setBounds(32, 147, 89, 23);
		contentPanel.add(btnAnadirTallas);
		
		JButton btnBorrarTallas = new JButton("Borrar");
		btnBorrarTallas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PrincipalJFrame.tallas = logicaAtributos.borrarElement(tfTallas,PrincipalJFrame.tallas);
				logicaGeneral.actAtribs();
				logicaGeneral.Actualizador();
				tfTallas.setText("");
				tfIndexTalla.setText("");
				logicaAtributos.GuardadorAtributs();
				XmlTransformer.guardadorEnXML(PrincipalJFrame.lListaProduct);
			}
		});
		
		btnBorrarTallas.setBounds(179, 147, 89, 23);
		contentPanel.add(btnBorrarTallas);
		
		tfColores = new JTextField();
		tfColores.setEditable(false);
		tfColores.setColumns(10);
		tfColores.setBounds(32, 266, 236, 20);
		contentPanel.add(tfColores);
		
		JButton btnAnadirColor = new JButton("Anadir");
		btnAnadirColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrincipalJFrame.colores = logicaAtributos.addElement(tfColores,PrincipalJFrame.colores);
				logicaGeneral.actAtribs();
				logicaGeneral.Actualizador();
				tfColores.setText("");
				tfIndexColor.setText("");
				logicaAtributos.GuardadorAtributs();
				XmlTransformer.guardadorEnXML(PrincipalJFrame.lListaProduct);
			}
		});
		
		btnAnadirColor.setEnabled(false);
		btnAnadirColor.setBounds(32, 297, 89, 23);
		contentPanel.add(btnAnadirColor);
		
		JButton btnBorrarColor = new JButton("Borrar");
		btnBorrarColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrincipalJFrame.colores = logicaAtributos.borrarElement(tfCateg,PrincipalJFrame.categorias);
				logicaGeneral.actAtribs();
				logicaGeneral.Actualizador();
				tfColores.setText("");
				tfIndexColor.setText("");
				logicaAtributos.GuardadorAtributs();
				XmlTransformer.guardadorEnXML(PrincipalJFrame.lListaProduct);
			}
		});
		
		btnBorrarColor.setEnabled(false);
		btnBorrarColor.setBounds(179, 297, 89, 23);
		contentPanel.add(btnBorrarColor);
		
		tfCateg = new JTextField();
		tfCateg.setColumns(10);
		tfCateg.setBounds(32, 416, 236, 20);
		contentPanel.add(tfCateg);
		
		JButton btnAnadirCateg = new JButton("Anadir");
		btnAnadirCateg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrincipalJFrame.categorias = logicaAtributos.addElement(tfCateg,PrincipalJFrame.categorias);
				logicaGeneral.actAtribs();
				logicaGeneral.Actualizador();
				tfCateg.setText("");
				tfIndexCateg.setText("");
				logicaAtributos.GuardadorAtributs();
				XmlTransformer.guardadorEnXML(PrincipalJFrame.lListaProduct);
			}
		});
		btnAnadirCateg.setBounds(32, 447, 89, 23);
		contentPanel.add(btnAnadirCateg);
		
		JButton btnBorrarCateg = new JButton("Borrar");
		btnBorrarCateg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrincipalJFrame.categorias = logicaAtributos.borrarElement(tfCateg,PrincipalJFrame.categorias);
				logicaGeneral.actAtribs();
				logicaGeneral.Actualizador();
				tfCateg.setText("");
				tfIndexCateg.setText("");
				logicaAtributos.GuardadorAtributs();
				XmlTransformer.guardadorEnXML(PrincipalJFrame.lListaProduct);
			}
		});
		btnBorrarCateg.setBounds(179, 447, 89, 23);
		contentPanel.add(btnBorrarCateg);
		
		tfIndexTalla = new JTextField();
		tfIndexTalla.setEditable(false);
		tfIndexTalla.setBounds(290, 116, 35, 20);
		contentPanel.add(tfIndexTalla);
		tfIndexTalla.setColumns(10);
		
		tfIndexColor = new JTextField();
		tfIndexColor.setEditable(false);
		tfIndexColor.setColumns(10);
		tfIndexColor.setBounds(290, 266, 35, 20);
		contentPanel.add(tfIndexColor);
		
		tfIndexCateg = new JTextField();
		tfIndexCateg.setEditable(false);
		tfIndexCateg.setColumns(10);
		tfIndexCateg.setBounds(290, 416, 35, 20);
		contentPanel.add(tfIndexCateg);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrincipalJFrame.av.setVisible(false);
						
			}});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
			
		
	}
}
