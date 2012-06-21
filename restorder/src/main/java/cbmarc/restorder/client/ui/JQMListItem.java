/**
 * 
 */
package cbmarc.restorder.client.ui;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Image;

/**
 * @author marc
 *
 */
public class JQMListItem extends ComplexPanel {
	
	private JQMList list;
	private Anchor leftAnchor;
	
	public JQMListItem(String text) {
		setElement(Document.get().createLIElement());
		
		Element h3 = Document.get().createHElement(3);
		h3.setInnerText(text);
		
		getElement().appendChild(h3);
	}
	
	public JQMListItem(String text, Anchor leftAnchor) {
		setElement(Document.get().createLIElement());
		this.leftAnchor = leftAnchor;
		
		Element h3 = Document.get().createHElement(3);
		h3.setInnerText(text);
		
		leftAnchor.getElement().appendChild(h3);
		leftAnchor.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				onLeftAnchorClick();
				
			}});
		
		add(leftAnchor, getElement());
	}
	
	public JQMListItem(String text, Anchor leftAnchor, Anchor rightAnchor) {
		this(text, leftAnchor);
		
		rightAnchor.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				onRightAnchorClick();
				
			}});
		
		add(rightAnchor, getElement());
	}

	public void setImage(Image image) {
		Element element = getElement();
		
		if(leftAnchor != null)
			element = leftAnchor.getElement();

		element.appendChild(image.getElement());
		
	}
	
	public void onLeftAnchorClick() {
		list.onLeftAnchorClick(this);
	}
	
	public void onRightAnchorClick() {
		list.onRightAnchorClick(this);
	}
	
	public void setList(JQMList list) {
		this.list = list;
	}
	
	public void setDescription(String d) {
		Element element = getElement();
		
		Element p = Document.get().createPElement();
		p.setInnerText(d);
		
		if(leftAnchor != null)
			element = leftAnchor.getElement();
		
		element.appendChild(p);
		
	}
	
	public void setCount(Integer count) {
		Element s = Document.get().createSpanElement();
		s.setClassName("ui-li-count");
		s.setInnerText(count.toString());
		
		getElement().appendChild(s);
	}

}
