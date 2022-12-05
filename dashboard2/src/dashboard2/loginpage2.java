package dashboard2;
import java.util.*;
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
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;


import javax.swing.border.BevelBorder;

public class loginpage2 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton loginBtn;
    private JButton btn;
    private JPanel contentPane;
    public static String fname;
    public static String lname;
    private JTextField patientAdd;
    private JTextField txtPat;
    

   
    public loginpage2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(350, 0, 950, 800);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(216, 239, 236));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField = new JTextField();
        textField.setDisabledTextColor(new Color(0, 0, 0));
        textField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField.setBounds(137, 254, 242, 41);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        passwordField.setBounds(137, 356, 242, 40);
        contentPane.add(passwordField);

        JLabel lblUsername = new JLabel("Email Address");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(new Color(0, 0, 0));
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(137, 217, 124, 27);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(new Color(0, 0, 0));
        lblPassword.setBackground(Color.BLACK);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(137, 305, 84, 41);
        contentPane.add(lblPassword);

        loginBtn = new JButton("Login");
        loginBtn.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        loginBtn.setBackground(new Color(255, 255, 255));
        loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
        loginBtn.setBounds(137, 433, 113, 41);
        loginBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
           	 String ema = textField.getText();
				String pass = passwordField.getText();
				try {
               	Class.forName("com.mysql.cj.jdbc.Driver");
                   Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proto", "root", "root");
                   String query = "select firstname,lastname,email,password from health;";
                   Statement sta = connection.createStatement();
                   ResultSet rs= sta.executeQuery(query);
                   int flag=0;
                   while (rs.next()) {
                   	String em=rs.getString("email");
                   	String pass2=rs.getString("password");
                   	fname=rs.getString("firstname");
                   	lname=rs.getString("lastname");
                   	if (ema.equals(em) && pass.equals(pass2)) {
                   		JOptionPane.showMessageDialog(null, "Login Successful");
                   		flag=1;
                   		dpage obj2=new dpage(fname,lname);
                   		try {
           					obj2.frame.setVisible(true);
           				} catch (Exception e1) {
           					// TODO Auto-generated catch block
           					e1.printStackTrace();
                   	}
                   }
                   	else if (ema.equals("Patient@xyz.in") && pass.equals("Pat2")) {
                   		JOptionPane.showMessageDialog(null, "Login Successful");
                   		flag=1;	
                   		ppage window = new ppage();
                   		try {
                   			window.frame.setVisible(true);
                   			break;
                   				} catch (Exception ejk) {
                   					ejk.printStackTrace();
                   				}
                   			}
                   		}
                   if (flag==0) {
               		JOptionPane.showMessageDialog(null, "Incorrect Credentials");
               	}
                   connection.close();
               } 
				catch (Exception exception) {
                   exception.printStackTrace();
               }
           	}
       });
        

           
        
        btn = new JButton("Forgot Password ?");
        btn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        Dimension size = btn.getPreferredSize();
        btn.setBounds(169,503,176,27);
        btn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent f) {
            	EventQueue.invokeLater(new Runnable() {
        			public void run() {
        				try {
        					ForgotPassPage frame = new ForgotPassPage();
        					frame.setVisible(true);
        				} catch (Exception e) {
        					e.printStackTrace();
        				}
        			}
        		});               
            }
        });
        JButton registerBtn = new JButton("Register");
        registerBtn.setForeground(new Color(255, 255, 255));
        registerBtn.setBackground(new Color(0, 0, 0));
        registerBtn.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        registerBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
        registerBtn.setBounds(273, 433, 106, 41);
        registerBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent r) {
				EventQueue.invokeLater(new Runnable() {
        			public void run() {
        				try {
        					registration2 frame2 = new registration2();
        					frame2.setVisible(true);
        				} catch (Exception e) {
        					e.printStackTrace();
        				}
        			}
        		});
				
			}
        	
        });
        contentPane.add(loginBtn);
        contentPane.add(btn);
        contentPane.add(registerBtn);
        
        JLabel lblNewLabel_1 = new JLabel("Patient Login Info");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel_1.setBounds(579, 219, 266, 40);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_3 = new JLabel("Password:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(579, 371, 134, 56);
        contentPane.add(lblNewLabel_3);
        
        JLabel lblNewLabel = new JLabel("Transistron");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 99));
        lblNewLabel.setBounds(264, 24, 497, 100);
        contentPane.add(lblNewLabel);
        
        patientAdd = new JTextField();
        patientAdd.setEditable(false);
        patientAdd.setText("Patient@xyz.in");
        patientAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
        patientAdd.setDisabledTextColor(Color.BLACK);
        patientAdd.setColumns(10);
        patientAdd.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        patientAdd.setBounds(579, 320, 242, 41);
        contentPane.add(patientAdd);
        
        txtPat = new JTextField();
        txtPat.setEditable(false);
        txtPat.setText("Pat2\r\n");
        txtPat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtPat.setDisabledTextColor(Color.BLACK);
        txtPat.setColumns(10);
        txtPat.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        txtPat.setBounds(579, 420, 242, 41);
        contentPane.add(txtPat);
        
        JLabel lblEmailAddress = new JLabel("Email Address: ");
        lblEmailAddress.setForeground(Color.BLACK);
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmailAddress.setBackground(Color.BLACK);
        lblEmailAddress.setBounds(579, 288, 153, 27);
        contentPane.add(lblEmailAddress);
        
        JLabel bg1 = new JLabel("");
        bg1.setBorder(new LineBorder(new Color(168, 209, 205), 3, true));
        bg1.setSize(new Dimension(1, 0));
        bg1.setOpaque(true);
        bg1.setLabelFor(this);
        bg1.setBackground(new Color(168, 209, 205));
        bg1.setBounds(94, 196, 333, 405);
        contentPane.add(bg1);
        
        ImageIcon background =new ImageIcon("C:\\Users\\msi\\eclipse-workspace\\dashboard2\\src\\dashboard2\\BACKGROUND LOGIN PAGE.png");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(950, 800, Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
		back.setForeground(Color.WHITE);
		back.setLayout(null);
		back.setBounds(0, -27, 936, 780);
        JLabel bg2 = new JLabel("");
        bg2.setSize(new Dimension(1, 0));
        bg2.setOpaque(true);
        bg2.setBorder(new LineBorder(new Color(168, 209, 205), 3, true));
        bg2.setBackground(new Color(168, 209, 205));
        bg2.setBounds(536, 196, 333, 405);
        contentPane.add(bg2);
        contentPane.add(back);
    }
}