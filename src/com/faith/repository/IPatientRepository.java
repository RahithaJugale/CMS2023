package com.faith.repository;

import java.util.List;

import com.faith.entity.Patient;

public interface IPatientRepository {

	//add new patient
	public void addPatient(Patient _patient);
	
	//list all patients
	public List<Patient> listAllPatients();
	
	//delete patient
	public void deletePatient(Integer _patientId);
	
	//update patient
	public Patient getPatientDetails(Integer _patientId);
	
	//search patient by phone number
	public List<Patient> searchPatient(Long _phoneNumber);
}
