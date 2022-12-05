package dashboard2;


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
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
//import NewTransistrons.opening;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class dpage {

	JFrame frame;
	public String docfirstname;
	public String doclastname;
	public JButton btn;
	public JButton btn3;
	public String feed;
	ResultSet rs3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTable table;
	private JScrollPane scrollPane;
	
	public dpage(String a, String b) throws Exception {
		docfirstname=a;
		doclastname=b;
		initialize();
		
	}

	

	
	public void initialize() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proto", "root", "root");
		frame = new JFrame();
		frame.setBounds(100, 100, 722, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(216, 239, 236));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel tx = new JLabel("Welcome, Doctor "+docfirstname+" "+doclastname);
		tx.setForeground(Color.BLACK);
        tx.setFont(new Font("Tahoma", Font.PLAIN, 35));
        tx.setBounds(27, -16, 671, 126);
        panel.add(tx);
        
        
        
        JButton btnNewButton = new JButton("Clear Data");
        btnNewButton.setBackground(new Color(0, 0, 0));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setBounds(10, 381, 227, 52);
        btnNewButton.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());
				
			}
        	
        	
        });
        panel.add(btnNewButton);
        
        
        btn = new JButton("Patient Data and Bot Ultrasonic Tracker");
        btn.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        btn.setBackground(new Color(168, 209, 205));
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 26));
        btn.setBounds(104, 113, 498, 67);
        btn.addActionListener(new ActionListener() {
        	opening obj6= new opening();
            public void actionPerformed(ActionEvent e) {
            	try {
					obj6.open();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            }
        });
        panel.add(btn);
        
        btn3 = new JButton("Patient Communication");
        btn3.setForeground(new Color(255, 255, 255));
        btn3.setBackground(new Color(0, 0, 0));
        btn3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn3.setBounds(10, 298, 227, 52);
        btn3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            	String q2="select * from feedback;";
                try {
					Statement st2=connection.createStatement();
					ResultSet sr=st2.executeQuery(q2);
					ResultSetMetaData rsm=sr.getMetaData();
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					int cols=rsm.getColumnCount();
					String[] col=new String[cols];
					for (int h=0;h<cols;h++) {
						col[h]=rsm.getColumnName(h+1);
					}
					model.setColumnIdentifiers(col);
					String fee;
					while(sr.next()) {
						fee=sr.getString(1);
						String[] row= {fee};
						model.addRow(row);
					}
					//st2.close();
					//connection.close();
                }
                catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            
        });
        panel.add(btn3);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(270, 190, 392, 292);
        panel.add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        
        ImageIcon background =new ImageIcon("C:\\Users\\msi\\eclipse-workspace\\dashboard2\\src\\dashboard2\\BACKGROUND LOGIN PAGE.png");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(722,529, Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
		back.setForeground(Color.WHITE);
		back.setLayout(null);
		back.setBounds(-124, -163, 936, 780);
		panel.add(back);
        
        
        
        
        
        
        
        
        
	}
}
