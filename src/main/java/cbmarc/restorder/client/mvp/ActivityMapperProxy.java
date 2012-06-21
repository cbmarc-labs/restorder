/**
 * 
 */
package cbmarc.restorder.client.mvp;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Provider;

/**
 * @author marc
 *
 */
public abstract class ActivityMapperProxy implements ActivityMapper {
	
	Map<Class<? extends Place>, Provider<? extends Activity>> providerMap = 
			new HashMap<Class<? extends Place>, Provider<? extends Activity>>();

	public Activity getActivity(Place place) {
		Provider<? extends Activity> provider = providerMap.get(place.getClass());
		
		if(provider != null)
			return provider.get();
		
		return null;
	}

}
