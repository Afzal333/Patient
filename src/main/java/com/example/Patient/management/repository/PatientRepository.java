package com.example.Patient.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Patient.management.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
