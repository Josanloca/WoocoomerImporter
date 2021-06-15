package Logic;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Model.Producto;
import View.AtributView;
import View.Dimensiones;
import View.ImgVariable;
import View.Principal;
import View.PrincipalJFrame;


public class logicaGeneral implements Constantes{
	
	public static String sURLShort="";
	public static String sURLLong="";
	
	@SuppressWarnings("unchecked")
	public static void MEGAGET() {
		if(PrincipalJFrame.bNumeroPosicion == PrincipalJFrame.lListaProduct.size()) {
			
			Producto PD = new Producto(PrincipalJFrame.bNumeroPosicion,
					PrincipalJFrame.tfNombre.getText(),
					PrincipalJFrame.taDescripccion.getText(),
					Double.valueOf(PrincipalJFrame.tfPrecio.getText()),
					PrincipalJFrame.listCategoria.getSelectedValuesList().get(ZERO).toString(),
					PrincipalJFrame.urlImagen.getText(),
					stringGenerator(PrincipalJFrame.listTallas.getSelectedValuesList()),
					stringGenerator(PrincipalJFrame.listColores.getSelectedValuesList()),
					stringBoleano(PrincipalJFrame.cboxVariable.isSelected()),
					PrincipalJFrame.lbRutaFull.getText(),
					Float.valueOf(Dimensiones.tfPeso.getText()),
					Float.valueOf(Dimensiones.tfLargo.getText()),
					Float.valueOf(Dimensiones.tfAncho.getText()),
					Float.valueOf(Dimensiones.tfAlto.getText()));
	
			if(PrincipalJFrame.cboxVariable.isSelected()) {
				PD.setProductosVariables(separadorCategorias(PrincipalJFrame.listColores.getSelectedValuesList(),PrincipalJFrame.listTallas.getSelectedValuesList(),(byte)0));
			}
			PrincipalJFrame.lListaProduct.add(PD);	
		}else {  
			
			Producto PD = new Producto(PrincipalJFrame.bNumeroPosicion,
					PrincipalJFrame.tfNombre.getText(),
					PrincipalJFrame.taDescripccion.getText(),
					Double.valueOf(PrincipalJFrame.tfPrecio.getText()),
					PrincipalJFrame.listCategoria.getSelectedValuesList().get(ZERO).toString(),
					PrincipalJFrame.urlImagen.getText(),
					stringGenerator(PrincipalJFrame.listTallas.getSelectedValuesList()),
					stringGenerator(PrincipalJFrame.listColores.getSelectedValuesList()),
					stringBoleano(PrincipalJFrame.cboxVariable.isSelected()),
					PrincipalJFrame.lbRutaFull.getText(),
					Float.valueOf(Dimensiones.tfPeso.getText()),
					Float.valueOf(Dimensiones.tfLargo.getText()),
					Float.valueOf(Dimensiones.tfAncho.getText()),
					Float.valueOf(Dimensiones.tfAlto.getText()));
			
			if(PrincipalJFrame.cboxVariable.isSelected()) {
				PD.setProductosVariables(separadorCategorias(PrincipalJFrame.listColores.getSelectedValuesList(),PrincipalJFrame.listTallas.getSelectedValuesList(),(byte)1));
			}
			PrincipalJFrame.lListaProduct.set(PrincipalJFrame.bNumeroPosicion,PD);	
		}
		XmlTransformer.guardadorEnXML(PrincipalJFrame.lListaProduct);
	}
	
	//STRING GENERATORS
	
	private static String stringGenerator(List<Integer> list){
		String sResultado= "";
		for(byte x=ZERO; x < list.size(); x++) {
			if(x+1<list.size()) {
				sResultado += list.get(x)+" | ";
			}else {
				sResultado += list.get(x);
			}
		}
		return sResultado;
	}
	
	private static String stringBoleano(boolean bool) {
		String sResultado ="simple";
		if(bool) {
			sResultado ="variable";
		}
		return sResultado;
	}
	
