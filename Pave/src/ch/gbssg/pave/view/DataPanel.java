package ch.gbssg.pave.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import ch.gbssg.pave.model.PatientModel;

public class DataPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	JLabel lblID;
	JLabel lblSurname;
	JLabel lblFirstName;
	JLabel lblBirthdate;
	JLabel lblAddress;
	JLabel lblPostalCode;
	JLabel lblPlace;
	JTextArea  txtAreaMedicalHistory;
	JScrollPane scrollPane;
	
	public DataPanel(){
		JPanel pnlFormData;
		JPanel pnlMedicalHistory;
		Font f;
		setLayout(new GridLayout(2,1));
		
		pnlFormData			= new JPanel(new GridLayout(9,2));
		pnlMedicalHistory	= new JPanel(new BorderLayout());
		
		
		Font oldLabelFont = UIManager.getFont("Label.font");
	    UIManager.put("Label.font", oldLabelFont.deriveFont(Font.PLAIN));
		lblID					= new JLabel("1");
		lblSurname				= new JLabel("Meier");
		lblFirstName			= new JLabel("Peter");
		lblBirthdate			= new JLabel("20.05.1965");
		lblAddress				= new JLabel("Kanalstrasse 33");
		lblPostalCode			= new JLabel("9464");
		lblPlace				= new JLabel("Rüthi");
		
		txtAreaMedicalHistory	= new JTextArea("Gebrochenes Bein");
		txtAreaMedicalHistory.setEditable(false);
		scrollPane              = new JScrollPane(txtAreaMedicalHistory);
		
	    UIManager.put("Label.font", oldLabelFont.deriveFont(Font.BOLD));
		pnlFormData.add(new JLabel("     Patienten Nr.:"));
		pnlFormData.add(lblID);
		pnlFormData.add(new JLabel("     Name:"));
		pnlFormData.add(lblSurname);
		pnlFormData.add(new JLabel("     Vorname:"));
		pnlFormData.add(lblFirstName);
		pnlFormData.add(new JLabel("     Geburtsdatum:"));
		pnlFormData.add(lblBirthdate);
		pnlFormData.add(new JLabel("     Adresse:"));
		pnlFormData.add(lblAddress);
		pnlFormData.add(new JLabel("     PLZ:"));
		pnlFormData.add(lblPostalCode);
		pnlFormData.add(new JLabel("     Ort:"));
		pnlFormData.add(lblPlace);
		pnlFormData.add(new JLabel());
		pnlFormData.add(new JLabel());
		
		pnlMedicalHistory.add(new JLabel("Krankengeschichte:"), BorderLayout.NORTH);
		pnlMedicalHistory.add(scrollPane, BorderLayout.CENTER);
		
		add(pnlFormData);
		add(pnlMedicalHistory);
	}
	
	public void setPatient(PatientModel patient){
		lblID.setText("" + patient.getPatientID_m());
		lblSurname.setText(patient.getSurname_m());
		lblFirstName.setText(patient.getFirstName_m());
		lblBirthdate.setText(patient.getBirthdate_m());
		lblAddress.setText(patient.getAddress_m());
		lblPostalCode.setText("" + patient.getPostalCode_m());
		lblPlace.setText(patient.getPlace_m());
		txtAreaMedicalHistory.setText(patient.getMedicalHistory_m());
	}
}
