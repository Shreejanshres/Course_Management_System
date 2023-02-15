package coursemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Teacher extends SystemUser{
	private int module;
	Teacher(){}
	Teacher(int id, String name, String address, String phone, String dob, String email, String password, int module){
		super(id,name, address,phone,dob,email,password);
		this.module=module;
	}
	public int getModule() {
		return this.module;
	}
	
	

	public void login(String email ,String pass) {
		String  url="jdbc:mysql://localhost:3306/collegeinformation";
	    String username="root";
	    String password="";
		try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,username,password);
            Statement statement =connection.createStatement();        
            ResultSet resultset=statement.executeQuery("select * from teachers WHERE email= '"+email+"'AND password='"+pass+"'");    
            if(resultset.next()) {
            	new TeacherDashboard(email);
            }else {
            	loginPage login= new loginPage();
            	login.errorCredential.setVisible(true);
            }
        }
        catch(Exception e){
            System.out.println("cannot connect");
        }
      
	}
	public void addMarks(String id, String mark1, String mark2, String mark3) {
		String url="jdbc:mysql://localhost:3306/collegeinformation";
		String username="root";
		String password="";
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection(url,username,password);
		Statement statement=connection.createStatement();
		int rows = statement.executeUpdate("update students set Marks1='"+mark1+"',Marks2='"+mark2+"',Marks3='"+mark3+"' WHERE ID='"+id+"'");
		if (rows > 0) {
		System.out.println("Record updated successfully");
		} else {
		System.out.println("Error updating record");
		}
		}catch(Exception e) {
		System.out.println("cannot connect");
		}
	}
	
	public ArrayList<Teacher> informationList(){
		String url="jdbc:mysql://localhost:3306/collegeinformation";
		String username="root";
		String password="";
		ArrayList<Teacher> informationlist= new ArrayList<Teacher>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url,username,password);
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("SELECT * FROM teachers");
			while(rs.next()) {
				Teacher info= new Teacher(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8));
				informationlist.add(info);
				
			}
		}
		catch(Exception e) {
			System.out.println("cannot connect");
		}
		return informationlist;
	}

	public boolean update(String name, String address, String phone, String dob, String email, String pass,String module) {
	    int module_id=0;
	    String url="jdbc:mysql://localhost:3306/collegeinformation";
	    String username="root";
	    String password="";
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection connection=DriverManager.getConnection(url,username,password);
	        Statement st= connection.createStatement();
	        ResultSet rs=st.executeQuery("SELECT ID from modules WHERE Name='"+module+"'");
	        if(rs.next()) {
	            module_id=rs.getInt("ID");
	            String query1="INSERT INTO teachers(Name,Address,Phone,DOB,Email,Password,Module_id) Values(?,?,?,?,?,?,?)";
		        PreparedStatement statement=connection.prepareStatement(query1);
		        statement.setString(1, name);
		        statement.setString(2, address);
		        statement.setString(3, phone);
		        statement.setString(4, dob);
		        statement.setString(5, email);
		        statement.setString(6, pass);
		        statement.setInt(7, module_id);
		        int row=statement.executeUpdate();
		        if(row>0) {
		           return true;
		        }
		        else {
		            return false;
		        }
	        }
	        ResultSet rs2=st.executeQuery("SELECT ID from optionalmodules WHERE Name='"+module+"'");
	        if(rs2.next()) {
	            module_id=rs2.getInt("ID");
	        
	        String query1="INSERT INTO teachers(Name,Address,Phone,DOB,Email,Password,Optional_id) Values(?,?,?,?,?,?,?)";
	        PreparedStatement statement=connection.prepareStatement(query1);
	        statement.setString(1, name);
	        statement.setString(2, address);
	        statement.setString(3, phone);
	        statement.setString(4, dob);
	        statement.setString(5, email);
	        statement.setString(6, pass);
	        statement.setInt(7, module_id);
	        int row=statement.executeUpdate();
	        if(row>0) {
	           return true;
	        }
	        else {
	            return false;
	        }
	        }
	    } catch(Exception e) {
	    	System.out.println("Cannot connect: " + e.getMessage());
	    }
	    return false;
	   
	}
	public String getmodule(String email) {
		String url="jdbc:mysql://localhost:3306/collegeinformation";
	    String username="root";
	    String password="";
	    int module_id=0;
	    String module_name = null;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection connection=DriverManager.getConnection(url,username,password);
	        Statement st= connection.createStatement();
	        ResultSet rs=st.executeQuery("SELECT * from teachers WHERE email='"+email+"'");
	        while(rs.next()) {
	        	module_id=rs.getInt("Module_id");
	        }
	        System.out.println(module_id);
	        ResultSet rs2=st.executeQuery("Select * from modules where ID='"+module_id+"'");
	        while(rs2.next()) {
	        	 module_name=rs2.getString("Name");
	        }
	        System.out.println(module_name);
	    }catch(Exception e) {
	        System.out.println("Cannot connect:");
	    }
		return module_name;
	}
	public void edit(int id) {
		System.out.println(id);
		String Id = null,name = null,address = null,phone = null,dob = null;
		String url="jdbc:mysql://localhost:3306/collegeinformation";
	    String username="root";
	    String password="";
	    try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
		      Connection connection=DriverManager.getConnection(url,username,password);
		      Statement st= connection.createStatement();
		      ResultSet rs=st.executeQuery("SELECT * FROM teachers WHERE Id='"+ id+"'") ;
		      while(rs.next()) {
		    	  Id=String.valueOf(rs.getInt("ID"));
		    	  name=rs.getString("Name");
		    	  address=rs.getString("Address");
		    	  phone=rs.getString("Phone");
		    	  dob=rs.getString("Dob");
		      }
	    new EditTable().edit(Id,name,address,phone,dob,"teacher");
	    }catch(Exception e) {
	    	System.out.println("cannot connect");
	    }
	}
	
}