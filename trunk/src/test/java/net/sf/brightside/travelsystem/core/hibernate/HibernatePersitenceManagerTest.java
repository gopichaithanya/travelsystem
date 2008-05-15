package net.sf.brightside.travelsystem.core.hibernate;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.isA;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.fail;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import net.sf.brightside.travelsystem.core.hibernate.HibernateGenericDAOImpl;

import org.easymock.EasyMock;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HibernatePersitenceManagerTest {

	private HibernateGenericDAOImpl daoImpl;

	protected Session session;

	protected Criteria criteria;

	protected Serializable id;

	protected SessionFactory sessionFactory;

	@BeforeMethod
	public void setUp() throws Exception {

		daoImpl = new HibernateGenericDAOImpl();

		session = EasyMock.createStrictMock(Session.class);

		criteria = EasyMock.createStrictMock(Criteria.class);

		id = new Integer(3);

		sessionFactory = EasyMock.createStrictMock(SessionFactory.class);

	}



}
