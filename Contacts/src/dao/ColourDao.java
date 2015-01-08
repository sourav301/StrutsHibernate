package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import dto.Colour;
 

public class ColourDao {
	List<Colour> colourList=null;
	public List<Colour> getColourList(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
	       colourList = (List<Colour>)session.createQuery("from Colour").list();
	       System.out.println("READING End");
        }catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally{
        	session.close();
        }
		return colourList;
	}
}
