package dashboard2;

import java.awt.EventQueue;

public class main {
	public static void main(String[] args) throws Exception {
		creation obj1= new creation();
		
		obj1.create();
		
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    loginpage2 frame = new loginpage2();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }
		
	}


