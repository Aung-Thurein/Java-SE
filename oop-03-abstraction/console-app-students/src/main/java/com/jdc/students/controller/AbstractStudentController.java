package com.jdc.students.controller;

import com.jdc.console.app.AbstractFeature;
import com.jdc.console.app.UserInputs;
import com.jdc.students.model.StudentForm;
import com.jdc.students.model.StudentModel;

public abstract class AbstractStudentController extends AbstractFeature {

	protected StudentModel model;

	public AbstractStudentController(int id, String name, StudentModel model) {
		super(id, name);
		this.model = model;
	}
	
	protected StudentForm getStudentInfo() {

		var form = new StudentForm();
		int size = 13;
		form.setName(UserInputs.readString(size, "Student Name"));
		form.setPhone( UserInputs.readString(size, "Phone Number"));
		form.setEmail(UserInputs.readString(size, "Email"));
		form.setAddress(UserInputs.readString(size, "Address"));
		
		return form;
	}

	protected int getStudentId() {
		return UserInputs.readInt("Student ID : ");
	}
	
	protected void showMessageForStudentNotFound(int id){
		System.out.printf("There is no student with id : %d%n", id);
	
	}

}