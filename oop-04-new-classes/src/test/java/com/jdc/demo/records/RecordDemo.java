package com.jdc.demo.records;

import org.junit.jupiter.api.Test;

import com.jdc.demo.dto.Patient;
import com.jdc.demo.dto.Patient.Builder;
import com.jdc.demo.dto.Patient.Gender;
import com.jdc.demo.dto.Student;
import com.jdc.demo.dto.StudentDto;

public class RecordDemo {

	
	@Test
	public void test_immutable() {
		StudentDto student = new StudentDto(1, "Aung Aung", "323123132");
		System.out.println(student);
	}
	
	@Test
	public void test_record() {
		Student student = new Student(1, "Su Su", "32342231");
		System.out.println(student);
	}
	
	@Test
	public void test_record_builder() {
		
		Builder patient = Patient.builder();
		patient.id(1);
		patient.name("Aung Aung");
		patient.address("Myaynigone");
		patient.BloodType("o");
		patient.gender(Gender.MALE);
		System.out.println(patient.build());
		
	
	}
	
}
