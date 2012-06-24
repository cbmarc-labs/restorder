/**
 * 
 */
package cbmarc.restorder.client.view;

import com.google.gwt.place.shared.Place;

/**
 * @author marc
 *
 */
public interface MainView extends IsView {
	
	String getId();
		
	public interface Presenter {
		void goTo(Place place);
	}
	
}
