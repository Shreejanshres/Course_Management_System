package coursemanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AddModule {
	private boolean option;
	public JFrame frame;
	private JTextField idInput;
	private JTextField nameInput;
	JComboBox<String> courseInput = new JComboBox<String>();
	JComboBox<String> levelInput = new JComboBox<String>();
	JCheckBox optional = new JCheckBox("Is Optional?");
	public boolean isOption() {
		return option;
	}

	public void setOption(boolean option) {
		this.option = option;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddModule window = new AddModule();
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
	public AddModule() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(250, 50, 444, 398);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel headingLbl = new JLabel("Add Module");
		headingLbl.setFont(new Font("Tahoma", Font.BOLD, 40));
		headingLbl.setHorizontalAlignment(SwingConstants.CENTER);
		headingLbl.setBounds(0, 11, 430, 42);
		frame.getContentPane().add(headingLbl);
		
		JLabel idLbl = new JLabel("ID:");
		idLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		idLbl.setBounds(49, 100, 38, 14);
		frame.getContentPane().add(idLbl);
		
		idInput = new JTextField();
		idInput.setColumns(10);
		idInput.setBounds(132, 100, 226, 20);
		frame.getContentPane().add(idInput);
		
		JLabel nameLbl = new JLabel("Name:");
		nameLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		nameLbl.setBounds(49, 140, 66, 20);
		frame.getContentPane().add(nameLbl);
		
		nameInput = new JTextField();
		nameInput.setColumns(10);
		nameInput.setBounds(132, 140, 226, 20);
		frame.getContentPane().add(nameInput);
		
		JLabel courseLbl = new JLabel("Course:");
		courseLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		courseLbl.setBounds(49, 220, 73, 20);
		frame.getContentPane().add(courseLbl);
		levelInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=levelInput.getSelectedIndex();
				if(index==3) {
					optional.setVisible(true);
				}
				else
				{
					optional.setVisible(false);
				}
			}
		});
		levelInput.setModel(new DefaultComboBoxModel<String>(new String[] {"Select Level", "Level 4", "Level 5", "Level 6"}));
		
		
		levelInput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		levelInput.setBounds(132, 180, 226, 22);
		frame.getContentPane().add(levelInput);
		frame.setVisible(true);
		
		courseInput.setBounds(132, 220, 226, 22);
		frame.getContentPane().add(courseInput);
		
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id= idInput.getText();
				String name=nameInput.getText();
				int lvl=levelInput.getSelectedIndex();
				int level = 0;
				String course=courseInput.getSelectedItem().toString();
				int c_id=new Courses().getid(course);
				if(lvl==1) {
					level=4;
				}
				else if(lvl==2) {
					level=5;
				}
				else if(lvl==3) {
					level=6;
				}
				if(isOption()==false) {
				new Modules(id, name, level, c_id).store();
				JOptionPane.showMessageDialog(null, "Please click logo to refresh the page.", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
				boolean check=new Modules(id, name, level, c_id).store(id);
				if(check) {
					JOptionPane.showMessageDialog(null, "Same ID!!", "Warning", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Please click logo to refresh the page.", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
				}
				
			}
		});
		addBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		addBtn.setBounds(152, 307, 91, 23);
		frame.getContentPane().add(addBtn);
		
		JLabel levelLbl = new JLabel("Level:");
		levelLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		levelLbl.setBounds(49, 180, 66, 20);
		frame.getContentPane().add(levelLbl);
		optional.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		
		optional.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					setOption(true);
		        } else {
		            setOption(false);
		        };
			}
		});
		optional.setBounds(132, 260, 167, 32);
		frame.getContentPane().add(optional);
		optional.setVisible(false);
		
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
				courseInput.addItem(coursename);
			}
		}
		catch(Exception e) {
			System.out.println("Cannot connect");
		}
	}

	
}
