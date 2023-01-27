package com.faith.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.entity.Bill;
import com.faith.repository.IBillRepository;

@Service
public class BillServiceImplementation implements IBillService {

	@Autowired
	IBillRepository billRepositoryImplementation;
	
	@Override
	@Transactional
	public List<Bill> getAllBills() {
		return billRepositoryImplementation.getAllBills();
	}

	@Override
	@Transactional
	public Bill addBill(Bill _bill) {
		return billRepositoryImplementation.addBill(_bill);
	}

	@Override
	@Transactional
	public Bill getBillForAppointmentId(Integer _appointmentId) {
		Bill bill = billRepositoryImplementation.getBillForAppointmentId(_appointmentId);
		System.out.println(bill);
		return bill;
	}

}
