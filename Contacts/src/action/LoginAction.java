package action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.LoginModel;
import model.ProfileModel;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.omg.CORBA.Request;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.LoginService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.UserDAO;
import dto.User;

public class LoginAction extends ActionSupport implements ModelDriven<LoginModel>,SessionAware {
	private static final long serialVersionUID = 1L;
	LoginModel user = new LoginModel();
	ProfileModel profileData = new ProfileModel();
	private SessionMap<String,Object> sessionMap; 
	HttpServletRequest request = ServletActionContext.getRequest();

	@Override
	public LoginModel getModel() {
		return user;
	}
	
	@Override
	public String execute(){
		System.out.println("Login Execute");
		return "success";
	}
	
	public String loginMethod(){
		System.out.println("Login Method");
		if(checkLogin()){
			System.out.println("Returning Success");
			return "success";
		}
		else
			return "fail";
	}
	
	private boolean checkLogin(){
		ApplicationContext applicationContext = null;
		applicationContext = new ClassPathXmlApplicationContext("service.xml");
		LoginService userDAO = (LoginService) applicationContext.getBean("LoginService");
		List<User> users = userDAO.getUserList(user);
		
		int n = users.size();
		if(n>0){
			User u = users.get(0);
			profileData.setUsername(u.getUserName());
			profileData.setPhonenumber(u.getPhoneNumber());
			profileData.setAddress(u.getAddress());
			profileData.setCityName(u.getCities().getCityName());
			profileData.setColourName(u.getColour().getColourName());
			sessionMap.put("userObject", profileData);
			return true;
		}
		else		
			return false;
	}
//	@Override
//	public void validate(){
//		System.out.println("######Validate");
//		
//		if(user.getUsername()==null||user.getUsername().equalsIgnoreCase("")){
//			this.addFieldError("Username","Please enter Username");
//		}if(user.getPassword()==null||user.getPassword().equalsIgnoreCase("")){
//			this.addFieldError("Password","Please enter Password");
//		}
//	}
	@Override
	public void setSession(Map<String, Object> map) {
		 sessionMap=(SessionMap)map;  
	}

}
