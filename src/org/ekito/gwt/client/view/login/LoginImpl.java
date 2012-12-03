package org.ekito.gwt.client.view.login;

import org.ekito.gwt.client.UIConst;
import org.ekito.gwt.client.activity.LoginActivity;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * this is the login page
 * @author dimitri valax @www.ekito.fr
 *
 */
public class LoginImpl extends SimplePanel implements Login {
	
	private LoginActivity presenter;

	private Button goToMain = GWT.create(Button.class);

	public LoginImpl() {
		super();
		setVisible(false);
		goToMain.setText("goToMain");
		final VerticalPanel panel = GWT.create(VerticalPanel.class);
		panel.setHorizontalAlignment(HasAlignment.ALIGN_CENTER);
		panel.setVerticalAlignment(HasAlignment.ALIGN_MIDDLE);
		panel.add(goToMain);
		goToMain.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				presenter.goToMain();
			}
		});
		Window.addResizeHandler(new ResizeHandler() {

		     public void onResize(ResizeEvent event) {
		       int height = event.getHeight();
		       panel.setSize("100%", height - UIConst.BANNER_HEIGHT + "px");
		     }
		   });
		panel.setSize("100%", Window.getClientHeight() - UIConst.BANNER_HEIGHT	 + "px");
		panel.setBorderWidth(1);
		add(panel);
	}

	@Override
	public void setPrensenter(final LoginActivity presenter) {
		 
		this.presenter = presenter;
	}

	@Override
	public Widget asWidget() {
		return this;
	}

}
