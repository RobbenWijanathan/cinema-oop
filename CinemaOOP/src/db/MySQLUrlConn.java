package db;

public class MySQLUrlConn implements UrlConn {
	private final String url;
	private String username;
	private String password;
	
	
	
	public MySQLUrlConn(String url) {
		super();
		this.url = String.format("jdbc:mysql://localhost:3306/%s", url);
	}

	@Override
	public String getUrl() {
		// TODO Auto-generated method stub
		return url;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
