package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EmployeeDAO;

/**
 * EDeleteServletサーブレットクラス
 * @author 高野
 * 社員情報削除用
 */
@WebServlet("/EDeleteServlet")
public class EDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/** 社員情報を削除 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String empId = request.getParameter("empId");
		EmployeeDAO empDAO = new EmployeeDAO();
		boolean error = empDAO.delete(empId);
		if(error) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/EListServlet");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("error", error);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/EmployeeList.jsp");
			dispatcher.forward(request, response);
		}
	}
}