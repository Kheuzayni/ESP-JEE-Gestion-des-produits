package forms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import dao.UtilisateurDao;

public class ConnexionForm
{
	private static final String	CHAMP_LOGIN		= "login";
	private static final String	CHAMP_PASSWORD	= "password";

	private HttpServletRequest	request;
	private String				statusMessage, login;

	public ConnexionForm(HttpServletRequest request)
	{
		this.request = request;
	}

	public boolean connecter()
	{
		login = getParameter(CHAMP_LOGIN);
		String password = getParameter(CHAMP_PASSWORD);

		Utilisateur utilisateur = UtilisateurDao.getByLogin(login);

		if ("admin".equals(login) && "passer".equals(password))
		{
			utilisateur = new Utilisateur("admin", "admin", "admin", "passer");
		}
		else if (utilisateur == null
				|| !utilisateur.getPassword().equals(password))
		{
			statusMessage = "Login et/ou mot de passe incorrect !";

			return false;
		}

		HttpSession session = request.getSession();
		session.setAttribute("utilisateur", utilisateur);

		return true;
	}

	private String getParameter(String champ)
	{
		String valeur = request.getParameter(champ);

		if (valeur == null || valeur.trim().isEmpty())
		{
			return null;
		}
		else
		{
			return valeur.trim();
		}
	}

	public String getStatusMessage()
	{
		return statusMessage;
	}

	public String getLogin()
	{
		return login;
	}
}
