package com.example.Patient.management.service;

import java.util.List;


import com.example.Patient.management.entity.Patient;

public interface PatientService {
List<Patient> getAllPatients();
	
	Patient savePatient(Patient patient);
	
	Patient getPatientById(Long id);
	
	Patient updatePatient(Patient patient);
	
	void deletePatientById(Long id);
}

