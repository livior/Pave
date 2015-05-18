package ch.gbssg.pave.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdatepicker.impl.*;

public class FormPanel extends JPanel{
 	private static final long serialVersionUID = 1L;
	JTextField	txtID;
	JTextField	txtSurname;
	JTextField	txtFirstName;
	ObservingTextField txtDate;
	JButton     btnBrowse;
	JTextField	txtBirthday;
	JTextField	txtBirthMonth;
	JTextField	txtBirthYear;
	JTextField	txtAddress;
	JTextField	txtPostalCode;
	JTextField	txtPlace;
	
	public FormPanel(){
		setLayout(new GridLayout(5,3));
		txtSurname				= new JTextField();
		txtFirstName			= new JTextField();
		txtBirthday				= new JTextField();
		txtBirthMonth			= new JTextField();
		txtBirthYear			= new JTextField();
		txtDate                 = new ObservingTextField();
		btnBrowse               = new JButton("...");
		txtAddress				= new JTextField();
		txtPostalCode			= new JTextField();
		txtPlace				= new JTextField();

		add(new JLabel("     Name:"));
		add(txtSurname);
		add(new JLabel());
		add(new JLabel("     Vorname:"));
		add(txtFirstName);
		add(new JLabel());
		add(new JLabel("     Geburtsdatum:"));
//		add(txtBirthday);
	//	add(txtBirthMonth);
		//add(txtBirthYear);
		add(txtDate);
		add(btnBrowse);
		add(new JLabel("     Adresse:"));
		add(txtAddress);
		add(new JLabel());
		add(new JLabel("     PLZ/Ort:"));
		add(txtPostalCode);
		add(txtPlace);
	}
	public ObservingTextField getDatePickerTxtField(){
		return txtDate;
	}
	public void setBtnBrowseActionListener(ActionListener a){
		this.btnBrowse.addActionListener(a);
	}

}
