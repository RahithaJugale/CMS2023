package com.faith.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.entity.Appointment;
import com.faith.repository.IAppointmentRepository;

@Service
public class AppointmentServiceImplementation implements IAppointmentService {

	@Autowired
	IAppointmentRepository appointmentRepositoryImplementation;
	
	@Override
	@Transactional
	public List<Appointment> listAllAppointmentsForDay(String _appointmentDate) {
		return appointmentRepositoryImplementation.listAllAppointmentsForDay(_appointmentDate);
	}

	@Override
	@Transactional
	public Appointment getAppointmentDetails(Integer _appointmentId) {
		return appointmentRepositoryImplementation.getAppointmentDetails(_appointmentId);
	}

	@Override
	@Transactional
	public void saveAppointment(Appointment _appointment) {
		appointmentRepositoryImplementation.addAppointment(_appointment);
	}
	
	@Override
	@Transactional
	public List<Appointment> listAllAppointments(){
		return appointmentRepositoryImplementation.listAllAppointments();
	}

	@Override
	@Transactional
	public void cancelAppointment(Integer _appointmentId) {
		appointmentRepositoryImplementation.cancelAppointment(_appointmentId);
	}

	@Override
	@Transactional
	public List<Appointment> getByPatientName(String _patientName) {
		return appointmentRepositoryImplementation.listAllAppointmentsByPatientName(_patientName);
	}

}
