package com.lu2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// hb-01-one-to-one-uni is the schema name. i.e. the database name.
		// remember to update in the hibernate config file for its use in further project
		String jdbcUrl="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
		String user="hbstudent";
		String pass="hbstudent";
try {
	System.out.println("Connecting to database :"+jdbcUrl);
	Connection myConn=DriverManager.getConnection(jdbcUrl, user, pass);
	System.out.println("Connection established successfully");
}
catch(Exception e)
{
	e.printStackTrace();
	}
	}

}
