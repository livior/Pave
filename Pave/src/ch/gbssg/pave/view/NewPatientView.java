package ch.gbssg.pave.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class NewPatientView extends JFrame{
	private static final long serialVersionUID = 1L;
	private static FormPanel pnlForm;
	ButtonTextAreaPanel pnlButtonTextArea;
	public NewPatientView(){
		super("Patient hinzufügen");
		initForm();
	}
	
	/**
     * Die JForm wird initialisiert und alle Steuerelemente
     * positioniert
     */
    private void initForm(){
    	this.setLayout(new GridLayout(2,1));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(400, 500);
        

        pnlForm = new FormPanel();
        pnlButtonTextArea = new ButtonTextAreaPanel();
        this.add(pnlForm);
        this.add(pnlButtonTextArea);
        
//		UtilDateModel model = new UtilDateModel();
	//	model.setDate(1990, 8, 24);
		//JDatePanelImpl datePanel = new JDatePanelImpl(model,null);
		//JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, null);
		 
    //    add(datePicker);		//setLayout(new GridLayout(6,4));
    }

    public void setBtnBrowseActionListener(ActionListener a){
    	pnlForm.setBtnBrowseActionListener(a);
    }
    public static ObservingTextField getDatePickerTxtField(){
    	return pnlForm.getDatePickerTxtField();
    }

}
