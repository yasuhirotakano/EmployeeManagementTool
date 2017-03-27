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
import model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Login.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int empId = Integer.parseInt(request.getParameter("id"));
		UserDAO userDAO = new UserDAO();
		boolean check = userDAO.selectC(empId);
		if(check) {
			String pass = request.getParameter("pass");
			User u = userDAO.select(empId);
			if(pass.equals(u.getPass())) {
				EmployeeDAO empDAO = new EmployeeDAO();
				Employee user = empDAO.select(u.getId());
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}else {
				request.setAttribute("check", false);
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Login.jsp");
				dispatcher.forward(request, response);
			}
		}else {
			request.setAttribute("check", check);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Login.jsp");
			dispatcher.forward(request, response);
		}
	}
}