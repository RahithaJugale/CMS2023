package com.faith.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faith.dto.DoctorDTO;

@Repository
public class DoctorRepositoryImplementation implements IDoctorRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<DoctorDTO> listAllDoctors() {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			Query<DoctorDTO> query = session.createQuery("select new com.faith.dto.DoctorDTO(d.doctorId, d.specializationId, s.fullName) from Doctor d inner join Staff s on d.staffId=s.staffId");
			List<DoctorDTO> doctors = query.getResultList();
			System.out.println(doctors);
			return doctors;
			
		}catch(Exception e) {
			
		}
		return null;
	}

	@Override
	public Double getConsultationFees(Integer _doctorId) {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			Query<Double> query = session.createQuery("select d.consultationFees from Doctor d where d.doctorId=: docId");
			query.setParameter("docId", _doctorId);
			Double consultationFee = query.getSingleResult();
			System.out.println(consultationFee);
			return consultationFee;
			
		}catch(Exception e) {
			
		}
		return null;
	}

}
