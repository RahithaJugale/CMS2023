package com.faith.dto;

public class DoctorDTO {

	private Integer doctorId;
	private Integer specializationId;
	private String fullName;
	
	public DoctorDTO() {

	}

	public DoctorDTO(Integer doctorId, Integer specializationId, String fullName) {
		super();
		this.doctorId = doctorId;
		this.specializationId = specializationId;
		this.fullName = fullName;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Integer getSpecializationId() {
		return specializationId;
	}

	public void setSpecializationId(Integer specializationId) {
		this.specializationId = specializationId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "DoctorDTO [doctorId=" + doctorId + ", specializationId=" + specializationId + ", fullName=" + fullName
				+ "]";
	}
}
