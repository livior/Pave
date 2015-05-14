package ch.gbssg.pave.view;

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
		setLayout(new GridLayout(10,2));
		
		txtID					= new JTextField("1");
		txtSurname				= new JTextField("Meier");
		txtFirstName			= new JTextField("Peter");
		txtBirthdate			= new JTextField("20.05.1965");
		txtAddress				= new JTextField("Kanalstrasse 33");
		txtPostalCode			= new JTextField("9464");
		txtPlace				= new JTextField("Rüthi");
		txtAreaMedicalHistory	= new JTextArea("Gebrochenes Bein");
		scrollPane              = new JScrollPane(txtAreaMedicalHistory);
		
		add(new JLabel("Patienten Nr.:"));
		add(txtID);
		add(new JLabel("Name:"));
		add(txtSurname);
		add(new JLabel("Vorname:"));
		add(txtFirstName);
		add(new JLabel("Geburtsdatum:"));
		add(txtBirthdate);
		add(new JLabel("Adresse:"));
		add(txtAddress);
		add(new JLabel("PLZ:"));
		add(txtPostalCode);
		add(new JLabel("Ort:"));
		add(txtPlace);
		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel("Krankengeschichte:"));
		add(new JLabel(""));
		add(scrollPane);
	}
}
