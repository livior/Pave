package ch.gbssg.pave.controller;
import ch.gbssg.pave.model.PatientModel;
import ch.gbssg.pave.view.*;

public class Controller {
	private MainView view_m;
	//private PatientModel model_m;
	
	public Controller(){
		this.view_m = new MainView();
		//this.model_m = new PatientModel();
	}
	
	public void showView(){
        this.view_m.setVisible(true);
    }
}
