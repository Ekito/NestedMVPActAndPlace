package org.ekito.gwt.client.view.banner;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author dimitri 
 * 
 * the banner implementation
 *
 */
public class BannerImpl extends SimplePanel implements Banner {
	
	

	/**
	 * the constructor
	 */
	public BannerImpl() {
		super();
		VerticalPanel panel = GWT.create(VerticalPanel.class);
		panel.setHorizontalAlignment(HasAlignment.ALIGN_CENTER);
		panel.setVerticalAlignment(HasAlignment.ALIGN_MIDDLE);
		panel.add(new HTML("The Banner"));
		panel.setSize("100%", "100%");
		panel.setBorderWidth(1);
		add(panel);
	}

	@Override
	public Widget asWidget() {
		return this;
	}

}
