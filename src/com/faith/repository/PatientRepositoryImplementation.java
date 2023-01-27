package com.faith.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faith.entity.Patient;

@Repository
public class PatientRepositoryImplementation implements IPatientRepository {

	@Autowired
	SessionFactory sessionFactory;

	// add patients
	@Override
	@Transactional
	public void addPatient(Patient _patient) {

		// open session
		Session session = sessionFactory.openSession();
		// begin transaction
		Transaction transaction = session.beginTransaction();
		try {
			// add new record
			System.out.println(_patient.getPatientId());
			if (_patient.getPatientId() == null) {
				_patient.setIsActive(true);
				_patient.setCreatedAt(new Date());
				_patient.setUpdatedAt(new Date());

				// update
			} else {
				_patient.setUpdatedAt(new Date());
			}
			// save to DB
			session.saveOrUpdate(_patient);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	// list all patients
	@Override
	@Transactional
	public List<Patient> listAllPatients() {
		// open session
		Session session = sessionFactory.getCurrentSession();
		try {
			Query<Patient> query = session.createQuery("from Patient order by patientId", Patient.class);

			List<Patient> patients = query.getResultList();
			return patients;

		} catch (Exception e) {
			System.out.println("Error");
		}
		return null;
	}

	// delete a patient
	@Override
	@Transactional
	public void deletePatient(Integer _patientId) {
		// open session
		Session session = sessionFactory.openSession();
		// begin transaction
		Transaction transaction = session.beginTransaction();
		try {

			Patient _patient = session.get(Patient.class, _patientId);

			_patient.setUpdatedAt(new Date());
			_patient.setIsActive(false);

			// save to DB
			session.saveOrUpdate(_patient);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}

	}

	@Override
	@Transactional
	public Patient getPatientDetails(Integer _patientId) {
		// open session
		Session session = sessionFactory.openSession();

		try {

			Patient _patient = session.get(Patient.class, _patientId);
			return _patient;
		} catch (Exception e) {

		} finally {
			session.close();
		}
		return null;
	}

	// search patients by phone number
	@Override
	@Transactional
	public List<Patient> searchPatient(Long _phoneNumber) {
		// open session
		Session session = sessionFactory.getCurrentSession();
		try {
			Query<Patient> query = session.createQuery("from Patient where phoneNumber=:_phoneNumber order by patientId", Patient.class);
			query.setParameter("_phoneNumber", _phoneNumber);

			List<Patient> patients = query.getResultList();
			System.out.println(patients);
			return patients;

		} catch (Exception e) {
			System.out.println("Error");
		}
		return null;
	}

}
