/**
 * 
 */
package cbmarc.restorder.server;

import java.util.List;

import cbmarc.restorder.client.rpc.ArticleService;
import cbmarc.restorder.shared.ServerException;
import cbmarc.restorder.shared.model.Article;
import cbmarc.restorder.shared.model.Model;

/**
 * @author Marc
 *
 */
@SuppressWarnings("serial")
public class ArticleServiceImpl
	extends CrudServiceImpl implements ArticleService {
	
	@Override
	public List<Model> getAll(Long id) throws ServerException {
		List<Model> list = null;
		
		String name = Article.class.getName();
		
		try {
			String filter = "and parent=null";
			if(id != null)
				filter = "and parent=" + id;
			
			list = dao.getAll(name, "where folder=1 " + filter + " order by name");
			list.addAll(dao.getAll(name, "where folder=0 " + filter + " order by name"));
			
			
		} catch(Exception e) {
			throw new ServerException(e);
			
		}
		
		return list;
	}
}
