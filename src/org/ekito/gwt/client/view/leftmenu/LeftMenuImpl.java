package org.ekito.gwt.client.view.leftmenu;

import org.ekito.gwt.client.UIConst;
import org.ekito.gwt.client.activity.LeftMenuActivity;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * this is the left menu page.
 * 
 * @author dimitri valax @www.ekito.fr
 *
 */
public class LeftMenuImpl extends ScrollPanel implements LeftMenu{
	
	private Button goToLogin = GWT.create(Button.class);
	
	private Button changeContent = GWT.create(Button.class);

	private LeftMenuActivity presenter;
	
	private final VerticalPanel vp = new VerticalPanel();
	
	/**
	 * the constructor
	 */
	public LeftMenuImpl() {
		super();
		setVisible(false);
		VerticalPanel menu = GWT.create(VerticalPanel.class);
		menu.setHorizontalAlignment(HasAlignment.ALIGN_CENTER);
		menu.setSize("100%", "100%");
		menu.add(new HTML("Left menu"));
		goToLogin.setText("goToLogin");
		menu.add(goToLogin);

		goToLogin.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				presenter.goToLogin();

			}
		});
		changeContent.setText("+1");
		menu.add(changeContent);

		changeContent.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				presenter.goToPlusOne();
			}
		});
		Window.addResizeHandler(new ResizeHandler() {

		     public void onResize(ResizeEvent event) {
		       int height = event.getHeight();
		       vp.setSize("8em", height - UIConst.BANNER_HEIGHT + "px");
		     }
		   });
		vp.setSize("8em", Window.getClientHeight() - UIConst.BANNER_HEIGHT + "px");
		vp.setBorderWidth(1);
		vp.add(menu);
		add(vp);
	}
	
	@Override
	public void setPrensenter(final LeftMenuActivity presenter) {
		this.presenter = presenter;

	}

	@Override
	public Widget asWidget() {
		return this;
	}

}
