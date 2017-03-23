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
import model.Department;

/**
 * DListServletサーブレットクラス
 * @author 高野
 * 部署情報一覧表示用
 */
@WebServlet("/DListServlet")
public class DListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/** 部署情報一覧を表示 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartmentDAO deparDAO = new DepartmentDAO();
		ArrayList<Department> deparList = deparDAO.list();
		request.setAttribute("deparList", deparList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/DepartmentList.jsp");
		dispatcher.forward(request, response);
	}
}