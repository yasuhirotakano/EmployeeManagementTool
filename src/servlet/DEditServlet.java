package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DepartmentDAO;
import model.Department;

/**
 * DEditServletサーブレットクラス
 * @author 高野
 * 部署情報編集、新規追加用
 */
@WebServlet("/DEditServlet")
public class DEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/** 編集ボタン押したときに該当する部署情報を表示 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String check = request.getParameter("check");
		DepartmentDAO deparDAO = new DepartmentDAO();
		
		if(check.equals("編集")) {
			int deparId = Integer.parseInt(request.getParameter("deparId"));
			Department department = deparDAO.select(deparId);
			request.setAttribute("department", department);
		}
		
		request.setAttribute("check", check);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/DepartmentEdit.jsp");
		dispatcher.forward(request, response);
	}
	
	/** 編集、または新規追加した部署情報をデータベースに保存 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String check = request.getParameter("check");
		String departmentName = request.getParameter("departmentName");
		DepartmentDAO deparDAO = new DepartmentDAO();
		String result = "成功";
		boolean error = false;
		boolean choice = false;
		
		if(check.equals("編集")) {
			int departmentId = Integer.parseInt(request.getParameter("departmentId"));
			error = deparDAO.edit(departmentId, departmentName);
		}else {
			error = deparDAO.create(departmentName);
		}
		
		if(error != true) {
			result = "失敗";
		}
		
		request.setAttribute("choice", choice);
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Result.jsp");
		dispatcher.forward(request, response);
	}
}