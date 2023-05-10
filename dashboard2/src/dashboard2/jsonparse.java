package dashboard2;

import java.io.BufferedReader;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;


class jsonparse {
	StringBuffer response = new StringBuffer();
    
	
    	
		public void StartParsing() throws Exception {
    		String cmnd = "http://api.thingspeak.com/channels/1886709/feed.json";
    		URL obj = new URL(cmnd);
    		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    		con.setRequestMethod("GET");
    		int responseCode = con.getResponseCode();
    		System.out.println("GET Response Code :: " + responseCode);
    		if (responseCode == HttpURLConnection.HTTP_OK) { // success
    			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    			String inputLine;
    			response = new StringBuffer();

    			while ((inputLine = in.readLine()) != null) {
    				response.append(inputLine);
    			}
    			in.close();
    			File f = new File("data.txt");
    			FileWriter fw = new FileWriter("data.txt");
    			fw.write(response.toString());
    			// print result
    			//System.out.println(response.toString());
    			
    		} 
    		else {
    			System.out.println("GET request not worked");
    		}
    	}
		
		public String[] Readvalues() throws Exception{
			String txt = response.toString();
			Parser p = new Parser();
			String[] values = p.jsonparse(txt);
			
			return values;
		}
}