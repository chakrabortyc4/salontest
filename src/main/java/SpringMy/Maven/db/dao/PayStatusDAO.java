package SpringMy.Maven.db.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import SpringMy.Maven.db.enities.PayStatus;
import SpringMy.Maven.db.enities.Users;
import SpringMy.Maven.model.UserStatusDisplayDTO;
@Repository
public class PayStatusDAO {
	
 private static final Log log = LogFactory.getLog(PayStatusDAO.class);
     @Autowired
	 private SessionFactory sessionFactory;
	 public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	       }
	 
	 
	 public void persist(PayStatus transientInstance){
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
	 
	
	 public void attachDirty(PayStatus instance) {
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
	 
	 
	 public List findByExample(PayStatus instance) {
			log.debug("finding PayStatus instance by example");
			try {
				  Session session = sessionFactory.getCurrentSession();
				 List results = session.createCriteria("SpringMy.Maven.db.enities.PayStatus").add(Example.create(instance)).list();
				 log.debug("find by example successful, result size: " + results.size());
				return results;
			} catch (RuntimeException re) {
				log.error("find by example failed", re);
				throw re;
			}
		} 
	 
	
	
	public void delete(PayStatus persistentInstance) {
		log.debug("deleting Domain instance");
		try {			
			  Session session = sessionFactory.getCurrentSession();
			  session.delete(persistentInstance);
			 log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	
	public List<UserStatusDisplayDTO> fetchSql(String sql){
		log.debug("PayStatus instance : " + sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			 @SuppressWarnings("unchecked")
			 List<UserStatusDisplayDTO> results = session.createSQLQuery(sql)
							  .addScalar("user_id", StandardBasicTypes.INTEGER)
							  .addScalar("first_name", StandardBasicTypes.STRING)
							  .addScalar("last_name", StandardBasicTypes.STRING)
							  .addScalar("club", StandardBasicTypes.STRING)
							  .addScalar("country", StandardBasicTypes.STRING)
							  .addScalar("attempt_section", StandardBasicTypes.INTEGER)
							  .addScalar("total_entry", StandardBasicTypes.INTEGER)
							  .addScalar("paying_status", StandardBasicTypes.STRING)
							  .setResultTransformer( Transformers.aliasToBean(UserStatusDisplayDTO.class))
							  .list();
			
			 if(results.size()>0)
				return results; 				 			
		    }catch (RuntimeException re) {
				log.error("fatch UserGroupRole failed", re);
				throw re;
			}
		return new ArrayList();
	}
	
	
	
	public PayStatus findByUserId(Users id) {
		log.debug("getting User instance with id: " + id);
		try{
			 Session session = sessionFactory.getCurrentSession();
			 Criteria cr =session.createCriteria(PayStatus.class)
					     .add(Restrictions.eq("users", id));
			PayStatus payStatus = (PayStatus) cr.uniqueResult();
						
			return payStatus;      		
		   } catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		   }
			
	}
	
}
