/**
 * 
 */
package cbmarc.restorder.client.view;

import cbmarc.restorder.client.view.impl.ArticleEditViewImpl;
import cbmarc.restorder.client.view.impl.ArticleListViewImpl;
import cbmarc.restorder.client.view.impl.MainViewImpl;
import cbmarc.restorder.client.view.impl.MenuViewImpl;

import com.google.gwt.inject.client.AbstractGinModule;

/**
 * @author marc
 *
 */
public class ViewGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(MainViewImpl.class);
		bind(ArticleEditView.class).to(ArticleEditViewImpl.class);
		bind(ArticleListView.class).to(ArticleListViewImpl.class);
		bind(MenuView.class).to(MenuViewImpl.class);
	}

}
