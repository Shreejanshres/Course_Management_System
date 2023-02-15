package coursemanagement;

import javax.swing.*;

import java.awt.Font;

import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddTeacher {

	public JFrame frame;
	private JTextField nameInput;
	private JTextField addressInput;
	private JTextField phoneInput;
	private JTextField emailInput;
	private JPasswordField passwordInput;
	JLabel addTeacherLabel = new JLabel("Add Teacher");
	JLabel nameLabel = new JLabel("Full Name:");
	JLabel addressLabel = new JLabel("Address:");
	JLabel phoneLabel = new JLabel("Phone No:");
	JLabel emailLabel = new JLabel("Email:");
	JLabel passwordLabel = new JLabel("Password:");
	JLabel courseLabel = new JLabel("Course:");
	JLabel moduleLabel = new JLabel("Module:");
	JLabel errorLbl = new JLabel("Email eg:email12@eclass.edu.np  and Password eg:P@ssword123#");
	JLabel teacherLabel = new JLabel("Teacher's Added!!!");
	JLabel teacherError= new JLabel("Error");
	JButton confirmBtn = new JButton("Confirm");
	JComboBox<String> courseBox = new JComboBox<>();
	JComboBox<String> moduleBox = new JComboBox<>();
	private final JLabel dobLabel = new JLabel("DOB:");
	private JTextField dobInput;
	public AddTeacher() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(250, 50, 510, 569);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
		addTeacherLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		addTeacherLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addTeacherLabel.setBounds(0, 11, 494, 62);
		frame.getContentPane().add(addTeacherLabel);
		
		
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		nameLabel.setBounds(47, 94, 97, 27);
		frame.getContentPane().add(nameLabel);
		
		nameInput = new JTextField();
		nameInput.setBackground(SystemColor.control);
		nameInput.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		nameInput.setColumns(10);
		nameInput.setBounds(154, 94, 209, 27);
		frame.getContentPane().add(nameInput);
		
		
		addressLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		addressLabel.setBounds(47, 134, 97, 27);
		frame.getContentPane().add(addressLabel);
		
		addressInput = new JTextField();
		addressInput.setBackground(SystemColor.control);
		addressInput.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		addressInput.setColumns(10);
		addressInput.setBounds(154, 134, 209, 27);
		frame.getContentPane().add(addressInput);
		
		
		phoneLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		phoneLabel.setBounds(47, 174, 97, 27);
		frame.getContentPane().add(phoneLabel);
		
		phoneInput = new JTextField();
		phoneInput.setBackground(SystemColor.control);
		phoneInput.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		phoneInput.setColumns(10);
		phoneInput.setBounds(154, 174, 209, 27);
		frame.getContentPane().add(phoneInput);
		
		errorLbl.setForeground(new Color(255, 0, 0));
		errorLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		errorLbl.setBounds(47, 476, 396, 22);
		frame.getContentPane().add(errorLbl);
		errorLbl.setVisible(false);
		
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		emailLabel.setBounds(47, 254, 97, 27);
		frame.getContentPane().add(emailLabel);
		
		emailInput = new JTextField();
		emailInput.setBackground(SystemColor.control);
		emailInput.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		emailInput.setColumns(10);
		emailInput.setBounds(154, 254, 209, 27);
		frame.getContentPane().add(emailInput);
		
		
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordLabel.setBounds(47, 294, 97, 27);
		frame.getContentPane().add(passwordLabel);
		
		passwordInput = new JPasswordField();
		passwordInput.setBackground(SystemColor.control);
		passwordInput.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		passwordInput.setBounds(154, 294, 209, 27);
		frame.getContentPane().add(passwordInput);
		courseBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String course=courseBox.getSelectedItem().toString();
				setCourses(course);
			}
		});
		
		
		courseBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		courseBox.setModel(new DefaultComboBoxModel<>(new String[] {"Please Select Course"}));
		courseBox.setBounds(154, 334, 209, 27);
		frame.getContentPane().add(courseBox);
		
		
		courseLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		courseLabel.setBounds(47, 334, 97, 27);
		frame.getContentPane().add(courseLabel);
		
		
		moduleLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		moduleLabel.setBounds(47, 374, 97, 27);
		frame.getContentPane().add(moduleLabel);
		
		
		moduleBox.setModel(new DefaultComboBoxModel<>(new String[] {"Please Enter Module"}));
		moduleBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		moduleBox.setBounds(154, 374, 209, 27);
		frame.getContentPane().add(moduleBox);
		
		
		teacherLabel.setForeground(new Color(34, 139, 34));
		teacherLabel.setHorizontalAlignment(SwingConstants.CENTER);
		teacherLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		teacherLabel.setBounds(10, 472, 474, 25);
		frame.getContentPane().add(teacherLabel);
		teacherLabel.setVisible(false);
		
		teacherError.setForeground(new Color(255, 0, 0));
		teacherError.setHorizontalAlignment(SwingConstants.CENTER);
		teacherError.setFont(new Font("Tahoma", Font.PLAIN, 20));
		teacherError.setBounds(10, 472, 474, 25);
		frame.getContentPane().add(teacherError);
		teacherError.setVisible(false);
		
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=nameInput.getText();
				String address=addressInput.getText();
				String phone=phoneInput.getText();
				String dob=dobInput.getText();
				String email=emailInput.getText();
				String password=new String(passwordInput.getPassword());
				String module=moduleBox.getSelectedItem().toString();
				boolean checkemail=new RegexTest().checkEmail(email);
				boolean checkpass=new RegexTest().checkPassword(password);
				if(checkemail && checkpass) {
					errorLbl.setVisible(false);
					boolean check=new Teacher().update(name, address, phone, dob, email, password,module);
					if(check) {
						teacherLabel.setVisible(true);
						teacherError.setVisible(false);	
						JOptionPane.showMessageDialog(null, "Please click logo to refresh the page.", "Information", JOptionPane.INFORMATION_MESSAGE);
						
					}
					else {
						teacherLabel.setVisible(false);
						teacherError.setVisible(true);
					}
				}
				else {
					errorLbl.setVisible(true);
				}
				
			}
		});
		
		
		confirmBtn.setFont(new Font("Tahoma", Font.BOLD, 17));
		confirmBtn.setBounds(172, 434, 133, 27);
		frame.getContentPane().add(confirmBtn);
		dobLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		dobLabel.setBounds(47, 214, 97, 27);
		
		frame.getContentPane().add(dobLabel);
		
		dobInput = new JTextField();
		dobInput.setColumns(10);
		dobInput.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		dobInput.setBackground(SystemColor.menu);
		dobInput.setBounds(154, 214, 209, 27);
		frame.getContentPane().add(dobInput);
		setCourses();
		
	}
	public void setCourses() {
		String url="jdbc:mysql://localhost:3306/collegeinformation";
		String username="root";
		String password="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url,username,password);
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("SELECT * FROM courses");
			while(rs.next()) {
				String coursename=rs.getString("Name");
				courseBox.addItem(coursename);
			}
		}
		catch(Exception e) {
			System.out.println("Cannot connect");
		}
	}
	public void setCourses(String course) {
		int id = 0;
		String url="jdbc:mysql://localhost:3306/collegeinformation";
		String username="root";
		String password="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url,username,password);
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("SELECT ID  FROM courses where Name='"+course+"'");
			while(rs.next()) {
				id=rs.getInt("ID");
			}
			ResultSet rs2=statement.executeQuery("SELECT * FROM modules where Course_ID='"+id+"'");
			moduleBox.removeAllItems();
			while(rs2.next()) {
				String module1=rs2.getString("Name");
				moduleBox.addItem(module1);
			}
			ResultSet rs3=statement.executeQuery("SELECT * FROM optionalmodules where Course_ID='"+id+"'");
			while(rs3.next()) {
				String module2=rs3.getString("Name");
				moduleBox.addItem(module2);
			}
		}catch(Exception e) {
			System.out.println("Cannot connect"+e.getMessage());
		}
	}
}
