package metro_ticket_booking;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
public class Reg {

	private JFrame frame;
	private JTextField tb1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reg window = new Reg();
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
	public Reg() {
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
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(173, 11, 69, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Sitka Display", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 46, 58, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone No");
		lblNewLabel_2.setFont(new Font("Sitka Display", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 78, 69, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setFont(new Font("Sitka Display", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 108, 58, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Day");
		lblNewLabel_4.setFont(new Font("Sitka Display", Font.BOLD, 15));
		lblNewLabel_4.setBounds(10, 133, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		tb1 = new JTextField();
		tb1.setBounds(138, 47, 77, 14);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		JFormattedTextField tb2 = new JFormattedTextField();
		
		tb2.setBounds(138, 73, 77, 14);
		frame.getContentPane().add(tb2);
		
		JRadioButton r1 = new JRadioButton("Female");
		r1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		r1.setBounds(138, 102, 70, 14);
		frame.getContentPane().add(r1);
		
		JRadioButton r2 = new JRadioButton("Male");
		r2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		r2.setBounds(210, 102, 69, 14);
		frame.getContentPane().add(r2);
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		JComboBox c1 = new JComboBox();
		c1.setModel(new DefaultComboBoxModel(new String[] {"select day", "today", "tomorrow", "dayaftertomorrow"}));
		c1.setBounds(138, 127, 77, 14);
		frame.getContentPane().add(c1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\online lab\\Desktop\\img.png"));
		lblNewLabel_5.setBounds(10, 0, 58, 35);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n=tb1.getText();
				String phn=tb2.getText();
				String g;
				if(r1.isSelected())
				{
					g="Female";
				}
				else if(r2.isSelected())
				{
					g="Male";
				}
				else
				{
					g="Invalid";
				}
				String d=(String) c1.getSelectedItem();
				JOptionPane.showMessageDialog(btnNewButton,"Name:"+n+"\n Phone No:"+phn+"\n Gender:"+g+"\n Day:"+d);
				Ticket_Booking b=new Ticket_Booking();
				b.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(173, 163, 102, 14);
		frame.getContentPane().add(btnNewButton);
		
		
	}
}
