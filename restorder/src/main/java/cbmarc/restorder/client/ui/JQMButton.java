/**
 * 
 */
package cbmarc.restorder.client.ui;

import com.google.gwt.user.client.ui.Anchor;

/**
 * JQMButton class
 * 
 * @author marc
 *
 */
public class JQMButton extends Anchor {
	
	public JQMButton() {
		setAttribute("data-role", "button");
	}
	
	public void setDatainline(String datainline) {
		setAttribute("data-inline", datainline);
	}
	
	public void setDataicon(String dataicon) {
		setAttribute("data-icon", dataicon);
	}
	
	public void setDataiconpos(String dataiconpos) {
		setAttribute("data-iconpos", dataiconpos);
	}
	
	public void setDatatheme(String datatheme) {
		setAttribute("data-theme", datatheme);
	}
	
	private void setAttribute(String attribute, String value) {
		getElement().setAttribute(attribute, value);
	}

}
