package net.sf.brightside.travelsystem.tapestry.providers;

import org.apache.tapestry5.ioc.AnnotationProvider;
import org.apache.tapestry5.ioc.ObjectLocator;
import org.apache.tapestry5.ioc.ObjectProvider;
import org.apache.tapestry5.ioc.annotations.InjectService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class SpringBeansProvider implements ObjectProvider {

	private ApplicationContext context;

	public SpringBeansProvider(@InjectService("MyApplicationContext")
	ApplicationContext context) {
		super();
		this.context = context;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T provide(Class<T> returnType,
			AnnotationProvider annotationProvider, ObjectLocator objectLocator) {
		// TODO Auto-generated method stub
		SpringBean annotation = annotationProvider
				.getAnnotation(SpringBean.class);
		if (annotation == null)
			return null;
		String beanName = annotation.beanName();

		T bean = null;

		if (beanName.equals("")) {

			try {
				bean = (T) context.getBean(returnType.getName());
			} catch (BeansException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new BeanNameNotProvidedException(returnType);
			}

		} else {
			bean = (T) context.getBean(beanName);

		}

		return bean;
	}

}
