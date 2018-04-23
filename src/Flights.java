//class to hold flight data to be sent to query. Used when creating a flight
public class Flights {
	public String departureCity, departureDate, departureTime, arrivalCity, arrivalDate, arrivalTime;
	
	public Flights() {
		
	}
	//constructor holding data for flights to be sent to query
	public Flights(String departureCity, String departureDate,String departureTime, String arrivalCity, String arrivalDate, String arrivalTime) {
		this.departureCity = departureCity;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalCity = arrivalCity;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		
		
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
}
