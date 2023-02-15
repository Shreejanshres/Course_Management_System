package coursemanagement;
import java.sql.*;
import java.util.*;

public class Admin extends SystemUser {
	
	public Admin() {}
	public Admin(int id,String name, String address, String phone, String dob,String email, String password) {
		super(id,name, address,phone,dob,email,password);
	}
	
 
    
	public void login(String email,String pass) {
		String  url="jdbc:mysql://localhost:3306/collegeinformation";
	    String username="root";
	    String password="";
		try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,username,password);
            Statement statement =connection.createStatement();        
            ResultSet resultset=statement.executeQuery("select * from admins WHERE email= '"+email+"'AND password='"+pass+"'");    
            if(resultset.next()) {
            	new AdminDashboard().frame.setVisible(true);;
            }else {
            	loginPage login= new loginPage();
            	login.errorCredential.setVisible(true);
            }
        }
        catch(Exception e){
            System.out.println("cannot connect");
        }
      
		
		
		
		
		
	}
	
	public ArrayList<Admin> informationList(){
		
		String url="jdbc:mysql://localhost:3306/collegeinformation";
		String username="root";
		String password="";
		ArrayList<Admin> informationlist= new ArrayList<Admin>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url,username,password);
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("SELECT * FROM admins");
			while(rs.next()) {
				Admin info= new Admin(rs.getInt("ID"),rs.getString("Name"),rs.getString("Address"),rs.getString("Phone"),rs.getString("DOB"),rs.getString("Email"),rs.getString("Password"));
				informationlist.add(info);
			}
		}
		catch(Exception e) {
			System.out.println("cannot connect");
		}
		return informationlist;
	}
	public void edit(int id) {
		String Id = null,name = null,address = null,phone = null,dob = null;
		String url="jdbc:mysql://localhost:3306/collegeinformation";
	    String username="root";
	    String password="";
	    try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
		      Connection connection=DriverManager.getConnection(url,username,password);
		      Statement st= connection.createStatement();
		      ResultSet rs=st.executeQuery("SELECT * FROM admins WHERE Id='"+ id+"'") ;
		      while(rs.next()) {
		    	  Id=String.valueOf(rs.getInt("ID"));
		    	  name=rs.getString("Name");
		    	  address=rs.getString("Address");
		    	  phone=rs.getString("Phone");
		    	  dob=rs.getString("Dob");
		      }
	    new EditTable().edit(Id,name,address,phone,dob,"admin");
	    }catch(Exception e) {
	    	System.out.println("cannot connect");
	    }
	}
	public boolean update(String name, String address, String phone, String dob, String email, String pass) {
		    String url="jdbc:mysql://localhost:3306/collegeinformation";
		    String username="root";
		    String password="";
		    try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection connection=DriverManager.getConnection(url,username,password);
		        String query1="INSERT INTO admins(Name,Address,Phone,DOB,Email,Password) Values(?,?,?,?,?,?)";
		        PreparedStatement statement=connection.prepareStatement(query1);
		        statement.setString(1, name);
		        statement.setString(2, address);
		        statement.setString(3, phone);
		        statement.setString(4, dob);
		        statement.setString(5, email);
		        statement.setString(6, pass);
		        int row=statement.executeUpdate();
		        if(row>0) {
		           return true;
		        }
		        else {
		            return false;
		        }
		    } catch(Exception e) {
		    	System.out.println("Cannot connect: " + e.getMessage());
		    }
			return false;		
	}
	
	

	
}

	
	

