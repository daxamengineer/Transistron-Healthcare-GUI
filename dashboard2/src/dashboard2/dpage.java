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
	public String docid;
	public JButton btn;
	public JButton btn3;
	public String feed;
	ResultSet rs3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton_2;
	
	public dpage(String a, String b, String c) throws Exception {
		docfirstname=a;
		doclastname=b;
		docid=c;
		initialize();
	}
	public void initialize() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
        final Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proto", "root", "root");
		frame = new JFrame();
		frame.setBounds(100, 100, 722, 529);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
		JPanel panel = new JPanel();
		panel.setBackground(new Color(53, 245, 205));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		ImageIcon background =new ImageIcon("C:\\Users\\anish\\eclipse-workspace\\dashboard2\\src\\dashboard2\\bg1.png");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(1000, 1000, Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        
		JLabel tx = new JLabel("Welcome, Dr. "+docfirstname+" "+doclastname);
		tx.setForeground(Color.BLACK);
        tx.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
        tx.setBounds(19, 10, 671, 126);
        panel.add(tx);
        
        final JButton btnNewButton_1 = new JButton("Appointments");
		btnNewButton_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		btnNewButton_1.setBounds(18, 319, 147, 52);
		panel.add(btnNewButton_1);
        
        JButton btnNewButton = new JButton("Clear Data");
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        btnNewButton.setBounds(18, 409, 147, 52);
        btnNewButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());
				btn3.setEnabled(true);
				btnNewButton_1.setEnabled(true);	
			}
        });
        panel.add(btnNewButton);
        
        
        btn = new JButton("Patient Data");
        btn.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        btn.setBounds(18, 144, 147, 52);
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
        
        btn3 = new JButton("Reviews");
        btn3.setForeground(new Color(0, 0, 0));
        btn3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        btn3.setBounds(18, 232, 147, 52);
        
        
		
		
        btn3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            	String q2="select * from feedback;";
                try {
                	btn3.setEnabled(false);
                	btnNewButton_1.setEnabled(true);
                	table.setModel(new DefaultTableModel());
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
        scrollPane.setBounds(196, 133, 494, 328);
        panel.add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        
        btnNewButton_2 = new JButton("Log out");
        btnNewButton_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
        btnNewButton_2.setBounds(611, 10, 85, 21);
        panel.add(btnNewButton_2);
        JLabel back=new JLabel(background);
        back.setForeground(Color.WHITE);
        back.setLayout(null);
        back.setBounds(0, 0, 711, 492);
        panel.add(back);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.setVisible(false);
            	loginpage obj5 = new loginpage();
            	obj5.setVisible(true);
            }
		});
        
		
		
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String q2="select name,age,sex,contact,bloodgroup,slot from patreg where docID='"+docid+"';";
            		try {
            			btn3.setEnabled(true);
                    	btnNewButton_1.setEnabled(false);
            			table.setModel(new DefaultTableModel());
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
    					String name;
    					String age;
    					String sex;
    					String contact;
    					String blood;
    					String slot;
    					while(sr.next()) {
    						name=sr.getString(1);
    						age=sr.getString(2);
    						sex=sr.getString(3);
    						contact=sr.getString(4);
    						blood=sr.getString(5);
    						slot=sr.getString(6);
    						String[] row= {name,age,sex,contact,blood,slot};
    						model.addRow(row);
    					}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            }
		});
        
	}
}