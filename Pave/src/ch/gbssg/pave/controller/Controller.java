package ch.gbssg.pave.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.UnsupportedLookAndFeelException;

import ch.gbssg.pave.model.*;
import ch.gbssg.pave.view.*;

public class Controller {
	private MainView viewMain_m;
	private NewPatientView viewNewPatient_m;
	private SQLiteDatabaseModel modelSQLiteDatabase_m;
	private ArrayList<PatientModel> modelPatients_m;
	
	public Controller() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		this.viewMain_m = new MainView();
		this.viewNewPatient_m = new NewPatientView();
		this.modelSQLiteDatabase_m = new SQLiteDatabaseModel();
		addActionListener();
		this.modelPatients_m = new ArrayList<PatientModel>();
	}
	
	public void addActionListener(){
		this.viewMain_m.setBtnNewActionListener(new BtnNewListener());
		this.viewNewPatient_m.setBtnBrowseActionListener(new BtnBrowseListener());
		this.viewNewPatient_m.setBtnSaveActionListener(new BtnSaveListener());
		this.viewNewPatient_m.setBtnCloseActionListener(new BtnCloseListener());
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
    		DatePicker dp = new DatePicker(Controller.this.viewNewPatient_m.getDatePickerTxtField(),locale);
    		Date selectedDate = dp.parseDate(Controller.this.viewNewPatient_m.getDatePickerTxtField().getText());
    		dp.setSelectedDate(selectedDate);
    		dp.start(Controller.this.viewNewPatient_m.getDatePickerTxtField());
    	}
    	
    	private Locale getLocale(String loc){
    		if(loc!=null && loc.length() > 0)
    			return new Locale(loc);
    		else
    			return Locale.GERMANY;
    	}
    }
    class BtnSaveListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        	PatientModel patient=new PatientModel(Controller.this.viewNewPatient_m.getFirstName(),Controller.this.viewNewPatient_m.getSurname(),Controller.this.viewNewPatient_m.getBirthdate(),Controller.this.viewNewPatient_m.getAddress(),Controller.this.viewNewPatient_m.getPostalCode(),Controller.this.viewNewPatient_m.getPlace(),Controller.this.viewNewPatient_m.getMedicalHistory());
        	System.out.println(patient.getFirstName());
        	System.out.println(Controller.this.viewNewPatient_m.getFirstName());
        	System.out.println(Controller.this.viewNewPatient_m.getSurname());
        	System.out.println(Controller.this.viewNewPatient_m.getBirthdate());
        	System.out.println(Controller.this.viewNewPatient_m.getAddress());
        	System.out.println("" + Controller.this.viewNewPatient_m.getPostalCode());
        	System.out.println("" + Controller.this.viewNewPatient_m.getPlace());
        	System.out.println("" + Controller.this.viewNewPatient_m.getMedicalHistory());
        	Controller.this.modelPatients_m.add(patient);
        	Controller.this.viewMain_m.updateList(Controller.this.modelPatients_m);
        	Controller.this.viewNewPatient_m.dispose();
        }
    }
    class BtnCloseListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        	Controller.this.viewNewPatient_m.dispose();
//        	Controller.this.viewNewPatient_m.hide();
        }
    }
}
