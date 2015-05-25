package ch.gbssg.pave.model;

import java.sql.*;
import java.util.ArrayList;

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
	private final String INSERT=        "INSERT INTO PATIENTS (ID,FIRSTNAME,BIRTHDATE,ADDRESS,POSTALCODE,PLACE,MEDICALHISTORY) VALUES(?,?,?,?,?,?,?)";
	
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
		PreparedStatement statement = connection_m.prepareStatement(INSERT); 
		statement.setInt(1,patient.getID());
	    statement.setString(2,patient.getFirstName());
	    statement.setString(3,patient.getBirthdate());
	    statement.setString(4,patient.getAddress());
	    statement.setInt(5,patient.getPostalCode());
	    statement.setString(6,patient.getPlace());
	    statement.setString(7,patient.getMedicalHistory());
		statement.executeUpdate();
		
		this.connection_m.commit();
	}
	
	public ArrayList<PatientModel> getPatients(){
		ArrayList<PatientModel> patients = new ArrayList<PatientModel>();
		PatientModel patient;
		try { 
			ResultSet rs = stmt.executeQuery("SELECT * FROM PATIENTS;"); 
			stmt = this.connection_m.createStatement();
	        while(rs.next()) {
	        	patient=new PatientModel(rs.getString("FIRSTNAME"), rs.getString("SURNAME"), rs.getString("BIRTHDATE"), rs.getString("ADDRESS"), rs.getInt("POSTALCODE"), rs.getString("PLACE"), rs.getString("MEDICALHISTORY"));
	        	patient.setID(rs.getInt("ID"));
	        	patients.add(patient);
	            
	        }
	        rs.close(); 
			this.connection_m.commit();
		}catch(SQLException e){
			System.err.println("Couldn't handle DB-Query"); 
            e.printStackTrace(); 
		}
		return(patients);
	}
}
