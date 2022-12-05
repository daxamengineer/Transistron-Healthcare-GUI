package dashboard2;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

class ForgotPassPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameo;
	private JButton submitButton;
	private JLabel errorLabel;
	private JLabel er;
	private JLabel lblWhatIsYour;
	private JTextField textField;
	private JLabel lblNewLabel;
	String pass;
	public ForgotPassPage() throws IOException {		
		super("Forgot Password");		
		setResizable(false);
		setVisible(true);
	

	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 371, 486);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 239, 236));
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		ImageIcon background2 =new ImageIcon("C:\\Users\\msi\\eclipse-workspace\\dashboard2\\src\\dashboard2\\image 14.png");
        Image img2=background2.getImage();
        Image temp2=img2.getScaledInstance(30, 40, Image.SCALE_SMOOTH);
		background2=new ImageIcon(temp2);
		

		JLabel titleLabel = new JLabel("Forgot Password \r\n");
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 39));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(20, 10, 339, 85);
		contentPane.add(titleLabel);

		usernameo = new JTextField();
		usernameo.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		usernameo.setBounds(20, 106, 200, 31);
		contentPane.add(usernameo);
		usernameo.setColumns(10);

		JLabel unameSignInLabel = new JLabel("Email Address");
		unameSignInLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		unameSignInLabel.setHorizontalAlignment(SwingConstants.CENTER);
		unameSignInLabel.setForeground(Color.BLACK);
		unameSignInLabel.setBounds(20, 80, 129, 31);
		contentPane.add(unameSignInLabel);


		submitButton = new JButton("Submit");
		submitButton.setForeground(new Color(255, 255, 255));
		submitButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		submitButton.setBackground(new Color(0, 0, 0));
		submitButton.setBounds(61, 237, 88, 39);
		contentPane.add(submitButton);

		errorLabel = new JLabel("Please enter a valid email address.");
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(71, 286, 224, 31);
		errorLabel.setVisible(false);
		contentPane.add(errorLabel);
		
		lblWhatIsYour = new JLabel("What is your favorite color?");
		lblWhatIsYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhatIsYour.setForeground(Color.BLACK);
		lblWhatIsYour.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWhatIsYour.setBounds(10, 166, 262, 31);
		contentPane.add(lblWhatIsYour);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField.setBounds(20, 196, 200, 31);
		contentPane.add(textField);
		
		ImageIcon background =new ImageIcon("C:\\Users\\msi\\eclipse-workspace\\dashboard2\\src\\dashboard2\\f.1.png");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(373, 486, Image.SCALE_SMOOTH);
        
        background=new ImageIcon(temp);
        ImageIcon background3 =new ImageIcon("C:\\Users\\msi\\eclipse-workspace\\dashboard2\\src\\dashboard2\\image 14.png");
        Image img3=background3.getImage();
        Image temp3=img3.getScaledInstance(37, 48, Image.SCALE_SMOOTH);
        
        background3=new ImageIcon(temp3);
        er = new JLabel("Your password: "+pass);
		er.setHorizontalAlignment(SwingConstants.CENTER);
		er.setForeground(Color.RED);
		er.setBounds(61, 327, 189, 114);
		er.setVisible(false);
		contentPane.add(er);
		
		lblNewLabel = new JLabel("Incorrect Security Answer");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(116, 313, 156, 13);
		lblNewLabel.setVisible(false);
		contentPane.add(lblNewLabel);
		JLabel back=new JLabel(background);
		back.setForeground(Color.WHITE);
		back.setLayout(null);
		back.setBounds(0, -27, 363, 476);
		
		
		

		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String us = usernameo.getText();
				String col= textField.getText();
				try {
                	Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proto", "root", "root");
                    String query = "select email,password,color from health where email='"+us+"';";

                    Statement str = connection.createStatement();
                    ResultSet rs=str.executeQuery(query);
                    if (rs.next()==false) {
                    	errorLabel.setText("Please enter a valid email address.");
    					errorLabel.setVisible(true);
                    	return;                   	
                    }
                    else {      
                    	pass=rs.getString("password");
                    	String col2=rs.getString("color");
                    	if (col.equals(col2)) {
                    		
                    		er.setText("Your password: "+pass);
                    		er.setVisible(true);
                    		lblNewLabel.setVisible(false);
                    		errorLabel.setVisible(false);
                    	}
                    	else {
                    		lblNewLabel.setText("Incorrect Security Answer");
        					lblNewLabel.setVisible(true);
                        	return;
                    	}
                    	                   	
                    }                   
                    connection.close();
                } 
				catch (Exception exception) {
                    System.out.println(exception);
                }				
			}
		});
		contentPane.add(back);
	}		
	}