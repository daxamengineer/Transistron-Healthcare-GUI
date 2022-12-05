package dashboard2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
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

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class ppage {

	JFrame frame;
	private JTextField textField;
	


	public ppage() throws Exception {
		initialize();
	}

	
	private void initialize() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proto", "root", "root");
		jsonparse t = new jsonparse();
		t.StartParsing();
		String[] arr = t.Readvalues();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 940, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(216, 239, 236));
		panel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Your BPM: "+arr[0]);
		lblNewLabel.setBounds(364, 89, 314, 103);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome, Patient");
		lblNewLabel_1.setBounds(354, 10, 345, 86);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setAlignmentX(Component.LEFT_ALIGNMENT);
		textField.setAlignmentY(Component.TOP_ALIGNMENT);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField.setBounds(465, 201, 451, 234);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("<html>Please use this box to relay information to the doctor or for any query/feedback in short words.</html>");
		lblNewLabel_2.setVerticalTextPosition(SwingConstants.TOP);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(23, 202, 444, 103);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(772, 454, 144, 40);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(168, 209, 205));
		lblNewLabel_3.setBounds(310, 10, 401, 86);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Recorded!");
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.ITALIC, 23));
		lblNewLabel_4.setBounds(581, 449, 144, 49);
		lblNewLabel_4.setVisible(false);
		panel.add(lblNewLabel_4);
		ImageIcon background =new ImageIcon("C:\\Users\\msi\\eclipse-workspace\\dashboard2\\src\\dashboard2\\BACKGROUND LOGIN PAGE.png");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(940,541, Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
		back.setForeground(Color.WHITE);
		back.setLayout(null);
		back.setBounds(0, -155, 936, 780);
		panel.add(back);
		
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String feed=textField.getText();
            	
            	try {
            	String query = "INSERT INTO feedback values('"+feed+"');";
                Statement sta = connection.createStatement();
                int i=sta.executeUpdate(query);
            	}
            	catch (Exception egt) {
            		egt.printStackTrace();
            	}
            	 lblNewLabel_4.setText("Recorded!");
            	 lblNewLabel_4.setVisible(true); 
            	 
            	 
            	
            }
            });
	}
}

