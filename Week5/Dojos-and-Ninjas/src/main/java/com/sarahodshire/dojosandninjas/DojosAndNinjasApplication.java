package com.sarahodshire.dojosandninjas;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

@SpringBootApplication
public class DojosAndNinjasApplication {

	public static void main(String[] args) {
		SpringApplication.run(DojosAndNinjasApplication.class, args);
//
//		String url = "jdbc:mysql://localhost:3306/java_dojo_ninjas";
//		String username = "root";
//		String password = "root";
		
//		try {
//			Connection connection = DriverManager.getConnection(url, username, password);
//			String sql = "INSERT INTO ninjas (fName, lName, age) VALUES (?,?,?)";
//			PreparedStatement statement = connection.prepareStatement(sql);
//			statement.setString(1, "Sam");
//			statement.setString(2, "Hall");
//			
//			int rows = statement.executeUpdate();
//			if (rows>0) {
//				System.out.println("A row has been inserted");
//			}
//			
//			statement.close();
//			connection.close();
//
//		} catch (SQLException e) {
//			System.out.println("Error!");
//			e.printStackTrace();
//		}
	}
}
