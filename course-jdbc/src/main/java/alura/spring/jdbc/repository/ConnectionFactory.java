package alura.spring.jdbc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import alura.spring.jdbc.config.AppConfig;

public class ConnectionFactory {

	public static Connection getConnection() throws SQLException {
		Properties props = AppConfig.PROPS;
		return DriverManager.getConnection(
				props.getProperty("database"),
				props.getProperty("username"),
				props.getProperty("password"));
	}

}
