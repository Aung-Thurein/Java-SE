package com.jdc.console.app;

import com.jdc.console.app.exceptions.ConsoleAppException;

public class ConsoleApplication {
	
	private String appName;
	private AbstractFeature [] features;
	boolean skipAsking = false;

	public ConsoleApplication(String appName, AbstractFeature ... features) {
		super();
		this.appName = appName;
		this.features = features;
	}
		public void launch() {
			showMessage("Welcome to %s".formatted(appName));
		
			try {
				do {
					
					try {
						
						skipAsking = false;
						var feature = getUserSelectedFeature();
						
						feature.showMenu();
						System.out.println();
					
						feature.doBusiness();
						System.out.println();
						
					} catch (ConsoleAppException e) {
						System.out.printf("Error : %s%n%n", e.getMessage());
						skipAsking = true;
						
				}
			}	
				
			while(skipAsking || askToDoAgain());
				showMessage("See you Again!");
			

			} catch (Exception e) {
				System.out.printf("System Error : %s%n%n",e.getMessage());
			}
		}
	
		private AbstractFeature getUserSelectedFeature() {
			
			System.out.println("Please Select Menu");
			for(var feature :features) {
				feature.showMenu();
			}
			System.out.println();
			var selectedId = UserInputs.readInt("Feature ID");
			
			return features[selectedId-1];
		}
		private boolean askToDoAgain() {
		
			System.out.println();
			var result = UserInputs.readString("Do you want to do again? (y/Others)");
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
