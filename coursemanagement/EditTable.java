package coursemanagement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditTable {
	private String id;
	public JFrame frame;
	private JLabel idshow = new JLabel();
	JLabel dobLbl = new JLabel("DOB:");
	JLabel phoneLbl = new JLabel("Phone:");
	JLabel addressLbl = new JLabel("Address:");
	JLabel nameLbl = new JLabel("Name:");
	JLabel idLbl = new JLabel("ID:");
	JButton reportBtn = new JButton("Report");
	private final JLabel nameShow = new JLabel();
	private final JLabel addressShow = new JLabel();
	private final JLabel phoneShow = new JLabel();
	private final JLabel dobShow = new JLabel();

	public EditTable() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(250, 50, 541, 366);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Show Data");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(132, 11, 241, 45);
		frame.getContentPane().add(lblNewLabel);
		
		
		idLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		idLbl.setBounds(55, 67, 72, 21);
		frame.getContentPane().add(idLbl);
		
	
		nameLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		nameLbl.setBounds(55, 100, 72, 21);
		frame.getContentPane().add(nameLbl);
		
		
		addressLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		addressLbl.setBounds(55, 133, 72, 21);
		frame.getContentPane().add(addressLbl);
		
		
		phoneLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		phoneLbl.setBounds(55, 166, 72, 21);
		frame.getContentPane().add(phoneLbl);
		
		
		dobLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		dobLbl.setBounds(55, 199, 72, 21);
		frame.getContentPane().add(dobLbl);
		
		
		idshow.setBounds(154, 67, 46, 21);
		frame.getContentPane().add(idshow);
		
		
		reportBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Student().report(getId());
			}
		});
		reportBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		reportBtn.setBounds(402, 265, 89, 21);
		frame.getContentPane().add(reportBtn);
		nameShow.setBounds(154, 100, 89, 21);
		
		frame.getContentPane().add(nameShow);
		addressShow.setBounds(154, 133, 89, 21);
		
		frame.getContentPane().add(addressShow);
		phoneShow.setBounds(154, 166, 89, 21);
		
		frame.getContentPane().add(phoneShow);
		dobShow.setBounds(154, 199, 89, 21);
		
		frame.getContentPane().add(dobShow);
		frame.setVisible(true);
	}
	public void edit(String id,String name, String address, String phone, String dob,String userType) {
		setId(id);
		idshow.setText(id);
		nameShow.setText(name);
		addressShow.setText(address);
		phoneShow.setText(phone);
		dobShow.setText(dob);
		if(userType=="admin" || userType.equals("teacher")) {
			reportBtn.setVisible(false);
		}else {
			reportBtn.setVisible(true);
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
