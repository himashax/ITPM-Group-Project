package userInterfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


import models.TimeSlot;

public class Demo2 implements ActionListener {


	private JFrame frame;
	private JButton createBtn, deleteBtn;
	private JSpinner startTime,endTime; 
	private DefaultTableModel mngModel;
	private JTable timeslotTable;
	private JScrollPane scPane;
	private JPanel panel_1;
	private int id;
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
		
		panel_1 = new JPanel();
		panel_1.setBounds(58, 386, 682, 226);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Starting Time");
		lblNewLabel.setBounds(86, 49, 90, 24);
		panel.add(lblNewLabel);
		
		JLabel lblEndingTime = new JLabel("Ending Time");
		lblEndingTime.setBounds(86, 95, 90, 24);
		panel.add(lblEndingTime);
		
		startTime = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor de_startTime = new JSpinner.DateEditor(startTime, "HH:mm:ss");
		startTime.setBounds(304, 50, 119, 23);
		startTime.setEditor(de_startTime);
		startTime.setValue(new Date());
		panel.add(startTime);
		
		endTime = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor de_endTime = new JSpinner.DateEditor(endTime, "HH:mm:ss");
		endTime.setEditor(de_endTime);
		endTime.setValue(new Date());
		endTime.setBounds(304, 96, 119, 23);
		panel.add(endTime);

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
		
		
		mngModel = new DefaultTableModel(new String[]{"id","SHour", "SMin"}, 0);
		timeslotTable = new JTable(mngModel);
		timeslotTable.setBounds(622, 154, -500, -93);
		
		timeslotTable = new JTable();
		timeslotTable.setBounds(46, 171, 546, -135);
		
		
		timeslotTable = new JTable(mngModel);
		timeslotTable.setBounds(622, 154, -500, -93);
		
		timeSlots();
		scPane = new JScrollPane(timeslotTable);
		scPane.setBounds(21, 21, 638, 183);
		panel_1.add(scPane);
		
		JTableHeader head = timeslotTable.getTableHeader();
		head.setBackground(new Color(102, 153, 255));
		head.setFont(new Font("Tahoma", Font.BOLD, 11));
		head.setForeground(Color.white);
		
		timeslotTable.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row= timeslotTable.getSelectedRow();
				id = Integer.parseInt(mngModel.getValueAt(row, 0).toString());
			}
			});
		
		
	}
		
	
	public void timeSlots() {
		TimeSlot ts = new TimeSlot();
		ArrayList<TimeSlot> list = ts.getTimeSlots();
		DefaultTableModel tableModel = (DefaultTableModel)timeslotTable.getModel();
		Object[] row = new Object[3];
		for(int i=0;i<list.size();i++) {
			row[0]=list.get(i).getId();
			row[1]=list.get(i).getStartTime();
			row[2]=list.get(i).getEndTime();
			tableModel.addRow(row);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		Object ob = e.getSource();
		if(ob == createBtn) {
			
			Date start_time =  (Date) startTime.getValue();
			Timestamp ts=new Timestamp(start_time.getTime());
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");  
			
            Date end_time =  (Date) endTime.getValue();
			Timestamp ts2=new Timestamp(end_time.getTime());
			SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm:ss");  
			
            TimeSlot tslot = new TimeSlot();
            tslot.createTimeSlot(formatter.format(ts), formatter2.format(ts2));
            DefaultTableModel tModel = (DefaultTableModel)timeslotTable.getModel();
            tModel.setRowCount(0);
			timeSlots();
		}
		if(ob == deleteBtn) {

			TimeSlot ts = new TimeSlot();
			ts.deleteTimeSlot(id);
			DefaultTableModel tModel = (DefaultTableModel)timeslotTable.getModel();
            tModel.setRowCount(0);
			timeSlots();
			
			
		}
	}

}