	//EL ERROR ESTA AQUI POR NARICES
	
	private static List <Producto> separadorCategorias(List<Integer> listColores, List<Integer> listallas, byte bNum){
		List <Producto> listaVariables = new ArrayList<Producto>();
		String color,talla;
		for(byte x=0; x < listColores.size(); x++) {
			color = listColores.get(x)+"";
			
			for(byte y = ZERO; y < listallas.size(); y++) {
				talla = listallas.get(y)+"";
				
				PilladorImgURL(color);
				
				listaVariables.add(new Producto(PrincipalJFrame.bNumeroPosicion,
						PrincipalJFrame.tfNombre.getText(),
						PrincipalJFrame.taDescripccion.getText(),
						Double.valueOf(PrincipalJFrame.tfPrecio.getText()),
						PrincipalJFrame.listCategoria.getSelectedValuesList().get(ZERO).toString(),
						sURLShort,
						/*Foto*/
						talla,
						color,
						stringBoleano(PrincipalJFrame.cboxVariable.isSelected()),
						sURLLong,
						Float.valueOf(Dimensiones.tfPeso.getText()),
						Float.valueOf(Dimensiones.tfLargo.getText()),
						Float.valueOf(Dimensiones.tfAncho.getText()),
						Float.valueOf(Dimensiones.tfAlto.getText())));
			}
		}
		return listaVariables;
	}
	
	public static void PilladorImgURL(String color) {
		String sLong ="",sShort="";
		
		if(color.contentEquals("Amarillo")) {
			sLong =ImgVariable.lbRutaLAmarillo.getText();
			sShort=ImgVariable.lbRutaSAmarillo.getText();
		}else if(color.contentEquals("Azul")){
			sLong =ImgVariable.lbRutaLAzul.getText();
			sShort=ImgVariable.lbRutaSAzul.getText();
		}else if(color.contentEquals("Rojo")){
			sLong =ImgVariable.lbRutaLRojo.getText();
			sShort=ImgVariable.lbRutaSRojo.getText();
		}else if(color.contentEquals("Verde")){
			sLong =ImgVariable.lbRutaLVerde.getText();
			sShort=ImgVariable.lbRutaSVerde.getText();
		}else if(color.contentEquals("Blanco")){
			sLong =ImgVariable.lbRutaLBlanco.getText();
			sShort=ImgVariable.lbRutaSBlanco.getText();
		}else if(color.contentEquals("Gris")){
			sLong =ImgVariable.lbRutaLGris.getText();
			sShort=ImgVariable.lbRutaSGris.getText();
		}else if(color.contentEquals("Morado")){
			sLong =ImgVariable.lbRutaLMorado.getText();
			sShort=ImgVariable.lbRutaSMorado.getText();
		}else if(color.contentEquals("Negro")){
			sLong =ImgVariable.lbRutaLNegro.getText();
			sShort=ImgVariable.lbRutaSNegro.getText();
		}		
		sURLShort = sShort;
		sURLLong = sLong;
	}

	//EL NUCLEO PRINCIPAL Y EL MAYOR ERROR

