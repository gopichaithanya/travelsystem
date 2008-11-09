package net.sf.brightside.travelsystem.tapestry.services;

import java.io.IOException;

import net.sf.brightside.travelsystem.core.spring.ApplicationContextFactoryImpl;
import net.sf.brightside.travelsystem.tapestry.providers.SpringBeansProvider;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.ObjectProvider;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.InjectService;
import org.apache.tapestry5.ioc.annotations.Local;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.RequestFilter;
import org.apache.tapestry5.services.RequestHandler;
import org.apache.tapestry5.services.Response;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;

/**
 * This module is automatically included as part of the Tapestry IoC Registry,
 * it's a good place to configure and extend Tapestry, or to place your own
 * service definitions.
 */
public class AppModule {
	public static void bind(ServiceBinder binder) {
		// binder.bind(MyServiceInterface.class, MyServiceImpl.class);

		// Make bind() calls on the binder object to define most IoC services.
		// Use service builder methods (example below) when the implementation
		// is provided in line, or requires more initialization than simply
		// invoking the constructor.

		// This is one way to crate application factory service and to bind it.
		// Also you can add some additional configuration like withMarker,
		// withId, eagerLoad, scope
		// binder.bind(ApplicationContextFactory.class,
		// ApplicationContextFactoryImpl.class);

		binder.bind(ObjectProvider.class, SpringBeansProvider.class).withId(
				"SpringBeansProvider");

	}

	/**
	 * Here is application context service. After build name you provide the
	 * unique id of your service to build (Convention over Configuration thing,
	 * bla, bla). This way is better if you want some additional initialization
	 * and not just invoking default constructor to get implementation instance
	 * like in bind method.
	 * 
	 * @author Nikola
	 */

	public static ApplicationContext buildMyApplicationContext() {
		return new ApplicationContextFactoryImpl()
				.getApplicationContextInstance();
	}

	/**
	 * Here is how you can inject some other service into your service.
	 * 
	 * @author Nikola
	 */
	// public Passenger buildPassenger(@InjectService("MyApplicationContext")
	// ApplicationContext context) {
	// return (Passenger) context.getBean(Passenger.class.getName());
	// }
	/**
	 * Although Passenger is not service but just an object and there is another
	 * way of creating objects by implementing an ObjectProvider interface and
	 * binding it with tapestry as service New providers can be specified by
	 * contributing to the MasterObjectProvider service's configuration. The
	 * configuration is mapped, with the keys being the provider prefix, and the
	 * values being the object provider implementation..*
	 * 
	 * @author Nikola
	 */

	public void contributeMasterObjectProvider(
			@InjectService("SpringBeansProvider")
			ObjectProvider objectProvider,
			OrderedConfiguration<ObjectProvider> configuration) {
		configuration.add("SpringProvider", objectProvider);
	}

	public static void contributeApplicationDefaults(
			MappedConfiguration<String, String> configuration) {
		// Contributions to ApplicationDefaults will override any contributions
		// to
		// FactoryDefaults (with the same key). Here we're restricting the
		// supported
		// locales to just "en" (English). As you add localised message catalogs
		// and other assets,
		// you can extend this list of locales (it's a comma separated series of
		// locale names;
		// the first locale name is the default when there's no reasonable
		// match).

		configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en");

		// The factory default is true but during the early stages of an
		// application
		// overriding to false is a good idea. In addition, this is often
		// overridden
		// on the command line as -Dtapestry.production-mode=false
		configuration.add(SymbolConstants.PRODUCTION_MODE, "false");
		configuration.add("tapestry.start-page-name", "start");
	}

	/**
	 * This is a service definition, the service will be named "TimingFilter".
	 * The interface, RequestFilter, is used within the RequestHandler service
	 * pipeline, which is built from the RequestHandler service configuration.
	 * Tapestry IoC is responsible for passing in an appropriate Logger
	 * instance. Requests for static resources are handled at a higher level, so
	 * this filter will only be invoked for Tapestry related requests.
	 * 
	 * <p>
	 * Service builder methods are useful when the implementation is inline as
	 * an inner class (as here) or require some other kind of special
	 * initialization. In most cases, use the static bind() method instead.
	 * 
	 * <p>
	 * If this method was named "build", then the service id would be taken from
	 * the service interface and would be "RequestFilter". Since Tapestry
	 * already defines a service named "RequestFilter" we use an explicit
	 * service id that we can reference inside the contribution method.
	 */
	public RequestFilter buildTimingFilter(final Logger log) {
		return new RequestFilter() {
			public boolean service(Request request, Response response,
					RequestHandler handler) throws IOException {
				long startTime = System.currentTimeMillis();

				try {
					// The responsibility of a filter is to invoke the
					// corresponding method
					// in the handler. When you chain multiple filters together,
					// each filter
					// received a handler that is a bridge to the next filter.

					return handler.service(request, response);
				} finally {
					long elapsed = System.currentTimeMillis() - startTime;

					log.info(String.format("Request time: %d ms", elapsed));
				}
			}
		};
	}

	/**
	 * This is a contribution to the RequestHandler service configuration. This
	 * is how we extend Tapestry using the timing filter. A common use for this
	 * kind of filter is transaction management or security. The
	 * 
	 * @Local annotation selects the desired service by type, but only from the
	 *        same module. Without
	 * @Local, there would be an error due to the other service(s) that
	 *         implement RequestFilter (defined in other modules).
	 */
	public void contributeRequestHandler(
			OrderedConfiguration<RequestFilter> configuration, @Local
			RequestFilter filter) {
		// Each contribution to an ordered configuration has a name, When
		// necessary, you may
		// set constraints to precisely control the invocation order of the
		// contributed filter
		// within the pipeline.

		configuration.add("Timing", filter);
	}
}
