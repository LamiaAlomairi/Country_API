package Country;

import java.io.*;
import java.net.*;
import java.util.List;

import com.google.gson.*;

public class Fetch_Data extends MenuItem{

	Fetch_Data(){
		this.actionName = "Fetch Data From API";
	}
	
	public void action() {
		try {
            URL url = new URL("https://restcountries.com/v3.1/all");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
              response.append(inputLine);
            }
            in.close();

            System.out.println(response.toString()); // print the response

            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(response.toString()).getAsJsonArray(); // parse the response into a JsonArray
            System.out.printf("%-45s %-60s %-280s %-50s %-50s %-50s %-50s %-50s %-50s %-50s %-50s %-50s%n","common","official","nativeName", "tld", "cca2", "ccn3", "cca3",
            		"cioc", "independent", "status", "unMember", "GTQ");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                String common = jsonObject.getAsJsonObject("name").get("common").getAsString(); // extract the name
                String official = jsonObject.getAsJsonObject("name").get("official").getAsString();
                
                JsonObject nativeNameObj = jsonObject.getAsJsonObject("name").getAsJsonObject("nativeName");
                if(nativeNameObj != null){
                    JsonObject languageObj = nativeNameObj.getAsJsonObject("Language");
                    if(languageObj != null){
                        String officiall = languageObj.get("official").getAsString();
                        String commonn = languageObj.get("common").getAsString();
                    }
                }
                
                JsonElement tldElement = jsonObject.get("tld");
                JsonArray tld = tldElement != null ? tldElement.getAsJsonArray() : null;
                JsonElement cca2Element = jsonObject.get("cca2");
                String cca2 = cca2Element != null ? cca2Element.getAsString() : null;
                JsonElement ccn3Element = jsonObject.get("ccn3");
                int ccn3 = ccn3Element != null ? ccn3Element.getAsInt() : 0;
                JsonElement cca3Element = jsonObject.get("cca3");
                String cca3 = cca3Element != null ? cca3Element.getAsString() : null;
                JsonElement ciocElement = jsonObject.get("cioc");
                String cioc = ciocElement != null ? ciocElement.getAsString() : null;
                JsonElement independentElement = jsonObject.get("independent");
                boolean independent = independentElement != null ? independentElement.getAsBoolean() : false;
                JsonElement statusElement = jsonObject.get("status");
                String status = statusElement != null ? statusElement.getAsString() : null;
                JsonElement unMemberElement = jsonObject.get("unMember");
                boolean unMember = unMemberElement != null ? unMemberElement.getAsBoolean() : false;
                
                JsonObject GTQeObj = jsonObject.getAsJsonObject("currencies").getAsJsonObject("GTQ");
                if (GTQeObj != null && !GTQeObj.isJsonNull()) { // Check if GTQeObj exists and is not null
                	JsonElement nameeElement = GTQeObj.get("name");
                    String namee = nameeElement != null ? ciocElement.getAsString() : null;
                    JsonElement symbolElement = GTQeObj.get("symbol");
                    if (symbolElement != null && !symbolElement.isJsonNull()) { // Check if symbolElement exists and is not null
                        char symboll = symbolElement.getAsString().charAt(0);
                        System.out.printf("%-50s %-50c%n", namee, symboll);
                    }
                } else {
                    System.out.printf("%-50s %-50c%n", "N/A", 'N'); // If GTQeObj does not exist, print N/A values
                }

                
                System.out.printf("%-45s %-60s %-280s %-50s %-50s %-50s %-50s %-50s %-50s %-50s %-50s %-50s%n",common,official,nativeNameObj,tld,cca2,ccn3,cca3,
                		cioc,independent,status,unMember,GTQeObj);
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
          } catch (Exception e) {
            e.printStackTrace();
          }
	}
}
