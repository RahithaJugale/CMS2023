package com.faith.service;

public interface ILoginService {

	//get role id from user login
	public Integer getRoleFromLogin(String username, String password);
	
}
