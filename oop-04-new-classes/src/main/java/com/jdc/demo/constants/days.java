package com.jdc.demo.constants;

public enum days  implements DisplayNameEnable{

	MON("Monday"){

		@Override
		public boolean isWeekend() {
			return false;
		}},
	TUE("Tuesday"){

		@Override
		public boolean isWeekend() {
			return false;
		}}, 
	WED("Wednesday"){

		@Override
		public boolean isWeekend() {
			return false;
		}},
	THU("Thursday"){

		@Override
		public boolean isWeekend() {
			// TODO Auto-generated method stub
			return false;
		}},
	FRI("Friday"){

		@Override
		public boolean isWeekend() {
			// TODO Auto-generated method stub
			return false;
		}},
	SAT("Saturday"){

		@Override
		public boolean isWeekend() {
			// TODO Auto-generated method stub
			return true;
		}},
	SUN("Sunday"){

		@Override
		public boolean isWeekend() {
			// TODO Auto-generated method stub
			return true;
		}};
	
	private days(String displayName) {
		this.displayName = displayName;
	}
	
	//Instance variables
	private String displayName;
	
	//Instance Method
	public String getDisplayName() {
		return displayName;
		
	}
	
	public int getValue() {
		return ordinal()+1;
	}
	
	public abstract boolean isWeekend();
}
