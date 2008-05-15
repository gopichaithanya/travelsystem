package net.sf.brightside.travelsystem.core.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextFactoryImpl implements ApplicationContextFactory {

	private static ApplicationContext context = null;

	@Override
	public ApplicationContext getApplicationContextInstance() {
		// TODO Auto-generated method stub

		if (context == null) {
			return new ClassPathXmlApplicationContext(this.getLocations());

		} else {
			return context;
		}
	}

	@Override
	public String[] getLocations() {
		// TODO Auto-generated method stub
		String[] locations = {
				"META-INF/net/sf/brightside/travelsystem/core/spring/context.xml",
				"META-INF/net/sf/brightside/travelsystem/metamodel/context.xml",
				"META-INF/net/sf/brightside/travelsystem/core/hsqldb/context.xml",
				"META-INF/net/sf/brightside/travelsystem/core/hibernate/context.xml",
				"META-INF/net/sf/brightside/travelsystem/service/context.xml"
				};

		return locations;
	}
}
