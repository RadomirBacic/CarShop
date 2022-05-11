package service;

import java.util.List;

import dao.AdminDao;
import model.User;

public class AdminService {
	AdminDao dao = new AdminDao();

	public List<User> takeAllUsers() {
		
		return dao.takeAllUsers();
	}

}
