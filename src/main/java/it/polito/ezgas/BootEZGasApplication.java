package it.polito.ezgas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootEZGasApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootEZGasApplication.class, args);
	}
	
	@PostConstruct
	public void setupDbWithData() throws SQLException{
		
		Connection conn = DriverManager.getConnection("jdbc:h2:./data/memo", "sa", "password");
		
		/*System.out.println("Connected to the database");
        
        //declare the statement object
        Statement sqlStatement = conn.createStatement();
        //declare the result set    
        ResultSet rs = null;
        //Build the query string, making sure to use column aliases
        String queryString="select * from users";
        //print the query string to the screen
        System.out.println("\nQuery string:");
        System.out.println(queryString);
        //execute the query
        rs=sqlStatement.executeQuery(queryString);*/
		
		conn.close();
		
		
		/*
		 
		list all the users stored in the database and, if there is no an admin user create it
		 
			User user= new User("admin", "admin", "admin@ezgas.com", 5);
			user.setAdmin(true);
			
		and then save it in the db
	
			
		*/

	}

}
