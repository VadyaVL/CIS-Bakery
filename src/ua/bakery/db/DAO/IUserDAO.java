package ua.bakery.db.DAO;

import java.util.Collection;

import ua.bakery.db.jpa.User;

/**
* @author vadym
* @since 0.12
*/
public interface IUserDAO {
	public void saveUser(User user);
	public void updateUser(User user);
	public User getUserById(Integer user_id);
	public Integer getAllUserCount();
	public Collection<User> getAllUser();
	public void deleteUser(User user);
}