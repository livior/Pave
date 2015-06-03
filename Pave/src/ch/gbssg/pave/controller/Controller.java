package ch.gbssg.pave.controller;

/**
 * This class controls the data flow between the model and the view.
 * It contains all logical operations. All Listeners are defined in the Controller.
 * The view classes will be created here too.
 * @author Livio Rinaldi
 * @class  IAN6A
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
	
	/**
	 * initialize the program with the database
	 * connection and the needed variables
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws UnsupportedLookAndFeelException
	 * @throws SQLException
	 */
	public Controller() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, SQLException{
		this.viewMain_m = new MainView();
		
		this.modelSQLiteDatabase_m = new SQLiteDatabaseModel();
		this.modelPatients_m = new ArrayList<PatientModel>();
		this.modelPatients_m = this.modelSQLiteDatabase_m.getPatients();
    	this.viewMain_m.updateList(this.modelPatients_m);
    	if(this.modelPatients_m.size()>0)
    		this.viewMain_m.setPatient(this.modelPatients_m.get(0));
    	else
    		this.viewMain_m.setBtnsActive(false);
    		
    		
	}
	
	/**
	 * creates the main GUI and the ActionListeners
	 */
	public void showMainView(){
		this.viewMain_m.setBtnSearchActionListener(new BtnSearchListener());
		this.viewMain_m.setBtnNewActionListener(new BtnNewListener());
		this.viewMain_m.setBtnDeleteActionListener(new BtnDeleteListener());
		this.viewMain_m.setBtnGenerateBillActionListener(new BtnGenerateBillListener());
		this.viewMain_m.setBtnEditActionListener(new BtnEditListener());
		this.viewMain_m.setBtnExportActionListener(new BtnExportListener());
		this.viewMain_m.setListActionListener(new ListActionListener());
        this.viewMain_m.setVisible(true);
    }

	/**
	 * creates the GUI to add a new patient and the ActionListeners
	 */
	private void showNewPatientView(){
		this.viewNewPatient_m = new NewPatientView();
		
		this.viewNewPatient_m.setBtnBrowseActionListener(new BtnBrowseListener());
		this.viewNewPatient_m.setBtnSaveActionListener(new BtnSaveListener());
		this.viewNewPatient_m.setBtnCloseActionListener(new BtnCloseListener());
		
        this.viewNewPatient_m.setVisible(true);
    }

	/**
	 * creates the GUI to generate a bill and the ActionListeners
	 */
	private void showGenerateBillView(){
		this.viewGenerateBill_m = new GenerateBillView();

		this.viewGenerateBill_m.setBtnBrowseActionListener(new BtnBrowseBillListener());
		this.viewGenerateBill_m.setBtnSaveActionListener(new BtnSaveBillListener());
		this.viewGenerateBill_m.setBtnPrintActionListener(new BtnPrintBillListener());
		this.viewGenerateBill_m.setBtnCloseActionListener(new BtnCloseBillListener());
		
        this.viewGenerateBill_m.setVisible(true);
	}
	
	/**
	 * creates the GUI to edit a patient and the ActionListeners
	 */
	private void showEditPatientView(){
		this.viewEditPatient_m = new EditPatientView(this.modelPatients_m.get(viewMain_m.getList().getSelectedIndex()));
		
		this.viewEditPatient_m.setBtnBrowseEditActionListener(new BtnBrowseEditListener());
		this.viewEditPatient_m.setBtnSaveEditActionListener(new BtnSaveEditListener());
		this.viewEditPatient_m.setBtnCloseEditActionListener(new BtnCloseEditListener());
		
		this.viewEditPatient_m.setVisible(true);
	}
	
	/**
     * internal listener classes implement the Interface ActionListener
     */
    class BtnNewListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        	showNewPatientView();
        }
    }
    class BtnDeleteListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        	if (JOptionPane.showConfirmDialog(null, "Wirklich löschen?", "Löschen", 
        		    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
        		    == JOptionPane.YES_OPTION)
    		{
            	try {
    				Controller.this.modelSQLiteDatabase_m.deletePatient(Controller.this.modelPatients_m.get(Controller.this.viewMain_m.getList().getSelectedIndex()));
    			} catch (SQLException e1) {
    				Controller.this.viewMain_m.showError("Datenbank Fehler!");
    				e1.printStackTrace();
    			}
                Controller.this.modelPatients_m.remove(Controller.this.viewMain_m.getList().getSelectedIndex());
            	Controller.this.viewMain_m.updateList(Controller.this.modelPatients_m);
            	if(Controller.this.modelPatients_m.size()>0)
            		Controller.this.viewMain_m.setPatient(Controller.this.modelPatients_m.get(Controller.this.viewMain_m.getList().getSelectedIndex()));
            	else
            	{
                	Controller.this.viewMain_m.setBtnsActive(false);
            		Controller.this.viewMain_m.clearDataPanel();
            	}
    		}
    		else
    		{
    			return;
    		}
        }
    }
    class BtnSearchListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int index;
			String search;
			String name;
			
			for(index=0;index<Controller.this.modelPatients_m.size();index++){
				name = Controller.this.modelPatients_m.get(index).getFirstName() + " " + Controller.this.modelPatients_m.get(index).getSurname();
				search = Controller.this.viewMain_m.getSearchText();
				if(name.toLowerCase().contains(search.toLowerCase())) 
					Controller.this.modelPatients_m.get(index).setFiltered_m(true);
				else
					Controller.this.modelPatients_m.get(index).setFiltered_m(false);
			}
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
    class BtnExportListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
	    	JFileChooser fileChooser = new JFileChooser();
	    	PrintWriter writer=null;
	    	String filename;
	    	
	    	fileChooser.setDialogTitle("Exportieren");
	    	fileChooser.addChoosableFileFilter(new OpenFileFilter("docx","Word-Dokument (docx)") );
	    	fileChooser.addChoosableFileFilter(new OpenFileFilter("doc","Word-Dokument (doc)") );
	    	fileChooser.addChoosableFileFilter(new OpenFileFilter("pdf","PDF-Dokument") );
	    	int userSelection = fileChooser.showSaveDialog(Controller.this.viewMain_m);
	    	if (userSelection == JFileChooser.APPROVE_OPTION) {
	    	    File fileToSave = fileChooser.getSelectedFile();
	    	    filename=fileToSave.toString();
	    	    if(!filename.endsWith(".docx") || !filename.endsWith(".doc") || !filename.endsWith(".pdf"))
	    	    	filename+=".doc";
	    	    try {
					writer = new PrintWriter(fileToSave.getPath(), "UTF-8");
				} catch (FileNotFoundException | UnsupportedEncodingException e1) {
		    	    Controller.this.viewGenerateBill_m.showError("Datei konnte nicht gespeichert werden!");	    	    
					e1.printStackTrace();
				}
	    	    writer.println("Patienten Nr.:\t\t" + Controller.this.modelPatients_m.get(Controller.this.viewMain_m.getList().getSelectedIndex()).getID());
	    	    writer.println("Vorname:\t\t\t" + Controller.this.modelPatients_m.get(Controller.this.viewMain_m.getList().getSelectedIndex()).getFirstName());
	    	    writer.println("Name:\t\t\t\t" + Controller.this.modelPatients_m.get(Controller.this.viewMain_m.getList().getSelectedIndex()).getSurname());
	    	    writer.println("Geburtsdatum:\t\t" + Controller.this.modelPatients_m.get(Controller.this.viewMain_m.getList().getSelectedIndex()).getBirthdate());
	    	    writer.println("Adresse:\t\t\t" + Controller.this.modelPatients_m.get(Controller.this.viewMain_m.getList().getSelectedIndex()).getAddress());
	    	    writer.println("PLZ/Ort:\t\t\t" + Controller.this.modelPatients_m.get(Controller.this.viewMain_m.getList().getSelectedIndex()).getPostalCode() + " " + Controller.this.modelPatients_m.get(Controller.this.viewMain_m.getList().getSelectedIndex()).getPlace());
	    	    writer.println("");
	    	    writer.println("Krankengeschichte:\n" + Controller.this.modelPatients_m.get(Controller.this.viewMain_m.getList().getSelectedIndex()).getMedicalHistory());
	    	    Controller.this.viewGenerateBill_m.showMessage("Erfolgreich gespeichert");	    	    
	    	    writer.close();
	    	}
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
        		Controller.this.viewNewPatient_m.showError("PLZ muss eine Zahl sein!");
        		return;
        	}
        	PatientModel patient=new PatientModel(Controller.this.viewNewPatient_m.getFirstName(),Controller.this.viewNewPatient_m.getSurname(),Controller.this.viewNewPatient_m.getBirthdate(),Controller.this.viewNewPatient_m.getAddress(),Controller.this.viewNewPatient_m.getPostalCode(),Controller.this.viewNewPatient_m.getPlace(),Controller.this.viewNewPatient_m.getMedicalHistory());
        	Controller.this.modelPatients_m.add(patient);
        	try {
				Controller.this.modelSQLiteDatabase_m.addPatient(patient);
			} catch (SQLException e1) {
				e1.printStackTrace();
				Controller.this.viewNewPatient_m.showError("Datenbank fehler!");
        		return;
			}
        	Controller.this.viewMain_m.updateList(Controller.this.modelPatients_m);
        	Controller.this.viewMain_m.setPatient(Controller.this.modelPatients_m.get(Controller.this.viewMain_m.getList().getSelectedIndex()));
        	Controller.this.viewMain_m.setBtnsActive(true);
        	Controller.this.viewNewPatient_m.dispose();
        }
    }
    class BtnCloseListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        	Controller.this.viewNewPatient_m.dispose();
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
        		Controller.this.viewEditPatient_m.showError("PLZ muss eine Zahl sein!");
        		return;
        	}
        	Controller.this.modelPatients_m.get(Controller.this.viewMain_m.getList().getSelectedIndex()).setAllData(Controller.this.viewEditPatient_m.getFirstName(),Controller.this.viewEditPatient_m.getSurname(),Controller.this.viewEditPatient_m.getBirthdate(),Controller.this.viewEditPatient_m.getAddress(),Controller.this.viewEditPatient_m.getPostalCode(),Controller.this.viewEditPatient_m.getPlace(),Controller.this.viewEditPatient_m.getMedicalHistory());
        	try {
				Controller.this.modelSQLiteDatabase_m.editPatient(Controller.this.modelPatients_m.get(Controller.this.viewMain_m.getList().getSelectedIndex()));
			} catch (SQLException e1) {
				e1.printStackTrace();
				Controller.this.viewNewPatient_m.showError("Datenbank fehler!");
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
	    	JFileChooser fileChooser = new JFileChooser();
	    	String filename;
	    	PrintWriter writer=null;

        	if(Controller.this.viewGenerateBill_m.getOperationTime()<0)
        	{
        		Controller.this.viewGenerateBill_m.showError("Behandlunsdauer muss eine Zahl sein!");
        		return;
        	}
	    	if(Controller.this.viewGenerateBill_m.getPrice()<0)
        	{
        		Controller.this.viewGenerateBill_m.showError("Stundensatz muss eine Zahl sein!");
        		return;
        	}
        	
	    	fileChooser.setDialogTitle("Speichern");
	    	fileChooser.addChoosableFileFilter(new OpenFileFilter("docx","Word-Dokument (docx)") );
	    	fileChooser.addChoosableFileFilter(new OpenFileFilter("doc","Word-Dokument (doc)") );
	    	fileChooser.addChoosableFileFilter(new OpenFileFilter("pdf","PDF-Dokument") );
	    	
	    	int userSelection = fileChooser.showSaveDialog(Controller.this.viewMain_m);
	    	if (userSelection == JFileChooser.APPROVE_OPTION) {
	    	    File fileToSave = fileChooser.getSelectedFile();
	    	    filename=fileToSave.toString();
	    	    if(!filename.endsWith(".docx") || !filename.endsWith(".doc") || !filename.endsWith(".pdf"))
	    	    	filename+=".doc";
	    	    try {
					writer = new PrintWriter(filename, "UTF-8");
				} catch (FileNotFoundException | UnsupportedEncodingException e1) {
		    	    Controller.this.viewGenerateBill_m.showError("Datei konnte nicht gespeichert werden!");	    	    
					e1.printStackTrace();
				}
	    	    writer.println("Vorname:\t\t\t" + Controller.this.modelPatients_m.get(Controller.this.viewMain_m.getList().getSelectedIndex()).getFirstName());
	    	    writer.println("Name:\t\t\t\t" + Controller.this.modelPatients_m.get(Controller.this.viewMain_m.getList().getSelectedIndex()).getSurname());
	    	    writer.println("Adresse:\t\t\t" + Controller.this.modelPatients_m.get(Controller.this.viewMain_m.getList().getSelectedIndex()).getAddress());
	    	    writer.println("PLZ/Ort:\t\t\t" + Controller.this.modelPatients_m.get(Controller.this.viewMain_m.getList().getSelectedIndex()).getPostalCode() + " " + Controller.this.modelPatients_m.get(Controller.this.viewMain_m.getList().getSelectedIndex()).getPlace());
	    	    writer.println("");
	    	    writer.println("Behandlungsdatum:\t" + Controller.this.viewGenerateBill_m.getDatePickerTxtField().getText());
	    	    writer.println("Kosten:\t\t\t" + Controller.this.viewGenerateBill_m.getOperationTime() * Controller.this.viewGenerateBill_m.getPrice() + "0 Fr.");
	    	    writer.println("");
	    	    writer.println("Beschreibung:\n" + Controller.this.viewGenerateBill_m.getDescription());
	    	    Controller.this.viewGenerateBill_m.showMessage("Erfolgreich gespeichert");	    	    
	    	    writer.close();
	    	}
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
    class ListActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Controller.this.viewMain_m.setPatient(Controller.this.modelPatients_m.get(Controller.this.viewMain_m.getList().getSelectedIndex()));
		}
    }
}
