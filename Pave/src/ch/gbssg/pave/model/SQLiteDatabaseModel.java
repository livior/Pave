package ch.gbssg.pave.model;

import java.sql.*;

public class SQLiteDatabaseModel {
	private Connection connection_m;
	private Statement stmt = null;
	private final String CREATE_TABLE=	"CREATE TABLE IF NOT EXISTS PATIENTS " +
		                 				"(ID INT PRIMARY KEY     NOT NULL," +
		                 				"FIRSTNAME       TEXT    NOT NULL, " + 
		                 				"SURNAME         TEXT    NOT NULL, " + 
		                 				"BIRTHDATE       CHAR(10)," + 
		                 				"ADDRESS         TEXT    NOT NULL," +
		                 				"POSTALCODE      INT     NOT NULL," +
		                 				"PLACE           TEXT    NOT NULL," +
		                 				"MEDICALHISTORY  TEXT    NOT NULL)";
	
	public SQLiteDatabaseModel(){
		try {
			Class.forName("org.sqlite.JDBC");
			this.connection_m = DriverManager.getConnection("jdbc:sqlite:Patients.db");
			stmt = this.connection_m.createStatement();
			String sql = CREATE_TABLE; 
		    stmt.executeUpdate(sql);
		    stmt.close();
		    this.connection_m.close();

		} catch (Exception e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	}
	
	public void addPatient(PatientModel patient) throws SQLException{
		String sql = "INSERT INTO flights (ID,FIRSTNAME,SURNAME) VALUES('"+ patient.getPatientID_m() +"','"+ patient.getFirstName_m() + "','"+ patient.getSurname_m() + "','" + patient.getBirthdate_m() + "','" + patient.getAddress_m() + patient.getPostalCode_m() + "','" + patient.getPlace_m() + patient.getMedicalHistory_m() + "')";
		//this.connection_m.prepareStatement(sql)
		stmt.executeQuery(sql);

	}
}
