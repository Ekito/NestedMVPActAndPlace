package org.ekito.gwt.client;

import org.ekito.gwt.client.activity.mapper.ApplicationPlaceHistoryMapper;
import org.ekito.gwt.client.activity.place.LoginPlace;
import org.ekito.gwt.client.gin.ApplicationGinjector;
import org.ekito.gwt.client.view.MainPanel;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;





/**
 *  this class is the entry point of the application
 * @author dimitri valax @www.ekito.fr
 *
 */
public class NestedMVPActAndPlaceProject implements EntryPoint {
	
	/**
	 * Application injector
	 */
	private static ApplicationGinjector injector = GWT.create(ApplicationGinjector.class); 

	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		ClientFactory clientFactory = injector.getClientFactory();
		MainPanel mainPanel = clientFactory.getMainPanel();
		// build the main view
		mainPanel.buildMainView();
		
		// create default place
		LoginPlace loginPlace = new LoginPlace();
		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		ApplicationPlaceHistoryMapper historyMapper = GWT.create(ApplicationPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		// set the default place
		historyHandler.register(clientFactory.getPlaceController(), clientFactory.getEventBus(), loginPlace);
		
		RootLayoutPanel.get().add(mainPanel);
		
		// Goes to the represented on url or the default place
		historyHandler.handleCurrentHistory();
		
		}
}
