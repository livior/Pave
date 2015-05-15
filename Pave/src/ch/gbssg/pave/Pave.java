package ch.gbssg.pave;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ch.gbssg.pave.controller.Controller;



public class Pave {
	public Pave(){
		
	}
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		Pave pave;
		Controller controller = new Controller();
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());		
		controller.showView();
		
		pave=new Pave();
		
	}

}
