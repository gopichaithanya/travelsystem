package net.sf.brightside.travelsystem.tapestry.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.OptionGroupModel;
import org.apache.tapestry5.OptionModel;
import org.apache.tapestry5.util.AbstractSelectModel;

public class BeanSelectModel<Bean> extends AbstractSelectModel {

	private List<Bean> list;

	public BeanSelectModel(List<Bean> list) {
		super();
		this.list = list;
	}

	@Override
	public List<OptionGroupModel> getOptionGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OptionModel> getOptions() {
		// TODO Auto-generated method stub
		List<OptionModel> l = new ArrayList<OptionModel>();
		for (Bean bean : list) {
			l.add(new BeanOptionModel<Bean>(bean));
		}
		return l;
	}

}
