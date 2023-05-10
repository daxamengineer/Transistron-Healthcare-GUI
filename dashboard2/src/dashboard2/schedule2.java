package dashboard2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Panel;
import java.awt.Checkbox;
import java.awt.TextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JList;
import java.awt.List;
import javax.swing.JComboBox;

public class schedule2 {

	JFrame frame2;
	private JTextField txtFullName;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	


	public schedule2() throws Exception {
		initialize();
	}

	
	private void initialize() throws Exception {
		frame2 = new JFrame();
		frame2.setBounds(100, 100, 940, 541);
		frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(53, 245, 205));
		panel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frame2.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		ImageIcon background =new ImageIcon("C:\\Users\\anish\\eclipse-workspace\\dashboard2\\src\\dashboard2\\bg1.png");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(1000, 2000, Image.SCALE_SMOOTH);
        background=new ImageIcon(temp); // for Background Gradient
       
        String[] choices = {"7:30 A.M. - 8:15 A.M.","8:15 A.M. - 9:00 A.M.","9:00 A.M. - 9:45 A.M.","9:45 A.M. - 10:30 A.M.","10:30 A.M. - 11:15A.M.","11:15 A.M. - 12:00 P.M.","2:00 P.M. - 2:45 P.M.","2:45 P.M. - 3:30 P.M.","3:30 P.M. - 4:15 P.M.","4:15 P.M. - 5:00 P.M.","5:00 P.M. - 5:45 P.M.","5:45 P.M. - 6:30 P.M."};
		   
        final JComboBox comboBox = new JComboBox(choices);
        comboBox.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        comboBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        comboBox.setBounds(523, 239, 280, 29);
        comboBox.setVisible(true);
        
        String[] biosex= {"Male","Female"}; 
        
        String[] bloodchoice = {"B+","B-","O+","O-","A+","A-","AB+","AB-"};
        
        final JComboBox comboBox_2 = new JComboBox(bloodchoice);
        comboBox_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        comboBox_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		comboBox_2.setBounds(523, 159, 79, 29);
		panel.add(comboBox_2);
		
