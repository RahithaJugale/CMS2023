package com.faith.service;

import java.util.List;

import com.faith.dto.DoctorDTO;

public interface IDoctorService {

	//list all doctors
	public List<DoctorDTO> listAllDoctors();
	
	//get consultation fee
	public Double getConsultationFees(Integer _doctorId);
}
