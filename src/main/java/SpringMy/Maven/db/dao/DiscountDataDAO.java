package SpringMy.Maven.db.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

import SpringMy.Maven.db.enities.DiscountData;
import SpringMy.Maven.db.enities.Users;

public class DiscountDataDAO {
	
 private static final Log log = LogFactory.getLog(PayStatusDAO.class);
	 
	 private SessionFactory sessionFactory;
	 private Transaction transaction;
	 private Session session;
	 
	 public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	       }
	 
	 
	 
	 public void persist(DiscountData transientInstance) {
			log.debug("persisting Domain instance");
			try {			
				 session = sessionFactory.openSession();
				 transaction = session.beginTransaction();
				 session.save(transientInstance);
				 log.debug("persist successful");
				 transaction.commit();
				 session.close();
			    } catch (RuntimeException re) {
				         log.error("persist failed", re);
				         throw re;
			             }
		}
	 
	 
	 public List findByExample(DiscountData instance) {
			log.debug("finding User instance by example");
			try {				
				 session = sessionFactory.openSession();
				 transaction = session.beginTransaction();
				 List results = session.createCriteria("SpringMy.Maven.db.enities.DiscountData").add(Example.create(instance)).list();
				 log.debug("find by example successful, result size: " + results.size());
				 transaction.commit();
				 session.close();
				return results;
			} catch (RuntimeException re) {
				log.error("find by example failed", re);
				throw re;
			}
		}
	 

	 
	 public List<DiscountData> findAColumn(String nameOfColumn){
			try{
				session = sessionFactory.openSession();
				Criteria cr =session.createCriteria(DiscountData.class)
			    .setProjection(Projections.projectionList()		      
			    .add(Projections.property(nameOfColumn), nameOfColumn))
			    .setResultTransformer(Transformers.aliasToBean(DiscountData.class));
				
				 List<DiscountData> list = cr.list();
				 
				 //System.out.println("list= "+list);
				 
				 return list;
			   } catch (RuntimeException re) {
				                               log.error("get failed", re);
				                               throw re;
			                                  }		
		 }



	public void attachDirty(DiscountData discountData) {
		// TODO Auto-generated method stub
		
	}
	 
	 
}
