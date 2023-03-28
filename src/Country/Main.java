package Country;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static boolean initial_loop = true;
    static String db;
    static String user = "sa";
    static String pass = "root";
    static Connection con = null;
    static boolean project = true;
	static ArrayList<MenuItem> menuList = new ArrayList<MenuItem>(); 
	public static void setDBName(String db_name) {
        Main.db = db_name;
    }

    public static String getDBName() {
        return db;
    }
    
	public static void main(String[] args) {
		initial_database();
        createTable();
		Array();
		while(project) {
        	try {
        		System.out.printf("%30s%n","_______________________________________");
        		System.out.printf("%17s %11s%n","Menu Option","");
        		System.out.printf("%30s%n","---------------------------------------");
        		for (int i = 0; i < menuList.size(); i++){
        			System.out.println("    "+(i+1) + "- " + menuList.get(i).actionName);
                }
        		System.out.printf("%30s%n","_______________________________________");
        		System.out.println();
        		
                System.out.print("Enter Number of Option: ");
                int option = scan.nextInt();
                System.out.printf("%30s%n","_____________________________");
                if(option >0 && option <= menuList.size()) {
                	option = option - 1;
                	menuList.get(option).action();	   	 
	 			    }
	 			    else {
	 			    	System.out.println(" ________________________________________________");
	 			    	System.out.println("|   Invalid number, please enter a valid number  |");
	 			    	System.out.println("|________________________________________________|");
	 			    }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

	}
//  **************************************************************************************************************************
//  **********************     Create Database    ****************************************************************************    
//  **************************************************************************************************************************
	static void initial_database() {
    	String url = "jdbc:sqlserver://localhost:1433;" + "encrypt = true;" + "trustServerCertificate = true";
        try {
            while (initial_loop) {
                System.out.print("Enter DataBase Name: ");
                db = scan.next();

                Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                DriverManager.registerDriver(driver);
                Connection connection = DriverManager.getConnection(url, user, pass);
                Statement statement = connection.createStatement();
                String sql = "CREATE DATABASE " + db +";";
                statement.executeUpdate(sql);
                initial_loop = false;
            }
        } 
        catch (Exception e) {
            System.out.println("Some Error Happened >_< ");
        }
    }
    
//  **************************************************************************************************************************
//  **********************      Create Table      ****************************************************************************    
//  **************************************************************************************************************************    
    static void createTable() {
    	String url = "jdbc:sqlserver://localhost:1433;" + "databaseName =" + db +";" + "encrypt = true;" + "trustServerCertificate = true";
    	String user = "sa";
		String pass = "root";
	    Connection con = null;
        try {
        	Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);
            con = DriverManager.getConnection(url, user, pass);

            Statement st = con.createStatement();

            String sql_university= "IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'Country') "
                    + "CREATE TABLE Country(\r\n"
                    + "    id INT PRIMARY KEY IDENTITY(1,1),\r\n"
                    + "    common VARCHAR(200), \r\n"
                    + "    official VARCHAR(200),"
                    + "    nativeName VARCHAR(200),"
                    + "    language_common VARCHAR(200),"
                    + "    language_official VARCHAR(200)"
                    + ");";
            st.executeUpdate(sql_university);
            con.close();
        }
	        catch (Exception ex) {
	            //System.out.println("Something Error Happened -_- ");
	        	System.err.println(ex);
	        }		
			
		}
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
