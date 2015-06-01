package ch.gbssg.pave.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.swing.UnsupportedLookAndFeelException;

import ch.gbssg.pave.model.*;
import ch.gbssg.pave.view.*;

public class Controller {
	private MainView viewMain_m;
	private NewPatientView viewNewPatient_m;
	private GenerateBillView viewGenerateBill_m;
	private EditPatientView viewEditPatient_m;
	private SQLiteDatabaseModel modelSQLiteDatabase_m;
	private ArrayList<PatientModel> modelPatients_m;
	
	public Controller() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, SQLException{
		this.viewMain_m = new MainView();
		
		this.modelSQLiteDatabase_m = new SQLiteDatabaseModel();
		this.modelPatients_m = new ArrayList<PatientModel>();
		this.modelPatients_m = this.modelSQLiteDatabase_m.getPatients();
    	this.viewMain_m.updateList(this.modelPatients_m);
    	if(this.modelPatients_m.size()>0)
    		this.viewMain_m.setPatient(this.modelPatients_m.get(0));
	}
	
	public void showMainView(){
		this.viewMain_m.setBtnNewActionListener(new BtnNewListener());
		this.viewMain_m.setBtnDeleteActionListener(new BtnDeleteListener());
		this.viewMain_m.setBtnGenerateBillActionListener(new BtnGenerateBillListener());
		this.viewMain_m.setBtnEditActionListener(new BtnEditListener());
		this.viewMain_m.setListActionListener(new ListListener());
        this.viewMain_m.setVisible(true);
    }
	public void showNewPatientView(){
		this.viewNewPatient_m = new NewPatientView();
		
		this.viewNewPatient_m.setBtnBrowseActionListener(new BtnBrowseListener());
		this.viewNewPatient_m.setBtnSaveActionListener(new BtnSaveListener());
		this.viewNewPatient_m.setBtnCloseActionListener(new BtnCloseListener());
		
        this.viewNewPatient_m.setVisible(true);
    }
	public void showGenerateBillView(){
		this.viewGenerateBill_m = new GenerateBillView();

		this.viewGenerateBill_m.setBtnBrowseActionListener(new BtnBrowseBillListener());
		this.viewGenerateBill_m.setBtnSaveActionListener(new BtnSaveBillListener());
		this.viewGenerateBill_m.setBtnPrintActionListener(new BtnPrintBillListener());
		this.viewGenerateBill_m.setBtnCloseActionListener(new BtnCloseBillListener());
		
        this.viewGenerateBill_m.setVisible(true);
	}
	public void showEditPatientView(){
		this.viewEditPatient_m = new EditPatientView(this.modelPatients_m.get(viewMain_m.getList().getSelectedIndex()));
		
		this.viewEditPatient_m.setBtnBrowseEditActionListener(new BtnBrowseEditListener());
		this.viewEditPatient_m.setBtnSaveEditActionListener(new BtnSaveEditListener());
		this.viewEditPatient_m.setBtnCloseEditActionListener(new BtnCloseEditListener());
		
		this.viewEditPatient_m.setVisible(true);
	}
	
