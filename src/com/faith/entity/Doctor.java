package com.faith.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer doctorId;
	private Integer staffId;
	private Integer specializationId;
	private Double consultationFees;
	
	@OneToOne
	@JoinColumn(name="staffId", insertable=false, updatable=false)
	private Staff staff;

	@ManyToOne
	@JoinColumn(name="specializationId", insertable=false, updatable=false)
	private Specialization specialization;
	
	//default constructor
	public Doctor() {

	}

	//parameterized constructor
	public Doctor(Integer doctorId, Integer staffId, Integer specializationId, Double consultationFees, Staff staff,
			Specialization specialization) {
		super();
		this.doctorId = doctorId;
		this.staffId = staffId;
		this.specializationId = specializationId;
		this.consultationFees = consultationFees;
		this.staff = staff;
		this.specialization = specialization;
	}

	public Doctor(Integer doctorId, Integer staffId, Integer specializationId, Double consultationFees) {
		super();
		this.doctorId = doctorId;
		this.staffId = staffId;
		this.specializationId = specializationId;
		this.consultationFees = consultationFees;
	}

	//getters and setters
	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Integer getSpecializationId() {
		return specializationId;
	}

	public void setSpecializationId(Integer specializationId) {
		this.specializationId = specializationId;
	}

	public Double getConsultationFees() {
		return consultationFees;
	}

	public void setConsultationFees(Double consultationFees) {
		this.consultationFees = consultationFees;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	//toString()
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", staffId=" + staffId + ", specializationId=" + specializationId
				+ ", consultationFees=" + consultationFees + ", staff=" + staff + ", specialization=" + specialization
				+ "]";
	}
}