	public static void Actualizador() {

		String sColor="";
		String sTalla="";		
		String sCategoria="";
				
		sColor = PrincipalJFrame.lListaProduct.get(PrincipalJFrame.bNumeroPosicion).getColor();
		sTalla = PrincipalJFrame.lListaProduct.get(PrincipalJFrame.bNumeroPosicion).getTalla();
		sCategoria = PrincipalJFrame.lListaProduct.get(PrincipalJFrame.bNumeroPosicion).getCategoria();
		
		PrincipalJFrame.tfNombre.setText(String.valueOf(PrincipalJFrame.lListaProduct.get(PrincipalJFrame.bNumeroPosicion).getNombre()));
		PrincipalJFrame.tfPrecio.setText(String.valueOf(PrincipalJFrame.lListaProduct.get(PrincipalJFrame.bNumeroPosicion).getPrecio()));
		PrincipalJFrame.taDescripccion.setText(String.valueOf(PrincipalJFrame.lListaProduct.get(PrincipalJFrame.bNumeroPosicion).getDescripcion()));
		
		PrincipalJFrame.listColores.setSelectedIndices(refactorizador(Realineador(PrincipalJFrame.colores,sColor)));
		PrincipalJFrame.listTallas.setSelectedIndices(refactorizador(Realineador(PrincipalJFrame.tallas,sTalla)));
		PrincipalJFrame.listCategoria.setSelectedIndices(refactorizador(Realineador(PrincipalJFrame.categorias,sCategoria)));
		
		PrincipalJFrame.urlImagen.setText(String.valueOf(PrincipalJFrame.lListaProduct.get(PrincipalJFrame.bNumeroPosicion).getImgurl()));
		PrincipalJFrame.lbRutaFull.setText(String.valueOf(PrincipalJFrame.lListaProduct.get(PrincipalJFrame.bNumeroPosicion).getImgRuta()));
		cargarImagen(String.valueOf(PrincipalJFrame.lListaProduct.get(PrincipalJFrame.bNumeroPosicion).getImgRuta()));
		Dimensiones.tfPeso.setText(String.valueOf(PrincipalJFrame.lListaProduct.get(PrincipalJFrame.bNumeroPosicion).getPeso()));
		Dimensiones.tfLargo.setText(String.valueOf(PrincipalJFrame.lListaProduct.get(PrincipalJFrame.bNumeroPosicion).getLongitud()));
		Dimensiones.tfAncho.setText(String.valueOf(PrincipalJFrame.lListaProduct.get(PrincipalJFrame.bNumeroPosicion).getAnchura()));
		Dimensiones.tfAlto.setText(String.valueOf(PrincipalJFrame.lListaProduct.get(PrincipalJFrame.bNumeroPosicion).getAltura()));
		
		if(PrincipalJFrame.lListaProduct.get(PrincipalJFrame.bNumeroPosicion).getVariable().equals("variable")) {
			PrincipalJFrame.cboxVariable.setSelected(true);
			PrincipalJFrame.mntImgVariable.setEnabled(true);
			cargarImagenVacioVariable();
			for(int i = ZERO; i < PrincipalJFrame.lListaProduct.get(PrincipalJFrame.bNumeroPosicion).getProductosVariables().size(); i++) {
				cargarImagenVariable(PrincipalJFrame.lListaProduct.get(PrincipalJFrame.bNumeroPosicion).getProductosVariables().get(i));
				}
		}else {
			PrincipalJFrame.cboxVariable.setSelected(false);
			PrincipalJFrame.mntImgVariable.setEnabled(false);
		}
	}
	
