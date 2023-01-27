package com.faith.service;

import java.util.Date;
import java.util.List;

import com.faith.entity.Appointment;

public interface IAppointmentService {

	//list all appointments for a day
	public List<Appointment> listAllAppointmentsForDay(String _appointmentDate);
	
	//get appointment details
	public Appointment getAppointmentDetails(Integer _appointmentId);
	
	//save appointment
	public void saveAppointment(Appointment _appointment);
	
	public List<Appointment> listAllAppointments();
	
	public void cancelAppointment(Integer _appointmentId);
	
	public List<Appointment> getByPatientName(String _patientName);
}
