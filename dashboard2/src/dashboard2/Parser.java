package dashboard2;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Parser {
	String bpm;
	long lastid;
	static long lastentry;
	
	public String[] jsonparse(String str)
    {   
		String[] values = new String[1];
        Object obj = null;
        
		obj = new JSONValue().parse(str);
          
        // typecasting obj to JSONObject
        
        JSONObject jo = (JSONObject) obj;
        @SuppressWarnings("unchecked")
		Map<String, String> ch = ((Map<String, String>)jo.get("channel"));
        Iterator<Map.Entry<String, String>> itr1 = ch.entrySet().iterator();
        
        while (itr1.hasNext()) {
            Map.Entry pair = itr1.next();
            if (pair.getKey().equals("last_entry_id")) {
            	this.lastid = (long) pair.getValue();
            }
            //System.out.println(pair.getKey() + " : " + pair.getValue());
        lastentry = lastid;
            
        }
        JSONArray feeds = (JSONArray)(jo.get("feeds"));
    
         		
        
        if(feeds.toString().contains("\"entry_id\":"+String.valueOf(lastid)))
        {
        	Iterator<JSONObject> it = feeds.iterator();
        	while (it.hasNext()) {
        	JSONObject j = it.next();
        	if (j.get("entry_id").equals(lastid)) {	
        	try {
    			
    			
    			bpm = (String) j.get("field2");
    			
    			
    		}
    		catch(NoSuchElementException e) {
    			continue;
    		}
        	}
        }
        	
        	
        }
        values = new String[]{bpm};
		return values;
        
        
    }
}
	