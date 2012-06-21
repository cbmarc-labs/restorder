/**
 * 
 */
package cbmarc.restorder.client.mvp;

import cbmarc.restorder.client.place.AppPlaceHistoryMapper;
import cbmarc.restorder.client.place.DefaultPlace;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

/**
 * @author marc
 *
 */
public class MvpGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
		bind(PlaceHistoryMapper.class).to(AppPlaceHistoryMapper.class).in(Singleton.class);
		bind(MainActivityMapper.class);
		
	}
	
	@Provides 
	@Singleton  
	public PlaceHistoryHandler getHistoryHandler(PlaceController placeController,
			PlaceHistoryMapper historyMapper, EventBus eventBus) {
		PlaceHistoryHandler historyHandler =  new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, new DefaultPlace());
		
		return historyHandler;
	}
	
	@Provides
	@Singleton
	public PlaceController getPlaceController(EventBus eventBus) {
		return new PlaceController(eventBus);
	}

}
