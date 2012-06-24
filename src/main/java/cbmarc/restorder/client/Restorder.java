package cbmarc.restorder.client;

import cbmarc.restorder.client.utils.JQMUtils;
import cbmarc.restorder.client.event.JQMChangePageEvent;
import cbmarc.restorder.client.view.MainView;
import cbmarc.restorder.client.view.impl.ListDialogViewImpl;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

public class Restorder implements EntryPoint {
	
	public static String MAINPAGE;
	public static String LISTDIALOGPAGE;
	
	MainView main;
	ListDialogViewImpl dialog;
	
	@Override
	public void onModuleLoad() {
		AppGinjector ginjector = GWT.create(AppGinjector.class);
		
		main = ginjector.getMainView();
		dialog = ginjector.getListDialogView();
		
		RootPanel.get().add(main);
		RootPanel.get().add(dialog);
		
		MAINPAGE = main.getId();
		LISTDIALOGPAGE = dialog.getId();
		
		JQMUtils.changePage(Restorder.MAINPAGE);
		
		ginjector.getPlaceHistoryHandler().handleCurrentHistory();
	  
	}
	
}
