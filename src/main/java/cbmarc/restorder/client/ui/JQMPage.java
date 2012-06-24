/**
 * 
 */
package cbmarc.restorder.client.ui;

import cbmarc.restorder.client.utils.JQMUtils;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * JQMPage class
 * 
 * @author marc
 *
 */
public class JQMPage extends HTMLPanel {
	
	public JQMPage() {
		this("");
	}
	
	public JQMPage(String html) {
		super(html);

		getElement().setId(DOM.createUniqueId());
		getElement().setAttribute("data-role", "page");
	}
	
	public void setDatarole(String datarole) {
		getElement().setAttribute("data-role", datarole);
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.Widget#onAttach()
	 */
	@Override
	protected void onAttach() {
		super.onAttach();
		JQMUtils.page(getElement().getId());
		
	}

}
