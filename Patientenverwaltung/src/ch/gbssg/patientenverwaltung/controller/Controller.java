package ch.gbssg.patientenverwaltung.controller;
import ch.gbssg.patientenverwaltung.model.Model;
import ch.gbssg.patientenverwaltung.view.*;

public class Controller {
	private MainView view_m;
	private Model model_m;
	
	public Controller(){
		this.view_m = new MainView();
		this.model_m = new Model();
	}
	
	public void showView(){
        this.view_m.setVisible(true);
    }
}
