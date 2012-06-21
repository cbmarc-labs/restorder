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
public class JQMContent extends HTMLPanel {
	
	public JQMContent() {
		this("");
	}
	
	public JQMContent(String html) {		
		super(html);

		getElement().setId(DOM.createUniqueId());
		getElement().setAttribute("data-role", "content");
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.Widget#onAttach()
	 */
	@Override
	protected void onAttach() {
		super.onAttach();
		JQMUtils.triggerCreate(getElement().getId());
	}

}
