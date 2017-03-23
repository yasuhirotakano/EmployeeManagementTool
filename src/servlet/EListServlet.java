package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EmployeeDAO;
import model.Employee;

/**
 * EListServletサーブレットクラス
 * @author 高野
 * 社員情報一覧表示用
 */
@WebServlet("/EListServlet")
public class EListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/** 社員情報一覧を表示 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDAO empDAO = new EmployeeDAO();
		ArrayList<Employee> empList = empDAO.list();
		request.setAttribute("empList", empList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/EmployeeList.jsp");
		dispatcher.forward(request, response);
	}
}