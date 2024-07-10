package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Utilisateur;
import dao.UtilisateurDao;

public class AjoutUtilisateurForm
{
	private static final String	CHAMP_NOM			= "nom";
	private static final String	CHAMP_PRENOM		= "prenom";
	private static final String	CHAMP_LOGIN			= "login";
	private static final String	CHAMP_PASSWORD		= "password";
	private static final String	CHAMP_PASSWORD_BIS	= "passwordBis";

	private Utilisateur			utilisateur;
	private HttpServletRequest	request;
	private Map<String, String>	erreurs;
	private String				statusMessage;

	public AjoutUtilisateurForm(HttpServletRequest request)
	{
		this.request = request;
		this.erreurs = new HashMap<String, String>();
	}

	public boolean ajouter()
	{
		String nom = getParameter(CHAMP_NOM);
		String prenom = getParameter(CHAMP_PRENOM);
		String login = getParameter(CHAMP_LOGIN);
		String password = getParameter(CHAMP_PASSWORD);

		validerChamps(CHAMP_NOM, CHAMP_PRENOM, CHAMP_LOGIN, CHAMP_PASSWORD,
				CHAMP_PASSWORD_BIS);

		validerPasswords(CHAMP_PASSWORD, CHAMP_PASSWORD_BIS);

		if (erreurs.isEmpty())
		{
			utilisateur = new Utilisateur(nom, prenom, login, password);

			if (UtilisateurDao.ajouter(utilisateur))
			{
				utilisateur = null;
				statusMessage = "Ajout effectué avec succès !";

				return true;
			}
			else
			{
				statusMessage = "Une erreur inattendue s'est produite !";

				return false;
			}
		}
		else
		{
			utilisateur = new Utilisateur(nom, prenom, login, password);
			statusMessage = "Echec de l'ajout";

			return false;
		}
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

	private void validerChamps(String... champs)
	{
		for (String champ : champs)
		{
			if (getParameter(champ) == null)
			{
				erreurs.put(champ, "Vous devez renseigner ce champ");
			}
		}
	}

	private void validerPasswords(String champPassword, String champPasswordBis)
	{
		String password = getParameter(champPassword);
		String passwordBis = getParameter(champPasswordBis);

		if (password != null && !password.equals(passwordBis))
		{
			erreurs.put(champPassword,
					"Les mots de passe ne sont pas conformes");
			erreurs.put(champPasswordBis,
					"Les mots de passe ne sont pas conformes");
		}
	}

	public Utilisateur getUtilisateur()
	{
		return utilisateur;
	}

	public Map<String, String> getErreurs()
	{
		return erreurs;
	}

	public String getStatusMessage()
	{
		return statusMessage;
	}
}
