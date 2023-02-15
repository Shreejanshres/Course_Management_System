package coursemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public  class Student extends SystemUser {
	String dbHost = "localhost";
	String dbPort = "3306";
	String dbName = "collegeinformation";
	String  url="jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName;
    String username="root";
    String password="";
    
    private int level;
    private int course;
    private int marks1;
    private int marks2;
    private int marks3;
    private String result;
    public Student() {}
	Student(int id, String name, String address, String phone, String dob,int level,String email, String password, int course,int marks1, int marks2, int marks3) {
		super(id, name, address, phone, dob,email,password);
		this.level=level;
		this.course=course;
		this.marks1=marks1;
		this.marks2=marks2;
		this.marks3=marks3;
		
	}
	public int getLevel() {
		return this.level;
	}
	public int getCourse() {
		return this.course;
	}
	public int getMarks1() {
		return this.marks1;
	}
	public int getMarks2() {
		return this.marks2;
	}
	public int getMarks3() {
		return this.marks3;
	}
	public String getResult() {
		return this.result;
	}
	public void setMarks1(int mark1) {
		this.marks1=mark1;
	}
	public void setMarks2(int mark2) {
		this.marks2=mark2;
	}
	public void setMarks3(int mark3) {
		this.marks3=mark3;
	}
	public void setResult(String result) {
		this.result=result;
	}
	public void login(String email, String pass) {
		report(email, pass);
		System.out.println(getName());
		try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection= DriverManager.getConnection(url,username,password);

            Statement statement =connection.createStatement();
            
            ResultSet resultSet=statement.executeQuery("select * from students WHERE email= '"+email+"'AND password = '"+pass+"'");
            if (resultSet.next()){
            	new StudentDashboard(getMarks1(),getMarks2(),getMarks3(),getResult()).frame.setVisible(true);
            }
            else {
            	System.out.println("doesnt");
            }
            }
        catch(Exception e){
            System.out.println(e);
        }
		
	}
	public ArrayList<Student> informationList(){
		String url="jdbc:mysql://localhost:3306/collegeinformation";
		String username="root";
		String password="";
		ArrayList<Student> informationlist= new ArrayList<Student>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url,username,password);
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("SELECT * FROM students");
			while(rs.next()) {
				Student info= new Student(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getInt(10), rs.getInt(11),rs.getInt(12));
				informationlist.add(info);
			}
		}
		catch(Exception e) {
			System.out.println("cannot connect");
		}
		return informationlist;
	}
	public void update( String name, String address, String phone, String dob,int level, String email, String pass,int course_id,int option1, int option2) {
		System.out.println(name+address+phone+dob+level+email+pass+option1+option2);
		String url="jdbc:mysql://localhost:3306/collegeinformation";
		String username="root";
		String password="";
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection(url,username,password);
		String query1="INSERT INTO students(Name,Address,Phone,DOB,Level,Email,Password,Course_id,Option1,Option2) Values (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement=connection.prepareStatement(query1);
		statement.setString(1,name);
		statement.setString(2,address);
		statement.setString(3,phone);
		statement.setString(4,dob);
		statement.setLong(5,level);
		statement.setString(6,email);
		statement.setString(7,pass);
		statement.setLong(8,course_id);
		statement.setLong(9, option1);
		statement.setLong(10, option2);
		int row=statement.executeUpdate();
		if(row>0) {
			System.out.println("Data inserted sucessfully");
		}
		else {
			System.out.println("Error while inserting data");
		}
			
		}catch(Exception e) {
			System.out.println("Cannot connecty"+e.getMessage());
		}
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
		      ResultSet rs=st.executeQuery("SELECT * FROM students WHERE Id='"+ id+"'") ;
		      while(rs.next()) {
		    	  Id=String.valueOf(rs.getInt("ID"));
		    	  name=rs.getString("Name");
		    	  address=rs.getString("Address");
		    	  phone=rs.getString("Phone");
		    	  dob=rs.getString("Dob");
		    	  System.out.println(Id);
		      }
	    new EditTable().edit(Id,name,address,phone,dob,"student");
	    }catch(Exception e) {
	    	System.out.println("cannot connect");
	    }
	}
	
	public void report(String id) {
		String url="jdbc:mysql://localhost:3306/collegeinformation";
	    String username="root";
	    String password="";
	    try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
		      Connection connection=DriverManager.getConnection(url,username,password);
		      Statement st= connection.createStatement();
		      ResultSet rs=st.executeQuery("SELECT * FROM students WHERE Id='"+ id+"'") ;
		      while(rs.next()) {
		    	  if(rs.getInt("Marks1")==0 && rs.getInt("Marks2")==0 && rs.getInt("Marks3")==0) {
		    		  throw new ReportNotMadeException();
		    	  }
		    	  else if(rs.getInt("Marks1")>=40 && rs.getInt("Marks2")>=40 && rs.getInt("Marks3")>=40) {
		    		  setResult("Pass");
		    	  }
		    	  else {
		    		  setResult("Fail");
		    	  }
		    	  new Report(rs.getString("ID"),rs.getString("Name"),rs.getString("Marks1"),rs.getString("Marks2"),rs.getString("Marks3"),getResult());
		
		      }
	    }
	    catch (ReportNotMadeException ex) {
	    	System.out.println("Report has not been made yet");
	    }catch(Exception e) {
	    	System.out.println("cannot connect");
	    }
	}
	public void report(String email, String pass) {
		String url="jdbc:mysql://localhost:3306/collegeinformation";
	    String username="root";
	    String password="";
	    try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
		      Connection connection=DriverManager.getConnection(url,username,password);
		      Statement st= connection.createStatement();
		      ResultSet rs=st.executeQuery("SELECT * FROM students WHERE email= '"+email+"'AND password = '"+pass+"'") ;
		      while(rs.next()) {
		    	  System.out.println(rs.getInt("Marks1"));
		    	  if(rs.getInt("Marks1")==0 && rs.getInt("Marks2")==0 && rs.getInt("Marks3")==0) {
		    		  setResult("Ng");
		    	  }
		    	  else if(rs.getInt("Marks1")>=40 && rs.getInt("Marks2")>=40 && rs.getInt("Marks3")>=40) {
		    		  setResult("Pass");
		    	  }
		    	  else {
		    		  setResult("Fail");
		    	  }
		    	  setMarks1(rs.getInt("Marks1"));
		    	  setMarks2(rs.getInt("Marks2"));
		    	  setMarks3(rs.getInt("Marks3"));
		      }
		      
		     
	    }catch(Exception e) {
	    	System.out.println("cannot connect");
	    }
	}


	

}
