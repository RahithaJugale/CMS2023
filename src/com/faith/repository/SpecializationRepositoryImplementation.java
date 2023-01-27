package com.faith.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faith.entity.Specialization;

@Repository
public class SpecializationRepositoryImplementation implements ISpecializationRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Specialization> getAllSpecialization() {
		
		Session session = sessionFactory.getCurrentSession();
		try {
			
			Query<Specialization> query = session.createQuery("from Specialization order by specializationName", Specialization.class);
			List<Specialization> specializations = query.getResultList();
			return specializations;
			
		}catch(Exception e) {
			
		}
		return null;
	}

}
