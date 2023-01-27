package com.faith.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.entity.Patient;
import com.faith.repository.IPatientRepository;

@Service
public class PatientServiceImplementation implements IPatientService {

	@Autowired
	IPatientRepository patientRepositoryImplementation;
	
	//add new patient
	@Override
	public void addPatient(Patient _patient) {
		patientRepositoryImplementation.addPatient(_patient);
	}

	//list all patients
	@Override
	public List<Patient> listAllPatients() {
		return patientRepositoryImplementation.listAllPatients();
	}
	
	//delete patient
	@Override
	public void deletePatient(Integer _patientId) {
		patientRepositoryImplementation.deletePatient(_patientId);
		
	}
	
	//get patient details
	public Patient getPatientDetails(Integer _patientId) {
		return patientRepositoryImplementation.getPatientDetails(_patientId);
	}

	//search patient by phone number
	@Override
	public List<Patient> searchPatient(Long _phoneNumber) {
		return patientRepositoryImplementation.searchPatient(_phoneNumber);
	}

}
