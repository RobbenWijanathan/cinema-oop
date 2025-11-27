package repository;

import java.sql.SQLException;
import java.util.List;

import model.User;

public interface UserRepository {
	public List<User> getUsers() throws SQLException;
	public User getUserById(String id) throws SQLException;
	public User getUserByName(String name) throws SQLException;
	public boolean createUser(String name, String hashedPassword) throws SQLException;
	public boolean updateUser(String id, String name, String hashedPassword) throws SQLException;
	public boolean deleteUser(String id) throws SQLException;
}
