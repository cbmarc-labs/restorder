/**
 * 
 */
package cbmarc.restorder.client.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author Marc
 *
 */
public interface ImageServiceAsync {
	
	void getAll(AsyncCallback<List<String>> callback);

}
