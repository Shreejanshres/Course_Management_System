package coursemanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TeacherDashboard {
	private String email;
	private JFrame frame;
	JTable studentTable;
	JLabel moduleName = new JLabel();
	private JTextField idInput;
	private JTextField mark1Input;
	private JTextField mark2Input;
	private JTextField mark3Input;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherDashboard window = new TeacherDashboard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public String getEmail() {
		return email;
	}
	public TeacherDashboard() {
		initialize();
	}
	public TeacherDashboard(String email) {
		this.email=email;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(250, 50, 1068, 747);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(SystemColor.controlHighlight);
		topPanel.setBounds(0, 0, 1052, 84);
		frame.getContentPane().add(topPanel);
		topPanel.setLayout(null);
		
		JLabel logo = new JLabel();
		logo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TeacherDashboard(getEmail());
				frame.dispose();
				
			}
		});
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
		bottomPanel.setBounds(0, 83, 1052, 625);
		frame.getContentPane().add(bottomPanel);
		bottomPanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Students");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(23, 11, 120, 43);
		bottomPanel.add(lblNewLabel_2);
		
		JScrollPane studentScroll = new JScrollPane();
		studentScroll.setBounds(23, 52, 773, 562);
		bottomPanel.add(studentScroll);
		
		studentTable = new JTable();
		studentTable.setEnabled(false);
		studentScroll.setViewportView(studentTable);
		studentTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Name", "Address", "Phone", "DOB","Level","Course_id","Marks1","Marks2","Marks3"
				}
			));
		
		
		moduleName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		moduleName.setBounds(806, 52, 236, 214);
		bottomPanel.add(moduleName);
		
		JPanel addMarksPanel = new JPanel();
		addMarksPanel.setBackground(SystemColor.scrollbar);
		addMarksPanel.setBounds(806, 277, 236, 337);
		bottomPanel.add(addMarksPanel);
		addMarksPanel.setLayout(null);
		
		JLabel addMarks = new JLabel("Add Marks");
		addMarks.setFont(new Font("Tahoma", Font.BOLD, 20));
		addMarks.setHorizontalAlignment(SwingConstants.CENTER);
		addMarks.setBounds(10, 11, 216, 30);
		addMarksPanel.add(addMarks);
		
		JLabel idLbl = new JLabel("ID:");
		idLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		idLbl.setBounds(22, 66, 46, 14);
		addMarksPanel.add(idLbl);
		
		JLabel mark1Lbl = new JLabel("Marks 1:");
		mark1Lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		mark1Lbl.setBounds(22, 106, 75, 14);
		addMarksPanel.add(mark1Lbl);
		
		JLabel mark2Lbl = new JLabel("Marks 2:");
		mark2Lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		mark2Lbl.setBounds(22, 146, 75, 14);
		addMarksPanel.add(mark2Lbl);
		
		JLabel mark3Lbl = new JLabel("Marks 3:");
		mark3Lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		mark3Lbl.setBounds(22, 186, 75, 14);
		addMarksPanel.add(mark3Lbl);
		
		idInput = new JTextField();
		idInput.setBounds(95, 66, 131, 20);
		addMarksPanel.add(idInput);
		idInput.setColumns(10);
		
		mark1Input = new JTextField();
		mark1Input.setColumns(10);
		mark1Input.setBounds(95, 106, 131, 20);
		addMarksPanel.add(mark1Input);
		
		mark2Input = new JTextField();
		mark2Input.setColumns(10);
		mark2Input.setBounds(95, 146, 131, 20);
		addMarksPanel.add(mark2Input);
		
		mark3Input = new JTextField();
		mark3Input.setColumns(10);
		mark3Input.setBounds(95, 186, 131, 20);
		addMarksPanel.add(mark3Input);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=idInput.getText();
				String mark1=mark1Input.getText();
				String mark2=mark2Input.getText();
				String mark3=mark3Input.getText();
				new Teacher().addMarks(id, mark1, mark2, mark3);
				JOptionPane.showMessageDialog(null, "Please click logo to refresh the page.", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(76, 265, 89, 23);
		addMarksPanel.add(btnNewButton);
		viewStudent();
		showCourse();
	}
	public void viewStudent() {
		ArrayList<Student> list=new Student().informationList();
		DefaultTableModel model2=(DefaultTableModel) studentTable.getModel();
		Object[] row = new Object[10];
		for(int i=0; i<list.size();i++) {
			row[0]=list.get(i).getId();
			row[1]=list.get(i).getName();
			row[2]=list.get(i).getAddress();
			row[3]=list.get(i).getPhone();
			row[4]=list.get(i).getDob();
			row[5]=list.get(i).getLevel();
			row[6]=list.get(i).getCourse();
			row[7]=list.get(i).getMarks1();
			row[8]=list.get(i).getMarks2();
			row[9]=list.get(i).getMarks3();
			model2.addRow(row);
		}
	}
	public void showCourse() {
		String module=new Teacher().getmodule(getEmail());
		moduleName.setText(module);
	}
}
