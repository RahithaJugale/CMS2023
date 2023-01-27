package com.faith.controller;

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

import com.faith.entity.Patient;
import com.faith.service.IPatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	IPatientService patientServiceImplementation;

	@GetMapping("/list")
	public String viewPatientList(Model _model, HttpSession session) {
		try {

			Integer role = (Integer) session.getAttribute("roleId");
			if (role == 3) {

				List<Patient> patients = patientServiceImplementation.listAllPatients();

				_model.addAttribute("patients", patients);

				return "patient-list";
			}
		} catch (Exception e) {
			return "page-not-found";

		}
		return "page-not-found";
	}

	@GetMapping("/add")
	public String patientForm(Model _model, HttpSession session) {

		try {

			Integer role = (Integer) session.getAttribute("roleId");
			if (role == 3) {
				Patient patient = new Patient();

				_model.addAttribute("patient", patient);

				return "patient-registration-form";
			}
		} catch (Exception e) {
			return "page-not-found";

		}
		return "page-not-found";
	}

	@PostMapping("/save")
	public String savePatient(@ModelAttribute("patient") Patient _patient,
			@RequestParam("patientId") Integer _patientId, HttpSession session) {

		try {

			Integer role = (Integer) session.getAttribute("roleId");
			if (role == 3) {
				if (_patientId != null) {
					Patient patient = patientServiceImplementation.getPatientDetails(_patientId);
					_patient.setCreatedAt(patient.getCreatedAt());
					_patient.setIsActive(patient.getIsActive());
				}
				
				if(_patientId == null) {
					session.setAttribute("newPatient", true);
				}
				patientServiceImplementation.addPatient(_patient);

				return "redirect:/patient/list";
			}
		} catch (Exception e) {
			return "page-not-found";

		}
		return "page-not-found";
	}

	@GetMapping("/delete")
	public String deletePatient(@RequestParam("patientId") Integer _patientId, HttpSession session) {

		try {

			Integer role = (Integer) session.getAttribute("roleId");
			if (role == 3) {
				patientServiceImplementation.deletePatient(_patientId);
				return "redirect:/patient/list";
			}
		} catch (Exception e) {
			return "page-not-found";

		}
		return "page-not-found";
	}

	@GetMapping("/update")
	public String updatePatient(@RequestParam("patientId") Integer _patientId, Model _model, HttpSession session) {

		try {

			Integer role = (Integer) session.getAttribute("roleId");
			if (role == 3) {
				Patient _patient = patientServiceImplementation.getPatientDetails(_patientId);

				_model.addAttribute("patient", _patient);
				return "update-patient-form";
			}
		} catch (Exception e) {
			return "page-not-found";

		}
		return "page-not-found";
	}

	@GetMapping("/search")
	public String searchPatient(@RequestParam("phoneNumber") String phoneNumber, Model _model, HttpSession session) {

		try {

			Integer role = (Integer) session.getAttribute("roleId");
			if (role == 3) {
				List<Patient> patients;
				if (phoneNumber != "") {
					Long _phoneNumber = Long.parseLong(phoneNumber);

					patients = patientServiceImplementation.searchPatient(_phoneNumber);
				} else {
					return "redirect:/patient/list";
				}

				_model.addAttribute("patients", patients);
				return "patient-list";
			}
		} catch (Exception e) {
			return "page-not-found";

		}
		return "page-not-found";
	}
}
