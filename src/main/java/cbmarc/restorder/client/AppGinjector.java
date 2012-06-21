package cbmarc.restorder.client;

import cbmarc.restorder.client.view.impl.MainViewImpl;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;

@GinModules({AppGinModule.class})
public interface AppGinjector extends Ginjector {
	
	PlaceHistoryHandler getPlaceHistoryHandler();
	PlaceController getPlaceController();
	MainViewImpl getMainView();

}
