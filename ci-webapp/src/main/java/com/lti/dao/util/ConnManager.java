package com.lti.dao.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnManager {
	
	/*public static Connection connect() {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			return DriverManager.getConnection("jdbc:derby://localhost:1527/trainingdb", "mj", "mj");
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}*/
	public static Connection connect() {
		try {
			Properties dbdrops = new Properties();
			//dbdrops.load(new FileReader("dev-db.properties"));
			dbdrops.load(ConnManager.class.getClassLoader().getResourceAsStream("dev-db.properties"));
			//how to remove hardcoded filename -- we need to pass the filename as env variable
			//one option is to pass VM arguments using -D option
			Class.forName(dbdrops.getProperty("driverName"));
			return DriverManager.getConnection(dbdrops.getProperty("url"),dbdrops.getProperty("user"),dbdrops.getProperty("pass"));
		}
		catch(ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
