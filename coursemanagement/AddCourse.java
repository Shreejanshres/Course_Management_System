package coursemanagement;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCourse {

	private JFrame frame;
	private JTextField idInput;
	private JTextField nameInput;

	public AddCourse() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(250, 50, 444, 307);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Add Course");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(0, 11, 428, 55);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel idLbl = new JLabel("ID:");
		idLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		idLbl.setBounds(44, 100, 38, 14);
		frame.getContentPane().add(idLbl);
		
		idInput = new JTextField();
		idInput.setBounds(127, 100, 226, 20);
		frame.getContentPane().add(idInput);
		idInput.setColumns(10);
		
		JLabel nameLbl = new JLabel("Name:");
		nameLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		nameLbl.setBounds(44, 140, 66, 20);
		frame.getContentPane().add(nameLbl);
		
		nameInput = new JTextField();
		nameInput.setColumns(10);
		nameInput.setBounds(127, 143, 226, 20);
		frame.getContentPane().add(nameInput);
		
		JButton coursesBtn = new JButton("Add");
		coursesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=idInput.getText();
				String name=nameInput.getText();
				new Courses(id,name).Store();
				JOptionPane.showMessageDialog(null, "Please click logo to refresh the page.", "Information", JOptionPane.INFORMATION_MESSAGE);

			}
			
		});
		coursesBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		coursesBtn.setBounds(162, 207, 89, 23);
		frame.getContentPane().add(coursesBtn);
	}

	
}
