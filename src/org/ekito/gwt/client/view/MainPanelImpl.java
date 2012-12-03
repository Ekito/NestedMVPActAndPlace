package org.ekito.gwt.client.view;

import org.ekito.gwt.client.ClientFactory;
import org.ekito.gwt.client.activity.mapper.LeftMenuActivityMapper;
import org.ekito.gwt.client.activity.mapper.LoginActivityMapper;
import org.ekito.gwt.client.view.banner.Banner;
import org.ekito.gwt.client.view.leftmenu.LeftMenu;
import org.ekito.gwt.client.view.login.Login;
import org.ekito.gwt.client.view.maincontent.CenterContent;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;


/**
 * this class stand for the nested view. it includes the banner, the login, the left menu and the main content views.
 * it construct the nested view and initialize each ActivityMapper & ActivityManager. It also override the setWidget method in order to place component and manage their visibility.
 * @author dimitri valax @www.ekito.fr
 *
 */
public class MainPanelImpl implements MainPanel {

	/*
	 * the application container
	 */
	private LayoutPanel appContainer = GWT.create(LayoutPanel.class);

	/*
	 * different part which compose the main panel
	 */
	private CenterContent centerContent;
	private LeftMenu leftMenu;
	private Banner banner;
	private Login login;

	/*
	 * the client factory
	 */
	private ClientFactory clientFactory;

	@Inject
	public MainPanelImpl(final ClientFactory clientFactory ,
			final CenterContent centerContent, final LeftMenu leftMenu,
			final Banner banner, final Login login) {
		this.centerContent = centerContent;
		this.leftMenu = leftMenu;
		this.banner = banner;
		this.login = login;
		this.clientFactory = clientFactory;
	}

	
	/**
	 * set the visibility of the login display
	 */
	private AcceptsOneWidget loginDisplay = new AcceptsOneWidget() {

		@Override
		public void setWidget(IsWidget w) {
			Widget widget = Widget.asWidgetOrNull(w);
			appContainer.setWidgetVisible(login.asWidget(), widget != null);
			if (widget != null) {
				appContainer.setWidgetTopHeight(login.asWidget(), 8, Unit.EM,
						70, Unit.EM);
			}
		}
	};

	/**
	 * set the visibility of the main content display
	 */
	private AcceptsOneWidget mainDisplay = new AcceptsOneWidget() {

		@Override
		public void setWidget(IsWidget w) {
			Widget widget = Widget.asWidgetOrNull(w);
			appContainer.setWidgetVisible(centerContent.asWidget(),
					widget != null);
			appContainer.setWidgetVisible(leftMenu.asWidget(), widget != null);
			appContainer.setWidgetVisible(login.asWidget(), widget == null);
			if (widget != null) {
				appContainer.setWidgetTopHeight(leftMenu.asWidget(), 8,
						Unit.EM, 70, Unit.EM);
				appContainer.setWidgetLeftRight(leftMenu.asWidget(), 0,
						Unit.EM, 8, Unit.EM);
				appContainer.setWidgetTopHeight(centerContent.asWidget(), 8,
						Unit.EM, 70, Unit.EM);
				appContainer.setWidgetLeftRight(centerContent.asWidget(), 8,
						Unit.EM, 0, Unit.EM);
				appContainer.setWidgetTopHeight(centerContent.asWidget(), 8, Unit.EM, 70, Unit.EM);
			}
		}
	};

	@Override
	public void buildMainView() {
		// Build the view
		// add the banner
		appContainer.add(banner);
		appContainer.setWidgetTopHeight(banner.asWidget(), 0, Unit.EM, 8,
				Unit.EM);
		// add the left menu
		appContainer.add(leftMenu);

		// add the center content
		appContainer.add(centerContent);

		// add the login page
		appContainer.add(login);

		// initialize the activity mapper
		initializeActivityMapper();
	}


	/**
	 *  initialize ActivityMapper & ActivityManager for each display.
	 */
	private void initializeActivityMapper() {
		// create the left menu activity mapper
		ActivityMapper leftMenuActivityMapper = new LeftMenuActivityMapper(
				leftMenu, centerContent, clientFactory);
		ActivityManager leftMenuActivityManager = new ActivityManager(
				leftMenuActivityMapper, clientFactory.getEventBus());
		leftMenuActivityManager.setDisplay(mainDisplay);

		// create the login activity mapper
		ActivityMapper loginActivityMapper = new LoginActivityMapper(login,
				clientFactory);
		ActivityManager loginActivityManager = new ActivityManager(
				loginActivityMapper, clientFactory.getEventBus());
		loginActivityManager.setDisplay(loginDisplay);
	}
	

	@Override
	public Widget asWidget() {
		return appContainer.asWidget();
	}

}
