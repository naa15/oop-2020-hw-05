
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accmanager.AccountManager;

/**
 * Servlet implementation class NewAccServlet
 */
public class NewAccServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewAccServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		AccountManager accountManager = (AccountManager) getServletContext().getAttribute("accs");
		request.setAttribute("name", username);
		if (accountManager.checkAccount(username)) {

			RequestDispatcher rd = request.getRequestDispatcher("/AccountAlreadyExists.jsp");
			rd.forward(request, response);
		} else {
			if (username.length() == 0 || password.length() == 0) {
				RequestDispatcher rd = request.getRequestDispatcher("/NewAccount.html");
				rd.forward(request, response);
			} else {
				accountManager.addUser(username, password);
				RequestDispatcher rd = request.getRequestDispatcher("/Welcome.jsp");
				rd.forward(request, response);
			}
		}
	}

}
