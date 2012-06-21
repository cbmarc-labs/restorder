package cbmarc.restorder.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Restorder implements EntryPoint {
	
	@Override
	public void onModuleLoad() {
		AppGinjector ginjector = GWT.create(AppGinjector.class);
		RootPanel.get("start").add(ginjector.getMainView());
		
		ginjector.getPlaceHistoryHandler().handleCurrentHistory();
	  
	}
	
}
