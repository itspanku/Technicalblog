package org.jsp.userproduct.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.userproduct.dto.Product;
import org.jsp.userproduct.dto.User;

public class ProductDao {
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public Product AddProduct(Product pro, int user_id) {
		User u = manager.find(User.class, user_id);
		if (u != null) {
			pro.setUser(u);
			u.getProduct().add(pro);
			manager.persist(pro);
			transaction.begin();
			transaction.commit();
			return pro;
		} else {
			return null;
		}
	}

	public List<Product> viewProduct(int user_id) {
		String qry = "select u.product from User u where u.id=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, user_id);
		try {
			return (List<Product>) q.getResultList();
		} catch (NoResultException e) {
			return null;

		}
	}

	public Product viewProductBY(String categery) {
		String qry = "select p from Product p where p.categery=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, categery);
		try {
			return (Product) q.getSingleResult();
		} catch (NoResultException e) {
			return null;

		}
	}
}
