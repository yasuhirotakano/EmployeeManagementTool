package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DepartmentDAO;
import DAO.EmployeeDAO;
import model.Department;
import model.Employee;

/**
 * SearchServletサーブレットクラス
 * @author 高野
 * 検索用
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/** 検索ページを表示させる */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartmentDAO deparDAO = new DepartmentDAO();
		ArrayList<Department> deparList = deparDAO.list();
		request.setAttribute("deparList", deparList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Search.jsp");
		dispatcher.forward(request, response);
	}
	
	/** 検索フォームに入力した値で検索をし、結果を表示させる */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int departmentId = Integer.parseInt(request.getParameter("departmentId"));
		EmployeeDAO empDAO = new EmployeeDAO();
		int intId;
		
		if(id.equals("")) {
			intId = 0;
		}else {
			intId = Integer.parseInt(id);
		}
		
		ArrayList<Employee> empList = empDAO.Search(intId, name, departmentId);
		
		if(empList == null || empList.size() == 0) {
			boolean lCheck = true;
			request.setAttribute("lCheck", lCheck);
		}
		
		request.setAttribute("empList", empList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/EmployeeList.jsp");
		dispatcher.forward(request, response);
	}
}