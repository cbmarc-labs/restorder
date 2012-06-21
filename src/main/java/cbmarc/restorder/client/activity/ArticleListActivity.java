/**
 * 
 */
package cbmarc.restorder.client.activity;

import cbmarc.restorder.client.view.ArticleListView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

/**
 * @author marc
 *
 */
public class ArticleListActivity extends AbstractActivity 
		implements ArticleListView.Presenter {
	
	private ArticleListView view;
	private PlaceController placeController;
	
	@Inject
	public ArticleListActivity(ArticleListView view, PlaceController placeController) {
		super();
		this.view = view;
		this.placeController = placeController;
		view.setPresenter(this);
		
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		panel.setWidget(view.asWidget());
		
	}

	@Override
	public void goTo(Place place) {
		placeController.goTo(place);
		
	}

}
