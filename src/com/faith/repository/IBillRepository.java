package com.faith.repository;

import java.util.List;

import com.faith.entity.Bill;

public interface IBillRepository {

	public List<Bill> getAllBills();
	
	public Bill addBill(Bill _bill);
	
	public Bill getBillForAppointmentId(Integer _appointmentId);
}
