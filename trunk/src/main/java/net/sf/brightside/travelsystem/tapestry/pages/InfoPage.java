package net.sf.brightside.travelsystem.tapestry.pages;

import org.apache.tapestry5.annotations.Persist;

public class InfoPage {

	@Persist(value = "flash")
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
