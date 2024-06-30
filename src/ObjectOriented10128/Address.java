package ObjectOriented10128;

public class Address {

	private String streetAddress;
	private String buildingNumber;
	private String city;
	private String country;

	public Address(String streetAddress, String buildingNumber, String city, String state) {
		this.streetAddress = streetAddress;
		this.buildingNumber = buildingNumber;
		this.city = city;
		this.country = state;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String state) {
		this.country = state;
	}

	@Override
	public String toString() {
		return streetAddress + " " + buildingNumber + ", " + city + ", " + country;

	}
}