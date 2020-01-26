package TechAssessment.CLIInterface.views;

import java.util.HashMap;
import java.util.Scanner;

public class InitialView extends BaseView {

	public InitialView() {
		
	}
	public InitialView(HashMap<String,Object>nextInfo) {
		super(nextInfo);
	}
	
	@Override
	public void startInteraction() {
		System.out.println("hello Welcome to Transport.ly");
		System.out.println("please Select one of the options to execute commands");
		System.out.println("///////////////");
		int response;
		while(true){
			System.out.println("option 1) Add Flights");
			System.out.println("option 2) schedule flight itineraries");
			System.out.println("option 3) Exit Program");
			response = Integer.parseInt(scanner.nextLine());
			if(response !=0) {
				break;
			}
		}
		if(response == 1) {
			this.setNextView(new AddFlightView());
		}
		else if(response == 2) {
			this.setNextView(new FlightScheduleView());
		}
		
	}
	
	
}
