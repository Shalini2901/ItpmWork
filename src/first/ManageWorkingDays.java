package first;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;

public class ManageWorkingDays implements ActionListener{

	private JFrame frame;
	private JTable table;
	private JTable manageDays;
	private DefaultTableModel manageModel;
	private JScrollPane scPane;
	private JTextField hours;
	private JTextField min;
	private JButton btnUpdate,btnDelete;
	private JComboBox noOfDays;
	private int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageWorkingDays window = new ManageWorkingDays();
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
	public ManageWorkingDays() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(26, 29, 720, 196);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		manageModel = new DefaultTableModel(new String[]{"id","workingDays", "workingTimePerDay", "minutes","noOfWorkingDays"}, 0);
		manageDays = new JTable(manageModel);
		manageDays.setBounds(622, 154, -500, -93);
		
		
		JTableHeader head = manageDays.getTableHeader();
		head.setBackground(new Color(102, 153, 255));
		head.setFont(new Font("Tahoma", Font.BOLD, 11));
		head.setForeground(Color.white);
		
		scPane = new JScrollPane(manageDays);
		scPane.setBounds(20,37,500,144);
		workingDayList();
		panel.add(scPane);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(598, 40, 85, 21);
		btnUpdate.addActionListener(this);
		panel.add(btnUpdate);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setBounds(598, 110, 85, 21);
		btnDelete.addActionListener(this);
		panel.add(btnDelete);
		manageDays.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row= manageDays.getSelectedRow();
				id = Integer.parseInt(manageModel.getValueAt(row, 0).toString());
				noOfDays.setSelectedItem(manageModel.getValueAt(row, 4).toString());
				hours.setText(manageModel.getValueAt(row,2).toString());
				min.setText(manageModel.getValueAt(row, 3).toString());
			}
			});
	
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(65, 105, 225)), "Update | Delete Working Days and Hours", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 130, 180)));
		panel_1.setBackground(SystemColor.scrollbar);
		panel_1.setBounds(36, 270, 720, 250);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNoOfWorking = new JLabel("No of Working Days");
		lblNoOfWorking.setBounds(59, 50, 113, 23);
		panel_1.add(lblNoOfWorking);
		
		JLabel lblWorkingDays = new JLabel("Working Days");
		lblWorkingDays.setBounds(59, 100, 90, 23);
		panel_1.add(lblWorkingDays);
		
		String[] data= {"5","2"};
		noOfDays = new JComboBox(data);
		noOfDays.setBounds(210, 50, 167, 23);
		panel_1.add(noOfDays);
		
		JCheckBox chkMonday = new JCheckBox("Monday");
		chkMonday.setBounds(210, 101, 77, 21);
		panel_1.add(chkMonday);
		
		JCheckBox chkTuesday = new JCheckBox("Tuesday");
		chkTuesday.setBounds(296, 101, 81, 21);
		panel_1.add(chkTuesday);
		
		JCheckBox chkWednesday = new JCheckBox("Wednesday");
		chkWednesday.setBounds(390, 101, 93, 21);
		panel_1.add(chkWednesday);
		
		JCheckBox chkThursday = new JCheckBox("Thursday");
		chkThursday.setBounds(496, 101, 93, 21);
		panel_1.add(chkThursday);
		
		JCheckBox chkFriday = new JCheckBox("Friday");
		chkFriday.setBounds(603, 101, 93, 21);
		panel_1.add(chkFriday);
		
		JCheckBox chkSaturday = new JCheckBox("Saturday");
		chkSaturday.setBounds(210, 145, 77, 21);
		panel_1.add(chkSaturday);
		
		JCheckBox chkSunday = new JCheckBox("Sunday");
		chkSunday.setBounds(296, 145, 80, 21);
		panel_1.add(chkSunday);
		
		JLabel lblWorkingTimePer = new JLabel("Working Time Per Day");
		lblWorkingTimePer.setBounds(59, 199, 130, 23);
		panel_1.add(lblWorkingTimePer);
		
		hours = new JTextField();
		hours.setBounds(210, 199, 96, 23);
		panel_1.add(hours);
		hours.setColumns(10);
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setBounds(316, 204, 45, 13);
		panel_1.add(lblHours);
		
		min = new JTextField();
		min.setBounds(390, 199, 96, 23);
		panel_1.add(min);
		min.setColumns(10);
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setBounds(496, 204, 55, 14);
		panel_1.add(lblMinutes);
		
	}
	
	public void workingDayList() {
		DaysndHours dh = new DaysndHours();
		ArrayList<DaysndHours> dayList = dh.workingDayList();
		DefaultTableModel tableModel = (DefaultTableModel)manageDays.getModel();
		Object[] row = new Object[5];
		for(int i=0;i<dayList.size();i++) {
			row[0]=dayList.get(i).getId();
			row[1]=dayList.get(i).getWorkingDays();
			row[2]=dayList.get(i).getWorkingTimePerDay();
			row[3]=dayList.get(i).getMin();
			row[4]=dayList.get(i).getNoOfWorkingDays();			
			
			tableModel.addRow(row);
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob = e.getSource();
		if(ob == btnUpdate) {
			int hr = Integer.parseInt(hours.getText().toString());
			int mint = Integer.parseInt(min.getText().toString());
			int day= Integer.parseInt(noOfDays.getSelectedItem().toString());
			System.out.println(day);
			DaysndHours dh = new DaysndHours();
			dh.updateWorkingDays(1,"Friday", hr,mint, day );
		}
		
		
	}
	
	
}
