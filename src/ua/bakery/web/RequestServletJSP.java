package ua.bakery.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.bakery.db.DAO.factory.DAOFactory;
import ua.bakery.db.jpa.Request;
import ua.bakery.db.jpa.User;

/**
 * Servlet implementation class RequestServletJSP
 */
@WebServlet("/RequestServletJSP")
public class RequestServletJSP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestServletJSP() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ClassCastException, ServletException, Exception, IOException {
		
		String name = request.getParameter("user");
		try {
			response.setContentType("text/html; charset=utf-8");
			List<Request> requests = (List<Request>) DAOFactory.getInstance().getRequestDAO().getRequestByUserRealName(name);
			
			request.setAttribute("requests", requests);
			request.setAttribute("title", "Заявки користувача: " + name);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} finally {
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stubtry
		try {
			processRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
