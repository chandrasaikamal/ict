import java.io.*;
import java.sql.*;
import java.util.*;
public class DBHandler {

public Connection establishConnection(){
    
    Properties properties=new Properties();
	FileInputStream fileInputStream=null;
	try {
		fileInputStream = new FileInputStream("db.properties");
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		properties.load(fileInputStream);
	} catch (IOException e) {
		e.printStackTrace();
	}
	//Retrieving properties from db.properties and catching exception if not found
	try {
		Class.forName(properties.getProperty("db.classname"));
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	//Retrieving properties from db.properties
	String url=properties.getProperty("db.url");
	String username=properties.getProperty("db.username");
	String password=properties.getProperty("db.password");
	Connection connection=null;
	//Establishing connection and catching exception if connection is not established or url not found
	try {
		connection = DriverManager.getConnection(url,username,password);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return connection;
}
}