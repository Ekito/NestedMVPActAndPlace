package org.ekito.gwt.client.activity.place;

import org.ekito.gwt.client.UIConst;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class MainPlace extends Place {

	String placeName = "mainPlace";

	int plusOne = 0;

	@Prefix("main")
	public static class Tokenizer implements PlaceTokenizer<MainPlace> {

		@Override
		public MainPlace getPlace(String token) {
			MainPlace mainPlace = new MainPlace();
			mainPlace.setPlaceName(token);	
			return mainPlace;
		}

		@Override
		public String getToken(MainPlace place) {
			return place.getPlaceName();
		}

	}

	public String getPlaceName() {
		String plusOne = UIConst.PLUS_ONE + this.getPlusOne();
		return placeName + plusOne;
	}

	public void setPlaceName(String placeName) {
		String plusOne =  placeName.substring(placeName.indexOf(UIConst.PLUS_ONE) + UIConst.PLUS_ONE.length(), placeName.length());
		this.plusOne = Integer.valueOf(plusOne);
	}

	public int getPlusOne() {
		return plusOne;
	}

	public void setPlusOne(int plusOne) {
		this.plusOne = plusOne;
	}

}
