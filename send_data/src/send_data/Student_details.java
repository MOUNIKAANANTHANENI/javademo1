package send_data;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Student_details {

	private JFrame frame;
	private JTextField t1;
	private JTextField t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_details window = new Student_details();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Student_details() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("student");
		lblNewLabel.setBounds(171, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("id");
		lblNewLabel_1.setBounds(10, 80, 67, -25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("id");
		lblNewLabel_2.setBounds(20, 55, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("name");
		lblNewLabel_3.setBounds(20, 92, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		t1 = new JTextField();
		t1.setBounds(149, 52, 86, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(149, 89, 86, 20);
		frame.getContentPane().add(t2);
		t2.setColumns(10);
		
		JButton btnNewButton = new JButton("ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String i=t1.getText();
				int sno=Integer.parseInt(i);
				String na=t2.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/mrecclg","root","mrec");
					String q="insert into abcd values('"+sno+"','"+na+"')";
//					PreparedStatement s= c.prepareStatement("insert into abcd values(?,?)");
//					s.setInt(1,123);
//					s.setString(2, "fdg");
//					ResultSet i1=s.executeQuery();
Statement s=c.createStatement();
s.execute(q);
					c.close();
					JOptionPane.showInternalMessageDialog(btnNewButton, "done");
					
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(171, 144, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
