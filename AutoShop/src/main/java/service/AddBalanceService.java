package service;

import dao.AddBalanceDao;
import model.User;

public class AddBalanceService {
	
	AddBalanceDao dao = new AddBalanceDao();

	public User existUser(String userName) {
		
		return dao.existUser(userName);
	}

	public boolean addBalanceToUser(User user, Double balance) {
		
		return dao.addBalanceToUser(user,balance);
	}

	

}
