package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import dto.City;

public class CityDao {

	List<City> cityList=null;
	public List<City> getCityList(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
	       cityList = (List<City>)session.createQuery("from City").list();
	        System.out.println("READING End");
        }catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
		return cityList;
	}
}
