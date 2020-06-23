package school_control.beans;

public class Teacher {
	private String userName;
	private String password;
	private float workExp;
	
	public Teacher() {
		
	}
	
	public Teacher(String userName, String password, float workExp) {
		this.userName = userName;
		this.password = password;
		this.workExp = workExp;
		
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public float getWorkExp() {
		return workExp;
	}
	
	public void setWorkExp(float workExp) {
		this.workExp = workExp;
	}
}
