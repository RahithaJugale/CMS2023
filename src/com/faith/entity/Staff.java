package com.faith.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Staff {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer staffId;
	
	private Integer userId;
	private String fullName;
	private Date dateOfBirth;
	private Long mobileNumber;
	private String address;
	private Date dateOfJoining;

	@OneToOne
	@JoinColumn(name="userId", insertable=false, updatable=false)
	private User user;

	//default constructor
	public Staff() {

	}

	//parameterized constructor
	public Staff(Integer staffId, Integer userId, String fullName, Date dateOfBirth, Long mobileNumber, String address,
			Date dateOfJoining, User user) {
		super();
		this.staffId = staffId;
		this.userId = userId;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.dateOfJoining = dateOfJoining;
		this.user = user;
	}

	public Staff(Integer staffId, Integer userId, String fullName, Date dateOfBirth, Long mobileNumber, String address,
			Date dateOfJoining) {
		super();
		this.staffId = staffId;
		this.userId = userId;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.dateOfJoining = dateOfJoining;
	}

	//getters and setters
	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	//toString()
	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", userId=" + userId + ", fullName=" + fullName + ", dateOfBirth="
				+ dateOfBirth + ", mobileNumber=" + mobileNumber + ", address=" + address + ", dateOfJoining="
				+ dateOfJoining + ", user=" + user + "]";
	}
}
