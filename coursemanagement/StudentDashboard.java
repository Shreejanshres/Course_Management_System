package coursemanagement;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class StudentDashboard {
	private String mark1;
	private String mark2;
	private String mark3;
	private String result;
	public JFrame frame;
	private JTable teacherTable;
	public JLabel mark1Show = new JLabel();
	public JLabel mark2Show = new JLabel();
	public JLabel mark3Show = new JLabel();
	public JLabel resultShow = new JLabel();

	public StudentDashboard(int mark1, int mark2, int mark3,String result) {
		this.mark1=String.valueOf(mark1);
		this.mark2=String.valueOf(mark2);
		this.mark3=String.valueOf(mark3);
		this.result=result;
		initialize();
	}
	public String getMark1() {
		return mark1;
	}
	public String getMark2() {
		return mark2;
	}
	public String getMark3() {
		return mark3;
	}
	public String getResult() {
		return result;
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(250, 50, 1068, 747);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(SystemColor.controlHighlight);
		topPanel.setBounds(0, 0, 1052, 84);
		frame.getContentPane().add(topPanel);
		topPanel.setLayout(null);
		
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("E:\\College\\Year 2\\SEM 1\\Object Oriented Design and Programming\\All programs\\Course_Management\\src\\coursemanagement\\images\\logo.png"));
		logo.setBounds(0, 0, 111, 84);
		topPanel.add(logo);
		
		JLabel logout = new JLabel();
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new loginPage().frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		logout.setIcon(new ImageIcon("E:\\College\\Year 2\\SEM 1\\Object Oriented Design and Programming\\All programs\\Course_Management\\src\\coursemanagement\\images\\logout.png"));
		logout.setBounds(988, 0, 42, 56);
		topPanel.add(logout);
		
		JLabel lblNewLabel_1 = new JLabel("Logout");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(982, 55, 48, 20);
		topPanel.add(lblNewLabel_1);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBounds(10, 94, 1034, 606);
		frame.getContentPane().add(bottomPanel);
		bottomPanel.setLayout(null);
		
		JLabel welcomeLbl = new JLabel("Welcome");
		welcomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLbl.setFont(new Font("Tahoma", Font.BOLD, 35));
		welcomeLbl.setBounds(10, 21, 1046, 42);
		bottomPanel.add(welcomeLbl);
		
		JLabel teacherLbl = new JLabel("Your Teachers:");
		teacherLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		teacherLbl.setHorizontalAlignment(SwingConstants.CENTER);
		teacherLbl.setBounds(10, 73, 192, 30);
		bottomPanel.add(teacherLbl);
		
		JScrollPane teacherScroll = new JScrollPane();
		teacherScroll.setBounds(34, 113, 798, 472);
		bottomPanel.add(teacherScroll);
		
		teacherTable = new JTable();
		teacherScroll.setViewportView(teacherTable);
		teacherTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Name", "Email","Module"
				}
			));
		teacherTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel marksLbl = new JLabel("Report");
		marksLbl.setHorizontalAlignment(SwingConstants.CENTER);
		marksLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		marksLbl.setBounds(832, 73, 192, 30);
		bottomPanel.add(marksLbl);
		
		JLabel mark1Lbl = new JLabel("Marks1:");
		mark1Lbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		mark1Lbl.setBounds(842, 138, 75, 22);
		bottomPanel.add(mark1Lbl);
		
		JLabel marks2Lbl = new JLabel("Marks2:");
		marks2Lbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		marks2Lbl.setBounds(842, 184, 75, 22);
		bottomPanel.add(marks2Lbl);
		
		JLabel marks3Lbl = new JLabel("Marks3:");
		marks3Lbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		marks3Lbl.setBounds(842, 229, 75, 22);
		bottomPanel.add(marks3Lbl);
		
		JLabel resultLbl = new JLabel("Result:");
		resultLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		resultLbl.setBounds(842, 278, 75, 22);
		bottomPanel.add(resultLbl);
		
		
		mark1Show.setFont(new Font("Tahoma", Font.BOLD, 18));
		mark1Show.setBounds(949, 138, 75, 22);
		bottomPanel.add(mark1Show);
		
	
		mark2Show.setFont(new Font("Tahoma", Font.BOLD, 18));
		mark2Show.setBounds(949, 184, 75, 22);
		bottomPanel.add(mark2Show);
		
		
		mark3Show.setFont(new Font("Tahoma", Font.BOLD, 18));
		mark3Show.setBounds(949, 229, 75, 22);
		bottomPanel.add(mark3Show);
		
		resultShow.setFont(new Font("Tahoma", Font.BOLD, 18));
		resultShow.setBounds(949, 278, 75, 22);
		bottomPanel.add(resultShow);
		viewTeacher();
		setLabel();
	}
	public void viewTeacher() {
		String a;
		ArrayList<Teacher> list=new Teacher().informationList();
		DefaultTableModel model=(DefaultTableModel) teacherTable.getModel();
		Object[] row = new Object[10];
		for(int i=0; i<list.size();i++) {
			row[0]=list.get(i).getName();
			a=list.get(i).getEmail();
			row[1]=a;
			row[2]=list.get(i).getmodule(a);
			model.addRow(row);
		}
		
	}
	public void setLabel() {
		mark1Show.setText(getMark1());
		mark2Show.setText(getMark2());
		mark3Show.setText(getMark3());
		resultShow.setText(getResult());
		
		
	}
	
	
	
}
