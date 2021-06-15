package View;

import java.awt.Dimension;
import java.awt.Toolkit;

import Logic.logicaGeneral;

public class Principal {
	
	public static PrincipalJFrame frame;
	
	public static void main(String[] args) {
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		if(!logicaGeneral.bExiste()) {
			logicaGeneral.PreCarga();
		}
		
		frame = new  PrincipalJFrame();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setVisible(true);
	}
}