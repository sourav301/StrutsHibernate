package service;

import java.util.List;

import vo.CityVO;
import vo.ColourVO;
import model.LoginModel;
import model.RegisterModel;
import dao.UserDAO;
import dto.User;

public class LoginService {
	UserDAO userDao;

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	public List<User> getUserList(LoginModel loginModel){
		List<User> userList = null;
		userList = userDao.getLoginList(loginModel);
		return userList;
	}
	public boolean AddUser(RegisterModel regModel,CityVO cityModel,ColourVO colourVO){
		System.out.println("Add user Service");
		try{
			if(userDao.AddUser(regModel, cityModel, colourVO))
				return true;
			else
				return false;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	

}
