import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class OpenWeatherBot {

	
	// api endpoint for weather app
	private static final String endpoint = "http://api.openweathermap.org/data/2.5/weather?q=%s&APPID=%s";
	// api key for weather app
	private static final String accessID = "c856fd3bb80425b6d7b75f0aae5b1ed3";


	// call to api to get weather info 
	public static OpenWeatherData getWeather(String location) { // requests data from website 
		try {

			URL url = new URL(String.format(endpoint, location, accessID));

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");


			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder result = new StringBuilder();

			String line;
			while ((line = reader.readLine()) != null) { // reads the information 
				result.append(line);
			}
			reader.close();


			return parseJSON(result.toString());

		} catch (Exception e) { // if info is not gathered 
			System.out.println("Failed to gather info");
		}

		return null;
	}

	private static OpenWeatherData parseJSON(String json) {

		double temperature,highOfDay, lowOfday;
		String location;
		JsonObject object = new JsonParser().parse(json).getAsJsonObject();


		JsonObject main = object.getAsJsonObject("main");


		 temperature = main.get("temp").getAsDouble();
		 highOfDay = main.get("temp_max").getAsDouble();
		 lowOfday = main.get("temp_min").getAsDouble();

		//takes location
		location = object.get("name").getAsString();

		return new OpenWeatherData(temperature, highOfDay, lowOfday, location);
	}

}