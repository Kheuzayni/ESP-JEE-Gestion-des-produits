package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import forms.ConnexionForm;

/**
 * Servlet implementation class Connexion
 */
@WebServlet({ "/login", "/logout" })
public class Connexion extends HttpServlet
{
	private static final long	serialVersionUID	= 1L;
	private static final String	VUE_LOGIN			= "/WEB-INF/login.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String path = request.getServletPath();
		switch (path)
		{
			case "/login":
				getServletContext().getRequestDispatcher(VUE_LOGIN)
						.forward(request, response);
				break;

			case "/logout":
				HttpSession session = request.getSession();
				session.invalidate();
				response.sendRedirect(request.getContextPath() + "/login");
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		ConnexionForm form = new ConnexionForm(request);
		if (form.connecter())
		{
			response.sendRedirect(request.getContextPath() + "/users/list");
		}
		else
		{
			request.setAttribute("form", form);
			getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request,
					response);
		}
	}

}
