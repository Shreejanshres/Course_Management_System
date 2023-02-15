package coursemanagement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;

public class Report {
	private String id;
	private String name;
	private String mark1;
	private String mark3;
	private String mark2;
	private String result;
	public JFrame frame;
	JLabel headingLbl = new JLabel("Report");
	JPanel reportShow = new JPanel();
	JLabel idLbl2 = new JLabel("ID:");
	JLabel nameLbl = new JLabel("Name:");
	JLabel mark1Lbl = new JLabel("Mark 1:");
	JLabel mark2Lbl = new JLabel("Mark 2:");
	JLabel mark3Lbl = new JLabel("Mark 3:");
	JLabel reportLbl = new JLabel("Result:");
	
	JLabel idShow = new JLabel();
	JLabel nameShow = new JLabel();
	JLabel mark1Show = new JLabel();
	JLabel mark2Show = new JLabel();
	JLabel mark3Show = new JLabel();
	JLabel resultShow = new JLabel("Result:");
	public Report(String id , String name, String mark1, String mark2, String mark3,String result) {
		this.id=id;
		this.name=name;
		this.mark1=mark1;
		this.mark2=mark2;
		this.mark3=mark3;
		this.result=result;
		initialize();
	}
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMark1() {
		return mark1;
	}

	public String getMark3() {
		return mark3;
	}

	public String getMark2() {
		return mark2;
	}

	public String getResult() {
		return result;
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 556, 397);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
		headingLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		headingLbl.setHorizontalAlignment(SwingConstants.CENTER);
		headingLbl.setBounds(10, 11, 530, 44);
		frame.getContentPane().add(headingLbl);
		
		
		reportShow.setBounds(10, 65, 520, 276);
		frame.getContentPane().add(reportShow);
		reportShow.setLayout(null);
		
		
		idLbl2.setFont(new Font("Dialog", Font.BOLD, 20));
		idLbl2.setBounds(33, 20, 38, 25);
		reportShow.add(idLbl2);
		
	
		nameLbl.setFont(new Font("Dialog", Font.BOLD, 20));
		nameLbl.setBounds(33, 60, 93, 25);
		reportShow.add(nameLbl);
		
		
		mark1Lbl.setFont(new Font("Dialog", Font.BOLD, 20));
		mark1Lbl.setBounds(33, 100, 93, 25);
		reportShow.add(mark1Lbl);
		
		
		mark2Lbl.setFont(new Font("Dialog", Font.BOLD, 20));
		mark2Lbl.setBounds(33, 140, 93, 25);
		reportShow.add(mark2Lbl);
		
		
		mark3Lbl.setFont(new Font("Dialog", Font.BOLD, 20));
		mark3Lbl.setBounds(33, 180, 93, 25);
		reportShow.add(mark3Lbl);
		
		
		reportLbl.setFont(new Font("Dialog", Font.BOLD, 20));
		reportLbl.setBounds(33, 220, 93, 25);
		reportShow.add(reportLbl);
		idShow.setText("a");
		
		
		idShow.setFont(new Font("Dialog", Font.BOLD, 20));
		idShow.setBounds(147, 20, 38, 25);
		reportShow.add(idShow);
		
		
		nameShow.setFont(new Font("Dialog", Font.BOLD, 20));
		nameShow.setBounds(147, 60, 93, 25);
		reportShow.add(nameShow);
		
		
		mark1Show.setFont(new Font("Dialog", Font.BOLD, 20));
		mark1Show.setBounds(147, 100, 93, 25);
		reportShow.add(mark1Show);
		
		
		mark2Show.setFont(new Font("Dialog", Font.BOLD, 20));
		mark2Show.setBounds(147, 140, 93, 25);
		reportShow.add(mark2Show);
		
		
		mark3Show.setFont(new Font("Dialog", Font.BOLD, 20));
		mark3Show.setBounds(147, 180, 93, 25);
		reportShow.add(mark3Show);
		
		
		resultShow.setFont(new Font("Dialog", Font.BOLD, 20));
		resultShow.setBounds(147, 220, 93, 25);
		reportShow.add(resultShow);
		show();
	}
	public void show(){
		idShow.setText(getId());
		nameShow.setText(getName());
		mark1Show.setText(getMark1());
		mark2Show.setText(getMark2());
		mark3Show.setText(getMark3());
		resultShow.setText(getResult());
	}

	
	
}
