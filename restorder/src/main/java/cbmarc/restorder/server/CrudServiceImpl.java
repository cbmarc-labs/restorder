/**
 * 
 */
package cbmarc.restorder.server;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import cbmarc.restorder.client.rpc.CrudService;
import cbmarc.restorder.server.dao.CrudDAO;
import cbmarc.restorder.shared.ServerException;
import cbmarc.restorder.shared.model.Model;

/**
 * @author Marc
 *
 */
@SuppressWarnings("serial")
public class CrudServiceImpl
	extends SpringRemoteServiceServlet implements CrudService {
	
	@Autowired
	protected CrudDAO<Model> dao;

	@Override
	public void saveOrUpdate(Model model) throws ServerException {
		try {
			dao.saveOrUpdate(model);
			
		} catch(Exception e) {
			// normally bad style but we need to throw again to inform the client
			throw new ServerException(e);
			
		}
		
	}

	@Override
	public Model get(long id, String model) throws ServerException {
		Model entity = null;
		
		try {
			entity = dao.get(id, model);
			
		} catch(Exception e) {
			throw new ServerException(e);
		}
			
		return entity;
		
	}

	@Override
	public List<Model> getAll(String model) throws ServerException {
		try {
			return getAll(model, "");
		} catch(Exception e) {
			throw new ServerException(e);
		}
		
	}

	@Override
	public void deleteAll(Set<Model> model) throws ServerException {
		try {
			dao.deleteAll(model);
			
		} catch(Exception e) {
			throw new ServerException(e);
			
		}
		
	}

	@Override
	public String test(String data) throws Exception {
		//this.saveOrUpdate(new User(data, data, false, null));
		
		return "All ok !!!";
		
	}

	@Override
	public void delete(Model model) throws Exception {
		try {
			dao.delete(model);
		} catch(Exception e) {
			throw new ServerException(e);
			
		}
		
	}

	@Override
	public List<Model> getAll(String model, String clause) throws Exception {
		List<Model> list = null;
		
		try {
			list = dao.getAll(model, clause);
			
			for(Model m: list) {
				m.deHibernate();
			}
			
		} catch(Exception e) {
			throw new ServerException(e);
			
		}
		
		return list;
	}
}
