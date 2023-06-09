package send_data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Signup {

	private JFrame frame;
	private JTextField t1;
	private JPasswordField t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup window = new Signup();
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
	public Signup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SignUp");
		lblNewLabel.setBounds(154, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setBounds(37, 48, 100, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PassWord");
		lblNewLabel_2.setBounds(37, 103, 87, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		t1 = new JTextField();
		t1.setBounds(207, 45, 86, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		t2 = new JPasswordField();
		t2.setBounds(207, 100, 86, 20);
		frame.getContentPane().add(t2);
		
		JButton btnNewButton = new JButton("SignUp");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u=t1.getText();
				String  p1=t2.getText();
			
				try {
				Connection	c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrecclg","root","mrec");
					
					String q="insert into signup values('"+u+"','"+p1+"')";
					
					Statement s=c.createStatement();
					s.execute(q);
					c.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Login l=new Login();
				l.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		btnNewButton.setBounds(138, 160, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
	}
}
