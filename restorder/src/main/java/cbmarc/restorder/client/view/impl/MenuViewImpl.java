/**
 * 
 */
package cbmarc.restorder.client.view.impl;

import cbmarc.restorder.client.place.ArticleEditPlace;
import cbmarc.restorder.client.place.ArticleListPlace;
import cbmarc.restorder.client.view.MenuView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;

/**
 * @author Marc
 *
 */
@Singleton
public class MenuViewImpl extends Composite implements MenuView {

	private static MenuUiBinder uiBinder = GWT.create(MenuUiBinder.class);
	interface MenuUiBinder extends UiBinder<Widget, MenuViewImpl> {}
	
	@UiField Anchor menu1;
	@UiField Anchor menu2;
	
	private Presenter presenter;
	
	public MenuViewImpl() {		
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiHandler("menu1")
	void handleClick(ClickEvent e) {
		presenter.goTo(new ArticleEditPlace());
	}

	@UiHandler("menu2")
	void menu2HandleClick(ClickEvent e) {
		presenter.goTo(new ArticleListPlace());
	}
	
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
		
	}

}
