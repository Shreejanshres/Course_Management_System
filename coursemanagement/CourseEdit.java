package coursemanagement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CourseEdit {
	private String id;
	private String name;
	
	private JFrame frame;
	JLabel idShow = new JLabel("ID:");
	JLabel nameShow = new JLabel("Name:");
	public CourseEdit(String id, String name) {
		this.id=id;
		this.name=name;
		initialize();
	}
	public String getId() {
		return id;
	}
	public String getName() {
		
		return name;
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 360, 269);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Edit Course");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 346, 52);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setBounds(53, 85, 50, 19);
		frame.getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(53, 121, 50, 19);
		frame.getContentPane().add(lblName);
		
		
		idShow.setFont(new Font("Tahoma", Font.BOLD, 15));
		idShow.setBounds(133, 85, 50, 19);
		frame.getContentPane().add(idShow);
		
	
		nameShow.setFont(new Font("Tahoma", Font.BOLD, 15));
		nameShow.setBounds(133, 121, 138, 19);
		frame.getContentPane().add(nameShow);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Courses().delete(getId());
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setBounds(113, 187, 85, 21);
		frame.getContentPane().add(btnDelete);
		edit();
	}
	public void edit() {
		idShow.setText(getId());
		nameShow.setText(getName());
		
	}
}
