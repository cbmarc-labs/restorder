/**
 * 
 */
package cbmarc.restorder.client.event;

import com.google.gwt.event.shared.HandlerManager;

/**
 * @author marc
 *
 */
public class EventBus extends HandlerManager {
	
	private static final EventBus eventBus = new EventBus();

	public EventBus() {
		super(null);
		
	}
	
	public static EventBus getEventBus() {
		return eventBus;
		
	}

}
