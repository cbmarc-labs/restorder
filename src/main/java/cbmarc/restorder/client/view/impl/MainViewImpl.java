/**
 * 
 */
package cbmarc.restorder.client.view.impl;

import cbmarc.restorder.client.mvp.MainActivityMapper;
import cbmarc.restorder.client.mvp.MenuActivityMapper;
import cbmarc.restorder.client.ui.JQMContent;
import cbmarc.restorder.client.view.MainView;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;

/**
 * @author marc
 *
 */
@Singleton
public class MainViewImpl extends Composite implements MainView {

	private static MainViewImplUiBinder uiBinder = GWT
			.create(MainViewImplUiBinder.class);

	interface MainViewImplUiBinder extends UiBinder<Widget, MainViewImpl> {
	}
	
	@UiField JQMContent main;
	@UiField SimplePanel primary;
	@UiField SimplePanel secondary;
	
	@Inject
	public MainViewImpl(MenuActivityMapper menuActivityMapper,
			MainActivityMapper mainActivityMapper, EventBus eventBus) {
		initWidget(uiBinder.createAndBindUi(this));
		
		ActivityManager menuActivityManager = new ActivityManager(menuActivityMapper, eventBus);
	    menuActivityManager.setDisplay(secondary);
	    
	    ActivityManager mainActivityManager = new ActivityManager(mainActivityMapper, eventBus);
	    mainActivityManager.setDisplay(primary);
	}

}
