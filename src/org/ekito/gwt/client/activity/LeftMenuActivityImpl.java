package org.ekito.gwt.client.activity;

import org.ekito.gwt.client.ClientFactory;
import org.ekito.gwt.client.activity.place.LoginPlace;
import org.ekito.gwt.client.activity.place.MainPlace;
import org.ekito.gwt.client.view.leftmenu.LeftMenu;
import org.ekito.gwt.client.view.maincontent.CenterContent;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class LeftMenuActivityImpl extends AbstractActivity implements
		LeftMenuActivity {

	LeftMenu leftMenu;
	
	CenterContent centerContent;

	/*
	 * the client factory
	 */
	ClientFactory clientFactory;

	@Inject
	public LeftMenuActivityImpl(final LeftMenu leftMenu, final CenterContent centerContent,
			final ClientFactory clientFactory) {
		this.leftMenu = leftMenu;
		this.centerContent = centerContent;
		this.clientFactory = clientFactory;
		this.leftMenu.setPrensenter(this);
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		// set the center content visible
		panel.setWidget(leftMenu.asWidget());
		// update the plusOne number
		MainPlace here = (MainPlace) clientFactory.getPlaceController().getWhere();
		centerContent.setText(here.getPlusOne());
	}

	@Override
	public void goToLogin() {
		clientFactory.getPlaceController().goTo(new LoginPlace());

	}
	
	@Override
	public void goToPlusOne() {
		MainPlace there = new MainPlace();
		MainPlace here = (MainPlace) clientFactory.getPlaceController().getWhere();
		there.setPlusOne(here.getPlusOne() + 1);
		clientFactory.getPlaceController().goTo(there);

	}

}
