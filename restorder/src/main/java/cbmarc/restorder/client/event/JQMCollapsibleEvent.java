package cbmarc.restorder.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

/**
 * MessageEvent class
 * 
 * @author marc
 *
 */
public class JQMCollapsibleEvent extends GwtEvent<JQMCollapsibleEvent.Handler> {
	
	public interface Handler extends EventHandler {
		
		public void onExpand(JQMCollapsibleEvent event);
		public void onCollapse(JQMCollapsibleEvent event);
		
	}
	
	private static Type<Handler> TYPE = new Type<Handler>();
	private enum Operation {EXPAND, COLLAPSE};
	
	private Operation operation;
	
	private JQMCollapsibleEvent(Operation operation) {
		this.operation = operation;
	}
	
	public static JQMCollapsibleEvent expand() {
		return new JQMCollapsibleEvent(Operation.EXPAND);
	}
	
	public static JQMCollapsibleEvent collapse() {
		return new JQMCollapsibleEvent(Operation.COLLAPSE);
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
		switch(operation) {
		case EXPAND:
			handler.onExpand(this);
			break;
		case COLLAPSE:
			handler.onCollapse(this);
			break;
		}
	}

}
