package ch.gbssg.pave;
import java.sql.SQLException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ch.gbssg.pave.controller.Controller;



public class Pave {
	public Pave(){
		
	}
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, SQLException{
		Pave pave;
		Controller controller = new Controller();
		controller.showMainView();
		
		pave=new Pave();
		
	}

}
