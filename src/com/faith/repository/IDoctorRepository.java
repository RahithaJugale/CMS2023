package com.faith.repository;

import java.util.List;

import com.faith.dto.DoctorDTO;

public interface IDoctorRepository {

	//list all doctors
	public List<DoctorDTO> listAllDoctors();
	
	//get consultation fee
	public Double getConsultationFees(Integer _doctorId);
}
