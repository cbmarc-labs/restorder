package cbmarc.restorder.client.rpc;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public abstract class AppAsyncCallback<T> implements AsyncCallback<T> {
	
	@Override
	public void onFailure(Throwable caught) {
		Window.alert("Server error: " + caught.toString());
		
	}
	
}
