package cbmarc.restorder.client.rpc;

import java.util.List;

import cbmarc.restorder.shared.model.Model;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("article.rpc")
public interface ArticleService extends CrudService {
	
	public List<Model> getAll(Long id) throws Exception;
	
}
