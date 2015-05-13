package ch.gbssg.patientenverwaltung;
import ch.gbssg.patientenverwaltung.controller.Controller;



public class Patientenverwaltung {
	public Patientenverwaltung(){
		
	}
	public static void main(String[] args) {
		Patientenverwaltung pave;
		Controller controller = new Controller();
		
		controller.showView();
		
		pave=new Patientenverwaltung();
		
	}

}
