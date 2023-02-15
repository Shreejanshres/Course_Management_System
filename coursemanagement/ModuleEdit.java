package coursemanagement;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ModuleEdit {
	private String id;
	private String name;
	private String level;
	private String course;
	private JFrame frame;
	JLabel idShow = new JLabel();
	JLabel nameShow = new JLabel();
	JLabel levelShow = new JLabel();
	JLabel courseShow = new JLabel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuleEdit window = new ModuleEdit();
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
	public ModuleEdit(){initialize();}
	public ModuleEdit(String id, String name, String level, String course) {
		this.id=id;
		this.name=name;
		this.level=level;
		this.course=course;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 360, 317);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JLabel lblNewLabel = new JLabel("Edit Course");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 346, 52);
		frame.getContentPane().add(lblNewLabel);
		frame.setResizable(false);
		
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
				new Modules().delete(getId());
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setBounds(113, 237, 85, 21);
		frame.getContentPane().add(btnDelete);
		
		JLabel lblLevel = new JLabel("Level:");
		lblLevel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLevel.setBounds(53, 158, 50, 19);
		frame.getContentPane().add(lblLevel);
		
		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCourse.setBounds(53, 190, 70, 19);
		frame.getContentPane().add(lblCourse);
		
		
		levelShow.setFont(new Font("Tahoma", Font.BOLD, 15));
		levelShow.setBounds(133, 158, 50, 19);
		frame.getContentPane().add(levelShow);
		
		
		courseShow.setFont(new Font("Tahoma", Font.BOLD, 15));
		courseShow.setBounds(133, 190, 138, 19);
		frame.getContentPane().add(courseShow);
		edit();
	}
	public void edit() {
		idShow.setText(getId());
		nameShow.setText(getName());
		levelShow.setText(getLevel());
		courseShow.setText(getCourse());
		
	}

	public String getCourse() {
		return course;
	}

	public String getLevel() {
		return level;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}
}
