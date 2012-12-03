package org.ekito.gwt.client.activity.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class LoginPlace extends Place {

	String placeName = "login";

	@Prefix("login")
	public static class Tokenizer implements PlaceTokenizer<LoginPlace> {

		@Override
		public LoginPlace getPlace(String token) {
			LoginPlace loginPlace = new LoginPlace();
			loginPlace.setPlaceName(token);
			return loginPlace;
		}

		@Override
		public String getToken(LoginPlace place) {
			return place.getPlaceName();
		}

	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

}
