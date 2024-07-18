package com.jdc.students.controller;

import java.util.Set;

import com.jdc.console.app.UserInputs;
import com.jdc.console.app.component.TableView;
import com.jdc.students.controller.adaptor.StudentOutputTableViewModel;
import com.jdc.students.model.StudentModel;
import com.jdc.students.model.StudentOutput;

/**
 * 
 */
public class StudentSearchController extends AbstractStudentController {

	public StudentSearchController(int id, StudentModel model) {
		super(id, "Student Search", model);
	}
	private String getKeyword() {
		return UserInputs.readString("Enter Search Keyword : ");

	}

	private void showResult(StudentOutput[] result) {
		
		var tableViewModel = new StudentOutputTableViewModel(result);
		var tableView = new TableView(tableViewModel);
		tableView.draw();
		
		
		
	}

	@Override
	public void doBusiness() {

		var keyword = getKeyword(); 
		var result = model.search(keyword);
		if(result.length > 0) {
			showResult(result);
		}else {
			System.out.println("There is no result!");
		}
		
		}

}