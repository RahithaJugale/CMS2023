package com.faith.service;

import java.util.List;

import com.faith.entity.Patient;

public interface IPatientService {

	// add new patient
	public void addPatient(Patient _patient);

	// list all patients
	public List<Patient> listAllPatients();

	// delete patient
	public void deletePatient(Integer _patientId);

	// get patient details
	public Patient getPatientDetails(Integer _patientId);
	
	//search patient by phoneNumber
	public List<Patient> searchPatient(Long _phoneNumber);
}
