package com.faith.repository;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faith.entity.Appointment;
import com.faith.entity.Patient;

@Repository
public class AppointmentRepositoryImplementation implements IAppointmentRepository {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Appointment> listAllAppointmentsForDay(String _appointmentDate) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {

			Query<Appointment> query = session.createQuery(
					"from Appointment where appointmentDate=:appDate and isActive=true order by tokenNumber", Appointment.class);
			query.setParameter("appDate", _appointmentDate);

			List<Appointment> appointments = query.getResultList();
			return appointments;
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void addAppointment(Appointment _appointment) {
		// open session
		Session session = sessionFactory.openSession();
		// begin transaction
		Transaction transaction = session.beginTransaction();
		try {
			// add new record
			System.out.println(_appointment.getAppointmentId());
			if (_appointment.getAppointmentId() == null) {
				_appointment.setIsActive(true);
				_appointment.setCreatedAt(new Date());
				_appointment.setUpdatedAt(new Date());
				String appDate = _appointment.getAppointmentDate();
				Integer docId = _appointment.getDoctorId();
				Query<Integer> query = session.createQuery("select max(tokenNumber) from Appointment where doctorId=: docId and appointmentDate=:appDate");
				query.setParameter("docId", docId);
				query.setParameter("appDate", appDate);
				
				Integer tokenNumber = query.getSingleResult();
				if(tokenNumber == null) {
					_appointment.setTokenNumber(1);
				}else {
					_appointment.setTokenNumber(tokenNumber+1);
				}
				System.out.println("token"+tokenNumber);

				// update
			} else {
				_appointment.setUpdatedAt(new Date());
			}
			// save to DB
			session.saveOrUpdate(_appointment);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}

	}

	@Override
	public void cancelAppointment(Integer _appointmentId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {

			Appointment _appointment = session.get(Appointment.class, _appointmentId);
			_appointment.setIsActive(false);
			_appointment.setUpdatedAt(new Date());
			
			session.saveOrUpdate(_appointment);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public Appointment getAppointmentDetails(Integer _appointmentId) {
		// open session
		Session session = sessionFactory.openSession();

		try {

			Appointment _appointment = session.get(Appointment.class, _appointmentId);
			return _appointment;
		} catch (Exception e) {

		} finally {
			session.close();
		}
		return null;
	}
	
	public List<Appointment> listAllAppointments(){
		
		Session session = sessionFactory.getCurrentSession();
		try {
			
			Query<Appointment> query = session.createQuery("from Appointment where isActive=true order by appointmentId", Appointment.class);
			List<Appointment> appointments = query.getResultList();
			return appointments;
		}catch(Exception e) {
			
		}
		return null;
	}

	@Override
	public List<Appointment> listAllAppointmentsByPatientName(String _patientName) {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			System.out.println("Inside repo");
			Query<Appointment> query = session.createQuery("select new com.faith.entity.Appointment(a.appointmentId, a.patientId, a.doctorId, a.specializationId, a.appointmentDate, a.tokenNumber, a.isActive, a.createdAt, a.updatedAt, a.patient, a.doctor, a.specialization) from Appointment a inner join Patient p on a.patientId=p.patientId where p.firstName=:patientname");
			query.setParameter("patientname", _patientName);
			List<Appointment> appointments = query.getResultList();
			System.out.println(appointments);
			return appointments;
		}catch(Exception e) {
			
		}
		return null;
	}

}
