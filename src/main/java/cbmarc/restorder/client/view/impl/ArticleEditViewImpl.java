/**
 * 
 */
package cbmarc.restorder.client.view.impl;

import cbmarc.restorder.client.ui.JQMButton;
import cbmarc.restorder.client.ui.JQMCollapsible;
import cbmarc.restorder.client.view.ArticleEditView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SelectElement;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.ui.client.adapters.ValueBoxEditor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;

/**
 * @author marc
 *
 */
@Singleton
public class ArticleEditViewImpl extends Composite implements ArticleEditView {
	
	private static EditProductViewImplUiBinder uiBinder = GWT
			.create(EditProductViewImplUiBinder.class);
	
	interface EditProductViewImplUiBinder extends
			UiBinder<Widget, ArticleEditViewImpl> {}
		
	@UiField TextBox nameField, descriptionField;
	@UiField SelectElement folderField;
	@UiField Image imageField;
	
	@UiField JQMButton saveButton;
	
	@UiField JQMCollapsible imageGallery;
	@UiField HTMLPanel imageGalleryContent;
	
	LeafValueEditor<Boolean> folder = new LeafValueEditor<Boolean>() {

		@Override
		public void setValue(Boolean value) {
			int selected = 0;
			
			if(value != null)
				if(value) selected = 1;
			
			folderField.setSelectedIndex(selected);
			
		}

		@Override
		public Boolean getValue() {
			Boolean b = false;
			
			if(folderField.getSelectedIndex() == 1)
				b = true;
			
			return b;
		}
		
	};
	
	LeafValueEditor<String> image = new LeafValueEditor<String>(){

		@Override
		public void setValue(String value) {
			imageField.setUrl("img/" + value);
			
		}

		@Override
		public String getValue() {
			return "nasasdasdull";
		}};
	
	private Presenter presenter;
	
	public ArticleEditViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiHandler("nameField")
	public void onFocus(FocusEvent event) {
		nameField.selectAll();
	}
	
	public void focus() {
		nameField.setFocus(true);
	}
	
	public void reset() {
		// TODO
	}

	@Override
	public IsEditor<ValueBoxEditor<String>> getName() {
		return nameField;
	}

	@Override
	public IsEditor<ValueBoxEditor<String>> getDescription() {
		return descriptionField;
	}

	@Override
	public LeafValueEditor<String> getImage() {
		return image;
	}

	@UiHandler("saveButton")
	void handleClick(ClickEvent e) {
		presenter.doSave();
	}

	@Override
	public JQMCollapsible getCollapsible() {
		return imageGallery;
	}

	@Override
	public HTMLPanel getCollapsibleContent() {
		return imageGalleryContent;
	}

	@Override
	public LeafValueEditor<Boolean> getFolder() {
		return folder;
	}
	
	public void setFolder(Boolean b) {
		
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
		
	}
	
	@Override
	protected void onAttach() {
		super.onAttach();
		focus();
	}

	@Override
	public void setImageUrl(String img) {
		imageField.setUrl("img/" + img);
		
	}

}
