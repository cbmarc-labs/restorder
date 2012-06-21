/**
 * 
 */
package cbmarc.restorder.client.mvp;

import cbmarc.restorder.client.activity.ArticleEditActivity;
import cbmarc.restorder.client.activity.ArticleListActivity;
import cbmarc.restorder.client.place.ArticleEditPlace;
import cbmarc.restorder.client.place.ArticleListPlace;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author marc
 *
 */
public class MainActivityMapper extends ActivityMapperProxy {

	@Inject
	public MainActivityMapper(
			Provider<ArticleListActivity> articleListActivityProvider,
			Provider<ArticleEditActivity> articleEditActivityProvider) {
		super();
		
		providerMap.put(ArticleListPlace.class, articleListActivityProvider);
		providerMap.put(ArticleEditPlace.class, articleEditActivityProvider);
	}

}
