package com.faith.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Bill {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer billId;
	private Integer appointmentId;
	private Double amount;
	
	@OneToOne
	@JoinColumn(name="appointmentId", insertable=false, updatable=false)
	private Appointment appointment;

	//default constructor
	public Bill() {
		
	}

	//parameterized constructor
	public Bill(Integer billId, Integer appointmentId, Double amount) {
		super();
		this.billId = billId;
		this.appointmentId = appointmentId;
		this.amount = amount;
	}

	public Bill(Integer billId, Integer appointmentId, Double amount, Appointment appointment) {
		super();
		this.billId = billId;
		this.appointmentId = appointmentId;
		this.amount = amount;
		this.appointment = appointment;
	}

	//getters and setters
	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	//toString()
	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", appointmentId=" + appointmentId + ", amount=" + amount + ", appointment="
				+ appointment + "]";
	}	
}
