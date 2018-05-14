package SpringMy.Maven.db.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import SpringMy.Maven.db.enities.Category;
@Repository
public class CategoryDAO {
	
	
	 private static final Log log = LogFactory.getLog(UsersDAO.class);
     @Autowired
	 private SessionFactory sessionFactory;
	 
	 public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	       }
	
	 
	 public Integer getCategoryID(String categoryName){
	 log.debug("categoryName instance");
	  try {	 
		    Session session = sessionFactory.getCurrentSession();
		   Criteria criteria = session.createCriteria(Category.class);
		                     criteria.add(Restrictions.eq("categoryName", categoryName));
		                     criteria.setProjection(Property.forName("categoryId")).uniqueResult();
		                     
		   Integer id = (Integer) criteria.list().get(0);            
		   		   
		   System.out.println("value of Category="+id); 
		   return id;
	      } catch (RuntimeException re) {
	         log.error("categoryName failed", re);
	         throw re;
          }
		 
	 }

}
