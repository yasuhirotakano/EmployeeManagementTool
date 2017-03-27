package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.EmployeeDAO;
import DAO.UserDAO;
import model.Employee;

@WebServlet("/NewLoginServlet")
public class NewLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/NewLogin.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int empId = Integer.parseInt(request.getParameter("id"));
		EmployeeDAO empDAO = new EmployeeDAO();
		Employee user;
		boolean check = empDAO.selectC(empId);
		if(check) {
			user = empDAO.select(empId);
			String password = request.getParameter("password");
			UserDAO userDAO = new UserDAO();
			boolean check2 = userDAO.create(empId, password);
			if(check2) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
			}else {
				request.setAttribute("check", false);
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/NewLogin.jsp");
				dispatcher.forward(request, response);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("check", check);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/NewLogin.jsp");
			dispatcher.forward(request, response);
		}
	}
}