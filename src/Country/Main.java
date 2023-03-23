package Country;

import java.util.*;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static boolean project = true;
	static ArrayList<MenuItem> menuList = new ArrayList<MenuItem>(); 
	public static void main(String[] args) {
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
	public static void Array()
    {
    	menuList.add(new Fetch_Data());
//    	menuList.add(new ListOfUniversity());
//    	menuList.add(new BackupOfDB());
//    	menuList.add(new FetchData());
//    	menuList.add(new SelectData());
//    	menuList.add(new SaveInFile());
//    	menuList.add(new FetchDataFromFile());
//    	menuList.add(new RemoveTable());
//	    menuList.add(new Exit());
    }

}
