package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Utilisateur;

public class UtilisateurDao
{
	private static final ArrayList<Utilisateur>	utilisateurs			= new ArrayList<Utilisateur>();

	private static final String					SELECT_ALL_USERS_SQL	= "SELECT * FROM Utilisateur";
	private static final String					INSERT_USER_PSQL		= "INSERT INTO Utilisateur VALUES(0, ?, ?, ?, ?)";
	private static final String					DELETE_USER_SQL		= "DELETE FROM Utilisateur WHERE id=?";
	private static final String					MODIFIER_USER_SQL		= "UPDATE Utilisateur SET nom=?,prenom=?,login=?,password=? WHERE id=?";


	public static boolean ajouter(Utilisateur utilisateur)
	{
		Connection connection = ConnexionManager.getInstance();
		PreparedStatement statement = null;

		try
		{
			statement = connection.prepareStatement(INSERT_USER_PSQL);
			
			statement.setString(1, utilisateur.getNom());
			statement.setString(2, utilisateur.getPrenom());
			statement.setString(3, utilisateur.getLogin());
			statement.setString(4, utilisateur.getPassword());

			int status = statement.executeUpdate();

			if (status == 1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (SQLException e)
		{
			System.out.println("Erreur durant l'insertion de l'utilisateur : "
					+ e.getMessage());
		}
		finally
		{
			try
			{
				if (statement != null)
				{
					statement.close();
				}
			}
			catch (SQLException e)
			{
			}

			try
			{
				if (connection != null)
				{
					connection.close();
				}
			}
			catch (SQLException e)
			{
			}
		}

		return false;
	}

					
	

	public static boolean supprimer(int id)
	{
	
	Connection connection = ConnexionManager.getInstance();
	PreparedStatement statement = null;

	try {

	statement = connection.prepareStatement(DELETE_USER_SQL);
	
	statement.setInt(1,id);

   int status = statement.executeUpdate();

	if (status == 1)
	{
		return true;
	}
	else
	{
		return false;
	}
}
catch (SQLException e)
{
	System.out.println("Erreur durant la delete de l'utilisateur : "
			+ e.getMessage());
}
finally
{
	try
	{
		if (statement != null)
		{
			statement.close();
		}
	}
	catch (SQLException e)
	{
	}

	try
	{
		if (connection != null)
		{
			connection.close();
		}
	}
	catch (SQLException e)
	{
	}
}

return false;
}

	
	  public static boolean  modifier(int id ,String nom,String prenom,String login,String password) 
	  {

			Connection connection = ConnexionManager.getInstance();
			PreparedStatement statement = null;

			try
			{
				statement = connection.prepareStatement(MODIFIER_USER_SQL);
				statement.setInt(1,id);
				statement.setString(2 , nom);
				statement.setString(3 , prenom);
				statement.setString(4, login);
				statement.setString(5, password);
				int status = statement.executeUpdate();

				if (status == 1)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			catch (SQLException e)
			{
				System.out.println("Erreur durant la modification de l'utilisateur : "
						+ e.getMessage());
			}
			finally
			{
				try
				{
					if (statement != null)
					{
						statement.close();
					}
				}
				catch (SQLException e)
				{
				}

				try
				{
					if (connection != null)
					{
						connection.close();
					}
				}
				catch (SQLException e)
				{
				}
			}

			return false;
		}

	       

	

	public static ArrayList<Utilisateur> getList()
	{
		Connection connection = ConnexionManager.getInstance();

		Statement statement = null;
		ResultSet reponse = null;

		ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

		try
		{
			statement = connection.createStatement();
			reponse = statement.executeQuery(SELECT_ALL_USERS_SQL);

			int id;
			String nom, prenom, login, password;

			while (reponse.next())
			{
				id = reponse.getInt("id");
				nom = reponse.getString("nom");
				prenom = reponse.getString("prenom");
				login = reponse.getString("login");
				password = reponse.getString("password");

				utilisateurs
						.add(new Utilisateur(id, nom, prenom, login, password));
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (reponse != null)
				{
					reponse.close();
				}
			}
			catch (SQLException e)
			{
			}
			try
			{
				if (statement != null)
				{
					statement.close();
				}
			}
			catch (SQLException e)
			{
			}

			try
			{
				if (connection != null)
				{
					connection.close();
				}
			}
			catch (SQLException e)
			{
			}
		}

		return utilisateurs;
	}

	public static Utilisateur getById(int id)
	{
		for (Utilisateur utilisateur : utilisateurs)
		{
			if (utilisateur.getId() == id)
			{
				return utilisateur;
			}
		}

		return null;
	}

	public static Utilisateur getByLogin(String login)
	{
		for (Utilisateur utilisateur : utilisateurs)
		{
			if (utilisateur.getLogin().equals(login))
			{
				return utilisateur;
			}
		}

		return null;
	}
}
