package coursemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Courses {
	private String id;
	private String name;
	Courses(){}
	Courses(String id, String name){
		this.id=id;
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public ArrayList<Courses> informationList(){
		String url="jdbc:mysql://localhost:3306/collegeinformation";
		String username="root";
		String password="";
		ArrayList<Courses> informationlist= new ArrayList<Courses>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url,username,password);
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("SELECT * FROM courses");
			while(rs.next()) {
				Courses info= new Courses(rs.getString(1),rs.getString(2));
				informationlist.add(info);
				
			}
		}
		catch(Exception e) {
			System.out.println("cannot connect");
		}
		return informationlist;
	}
	public void Store() {
		String url="jdbc:mysql://localhost:3306/collegeinformation";
	    String username="root";
	    String password="";
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection connection=DriverManager.getConnection(url,username,password);
	        String query1="INSERT INTO courses(Id,Name) Values(?,?)";
	        PreparedStatement statement=connection.prepareStatement(query1);
	        statement.setString(1, id);
	        statement.setString(2, name);
	        statement.executeUpdate();
	    } catch(Exception e) {
	    	System.out.println("Cannot connect: " + e.getMessage());
	    }
			
	}
	public int getid(String course) {
		String url="jdbc:mysql://localhost:3306/collegeinformation";
	    String username="root";
	    String password="";
	    int id = 0;
	    try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
		      Connection connection=DriverManager.getConnection(url,username,password);
		      Statement st= connection.createStatement();
		      ResultSet rs=st.executeQuery("SELECT ID FROM courses WHERE name='"+ course+"'") ;
		      while(rs.next()) {
		    	id=rs.getInt("ID");
		    	  
		      }
	    }catch(Exception e) {
	    	System.out.println("cannot connect");
	    }
	    return id;
	}
	public void edit(int id) {
		String Id = null,name=null;
		String url="jdbc:mysql://localhost:3306/collegeinformation";
	    String username="root";
	    String password="";
	    try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
		      Connection connection=DriverManager.getConnection(url,username,password);
		      Statement st= connection.createStatement();
		      ResultSet rs=st.executeQuery("SELECT * FROM courses WHERE Id='"+ id+"'") ;
		      while(rs.next()) {
		    	  Id=String.valueOf(rs.getInt("ID"));
		    	  name=rs.getString("Name");
		      }
	    new CourseEdit(Id, name);
	    }catch(Exception e) {
	    	System.out.println("cannot connect");
	    }
	}
	public void delete(String id) {
		String url="jdbc:mysql://localhost:3306/collegeinformation";
	    String username="root";
	    String password="";
	    try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
		      Connection connection=DriverManager.getConnection(url,username,password);
		      Statement st= connection.createStatement();
		      st.executeUpdate("Delete from courses where ID='"+ id+"'") ;
	    }catch(Exception e) {
	    	System.out.println("cannot connect"+e.getMessage());
	    }
	}
	
}
