package TechAssessment.model;

public class FlightDetails {

	int flightNumber;
	String departureCity;
	String ArrivalCity;
	int flightDay;
	
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	public String getArrivalCity() {
		return ArrivalCity;
	}
	public void setArrivalCity(String arrivalCity) {
		ArrivalCity = arrivalCity;
	}
	public int getFlightDay() {
		return flightDay;
	}
	public void setFlightDay(int flightDay) {
		this.flightDay = flightDay;
	}
	
	@Override
	public int hashCode() 
	{
	    return this.flightNumber;
	}
	
	public String toString() {
		return "Flight: "+ this.getFlightNumber()+", departure: "+this.getDepartureCity() + ", arrival: " + this.getArrivalCity() + ", day: " + this.getFlightDay();
	}
	
}
