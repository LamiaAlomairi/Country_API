package Country;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

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
                
                
                JsonObject currenciesObj = jsonObject.getAsJsonObject("currencies");
                if (currenciesObj != null) {
                    JsonObject GTQeObj = currenciesObj.getAsJsonObject("GTQ");
                    if (GTQeObj != null) {
                        String namee = GTQeObj.get("name").getAsString();
                        String symbol = GTQeObj.get("symbol").getAsString();
                        // do something with the name and symbol fields
                    }
                }
                System.out.printf("%-45s %-60s %-280s %-50s %-50s %-50s %-50s %-50s %-50s %-50s %-50s %-50s%n",common,official,nativeNameObj,tld,cca2,ccn3,cca3,
                		cioc,independent,status,unMember,currenciesObj);
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		} catch (Exception e) {
            e.printStackTrace();
          }
		
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

            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(response.toString()).getAsJsonArray(); // parse the response into a JsonArray
            for (JsonElement element : jsonArray) {
                JsonObject jsonObject = element.getAsJsonObject();
                String common = null;
                String official = null;
                String nativeNameCommon = null;
                String languageOfficial = null;
                String languageCommon = null;

                JsonObject nameObj = jsonObject.getAsJsonObject("name");
                if (nameObj != null) {
                    JsonElement commonElement = nameObj.get("common");
                    if (commonElement != null) {
                        common = commonElement.getAsString();
                    }
                    
                    JsonElement officialElement = nameObj.get("official");
                    if (officialElement != null) {
                        official = officialElement.getAsString();
                    }
                    
                    JsonObject nativeNameObj = nameObj.getAsJsonObject("nativeName");
                    if (nativeNameObj != null) {
                        JsonObject languageObj = nativeNameObj.getAsJsonObject("Language");
                        if (languageObj != null) {
                            languageOfficial = languageObj.get("official").getAsString();
                            languageCommon = languageObj.get("common").getAsString();
                            nativeNameCommon = common;
                        }
                    }


                }


                JsonArray tldArray = jsonObject.getAsJsonArray("tld");
                List<String> tldList = new ArrayList<>();
                if (tldArray != null) {
                    for (JsonElement tldElement : tldArray) {
                        tldList.add(tldElement.getAsString());
                    }
                }
                String tld = String.join(",", tldList);


                String cca2 = jsonObject.getAsJsonPrimitive("cca2").getAsString();

                JsonPrimitive ccn3Primitive = jsonObject.getAsJsonPrimitive("ccn3");
                int ccn3 = ccn3Primitive != null ? ccn3Primitive.getAsInt() : 0;


                String cca3 = jsonObject.getAsJsonPrimitive("cca3").getAsString();

                String cioc = null;
                JsonPrimitive ciocPrimitive = jsonObject.getAsJsonPrimitive("cioc");
                if (ciocPrimitive != null) {
                    cioc = ciocPrimitive.getAsString();
                }

                JsonPrimitive independentPrimitive = jsonObject.getAsJsonPrimitive("independent");
                boolean independent = independentPrimitive != null ? independentPrimitive.getAsBoolean() : false;


                String status = jsonObject.getAsJsonPrimitive("status").getAsString();

                JsonPrimitive unMemberPrimitive = jsonObject.getAsJsonPrimitive("unMember");
                boolean unMember = unMemberPrimitive != null ? unMemberPrimitive.getAsBoolean() : false;


                double GTQ = 0.0;
                JsonObject currenciesObj = jsonObject.getAsJsonObject("currency");
                if (currenciesObj != null) {
                    JsonArray currenciesArray = currenciesObj.getAsJsonArray("GTQ");
                    if (currenciesArray != null) {
                        JsonObject currencyObj = currenciesArray.get(0).getAsJsonObject();
                        GTQ = currencyObj.get("rate").getAsDouble();
                    }
                }
                String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName="+Main.db+";encrypt=true;trustServerCertificate=true";
                String DB_USER = "sa";
                String DB_PASSWORD = "root";
                // store data in the database
                try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                    String sql = "INSERT INTO Country (common, official, nativeName, language_common, language_official) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement statement = conn.prepareStatement(sql);
                    statement.setString(1, common);
                    statement.setString(2, official);
                    statement.setString(3, nativeNameCommon);
                    statement.setString(4, languageOfficial);
                    statement.setString(5, languageCommon);

                    con.disconnect();
                    conn.close();
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
	}
}
            /*try {
                URL urll = new URL("https://restcountries.com/v3.1/all");
                HttpURLConnection conn = (HttpURLConnection) urll.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");

                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
                }

                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                String output;
                StringBuilder json = new StringBuilder();

                while ((output = br.readLine()) != null) {
                    json.append(output);
                }

                conn.disconnect();

                // Parse the JSON data and insert it into the local database
                Gson gson = new Gson();
                Country[] countries = gson.fromJson(json.toString(), Country[].class);

                if (countries.length == 0) {
                    System.out.println("No universities available in the selected country.");
                } else {
                    String url2 = "jdbc:sqlserver://localhost:1433;" + "databaseName = " + Main.db + ";" +
                            "encrypt = true;" + "trustServerCertificate = true";
                    con = (HttpURLConnection) DriverManager.getConnection(url2, user, pass);
                    String sql = "INSERT INTO Country (common, official, nativeName, language_official, language_common) " +
                            "VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement pstmt = ((Connection) con).prepareStatement(sql);
                    
                    for (Country cou : countries) {
                    	pstmt.setString(2, cou.get_name().get_common());
                    	pstmt.setString(3, cou.get_name().get_official());
                    	pstmt.setString(4, cou.get_name().get_nativeName().getSpanish().toString());
                    	pstmt.setString(5, cou.get_name().get_nativeName().getSpanish().getCommon());
                    	pstmt.setString(6, cou.get_name().get_nativeName().getSpanish().getOfficial());
                        pstmt.executeUpdate();
                    }

                    pstmt.close();
                    ((Connection) con).close();
                    System.out.println("Backup is complete.");
                }

            } catch (Exception e) {
                // Handle exceptions
                e.printStackTrace();
            }*/
		
		
