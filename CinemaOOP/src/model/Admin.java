package model;

public class Admin extends User {
	private String role;
	public Admin(String id, String name, String passwordHashed, String role) {
		super(id, name, passwordHashed);
		this.role = role;
	}
	
	@Override
	public void setName(String name) {
		throw new UnsupportedOperationException("Admin's name is final");
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
