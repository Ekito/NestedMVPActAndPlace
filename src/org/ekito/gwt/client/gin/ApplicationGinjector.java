package org.ekito.gwt.client.gin;

import org.ekito.gwt.client.ClientFactory;
import org.ekito.gwt.client.view.MainPanel;

import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;

@GinModules(ApplicationGinModule.class)
public interface ApplicationGinjector extends Ginjector {

	ClientFactory getClientFactory();

}
