package ch.gbssg.pave.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class FormPanel extends JPanel{
 	private static final long serialVersionUID = 1L;
	JTextField	txtID;
	JTextField	txtSurname;
	JTextField	txtFirstName;
	ObservingTextField txtDate;
	JButton     btnBrowse;
	JTextField	txtAddress;
	JTextField	txtPostalCode;
	JTextField	txtPlace;
	
	public FormPanel(){
		setLayout(new GridLayout(5,3));
		txtSurname				= new JTextField();
		txtFirstName			= new JTextField();
		txtDate                 = new ObservingTextField();
		btnBrowse               = new JButton("...");
		txtAddress				= new JTextField();
		txtPostalCode			= new JTextField();
		txtPlace				= new JTextField();

		add(new JLabel("     Name:"));
		add(txtFirstName);
		add(new JLabel());
		add(new JLabel("     Vorname:"));
		add(txtSurname);
		add(new JLabel());
		add(new JLabel("     Geburtsdatum:"));
		add(txtDate);
		add(btnBrowse);
		add(new JLabel("     Adresse:"));
		add(txtAddress);
		add(new JLabel());
		add(new JLabel("     PLZ/Ort:"));
		add(txtPostalCode);
		add(txtPlace);
	}
	public String getSurname(){
		return(txtSurname.getText());
	}
	public String getFirstName(){
		return(txtFirstName.getText());
	}
	public ObservingTextField getDatePickerTxtField(){
		return(txtDate);
	}
	public String getAddress(){
		return(txtAddress.getText());
	}
	public int getPostalCode(){
		int postalCode;
		try  
		{  
			postalCode = Integer.parseInt(txtPostalCode.getText());  
		}  
		catch(NumberFormatException nfe)  
		{  
		  return(-1);  
		}  
		return(postalCode);
	}
	public String getPlace(){
		return(txtPlace.getText());
	}
	public void setBtnBrowseActionListener(ActionListener a){
		this.btnBrowse.addActionListener(a);
	}
}
