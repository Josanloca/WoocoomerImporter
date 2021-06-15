package View;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logic.XmlTransformer;
import Logic.logicaGeneral;
import Model.Producto;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import java.awt.Toolkit;

import javax.swing.JCheckBox;
import javax.swing.ListSelectionModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import Logic.Constantes;

public class PrincipalJFrame extends JFrame implements Constantes{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public static JTextField tfPrecio;
	public static JTextField tfNombre;
	public static JTextArea taDescripccion;
	@SuppressWarnings("rawtypes")
	public static JList listColores;
	@SuppressWarnings("rawtypes")
	public static JList listTallas;
	@SuppressWarnings("rawtypes")
	public static JList listCategoria;
	public static JTextField urlImagen;
	public static String tallas [];
	public static String colores [];
	public static String categorias [];
	/*
	public static String tallas []=	{ "XS", "S", "M", "L", "XL", "XXL"};
	public static String colores [] = {"Amarillo", "Azul", "Rojo", "Verde", "Blanco", "Gris", "Morado", "Negro"};
	public static String categorias [] = {"Productos", "Epis", "Hosteleria", "Industria", "Sanidad"};
	*/
	public static JLabel lbImg ;
	public static JCheckBox cboxVariable;
	public static JLabel lbRutaFull;
	public static JMenuItem mntImgVariable;
	public static JButton btBorrar;
	
	public static JScrollPane spTallas;
	public static JScrollPane spColores;
	public static JScrollPane spCategorias;
	
	public static List <Producto> lListaProduct;
	public static byte bNumeroPosicion;
	public static ImgVariable iv;
	public static AtributView av;
	
