package cbmarc.restorder.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

/**
 * MessageEvent class
 * 
 * @author marc
 *
 */
public class JQMChangePageEvent extends GwtEvent<JQMChangePageEvent.Handler> {
	
	public interface Handler extends EventHandler {
		
		public void onChangePage(JQMChangePageEvent event);
		
	}
	
	private static Type<Handler> TYPE = new Type<Handler>();
	
	private String page;
	
	private JQMChangePageEvent(String page) {
		this.page = page;
	}
	
	public String getPage() {
		return page;
	}
	
	public static Type<Handler> getType() {	
		return TYPE;
	}

	@Override
	public final Type<Handler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(Handler handler) {
		handler.onChangePage(this);
	}

}
