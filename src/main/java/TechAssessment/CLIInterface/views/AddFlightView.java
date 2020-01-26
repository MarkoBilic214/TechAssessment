package TechAssessment.CLIInterface.views;

import java.util.ArrayList;

import TechAssessment.model.FlightDetails;

public class AddFlightView extends BaseView {

	@Override
	public void startInteraction() {
		ArrayList<FlightDetails> flightList = new ArrayList<FlightDetails>();
		while(true) {
			
			FlightDetails flight = new FlightDetails();
			System.out.println("please insert the details of the flight");
			System.out.println("please enter flight number");
			flight.setFlightNumber(Integer.parseInt(scanner.nextLine()));
			System.out.println("please enter departure City");
			flight.setDepartureCity(scanner.nextLine());
			System.out.println("please enter arival City");
			flight.setArrivalCity(scanner.nextLine());
			System.out.println("please enter flight day number");
			flight.setFlightDay(Integer.parseInt(scanner.nextLine()));
			flightList.add(flight);
			System.out.println("would you like to add another flight? (y/n)");
			String res = scanner.nextLine();
			if(res.equals("n")) {
				this.NextViewInfo.put("flights", flightList);
				break;	
			}
		}
		this.printFlights(flightList);
		InitialView view = new InitialView();
		this.setNextView(view);
	}
	
	private void printFlights(ArrayList<FlightDetails> flightList) {
		for (FlightDetails flight: flightList) {
			System.out.println(flight.toString());
		}
	}

	
	
}
