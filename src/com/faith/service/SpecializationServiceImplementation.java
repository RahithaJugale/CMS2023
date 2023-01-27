package com.faith.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.entity.Specialization;
import com.faith.repository.ISpecializationRepository;

@Service
public class SpecializationServiceImplementation implements ISpecializationService {

	@Autowired
	ISpecializationRepository specializationServiceRepository;
	
	@Override
	@Transactional
	public List<Specialization> listAllSpecialization() {
		return specializationServiceRepository.getAllSpecialization();
	}

}
