package TechAssessment.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import TechAssessment.model.FlightDetails;
import TechAssessment.model.Order;

public class FlightSchedular {

	
	public void  ScheduleOrders(ArrayList<FlightDetails> flights, ArrayList<Order> orders ) {
		HashMap<FlightDetails,ArrayList<Order>> flightsToOrders = new HashMap<FlightDetails,ArrayList<Order>>();
		HashMap<String,ArrayList<FlightDetails>> destinationToFlight = new HashMap<String,ArrayList<FlightDetails>>();  
		for(FlightDetails flight : flights) {
			if(destinationToFlight.get(flight.getArrivalCity())==null) {
				ArrayList<FlightDetails> arr = new ArrayList<FlightDetails>();
				arr.add(flight);
				destinationToFlight.put(flight.getArrivalCity(),arr);
			}
			else {
				destinationToFlight.get(flight.getArrivalCity()).add(flight);
			}
			
			flightsToOrders.put(flight, new ArrayList<Order>());
		}
		for(Order order: orders) {
			if (destinationToFlight.get(order.getDestination())!=null) {
				FlightDetails curFlight = null;
				for(FlightDetails flight : destinationToFlight.get(order.getDestination())) {
					if (flightsToOrders.get(flight).size()<20) {
						curFlight = flight;
						break;
					}
				}
				if(curFlight==null) {
					System.out.println("order: "+order.getOrderName() + ", flightNumber: not scheduled");
				}
				else {
					flightsToOrders.get(curFlight).add(order);
					curFlight=null;
				}	
			}
			else {
				System.out.println("order: "+order.getOrderName() + ", flightNumber: not scheduled");
			}
		}
		for(FlightDetails flight: flightsToOrders.keySet()) {
			for (Order order :flightsToOrders.get(flight)) {
				System.out.println("order: " +order.getOrderName() + ", flightNumber: "+ flight.getFlightNumber() +", departure: "+flight.getDepartureCity()+ ", arrival: "+flight.getArrivalCity() + ", day: "+flight.getFlightDay());
			}
		}
		System.out.println();
	}
}
