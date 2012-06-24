/**
 * 
 */
package cbmarc.restorder.client.activity;

import java.util.List;

import cbmarc.restorder.client.place.ArticleEditPlace;
import cbmarc.restorder.client.rpc.AppAsyncCallback;
import cbmarc.restorder.client.rpc.CrudService;
import cbmarc.restorder.client.rpc.CrudServiceAsync;
import cbmarc.restorder.client.rpc.ImageService;
import cbmarc.restorder.client.rpc.ImageServiceAsync;
import cbmarc.restorder.client.utils.JQMUtils;
import cbmarc.restorder.client.view.ArticleEditView;
import cbmarc.restorder.shared.model.Article;
import cbmarc.restorder.shared.model.Model;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.inject.Inject;

/**
 * @author marc
 *
 */
public class ArticleEditActivity extends AbstractActivity 
		implements ArticleEditView.Presenter {
	
	interface EditorDriver extends SimpleBeanEditorDriver<Article, ArticleEditView> {}

	private final EditorDriver editor;
	private ArticleEditView view;
	private PlaceController placeController;
	
	private final CrudServiceAsync crudService = GWT.create(CrudService.class);
	private final ImageServiceAsync imageService = GWT.create(ImageService.class);
	
	private Article article;
	
	@Inject
	public ArticleEditActivity(ArticleEditView view, PlaceController placeController) {
		this.view = view;
		this.placeController = placeController;
		
		editor = GWT.create(EditorDriver.class);
		editor.initialize(view);
		
		view.setPresenter(this);
		
	}
	
	private void populateImageGallery(List<String> result) {
		if(result.isEmpty()) {
			view.getCollapsibleContent().add(new HTML("Empty."));
		} else {
			for(final String img:result) {
				Image image = new Image("img/" + img);
				image.addClickHandler(new ClickHandler(){

					@Override
					public void onClick(ClickEvent event) {
						view.setImageUrl(img);
						
					}});
				
				view.getCollapsibleContent().add(image);
			}
		}
	}
	
	Long getTokenId(int index) {
		Long id = null;
		
		ArticleEditPlace listPlace = (ArticleEditPlace) placeController.getWhere();
		
		String[] ids = listPlace.getToken().split(",");
		try {
			id = Long.parseLong(ids[index]);
		} catch(Exception e) {}
		
		return id;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		ArticleEditPlace listPlace = (ArticleEditPlace) placeController.getWhere();
		String[] ids = listPlace.getToken().split(",", -1);
		Long id = null;
		
		try {
			id = Long.parseLong(ids[ids.length - 1]);
		} catch(Exception e) {}
		
		panel.setWidget(view);
		view.getCollapsible().collapse();
		
		if(id == null) {
			article = new Article();
			article.setImage("blank.jpg");
			
			try {
				id = Long.parseLong(ids[ids.length - 2]);
			} catch(Exception e) {}
			
			article.setParent(id);
			
			editor.edit(article);

		} else {
			doLoad(id);
			
		}
		
	}
	
	public void doLoad(Long id) {
		JQMUtils.showPageLoading();
		
		crudService.get(id, Article.class.getName(), 
				new AppAsyncCallback<Model>(){

			@Override
			public void onSuccess(Model result) {
				article = (Article) result;
				editor.edit(article);
				
				JQMUtils.hidePageLoading();
				
			}});
	}

	@Override
	public void doSave() {
		Article article = editor.flush();
		crudService.saveOrUpdate(article, new AppAsyncCallback<Void>(){

			@Override
			public void onSuccess(Void result) {
				JQMUtils.popup("Elemento guardado.");
				
			}});
		
	}

	@Override
	public void onGalleryExpand() {
		JQMUtils.showPageLoading();
		imageService.getAll(new AppAsyncCallback<List<String>>(){

			@Override
			public void onSuccess(List<String> result) {
				populateImageGallery(result);
				JQMUtils.hidePageLoading();
			}
		});
		
	}

	@Override
	public void onGalleryCollapse() {
		view.getCollapsibleContent().clear();
		
	}

}
