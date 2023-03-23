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

                
                System.out.printf("%-50s %-50s %-50s%n",common,official,nativeNameObj);
            }
          } catch (Exception e) {
            e.printStackTrace();
          }
	}
}