	//SEUDO ACTUALIZADOR LISTA ATRIBUTS
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void actAtribs() {
		PrincipalJFrame.listTallas = new JList(PrincipalJFrame.tallas);
		PrincipalJFrame.spTallas.setViewportView(PrincipalJFrame.listTallas);
		PrincipalJFrame.listColores = new JList(PrincipalJFrame.colores);
		PrincipalJFrame.spColores.setViewportView(PrincipalJFrame.listColores);
		PrincipalJFrame.listCategoria = new JList(PrincipalJFrame.categorias);
		PrincipalJFrame.spCategorias.setViewportView(PrincipalJFrame.listCategoria);
		PrincipalJFrame.listCategoria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		AtributView.jlTalla = new JList(PrincipalJFrame.tallas);
		AtributView.spTalla.setViewportView(AtributView.jlTalla);
		AtributView.jlColor = new JList(PrincipalJFrame.colores);
		AtributView.spColor.setViewportView(AtributView.jlColor);
		AtributView.jlCateg = new JList(PrincipalJFrame.categorias);
		AtributView.spCateg.setViewportView(AtributView.jlCateg);
		
		AtributView.jlTalla.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				logicaAtributos.nombreBloque(AtributView.jlTalla.getSelectedValue(),AtributView.tfTallas,AtributView.tfIndexTalla,AtributView.jlTalla.getSelectedIndex());
			}
		});
		
		AtributView.jlCateg.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				logicaAtributos.nombreBloque(AtributView.jlCateg.getSelectedValue(),AtributView.tfCateg,AtributView.tfIndexCateg,AtributView.jlCateg.getSelectedIndex());
			}
		});
	}
		
	public static List<Integer> Realineador(String sArray [],String sText) {
		List<Integer> list = new ArrayList<Integer>();
        for (int i = ZERO; i < sArray.length; i++) {
        	if(sText.contains(sArray[i])) {
        		list.add(i);
        	}
        }
		return list;
	}
	
	public static int[] refactorizador(List<Integer> list) {
		int[] array = new int[list.size()];
        for (int i = ZERO; i < list.size(); i++) {
        	array[i] = list.get(i);
        }        
        return array;
	}
	
	public static void setVacio() {
		PrincipalJFrame.tfNombre.setText(VOID);
		PrincipalJFrame.tfPrecio.setText("0");
		PrincipalJFrame.taDescripccion.setText(VOID);
		PrincipalJFrame.listColores.clearSelection();
		PrincipalJFrame.listTallas.clearSelection();
		PrincipalJFrame.listCategoria.clearSelection();
		PrincipalJFrame.urlImagen.setText(VOID);
		PrincipalJFrame.lbRutaFull.setText(VOID);
		cargarImagen(VOID);
		cargarImagenVacioVariable();
		Dimensiones.tfPeso.setText("0");
		Dimensiones.tfLargo.setText("0");
		Dimensiones.tfAncho.setText("0");
		Dimensiones.tfAlto.setText("0");
		PrincipalJFrame.btBorrar.setEnabled(false);
	} 
	
	public static boolean opcionesGuardarConstante() {
		boolean bResult=false;
		
		if(PrincipalJFrame.tfNombre.getText().equals(VOID) ||
				PrincipalJFrame.tfPrecio.getText().equals(VOID)) {
			JOptionPane.showMessageDialog(Principal.frame, "Error, Tiene que escribir un nombre y un precio!");
		}else if(PrincipalJFrame.cboxVariable.isSelected() && (PrincipalJFrame.listColores.isSelectionEmpty() || PrincipalJFrame.listTallas.isSelectionEmpty() ||
				PrincipalJFrame.listCategoria.isSelectionEmpty())){
			JOptionPane.showMessageDialog(Principal.frame, "Error, Tiene seleccionado los productos variables y falta por seleccionar la talla o el color o la categoria");
		}else {
			logicaGeneral.MEGAGET();
			bResult=true;
		}
		return bResult;
	}

	public static void imagenPredeterminada(Frame frame) {
		FileDialog fchAbrir = new FileDialog(frame, "Abrir documento...", FileDialog.LOAD);
		fchAbrir.setVisible(true);
		String directorio = fchAbrir.getDirectory();
		String fichero = fchAbrir.getFile();
		
		Image dimg = cargadoImagen(directorio+fichero).getScaledInstance(PrincipalJFrame.lbImg.getWidth(), PrincipalJFrame.lbImg.getHeight(),Image.SCALE_SMOOTH);
		
		PrincipalJFrame.lbImg.setIcon(new ImageIcon(dimg));
		PrincipalJFrame.urlImagen.setText(fichero);
		PrincipalJFrame.lbRutaFull.setText(directorio+fichero);
	}
	
	public static BufferedImage cargadoImagen(String sText) {
		BufferedImage img = null;
		try {
			if(sText==null) {
				sText="x";
			}
			File f = new File(sText);
			if(!(f==null) && f.exists() && !sText.equals("x")){
				img = ImageIO.read(new File(sText));
			}else {
				img = ImageIO.read(Principal.class.getClassLoader().getResource("404.jpg"));
			}
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return img;
	}
	
	public static void cargarImagen(String sText) {
		Image dimg = cargadoImagen(sText).getScaledInstance(150, 150,Image.SCALE_SMOOTH);
		PrincipalJFrame.lbImg.setIcon(new ImageIcon(dimg));
	}
	
	public static void cargarImagenVacioVariable() {
		Image dimg = cargadoImagen("x").getScaledInstance(50, 50,Image.SCALE_SMOOTH);

		ImgVariable.btAmarillo.setEnabled(false);
		ImgVariable.imgAmarillo.setIcon(new ImageIcon(dimg));
		
		ImgVariable.btAzul.setEnabled(false);
		ImgVariable.imgAzul.setIcon(new ImageIcon(dimg));
		
		ImgVariable.btRojo.setEnabled(false);
		ImgVariable.imgRojo.setIcon(new ImageIcon(dimg));
		
		ImgVariable.btVerde.setEnabled(false);
		ImgVariable.imgVerde.setIcon(new ImageIcon(dimg));
		
		ImgVariable.btBlanco.setEnabled(false);
		ImgVariable.imgBlanco.setIcon(new ImageIcon(dimg));
		
		ImgVariable.btGris.setEnabled(false);
		ImgVariable.imgGris.setIcon(new ImageIcon(dimg));
		
		ImgVariable.btMorado.setEnabled(false);
		ImgVariable.imgMorado.setIcon(new ImageIcon(dimg));
		
		ImgVariable.btNegro.setEnabled(false);
		ImgVariable.imgNegro.setIcon(new ImageIcon(dimg));
	}
	
	public static void cargarImagenVariable(Producto producto) {
		Image dimg = cargadoImagen(producto.getImgurl()).getScaledInstance(50, 50,Image.SCALE_SMOOTH);
		
		if(producto.getColor().contains("Amarillo")) {
			ImgVariable.btAmarillo.setEnabled(true);
			ImgVariable.imgAmarillo.setIcon(new ImageIcon(dimg));
		}else if(producto.getColor().contains("Azul")){
			ImgVariable.btAzul.setEnabled(true);
			ImgVariable.imgAzul.setIcon(new ImageIcon(dimg));
		}else if(producto.getColor().contains("Rojo")){
			ImgVariable.btRojo.setEnabled(true);
			ImgVariable.imgRojo.setIcon(new ImageIcon(dimg));
		}else if(producto.getColor().contains("Verde")){
			ImgVariable.btVerde.setEnabled(true);
			ImgVariable.imgVerde.setIcon(new ImageIcon(dimg));
		}else if(producto.getColor().contains("Blanco")){
			ImgVariable.btBlanco.setEnabled(true);
			ImgVariable.imgBlanco.setIcon(new ImageIcon(dimg));
		}else if(producto.getColor().contains("Gris")){
			ImgVariable.btGris.setEnabled(true);
			ImgVariable.imgGris.setIcon(new ImageIcon(dimg));
		}else if(producto.getColor().contains("Morado")){
			ImgVariable.btMorado.setEnabled(true);
			ImgVariable.imgMorado.setIcon(new ImageIcon(dimg));
		}else if(producto.getColor().contains("Negro")){
			ImgVariable.btNegro.setEnabled(true);
			ImgVariable.imgNegro.setIcon(new ImageIcon(dimg));
		}
		setImgURL(producto.getColor(),producto.getImgRuta(),producto.getImgurl());
	}
		
		public static void VariableImgOneXOne(Frame frame,String sTexto,JButton boton, JLabel label) {
			FileDialog fchAbrir = new FileDialog(frame, "Abrir documento...", FileDialog.LOAD);
			fchAbrir.setVisible(true);
			String directorio = fchAbrir.getDirectory();
			String fichero = fchAbrir.getFile();
			Image dimg = cargadoImagen(directorio+fichero).getScaledInstance(50, 50,Image.SCALE_SMOOTH);
				
			boton.setEnabled(true);
			label.setIcon(new ImageIcon(dimg));
			
			if(!(directorio == null) && !(fichero == null)) {
				guardadorImgVariable(sTexto, directorio, fichero);
				logicaGeneral.opcionesGuardarConstante();
				logicaGeneral.Actualizador();
			}
	}
		
		private static void guardadorImgVariable(String sTexto, String sDirec, String sFich) {
	        for (int i =0; i < PrincipalJFrame.lListaProduct.get(PrincipalJFrame.bNumeroPosicion).getProductosVariables().size(); i++) {
	        	if(PrincipalJFrame.lListaProduct.get(PrincipalJFrame.bNumeroPosicion).getProductosVariables().get(i).getColor().contains(sTexto)) {
	        		PrincipalJFrame.lListaProduct.get(PrincipalJFrame.bNumeroPosicion).getProductosVariables().get(i).setImgurl(sFich);
	        		PrincipalJFrame.lListaProduct.get(PrincipalJFrame.bNumeroPosicion).getProductosVariables().get(i).setImgRuta(sDirec+sFich);
	        		setImgURL(sTexto,sFich,(sDirec+sFich));
	        	}
	        }
		}
		
		public static void setImgURL(String color,String rutaL,String rutS) {
			if(color.contentEquals("Amarillo")) {
				ImgVariable.lbRutaLAmarillo.setText(rutaL);
				ImgVariable.lbRutaSAmarillo.setText(rutS);
			}else if(color.contentEquals("Azul")){
				ImgVariable.lbRutaLAzul.setText(rutaL);
				ImgVariable.lbRutaSAzul.setText(rutS);
			}else if(color.contentEquals("Rojo")){
				ImgVariable.lbRutaLRojo.setText(rutaL);
				ImgVariable.lbRutaSRojo.setText(rutS);
			}else if(color.contentEquals("Verde")){
				ImgVariable.lbRutaLVerde.setText(rutaL);
				ImgVariable.lbRutaSVerde.setText(rutS);
			}else if(color.contentEquals("Blanco")){
				ImgVariable.lbRutaLBlanco.setText(rutaL);
				ImgVariable.lbRutaSBlanco.setText(rutS);
			}else if(color.contentEquals("Gris")){
				ImgVariable.lbRutaLGris.setText(rutaL);
				ImgVariable.lbRutaSGris.setText(rutS);
			}else if(color.contentEquals("Morado")){
				ImgVariable.lbRutaLMorado.setText(rutaL);
				ImgVariable.lbRutaSMorado.setText(rutS);
			}else if(color.contentEquals("Negro")){
				ImgVariable.lbRutaLNegro.setText(rutaL);
				ImgVariable.lbRutaSNegro.setText(rutS);
			}
			
		}
		
		public static boolean bExiste () {
			File f = new File(XmlTransformer.RUTAGUARDADO);		
			return f.exists();
			
		}
		
		
		
		public static List<Producto> getRadomizer(){
			ArrayList<Producto> lProducto = new ArrayList<Producto>();
			lProducto.add(new Producto( 1,  "Nombre",  "Descripcion",(double)  5.3,  "Productos","url","S,XL,L",  "Amarillo,Verde","Variable","urlLarga",(float)0,(float)0,(float)0,(float)0));
		
			return lProducto;
		}

		public static void PreCarga() {
			String tallas []=	{ "XS", "S", "M", "L", "XL", "XXL"};
			PrincipalJFrame.tallas = tallas;
			String colores [] = {"Amarillo", "Azul", "Rojo", "Verde", "Blanco", "Gris", "Morado", "Negro", "Sin color"};
			PrincipalJFrame.colores = colores;
			String categorias [] = {"Productos", "Epis", "Hosteleria", "Industria", "Sanidad"};
			PrincipalJFrame.categorias = categorias;
			
			logicaAtributos.GuardadorAtributs();
			XmlTransformer.guardadorEnXML(getRadomizer());
		}
}