package com.sgm.daoImp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.sgm.dao.UserDao;
import com.sgm.entity.User;

@SuppressWarnings("unchecked")
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User getUser(int id) {
		String hql = "from User u where u.id=?";
		Query<User> query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, id);
		return (User) query.getSingleResult();
	}

	@Override
	public List<User> getAllUser() {
		String hql = "from User";
		Query<User> query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.getResultList();
	}

	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public boolean delUser(int id) {
		String hql = "delete User u where u.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, id);

		return (query.executeUpdate() > 0);
	}

	@Override
	public boolean updateUser(User user) {

		String hql = "update User u set u.name = ?,u.password=? where u.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, user.getName());
		query.setParameter(1, user.getPassword());
		query.setParameter(2, user.getId());

		return (query.executeUpdate() > 0);
	}
}
