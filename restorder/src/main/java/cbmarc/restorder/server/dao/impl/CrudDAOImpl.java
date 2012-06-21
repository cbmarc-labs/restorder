/**
 * 
 */
package cbmarc.restorder.server.dao.impl;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import cbmarc.restorder.server.dao.CrudDAO;

/**
 * CrudDAOImpl class
 * 
 * @author Marc
 */
@Component("crudDAO")
public class CrudDAOImpl<Type> 
		extends HibernateDaoSupport implements CrudDAO<Type> {
	
	/**
	 * logger
	 */
	private static Logger logger =
		    Logger.getLogger(CrudDAOImpl.class.getName());
			
	/**
	 * init()
	 * 
	 * @param factory
	 */
	@Autowired
    public void init(SessionFactory factory) {
        setSessionFactory(factory);
    }
    
	/**
	 * saveOrUpdate()
	 * 
	 * @author marc
	 */
	@Override
	public void saveOrUpdate(Type entity) throws Exception {
		getHibernateTemplate().saveOrUpdate(entity);
		
	}

	/**
	 * deleteAll()
	 * 
	 * @author marc
	 */
	@Override
	public void deleteAll(Set<Type> entity) throws Exception {
		getHibernateTemplate().deleteAll(entity);
		
	}

	/**
	 * get()
	 * 
	 * @author marc
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Type get(long id, String domainName) throws Exception {
		return (Type)getHibernateTemplate().get(domainName, id);
		
	}

	/**
	 * getAll()
	 * 
	 * @author marc
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Type> getAll(final String domainName) throws Exception {
		List<Type> list = getHibernateTemplate().find("from " + domainName);		
		
		return list;
	}

	@Override
	public void delete(Type entity) throws Exception {
		getHibernateTemplate().delete(entity);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Type> getAll(String domainName, String clause) throws Exception {
		List<Type> list = getHibernateTemplate().find("from " + domainName + " " + clause);		
		
		return list;
	}

}
