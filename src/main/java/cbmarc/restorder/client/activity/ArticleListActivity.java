/**
 * 
 */
package cbmarc.restorder.client.activity;

import java.util.List;

import cbmarc.restorder.client.event.JQMListSplitEvent;
import cbmarc.restorder.client.place.ArticleEditPlace;
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
import com.google.gwt.user.client.Window;
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
		
		bind();
		
	}
	
	private void bind() {
		view.getList().addClickHandler(new JQMListSplitEvent.Handler() {
			
			@Override
			public void onRightSideClick(JQMListSplitEvent event, int index) {
				doDelete((Article) articles.get(index));
				
			}
			
			@Override
			public void onLeftSideClick(JQMListSplitEvent event, int index) {
				doEdit((Article) articles.get(index));
				
			}
		});
	}
	
	public void doEdit(Article article) {
		goTo(new ArticleEditPlace(Long.toString(article.getId())));
	}
	
	public void doDelete(Article article) {
		JQMUtils.showPageLoading();
		articleService.delete(article, new AppAsyncCallback<Void>(){

			@Override
			public void onSuccess(Void result) {
				doLoad();
				
				JQMUtils.popup("Elemento eliminado.");
				
			}});
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		panel.setWidget(view.asWidget());
		
		doLoad();
		
	}
	
	public void doLoad() {
		JQMUtils.showPageLoading();
		
		Article article = null;
		
		articleService.getAll(article,
				new AppAsyncCallback<List<Model>>(){

			public void onSuccess(List<Model> result) {
				articles = result;
				setData(result);
				
				JQMUtils.hidePageLoading();
				
			}});
	}
	
	public void setData(List<Model> articles) {
		view.getList().clear();
		
		for (Model article:articles) {
			Article a = (Article) article;
			
			Anchor edit = new Anchor();
			Anchor delete = new Anchor();
			
			JQMListItem item = new JQMListItem(a.getName(), edit, delete);
			item.setDescription(a.getDescription());
			
			Image image = new Image("img/" + a.getImage());
			item.setImage(image);
						
			view.getList().add(item);
		}
		
		view.getList().refresh();
	}

	@Override
	public void goTo(Place place) {
		placeController.goTo(place);
		
	}

}
