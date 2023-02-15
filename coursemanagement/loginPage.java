package coursemanagement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;


public class loginPage {
	public JFrame frame;
	private JTextField emailInput;
	private JPasswordField passwordInput;
	JComboBox<String> userTypeInput = new JComboBox<>();
	
	
	JLabel errorEmail = new JLabel("Please enter email!!");
	JLabel errorCredential = new JLabel("Credentials mismatch!!!");
	JLabel errorPassword = new JLabel("Please enter Password!!!");
	JLabel errorType = new JLabel("Please choose user type");
	
	private String email;
	private String password;
	private int userType;
	public loginPage() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(250, 50, 400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel loginLabel = new JLabel(" LOGIN PAGE");
		loginLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setBounds(32, 38, 304, 64);
		frame.getContentPane().add(loginLabel);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emailLabel.setBounds(32, 136, 61, 22);
		frame.getContentPane().add(emailLabel);
		
		emailInput = new JTextField();
		emailInput.setBackground(SystemColor.control);
		emailInput.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		emailInput.setForeground(Color.DARK_GRAY);
		emailInput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		emailInput.setBounds(32, 168, 304, 28);
		frame.getContentPane().add(emailInput);
		emailInput.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		passwordLabel.setBounds(32, 237, 106, 22);
		frame.getContentPane().add(passwordLabel);
		
		passwordInput = new JPasswordField();
		passwordInput.setBackground(SystemColor.control);
		passwordInput.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.desktop));
		passwordInput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordInput.setBounds(33, 269, 304, 28);
		frame.getContentPane().add(passwordInput);
		
		JLabel userTypeLabel = new JLabel("User:");
		userTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		userTypeLabel.setBounds(32, 338, 80, 22);
		frame.getContentPane().add(userTypeLabel);
		userTypeInput.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		
		userTypeInput.setToolTipText("");
		userTypeInput.setFont(new Font("Tahoma", Font.BOLD, 15));
		userTypeInput.setModel(new DefaultComboBoxModel<String>(new String[] {"Select User Type", "Student", "Teacher", "Admin"}));
		userTypeInput.setBounds(32, 370, 157, 34);
		frame.getContentPane().add(userTypeInput);
		
		
		errorEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		errorEmail.setForeground(Color.RED);
		errorEmail.setBounds(32, 206, 173, 13);
		errorEmail.setVisible(false);
		frame.getContentPane().add(errorEmail);
		
		
		errorPassword.setForeground(Color.RED);
		errorPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		errorPassword.setBounds(32, 308, 173, 13);
		errorPassword.setVisible(false);
		frame.getContentPane().add(errorPassword);
		
		
		errorCredential.setForeground(Color.RED);
		errorCredential.setFont(new Font("Tahoma", Font.PLAIN, 14));
		errorCredential.setBounds(32, 438, 147, 13);
		errorCredential.setVisible(false);
		frame.getContentPane().add(errorCredential);
		
		
		errorType.setForeground(Color.RED);
		errorType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		errorType.setBounds(32, 414, 173, 13);
		errorType.setVisible(false);
		frame.getContentPane().add(errorType);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginPage login=new loginPage();
				String tempemail=emailInput.getText();
				String tempassword=new String(passwordInput.getPassword());
				int temptype=userTypeInput.getSelectedIndex();
				
				if(tempemail.equals("")) {
					errorEmail.setVisible(true);
				}
				else {
					errorEmail.setVisible(false);
					login.setEmail(tempemail);
				}
				if(tempassword.equals("")) {
					errorPassword.setVisible(true);
				}
				else {
					errorPassword.setVisible(false);
					login.setPassword(tempassword);
				}
				if(temptype==0) {
					errorType.setVisible(true);
					
				}
				else {
					errorType.setVisible(false);
					login.setUserType(temptype);
					frame.dispose();
					login.check();
				}
				
				
			}
		});
		loginBtn.setForeground(new Color(0, 0, 0));
		loginBtn.setBackground(new Color(255, 255, 255));
		loginBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		loginBtn.setBounds(122, 465, 96, 28);
		frame.getContentPane().add(loginBtn);
		
		JLabel signupLabel = new JLabel("Create Account");
		signupLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new SignupPage().frame.setVisible(true);
				frame.dispose();
			}
		});
		signupLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		signupLabel.setForeground(SystemColor.textHighlight);
		signupLabel.setBounds(122, 497, 137, 22);
		frame.getContentPane().add(signupLabel);
		
		JLabel lblNewLabel = new JLabel("for the first use use email admin1@eclass.edu.np and password admin1");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 536, 364, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	public void check () {
		int user=getUserType();
		
		if(user==1) {
			new Student().login(getEmail(), getPassword());
		}
		else if(user==2){
			new Teacher().login(getEmail(), getPassword());
		}
		else if(user==3){
			new Admin().login(getEmail(),getPassword());	
		}
	}
}
