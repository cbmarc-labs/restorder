/**
 * 
 */
package cbmarc.restorder.client.mvp;

import cbmarc.restorder.client.activity.MenuActivity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author marc
 *
 */
public class MenuActivityMapper implements ActivityMapper {

	Provider<MenuActivity> menuActivityProvider;

	@Inject
	public MenuActivityMapper(Provider<MenuActivity> menuActivityProvider) {
		super();
		this.menuActivityProvider = menuActivityProvider;
	}
	
	@Override
	public Activity getActivity(Place place) {
		return menuActivityProvider.get();
	}	

}
