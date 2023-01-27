package com.faith.repository;

public interface ILoginRepository {

	//check if user exists, then return role
	public Integer getRoleFromLogin(String username, String password);
}
