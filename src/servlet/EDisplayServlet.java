package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DepartmentDAO;
import DAO.EmployeeDAO;
import DAO.PostDAO;
import model.Department;
import model.Employee;
import model.Post;

@WebServlet("/EDisplayServlet")
public class EDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int empId = Integer.parseInt(request.getParameter("empId"));
		EmployeeDAO empDAO = new EmployeeDAO();
		DepartmentDAO deparDAO = new DepartmentDAO();
		PostDAO postDAO = new PostDAO();
		Employee employee = empDAO.select(empId);
		Department department = deparDAO.select(employee.getId());
		Post post = postDAO.select(employee.getId());
		request.setAttribute("post", post);
		request.setAttribute("department", department);
		request.setAttribute("employee", employee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/EmployeeDisplay.jsp");
		dispatcher.forward(request, response);
	}
}