	@SuppressWarnings({ "rawtypes" })
	public PrincipalJFrame() {
		
		XmlTransformer.theGetAtribut();
		
		tallas = XmlTransformer.XMLtallas;
		colores = XmlTransformer.XMLcolores;
		categorias = XmlTransformer.XMLcategorias;

		//
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ICON));
		av = new AtributView();
		Dimensiones dm = new Dimensiones();
		iv = new ImgVariable();

		bNumeroPosicion=ZERO;
		lListaProduct = XmlTransformer.theMEGAGET();
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int reply = JOptionPane.showConfirmDialog(Principal.frame, TEXTSALIDA, ADVERTENCIA, JOptionPane.YES_NO_OPTION);
				if (reply == ONE) {
					System.out.println(reply);
				}else {
					System.exit(ZERO);
				}
			}
		});
		
		setResizable(false);
		setTitle(TITULO);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 551, 451);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnExtras = new JMenu(EXTRAMENU);
		menuBar.add(mnExtras);
		
		JMenuItem mntmNewMenuItem = new JMenuItem(ENVIOOPCIONAL);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dm.setLocationRelativeTo(Principal.frame);
				dm.setModal(true);
				dm.setVisible(true);
			}
		});
		
		mnExtras.add(mntmNewMenuItem);
		
		mntImgVariable = new JMenuItem(CARGARIMGMENU);
		mntImgVariable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(logicaGeneral.opcionesGuardarConstante()) {
					logicaGeneral.Actualizador();
					iv.setLocationRelativeTo(Principal.frame);
					iv.setModal(true);
					iv.setVisible(true);
				}
			}
		});
		
		mntImgVariable.setEnabled(false);
		mnExtras.add(mntImgVariable);
		
		JMenuItem mntAtributs = new JMenuItem("Atributos");
		mntAtributs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logicaGeneral.Actualizador();
				av.setLocationRelativeTo(Principal.frame);
				av.setModal(true);
				av.setVisible(true);
			}
		});
		
		mnExtras.add(mntAtributs);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lbNombre = new JLabel(NOMBRE);
		lbNombre.setBounds(20, 20, 58, 14);
		panel.add(lbNombre);
		
		JLabel lbDescripcion = new JLabel(DESCRIPCCION);
		lbDescripcion.setBounds(20, 50, 58, 14);
		panel.add(lbDescripcion);
		
		JLabel lbPrecio = new JLabel(PRECIO);
		lbPrecio.setBounds(340, 310, 70, 14);
		panel.add(lbPrecio);
		
		JLabel lbCategoria = new JLabel(CATEGORIA);
		lbCategoria.setBounds(340, 185, 92, 14);
		panel.add(lbCategoria);
		
		JLabel lbTalla = new JLabel(TALLA);
		lbTalla.setBounds(340, 20, 70, 14);
		panel.add(lbTalla);
		
		JLabel lbColor = new JLabel(COLOR);
		lbColor.setBounds(340, 100, 69, 14);
		panel.add(lbColor);
		
		tfPrecio = new JTextField();
		tfPrecio.setBounds(410, 310, 100, 20);
		tfPrecio.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(100, 20, 201, 20);
		tfNombre.setColumns(10);
		
		JScrollPane spDescripcion = new JScrollPane();
		spDescripcion.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spDescripcion.setBounds(100, 50, 201, 59);
		
		taDescripccion = new JTextArea();
		spDescripcion.setViewportView(taDescripccion);
		
		spTallas = new JScrollPane();
		spTallas.setBounds(410, 20, 100, 65);
		
		listTallas = new JList();
		spTallas.setViewportView(listTallas);
		
		spColores = new JScrollPane();
		spColores.setBounds(410, 100, 101, 71);
		
		listColores = new JList();
		spColores.setViewportView(listColores);
		
		spCategorias = new JScrollPane();
		spCategorias.setBounds(410, 185, 100, 65);
		
		listCategoria = new JList();
		listCategoria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		spCategorias.setViewportView(listCategoria);
		
		logicaGeneral.actAtribs();
		
		JScrollPane spNombreImg = new JScrollPane();
		spNombreImg.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		spNombreImg.setVisible(false);
		spNombreImg.setBounds(110, 280, 1, 1);
		panel.add(spNombreImg);
		
		urlImagen = new JTextField();
		urlImagen.setFont(new Font(FONT, Font.PLAIN, 9));
		urlImagen.setEditable(false);
		spNombreImg.setViewportView(urlImagen);
		urlImagen.setColumns(10);
		
		JPanel PanelInferior = new JPanel();
		contentPane.add(PanelInferior, BorderLayout.SOUTH);
		PanelInferior.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		PanelInferior.add(panel_2, BorderLayout.WEST);
		
		JButton btPrincipio = new JButton(FULLIZQ);
		btPrincipio.setFont(new Font(FONT, Font.PLAIN, 9));
		
		btPrincipio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(bNumeroPosicion != ZERO) {
					if(logicaGeneral.opcionesGuardarConstante()) {
						bNumeroPosicion = ZERO;
						logicaGeneral.Actualizador();
					}
				}else {
					JOptionPane.showMessageDialog(Principal.frame,MENSBEGIN);
				}
			}
		});
		
		panel_2.add(btPrincipio);

		JButton btMenos = new JButton(IZQ);
		btMenos.setFont(new Font(FONT, Font.PLAIN, 9));
		btMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(bNumeroPosicion != ZERO) {
					if(logicaGeneral.opcionesGuardarConstante()) {
						bNumeroPosicion--;
						logicaGeneral.Actualizador();
					}
				}else {
					JOptionPane.showMessageDialog(Principal.frame,MENSBEGIN);
				}
			}
		});
		
		panel_2.add(btMenos);
		JButton btMas = new JButton(DEREC);
		btMas.setFont(new Font(FONT, Font.PLAIN, 9));
		
		btMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(bNumeroPosicion != lListaProduct.size()-ONE) {
					if(logicaGeneral.opcionesGuardarConstante()) {
						bNumeroPosicion++;
						logicaGeneral.Actualizador();
					}
				}else {
					JOptionPane.showMessageDialog(Principal.frame,MENSEND);
				}
			}
		});
		
		panel_2.add(btMas);
		
		JButton btFinal = new JButton(FULLDEREC);
		btFinal.setFont(new Font(FONT, Font.PLAIN, 9));
		btFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(bNumeroPosicion !=(byte) ((byte) lListaProduct.size()-ONE)) {
					
					if(logicaGeneral.opcionesGuardarConstante()) {
						bNumeroPosicion = (byte) ((byte) lListaProduct.size()-ONE);
						logicaGeneral.Actualizador();
					}
				}else {
					JOptionPane.showMessageDialog(Principal.frame,MENSEND);
				}
			}
		});
		
		panel_2.add(btFinal);
		
		JPanel panel_3 = new JPanel();
		PanelInferior.add(panel_3, BorderLayout.EAST);
		
		btBorrar = new JButton(BORAR);
		btBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int reply = JOptionPane.showConfirmDialog(Principal.frame, MENSBORAR, ADVERTENCIA, JOptionPane.YES_NO_OPTION);
				
				if (reply == ONE) {

				}else {
					lListaProduct.remove(bNumeroPosicion);
					bNumeroPosicion--;
					if(bNumeroPosicion<ZERO) {
						bNumeroPosicion =ZERO;
					}
					if(lListaProduct.size() == ZERO) {
						JOptionPane.showMessageDialog(Principal.frame,"NO EXISTEN DATOS EN LA BASE DE DATOS");
						lListaProduct.add(new Producto(ZERO ,VOID,VOID,ZERO,VOID,VOID,VOID,VOID,VOID,VOID,(float)ZERO,(float)ZERO,(float)ZERO,(float)ZERO));
					}
					logicaGeneral.Actualizador();
					}
			}
		});
		
		panel_3.add(btBorrar);
		
		JButton btGuardar = new JButton(GUARDAR);
		btGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(logicaGeneral.opcionesGuardarConstante()) {
					logicaGeneral.Actualizador();
					JOptionPane.showMessageDialog(Principal.frame,MENSGUARDAR);
				}
			}
		});
		
		panel_3.add(btGuardar);
		
		JButton btNuevo = new JButton(NUEVO);
		btNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(logicaGeneral.opcionesGuardarConstante()) {
					logicaGeneral.setVacio();
					bNumeroPosicion = (byte) lListaProduct.size();
				}
			}
		});
		
		panel_3.add(btNuevo);
		
		JButton btCargarImg = new JButton(TEXTCARGARIMG);
		btCargarImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logicaGeneral.imagenPredeterminada(Principal.frame);
			}
		});
		
		btCargarImg.setBounds(110, 310, 132, 23);
		panel.add(btCargarImg);
		
		JPanel PanelImg = new JPanel();
		PanelImg.setBounds(100, 120, 150, 150);
		PanelImg.setLayout(new BorderLayout(0, 0));
		
		lbImg = new JLabel(VOID);
		PanelImg.add(lbImg, BorderLayout.CENTER);
		
		cboxVariable = new JCheckBox(VARIA);
		cboxVariable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboxVariable.isSelected()) {
					mntImgVariable.setEnabled(true);
				}else {
					mntImgVariable.setEnabled(false);
				}
			}
		});
		
		cboxVariable.setBounds(410, 270, 97, 23);
		lbRutaFull = new JLabel(VOID);
		lbRutaFull.setEnabled(false);
		lbRutaFull.setVisible(false);
		lbRutaFull.setBounds(153, 332, 1, 1);
		
		logicaGeneral.Actualizador();

		panel.add(tfPrecio);
		panel.add(tfNombre);
		panel.add(spDescripcion);
		panel.add(spTallas);
		panel.add(spColores);
		panel.add(spCategorias);
		panel.add(cboxVariable);
		panel.add(PanelImg);
		panel.add(lbRutaFull);
	}
}
