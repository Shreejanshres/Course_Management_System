package coursemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class OptionalModule {
	private int id;
	private String name;
	private int c_id;
	OptionalModule(){}
	OptionalModule(int ID, String name, int c_id){
		this.id=ID;
		this.name=name;
		this.c_id=c_id;
	}
	public ArrayList<OptionalModule> informationList(){
		String url="jdbc:mysql://localhost:3306/collegeinformation";
		String username="root";
		String password="";
		ArrayList<OptionalModule> informationlist= new ArrayList<OptionalModule>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url,username,password);
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("SELECT * FROM optionalmodules");
			while(rs.next()) {
				OptionalModule info= new OptionalModule(rs.getInt(1),rs.getString(2),rs.getInt(3));
				informationlist.add(info);
				
			}
		}
		catch(Exception e) {
			System.out.println("cannot connect");
		}
		return informationlist;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getC_id() {
		return c_id;
	}
}
