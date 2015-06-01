package ch.gbssg.pave.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;


public class GenerateBillView extends JFrame{
	private static final long serialVersionUID = 1L;
	private BillFormPanel pnlBillForm;
	private BillButtonTextAreaPanel pnlBillButtonTextArea;
	public GenerateBillView(){
		super("Rechnung generieren");
		initForm();
	}
	
	/**
     * Die JForm wird initialisiert und alle Steuerelemente
     * positioniert
     */
    private void initForm(){
    	this.setLayout(new GridLayout(2,1));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(450, 500);
        this.setMinimumSize(new Dimension(450,200));
        

        pnlBillForm = new BillFormPanel();
        pnlBillButtonTextArea = new BillButtonTextAreaPanel();
        this.add(pnlBillForm);
        this.add(pnlBillButtonTextArea);
        
    }
    
    public void showErrorInvaildInput(String infoMessage){
    	String titleBar = "Fehler";
    	JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.ERROR_MESSAGE);
    }
    public void setBtnBrowseActionListener(ActionListener a){
    	pnlBillForm.setBtnBrowseActionListener(a);
    }
    public void setBtnSaveActionListener(ActionListener a){
    	pnlBillButtonTextArea.setBtnSaveActionListener(a);
    }
    public void setBtnPrintActionListener(ActionListener a){
    	pnlBillButtonTextArea.setBtnPrintActionListener(a);
    }
    public void setBtnCloseActionListener(ActionListener a){
    	pnlBillButtonTextArea.setBtnCloseActionListener(a);
    }

    public double getOperationTime(){
    	return(pnlBillForm.getOperationTime());
    }
    public double getPrice(){
    	return(pnlBillForm.getPrice());
    }
    public ObservingTextField getDatePickerTxtField(){
    	return pnlBillForm.getDatePickerTxtField();
    }
    public String getDescription(){
    	return(pnlBillButtonTextArea.getDescription());
    }
}
