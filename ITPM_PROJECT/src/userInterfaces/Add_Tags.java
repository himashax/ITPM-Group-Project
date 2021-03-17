package userInterfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import models.Tags;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add_Tags implements ActionListener {

	private JFrame frame;
	private JTextField tagName;
	private JTextField tagCode;
	private JComboBox relatedTag;
	private JButton clearBtn, saveBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Tags window = new Add_Tags();
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
	public Add_Tags() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 870, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(95, 77, 657, 343);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tag Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(116, 49, 63, 15);
		panel.add(lblNewLabel);
		
		tagName = new JTextField();
		tagName.setBounds(245, 42, 281, 30);
		panel.add(tagName);
		tagName.setColumns(10);
		
		JLabel lblTagCode = new JLabel("Tag Code");
		lblTagCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTagCode.setBounds(116, 106, 63, 15);
		panel.add(lblTagCode);
		
		tagCode = new JTextField();
		tagCode.setColumns(10);
		tagCode.setBounds(245, 100, 281, 30);
		panel.add(tagCode);
		
		JLabel lblRelativeTag = new JLabel("Related Tag");
		lblRelativeTag.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRelativeTag.setBounds(116, 169, 78, 15);
		panel.add(lblRelativeTag);
		
		String tags[] = {"Lecture", "Tutorial", "Lab|Practical", "Evaluation"};
		
		relatedTag = new JComboBox(tags);
		relatedTag.setBackground(Color.WHITE);
		relatedTag.setBounds(245, 162, 281, 30);
		panel.add(relatedTag);
		
		saveBtn = new JButton("New button");
		saveBtn.setBackground(new Color(102, 153, 255));
		saveBtn.setForeground(Color.WHITE);
		saveBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		saveBtn.setBounds(400, 256, 178, 30);
		saveBtn.addActionListener(this);
		panel.add(saveBtn);
		
		clearBtn = new JButton("Clear");
		clearBtn.setBackground(Color.LIGHT_GRAY);
		clearBtn.setForeground(Color.DARK_GRAY);
		clearBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		clearBtn.setBounds(81, 256, 178, 30);
		clearBtn.addActionListener(this);
		panel.add(clearBtn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(0, 0, 854, 30);
		frame.getContentPane().add(panel_1);
	}

	public void resetFields() {
		tagName.setText("");
		tagCode.setText("");
		relatedTag.setSelectedIndex(0);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == saveBtn) {
			String tag_name = tagName.getText();
			String tag_code = tagCode.getText();
			String related_tag = relatedTag.getSelectedItem().toString();
			
			Tags tag = new Tags();
			tag.insertTags(tag_name, tag_code, related_tag);
			resetFields();
			
		}else if(obj == clearBtn) {
			resetFields();
		}
	}
}
