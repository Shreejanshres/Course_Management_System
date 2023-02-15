package coursemanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class AddAdmin {

	public JFrame frame;
	private JTextField nameInput;
	private JTextField addressInput;
	private JTextField phoneInput;
	private JTextField emailInput;
	private JPasswordField passwordInput;
	JLabel addAdminLbl = new JLabel("Add Admin");
	JLabel nameLabel = new JLabel("Full Name:");
	JLabel addressLabel = new JLabel("Address:");
	JLabel phoneLabel = new JLabel("Phone No:");
	JLabel emailLabel = new JLabel("Email:");
	JLabel passwordLabel = new JLabel("Password:");
	JLabel errorLbl = new JLabel("Email eg:email12@eclass.edu.np  and Password eg:P@ssword123#");
	JLabel adminLabel = new JLabel("Admin Added!!!");
	JLabel adminError=new JLabel("Error");
	JButton confirmBtn = new JButton("Confirm");
	private final JLabel dobLabel = new JLabel("DOB:");
	private JTextField dobInput;

	public AddAdmin() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(250, 50, 510, 488);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
		addAdminLbl.setFont(new Font("Tahoma", Font.BOLD, 40));
		addAdminLbl.setHorizontalAlignment(SwingConstants.CENTER);
		addAdminLbl.setBounds(0, 11, 494, 62);
		frame.getContentPane().add(addAdminLbl);
		
		
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
		errorLbl.setBounds(47, 412, 396, 22);
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
		
		
		adminLabel.setForeground(new Color(34, 139, 34));
		adminLabel.setHorizontalAlignment(SwingConstants.CENTER);
		adminLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		adminLabel.setBounds(10, 408, 474, 25);
		frame.getContentPane().add(adminLabel);
		adminLabel.setVisible(false);
		
		adminError.setForeground(new Color(255, 0, 0));
		adminError.setHorizontalAlignment(SwingConstants.CENTER);
		adminError.setFont(new Font("Tahoma", Font.PLAIN, 20));
		adminError.setBounds(10, 408, 474, 25);
		frame.getContentPane().add(adminError);
		adminError.setVisible(false);
		
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=nameInput.getText();
				String address=addressInput.getText();
				String phone=phoneInput.getText();
				String dob=dobInput.getText();
				String email=emailInput.getText();
				String password=new String(passwordInput.getPassword());
				boolean checkemail=new RegexTest().checkEmail(email);
				boolean checkpass=new RegexTest().checkPassword(password);
				if(checkemail && checkpass) {
					errorLbl.setVisible(false);
					boolean check=new Admin().update(name, address, phone, dob, email, password);
					if(check) {
						adminLabel.setVisible(true);
						adminError.setVisible(false);
						JOptionPane.showMessageDialog(null, "Please click logo to refresh the page.", "Information", JOptionPane.INFORMATION_MESSAGE);

					}
					else {
						adminLabel.setVisible(false);
						adminError.setVisible(true);
					}
				}
				else {
					errorLbl.setVisible(true);
				}
				
			}
		});
		
		
		confirmBtn.setFont(new Font("Tahoma", Font.BOLD, 17));
		confirmBtn.setBounds(172, 370, 133, 27);
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
	}

}
