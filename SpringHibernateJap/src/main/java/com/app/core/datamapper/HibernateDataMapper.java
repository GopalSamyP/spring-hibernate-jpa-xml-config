package com.app.core.datamapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;

import com.app.exception.EntityMapperException;

public abstract class HibernateDataMapper<T extends Serializable> {

	private SessionFactory sessionFactory;

	public abstract Class<?> setEntityClass();

	@SuppressWarnings("unchecked")
	private final Class<T> entityClass = (Class<T>) setEntityClass();

	protected void save(T entity) throws EntityMapperException {
		Session session = null;
		try {
			session = getCurrentSession();

			session.save(entity);

		} catch (HibernateException e) {

			throw new EntityMapperException(e);
		}
	}

	protected void saveOrUpdate(T entity) throws EntityMapperException {
		Session session = null;
		try {

			session = getCurrentSession();

			session.saveOrUpdate(entity);

		} catch (HibernateException e) {
			throw new EntityMapperException(e);
		}
	}

	protected void persist(T entity) throws EntityMapperException {
		Session session = null;
		try {

			session = getCurrentSession();
			session.persist(entity);

		} catch (HibernateException e) {
			throw new EntityMapperException(e);
		}
	}

	protected void update(T entity) throws EntityMapperException {
		Session session = null;
		try {

			session = getCurrentSession();
			session.update(entity);

		} catch (HibernateException e) {
			throw new EntityMapperException(e);
		}
	}

	protected void delete(T entity) throws EntityMapperException {
		Session session = null;
		try {

			session = getCurrentSession();
			session.delete(entity);

		} catch (HibernateException e) {
			throw new EntityMapperException(e);
		}
	}

	protected ArrayList<T> getList(List<Criterion> criterions)
			throws EntityMapperException {
		Session session = null;
		Criteria criteria = null;
		try {
			session = getCurrentSession();

			criteria = session.createCriteria(entityClass);

			for (Criterion criterion : criterions) {
				criteria.add(criterion);
			}

			return getList(criteria);
		} catch (HibernateException e) {
			throw new EntityMapperException(e);
		}
	}

	@SuppressWarnings("unchecked")
	protected ArrayList<T> getList(Criteria criteria)
			throws EntityMapperException {
		ArrayList<T> list = (ArrayList<T>) criteria.list();

		return list;
	}

	@SuppressWarnings("unchecked")
	protected T get(Criteria criteria) throws EntityMapperException {
		Object uniqueObject = (T) criteria.uniqueResult();

		return (T) uniqueObject;
	}

	protected ArrayList<T> search(List<Criterion> criterions)
			throws EntityMapperException {
		Session session = null;
		Criteria criteria = null;
		try {

			session = getCurrentSession();

			criteria = session.createCriteria(entityClass);

			for (Criterion criterion : criterions) {
				criteria.add(criterion);
			}
			return getList(criteria);
		} catch (HibernateException e) {
			throw new EntityMapperException(e);
		}
	}

	protected T get(List<Criterion> criterions) throws EntityMapperException {

		Session session = null;
		Criteria criteria = null;

		try {

			session = getCurrentSession();

			criteria = session.createCriteria(entityClass);

			for (Criterion criterion : criterions) {
				criteria.add(criterion);
			}
			return get(criteria);
		} catch (HibernateException e) {
			throw new EntityMapperException(e);
		}

	}

	protected int updateWithNewSession(String query,
			Map<String, Object> queryMap) throws EntityMapperException {
		Session session = null;

		Query sQuery = null;

		try {
			session = sessionFactory.openSession();
			sQuery = session.createQuery(query);
			for (String key : queryMap.keySet()) {
				sQuery.setParameter(key, queryMap.get(key));
			}

			return sQuery.executeUpdate();

		} catch (HibernateException e) {

			throw new EntityMapperException(e);
		}
	}

	protected Session getCurrentSession() throws EntityMapperException {

		try {

			if (sessionFactory == null) {
				throw new EntityMapperException(getClass()
						+ " session factory is null");	
			}

			return sessionFactory.openSession();
		} catch (HibernateException e) {
			throw new EntityMapperException(e);
		}
	}

	protected Session getNewSession() throws EntityMapperException {
		try {

			if (sessionFactory == null) {
				throw new EntityMapperException(getClass()
						+ " session factory is null");
			}

			return sessionFactory.openSession();
		} catch (HibernateException e) {
			throw new EntityMapperException(e);
		}
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	@SuppressWarnings("unchecked")
	protected T requiredUniqueResult(Query q) throws EntityMapperException {
		Object result = q.uniqueResult();

		return (T) result;
	}

	@SuppressWarnings("unchecked")
	protected ArrayList<T> requiredListResult(Query query)
			throws EntityMapperException {

		return (ArrayList<T>) query.list();

	}

	protected Boolean executeUpdate(Query query) throws EntityMapperException {
		int rowCount = query.executeUpdate();

		return true;
	}

	protected void validateFound(Object o, String message)
			throws EntityMapperException {
		if (o == null) {
//			throw new EntityMapperException(null);
		}
	}

	protected void validateNotNull(Object object, String message)
			throws EntityMapperException {
		if (object == null) {
//			throw new EntityMapperException(null);
		}

	}
}
