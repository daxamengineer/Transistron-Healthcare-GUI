package dashboard2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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


public class registration2 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField username;   
    private JPasswordField passwordField;
    private JButton btnNewButton;
    int check=0;
    private JLabel ert;
    private JLabel ert2;
    private JTextField color;
  
    public registration2() throws ClassNotFoundException, SQLException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proto", "root", "root");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(216, 239, 236));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("New Registration");
        lblNewUserRegister.setBackground(new Color(0, 128, 0));
        lblNewUserRegister.setForeground(new Color(0, 0, 0));
        lblNewUserRegister.setFont(new Font("Tahoma", Font.PLAIN, 60));
        lblNewUserRegister.setBounds(152, 25, 586, 97);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("First name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(152, 117, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Last name");
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(152, 204, 110, 29);
        contentPane.add(lblNewLabel);

        firstname = new JTextField();
        firstname.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        firstname.setBounds(152, 158, 259, 36);
        contentPane.add(firstname);
        firstname.setColumns(10);

        lastname = new JTextField();
        lastname.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lastname.setBounds(152, 233, 259, 36);
        contentPane.add(lastname);
        lastname.setColumns(10);


        username = new JTextField();
        username.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        username.setFont(new Font("Tahoma", Font.PLAIN, 32));
        username.setBounds(602, 158, 259, 36);
        contentPane.add(username);
        username.setColumns(10);

        JLabel lblUsername = new JLabel("Email Address");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(602, 119, 159, 38);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(new Color(0, 0, 0));
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(602, 201, 99, 35);
        contentPane.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(602, 233, 260, 36);
        contentPane.add(passwordField);
        
        ert = new JLabel("Registration Successfull!");
        ert.setFont(new Font("Javanese Text", Font.BOLD | Font.ITALIC, 22));
		ert.setHorizontalAlignment(SwingConstants.CENTER);
		ert.setForeground(new Color(0, 0, 0));
		ert.setBounds(119, 364, 266, 62);
		ert.setVisible(false);
		contentPane.add(ert);
		
		ert2=new JLabel("Account already exists!");
		ert2.setFont(new Font("Javanese Text", Font.BOLD | Font.ITALIC, 22));
		ert2.setHorizontalAlignment(SwingConstants.CENTER);
		ert2.setForeground(new Color(0, 0, 0));
		ert2.setBounds(106, 436, 283, 47);
		ert2.setVisible(false);
		contentPane.add(ert2);
		
		
        btnNewButton = new JButton("Register");
        btnNewButton.setBackground(new Color(0, 0, 0));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstname.getText();
                String lastName = lastname.getText();
                String email = username.getText();
                String password = passwordField.getText();
                String colour =color.getText();
                
                String q2="select email from health;";
                try {
					Statement st2=connection.createStatement();
					ResultSet sr=st2.executeQuery(q2);
					
					while (sr.next()) {
						String usern=sr.getString("email");
						if (usern.equals(email)) {
							check=1;
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                try {
                	if (check==0) {
                    String query = "INSERT INTO health values('"+firstName+"','"+lastName+"','"+email+"','"+password+"','"+colour+"');";
                    Statement sta = connection.createStatement();
                    int i=sta.executeUpdate(query);
                    ert.setText("Registration successfull!!");
					ert.setVisible(true);                   
                    connection.close();
                	}
                	else {
                		ert2.setText("Account already exists!");
                		ert2.setVisible(true);                		
                	}
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                loginpage2 obj3=new loginpage2();
                obj3.setVisible(true);
            }
            
        });
        
        
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton.setBounds(420, 370, 182, 43);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_1 = new JLabel("Security Question: What is your favorite color?");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(152, 279, 450, 43);
        contentPane.add(lblNewLabel_1);
        
        color = new JTextField();
        color.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        color.setFont(new Font("Tahoma", Font.PLAIN, 32));
        color.setBounds(152, 318, 259, 36);
        contentPane.add(color);
        color.setColumns(10);
        ImageIcon background =new ImageIcon("C:\\Users\\msi\\eclipse-workspace\\dashboard2\\src\\dashboard2\\f.1.png");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(1014,597, Image.SCALE_SMOOTH);
        
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
		back.setForeground(Color.WHITE);
		back.setLayout(null);
		back.setBounds(64, -131, 936, 780);
		contentPane.add(back);
        
      
    }
}