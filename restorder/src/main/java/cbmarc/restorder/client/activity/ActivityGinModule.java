/**
 * 
 */
package cbmarc.restorder.client.activity;

import com.google.gwt.inject.client.AbstractGinModule;

/**
 * @author marc
 *
 */
public class ActivityGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(MenuActivity.class);
		bind(ArticleEditActivity.class);
		bind(ArticleListActivity.class);
		
	}

}
