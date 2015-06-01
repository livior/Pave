package ch.gbssg.pave.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ch.gbssg.pave.model.PatientModel;


public class BillFormPanel extends JPanel{
 	private static final long serialVersionUID = 1L;
	JTextField	txtOperationTime;
	JTextField	txtPrice;
	ObservingTextField txtDate;
	JButton     btnBrowse;
	
	public BillFormPanel(){
		setLayout(new GridLayout(3,3));
		txtOperationTime		= new JTextField();
		txtPrice    			= new JTextField();
		txtDate                 = new ObservingTextField();
		btnBrowse               = new JButton("...");

		add(new JLabel("     Behandlungsdauer (h):"));
		add(txtOperationTime);
		add(new JLabel());
		add(new JLabel("     Stundensatz (CHF):"));
		add(txtPrice);
		add(new JLabel());
		add(new JLabel("     Behandlungsdatum:"));
		add(txtDate);
		add(btnBrowse);
	}
	
	public double getOperationTime(){
		double operationTime;
		try{  
			operationTime = Double.parseDouble(txtOperationTime.getText());  
		}catch(NumberFormatException nfe){  
		  return(-1);  
		}  
		return(operationTime);
	}
	public double getPrice(){
		double price;
		try{  
			price = Double.parseDouble(txtPrice.getText());  
		}catch(NumberFormatException nfe){  
		  return(-1);  
		}  
		return(price);
	}
	public ObservingTextField getDatePickerTxtField(){
		return(txtDate);
	}
	public void setBtnBrowseActionListener(ActionListener a){
		this.btnBrowse.addActionListener(a);
	}
}
