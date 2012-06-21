/**
 * 
 */
package cbmarc.restorder.client.rpc;

import java.util.List;

import cbmarc.restorder.shared.model.Article;
import cbmarc.restorder.shared.model.Model;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author Marc
 *
 */
public interface ArticleServiceAsync extends CrudServiceAsync {
	
	void getAll(Article article, AsyncCallback<List<Model>> callback);
	
}
