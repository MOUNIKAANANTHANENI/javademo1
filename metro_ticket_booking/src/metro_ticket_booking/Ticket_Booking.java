package metro_ticket_booking;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ticket_Booking {

	private JFrame frame;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ticket_Booking window = new Ticket_Booking();
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
	public Ticket_Booking() {
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\online lab\\Desktop\\download11 (1).png"));
		lblNewLabel.setBounds(10, 0, 56, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ticket Booking");
		lblNewLabel_1.setFont(new Font("Sitka Heading", Font.BOLD, 15));
		lblNewLabel_1.setBounds(160, 11, 107, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(10, 51, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("From Station");
		lblNewLabel_3.setBounds(10, 79, 76, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("To Station");
		lblNewLabel_3_1.setBounds(10, 106, 76, 14);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("No Of Tickets");
		lblNewLabel_4.setBounds(10, 131, 76, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		t1 = new JTextField();
		t1.setBounds(122, 51, 116, 14);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		JComboBox c1 = new JComboBox();
		c1.setModel(new DefaultComboBoxModel(new String[] {"select Station", "Nagole", "Uppal", "Habsiguda", "Tarnaka", "Jbs"}));
		c1.setBounds(122, 75, 116, 14);
		frame.getContentPane().add(c1);
		
		JComboBox c2 = new JComboBox();
		c2.setModel(new DefaultComboBoxModel(new String[] {"select Station", "Mgbs", "kukatpally", "HitechCity", "Gachibowli", "RaiDurg", "Srnagar"}));
		c2.setBounds(122, 106, 116, 14);
		frame.getContentPane().add(c2);
		
		JComboBox c3 = new JComboBox();
		c3.setModel(new DefaultComboBoxModel(new String[] {"select No.Of.Tickets", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		c3.setBounds(122, 131, 116, 14);
		frame.getContentPane().add(c3);
		
		JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n=t1.getText();
				String f=(String) c1.getSelectedItem();
				String t=(String) c2.getSelectedItem();
				String ti=(String) c3.getSelectedItem();
				int tic=Integer.parseInt(ti);
			int bill=tic*80;
			
			if(f.equals(t))
			{
				JOptionPane.showMessageDialog(btnNewButton, "ivalid Station");
				
			}
			else
			{
				JOptionPane.showMessageDialog(btnNewButton, "Name:"+n+"\n From Station:"+f+"\n To Station:"+t+"\n No of tickets:"+ti+"\n Pirce :"+bill);
			}
					
			
			
			
			
			
			
			
			
//				JOptionPane.showMessageDialog(btnNewButton, "Name:"+n+"\n From Station:"+f+"\n To Station:"+t+"\n No of tickets:"+ti+"\n Pirce :"+bill);
			}
		});
		btnNewButton.setBounds(160, 169, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		//b.setVisible(true);
		frame.setVisible(true);
		
	}

}
