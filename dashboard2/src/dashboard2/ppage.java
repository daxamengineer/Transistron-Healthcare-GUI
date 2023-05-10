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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
import javax.swing.JSplitPane;
import javax.swing.JEditorPane;
import java.awt.TextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.JMenuBar;

public class ppage {

	JFrame frame;
	private JTextField txtpleaseUseThis;
	private final JLabel lblNewLabel_5 = new JLabel("Appointments");
	


	public ppage() throws Exception {
		initialize();
	}

	
	private void initialize() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
        final Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proto", "root", "root");
		jsonparse t = new jsonparse();
		t.StartParsing();
		String[] arr = t.Readvalues();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 940, 541);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(53, 245, 205));
		panel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("Log Out");
		btnNewButton_3.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		btnNewButton_3.setBounds(820, 10, 96, 34);
		panel.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.setVisible(false);
            	loginpage obj5 = new loginpage();
            	obj5.setVisible(true);
            }
		});
		lblNewLabel_5.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		lblNewLabel_5.setBounds(129, 246, 224, 43);
		panel.add(lblNewLabel_5);
		
		JButton btnNewButton_2 = new JButton("Manage Appointments");
		btnNewButton_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		btnNewButton_2.setBounds(71, 414, 368, 57);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
					pat_manage obj3=new pat_manage();
					obj3.frame.setVisible(true);
					frame.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
		});
		for (int k=0;k<arr.length;k++) {
			System.out.println(arr[k]);
		}
		JLabel lblNewLabel_2 = new JLabel("Your Oxygen Saturation: 96%"); //arr[2]
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(10, 148, 473, 56);
		panel.add(lblNewLabel_2);
		
		JLabel lblYourTemperature = new JLabel("Your Temperature: 98.4"); //arr[1]
		lblYourTemperature.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 26));
		lblYourTemperature.setBounds(9, 101, 402, 59);
		panel.add(lblYourTemperature);
		
		JLabel lblNewLabel = new JLabel("Your BPM: "+arr[0]);
		lblNewLabel.setBounds(9, 39, 314, 86);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 26));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome, Patient");
		lblNewLabel_1.setForeground(new Color(255, 213, 213));
		lblNewLabel_1.setBounds(347, -20, 311, 86);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 32));
		panel.add(lblNewLabel_1);
		
	//	txtpleaseUseThis = new JTextField();
	//	txtpleaseUseThis.setText("Please use this box to relay information\r\n to the doctor or for any query/feedback in short words.");
	//	txtpleaseUseThis.setHorizontalAlignment(SwingConstants.LEFT);
	//	txtpleaseUseThis.setAlignmentX(Component.LEFT_ALIGNMENT);
	//	txtpleaseUseThis.setAlignmentY(Component.TOP_ALIGNMENT);
	//	txtpleaseUseThis.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
	//	txtpleaseUseThis.setBounds(39, 345, 444, 116);
	//	panel.add(txtpleaseUseThis);
	//	txtpleaseUseThis.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBackground(new Color(232, 255, 250));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		btnNewButton.setBounds(659, 440, 116, 30);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
	//	lblNewLabel_3.setUndecorated(true);
	//	lblNewLabel_3.setOpacity();
		lblNewLabel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(0, 0, 99));
		lblNewLabel_3.setBounds(1, 2, 923, 51);
		panel.add(lblNewLabel_3);
		
		final JLabel lblNewLabel_4 = new JLabel("Recorded!");
		lblNewLabel_4.setFont(new Font("Segoe UI Light", Font.ITALIC, 20));
		lblNewLabel_4.setBounds(676, 457, 86, 49);
		lblNewLabel_4.setVisible(false);
		panel.add(lblNewLabel_4);
		
		ImageIcon background =new ImageIcon("C:\\Users\\anish\\eclipse-workspace\\dashboard2\\src\\dashboard2\\bg1.png");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(1000, 1000, Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
		
		JButton btnNewButton_1 = new JButton("Schedule Appointments");
		btnNewButton_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		btnNewButton_1.setBounds(71, 334, 368, 57);
		panel.add(btnNewButton_1);
		
		final TextArea textArea = new TextArea();
		textArea.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		textArea.setText("Please use this box to relay information to the doctor or for any\r\nquery/feedback in short words.");
		textArea.setBounds(524, 344, 402, 82);
		panel.add(textArea);
		textArea.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent arg0) {
				textArea.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBackground(new Color(252, 214, 218));
		panel_2.setBounds(524, 64, 400, 439);
		panel.add(panel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(253, 232, 234), new Color(7, 10, 8)));
		panel_1.setBackground(new Color(229, 255, 247));
		panel_1.setForeground(new Color(7, 10, 8));
		panel_1.setBounds(1, 53, 525, 449);
		panel.add(panel_1);
		JLabel back=new JLabel(background);
		back.setForeground(Color.WHITE);
		back.setLayout(null);
		back.setBounds(-44, -9, 986, 535);
		panel.add(back);
		

		ImageIcon bg =new ImageIcon("C:\\Users\\anish\\eclipse-workspace\\dashboard2\\src\\dashboard2\\Patient.png");
        Image image=bg.getImage();
        Image tempo=image.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        bg=new ImageIcon(tempo);
        JLabel back2=new JLabel(bg);
		back2.setForeground(Color.WHITE);
		back2.setLayout(null);
		back2.setBounds(47, 136, 447, 350);
		panel_2.add(back2);
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String feed=textArea.getText();
            	
            	try {
            	String query = "INSERT INTO feedback values('"+feed+"');";
                Statement sta = connection.createStatement();
                sta.executeUpdate(query);
            	}
            	catch (Exception egt) {
            		egt.printStackTrace();
            	}
            	 lblNewLabel_4.setText("Recorded!");
            	 lblNewLabel_4.setVisible(true); 
            	 
            	 
            	
            }
            });
		btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
            	schedule2 shed =new schedule2();
           		frame.setVisible(false);
           			shed.frame2.setVisible(true);
           			} 
            	catch (Exception ejk) {
           					ejk.printStackTrace();
           				}
            	 
            	 
            	
            }
            });
		
		
	}
}
