
public class Package {
	private String packageId;
	private String sourcePlace;
	private String destinationPlace;
	private double basicFare;
	private int noOfDays;
	private double packageCost;
	
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public String getSourcePlace() {
		return sourcePlace;
	}
	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}
	public String getDestinationPlace() {
		return destinationPlace;
	}
	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}
	public double getBasicFare() {
		return basicFare;
	}
	public void setBasicFare(double basicFare) {
		this.basicFare = basicFare;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public double getPackageCost() {
		return packageCost;
	}
	public void setPackageCost(double packageCost) {
		this.packageCost = packageCost;
	}

	public void calculatePackageCost() {
	
		double packageCost;
		
		
		//Calculating Package Cost
		
		
		int noOfDays=this.getNoOfDays(),discount=0;
		if(noOfDays<=5) {
			discount=0;
		}
		else if(noOfDays>5 && noOfDays<=8) {
			discount=3;
		}
		else if(noOfDays>8 && noOfDays<=10) {
			discount=5;
		}
		else if(noOfDays>10) {
			discount=7;
		}
		packageCost=this.getBasicFare()*noOfDays;
		double dis=(packageCost*discount)/100;
		double gst=(packageCost-dis)*0.12;
		//Setting Package Cost
		this.setPackageCost(packageCost-dis+gst);
		
		
	}
	
	
}
