package ua.bakery.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.bakery.db.DAO.factory.DAOFactory;
import ua.bakery.db.jpa.User;

/**
 * Servlet implementation class RequestServletJSP
 */
@WebServlet("/IndexServletJSP")
public class IndexServletJSP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServletJSP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		List<User> users = (List<User>) DAOFactory.getInstance().getUserDAO().getAll();
		String select = "<select name=\"user\">";
		
		for(User user : users){
			select += "<option id = " + user.getId() + " >" + user.getRealName() + "</option>";
		}
		select += "</select>";
		
		request.setAttribute("selectUser", select);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}