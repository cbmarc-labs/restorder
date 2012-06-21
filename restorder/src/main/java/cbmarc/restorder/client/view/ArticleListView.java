/**
 * 
 */
package cbmarc.restorder.client.view;

import cbmarc.restorder.client.ui.JQMList;

import com.google.gwt.place.shared.Place;

/**
 * @author marc
 *
 */
public interface ArticleListView extends IsView {
	
	JQMList getList();	
	void setPresenter(Presenter presenter);
	
	public interface Presenter {
		void goTo(Place place);
	}
}
