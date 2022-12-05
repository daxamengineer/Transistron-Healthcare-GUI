package dashboard2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class creation {
public void create() {
	String code="<!DOCTYPE html>\r\n"
			+ "<html>\r\n"
			+ "<head>\r\n"
			+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
			+ "<style>\r\n"
			+ "body {\r\n"
			+ "  margin: 0;\r\n"
			+ "  font-family: Arial, Helvetica, sans-serif;\r\n"
			+ "  background-image: url('C:\\Users\\msi\\OneDrive\\Desktop\\pngtree-hexagonal-molecular-structure-health-care-light-effect-blue-gradient-background-image_907495.png');\r\n"
			+ "  background-repeat: no-repeat;\r\n"
			+ "  background-attachment: fixed;\r\n"
			+ "  background-size: cover;\r\n"
			+ "}\r\n"
			+ "\r\n"
			+ ".topnav {\r\n"
			+ "  overflow: hidden;\r\n"
			+ "  background-color: #333;\r\n"
			+ "}\r\n"
			+ "\r\n"
			+ ".topnav a {\r\n"
			+ "  float: left;\r\n"
			+ "  color: #f2f2f2;\r\n"
			+ "  text-align: center;\r\n"
			+ "  padding: 14px 16px;\r\n"
			+ "  text-decoration: none;\r\n"
			+ "  font-size: 17px;\r\n"
			+ "}\r\n"
			+ "\r\n"
			+ ".topnav a:hover {\r\n"
			+ "  background-color: #ddd;\r\n"
			+ "  color: black;\r\n"
			+ "}\r\n"
			+ "\r\n"
			+ ".topnav a.active {\r\n"
			+ "  background-color: #f94bff;\r\n"
			+ "  color: white;\r\n"
			+ "}\r\n"
			+ "\r\n"
			+ ".logoutLblPos{\r\n"
			+ "\r\n"
			+ "  position:fixed;\r\n"
			+ "  right:100px;\r\n"
			+ "  top : 5px;\r\n"
			+ "}\r\n"
			+ "\r\n"
			+ "</style>\r\n"
			+ "</head>\r\n"
			+ "<body>\r\n"
			+ "\r\n"
			+ "<div class=\"topnav\">\r\n"
			+ "  <a class=\"active\" href=\"#home\">Home</a>\r\n"
			+ "  <!-- <a href=\"#logout\">Log Out</a> -->\r\n"
			+ "</div>\r\n"
			+ "\r\n"
			+ "<div style=\"padding-left:16px\">\r\n"
			+ "  <h1 color=\"#a932ad\">Patients Data</h1>\r\n"
			+ "  <center>\r\n"
			+ "    <table border=\"4\" bordercolor=\"#a932ad\" width=\"60%\">\r\n"
			+ "    <tr><td colspan=\"2\">\r\n"
			+ "    <h2 align=\"center\" color=\"#00FFFF\">BPM And Ultrasonic Data Monitoring Dashboard</h2>\r\n"
			+ "    </td></tr>\r\n"
			+ "    <tr><td>\r\n"
			+ "    <center>\r\n"
			+ "    <iframe width=\"450\" height=\"260\" style=\"border: 2px solid #0d0c0c;\" src=\"https://thingspeak.com/channels/1886709/charts/2?bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=10&type=line&update=15\"></iframe>\r\n"
			+ "    </td>\r\n"
			+ "    </tr>\r\n"
			+ "    <tr><td>\r\n"
			+ "    </center>\r\n"
			+ "    <center>\r\n"
			+ "    <iframe width=\"450\" height=\"260\" style=\"border: 2px solid #0d0c0c;\" src=\"https://thingspeak.com/channels/1886709/charts/1?bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=10&type=line&update=15\"></iframe>\r\n"
			+ "    </td>\r\n"
			+ "    </table>\r\n"
			+ "    </center>\r\n"
			+ "    </center>\r\n"
			+ "    <p>\r\n"
			+ "        <p>\r\n"
			+ "\r\n"
			+ "        </p>\r\n"
			+ "    </p>\r\n"
			+ "</div>\r\n"
			+ "\r\n"
			+ "</body>\r\n"
			+ "</html>";
	
	File f = new File("C:\\Users\\msi\\eclipse-workspace\\dashboard2\\src\\dashboard2\\dash.html");
	try {
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		bw.write(code);
		bw.close();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
