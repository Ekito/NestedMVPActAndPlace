package org.ekito.gwt.client.view.maincontent;

import org.ekito.gwt.client.UIConst;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * this is the class of the center content. For our example, it contains only a text which change when the user clich on the "+1" button.
 * 
 * @author dimitri valax @www.ekito.fr
 *
 */
public class CenterContentImpl extends ScrollPanel implements CenterContent {

	private Button goToLogin = GWT.create(Button.class);
	
	private HTML text = new HTML("Center Content " );

	@Inject
	public CenterContentImpl() {
		super();
		// by default the center content will be not visible, it will be when the activity will call the setwidget method.
		setVisible(false);
		final VerticalPanel panel = GWT.create(VerticalPanel.class);
		panel.setHorizontalAlignment(HasAlignment.ALIGN_CENTER);
		panel.setVerticalAlignment(HasAlignment.ALIGN_MIDDLE);
		goToLogin.setText("goToLogin");
		panel.add(text);
		Window.addResizeHandler(new ResizeHandler() {

		     public void onResize(ResizeEvent event) {
		       int height = event.getHeight();
		       panel.setSize("100%", height - UIConst.BANNER_HEIGHT + "px");
		     }
		   });
		panel.setSize("100%", Window.getClientHeight() - UIConst.BANNER_HEIGHT + "px");
		panel.setBorderWidth(1);
		add(panel);
	}

	@Override
	public Widget asWidget() {
		return this;
	}

	@Override
	public void setText(int nb) {
		text.setText(" +" + nb);
	}
	
	

}
