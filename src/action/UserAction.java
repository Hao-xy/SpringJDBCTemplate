package action;

import java.util.List;
import java.util.Map;

import entity.User;
import service.UserService;

public class UserAction {
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void add(User user) {
		userService.add(user);
	}

	public String findNameById(int id) {
		return userService.findNameById(id);
	}

	public int findNumbers() {
		return userService.findNumbers();
	}

	public List<User> findAll() {
		return userService.findAll();
	}

	public User findById(int id) {
		return userService.findById(id);
	}

	public Map<String, Object> findMapById(int id) {
		return userService.findMapById(id);
	}

	public List<Map<String, Object>> findAllMap() {
		return userService.findAllMap();
	}
}
