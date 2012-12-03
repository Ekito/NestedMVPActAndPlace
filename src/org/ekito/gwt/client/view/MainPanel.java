package org.ekito.gwt.client.view;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * this class stand for the nested view. it includes the banner, the login, the left menu and the main content views.
 * it construct the nested view and initialize each ActivityMapper & ActivityManager. It also override the setWidget method in order to place component and manage their visibility.
 * @author dimitri valax @www.ekito.fr
 *
 */
public interface MainPanel extends IsWidget{

	/**
	 * Contruct the main view with the banner, the login, the left menu and center content views.
	 */
	void buildMainView();

}
