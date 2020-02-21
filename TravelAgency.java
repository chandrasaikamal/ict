
import java.util.*;
import java.io.*;
import java.sql.*;
public class TravelAgency {
    
	
	public List<Package> generatePackageCost(String filePath) {
		
		List<Package> pack=new ArrayList<>();
		FileReader fr=null;
		
		
		//Reading file from given path
		
		
		try {
			fr = new FileReader(new File(filePath));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		
		//Readingthe data from file to buffered reader
		
		
		BufferedReader br = new BufferedReader(fr);
		String line;
		try {
			while((line=br.readLine())!=null)
			{
				String[] packageDetails=line.split(",");
				String packageId=packageDetails[0];
				try
				{
				    
				    
				    //Checking whether the packageId is valid or not
				    
				    
					if(validate(packageId))
					{
						
						String sourcePlace=packageDetails[1];
						String destinationPlace=packageDetails[2];
						double basicFare=Double.parseDouble(packageDetails[3]);
						int  noOfDays=Integer.parseInt(packageDetails[4]);
						Package p=new Package();
						
						
						//Storing the details into package class
						
						
						p.setPackageId(packageId);
						p.setDestinationPlace(destinationPlace);
						p.setBasicFare(basicFare);
						p.setNoOfDays(noOfDays);
						p.setSourcePlace(sourcePlace);
						p.calculatePackageCost();
						
						
						//Adding Package object to list
						
						
						pack.add(p);
					}
				}
				catch(InvalidPackageIdException e)
				{
				    
				    
				    //Handling user defined Exception if PackageId is Inavalid
				    
				    
					System.out.println(e.getMessage());
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pack;
		
		
	}
	
	public boolean validate(String packageId) throws InvalidPackageIdException {
	    
		//checking for packageId
		
		
    	if(packageId.matches("[a-zA-Z0-9]{3}[/]{1}[a-zA-Z0-9]{3}")) {
			return true;
		
		}
		
		
		//Throwing InvalidPackageIdException
		
		
		throw new InvalidPackageIdException("Invalid Package Id");
    	
	}
	
	
	public List<Package> findPackagesWithMinimumNumberOfDays() {
		
		DBHandler d=new DBHandler();
		List<Package> finalList=new ArrayList<>();
		
		
		//Storing Connection returned from establishConnection method in DBHandler
		
		
		Connection c=d.establishConnection();
		Statement s = null;
		try {
			s = c.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//Finding the rows with min nof of days from package_details
		
		
		String sql = "SELECT * FROM package_details WHERE no_of_days IN (SELECT MIN(no_of_days) FROM package_details)";
		ResultSet rs = null;
		try {
			rs = s.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(rs.next())
			{
				String packageId=rs.getString(1);
				String sourcePlace=rs.getString(2);
				String destinationPlace=rs.getString(3);
				int  noOfDays=rs.getInt(4);
				double PackageCost=rs.getInt(5);
				Package p=new Package();
				
				
				//Storing the details into package class
				
				
				p.setPackageId(packageId);
				p.setDestinationPlace(destinationPlace);
				p.setNoOfDays(noOfDays);
				p.setSourcePlace(sourcePlace);
				p.setPackageCost(PackageCost);
				
				
				//Adding Package object to list
				
				
				finalList.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return finalList;
	}
}
