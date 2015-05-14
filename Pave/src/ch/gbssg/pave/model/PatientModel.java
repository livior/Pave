package ch.gbssg.pave.model;

public class PatientModel {
	private static int	patientID_m;
	private String		firstName_m;
	private String		surename_m;
	private String		birthdate_m;
	private String		address_m;
	private int    		postalCode_m;
	private String		place_m;
	private String		medicalHistory_m;

	public PatientModel(){
		patientID_m++;
		this.firstName_m="";
		this.surename_m="";
		this.birthdate_m="";
		this.address_m="";
		this.postalCode_m=0;
		this.place_m="";
		this.medicalHistory_m="";
	}

	public PatientModel(String firstName, String surname, String birthdate, String address, int postalCode, String place, String medicalHistory){
		patientID_m++;
		this.firstName_m=firstName;
		this.surename_m=surname;
		this.birthdate_m=birthdate;
		this.address_m=address;
		this.postalCode_m=postalCode;
		this.place_m=place;
		this.medicalHistory_m=medicalHistory;
	}

	
	/* getter und setter */

	public static int getPatientID_m() {
		return patientID_m;
	}

	public static void setPatientID_m(int patientID_m) {
		PatientModel.patientID_m = patientID_m;
	}

	public String getFirstName_m() {
		return firstName_m;
	}

	public void setFirstName_m(String firstName_m) {
		this.firstName_m = firstName_m;
	}

	public String getSurename_m() {
		return surename_m;
	}

	public void setSurename_m(String surename_m) {
		this.surename_m = surename_m;
	}

	public String getBirthdate_m() {
		return birthdate_m;
	}

	public void setBirthdate_m(String birthdate_m) {
		this.birthdate_m = birthdate_m;
	}

	public String getAddress_m() {
		return address_m;
	}

	public void setAddress_m(String address_m) {
		this.address_m = address_m;
	}

	public int getPostalCode_m() {
		return postalCode_m;
	}

	public void setPostalCode_m(int postalCode_m) {
		this.postalCode_m = postalCode_m;
	}

	public String getPlace_m() {
		return place_m;
	}

	public void setPlace_m(String place_m) {
		this.place_m = place_m;
	}

	public String getMedicalHistory_m() {
		return medicalHistory_m;
	}

	public void setMedicalHistory_m(String medicalHistory_m) {
		this.medicalHistory_m = medicalHistory_m;
	}
	
}
