package action;

import java.util.List;
import java.util.Map;

import model.LoginModel;
import model.ProfileModel;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.UserDAO;
import dto.User;

public class LoginAction extends ActionSupport implements ModelDriven<LoginModel>,SessionAware {
	private static final long serialVersionUID = 1L;
	LoginModel user = new LoginModel();
	ProfileModel profileData = new ProfileModel();
	private SessionMap<String,Object> sessionMap; 
	
	@Override
	public LoginModel getModel() {
		return user;
	}
	
	@Override
	public String execute(){
		if(checkLogin()){
			sessionMap.put("password", "Session password");
			return "success";
		}
		else
			return "fail";
	}
	
	private boolean checkLogin(){
		UserDAO userDAO = new UserDAO();
		List<User> users = userDAO.getLoginList(user);
		
		int n = users.size();
		if(n>0){
			User u = users.get(0);
			profileData.setUsername(u.getUserName());
			profileData.setPhonenumber(u.getPhoneNumber());
			profileData.setAddress(u.getAddress());
			sessionMap.put("userObject", profileData);
			return true;
		}
		else		
			return false;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		 sessionMap=(SessionMap)map;  
	}

}
