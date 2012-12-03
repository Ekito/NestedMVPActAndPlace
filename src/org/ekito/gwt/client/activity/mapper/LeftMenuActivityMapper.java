package org.ekito.gwt.client.activity.mapper;

import org.ekito.gwt.client.ClientFactory;
import org.ekito.gwt.client.activity.LeftMenuActivityImpl;
import org.ekito.gwt.client.activity.place.MainPlace;
import org.ekito.gwt.client.view.leftmenu.LeftMenu;
import org.ekito.gwt.client.view.maincontent.CenterContent;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;

public class LeftMenuActivityMapper implements ActivityMapper {

	private LeftMenu leftMenu;
	
	private CenterContent centerContent;
	
	/*
	 * the client factory
	 */
	private ClientFactory clientFactory;

	@Inject
	public LeftMenuActivityMapper(final LeftMenu leftMenu, final CenterContent centerContent, final ClientFactory clientFactory ) {
		this.leftMenu = leftMenu;
		this.centerContent = centerContent;
		this.clientFactory = clientFactory;
	}

	public Activity getActivity(Place place) {
		if (place instanceof MainPlace) {
			return new LeftMenuActivityImpl(leftMenu, centerContent, clientFactory);
		}
		return null;
	}

}
