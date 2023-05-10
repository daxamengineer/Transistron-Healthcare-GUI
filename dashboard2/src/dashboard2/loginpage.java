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
import java.awt.SystemColor;

public class loginpage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton loginBtn;
    private JButton btn;
    private JPanel contentPane;
    public static String fname;
    public static String lname;
    public static String docid;
    

   
    public loginpage() {
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(350, 0, 950, 800);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(216, 239, 236));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel_3 = new JLabel("<html>DOCTOR LOGIN</html>");
        lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 50));
        lblNewLabel_3.setBounds(659, 54, 213, 112);
        contentPane.add(lblNewLabel_3);
        
        JLabel lblNewLabel_1 = new JLabel("__________");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblNewLabel_1.setForeground(Color.BLACK);
        lblNewLabel_1.setBackground(new Color(53, 245, 205));
        lblNewLabel_1.setBounds(740, 483, 186, 51);
        contentPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setDisabledTextColor(new Color(0, 0, 0));
        textField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField.setBounds(630, 324, 242, 41);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        passwordField.setBounds(630, 446, 242, 40);
        contentPane.add(passwordField);

        JLabel lblUsername = new JLabel("Email Address");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(new Color(0, 0, 0));
        lblUsername.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 22));
        lblUsername.setBounds(630, 273, 147, 27);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(new Color(0, 0, 0));
        lblPassword.setBackground(Color.BLACK);
        lblPassword.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 22));
        lblPassword.setBounds(630, 395, 101, 41);
        contentPane.add(lblPassword);

        loginBtn = new JButton("Login");
        loginBtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        loginBtn.setBackground(new Color(232, 255, 250));
        loginBtn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
        loginBtn.setBounds(612, 602, 269, 41);
        loginBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
           	 String ema = textField.getText();
				String pass = passwordField.getText();
				try {
               	Class.forName("com.mysql.cj.jdbc.Driver");
                   Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proto", "root", "root");
                   String query = "select docID,firstname,lastname,email,password from health;";
                   Statement sta = connection.createStatement();
                   ResultSet rs= sta.executeQuery(query);
                   int flag=0;
                   while (rs.next()) {
                   	String em=rs.getString("email");
                   	String pass2=rs.getString("password");
                   	fname=rs.getString("firstname");
                   	lname=rs.getString("lastname");
                   	docid=rs.getString("docID");
                   	if (ema.equals(em) && pass.equals(pass2)) {
                   		JOptionPane.showMessageDialog(null, "Login Successful");
                   		flag=1;
                   		dpage obj2=new dpage(fname,lname,docid);
                   		try {
           					obj2.frame.setVisible(true);
           					setVisible(false);
           				} catch (Exception e1) {
           					e1.printStackTrace();
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
        btn = new JButton("Forgot Password?");
        btn.setForeground(new Color(0, 0, 0));
        btn.setBackground(new Color(53, 245, 205));
        btn.setBorder(new LineBorder(new Color(53, 245, 205), 1, true));
        btn.setFont(new Font("Segoe UI Semilight", Font.BOLD | Font.ITALIC, 16));
        Dimension size = btn.getPreferredSize();
        btn.setBounds(730,497,153,27);
        btn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent f) {
            	EventQueue.invokeLater(new Runnable() {
        			public void run() {
        				try {
        					forgotpasspage frame = new forgotpasspage();
        					frame.setVisible(true);
        					setVisible(false);
        				} catch (Exception e) {
        					e.printStackTrace();
        				}
        			}
        		});               
            }
        });
        
        contentPane.add(loginBtn);
        contentPane.add(btn);
        
        JLabel lblNewLabel = new JLabel("TRANSISTRON");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 60));
        lblNewLabel.setBounds(10, 22, 521, 100);
        contentPane.add(lblNewLabel);
        
        ImageIcon background =new ImageIcon("C:\\Users\\anish\\eclipse-workspace\\dashboard2\\src\\dashboard2\\Layer 2.png");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(380, 380, Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
		back.setForeground(Color.WHITE);
		back.setLayout(null);
		back.setBounds(47, 136, 447, 407);
		contentPane.add(back);
        
        JButton btnNewButton = new JButton("<html>Click here to login as a patient.</html>");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        		ppage window = new ppage();
  
           			window.frame.setVisible(true);
           			
                    setVisible(false);
           			
           				} catch (Exception ejk) {
           					ejk.printStackTrace();
           				}
        	}
        });
        btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        btnNewButton.setForeground(SystemColor.menuText);
        btnNewButton.setBackground(new Color(232, 255, 250));
        btnNewButton.setBounds(106, 669, 335, 41);
        contentPane.add(btnNewButton);
        
        JLabel bg1 = new JLabel("");
        bg1.setBorder(new LineBorder(new Color(168, 209, 205), 3, true));
        bg1.setSize(new Dimension(1, 0));
        bg1.setOpaque(true);
        bg1.setLabelFor(this);
        bg1.setBackground(new Color(53, 245, 205));
        bg1.setBounds(543, 0, 393, 763);
        contentPane.add(bg1);
        
        JLabel lblNewLabel_2 = new JLabel("<html>Health is a state of complete harmony of the body, mind, and spirit.\r\n — B.K.S. Iyengar</html>");
        lblNewLabel_2.setFont(new Font("Segoe UI Variable", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel_2.setBounds(94, 497, 393, 166);
        contentPane.add(lblNewLabel_2);
        }
}