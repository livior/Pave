package ch.gbssg.pave.model;

/**
 * This is a model class. It's used to create patients.
 * All patient data are stored here and can be modified.
 * Everytime when a new Object of this class is created, the ID is plus 1, so is every
 * Object defined with his own ID.
 * @author Livio Rinaldi
 * @class  IAN6A
 */

public class PatientModel {
	private static int	patientID_m;
	private int         id_m;
	private String		firstName_m;
	private String		surname_m;
	private String		birthdate_m;
	private String		address_m;
	private int    		postalCode_m;
	private String		place_m;
	private String		medicalHistory_m;
	private boolean     isFiltered_m;


	public PatientModel(){
		patientID_m++;
		this.id_m=patientID_m;
		this.firstName_m="";
		this.surname_m="";
		this.birthdate_m="";
		this.address_m="";
		this.postalCode_m=0;
		this.place_m="";
		this.medicalHistory_m="";
		this.isFiltered_m=true;
	}

	public PatientModel(String firstName, String surname, String birthdate, String address, int postalCode, String place, String medicalHistory){
		patientID_m++;
		this.id_m=patientID_m;
		this.firstName_m=firstName;
		this.surname_m=surname;
		this.birthdate_m=birthdate;
		this.address_m=address;
		this.postalCode_m=postalCode;
		this.place_m=place;
		this.medicalHistory_m=medicalHistory;
		this.isFiltered_m=true;
	}

	
	/* getter und setter */
	public void setAllData(String firstName, String surname, String birthdate, String address, int postalCode, String place, String medicalHistory){
		this.firstName_m=firstName;
		this.surname_m=surname;
		this.birthdate_m=birthdate;
		this.address_m=address;
		this.postalCode_m=postalCode;
		this.place_m=place;
		this.medicalHistory_m=medicalHistory;
		
	}
	
	public static void setStaticID(int id){
		patientID_m=id;
	}
	public int getID() {
		return id_m;
	}

	public void setID(int id) {
		this.id_m = id;
	}

	public String getFirstName() {
		return firstName_m;
	}

	public void setFirstName(String firstName) {
		this.firstName_m = firstName;
	}

	public String getSurname() {
		return surname_m;
	}

	public void setSurname(String surname) {
		this.surname_m = surname;
	}

	public String getBirthdate() {
		return birthdate_m;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate_m = birthdate;
	}

	public String getAddress() {
		return address_m;
	}

	public void setAddress(String address) {
		this.address_m = address;
	}

	public int getPostalCode() {
		return postalCode_m;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode_m = postalCode;
	}

	public String getPlace() {
		return place_m;
	}

	public void setPlace(String place_m) {
		this.place_m = place_m;
	}

	public String getMedicalHistory() {
		return medicalHistory_m;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory_m = medicalHistory;
	}

	public boolean isFiltered_m() {
		return isFiltered_m;
	}

	public void setFiltered_m(boolean isFiltered_m) {
		this.isFiltered_m = isFiltered_m;
	}
	
}
