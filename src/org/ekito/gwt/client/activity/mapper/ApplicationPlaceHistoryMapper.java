package org.ekito.gwt.client.activity.mapper;

import org.ekito.gwt.client.activity.place.LoginPlace;
import org.ekito.gwt.client.activity.place.MainPlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({LoginPlace.Tokenizer.class, MainPlace.Tokenizer.class})
public interface ApplicationPlaceHistoryMapper extends PlaceHistoryMapper {

}
