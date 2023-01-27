package com.faith.repository;

import java.util.Date;
import java.util.List;

import com.faith.entity.Appointment;

public interface IAppointmentRepository {

	//list all appointments for a day
	public List<Appointment> listAllAppointmentsForDay(String _appointmentDate);
	
	//add new appointment
	public void addAppointment(Appointment _appointment);
	
	//cancel an appointment
	public void cancelAppointment(Integer _appointmentId);
	
	//update an appointment
	public Appointment getAppointmentDetails(Integer _appointmentId);
	
	public List<Appointment> listAllAppointments();
	
	//search appointments based on patient name
	public List<Appointment> listAllAppointmentsByPatientName(String _patientName);
}
