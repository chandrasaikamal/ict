import java.util.*;
public class Main {

	public static void main(String[] args) {
	    
	    //Creating object for TravelAgency class and calling generatePackageCost method and storing details in list of packages
	    
	    
	    TravelAgency travelagency=new TravelAgency();
		String filepath="VarshTourPackageDetails.txt";
		List<Package> list=travelagency.generatePackageCost(filepath);
		for(int i=0;i<list.size();i++) {
		    
		    
		    //Printing data
		    
		    
			System.out.println();
			Package p=list.get(i);
			System.out.print("id:"+p.getPackageId());
			System.out.println("source:"+p.getSourcePlace());
			System.out.println("destination:"+p.getDestinationPlace());
			System.out.println("basic:"+p.getBasicFare());
			System.out.println("days:"+p.getNoOfDays());
			System.out.println("Pckage Cost:"+p.getPackageCost());
		}
		
		
		
		//Creating object for TravelAgency class and calling findPackagesWithMinimumNumberOfDays method and storing details in list of packages
		
		
		list=travelagency.findPackagesWithMinimumNumberOfDays();
		for(int i=0;i<list.size();i++) {
		    
		    
		    //Printing data
		    
		    
			System.out.println();
			Package p=list.get(i);
			System.out.print("id:"+p.getPackageId());
			System.out.println("source:"+p.getSourcePlace());
			System.out.println("destination:"+p.getDestinationPlace());
			System.out.println("basic:"+p.getBasicFare());
			System.out.println("days:"+p.getNoOfDays());
			System.out.println("Pckage Cost:"+p.getPackageCost());
		}
	}

}
