package cbmarc.restorder.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

/**
 * MessageEvent class
 * 
 * @author marc
 *
 */
public class JQMListSplitEvent extends GwtEvent<JQMListSplitEvent.Handler> {
	
	public interface Handler extends EventHandler {
		
		public void onLeftClick(JQMListSplitEvent event, int index);
		public void onRightClick(JQMListSplitEvent event, int index);
		
	}
	
	private static Type<Handler> TYPE = new Type<Handler>();
	private enum Operation {LEFT, RIGHT};	
	private Operation operation;
	private int index;
	
	private JQMListSplitEvent(Operation operation, int index) {
		this.operation = operation;
		this.index = index;
	}
	
	public static JQMListSplitEvent left(int index) {
		return new JQMListSplitEvent(Operation.LEFT, index);
	}
	
	public static JQMListSplitEvent right(int index) {
		return new JQMListSplitEvent(Operation.RIGHT, index);
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
		case LEFT:
			handler.onLeftClick(this, index);
			break;
		case RIGHT:
			handler.onRightClick(this, index);
			break;
		}
	}

}
