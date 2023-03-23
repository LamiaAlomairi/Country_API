package Country;

import java.io.*;
import java.net.*;

import com.google.gson.*;

public class Fetch_Data extends MenuItem{

	Fetch_Data(){
		this.actionName = "Fetch Data From API";
	}
	
	public void action() {
		try {
            // Send GET request to API endpoint
            URL url = new URL("https://restcountries.com/v3.1/all");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            // Read response from API endpoint
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();

            // Parse JSON response and display as table
            JsonArray countries = new JsonArray();
            System.out.format("| %-25s | %-20s | %-15s | %-15s | %-10s |\n",
                    "Name", "tld", "cca2", "ccn3", "cca3");
            System.out.println("-".repeat(87));
            for (int i = 0; i < countries.size(); i++) {
                JsonObject country = countries.getAsJsonObject();
                String name = country.getAsJsonObject("name").getAsString();
                JsonArray tld = country.getAsJsonObject("tld").getAsJsonArray();
                String cca2 = country.getAsJsonObject("cca2").getAsString();
                int ccn3 = country.getAsJsonObject("ccn3").getAsInt();
                String cca3 = country.getAsJsonObject("cca3").getAsString();
                System.out.format("| %-25s | %-20s | %-15s | %-15s | %-10d |\n",
                        name, tld, cca2, ccn3, cca3);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
