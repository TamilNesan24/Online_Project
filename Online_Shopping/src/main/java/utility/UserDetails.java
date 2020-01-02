package utility;

public class UserDetails 
{

	private String name;
	private String email;
	private String password;
	private String UserId;
	private String Address;
	
	UserDetails (String name,String password,String email,String UserId,String Address)
	{
		this.name=name;
		this.password=password;
		this.email=password;
		this.UserId=UserId;
		this.Address=Address;

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}

}
