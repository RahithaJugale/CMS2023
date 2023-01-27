package com.faith.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_login")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	private String username;
	private String password;
	private Integer roleId;
	
	@ManyToOne
	@JoinColumn(name="roleId", insertable=false, updatable=false)
	private Role role;

	//default constructor
	public User() {

	}

	//parameterized constructor
	public User(Integer userId, String username, String password, Integer roleId) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.roleId = roleId;
	}

	public User(Integer userId, String username, String password, Integer roleId, Role role) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.roleId = roleId;
		this.role = role;
	}

	//getters and setters
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	//toString()
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", roleId=" + roleId
				+ ", role=" + role + "]";
	}
}
