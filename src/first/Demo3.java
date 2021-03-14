package first;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Demo3 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo3 window = new Demo3();
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
	public Demo3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.scrollbar);
		panel.setBounds(142, 362, 499, 227);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Session");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(144, 52, 45, 13);
		panel.add(lblNewLabel);
		
		JLabel lblTimeSlot = new JLabel("Time Slot");
		lblTimeSlot.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTimeSlot.setBounds(144, 105, 63, 13);
		panel.add(lblTimeSlot);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(238, 101, 133, 28);
		panel.add(comboBox);
		
		
		String values[]= {"Y3S1.12" , "Y3S1.13" , "Y3S1.14"};
		JComboBox comboBox_1 = new JComboBox(values);
		comboBox_1.setBounds(238, 40, 133, 28);
		panel.add(comboBox_1);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Roboto", Font.BOLD, 10));
		btnAdd.setBounds(208, 165, 85, 34);
		panel.add(btnAdd);
	}
}
