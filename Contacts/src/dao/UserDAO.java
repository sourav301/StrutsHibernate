package dao;

import java.util.List;

import model.RegisterModel;
import model.LoginModel;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import dto.User;
 

public class UserDAO {
	
	public Boolean AddUser(RegisterModel regModel){
		System.out.println("####Add user");
		System.out.println(regModel.getUsername());
		System.out.println(regModel.getPassword());
		System.out.println(regModel.getAddress());
		System.out.println(regModel.getPhonenumber());
		
		User userDTO = new User();
		userDTO.setUserName(regModel.getUsername());
		userDTO.setPassWord(regModel.getPassword());
		userDTO.setAddress(regModel.getAddress());
		userDTO.setPhoneNumber(regModel.getPhonenumber());
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			session.save(userDTO);
			session.getTransaction().commit();
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	
	
	public List<User> getLoginList(LoginModel loginModel){
		List<User> loginModelList = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
	        System.out.println("READING Start ##"+loginModel.getUsername());
	        loginModelList = (List<User>)session.createQuery("from User L where L.userName='"+loginModel.getUsername()+"' and L.passWord='"+loginModel.getPassword()+"'").list();
	        System.out.println("READING End");
        }catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
		return loginModelList;
	}
	
}
