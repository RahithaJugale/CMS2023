package com.faith.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.dto.DoctorDTO;
import com.faith.repository.IDoctorRepository;

@Service
public class DoctorServiceImplementation implements IDoctorService {

	@Autowired
	IDoctorRepository doctorRepositoryImplementation;
	
	@Override
	@Transactional
	public List<DoctorDTO> listAllDoctors() {
		return doctorRepositoryImplementation.listAllDoctors();
	}

	@Override
	@Transactional
	public Double getConsultationFees(Integer _doctorId) {
		return doctorRepositoryImplementation.getConsultationFees(_doctorId);
	}

}
