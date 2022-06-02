package service;

import java.util.List;

import common.CommonMethods;
import dao.AdminDao;
import model.TypeUser;
import model.User;

public class AdminService {
	AdminDao dao = new AdminDao();
	CommonMethods commonMethods = new CommonMethods();


	public TypeUser takeUserType(String typeUser) {
		
		return commonMethods.takeUserType(typeUser);
	}

	public List<User> backUserType(TypeUser type) {
		
		return dao.backUserType(type);
	}



}
