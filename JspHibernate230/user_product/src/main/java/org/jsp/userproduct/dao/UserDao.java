package org.jsp.userproduct.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.userproduct.dto.User;

public class UserDao {
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public User RegisterUser(User u) {

		manager.persist(u);
		transaction.begin();
		transaction.commit();

		return u;
	}

	public User varifyUser(long phone, String password) {
		String qry = "select u from User u where u.phone=?1 and u.password=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public User varifyUser(String email, String password) {
		String qry = "select u from User u where u.email=?1 and u.password=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public User updateUser(User u) {

		manager.merge(u);
		transaction.begin();
		transaction.commit();

		return u;
	}

}