        JButton btnNewButton = new JButton("Cancel");
        btnNewButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        btnNewButton.setBounds(816, 19, 88, 21);
        panel.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame2.setVisible(false);
            	ppage ob;
        		try {
        			ob = new ppage();
        			ob.frame.setVisible(true);
        		} catch (Exception e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
        		
            	
            }
        });
        panel.add(comboBox);
        final JComboBox comboBox_1 = new JComboBox(biosex);
        comboBox_1.setFont(new Font("Segoe UI Semibold", comboBox_1.getFont().getStyle(), 14));
        comboBox_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		comboBox_1.setBounds(26, 146, 125, 29);
		panel.add(comboBox_1);
		
		
		JLabel lblNewLabel = new JLabel("Full Name");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(29, 29, 96, 39);
		panel.add(lblNewLabel);
		
		txtFullName = new JTextField();
		txtFullName.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFullName.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txtFullName.setText("");
		
		
		txtFullName.setBounds(24, 72, 280, 25);
		panel.add(txtFullName);
		txtFullName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Age");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(29, 195, 67, 30);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_1.setText("");
		
		textField_1.setBounds(29, 236, 277, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Sex");
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(29, 116, 45, 19);
		panel.add(lblNewLabel_2);
		
		
//		textField_2 = new JTextField();
//		textField_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
//		textField_2.setText("");
		
//		textField_2.setBounds(26, 152, 280, 26);
//		panel.add(textField_2);
//		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Contact Information");
		lblNewLabel_3.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setBounds(522, 35, 190, 26);
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		textField_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_3.setText("");
		
		textField_3.setBounds(523, 74, 280, 23);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Blood Type");
		lblNewLabel_4.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_4.setBounds(522, 114, 157, 19);
		panel.add(lblNewLabel_4);
		
		
		
		
		
		JLabel lblNewLabel_5 = new JLabel("Choose a slot for tomorrow");
		lblNewLabel_5.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_5.setBounds(522, 198, 241, 30);
		panel.add(lblNewLabel_5);
		
		
		
		
		JButton sub = new JButton("Submit");
		sub.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		sub.setBackground(new Color(232, 255, 250));
		sub.setBounds(397, 298, 103, 30);
		panel.add(sub);
		
		
		
		ImageIcon backgroundd =new ImageIcon("C:\\Users\\anish\\eclipse-workspace\\dashboard2\\src\\dashboard2\\filler4.png");
        Image imagee=backgroundd.getImage();
        Image tem=imagee.getScaledInstance(924, 150, Image.SCALE_SMOOTH);
        backgroundd=new ImageIcon(tem);
        
    	JLabel lblNewLabel_6 = new JLabel(backgroundd);
		lblNewLabel_6.setBounds(0, 353, 924, 150);
		panel.add(lblNewLabel_6);
		
		JLabel back=new JLabel(background);
		back.setForeground(Color.WHITE);
		back.setLayout(null);
		back.setBounds(0, 0, 924, 502);
		panel.add(back);
		
		
		
	
		
		Class.forName("com.mysql.cj.jdbc.Driver");
        final Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proto", "root", "root");
        String q1="select slot,count(*) from patreg group by slot;";
        String q2="select count(*) from patreg;";
        final Statement sta = connection.createStatement();
        ResultSet rs= sta.executeQuery(q2);
        int ct = 0;
        while (rs.next()) {
        	ct=rs.getInt("count(*)");
        }
        
        if(ct==48) {
        	JOptionPane.showMessageDialog(null, "<html>All slots booked.Please try again tomorrow.</html>");
        	
   			frame2.setVisible(false);
        }
        else {
        	ResultSet rs2= sta.executeQuery(q1);
        	 while (rs2.next()) {
        		 int slotcheck=rs2.getInt("count(*)");
        		 String buttoncheck=rs2.getString("slot");
        		 if (slotcheck>=4) {
        			 
                 	for (int i=0;i<choices.length;i++) {
                 		
                 		String x =choices[i];
                 		if (x.equals(buttoncheck)) {
                 			ArrayList<String> list = new ArrayList<String>(Arrays.asList(choices));
                 			list.remove(x);
                 			choices = list.toArray(new String[0]);
                 			
                 		}
                 	} 
        		 }
        	 }
        }
        
        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String name = txtFullName.getText();
            	String aged = textField_1.getText();
                String sex = (String)comboBox_1.getSelectedItem();
                String contacted = textField_3.getText();
                String blood =(String)comboBox_2.getSelectedItem();
                String docid=null;
                
                if ((name.equals("")) || (aged.equals("")) || (contacted.equals(""))) {
                	JOptionPane.showMessageDialog(null, "Invalid Entries");
                	
                }
                
                else {
                	int age=0;
                	long contact=0;
                	int confirmflag=1;
                	
                	try {
            		age=Integer.parseInt(aged);
            		contact=Long.parseLong(contacted);
                	}
                	catch (NumberFormatException e2) {
                		e2.printStackTrace();
                		JOptionPane.showMessageDialog(null, "<html>Please enter a numerical format in Age and Contact Information.</html>");
                		System.out.print(age+contact);
                		confirmflag=0;
                	}
                	if (confirmflag==1) {
            		JOptionPane.showMessageDialog(null, "Confirmed!");
            		frame2.setVisible(false);
      				String docquery="select docID from patreg where slot='"+(String)comboBox.getSelectedItem()+"';";
       				try {
            		ResultSet rslot= sta.executeQuery(docquery);
           			Boolean flag1=false;
           			Boolean flag2=false;
           			Boolean flag3=false;
           			Boolean flag4=false;
           			
            	  	while (rslot.next()) {
            	  		String doctor=rslot.getString("docID");
            	  		
            	  		
            	  		if (doctor.equals("D1")) {
            	  			flag1=true;
      	        		 	}
            	  		else if (doctor.equals("D2")) {
            	  			flag2=true;
            	 		 	}
            	  		else if (doctor.equals("D3")) {
            	  			flag3=true;
            	   		 	}
            	  		else if (doctor.equals("D4")) {
       	      			 	flag4=true;
       	      			 	} 
            	 	 	}
            	        	 if (flag1==false) {
            	        		 docid="D1";
            	        	 }
            	        	 else if (flag2==false) {
            	        		 docid="D2";
            	        	 }
            	        	 else if (flag3==false) {
            	        		 docid="D3";
            	        	 }
            	        	 else  if (flag4==false){
            	        		 docid="D4";
            	        	 }
                            	
                                String query = "INSERT INTO patreg values('"+name+"','"+age+"','"+sex+"','"+contact+"','"+(String)comboBox.getSelectedItem()+"','"+docid+"','"+blood+"');";
                                
                                sta.executeUpdate(query);                  
                                connection.close();
                            } 
            				catch (Exception exception) {
                                exception.printStackTrace();
                            }
       				
                            ppage obj3;
							try {
								obj3 = new ppage();
								obj3.frame.setVisible(true);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
                            
            				
                	}
            		}
                }
            
        });
		
	}
}