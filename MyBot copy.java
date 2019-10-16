// first api: weather: user enters city name and then current, high and low temperature of the day is displayed
// second api: location information: users ip address is used to display information such as city, state, coordinates and more
//https://ipapi.co/

import org.jibble.pircbot.PircBot;

import java.io.*;
import java.net.*;

public class MyBot extends PircBot {

	public MyBot() {
		this.setName("kyy32");
	}

	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		message = message.toLowerCase();

		String location;
		String[] statement = message.split(" ");

		if (message.contains("weather")) {

			location = statement[1]; // the second word is equal to the location

			OpenWeatherData object = OpenWeatherBot.getWeather(location);

			if (object == null) {

				sendMessage(channel, "The weather API is currently not functioning");

			}

			String weather = object.toString();

			sendMessage(channel, weather);
		} else {
			if (message.contains("location")) { // call to second API return data based on ip address of user 

				try {

					URL ipapi = new URL("https://ipapi.co/json/");

					URLConnection connection = ipapi.openConnection();
					connection.setRequestProperty("User-Agent", "java-ipapi-client");
					BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					sendMessage(channel, "Info about your current location: ");

					String line;
					while ((line = reader.readLine()) != null) {

						sendMessage(channel, line); // starts displaying info

					}
					reader.close();

				} catch (MalformedURLException e) {

					e.printStackTrace();

				} catch (IOException e) {

					e.printStackTrace();

				}

			} else { // if the user doesnt use the words weather or location
				sendMessage(channel, "Your statement must include weather or location");
			}

		}

	}

}
