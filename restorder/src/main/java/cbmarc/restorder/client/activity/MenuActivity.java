/**
 * 
 */
package cbmarc.restorder.client.activity;

import cbmarc.restorder.client.view.MenuView;

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
public class MenuActivity extends AbstractActivity 
		implements MenuView.Presenter {
	
	private MenuView view;
	private PlaceController placeController;
	
	@Inject
	public MenuActivity(MenuView view, PlaceController placeController) {
		super();
		this.view = view;
		this.placeController = placeController;
		view.setPresenter(this);
		
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		panel.setWidget(view);
		
	}

	@Override
	public void goTo(Place place) {
		placeController.goTo(place);
		
	}

}
