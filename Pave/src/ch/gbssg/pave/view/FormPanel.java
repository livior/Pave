package ch.gbssg.pave.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class FormPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	JTextField txtID;
	JTextField txtSurname;
	JTextField txtFirstName;
	JTextField txtBirthdate;
	JTextField txtAddress;
	JTextField txtPostalCode;
	JTextField txtPlace;
	JTextArea  txtAreaMedicalHistory;
	JScrollPane scrollPane;
	
	public FormPanel(){
		JPanel pnlFormData;
		JPanel pnlMedicalHistory;
		
		setLayout(new GridLayout(2,1));
		
		pnlFormData			= new JPanel(new GridLayout(9,2));
		pnlMedicalHistory	= new JPanel(new BorderLayout());
		
		// TODO: create the labels and set their border for margin
		//label.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		
		txtID					= new JTextField("1");
		txtSurname				= new JTextField("Meier");
		txtFirstName			= new JTextField("Peter");
		txtBirthdate			= new JTextField("20.05.1965");
		txtAddress				= new JTextField("Kanalstrasse 33");
		txtPostalCode			= new JTextField("9464");
		txtPlace				= new JTextField("Rüthi");
		
		txtAreaMedicalHistory	= new JTextArea("Gebrochenes Bein");
		scrollPane              = new JScrollPane(txtAreaMedicalHistory);
		
		pnlFormData.add(new JLabel("Patienten Nr.:"));
		pnlFormData.add(txtID);
		pnlFormData.add(new JLabel("Name:"));
		pnlFormData.add(txtSurname);
		pnlFormData.add(new JLabel("Vorname:"));
		pnlFormData.add(txtFirstName);
		pnlFormData.add(new JLabel("Geburtsdatum:"));
		pnlFormData.add(txtBirthdate);
		pnlFormData.add(new JLabel("Adresse:"));
		pnlFormData.add(txtAddress);
		pnlFormData.add(new JLabel("PLZ:"));
		pnlFormData.add(txtPostalCode);
		pnlFormData.add(new JLabel("Ort:"));
		pnlFormData.add(txtPlace);
		pnlFormData.add(new JLabel());
		pnlFormData.add(new JLabel());
		
		pnlMedicalHistory.add(new JLabel("Krankengeschichte:"), BorderLayout.NORTH);
		pnlMedicalHistory.add(scrollPane, BorderLayout.CENTER);
		
		add(pnlFormData);
		add(pnlMedicalHistory);
	}
}
