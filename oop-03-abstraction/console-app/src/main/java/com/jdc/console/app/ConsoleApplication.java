package com.jdc.console.app;

public class ConsoleApplication {
	
	private String appName;
	private AbstractFeature [] features;

	public ConsoleApplication(String appName, AbstractFeature ... features) {
		super();
		this.appName = appName;
		this.features = features;
	}
		public void launch() {
			showMessage("Welcome to %s".formatted(appName));
			
			do {
				var feature = getUserSelectedFeature();
				
				feature.showMenu();
				System.out.println();
			
				feature.doBusiness();
				System.out.println();
				
			}while(askToDoAgain());
			showMessage("See you Again!");
		}
		
	
		private AbstractFeature getUserSelectedFeature() {
			
			System.out.println("Please Select Menu");
			for(var feature :features) {
				feature.showMenu();
			}
			System.out.println();
			var selectedId = UserInputs.readInt("Feature ID :");
			
			return features[selectedId-1];
		}
		private boolean askToDoAgain() {
		
			System.out.println();
			var result = UserInputs.readString("Do you want to do again? (y/Others) : ");
			System.out.println();
			return "Y".equalsIgnoreCase(result);
		}
		
		private void showMessage(String message) {
			System.out.println("==================================");
			System.out.println(message);
			System.out.println("==================================");
			System.out.println();
			
		}
	
	
}
