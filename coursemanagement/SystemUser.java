package coursemanagement;


public  abstract class SystemUser {
	private int id;
	private String name;
	private String address;
	private String phone;
	private String dob;
	private String email;
	private String password;

	SystemUser(){}
	SystemUser(int id, String name, String address, String phone, String dob,String email,String password ){
		this.id= id;
		this.name=name;
		this.address=address;
		this.phone=phone;
		this.dob=dob;
		this.email=email;
		this.password=password;
		System.out.println(name+"works");
	}
	public abstract void login(String email , String pass );
	
	public int getId() {
		return id;
	}
	public String getName() {
		return this.name;
	}
	public String getAddress() {
		return this.address;
	}
	public String getPhone() {
		return this.phone;
	}
	public String getDob() {
		return this.dob;
	}
	public String getEmail() {
		return this.email;
	}
	public String getPassword() {
		return this.password;
	}
}
