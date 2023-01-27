package com.faith.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Appointment {
	
	//instance variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer appointmentId;
	private Integer patientId;
	private Integer doctorId;
	private Integer specializationId;
	private String appointmentDate;
	private Integer tokenNumber;
	private Boolean isActive;
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToOne
	@JoinColumn(name="patientId", insertable=false, updatable=false)
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name="doctorId", insertable=false, updatable=false)
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name="specializationId", insertable=false, updatable=false)
	private Specialization specialization;

	//default constructor
	public Appointment() {

	}
    
	public Appointment(Integer appointmentId, Integer patientId, Integer doctorId, Integer specializationId,
			String appointmentDate) {
		super();
		this.appointmentId = appointmentId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.specializationId = specializationId;
		this.appointmentDate = appointmentDate;
	}

	//parameterized constructor
	public Appointment(Integer appointmentId, Integer patientId, Integer doctorId, Integer specializationId,
			String appointmentDate, Integer tokenNumber, Boolean isActive, Date createdAt, Date updatedAt,
			Patient patient, Doctor doctor, Specialization specialization) {
		super();
		this.appointmentId = appointmentId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.specializationId = specializationId;
		this.appointmentDate = appointmentDate;
		this.tokenNumber = tokenNumber;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.patient = patient;
		this.doctor = doctor;
		this.specialization = specialization;
	}

	public Appointment(Integer appointmentId, Integer patientId, Integer doctorId, Integer specializationId,
			String appointmentDate, Integer tokenNumber, Boolean isActive, Date createdAt, Date updatedAt) {
		super();
		this.appointmentId = appointmentId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.specializationId = specializationId;
		this.appointmentDate = appointmentDate;
		this.tokenNumber = tokenNumber;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	//getters and setters
	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
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

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Integer getTokenNumber() {
		return tokenNumber;
	}

	public void setTokenNumber(Integer tokenNumber) {
		this.tokenNumber = tokenNumber;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
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
		return "Appointment [appointmentId=" + appointmentId + ", patientId=" + patientId + ", doctorId=" + doctorId
				+ ", specializationId=" + specializationId + ", appointmentDate=" + appointmentDate + ", tokenNumber="
				+ tokenNumber + ", isActive=" + isActive + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", patient=" + patient + ", doctor=" + doctor + ", specialization=" + specialization + "]";
	}
}
