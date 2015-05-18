package ch.gbssg.pave.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Locale;

import ch.gbssg.pave.model.PatientModel;
import ch.gbssg.pave.view.*;

public class Controller {
	private MainView viewMain_m;
	private NewPatientView viewNewPatient_m;
	//private PatientModel model_m;
	
	public Controller(){
		this.viewMain_m = new MainView();
		this.viewNewPatient_m = new NewPatientView();
		addActionListener();
		//this.model_m = new PatientModel();
	}
	
	public void addActionListener(){
		this.viewMain_m.setBtnNewActionListener(new BtnNewListener());
		this.viewNewPatient_m.setBtnBrowseActionListener(new BtnBrowseListener());
	}
	public void showMainView(){
        this.viewMain_m.setVisible(true);
    }
	public void showNewPatientView(){
        this.viewNewPatient_m.setVisible(true);
    }
	
	/**
     * Innere Listener Klassen implementieren das Interface ActionListener
     */
    class BtnNewListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        	showNewPatientView();
        }
    }
    
    class BtnBrowseListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		String lang=null;
    		final Locale locale = getLocale(lang);
    		DatePicker dp = new DatePicker(NewPatientView.getDatePickerTxtField(),locale);
    		Date selectedDate = dp.parseDate(NewPatientView.getDatePickerTxtField().getText());
    		dp.setSelectedDate(selectedDate);
    		dp.start(NewPatientView.getDatePickerTxtField());
    		System.out.println("test");
    	}
    	
    	private Locale getLocale(String loc){
    		if(loc!=null && loc.length() > 0)
    			return new Locale(loc);
    		else
    			return Locale.GERMANY;
    	}
    }
}
