package coursemanagement;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SignupPage{
	public JFrame frame;
	private JTextField emailInput;
	private JPasswordField passwordInput;
	private JPasswordField confirmpasswordInput;
	private JTextField confirmEmail;
	private JTextField nameInput;
	private JTextField addressInput;
	private JTextField phInput;
	private JTextField dobInput;
	
	JLabel firstnameLabel = new JLabel("Enter full name");
	JLabel addressLbl = new JLabel("Address");
	JLabel phnoLbl = new JLabel("Phone no");
	JLabel levelLbl = new JLabel("Level");
	JComboBox<String> levelInput = new JComboBox<String>();
	JLabel courseLbl = new JLabel("Course");
	JComboBox<String> courseInput = new JComboBox<String>();
	JLabel module1Lbl = new JLabel("Module 1");
	JComboBox<String> module1Input = new JComboBox<String>();
	JLabel module2Lbl = new JLabel("Module 2");
	JComboBox<String> module2Input = new JComboBox<String>();
	JButton registerBtn = new JButton("Sign Up");
	JLabel dobLbl = new JLabel("Date of birth");
	JLabel errorLbl = new JLabel("Email eg:email12@eclass.edu.np  and Password eg:P@ssword123#");
	JLabel passwordError = new JLabel("Password Mismatch!!!");
	JLabel emailError = new JLabel("Email Mismatch!!!");
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupPage window = new SignupPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SignupPage() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(250, 50, 500, 795);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel signupLabel = new JLabel("SIGN UP");
		signupLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		signupLabel.setBounds(148, 10, 193, 90);
		frame.getContentPane().add(signupLabel);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		emailLabel.setBounds(42, 110, 107, 22);
		frame.getContentPane().add(emailLabel);
		
		emailInput = new JTextField();
		emailInput.setBounds(42, 142, 179, 28);
		frame.getContentPane().add(emailInput);
		emailInput.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		passwordLabel.setBounds(42, 200, 107, 22);
		frame.getContentPane().add(passwordLabel);
		
		JLabel confirmPasswordLabel = new JLabel("Confirm\r\n Password");
		confirmPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		confirmPasswordLabel.setBounds(270, 200, 168, 22);
		frame.getContentPane().add(confirmPasswordLabel);
		
		passwordInput = new JPasswordField();
		passwordInput.setBounds(42, 232, 179, 28);
		frame.getContentPane().add(passwordInput);
		
		confirmpasswordInput = new JPasswordField();
		confirmpasswordInput.setBounds(270, 232, 179, 28);
		frame.getContentPane().add(confirmpasswordInput);
		
		JLabel TextLabel = new JLabel("Already have an account?");
		TextLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TextLabel.setBounds(140, 681, 179, 22);
		frame.getContentPane().add(TextLabel);
		
		JLabel LoginLabel = new JLabel("Login");
		LoginLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new loginPage().frame.setVisible(true);
				frame.dispose();
			}
		});
		LoginLabel.setForeground(SystemColor.textHighlight);
		LoginLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		LoginLabel.setBounds(313, 681, 56, 22);
		frame.getContentPane().add(LoginLabel);
		
		JLabel emailConfirm = new JLabel("Confirm Email");
		emailConfirm.setFont(new Font("Tahoma", Font.BOLD, 18));
		emailConfirm.setBounds(270, 110, 130, 22);
		frame.getContentPane().add(emailConfirm);
		
		confirmEmail = new JTextField();
		confirmEmail.setColumns(10);
		confirmEmail.setBounds(270, 142, 179, 28);
		frame.getContentPane().add(confirmEmail);
		
		
		errorLbl.setForeground(new Color(255, 0, 0));
		errorLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		errorLbl.setBounds(53, 713, 396, 22);
		frame.getContentPane().add(errorLbl);
		
		
		passwordError.setForeground(new Color(255, 0, 0));
		passwordError.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordError.setBounds(270, 271, 179, 14);
		frame.getContentPane().add(passwordError);
		errorLbl.setVisible(false);
		passwordError.setVisible(false);
		
		firstnameLabel.setBounds(42, 293, 179, 22);
		firstnameLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		nameInput = new JTextField();
		nameInput.setBounds(42, 325, 179, 28);
		nameInput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nameInput.setColumns(10);
		
		
		addressLbl.setBounds(270, 295, 114, 22);
		addressLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		addressInput = new JTextField();
		addressInput.setBounds(270, 325, 179, 28);
		addressInput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		addressInput.setColumns(10);
		
	
		phnoLbl.setBounds(42, 383, 114, 22);
		phnoLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		phInput = new JTextField();
		phInput.setBounds(42, 415, 179, 28);
		phInput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		phInput.setColumns(10);
		
		
		levelLbl.setBounds(42, 472, 114, 22);
		levelLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		

		levelInput.setBounds(42, 504, 179, 28);
		levelInput.setFont(new Font("Tahoma", Font.BOLD, 12));
		levelInput.setModel(new DefaultComboBoxModel<String>(new String[] {"Enter your Level", "Level 4", "Level 5", "Level 6"}));
		
		
		courseLbl.setBounds(270, 472, 114, 22);
		courseLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		courseInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String course=courseInput.getSelectedItem().toString();
				setCourses(course);
			}
		});
		
		
		courseInput.setBounds(270, 504, 179, 28);
		courseInput.setFont(new Font("Tahoma", Font.BOLD, 12));
		
	
		module1Lbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		module1Lbl.setBounds(42, 554, 114, 22);
		module1Lbl.setVisible(false);
		
	
		module1Input.setFont(new Font("Tahoma", Font.BOLD, 12));
		module1Input.setBounds(42, 588, 179, 28);
		module1Input.setVisible(false);
		
		
		module2Lbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		module2Lbl.setBounds(270, 554, 114, 22);
		module2Lbl.setVisible(false);
		
		
		module2Input.setFont(new Font("Tahoma", Font.BOLD, 12));
		module2Input.setBounds(270, 588, 179, 28);
		module2Input.setVisible(false);
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email=emailInput.getText();
				String emconfirm=confirmEmail.getText();
				String password=new String(passwordInput.getPassword());
				String confirm=new String(confirmpasswordInput.getPassword());
				if(email.equals(emconfirm)) {
					emailError.setVisible(false);
				if(password.equals(confirm)) {
					boolean checkemail=new RegexTest().checkEmail(email);
					boolean checkpass=new RegexTest().checkPassword(password);
					if(checkemail==true && checkpass==true) {
						System.out.println("works");
						errorLbl.setVisible(false);
						String name=nameInput.getText();
						String address=addressInput.getText();
						String phone=phInput.getText();
						String dob=dobInput.getText();
						int level = 0;
						if(levelInput.getSelectedIndex()==1) {
							level=4;
						}
						else if(levelInput.getSelectedIndex()==2) {
							level=5;
						}
						else if(levelInput.getSelectedIndex()==3) {
							level=6;
						}
						String course=courseInput.getSelectedItem().toString();
						String module1=module1Input.getSelectedItem().toString();
						String module2=module2Input.getSelectedItem().toString();
						int id = 0,m1=0,m2=0;
						String url="jdbc:mysql://localhost:3306/collegeinformation";
						String username="root";
						String pass="";
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection connection=DriverManager.getConnection(url,username,pass);
							Statement statement=connection.createStatement();
							ResultSet rs=statement.executeQuery("SELECT ID  FROM courses where Name='"+course+"'");
							while(rs.next()) {
								id=rs.getInt("ID");
							}
							ResultSet rs1=statement.executeQuery("SELECT ID  FROM optionalmodules where Name='"+module1+"'");
							while(rs1.next()) {
								m1=rs1.getInt("ID");
							}
							ResultSet rs2=statement.executeQuery("SELECT ID  FROM optionalmodules where Name='"+module2+"'");
							while(rs2.next()) {
								m2=rs2.getInt("ID");
							}
						}catch(Exception e1) {
								System.out.println("Cannot connect"+e1.getMessage());
							}
						new loginPage().frame.setVisible(true);
						frame.dispose();
						new Student().update(name, address, phone, dob, level,email,password, id,m1,m2);
						
					}else {
						errorLbl.setVisible(true);
					}
					passwordError.setVisible(false);
					
				}
				else {
					passwordError.setVisible(true);
				}
			}else {
				emailError.setVisible(true);
			}
			}
		});
		registerBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		registerBtn.setBounds(205, 646, 111, 28);
		
		dobLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		dobLbl.setBounds(270, 383, 162, 22);
		
		dobInput = new JTextField();
		dobInput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dobInput.setColumns(10);
		dobInput.setBounds(270, 418, 179, 28);
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(firstnameLabel);
		frame.getContentPane().add(nameInput);
		frame.getContentPane().add(addressLbl);
		frame.getContentPane().add(addressInput);
		frame.getContentPane().add(phnoLbl);
		frame.getContentPane().add(phInput);
		frame.getContentPane().add(levelLbl);
		frame.getContentPane().add(courseLbl);
		frame.getContentPane().add(levelInput);
		frame.getContentPane().add(courseInput);
		frame.getContentPane().add(module1Lbl);
		frame.getContentPane().add(module1Input);
		frame.getContentPane().add(module2Lbl);
		frame.getContentPane().add(module2Input);
		frame.getContentPane().add(registerBtn);
		frame.getContentPane().add(dobLbl);
		frame.getContentPane().add(dobInput);
		emailError.setFont(new Font("Tahoma", Font.PLAIN, 13));
		emailError.setForeground(new Color(255, 0, 0));
		emailError.setBounds(270, 180, 162, 13);
		emailError.setVisible(false);
		
		frame.getContentPane().add(emailError);
		setCourses();
	}
	public void setCourses(String course) {
		int id = 0;
		String url="jdbc:mysql://localhost:3306/collegeinformation";
		String username="root";
		String pass="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url,username,pass);
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("SELECT ID  FROM courses where Name='"+course+"'");
			while(rs.next()) {
				id=rs.getInt("ID");
			}
			ResultSet rs2=statement.executeQuery("SELECT * FROM optionalmodules where Course_ID='"+id+"'");
			module1Input.removeAllItems();
			module2Input.removeAllItems();
			while(rs2.next()) {
				String module1=rs2.getString("Name");
				module1Input.addItem(module1);
				String module2=rs2.getString("Name");
				module2Input.addItem(module2);
			}
		}
		catch(Exception e) {
			System.out.println("Cannot connect");
		}
		int lvl=levelInput.getSelectedIndex();
		if(lvl==3) {
			module1Lbl.setVisible(true);
			module1Input.setVisible(true);
			module2Lbl.setVisible(true);
			module2Input.setVisible(true);
			
		}
		else {
			module1Lbl.setVisible(false);
			module1Input.setVisible(false);
			module2Lbl.setVisible(false);
			module2Input.setVisible(false);
		}
	}
	public void setCourses() {
		String url="jdbc:mysql://localhost:3306/collegeinformation";
		String username="root";
		String pass="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url,username,pass);
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("SELECT * FROM courses");
			while(rs.next()) {
				String coursename=rs.getString("Name");
				courseInput.addItem(coursename);
			}
		}
		catch(Exception e) {
			System.out.println("Cannot connect");
		}
	}
}
