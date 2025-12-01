package model;

public class User {
	protected String id;
	protected String name;
	protected String passwordHashed;
	
	public User(String id, String name, String passwordHashed) {
		super();
		this.id = id;
		this.name = name;
		this.passwordHashed = passwordHashed;
	}
	
	public User(Integer id, String string, String string2) {
		super();
		this.id = id.toString();
		this.name = name;
		this.passwordHashed = passwordHashed;
	}

	public String getUserId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswordHashed() {
		return passwordHashed;
	}
	public void setPasswordHashed(String passwordHashed) {
		this.passwordHashed = passwordHashed;
	}
	
}
