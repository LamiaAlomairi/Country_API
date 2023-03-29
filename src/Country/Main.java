package Country;

import java.sql.*;
import java.util.*;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static boolean initial_loop = true;
    static String db;
    static String user = "sa";
    static String pass = "root";
    static boolean project = true;
	static ArrayList<MenuItem> menuList = new ArrayList<MenuItem>(); 
// ******************************************************************
	public static void setDBName(String db_name) {
        Main.db = db_name;
    }

    public static String getDBName() {
        return db;
    }
 // ******************************************************************    
	public static void main(String[] args) {
		initial_database();
        createTable();
		Array();
		while(project) {
        	try {
        		System.out.println("_____________________________________________");
        		System.out.println("           Menu Option   ");
        		System.out.println("---------------------------------------------");
        		for (int i = 0; i < menuList.size(); i++){
        			System.out.println("    "+(i+1) + "- " + menuList.get(i).actionName);
                }
        		System.out.println("_____________________________________________");
        		System.out.println();
        		
                System.out.print("Enter Number of Option: ");
                int option = scan.nextInt();
                if(option >0 && option <= menuList.size()) {
                	option = option - 1;
                	menuList.get(option).action();	   	 
	 			    }
	 			    else {
	 			    	System.out.println("Invalid number, please enter a valid number  ");
	 			    }
            }
            catch(Exception e) {
            	System.out.println("Some Error Happened >_< ");
            }
        }

	}
	
//  **********     Create Database    ********************************************************************    
	static void initial_database() {
		try {
		    String url = "jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true";
		    while (initial_loop) {
		        System.out.print("Enter database name: ");
		        db = scan.next();
		        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		        Driver driver = new SQLServerDriver();
		        DriverManager.registerDriver(driver);
		        try (Connection con = DriverManager.getConnection(url, user, pass);
		             Statement st = con.createStatement();) {
		            String sql = "IF NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = '"+ db +"')"
		       		     + "BEGIN"
		    		     + "    CREATE DATABASE "+ db +";"
		    		     + "END;";

		            st.executeUpdate(sql);
		            initial_loop = false;
		        }
		    }
		} catch (Exception e) {
		    System.out.println("Error: " + e.getMessage());
		}
    }
    
//  *********      Create Table      *************************************************************     
    static void createTable() {
    	String url = "jdbc:sqlserver://localhost:1433; databaseName =" + db +"; encrypt = true; trustServerCertificate = true";
	    Connection con = null;
        try {
        	Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);
            con = DriverManager.getConnection(url, user, pass);

            Statement st = con.createStatement();

            String sql_country= "IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'Country') "
                    + "CREATE TABLE Country("
                    + "    id INT PRIMARY KEY IDENTITY(1,1),"
                    + "    common VARCHAR(200),"
                    + "    official VARCHAR(200),"
                    + "    nativeName VARCHAR(200),"
                    + "    language_common VARCHAR(200),"
                    + "    language_official VARCHAR(200)"
                    + ");";
            st.executeUpdate(sql_country);
            con.close();
        }
	        catch (Exception ex) {
	        	System.out.println("Error: " + ex.getMessage());
	        }	
		}
    
// **************************************************************
	public static void Array() {
    	menuList.add(new Fetch_Data());
//    	menuList.add(new ListOfUniversity());
//    	menuList.add(new BackupOfDB());
//    	menuList.add(new FetchData());
//    	menuList.add(new SelectData());
//    	menuList.add(new SaveInFile());
//    	menuList.add(new FetchDataFromFile());
//    	menuList.add(new RemoveTable());
	    menuList.add(new Exit());
    }

}
