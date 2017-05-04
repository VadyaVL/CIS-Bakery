package ua.bakery.db.DAO.dependInjection;

import java.util.Collection;
import java.util.List;

import ua.bakery.db.DAO.IUserDAO;
import ua.bakery.db.jpa.User;

public class UserDAO_DI {

	private IUserDAO userDAO;
	
	public UserDAO_DI(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

    
	public void saveUser(User user) {
		userDAO.saveUser(user);
	}

	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	public void deleteUser(User user) {
		userDAO.deleteUser(user);
	}

	public User getUserById(Integer user_id) {
		User user = userDAO.getUserById(user_id);
		return user;
	}

	public Integer getAllUserCount() {
		Integer cnt = userDAO.getAllUserCount();
		return cnt;
	}

	public Collection<User> getAllUser() {
		List<User> users = (List<User>) userDAO.getAllUser();
		return users;
	}


}
