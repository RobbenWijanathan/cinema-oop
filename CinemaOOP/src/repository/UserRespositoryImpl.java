package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.MySQLConn;
import model.User;

public class UserRespositoryImpl implements UserRepository {
	Connection conn;
	public UserRespositoryImpl() {
		try {
			conn = ((MySQLConn)MySQLConn.getConn()).conn;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	private User mapUser(ResultSet rs) throws SQLException {
		return new User(
			rs.getInt("id"),
			rs.getString("name"),
			rs.getString("password")
		);
				
	}
	
	public List<User> getUsers() throws SQLException {
		String query = "SELECT * FROM users";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet res = ps.executeQuery();
			List<User> users = new ArrayList<>();
			while(res.next()) {
				users.add(mapUser(res));
			}
			return users;
		}
		catch(SQLException e) {
			throw e;
		}
		catch(Exception e) {
			throw e;
		}
	}

	public User getUserById(String id) throws SQLException {
		String query = "SELECT * FROM users WHERE id LIKE ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				return mapUser(res);
			}
		}
		catch(SQLException e) {
			throw e;
		}
		catch(Exception e) {
			throw e;
		}
		return null;
	}

	public User getUserByName(String name) throws SQLException {
		String query = "SELECT * FROM users WHERE name LIKE ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				return mapUser(res);
			}
		}
		catch(SQLException e) {
			throw e;
		}
		catch(Exception e) {
			throw e;
		}
		return null;
	}

	public boolean createUser(String name, String hashedPassword) throws SQLException  {
		String query = "INSERT INTO users VALUES (?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, hashedPassword);
			ps.executeUpdate();
			return true;
		}
		catch(SQLException e) {
			throw e;
		}
		catch(Exception e) {
			throw e;
		}
	}

	public boolean updateUser(String id, String name, String hashedPassword) throws SQLException {
		String query = "INSERT users SET name = ?, password = ? WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, hashedPassword);
			ps.setString(3, id);
			ps.executeUpdate();
			return true;
		}
		catch(SQLException e) {
			throw e;
		}
		catch(Exception e) {
			throw e;
		}
	}

	public boolean deleteUser(String id) throws SQLException {
		String query = "DELETE FROM users WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
			return true;
		}
		catch(SQLException e) {
			throw e;
		}
		catch(Exception e) {
			throw e;
		}
	}
}
