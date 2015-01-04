package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.ProfileModel;
import model.RegisterModel;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.UserDAO;

public class Register extends ActionSupport implements ModelDriven<RegisterModel>,SessionAware {
	SessionMap<String, Object> sessionMap;
	RegisterModel regMod = new RegisterModel();
	ProfileModel profileData = new ProfileModel();
	UserDAO userDAO = new UserDAO();
	HttpServletRequest request = ServletActionContext.getRequest();
	
	public String execute(){
		System.out.println("####Execute");
		if(userDAO.AddUser(regMod)){
			request.setAttribute("status", "Registration Successful- Welcome to our Struts Application!");
			profileData.setUsername(regMod.getUsername());
			profileData.setPhonenumber(regMod.getPhonenumber());
			profileData.setAddress(regMod.getAddress());
			sessionMap.put("userObject", profileData);
			return "success";
		}
		else
			return "fail";
	}
	@Override
	public RegisterModel getModel() {
		// TODO Auto-generated method stub
		return regMod;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionMap =(SessionMap<String, Object>) arg0;
		
	}

}
