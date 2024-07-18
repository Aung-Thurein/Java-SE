package com.jdc.demo.dto;

public record Patient(
		int id,
		String name,
		String phone,
		String address,
		Gender gender,
		String BloodType
		) {
	
	public static class Builder{
		private int id;
		private String name;
		private String phone;
		private String address;
		private Gender gender;
		private String BloodType;
		
		public int id(int id) {
			this.id = id;
			return id;
		}
		public String name(String name) {
			this.name = name;
			return name;
		}
		public String phone(String phone) {
			this.phone = phone;
			return phone;
		}
		public String address(String address) {
			this.address = address;
			return address;
		}
		public Gender gender(Gender gender) {
			this.gender = gender;
			return gender;
		}
		public String BloodType(String BloodType) {
			this.BloodType = BloodType;
			return BloodType;
		}
		
		public Patient build() {
			return new Patient(id, name, phone, address, gender, BloodType);
		}
		
		
	}
	public static Builder builder() {
		return new Builder();
		
	}


public enum Gender{
	MALE,FEMALE
}


}


