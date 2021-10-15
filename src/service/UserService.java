package service;

import java.util.List;
import java.util.Map;

import dao.UserDao;
import entity.User;

public class UserService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void add(User user) {
		userDao.add(user);
	}

	public String findNameById(int id) {
		return userDao.findNameById(id);
	}

	public int findNumbers() {
		return userDao.findNumbers();
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User findById(int id) {
		return userDao.findById(id);
	}

	public Map<String, Object> findMapById(int id) {
		return userDao.findMapById(id);
	}

	public List<Map<String, Object>> findAllMap() {
		return userDao.findAllMap();
	}
}
