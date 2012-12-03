package org.ekito.gwt.client.activity.mapper;

import org.ekito.gwt.client.ClientFactory;
import org.ekito.gwt.client.activity.LoginActivityImpl;
import org.ekito.gwt.client.activity.place.LoginPlace;
import org.ekito.gwt.client.view.login.Login;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;

public class LoginActivityMapper implements ActivityMapper {
	
	private Login login;
	
	private ClientFactory clientFactory;
	
	@Inject
	public LoginActivityMapper(final Login login, final ClientFactory clientFactory) {
		this.login = login;
		this.clientFactory = clientFactory;
	}
	

	public Activity getActivity(Place place) {
		if (place instanceof LoginPlace) {
			return new LoginActivityImpl(login, clientFactory);
		}
		return null;
	}

}
