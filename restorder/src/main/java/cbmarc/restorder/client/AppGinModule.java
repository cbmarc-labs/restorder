package cbmarc.restorder.client;

import cbmarc.restorder.client.activity.ActivityGinModule;
import cbmarc.restorder.client.mvp.MvpGinModule;
import cbmarc.restorder.client.view.ViewGinModule;

import com.google.gwt.inject.client.AbstractGinModule;

public class AppGinModule extends AbstractGinModule {

	@Override
	protected void configure() {

		install(new ActivityGinModule());
	    install(new MvpGinModule());
	    install(new ViewGinModule());
		
	}

}
