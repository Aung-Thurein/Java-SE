package com.jdc.students.controller.adaptor;

import com.jdc.console.app.component.TabelViewModel;
import com.jdc.students.model.StudentOutput;

public class StudentOutputTableViewModel implements TabelViewModel{
	
	private StudentOutput[] array;
	
	public static final String ID = "ID";
	public static final String NAME = "Name";
	public static final String PHONE = "Phone";
	public static final String EMAIL = "Email";
	public static final String ADDRESS = "Address";
	
	private int idSize = ID.length() + 2;
	private int nameSize = NAME.length() + 2;
	private int phoneSize = PHONE.length() + 2;
	private int emailSize = EMAIL.length() + 2;
	private int addressSize = ADDRESS.length() + 2;
	
	public StudentOutputTableViewModel(StudentOutput[] array) {
		this.array = array;
		
		for (var data : array) {
			var id = String.valueOf(data.getId()).length()+2;
			idSize = id > idSize ? id : idSize;
			
			var name = data.getName().length() + 2;
			nameSize = name > nameSize ? name : nameSize;
			
			var phone = data.getPhone().length() + 2;
			phoneSize = phone > phoneSize ? phone : phoneSize;
			
			var email = data.getEmail().length() + 2;
			emailSize = email > emailSize ? email : emailSize;
			
			var address = data.getAddress().length() + 2;
			addressSize = address > addressSize ? address : addressSize;
			
		}
	}

	@Override
	public int maxSize() {
			return idSize + nameSize + phoneSize + emailSize + addressSize;
	}

	@Override
	public String header() {
		var rowFormat = getRowFormat();
		return rowFormat.formatted(ID,NAME,PHONE,EMAIL,ADDRESS);
	}

	private String getRowFormat() {
		var fmt = "%%-%ds%%-%ds%%-%ds%%-%ds%%-%ds";
		return fmt.formatted(idSize, nameSize, phoneSize, emailSize, addressSize);
	}

	@Override
	public String[] rows() {
		var rowFormat = getRowFormat();
		var result = new String [this.array.length];
		
		for (int i = 0; i < array.length; i++) {
			var data = array[i];
			result[i] = rowFormat.formatted(data.getId(), data.getName(), data.getPhone(), data.getEmail(), data.getAddress());
		}
		return result;
	}
	
}
