

public class MyBotMain {
	public static void main(String[] args) throws Exception {
		 // Now start our bot up.
		MyBot bot = new MyBot();
		// Enable debugging output.
		bot.setVerbose(true);
		// connects chatbox with freenode.net
		bot.connect("chat.freenode.net");
		// joins channel
		bot.joinChannel("#myowncha6778989"); 
		bot.sendMessage("#testbot","Please enter the word weather followed by city name for current weather updates or to learn more about about your location based on your ip address type location!");

	}
}