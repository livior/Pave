package ch.gbssg.pave;
import ch.gbssg.pave.controller.Controller;



public class Pave {
	public Pave(){
		
	}
	public static void main(String[] args) {
		Pave pave;
		Controller controller = new Controller();
		
		controller.showView();
		
		pave=new Pave();
		
	}

}
