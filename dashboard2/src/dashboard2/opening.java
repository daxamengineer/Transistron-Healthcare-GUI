package dashboard2;


import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class opening {
	public void open() throws Exception {
		String URL="C:\\Users\\anish\\eclipse-workspace\\dashboard2\\src\\dashboard2\\dash.html";
		File file=new File(URL);
		Desktop.getDesktop().browse(file.toURI());
	}

}