package com.faith.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.faith.dto.DoctorDTO;
import com.faith.entity.Appointment;
import com.faith.entity.Bill;
import com.faith.entity.Specialization;
import com.faith.service.IAppointmentService;
import com.faith.service.IBillService;
import com.faith.service.IDoctorService;
import com.faith.service.ISpecializationService;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	IAppointmentService appointmentServiceImplementation;

	@Autowired
	ISpecializationService specializationServiceImplementation;

	@Autowired
	IDoctorService doctorServiceImplementation;

	@Autowired
	IBillService billServiceImplementation;

	@GetMapping("/list")
	public String listAllAppointmentsForDay(String _appointmentDate, Model _model, HttpSession session)
			throws ParseException {

		try {

			Integer role = (Integer) session.getAttribute("roleId");
			if (role == 3) {
				String date = "";
				if (_appointmentDate == null) {
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					date = formatter.format(new Date());
					// _appointmentDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
				}

				List<Appointment> appointments = appointmentServiceImplementation.listAllAppointmentsForDay(date);

				_model.addAttribute("appointments", appointments);

				List<Bill> bills = billServiceImplementation.getAllBills();
				_model.addAttribute("bills", bills);

				return "appointment-list";

			}
		} catch (Exception e) {
			return "page-not-found";

		}
		return "page-not-found";
	}

	@GetMapping("/add")
	public String appointmentForm(@RequestParam("patientId") Integer _patientId, HttpSession session, Model _model) {

		try {

			Integer role = (Integer) session.getAttribute("roleId");
			if (role == 3) {
				Appointment _appointment = new Appointment();
				_appointment.setPatientId(_patientId);

				List<Specialization> specializations = specializationServiceImplementation.listAllSpecialization();
				List<DoctorDTO> doctors = doctorServiceImplementation.listAllDoctors();
				List<Appointment> appointments = appointmentServiceImplementation.listAllAppointments();

				_model.addAttribute("appointment", _appointment);
				_model.addAttribute("specializations", specializations);
				_model.addAttribute("doctors", doctors);
				_model.addAttribute("allAppointments", appointments);
				System.out.println(_appointment);
				// _model.addAttribute("doctors", "[[1,2,3,4],[5,6,7]]");
				// _model.addAllAttributes(doctors);

				return "book-appointment-form";

			}
		} catch (Exception e) {
			return "page-not-found";
		}
		return "page-not-found";
	}

	@PostMapping("/save")
	// @RequestMapping(value = "/save", method = { RequestMethod.GET,
	// RequestMethod.POST })
	public String saveAppointment(@ModelAttribute("appointment") Appointment _appointment,
			@RequestParam("appointmentId") Integer _appointmentId, @RequestParam("patientId") Integer _patientId,
			HttpSession session) {

		try {

			Integer role = (Integer) session.getAttribute("roleId");
			if (role == 3) {
				// System.out.println("Hello");
				System.out.println(_appointment);
				System.out.println(_patientId);
				System.out.println(_appointmentId);
				if (_appointmentId != null) {
					Appointment appointment = appointmentServiceImplementation.getAppointmentDetails(_appointmentId);
					_appointment.setCreatedAt(appointment.getCreatedAt());
					_appointment.setIsActive(appointment.getIsActive());
				}
				appointmentServiceImplementation.saveAppointment(_appointment);
				return "redirect:/appointment/list";
			}
		} catch (Exception e) {
			return "page-not-found";
		}
		return "page-not-found";

	}

	@GetMapping("/update")
	public String updateAppointment(@RequestParam("appointmentId") Integer _appointmentId, Model _model,
			HttpSession session) {

		try {

			Integer role = (Integer) session.getAttribute("roleId");
			if (role == 3) {
				Appointment _appointment = appointmentServiceImplementation.getAppointmentDetails(_appointmentId);
				_model.addAttribute("appointment", _appointment);
				List<Specialization> specializations = specializationServiceImplementation.listAllSpecialization();
				_model.addAttribute("specializations", specializations);
				List<DoctorDTO> doctors = doctorServiceImplementation.listAllDoctors();
				_model.addAttribute("doctors", doctors);
				System.out.println(_appointment);

				return "book-appointment-form";
			}
		} catch (Exception e) {
			return "page-not-found";
		}
		return "page-not-found";
	}

	@GetMapping("/cancel")
	public String cancelAppointment(@RequestParam("appointmentId") Integer _appointmentId, HttpSession session) {

		try {

			Integer role = (Integer) session.getAttribute("roleId");
			if (role == 3) {
				appointmentServiceImplementation.cancelAppointment(_appointmentId);
				return "redirect:/appointment/list";
			}
		} catch (Exception e) {
			return "page-not-found";
		}
		return "page-not-found";

	}

	@GetMapping("/filter")
	public String getAllAppointmentsForDay(@RequestParam("appointmentDate") String _appointmentDate, Model _model,
			HttpSession session) throws ParseException {

		try {

			Integer role = (Integer) session.getAttribute("roleId");
			if (role == 3) {
				String date = _appointmentDate;
				if (_appointmentDate == null) {
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					date = formatter.format(new Date());
					// _appointmentDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
				}

				List<Appointment> appointments = appointmentServiceImplementation.listAllAppointmentsForDay(date);

				_model.addAttribute("appointments", appointments);

				return "appointment-list";
			}
		} catch (Exception e) {
			return "page-not-found";
		}
		return "page-not-found";
	}

	@GetMapping("/search")
	public String getAllAppointmentsByPatientName(@RequestParam("patientName") String _patientName, Model _model,
			HttpSession session) throws ParseException {

		try {

			Integer role = (Integer) session.getAttribute("roleId");
			if (role == 3) {
				if (_patientName == "") {
					return "redirect:/appointment/list";
				}

				System.out.println(_patientName);
				List<Appointment> appointments = appointmentServiceImplementation.getByPatientName(_patientName);

				_model.addAttribute("appointments", appointments);

				return "appointment-list";
			}
		} catch (Exception e) {
			return "page-not-found";
		}
		return "page-not-found";
	}

	@GetMapping("/bill")
	public String billing(@RequestParam("appointmentId") Integer _appointmentId,
			@RequestParam("doctorId") Integer _doctorId, HttpSession session, Model _model) {

		try {

			Integer role = (Integer) session.getAttribute("roleId");
			System.out.println(role);
			if (role == 3) {
				System.out.println(role);
				Bill myBill1 = billServiceImplementation.getBillForAppointmentId(_appointmentId);
				System.out.println(myBill1);

				if (myBill1 != null) {
					_model.addAttribute("bill", myBill1);

				} else {

					Boolean newPatient = (Boolean) session.getAttribute("newPatient");
					Bill bill = new Bill();
					bill.setAppointmentId(_appointmentId);
					Double registrationFee = 200.0;
					Double consultFee = doctorServiceImplementation.getConsultationFees(_doctorId);
					Double totalFee = registrationFee + consultFee;
					if (newPatient != null) {
						bill.setAmount(totalFee);
						session.removeAttribute("newPatient");
					} else {
						bill.setAmount(consultFee);
					}
					
					session.removeAttribute("newPatient");
					Appointment appointment = appointmentServiceImplementation.getAppointmentDetails(_appointmentId);

					bill.setAppointment(appointment);

					Bill myBill = billServiceImplementation.addBill(bill);

					System.out.println(myBill);
					_model.addAttribute("bill", myBill);
					return "billing";
				}

				return "billing";
			}
		} catch (Exception e) {
			return "page-not-found";
		}
		return "page-not-found";
	}

}
