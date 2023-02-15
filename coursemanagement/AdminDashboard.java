package coursemanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class AdminDashboard {

	public JFrame frame;
	private JTable coursesTable;
	private JTable moduleTable;
	private JTable teacherTable;
	private JTable studentTable;
	private JTable adminTable;
	JPanel topPanel = new JPanel();
	JPanel leftPanel = new JPanel();
	JPanel rightPanel = new JPanel();
	
	JPanel teachersPanel = new JPanel();
	JPanel adminPanel = new JPanel();
	JPanel studentPanel = new JPanel();
	JPanel coursesPanel = new JPanel();

	private CardLayout rightLayout=new CardLayout(0, 0);
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboard window = new AdminDashboard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminDashboard() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(250, 50, 1068, 747);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(SystemColor.controlHighlight);
		topPanel.setBounds(0, 0, 1052, 86);
		frame.getContentPane().add(topPanel);
		topPanel.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AdminDashboard().frame.setVisible(true);
				frame.dispose();
				
			}
		});
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon("E:\\College\\Year 2\\SEM 1\\Object Oriented Design and Programming\\All programs\\Course_Management\\src\\coursemanagement\\images\\logo.png"));
		logo.setBounds(0, 0, 111, 84);
		topPanel.add(logo);
		
		JLabel logout = new JLabel("");
		logout.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new loginPage().frame.setVisible(true);
				frame.dispose();
			}
		});
		logout.setHorizontalAlignment(SwingConstants.CENTER);
		logout.setIcon(new ImageIcon("E:\\College\\Year 2\\SEM 1\\Object Oriented Design and Programming\\All programs\\Course_Management\\src\\coursemanagement\\images\\logout.png"));
		logout.setBounds(988, 0, 42, 56);
		topPanel.add(logout);
		
		JLabel logoutLabel = new JLabel("Logout");
		logoutLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		logoutLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logoutLabel.setBounds(982, 55, 48, 20);
		topPanel.add(logoutLabel);
		
		leftPanel.setBackground(new Color(102, 102, 102));
		leftPanel.setBounds(12, 97, 217, 598);
		frame.getContentPane().add(leftPanel);
		leftPanel.setLayout(null);
		
		JLabel adminContent = new JLabel("");
		adminContent.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				rightLayout.show(rightPanel,"name_392052692231600");
			}
		});
		JLabel studentContent = new JLabel("");
		studentContent.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				rightLayout.show(rightPanel,"name_391832980191500");
			}
		});
		JLabel teaherContent = new JLabel("");
		teaherContent.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				rightLayout.show(rightPanel,"name_391571554964500");
			}
		});
		JLabel courseContent = new JLabel("");
		courseContent.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				rightLayout.show(rightPanel,"name_388480798351600");
			}
		});
		
		
		studentContent.setHorizontalAlignment(SwingConstants.CENTER);
		studentContent.setIcon(new ImageIcon("E:\\College\\Year 2\\SEM 1\\Object Oriented Design and Programming\\All programs\\Course_Management\\src\\coursemanagement\\images\\students.png"));
		studentContent.setBounds(0, 139, 217, 91);
		leftPanel.add(studentContent);
		
		JLabel studentLabel = new JLabel("Students");
		studentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		studentLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		studentLabel.setBounds(0, 234, 217, 14);
		leftPanel.add(studentLabel);
		
		JLabel teacherLabel = new JLabel("Teachers");
		teacherLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		teacherLabel.setHorizontalAlignment(SwingConstants.CENTER);
		teacherLabel.setBounds(0, 363, 217, 23);
		leftPanel.add(teacherLabel);
		
	
		teaherContent.setIcon(new ImageIcon("E:\\College\\Year 2\\SEM 1\\Object Oriented Design and Programming\\All programs\\Course_Management\\src\\coursemanagement\\images\\teachers1.png"));
		teaherContent.setHorizontalAlignment(SwingConstants.CENTER);
		teaherContent.setBounds(0, 275, 217, 91);
		leftPanel.add(teaherContent);
		
		
		courseContent.setIcon(new ImageIcon("E:\\College\\Year 2\\SEM 1\\Object Oriented Design and Programming\\All programs\\Course_Management\\src\\coursemanagement\\images\\course.png"));
		courseContent.setHorizontalAlignment(SwingConstants.CENTER);
		courseContent.setBounds(0, 402, 217, 91);
		leftPanel.add(courseContent);
		
		JLabel courseLabel = new JLabel("Courses");
		courseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		courseLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		courseLabel.setBounds(0, 480, 217, 23);
		leftPanel.add(courseLabel);
		
		
		
		adminContent.setIcon(new ImageIcon("E:\\College\\Year 2\\SEM 1\\Object Oriented Design and Programming\\All programs\\Course_Management\\src\\coursemanagement\\images\\admin.png"));
		adminContent.setHorizontalAlignment(SwingConstants.CENTER);
		adminContent.setBounds(0, 11, 217, 91);
		leftPanel.add(adminContent);
		
		JLabel adminLabel = new JLabel("Admin");
		adminLabel.setHorizontalAlignment(SwingConstants.CENTER);
		adminLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		adminLabel.setBounds(0, 99, 217, 14);
		leftPanel.add(adminLabel);
		
		
		rightPanel.setBounds(229, 97, 813, 598);
		frame.getContentPane().add(rightPanel);
		rightPanel.setLayout(rightLayout);
		
		
		rightPanel.add(adminPanel, "name_392052692231600");
		adminPanel.setLayout(null);
		
		JLabel displayAdminLabel = new JLabel("Admin:");
		displayAdminLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		displayAdminLabel.setBounds(23, 25, 106, 14);
		adminPanel.add(displayAdminLabel);
		
		JButton addAdminBtn = new JButton("Add Admin");
		addAdminBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddAdmin();
			}
		});
		addAdminBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		addAdminBtn.setBounds(682, 533, 121, 23);
		adminPanel.add(addAdminBtn);
		
		JScrollPane adminScroll = new JScrollPane();
		adminScroll.setBounds(33, 50, 770, 474);
		adminPanel.add(adminScroll);
		
		adminTable = new JTable();
		adminTable.setCellSelectionEnabled(true);
		adminScroll.setViewportView(adminTable);
		adminTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Address", "Phone", "DOB"
			}
		));
		adminTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		adminTable.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
			    int selectedRow=adminTable.getSelectedRow();
			    if(selectedRow!=-1) {
			    	int id= (int) adminTable.getValueAt(selectedRow,0);
			    	new Admin().edit(id);
			    }
		}});
		rightPanel.add(studentPanel, "name_391832980191500");
		studentPanel.setLayout(null);
		
		JLabel displayStudentLabel = new JLabel("Students:");
		displayStudentLabel.setBounds(23, 25, 106, 14);
		displayStudentLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		studentPanel.add(displayStudentLabel);
		
		JScrollPane studentScroll = new JScrollPane();
		studentScroll.setBounds(33, 50, 770, 474);
		studentPanel.add(studentScroll);
		
		studentTable = new JTable();
		studentTable.setCellSelectionEnabled(true);
		studentScroll.setViewportView(studentTable);
		studentTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Id","Name","Address","Phone", "Dob", "Level","Course", "Marks1" ,"Marks2", "Marks3" 
			}
		));
		studentTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow2=studentTable.getSelectedRow();
				if(selectedRow2>=0) {
					int id= (int) studentTable.getValueAt(selectedRow2,0);
					new Student().edit(id);
				}
			}
		});
		studentTable.getColumnModel().getColumn(5).setPreferredWidth(74);
		studentTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		
		
		
		rightPanel.add(teachersPanel, "name_391571554964500");
		teachersPanel.setLayout(null);
		JLabel displayTeachersLabel = new JLabel("Teachers:");
		displayTeachersLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		displayTeachersLabel.setBounds(23, 25, 106, 14);
		teachersPanel.add(displayTeachersLabel);
		
		JButton addTeacherBtn = new JButton("Add Teacher");
		addTeacherBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddTeacher();
			}
		});
		addTeacherBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		addTeacherBtn.setBounds(650, 535, 153, 23);
		teachersPanel.add(addTeacherBtn);
		
		JScrollPane teacherScroll = new JScrollPane();
		teacherScroll.setBounds(33, 50, 770, 474);
		teachersPanel.add(teacherScroll);
		
		teacherTable = new JTable();
		teacherTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow3=teacherTable.getSelectedRow();
				if(selectedRow3!=-1) {
					int id=(int) teacherTable.getValueAt(selectedRow3, 0);
					new Teacher().edit(id);
				}
			}
		});
		teacherScroll.setViewportView(teacherTable);
		teacherTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Name","Address","Phone","DOB"
				}
			));
		teacherTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		
		rightPanel.add(coursesPanel, "name_388480798351600");
		coursesPanel.setLayout(null);
		
		JLabel displayCourseLabel = new JLabel("Courses:");
		displayCourseLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		displayCourseLabel.setBounds(23, 25, 106, 14);
		coursesPanel.add(displayCourseLabel);
		
		JButton addCourseBtn = new JButton("Add Course");
		addCourseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddCourse();	
			}
		});
		addCourseBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		addCourseBtn.setBounds(657, 226, 146, 23);
		coursesPanel.add(addCourseBtn);
		
		JLabel displayModuleLabel = new JLabel("Modules");
		displayModuleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		displayModuleLabel.setBounds(23, 271, 84, 14);
		coursesPanel.add(displayModuleLabel);
		
		JButton addModuleBtn = new JButton("Add Module");
		addModuleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddModule().frame.setVisible(true);
			}
		});
		addModuleBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		addModuleBtn.setBounds(657, 475, 146, 23);
		coursesPanel.add(addModuleBtn);
		
		JScrollPane courseScroll = new JScrollPane();
		courseScroll.setBounds(33, 56, 770, 159);
		coursesPanel.add(courseScroll);
		
		coursesTable = new JTable();
		coursesTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow4 = coursesTable.getSelectedRow();
				if (selectedRow4 != -1) {
				  String idString = coursesTable.getValueAt(selectedRow4, 0).toString();
				  try {
				    int id = Integer.parseInt(idString);
				    new Courses().edit(id);
				  } catch (NumberFormatException nfe) {
				    System.out.println("Unable to parse " + idString + " to an integer.");
				  }
				}

			}
		});

		courseScroll.setViewportView(coursesTable);
		coursesTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Name"
				}
			));
		JScrollPane moduleScroll = new JScrollPane();
		moduleScroll.setBounds(33, 296, 770, 165);
		coursesPanel.add(moduleScroll);
		
		
		moduleTable = new JTable();
		moduleTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow5 = moduleTable.getSelectedRow();
				if (selectedRow5 != -1) {
				  String idString = moduleTable.getValueAt(selectedRow5, 0).toString();
				  try {
				    int id = Integer.parseInt(idString);
				    new Modules().edit(id);
				  } catch (NumberFormatException nfe) {
				    System.out.println("Unable to parse " + idString + " to an integer.");
				  }
				}
		}
		});
		moduleScroll.setViewportView(moduleTable);
		moduleTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Name","Level","Course_id"
				}
			));
		viewStudent();
		viewAdmin();
		viewCourses();
		viewModules();
		viewTeacher();
		viewOptional();
	}
	public void viewAdmin() {
		ArrayList<Admin> list=new Admin().informationList();
		DefaultTableModel model=(DefaultTableModel) adminTable.getModel();
		Object[] row = new Object[5];
		for(int i=0; i<list.size();i++) {
			row[0]=list.get(i).getId();
			row[1]=list.get(i).getName();
			row[2]=list.get(i).getAddress();
			row[3]=list.get(i).getPhone();
			row[4]=list.get(i).getDob();
			model.addRow(row);
		}
	}
	public void viewStudent() {
		ArrayList<Student> list=new Student().informationList();
		DefaultTableModel model=(DefaultTableModel) studentTable.getModel();
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
			model.addRow(row);
		}
	}
	public void viewTeacher() {
		ArrayList<Teacher> list=new Teacher().informationList();
		DefaultTableModel model=(DefaultTableModel) teacherTable.getModel();
		Object[] row = new Object[10];
		for(int i=0; i<list.size();i++) {
			row[0]=list.get(i).getId();
			row[1]=list.get(i).getName();
			row[2]=list.get(i).getAddress();
			row[3]=list.get(i).getPhone();
			row[4]=list.get(i).getDob();
			model.addRow(row);
		}
		
	}
	public void viewCourses() {
		ArrayList<Courses> list=new Courses().informationList();
		DefaultTableModel model2=(DefaultTableModel) coursesTable.getModel();
		Object[] row = new Object[10];
		for(int i=0; i<list.size();i++) {
			row[0]=list.get(i).getId();
			row[1]=list.get(i).getName();
			model2.addRow(row);
		}
	}
	public void viewModules() {
		ArrayList<Modules> list=new Modules().informationList();
		DefaultTableModel model2=(DefaultTableModel) moduleTable.getModel();
		Object[] row = new Object[10];
		for(int i=0; i<list.size();i++) {
			row[0]=list.get(i).getId();
			row[1]=list.get(i).getName();
			row[2]=list.get(i).getLevel();
			row[3]=list.get(i).getC_id();
			model2.addRow(row);
		}
	}
	public void viewOptional() {
		ArrayList<OptionalModule> list=new OptionalModule().informationList();
		DefaultTableModel model2=(DefaultTableModel) moduleTable.getModel();
		Object[] row = new Object[10];
		for(int i=0; i<list.size();i++) {
			row[0]=list.get(i).getId();
			row[1]=list.get(i).getName();
			row[3]=list.get(i).getC_id();
			model2.addRow(row);
		}
	}
}
