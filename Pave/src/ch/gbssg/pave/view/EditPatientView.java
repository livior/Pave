package ch.gbssg.pave.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import ch.gbssg.pave.model.PatientModel;


public class EditPatientView extends JFrame{
	private static final long serialVersionUID = 1L;
	private FormPanel pnlForm;
	private ButtonTextAreaPanel pnlButtonTextArea;
	public EditPatientView(PatientModel patient){
		super("Patient bearbeiten");
		initForm(patient);
	}
	
	/**
     * Die JForm wird initialisiert und alle Steuerelemente
     * positioniert
     */
    private void initForm(PatientModel patient){
    	this.setLayout(new GridLayout(2,1));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(400, 500);
        

        pnlForm = new FormPanel();
        pnlButtonTextArea = new ButtonTextAreaPanel();
        pnlForm.setFormData(patient);
        pnlButtonTextArea.setTextAreaData(patient.getMedicalHistory());
        this.add(pnlForm);
        this.add(pnlButtonTextArea);
        
    }
    
    public void showErrorInvaildInput(String infoMessage){
    	String titleBar = "Fehler";
    	JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.ERROR_MESSAGE);
    }
    public void setBtnBrowseEditActionListener(ActionListener a){
    	pnlForm.setBtnBrowseActionListener(a);
    }
    public void setBtnSaveEditActionListener(ActionListener a){
    	pnlButtonTextArea.setBtnSaveActionListener(a);
    }
    public void setBtnCloseEditActionListener(ActionListener a){
    	pnlButtonTextArea.setBtnCloseActionListener(a);
    }

    public String getSurname(){
    	return(pnlForm.getSurname());
    }
    public String getFirstName(){
    	return(pnlForm.getFirstName());
    }
    public ObservingTextField getDatePickerTxtField(){
    	return pnlForm.getDatePickerTxtField();
    }
    public String getBirthdate(){
    	return pnlForm.getDatePickerTxtField().getText();
    }

    public String getAddress(){
    	return(pnlForm.getAddress());
    }
    public int getPostalCode(){
    	return(pnlForm.getPostalCode());
    }
    public String getPlace(){
    	return(pnlForm.getPlace());
    }
    public String getMedicalHistory(){
    	return(pnlButtonTextArea.getMedicalHistory());
    }
}
