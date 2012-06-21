/**
 * 
 */
package cbmarc.restorder.client.view.impl;

import cbmarc.restorder.client.place.ArticleEditPlace;
import cbmarc.restorder.client.ui.JQMButton;
import cbmarc.restorder.client.ui.JQMList;
import cbmarc.restorder.client.view.ArticleListView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;

/**
 * @author Marc
 *
 */
@Singleton
public class ArticleListViewImpl extends Composite implements ArticleListView {

	private static MainUiBinder uiBinder = GWT.create(MainUiBinder.class);
	interface MainUiBinder extends UiBinder<Widget, ArticleListViewImpl> {}
	
	@UiField JQMList list;
	@UiField JQMButton buttonNew;
	
	private Presenter presenter;
	
	public ArticleListViewImpl() {		
		initWidget(uiBinder.createAndBindUi(this));
		
	}

	@Override
	public JQMList getList() {
		return list;
	}

	@UiHandler("buttonNew")
	void buttonNewHandleClick(ClickEvent e) {
		presenter.goTo(new ArticleEditPlace());
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
		
	}

}
