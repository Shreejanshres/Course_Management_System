package coursemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Modules {
	private String id;
	private String name;
	private int level;
	private int c_id;
	
	Modules(){
	}
	Modules(String id,String name, int level,int c_id){
		this.id=id;
		this.name=name;
		this.level=level;
		this.c_id=c_id;
	}
	
	public ArrayList<Modules> informationList(){
		String url="jdbc:mysql://localhost:3306/collegeinformation";
		String username="root";
		String password="";
		ArrayList<Modules> informationlist= new ArrayList<Modules>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url,username,password);
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("SELECT * FROM modules");
			while(rs.next()) {
				Modules info= new Modules(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
				informationlist.add(info);
				
			}
		}
		catch(Exception e) {
			System.out.println("cannot connect");
		}
		return informationlist;
	}
	public void store() {
		String url="jdbc:mysql://localhost:3306/collegeinformation";
	    String username="root";
	    String password="";
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection connection=DriverManager.getConnection(url,username,password);
	        String query1="INSERT INTO modules(Id,Name,Level,Course_ID) Values(?,?,?,?)";
	        PreparedStatement statement=connection.prepareStatement(query1);
	        statement.setString(1, id);
	        statement.setString(2, name);
	        statement.setLong(3, level);
	        statement.setLong(4, c_id);
	        statement.executeUpdate();
	        new AdminDashboard().viewCourses();
	    } catch(Exception e) {
	    	System.out.println("Cannot connect: " + e.getMessage());
	    }
	}
	public void edit(int id) {
		String Id = null,name = null,c_id=null, level=null,course =null;
		String url="jdbc:mysql://localhost:3306/collegeinformation";
	    String username="root";
	    String password="";
	    try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
		      Connection connection=DriverManager.getConnection(url,username,password);
		      Statement st= connection.createStatement();
		      ResultSet rs=st.executeQuery("SELECT * FROM modules WHERE Id='"+ id+"'") ;
		      while(rs.next()) {
		    	  Id=String.valueOf(rs.getInt("ID"));
		    	  name=rs.getString("Name");
		    	  level=rs.getString("Level");
		    	  c_id=rs.getString("Course_ID");
		      }
		      ResultSet rs2=st.executeQuery("Select Name from courses where ID='"+c_id+"'");
		      while(rs2.next()) {
		    	  course=rs2.getString("Name");
		      }
	    new ModuleEdit(Id,name,level, course);
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
		      st.executeUpdate("Delete from Modules where ID='"+ id+"'") ;
	    }catch(Exception e) {
	    	System.out.println("cannot connect"+e.getMessage());
	    }
	}
	public String getId() {
		return id;
	}
	public int getLevel() {
		return level;
	}
	public int getC_id() {
		return c_id;
	}
	public String getName() {
		return name;
	}
	public boolean store(String id) {
		String url="jdbc:mysql://localhost:3306/collegeinformation";
	    String username="root";
	    String password="";
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection connection=DriverManager.getConnection(url,username,password);
	        Statement st= connection.createStatement();
	        ResultSet rs=st.executeQuery("SELECT ID from modules WHERE ID='"+id+"'");
	        if(rs.next()) {
	        	return true;
	        }else {
	        String query1="INSERT INTO optionalmodules(Id,Name,Course_ID) Values(?,?,?)";
	        PreparedStatement statement=connection.prepareStatement(query1);
	        statement.setString(1, id);
	        statement.setString(2, name);
	        statement.setLong(3, c_id);
	        statement.executeUpdate();
	        }
	    } catch(Exception e) {
	    	System.out.println("Cannot connect: " + e.getMessage());
	    }
		return false;
		
	}
	
}
