package net.sf.brightside.travelsystem.core.command.hibernate;

import net.sf.brightside.travelsystem.core.command.CommandException;
import net.sf.brightside.travelsystem.core.command.GetByExample;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class GetByExampleImpl<ReturnType,ExampleType> extends HibernateDaoSupport implements
		GetByExample<ReturnType, ExampleType> {
	
	ExampleType example;
	

	@SuppressWarnings("unchecked")
	@Override
	public ReturnType execute() throws CommandException {
		// TODO Auto-generated method stub
		Criteria criteria = this.getSession().createCriteria(example.getClass());
		criteria.add(Example.create(example));
		
		return (ReturnType) criteria.list();
		
			}

	@Override
	public ExampleType getExample() {
		// TODO Auto-generated method stub
		return example;
	}

	@Override
	public void setExample(ExampleType example) {
		// TODO Auto-generated method stub
		this.example = example;
	}

}
