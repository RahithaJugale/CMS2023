package com.faith.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.repository.ILoginRepository;

@Service
public class LoginServiceImplementation implements ILoginService {

	@Autowired
	ILoginRepository loginRepositoryImplementation;
	
	@Override
	@Transactional
	public Integer getRoleFromLogin(String username, String password) {
		return loginRepositoryImplementation.getRoleFromLogin(username, password);
	}

}
