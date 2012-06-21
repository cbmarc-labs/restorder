/**
 * 
 */
package cbmarc.restorder.client.view;

import cbmarc.restorder.client.ui.JQMCollapsible;
import cbmarc.restorder.shared.model.Article;

import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.ui.client.adapters.ValueBoxEditor;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * @author marc
 *
 */
public interface ArticleEditView extends IsView, Editor<Article> {
	
	@Path("name")
	IsEditor<ValueBoxEditor<String>> getName();
	
	@Path("description")
	IsEditor<ValueBoxEditor<String>> getDescription();
	
	@Path("folder")
	LeafValueEditor<Boolean> getFolder();
	
	@Path("image")
	LeafValueEditor<String> getImage();
	
	void setImageUrl(String img);
	
	JQMCollapsible getCollapsible();
	HTMLPanel getCollapsibleContent();
	
	void setPresenter(Presenter presenter);
	
	public interface Presenter {
		void doSave();
		void goTo(Place place);
	}
}
