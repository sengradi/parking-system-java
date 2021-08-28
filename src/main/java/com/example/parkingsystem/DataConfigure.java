package com.example.parkingsystem;

import java.io.File;
import java.io.IOException;

import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Configuration
public class DataConfigure {

	@Autowired
    private Environment env;
	
    @Bean
    public DataSource parkingDataSource() {
    	
		String userDirectory 	= new File("").getAbsolutePath();
	    String[] arrPath 		= userDirectory.split("/");
	    String fileName 		= "parking-configure.xml";
	    String path = "";
	    for(int i=0; i < arrPath.length ; i++) {
	    	path += arrPath[i] + "/";
	    }
	    
		String configFilePath = path; // System.getProperty("user.dir");
		File xmlFile = new File(configFilePath + "/parking-configure.xml");
		System.out.println(xmlFile);
		
		try {
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = (Document) db.parse(xmlFile);  
			doc.getDocumentElement().normalize(); 
			NodeList nodeList = doc.getElementsByTagName("database_configure"); 
			Node node = nodeList.item(0);
			Element eElement = (Element) node;
			
			String dbServer = eElement.getElementsByTagName("db_server").item(0).getTextContent();
			System.out.println("Server: " + dbServer);
			String dbConnection = eElement.getElementsByTagName("db_connection").item(0).getTextContent();
			System.out.println("DB: " + dbConnection);
			String dbPort = eElement.getElementsByTagName("db_port").item(0).getTextContent();
			System.out.println("Port: " + dbPort);
			
	        String dbName = eElement.getElementsByTagName("db_name").item(0).getTextContent();
	        System.out.println("DB Name: " + dbName);
	        String dbUsername = eElement.getElementsByTagName("username").item(0).getTextContent();
	        System.out.println("User: " + dbUsername);
	        String dbPassword = eElement.getElementsByTagName("password").item(0).getTextContent();
	        System.out.println("Pass: " + dbPassword);
			
	        String dbDriver = "com.mysql.cj.jdbc.Driver";
	        String dbURL = "jdbc:" + dbConnection + "://" + dbServer + ":" + dbPort + "/" + dbName; // + "?user=" + dbUsername + "&password=" + dbPassword;
	        System.out.println("URL: " + dbURL);
    	
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(dbDriver); 
	        System.out.println("Second URL : " + dbURL);
	        dataSource.setUrl(dbURL);
	        dataSource.setUsername(dbUsername);
	        dataSource.setPassword(dbPassword);
	        System.out.println("Third URL: " + dbURL);
	        return dataSource;
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return null; 
    }
	
}
