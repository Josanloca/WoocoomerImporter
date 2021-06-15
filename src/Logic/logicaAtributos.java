package Logic;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import View.PrincipalJFrame;

public class logicaAtributos {

	
	public static void GuardadorAtributs() {
		
		XmlTransformer.XMLtallas = PrincipalJFrame.tallas;
		XmlTransformer.XMLcolores = PrincipalJFrame.colores;
		XmlTransformer.XMLcategorias = PrincipalJFrame.categorias;
		
		XmlTransformer.guardadorXMLAtributos();
	}
	
	public static void nombreBloque(Object object, JTextField tfTexfield, JTextField tfIndex, int i) {		
		tfTexfield.setText((String) object);
		tfIndex.setText(String.valueOf(i));
	}
	
	
	public static String[] borrarElement(JTextField tfTexfield,String[] array ) {
		List <String> listString = new ArrayList<String>();
		String sString = tfTexfield.getText();
		String ResultArray [];
		
		for(byte i=0; i<array.length ; i++) {
			
			if(!sString.contentEquals(array[i])) {
				listString.add(array[i]); 
			}
		}
		ResultArray=new String[listString.size()];
		for(byte i=0; i<listString.size(); i++) {
			ResultArray[i] = listString.get(i);
		}	
		//System.out.println(listString);
		return ResultArray;
	}
	
	public static String[] addElement(JTextField tfTexfield, String[] array) {
		List <String> listString = new ArrayList<String>();
		String sString = tfTexfield.getText();
		String ResultArray [];
		
		for(byte i=0; i<array.length; i++) {
			listString.add(array[i]); 
		}
		
		listString.add(sString);
		
		ResultArray=new String[listString.size()];
		for(byte i=0; i<listString.size(); i++) {
			ResultArray[i] = listString.get(i);
		}	
		//System.out.println(listString);
		return ResultArray;
	}
}
