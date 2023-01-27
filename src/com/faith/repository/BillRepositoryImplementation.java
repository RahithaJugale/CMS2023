package com.faith.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faith.entity.Bill;

@Repository
public class BillRepositoryImplementation implements IBillRepository {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Bill> getAllBills() {

		Session session = sessionFactory.getCurrentSession();
		try {
			Query<Bill> query = session.createQuery("from Bill order by billId", Bill.class);
			List<Bill> bills = query.getResultList();
			return bills;
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public Bill addBill(Bill _bill) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.saveOrUpdate(_bill);
			transaction.commit();
			return _bill;
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Bill getBillForAppointmentId(Integer _appointmentId) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Query<Bill> query = session.createQuery("from Bill b where b.appointmentId=:appId");
			query.setParameter("appId", _appointmentId);

			Bill result = query.getSingleResult();

			return result;

		} catch (Exception e) {
		} finally {
		}
		return null;
	}

}
