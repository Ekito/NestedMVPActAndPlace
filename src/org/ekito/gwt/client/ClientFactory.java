package org.ekito.gwt.client;

import org.ekito.gwt.client.view.MainPanel;

import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;

/**
 * this class is a factory for things that are very usefull in all view
 * @author dimitri valax @www.ekito.fr
 *
 */
public class ClientFactory {
	
	
	
	private  EventBus eventBus;
	private  PlaceController placeController;
	private  Provider<MainPanel> mainPanelProvider;
	
	@Inject
	public  ClientFactory(final EventBus eventBus, final PlaceController placeController, final Provider<MainPanel> mainPanelProvider){
		this.eventBus = eventBus;
		this.placeController = placeController;
		this.mainPanelProvider = mainPanelProvider;
	}


	public EventBus getEventBus() {
		return eventBus;
	}


	public PlaceController getPlaceController() {
		return placeController;
	}


	public MainPanel getMainPanel() {
		return mainPanelProvider.get();
	}


	

}