	/**
     * Innere Listener Klassen implementieren das Interface ActionListener
     */
    class BtnNewListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        	showNewPatientView();
        }
    }
    class BtnDeleteListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        	try {
				Controller.this.modelSQLiteDatabase_m.deletePatient(Controller.this.modelPatients_m.get(Controller.this.viewMain_m.getList().getSelectedIndex()));
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
            Controller.this.modelPatients_m.remove(Controller.this.viewMain_m.getList().getSelectedIndex());
        	Controller.this.viewMain_m.updateList(Controller.this.modelPatients_m);
        }
    }    
    class BtnGenerateBillListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		showGenerateBillView();
    	}
    }
    class BtnEditListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		showEditPatientView();
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
        	if(Controller.this.viewNewPatient_m.getPostalCode()<0)
        	{
        		Controller.this.viewNewPatient_m.showErrorInvaildInput("PLZ muss eine Zahl sein!");
        		return;
        	}
        	PatientModel patient=new PatientModel(Controller.this.viewNewPatient_m.getFirstName(),Controller.this.viewNewPatient_m.getSurname(),Controller.this.viewNewPatient_m.getBirthdate(),Controller.this.viewNewPatient_m.getAddress(),Controller.this.viewNewPatient_m.getPostalCode(),Controller.this.viewNewPatient_m.getPlace(),Controller.this.viewNewPatient_m.getMedicalHistory());
        	System.out.println(patient.getFirstName());
        	System.out.println(Controller.this.viewNewPatient_m.getFirstName());
        	System.out.println(patient.getSurname());
        	System.out.println(patient.getBirthdate());
        	System.out.println(patient.getAddress());
        	System.out.println("" + patient.getPostalCode());
        	System.out.println("" + patient.getPlace());
        	System.out.println("" + patient.getMedicalHistory());
        	Controller.this.modelPatients_m.add(patient);
        	try {
				Controller.this.modelSQLiteDatabase_m.addPatient(patient);
			} catch (SQLException e1) {
				e1.printStackTrace();
				Controller.this.viewNewPatient_m.showErrorInvaildInput("Datenbank fehler!");
        		return;
			}
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
    
    class BtnBrowseEditListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		String lang=null;
    		final Locale locale = getLocale(lang);
    		DatePicker dp = new DatePicker(Controller.this.viewEditPatient_m.getDatePickerTxtField(),locale);
    		Date selectedDate = dp.parseDate(Controller.this.viewEditPatient_m.getDatePickerTxtField().getText());
    		dp.setSelectedDate(selectedDate);
    		dp.start(Controller.this.viewEditPatient_m.getDatePickerTxtField());
    	}
    	
    	private Locale getLocale(String loc){
    		if(loc!=null && loc.length() > 0)
    			return new Locale(loc);
    		else
    			return Locale.GERMANY;
    	}
    }
    class BtnSaveEditListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        	if(Controller.this.viewEditPatient_m.getPostalCode()<0)
        	{
        		Controller.this.viewEditPatient_m.showErrorInvaildInput("PLZ muss eine Zahl sein!");
        		return;
        	}
        	Controller.this.modelPatients_m.get(Controller.this.viewMain_m.getList().getSelectedIndex()).setAllData(Controller.this.viewEditPatient_m.getFirstName(),Controller.this.viewEditPatient_m.getSurname(),Controller.this.viewEditPatient_m.getBirthdate(),Controller.this.viewEditPatient_m.getAddress(),Controller.this.viewEditPatient_m.getPostalCode(),Controller.this.viewEditPatient_m.getPlace(),Controller.this.viewEditPatient_m.getMedicalHistory());
        	try {
				Controller.this.modelSQLiteDatabase_m.editPatient(Controller.this.modelPatients_m.get(Controller.this.viewMain_m.getList().getSelectedIndex()));
			} catch (SQLException e1) {
				e1.printStackTrace();
				Controller.this.viewNewPatient_m.showErrorInvaildInput("Datenbank fehler!");
        		return;
			}
        	Controller.this.viewMain_m.updateList(Controller.this.modelPatients_m);
        	Controller.this.viewMain_m.setPatient(Controller.this.modelPatients_m.get(Controller.this.viewMain_m.getList().getSelectedIndex()));
        	Controller.this.viewEditPatient_m.dispose();
        }
    }
    class BtnCloseEditListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        	Controller.this.viewEditPatient_m.dispose();
        }
    }

    class BtnBrowseBillListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		String lang=null;
    		final Locale locale = getLocale(lang);
    		DatePicker dp = new DatePicker(Controller.this.viewGenerateBill_m.getDatePickerTxtField(),locale);
    		Date selectedDate = dp.parseDate(Controller.this.viewGenerateBill_m.getDatePickerTxtField().getText());
    		dp.setSelectedDate(selectedDate);
    		dp.start(Controller.this.viewGenerateBill_m.getDatePickerTxtField());
    	}
    	
    	private Locale getLocale(String loc){
    		if(loc!=null && loc.length() > 0)
    			return new Locale(loc);
    		else
    			return Locale.GERMANY;
    	}
    }
    class BtnSaveBillListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        	if(Controller.this.viewGenerateBill_m.getPrice()<0)
        	{
        		Controller.this.viewGenerateBill_m.showErrorInvaildInput("Stundensatz muss eine Zahl sein!");
        		return;
        	}
        	if(Controller.this.viewGenerateBill_m.getOperationTime()<0)
        	{
        		Controller.this.viewGenerateBill_m.showErrorInvaildInput("Behandlunsdauer muss eine Zahl sein!");
        		return;
        	}
        	
        	// TODO: Save Bill as pdf-doc
        	Controller.this.viewGenerateBill_m.dispose();
        }
    }
    class BtnPrintBillListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        	Controller.this.viewGenerateBill_m.dispose();
        }
    }
    class BtnCloseBillListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        	Controller.this.viewGenerateBill_m.dispose();
        }
    }
    class ListListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        	viewMain_m.setPatient(Controller.this.modelPatients_m.get(viewMain_m.getList().getSelectedIndex())); 
        }
    }
}
