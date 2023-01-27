package com.faith.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faith.entity.User;

@Repository
public class LoginRepositoryImplementation implements ILoginRepository {

	@Autowired 
	SessionFactory sessionFactory;
	
	@Override
	public Integer getRoleFromLogin(String username, String password) {
		
		Session session = sessionFactory.getCurrentSession();
		try {
			System.out.println(username);
			System.out.println(password);
			Query<Integer> query = session.createQuery("select u.roleId from User u where u.username=:user and u.password=:pass");
			query.setParameter("user", username);
			query.setParameter("pass", password);

			Integer role = query.getSingleResult();
			if(role > 0) {
				return role;
			}else {
				return 0;
			}
		}catch(Exception e) {
			return 0;
		}

	}

}
