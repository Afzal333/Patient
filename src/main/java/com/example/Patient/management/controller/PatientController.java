package com.example.Patient.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Patient.management.entity.Patient;
import com.example.Patient.management.service.PatientService;

@Controller
public class PatientController {
	
	private PatientService patientService;
	
	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}

	@GetMapping("/patients")
	public String listPatient(Model model) {
		model.addAttribute("patients", patientService.getAllPatients());
		return "patients";
	}
	
	@GetMapping("/patients/new")
	public String createPatientForm(Model model) {
		
		// create student object to hold student form data
		Patient patient = new Patient();
		model.addAttribute("patient", patient);
		return "create_patient";
	}
	
	@PostMapping("/patients")
	public String savePatient(@ModelAttribute("patient") Patient patient) {
		patientService.savePatient(patient);
		return "redirect:/patients";
	}
		
	@GetMapping("/patients/edit/{id}")
	public String editPatientForm(@PathVariable Long id, Model model) {
			model.addAttribute("patient", patientService.getPatientById(id));
			return "edit_patient";
		}

	@PostMapping("/patients/{id}")
	public String updatePatient(@PathVariable Long id,
			@ModelAttribute("patient") Patient patient,
			Model model) {
			
			// get student from database by id
			Patient existingPatient = patientService.getPatientById(id);
			existingPatient.setId(id);
			existingPatient.setFirstName(patient.getFirstName());
			existingPatient.setLastName(patient.getLastName());
			existingPatient.setEmail(patient.getEmail());
			existingPatient.setBloodGroup(patient.getBloodGroup());
			
			// save updated student object
			patientService.updatePatient(existingPatient);
			return "redirect:/patients";		
		}
		
		// handler method to handle delete student request
		
		@GetMapping("/patients/{id}")
		public String deletePatient(@PathVariable Long id) {
			patientService.deletePatientById(id);
			return "redirect:/patients";
		}
	}
	
