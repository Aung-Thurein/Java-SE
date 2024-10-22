package com.jdc.students.controller;

import com.jdc.students.model.StudentModel;
import com.jdc.students.model.StudentOutput;

/**
 * 
 */
public class StudentDetailsController extends AbstractStudentController {

	public StudentDetailsController(int id, StudentModel model) {
		super(id, "Show Student Details", model);
	}
	
	@Override
	public void doBusiness() {
		
		var id = super.getStudentId();
		
		var result = model.findById(id);
		if(null != result) {
			showResult(result);
		}else {
			showMessageForStudentNotFound(id);
		}
		
	}
	
	private void showResult(StudentOutput result) {
		System.out.println("""
				Student Name : %s 
				Phone number : %s
				Email   	 : %s
				Address 	 : %s 
				
				""".formatted(result.getName(), result.getPhone(), result.getEmail(), result.getAddress()));
	}


}