package org.ekito.gwt.client.activity.place;

import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;


/**
 * The injectable PlaceController to be able to inject the eventbus into
 * @author dimitri
 *
 */
public class InjectablePlaceController extends PlaceController {

	@Inject
	public InjectablePlaceController(EventBus eventBus) {
		super(eventBus);
	}

}
