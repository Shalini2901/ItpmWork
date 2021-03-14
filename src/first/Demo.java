package first;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class Demo implements ActionListener{

	private JFrame frame;
	private JTextField minutes;
	private JTextField workingTime;
	private JComboBox workingdays;
	private JButton add,reset;
	private JCheckBox monday,tuesday,wednesday,thursday,friday,sat,sun; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo window = new Demo();
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
	public Demo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setBounds(100, 100,820, 639);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 255), new Color(160, 160, 160)), "ADD WORKING DAYS HOURS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(65, 105, 225)));
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(59, 25, 690, 554);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("No of Working Days");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(24, 41, 123, 23);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Working Days");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(24, 99, 96, 23);
		panel.add(lblNewLabel_1);
		
		monday = new JCheckBox("Monday");
		monday.setBackground(new Color(240, 255, 255));
		monday.setFont(new Font("Arial", Font.PLAIN, 12));
		monday.setBounds(200, 101, 93, 21);
		panel.add(monday);
		
		tuesday = new JCheckBox("Tuesday");
		tuesday.setBackground(new Color(240, 255, 255));
		tuesday.setFont(new Font("Arial", Font.PLAIN, 12));
		tuesday.setBounds(200, 137, 93, 21);
		panel.add(tuesday);
		
		wednesday = new JCheckBox("Wednesday");
		wednesday.setBackground(new Color(240, 255, 255));
		wednesday.setFont(new Font("Arial", Font.PLAIN, 12));
		wednesday.setBounds(200, 180, 93, 21);
		panel.add(wednesday);
		
		thursday = new JCheckBox("Thursday");
		thursday.setBackground(new Color(240, 255, 255));
		thursday.setFont(new Font("Arial", Font.PLAIN, 12));
		thursday.setBounds(200, 222, 93, 21);
		panel.add(thursday);
		
		friday = new JCheckBox("Friday");
		friday.setBackground(new Color(240, 255, 255));
		friday.setFont(new Font("Arial", Font.PLAIN, 12));
		friday.setBounds(200, 265, 93, 21);
		panel.add(friday);
		
		sat = new JCheckBox("Saturday");
		sat.setBackground(new Color(240, 255, 255));
		sat.setFont(new Font("Arial", Font.PLAIN, 12));
		sat.setBounds(340, 101, 93, 21);
		panel.add(sat);
		
		sun = new JCheckBox("Sunday");
		sun.setBackground(new Color(240, 255, 255));
		sun.setFont(new Font("Arial", Font.PLAIN, 12));
		sun.setBounds(340, 137, 93, 21);
		panel.add(sun);
		
		JLabel lblNewLabel_1_1 = new JLabel("Working Time Per Day");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(25, 324, 145, 23);
		panel.add(lblNewLabel_1_1);
		
		minutes = new JTextField();
		minutes.setBackground(new Color(240, 255, 255));
		minutes.setColumns(10);
		minutes.setBounds(381, 324, 123, 23);
		panel.add(minutes);
		
		add = new JButton("ADD");
		add.setForeground(SystemColor.window);
		add.setBackground(new Color(153, 204, 255));
		add.setBounds(95, 390, 93, 35);
		add.addActionListener(this);
		panel.add(add);
		
		reset = new JButton("RESET");
		reset.setBackground(new Color(255, 255, 255));
		reset.setBounds(348, 390, 85, 35);
		reset.addActionListener(this);
		panel.add(reset);
		
		workingTime = new JTextField();
		workingTime.setBackground(new Color(240, 255, 255));
		workingTime.setBounds(197, 325, 123, 23);
		panel.add(workingTime);
		workingTime.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Hours");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(330, 330, 45, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Minutes");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(519, 330, 54, 13);
		panel.add(lblNewLabel_3);
		
		String[] data= {"5","2"};
		workingdays = new JComboBox(data);
		workingdays.setBackground(new Color(240, 255, 255));
		workingdays.setBounds(200, 42, 123, 23);
		panel.add(workingdays);
		
		
	}
	
	
	
	public void clear() {
		workingdays.setSelectedIndex(0);
		workingTime.setText(null);
		minutes.setText(null);
		monday.setSelected(false);
		tuesday.setSelected(false);
		wednesday.setSelected(false);
		thursday.setSelected(false);
		friday.setSelected(false);
		sat.setSelected(false);
		sun.setSelected(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob = e.getSource();
		if(ob == add) {
			int noOf =Integer.parseInt(workingdays.getSelectedItem().toString()) ;
			int hours = Integer.parseInt(workingTime.getText());
			int min = Integer.parseInt(minutes.getText());
			
			ArrayList<String> days= new ArrayList<String>();
			//if (monday.isSelected()) {
                //JOptionPane.showMessageDialog(frame, "JCheckBox is selected");
				//days.add("monday");
            //}
            
			//System.out.println(s1);
			
			DaysndHours dh = new DaysndHours();
			dh.insertWorkingDays("Monday",hours,min,noOf);
	}
		
		if(ob == reset ) {
			
			clear();
		}
	}
}
