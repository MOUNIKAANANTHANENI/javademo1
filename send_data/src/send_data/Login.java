package send_data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField tb1;
	private JPasswordField tb2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(175, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setBounds(38, 53, 79, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Paasword");
		lblNewLabel_2.setBounds(37, 95, 64, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		tb1 = new JTextField();
		tb1.setBounds(150, 50, 86, 20);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		tb2 = new JPasswordField();
		tb2.setBounds(160, 88, 70, 20);
		frame.getContentPane().add(tb2);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u=tb1.getText();
				String p=tb2.getText();
				try {
					Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/mrecclg","root","mrec");
					String q="select count(*) from signup where username=? and password=?";
					PreparedStatement ps=c.prepareStatement(q);
					ps.setString(1, u);
					ps.setString(2, p);
					ResultSet r=ps.executeQuery();
					r.next();
					int i=r.getInt(1);
					if(i==0)
					{
						JOptionPane.showMessageDialog(btnNewButton, "invalid");
					}
					else
					{
						JOptionPane.showMessageDialog(btnNewButton, "valid");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
	
	
		btnNewButton.setBounds(115, 160, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}

	
}
