package cbmarc.restorder.client.view.impl;

import cbmarc.restorder.client.Restorder;
import cbmarc.restorder.client.place.ArticleEditPlace;
import cbmarc.restorder.client.utils.JQMUtils;
import cbmarc.restorder.client.view.IsView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ListDialogViewImpl extends Composite implements IsView {

	private static ListDialogUiBinder uiBinder = GWT
			.create(ListDialogUiBinder.class);

	interface ListDialogUiBinder extends UiBinder<Widget, ListDialogViewImpl> {}

	private PlaceController placeController;	
	
	@Inject
	public ListDialogViewImpl(PlaceController placeController) {
		initWidget(uiBinder.createAndBindUi(this));
		this.placeController = placeController;
		
	}
	
	public String getId() {
		return getElement().getId();
	}

	@UiHandler("newFolderButton")
	void newFolderButtonClick(ClickEvent e) {
		JQMUtils.changePage(Restorder.MAINPAGE);
		placeController.goTo(new ArticleEditPlace(""));
	}
	
	@UiHandler("newArticleButton")
	void newArticleButtonClick(ClickEvent e) {
		JQMUtils.changePage(Restorder.MAINPAGE);
		placeController.goTo(new ArticleEditPlace(""));
	}
	
	@UiHandler("cancelButton")
	void cancelButtonClick(ClickEvent e) {
		JQMUtils.changePage("gwt-uid-3");
	}

}
