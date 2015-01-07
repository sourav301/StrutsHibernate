package dao;

import java.util.List;

import model.RegisterModel;
import model.LoginModel;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import vo.CityVO;
import dto.City;
import dto.User;
 

public class UserDAO {
	
	public Boolean AddUser(RegisterModel regModel,CityVO cityModel){
		System.out.println("####Add user");
		System.out.println(regModel.getUsername());
		System.out.println(regModel.getPassword());
		System.out.println(regModel.getAddress());
		System.out.println(regModel.getPhonenumber());
		System.out.println(regModel.getCities());
		
		City city = new City();
		city.setCityId(cityModel.getCityId());
		city.setCityName(cityModel.getCityName());
		User userDTO = new User();
		userDTO.setUserName(regModel.getUsername());
		userDTO.setPassWord(regModel.getPassword());
		userDTO.setAddress(regModel.getAddress());
		userDTO.setPhoneNumber(regModel.getPhonenumber());
		userDTO.setCities(city);
		
		//userDTO.setCities(regModel.getCities());
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			session.save(userDTO);
			session.getTransaction().commit();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			
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
        }finally{
        	
		}
		return loginModelList;
	}
	
}
