package net.sf.brightside.travelsystem.core.spring;

import net.sf.brightside.travelsystem.core.persistence.PersistenceManager;

import org.springframework.context.ApplicationContext;
import org.testng.annotations.BeforeMethod;

public class AbstractSpringTest {

	protected ApplicationContext context;
	protected ApplicationContextFactory factory;
	@SuppressWarnings("unchecked")
	public PersistenceManager persistenceManager;

	@SuppressWarnings("unchecked")
	public PersistenceManager getPersistenceManager() {
		return persistenceManager;
	}

	@SuppressWarnings("unchecked")
	public void setPersistenceManager(PersistenceManager persistenceManager) {
		this.persistenceManager = persistenceManager;
	}

	@SuppressWarnings("unchecked")
	@BeforeMethod
	public void beforeMethod() {

		factory = new ApplicationContextFactoryImpl();
		context = factory.getApplicationContextInstance();
		persistenceManager = (PersistenceManager) this.context
				.getBean(PersistenceManager.class.getName());

	}

}
