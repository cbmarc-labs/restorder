/**
 * 
 */
package cbmarc.restorder.client.activity;

import java.util.List;

import cbmarc.restorder.client.Restorder;
import cbmarc.restorder.client.place.ArticleEditPlace;
import cbmarc.restorder.client.place.ArticleListPlace;
import cbmarc.restorder.client.rpc.AppAsyncCallback;
import cbmarc.restorder.client.rpc.ArticleService;
import cbmarc.restorder.client.rpc.ArticleServiceAsync;
import cbmarc.restorder.client.ui.JQMListItem;
import cbmarc.restorder.client.utils.JQMUtils;
import cbmarc.restorder.client.view.ArticleListView;
import cbmarc.restorder.shared.model.Article;
import cbmarc.restorder.shared.model.Model;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Image;
import com.google.inject.Inject;

/**
 * @author marc
 *
 */
public class ArticleListActivity extends AbstractActivity 
		implements ArticleListView.Presenter {
	
	private ArticleListView view;
	private PlaceController placeController;
	
	private List<Model> articles;
	
	private final ArticleServiceAsync articleService = 
			GWT.create(ArticleService.class);
	
	@Inject
	public ArticleListActivity(ArticleListView view,
			PlaceController placeController) {
		this.view = view;
		this.placeController = placeController;
		
		view.setPresenter(this);
		
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		panel.setWidget(view.asWidget());
		
		doLoad();
		
	}
	
	public void doLoad() {
		ArticleListPlace listPlace = (ArticleListPlace) placeController.getWhere();
		Long current = null;
		JQMUtils.showPageLoading();
		
		String[] ids = listPlace.getToken().split(",");
		try {
			current = Long.parseLong(ids[ids.length-1]);
		} catch(Exception e) {}
		
		view.getList().clear();
		
		articleService.getAll(current, 
				new AppAsyncCallback<List<Model>>(){

			public void onSuccess(List<Model> result) {
				articles = result;
				setData(result);
				
				JQMUtils.hidePageLoading();
				
			}});
	}
	
	Long getTokenId(int index) {
		Long id = null;
		
		ArticleListPlace listPlace = (ArticleListPlace) placeController.getWhere();
		
		String[] ids = listPlace.getToken().split(",");
		try {
			id = Long.parseLong(ids[index]);
		} catch(Exception e) {}
		
		return id;
	}
	
	public void setData(List<Model> articles) {
		JQMListItem item;
		Anchor rightAnchor;
		String parent = ".";
		
		if(getTokenId(1) != null)
			parent = "..";
		
		rightAnchor = new Anchor();
		rightAnchor.getElement().setAttribute("data-icon", "gear");
		rightAnchor.getElement().setAttribute("data-theme", "c");
		
		item = new JQMListItem(parent, new Anchor(), rightAnchor);
		item.setImage(new Image("img/folder.jpg"));
		view.getList().add(item);
		
		for (Model model:articles) {
			Article article = (Article) model;
			
			if(article.getFolder()) {
				rightAnchor = new Anchor();
				rightAnchor.getElement().setAttribute("data-icon", "gear");
				rightAnchor.getElement().setAttribute("data-theme", "c");
				
				item = new JQMListItem(article.getName(), new Anchor(), rightAnchor);
			} else {
				item = new JQMListItem(article.getName(), new Anchor());
			}
			
			item.setDescription(article.getDescription());
			
			Image image = new Image("img/" + article.getImage());
			item.setImage(image);
						
			view.getList().add(item);
		}
		
		view.getList().refresh();
	}

	@Override
	public void goTo(Place place) {
		placeController.goTo(place);
		
	}

	@Override
	public void onListLeftClick(int index) {
		ArticleListPlace listPlace = (ArticleListPlace) placeController.getWhere();
		
		String current = "";
		
		if(index == 0) {
			int i = listPlace.getToken().lastIndexOf(",");
			if(i > -1)
				current = listPlace.getToken().substring(0, i);
			
			goTo(new ArticleListPlace(current));
			
		} else {
			Article article = (Article) articles.get(index-1);
			
			try {
				current = Long.toString(article.getId());
			} catch(Exception e) {}
			
			if(article.getFolder()) {
				goTo(new ArticleListPlace(listPlace.getToken() + "," + current));
			} else {
				goTo(new ArticleEditPlace(listPlace.getToken() + "," + current));
			}
		}
		
	}

	@Override
	public void onListRightClick(int index) {
		ArticleListPlace listPlace = (ArticleListPlace) placeController.getWhere();
		
		if(index == 0) {
			JQMUtils.changePage(Restorder.LISTDIALOGPAGE);
			
		} else {
			Article article = (Article) articles.get(index-1);
			
			if(article.getFolder()) {
				String current = "";
				
				try {
					current = Long.toString(article.getId());
				} catch(Exception e) {}
				
				goTo(new ArticleEditPlace(listPlace.getToken() + "," + current));
				
			}
		}
		
		/*else {
			JQMUtils.showPageLoading();
			articleService.delete(article, new AppAsyncCallback<Void>(){

				@Override
				public void onSuccess(Void result) {
					doLoad();
				
					JQMUtils.popup("Elemento eliminado.");
				
				}});
		}*/
	}

	@Override
	public void doNew() {
		ArticleListPlace listPlace = (ArticleListPlace) placeController.getWhere();
		
		goTo(new ArticleEditPlace(listPlace.getToken() + ","));
		
	}

}
