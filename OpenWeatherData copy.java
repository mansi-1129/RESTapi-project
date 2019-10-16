
public class OpenWeatherData {

	
	private String location;

	private double temperature;
	private double highOfTheDay;
	private double lowOfTheDay;
	
     // constuctor for functions
	public OpenWeatherData(double currentTemp, double high, double low, String location) {
		setTemperature(currentTemp);
		setLocation(location);
		setHighOfTheDay(high);
		setlowOfTheDay(low);
		
	}
	public void setHighOfTheDay(double highOfTheDay1) { // converts high of the day to fehrenheight
		highOfTheDay = ((highOfTheDay1 - 273.15) * 1.8) + 32;
	}
	public void setlowOfTheDay(double low1) {
		lowOfTheDay = ((low1- 273.15) * 1.8) + 32;
	}

	public String toString() {

		return String.format("The weather at " + location + " : ") + String.format("The current temperature is %.1f°F. The high is %.1f°F and the low is %.1f°F.",temperature, highOfTheDay, lowOfTheDay);
	}

// sets temp
	public void setTemperature(double temperature1) {
		temperature = (temperature1 - 273.15) * 1.8 + 32;
	}
// sets location
	public void setLocation(String location1) {
		location = location1;
	}
}
