package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionManager
{
	private static final String	DB_URL		= "jdbc:mysql://localhost/java_ee";
	private static final String	DB_USER		= "root";
	private static final String	DB_PASSWORD	= "";

	public static Connection getInstance()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Erreur de chargement du pilote");
		}
		catch (SQLException e)
		{
			System.out.println("Echec de la connexion : " + e.getMessage());
		}

		return null;
	}
}
