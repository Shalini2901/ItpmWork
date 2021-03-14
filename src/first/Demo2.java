package first;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import java.awt.Color;

public class Demo2 implements ActionListener{

	private JFrame frame;
	private JButton createBtn, deleteBtn;
	private JSpinner startH,startM,startS,endH,endM,endS; 
	private DefaultTableModel mngModel;
	private JTable timeslotTable;
	private JScrollPane scPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo2 window = new Demo2();
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
	public Demo2() {
		initialize();
		
	}
	
	PreparedStatement ps;
	private JPanel panel_1;
	
	public Connection connect() {
		Connection connection=null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/itpm", "root", "");
			
			if(connection != null) {
				System.out.println("Successfully connected");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return connection;
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
		panel.setBounds(109, 33, 537, 253);
		panel.setBackground(SystemColor.scrollbar);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		mngModel = new DefaultTableModel(new String[]{"id","SHour", "SMin", "SSec","EHour","EMin","ESec"}, 0);
		timeslotTable = new JTable(mngModel);
		timeslotTable.setBounds(622, 154, -500, -93);
		
		
		JTableHeader head = timeslotTable.getTableHeader();
		head.setBackground(new Color(102, 153, 255));
		head.setFont(new Font("Tahoma", Font.BOLD, 11));
		head.setForeground(Color.white);
		
		
		JLabel lblNewLabel = new JLabel("Starting Time");
		lblNewLabel.setBounds(86, 49, 90, 24);
		panel.add(lblNewLabel);
		
		JLabel lblEndingTime = new JLabel("Ending Time");
		lblEndingTime.setBounds(86, 95, 90, 24);
		panel.add(lblEndingTime);
		
		endH = new JSpinner();
		endH.setBounds(203, 96, 59, 23);
		panel.add(endH);
		
		startS = new JSpinner();
		startS.setBounds(407, 50, 59, 23);
		panel.add(startS);
		
		startH = new JSpinner();
		startH.setBounds(203, 50, 59, 23);
		panel.add(startH);
		
		endM = new JSpinner();
		endM.setBounds(304, 96, 59, 23);
		panel.add(endM);
		
		endS = new JSpinner();
		endS.setBounds(407, 96, 59, 23);
		panel.add(endS);
		
		startM = new JSpinner();
		startM.setBounds(304, 50, 59, 23);
		panel.add(startM);
		
		createBtn = new JButton("CREATE");
		createBtn.setBackground(SystemColor.textHighlight);
		createBtn.setForeground(SystemColor.window);
		createBtn.setBounds(177, 170, 90, 32);
		createBtn.addActionListener(this);
		panel.add(createBtn);
		
		deleteBtn = new JButton("DELETE");
		deleteBtn.setBounds(333, 170, 90, 32);
		deleteBtn.addActionListener(this);
		panel.add(deleteBtn);
		
		panel_1 = new JPanel();
		panel_1.setBounds(58, 386, 682, 226);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		timeslotTable = new JTable();
		timeslotTable.setBounds(46, 171, 546, -135);
		panel_1.add(timeslotTable);
		timeslotTable = new JTable(mngModel);
		timeslotTable.setBounds(622, 154, -500, -93);
		
		
		scPane = new JScrollPane(timeslotTable);
		scPane.setBounds(21, 21, 638, 183);
		panel_1.add(scPane);
		
	}

	
	public String insertTimeSlot(int SHour, int SMin,int SSec, int EHour,int EMin,int ESec) {
		String outcome = "";
		
		try {
		    Connection connection = connect();
		    String insertQry = "insert into timeslot values ('1','"+SHour+"', '"+SMin+"', '"+SSec+"','"+EHour+"','"+EMin+"','"+ESec+"')";
		
		
			PreparedStatement ps = connection.prepareStatement(insertQry);
			if(ps.execute()) {
				outcome = "Inserted Successfully";
			}
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		Object ob = e.getSource();
		if(ob == createBtn) {
			//int startH =Integer.parseInt(ti.getSelectedItem().toString()) ;
		}
	}
}
