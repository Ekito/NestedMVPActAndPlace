package org.ekito.gwt.client.activity;

import org.ekito.gwt.client.ClientFactory;
import org.ekito.gwt.client.activity.place.MainPlace;
import org.ekito.gwt.client.view.login.Login;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class LoginActivityImpl  extends AbstractActivity implements  LoginActivity{
	
	Login login;
	
	/*
	 * the client factory
	 */
	ClientFactory clientFactory;
	
	@Inject
	public LoginActivityImpl(final Login login, final ClientFactory clientFactory) {
		this.login = login;
		this.clientFactory = clientFactory;
		this.login.setPrensenter(this);
	}


	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		panel.setWidget(login.asWidget());
	}

	@Override
	public void goToMain() {
		clientFactory.getPlaceController().goTo(new MainPlace());
	}
}
