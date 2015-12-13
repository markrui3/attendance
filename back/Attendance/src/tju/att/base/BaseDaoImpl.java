package tju.att.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDaoImpl<T> extends BaseInfo implements BaseDao<T>{
	@Resource
	private SessionFactory sessionFactory;
	protected Class<T> clazz; 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public BaseDaoImpl() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class)pt.getActualTypeArguments()[0];
		System.out.println("clazz = " + clazz.getName());
	}
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(T entity) {
		getSession().save(entity);
	}
	@Override
	public void update(T entity) {
		getSession().update(entity);
	}
	@Override
	public void delete(Long id) {
		Object obj = getSession().get(clazz, id);
		getSession().delete(obj);
	}
	@Override
	public T getById(Long id) {
		if (id == null) {
			return null;
		}
		return (T) getSession().get(clazz, id);
	}
	@Override
	public List<T> getByIds(Long[] ids) {
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		}

		return getSession().createQuery(
				"FROM " + clazz.getSimpleName() + " WHERE id IN(:ids)")
				.setParameterList("ids", ids)
				.list();
	}
	@Override
	public List<T> findAll() {
		return getSession().createQuery("FROM " + clazz.getSimpleName()).list();
	}

}
