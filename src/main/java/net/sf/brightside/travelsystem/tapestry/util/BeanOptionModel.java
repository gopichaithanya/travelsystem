package net.sf.brightside.travelsystem.tapestry.util;

import java.util.Map;

import org.apache.tapestry5.OptionModel;

public class BeanOptionModel<Bean> implements OptionModel {

	Bean bean;

	public BeanOptionModel(Bean bean) {
		super();
		this.bean = bean;
	}

	@Override
	public Map<String, String> getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub

		return bean.toString();
	}

	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return bean;
	}

	@Override
	public boolean isDisabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
