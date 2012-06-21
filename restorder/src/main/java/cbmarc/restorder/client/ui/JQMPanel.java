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
public class JQMPanel extends HTMLPanel {
		
	public JQMPanel(String html) {		
		super(html);

		getElement().setId(DOM.createUniqueId());
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
