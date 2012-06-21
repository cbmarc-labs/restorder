/**
 * 
 */
package cbmarc.restorder.client.view;

import com.google.gwt.place.shared.Place;

/**
 * @author marc
 *
 */
public interface MenuView extends IsView {
	
	public void setPresenter(Presenter presenter);
	
	public interface Presenter {
		public void goTo(Place place);
	}
	
}
