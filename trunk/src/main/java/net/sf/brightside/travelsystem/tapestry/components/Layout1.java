package net.sf.brightside.travelsystem.tapestry.components;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.annotations.IncludeStylesheet;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.ioc.annotations.Inject;

@IncludeStylesheet("context:resources/travelagencystyle.css")
public class Layout1 {

	@Inject
	@Path("context:resources/header.jpg")
	private Asset header;

	@Parameter(required = true, defaultPrefix = "literal")
	private String pageTitle;

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public Asset getHeader() {
		return header;
	}

	public void setHeader(Asset header) {
		this.header = header;
	}

}
