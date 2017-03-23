package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DepartmentDAO;

/**
 * DDeleteServletサーブレットクラス
 * @author 高野
 * 部署情報削除用
 */
@WebServlet("/DDeleteServlet")
public class DDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/** 部署情報を削除 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int departmentId = Integer.parseInt(request.getParameter("deparId"));
		DepartmentDAO deparDAO = new DepartmentDAO();
		boolean error = deparDAO.delete(departmentId);
		
		if(error) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/DListServlet");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("error", error);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/DepartmentList.jsp");
			dispatcher.forward(request, response);
		}
		
	}
}