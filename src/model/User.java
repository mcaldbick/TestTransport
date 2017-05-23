package model;

public class User {
	private String fristName="";
	private String lastName="";
	private String fromLocation="";
	private String toLocation="";
	
	public void user(String firstName, String lastName){
		firstName = this.fristName;
		lastName = this.lastName;
		fromLocation = this.fromLocation;
		toLocation = this.toLocation;
		
	}
	public void user(){
		
	}

	public String getFristName() {
		return fristName;
	}

	public void setFristName(String fristName) {
		this.fristName = fristName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
}
