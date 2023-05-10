package dashboard2;

import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class pat_manage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel panel;
    private JTextField textField;
    private JTextField textField_1;
	public JFrame frame;
    
    

   
    public pat_manage() throws Exception {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        final Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proto", "root", "root");
        frame = new JFrame();
        frame.setBackground(new Color(190, 252, 239));
		frame.setBounds(100, 100, 906, 529);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
		JPanel panel = new JPanel();
		panel.setBackground(new Color(53, 245, 205));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
        
        String[] choices = {"7:30 am-8:15 am","8:15 am-9:00 am","9:00 am-9:45 am","9:45 am-10:30 am","10:30 am-11:15 am","11:15 am-12:00 am","2:00 am-2:45 am","2:45 am-3:30 am","3:30 am-4:15 am","4:15 am-5:00 am","5:00 am-5:45 am","5:45 am-6:30 am"};
        String q1="select slot,count(*) from patreg group by slot;";
        String q2="select count(*) from patreg;";
        final Statement sta = connection.createStatement();
        ResultSet rs= sta.executeQuery(q2);
        int ct = 0;
        while (rs.next()) {
        	ct=rs.getInt("count(*)");
        }
        if(ct==48) {
        	JOptionPane.showMessageDialog(null, "<html>All other slots booked.Please try again tomorrow.</html>");
        	
   			
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
                 			List<String> list = new ArrayList<String>(Arrays.asList(choices));
                 			list.remove(x);
                 			choices = list.toArray(new String[0]);
                 			
                 		}
                 	} 
        		 }
        	 }
        }
        final JComboBox comboBox = new JComboBox(choices);
        comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        comboBox.setBounds(650, 163, 121, 25);
        panel.add(comboBox);
        comboBox.setVisible(false);
        
        JLabel lblNewLabel = new JLabel("Full Name");
        lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel.setBounds(33, 99, 117, 25);
        panel.add(lblNewLabel);
        
        textField = new JTextField();
        textField.setBounds(33, 135, 185, 19);
        panel.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Contact Information");
        lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel_1.setBounds(33, 168, 203, 37);
        panel.add(lblNewLabel_1);
        
        textField_1 = new JTextField();
        textField_1.setBounds(33, 206, 185, 19);
        panel.add(textField_1);
        textField_1.setColumns(10);
        
        JButton submit = new JButton("Submit");
        submit.setBackground(new Color(240, 240, 240));
        submit.setBorder(UIManager.getBorder("Button.border"));
        submit.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
        submit.setBounds(83, 248, 85, 21);
        panel.add(submit);
        
        
        final JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(130, 353, 620, 62);
        panel.add(scrollPane);
        scrollPane.setVisible(false);
        
        final JTable table = new JTable();
        scrollPane.setViewportView(table);
        
        final JLabel lblNewLabel_2 = new JLabel("YOUR SLOT");
        lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(384, 306, 117, 28);
        panel.add(lblNewLabel_2);
        lblNewLabel_2.setVisible(false);
        
        final JButton change = new JButton("CHANGE SLOT");
        change.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
        change.setBounds(250, 441, 137, 21);
        panel.add(change);
        change.setVisible(false);
        
        final JButton cancel = new JButton("CANCEL SLOT");
        cancel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
        cancel.setBounds(500, 441, 151, 21);
        panel.add(cancel);
        cancel.setVisible(false);
        
        final JLabel lblNewLabel_3 = new JLabel("Edit Your Appointment");
        lblNewLabel_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(583, 52, 249, 25);
        panel.add(lblNewLabel_3);
        lblNewLabel_3.setVisible(false);
        
        final JLabel lblNewLabel_4 = new JLabel("Choose A slot");
        lblNewLabel_4.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel_4.setBounds(650, 114, 137, 25);
        panel.add(lblNewLabel_4);
        lblNewLabel_4.setVisible(false);
        
        final JButton confirm = new JButton("Confirm");
        confirm.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
        confirm.setBounds(658, 236, 95, 21);
        panel.add(confirm);
        
        JLabel lblNewLabel_5 = new JLabel("Details");
        lblNewLabel_5.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
        lblNewLabel_5.setBounds(83, 52, 85, 25);
        panel.add(lblNewLabel_5);
        
		ImageIcon backgroundd =new ImageIcon("C:\\Users\\anish\\eclipse-workspace\\dashboard2\\src\\dashboard2\\filler.png");
        Image imagee=backgroundd.getImage();
        Image tem=imagee.getScaledInstance(170, 150, Image.SCALE_SMOOTH);
        backgroundd=new ImageIcon(tem);
        
        final JLabel lblNewLabel_7 = new JLabel(backgroundd);
        lblNewLabel_7.setBounds(332, 67, 218, 188);
        panel.add(lblNewLabel_7);
        lblNewLabel_7.setVisible(false);
        
        JButton btnNewButton = new JButton("Go Back");
        btnNewButton.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
        btnNewButton.setBounds(795, 11, 85, 19);
        panel.add(btnNewButton);
        
        ImageIcon bg = new ImageIcon("C:\\Users\\anish\\eclipse-workspace\\dashboard2\\src\\dashboard2\\doct.png");
        Image i = bg.getImage();
        Image t = i.getScaledInstance(500, 300, Image.SCALE_SMOOTH);
        bg = new ImageIcon(t);
        
        final JLabel label = new JLabel(bg);
        label.setBounds(314, 114, 545, 455);
        panel.add(label);
        
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.setVisible(false);
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
        confirm.setVisible(false);
        
        submit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            	
            		String name1=textField.getText();
            		String contact1=textField_1.getText();
            		
                	long contacted=0;
                	int confirmflag=1;
            	try {
            		contacted=Long.parseLong(contact1);
                	}
                	catch (NumberFormatException e2) {
                		JOptionPane.showMessageDialog(null, "<html>Please enter a numerical format for Contact Information.</html>");
                		confirmflag=0;
                	}
            	if (name1.equals("") || contact1.equals("")) {
            		JOptionPane.showMessageDialog(null, "<html>Invalid Entries.</html>");
            		confirmflag=0;
            	}
            	
        		if (confirmflag==1){
        			
            	String q2="select * from patreg where name='"+name1+"' and  contact="+contact1+";";
            	String name;
				String age;
				String sex;
				String contact;
				String blood;
				String slot;
				String docid;
                try {
                	
					Statement st2=connection.createStatement();
					ResultSet sr=st2.executeQuery(q2);
					int patflag=0;
					if (sr.next()==false) {
						JOptionPane.showMessageDialog(null, "<html>No patient found with the given parameters.</html>");
						patflag=1;
						
					}
					if (patflag==0) {
						table.setModel(new DefaultTableModel());
						label.setVisible(false);
						lblNewLabel_7.setVisible(true);
						textField.setEnabled(false);
	            		textField_1.setEnabled(false);
						scrollPane.setVisible(true);
	                	lblNewLabel_2.setVisible(true);
	                	change.setVisible(true);
	                	cancel.setVisible(true);
					ResultSetMetaData rsm=sr.getMetaData();
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					int cols=rsm.getColumnCount();
					String[] col=new String[cols];
					for (int h=0;h<cols;h++) {
						col[h]=rsm.getColumnName(h+1);
					}
					model.setColumnIdentifiers(col);
					ResultSet sr2=st2.executeQuery(q2);
					while(sr2.next()) {
						name=sr2.getString(1);
						age=sr2.getString(2);
						sex=sr2.getString(3);
						contact=sr2.getString(4);
						blood=sr2.getString(7);
						slot=sr2.getString(5);
						docid=sr2.getString(6);
						String[] row= {name,age,sex,contact,slot,docid,blood};
						model.addRow(row);
					}
					
                }
					
                }
                catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            } 
        });
        
        change.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            	lblNewLabel_3.setVisible(true);
            	lblNewLabel_4.setVisible(true);
            	confirm.setVisible(true);
            	comboBox.setVisible(true);
            }
		});
        
        cancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            	int newresult = JOptionPane.showConfirmDialog(frame,"Are you sure?", "Cancel your appointment",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                     if(newresult == JOptionPane.YES_OPTION){
                    	 String name1=textField.getText();
                 		 String contact1=textField_1.getText();
                    	 String q4="delete from patreg where name='"+name1+"' and  contact="+contact1+";";
                         Statement sta;
						try {
							sta = connection.createStatement();
							sta.executeUpdate(q4);
							JOptionPane.showMessageDialog(null, "<html>Appointment Cancelled.</html>");
							ppage obj5=new ppage();
							obj5.frame.setVisible(true);
							frame.setVisible(false);
                         
						}
						catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                     }
                 
            }
		});
        
        confirm.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            	
		try {
			
			
			String name1=textField.getText();
    		String contact1=textField_1.getText();
			
			
			String docid = null;
			String docquery="select docID from patreg where slot='"+(String)comboBox.getSelectedItem()+"';";
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
                    	
                        String query = "update patreg set docID='"+docid+"',slot='"+(String)comboBox.getSelectedItem()+"' where name='"+name1+"' and contact="+contact1+";";
                        System.out.println(query);
                        JOptionPane.showMessageDialog(null, "<html>Slot Updated. Press Submit Button to view updated slot.</html>");
                        sta.executeUpdate(query); 
                        table.setModel(new DefaultTableModel());
                        
                    } 
    				catch (Exception exception) {
                        exception.printStackTrace();
                    }
		
            }
		});
    }
}