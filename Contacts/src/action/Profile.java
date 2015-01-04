package action;

import javax.servlet.http.HttpSession;



import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dto.User;

public class Profile extends ActionSupport implements ModelDriven<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	User user = new User();
	 //HttpSession session=ServletActionContext.getRequest().getSession(false);  
	 @Override
	public String execute() throws Exception {
		System.out.println("####Execute Of Profile");
		//user= (User)session.getAttribute("userObject");
		user.setUserName("LOL User");
		return "success";
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
}
