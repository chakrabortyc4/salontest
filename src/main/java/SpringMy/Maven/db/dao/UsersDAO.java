package SpringMy.Maven.db.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import SpringMy.Maven.db.enities.Users;
import SpringMy.Maven.model.ClubDTO;


@Repository
public class UsersDAO {
	
	 private static final Log log = LogFactory.getLog(UsersDAO.class);

	 private SessionFactory sessionFactory;
	 
	 @Autowired
	 public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	       }
		
	 public void persist(Users transientInstance) {
		log.debug("persisting Domain instance");
		try {			
			 Session session = sessionFactory.getCurrentSession();
			 session.save(transientInstance);
			 log.debug("persist successful");
		    } catch (RuntimeException re) {
			         log.error("persist failed", re);
			         throw re;
		             }
	}
	 
	 public void attachDirty(Users instance) {
			log.debug("attaching dirty User instance");
			try {				 
				 Session session = sessionFactory.getCurrentSession();
				 session.saveOrUpdate(instance);
				 log.debug("attach successful");
			} catch (RuntimeException re) {
				log.error("attach failed", re);
				throw re;
			}
		}
	 
	 
	public Users findById(java.lang.Integer id) {
		log.debug("getting User instance with id: " + id);
		Users instance = new Users();
		try{
			Session session = sessionFactory.getCurrentSession();
			 instance = (Users) session.get("SpringMy.Maven.db.enities.Users", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			    }
			
		   } catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		   }
		return instance;
		
	}
	
	public List<Users> findAColumn(String nameOfColumn){
		try{
			 Session session = sessionFactory.getCurrentSession();
			Criteria cr =session.createCriteria(Users.class)
		    .setProjection(Projections.projectionList()		      
		    .add(Projections.property(nameOfColumn), nameOfColumn))
		    .setResultTransformer(Transformers.aliasToBean(Users.class));
			
			 List<Users> list = cr.list();
			 
			 return list;
		   } catch (RuntimeException re) {
			                               log.error("get failed", re);
			                               throw re;
		                                  }		
	 }
	
	
	public String findPassword(String email){
		String password =null;
		try{
			 Session session = sessionFactory.getCurrentSession();
			Criteria cr =session.createCriteria(Users.class);
					     cr.add(Restrictions.eq("email", email));
			             cr.setProjection(Property.forName("password")).uniqueResult();
			             password = (String) cr.list().get(0);		             			            
		}catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
           }
		return password;
	}
	
	
	public Users findByUserId(Integer usersId) {
		log.debug("getting User instance with id: " + usersId);
		try{
			 Session session = sessionFactory.getCurrentSession();
			Criteria cr =session.createCriteria(Users.class)
					     .add(Restrictions.eq("user_id", usersId));
			Users Users = (Users) cr.uniqueResult();
						
			return Users;      		
		   } catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		   }
			
	}
	
	public List findByExample(Users instance) {
		log.debug("finding User instance by example");
		try {
			 Session session = sessionFactory.getCurrentSession();
			 List results = session.createCriteria("SpringMy.Maven.db.enities.Users").add(Example.create(instance)).list();
			 log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<ClubDTO> fetchSql(String sql) {
		try {
			Session session = sessionFactory.getCurrentSession();
			
			@SuppressWarnings("unchecked")
			List<ClubDTO> results = session.createSQLQuery(sql)
					                         .addScalar("members_count", StandardBasicTypes.INTEGER)
					                         .addScalar("club", StandardBasicTypes.STRING)
					                         .setResultTransformer( Transformers.aliasToBean(ClubDTO.class))
											 .list();
			 
			 System.out.println("results.size="+results.size());
			if(results.size()>0)
			   return results;
			else
				return new ArrayList<ClubDTO>();
		}catch (RuntimeException re) {
			log.error("finding Category Wise FileCount of a User", re);
			throw re;
		}
	}

}
