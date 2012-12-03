package org.ekito.gwt.client.gin;

import org.ekito.gwt.client.activity.place.InjectablePlaceController;
import org.ekito.gwt.client.view.MainPanel;
import org.ekito.gwt.client.view.MainPanelImpl;
import org.ekito.gwt.client.view.banner.Banner;
import org.ekito.gwt.client.view.banner.BannerImpl;
import org.ekito.gwt.client.view.leftmenu.LeftMenu;
import org.ekito.gwt.client.view.leftmenu.LeftMenuImpl;
import org.ekito.gwt.client.view.login.Login;
import org.ekito.gwt.client.view.login.LoginImpl;
import org.ekito.gwt.client.view.maincontent.CenterContent;
import org.ekito.gwt.client.view.maincontent.CenterContentImpl;

import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Singleton;

/**
 * Declaration GIN binding.
 * @author dimitri valax @www.ekito.fr
 *
 */
public class ApplicationGinModule extends AbstractGinModule {

	@Override
	protected void configure() {

		// bind the EventBus
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
		// bind place controller
		bind(PlaceController.class).to(InjectablePlaceController.class).in(
				Singleton.class);

		// bind MainPanel
		bind(MainPanel.class).to(MainPanelImpl.class).in(Singleton.class);

		// bind the views
		bind(CenterContent.class).to(CenterContentImpl.class).in(
				Singleton.class);
		bind(LeftMenu.class).to(LeftMenuImpl.class).in(Singleton.class);
		bind(Banner.class).to(BannerImpl.class).in(Singleton.class);
		bind(Login.class).to(LoginImpl.class).in(Singleton.class);

	}

}
