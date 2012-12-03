package org.ekito.gwt.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class ChangeContentEvent extends GwtEvent<ChangeContentEventHandler> {
	  public static Type<ChangeContentEventHandler> TYPE = new Type<ChangeContentEventHandler>();
	  
	  @Override
	  public Type<ChangeContentEventHandler> getAssociatedType() {
	    return TYPE;
	  }

	  @Override
	  protected void dispatch(ChangeContentEventHandler handler) {
	    handler.onChangeContent(this);
	  }
	}
