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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

class forgotpasspage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameo;
	private JButton submitButton;
	private JLabel errorLabel;
	
	private JLabel lblWhatIsYour;
	private JTextField textField;
	private JLabel lblNewLabel;
	String pass;
	String us;
	String col;
	Statement str;
	
	public forgotpasspage() throws IOException {		
		super("Forgot Password");
		setResizable(false);
		setVisible(true);
	
		final loginpage obj = new loginpage();
	
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 511, 544);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(53, 245, 205));
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		ImageIcon background2 =new ImageIcon("C:\\Users\\anish\\eclipse-workspace\\dashboard2\\src\\dashboard2\\image 14.png");
        Image img2=background2.getImage();
        Image temp2=img2.getScaledInstance(30, 40, Image.SCALE_SMOOTH);
		background2=new ImageIcon(temp2);
		
		final JButton confirmbutton = new JButton("Confirm");
		confirmbutton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		confirmbutton.setBounds(193, 354, 101, 38);
		contentPane.add(confirmbutton);
		confirmbutton.setVisible(false);
		confirmbutton.setEnabled(false);
		
		final JLabel lblNewLabel_2 = new JLabel("Retype New Password:");
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 18));
		lblNewLabel_2.setBounds(104, 246, 262, 30);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		JButton btnNewButton = new JButton("Go back");
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		btnNewButton.setBounds(399, 13, 85, 21);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				setVisible(false);
				
				obj.setVisible(true);
			}
		});
		

		JLabel titleLabel = new JLabel("Forgot Password \r\n");
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(50, 45, 339, 85);
		contentPane.add(titleLabel);

		usernameo = new JTextField();
		usernameo.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		usernameo.setBounds(107, 192, 265, 31);
		contentPane.add(usernameo);
		usernameo.setColumns(10);

		final JLabel unameSignInLabel = new JLabel("Email Address");
		unameSignInLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 18));
		unameSignInLabel.setHorizontalAlignment(SwingConstants.CENTER);
		unameSignInLabel.setForeground(Color.BLACK);
		unameSignInLabel.setBounds(103, 151, 129, 31);
		contentPane.add(unameSignInLabel);


		submitButton = new JButton("Submit");
		submitButton.setForeground(new Color(0, 0, 0));
		submitButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		submitButton.setBackground(new Color(232, 255, 250));
		submitButton.setBounds(195, 353, 88, 39);
		contentPane.add(submitButton);
		
		lblWhatIsYour = new JLabel("What is your favorite color?");
		lblWhatIsYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhatIsYour.setForeground(Color.BLACK);
		lblWhatIsYour.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 18));
		lblWhatIsYour.setBounds(88, 245, 262, 31);
		contentPane.add(lblWhatIsYour);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField.setBounds(107, 284, 265, 31);
		contentPane.add(textField);
		
		errorLabel = new JLabel("Please enter a valid email address.");
		errorLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 11));
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(126, 429, 224, 31);
		errorLabel.setVisible(false);
		contentPane.add(errorLabel);
		
		
		lblNewLabel = new JLabel("Incorrect Security Answer");
		lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(162, 438, 156, 13);
		lblNewLabel.setVisible(false);
		contentPane.add(lblNewLabel);
		
		final JLabel lblNewLabel_1 = new JLabel("New Password:");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(108, 146, 154, 41);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				lblNewLabel.setVisible(false);
				errorLabel.setVisible(false);
			
				us = usernameo.getText();
				col= textField.getText();
				try {
                	Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proto", "root", "root");
                    String query = "select email,password,color from health where email='"+us+"';";

                    str = connection.createStatement();
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
                    		lblNewLabel_1.setVisible(true);
                    		lblNewLabel_2.setVisible(true);
                    		confirmbutton.setVisible(true);
                    		confirmbutton.setEnabled(true);
                    		unameSignInLabel.setVisible(false);
                    		lblWhatIsYour.setVisible(false);
                    		submitButton.setVisible(false);
                    		submitButton.setEnabled(false);
                    		usernameo.setText("");
            				textField.setText("");
                    	
                    	}
                    	else {
                    		lblNewLabel.setText("Incorrect Security Answer");
        					lblNewLabel.setVisible(true);
                        	return;
                    	}
                    	                   	
                    }                   
                    
                } 
				catch (Exception exception) {
                    System.out.println(exception);
                }				
			}
		});
		
		
		confirmbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String pass1=usernameo.getText();
				String pass2=textField.getText();
				int flag=0;
				if (pass1.length()<8) {
					JOptionPane.showMessageDialog(null, "<html>Minimum password length is 8 characters!</html>");
					flag=1;
				}
				else {
					if ((pass1.equals(pass2))==false) {
						JOptionPane.showMessageDialog(null, "<html>Passwords do not match.</html>");
					}
					else {
						int highc=0;
						int lowc=0;
						int spec=0;
						int dig=0;
						for (int i=0;i< pass1.length();i++) {
				            if (!Character.isDigit(pass1.charAt(i)) && !Character.isLetter(pass1.charAt(i)) && !Character.isWhitespace(pass1.charAt(i))) {
				                spec=1;
				            }
				            else if (Character.isDigit(pass1.charAt(i))){
				            	dig=1;
				            }
				            else if (Character.isUpperCase(pass1.charAt(i))) {
				            	highc=1;
				            }
				            else if (Character.isLowerCase(pass1.charAt(i))) {
				            	lowc=1;
				            }
				        }
						if (highc==0 || lowc==0 || spec==0 || dig==0) {
							JOptionPane.showMessageDialog(null, "<html>Password must container at least one uppercase character, one lowercase character, one integer and one special character.</html>");
						}
						else {
							String q3="update health set password='"+pass1+"' where email='"+us+"';";
							try {
								str.executeUpdate(q3);
								JOptionPane.showMessageDialog(null, "<html>New password set.</html>");
								setVisible(false);
								obj.setVisible(true);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
		});
	}		
	}