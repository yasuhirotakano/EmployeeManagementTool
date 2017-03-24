package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.DepartmentDAO;
import DAO.EmployeeDAO;
import DAO.ImageDAO;
import DAO.PostDAO;
import model.Department;
import model.Employee;
import model.Post;

/**
 * EEditServleサーブレットクラス
 * @author 高野
 * 社員情報編集、新規追加用
 */
@WebServlet("/EEditServlet")
@MultipartConfig()
public class EEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/** 編集ボタン押したときに該当する社員情報を表示 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String check = request.getParameter("check");
		EmployeeDAO empDAO = new EmployeeDAO();
		DepartmentDAO deparDAO = new DepartmentDAO();
		PostDAO postDAO = new PostDAO();
		ArrayList<Post> postList = postDAO.list();
		ArrayList<Department> deparList = deparDAO.list();
		
		if(check.equals("編集")) {
			boolean judge = false;
			int empId = Integer.parseInt(request.getParameter("empId"));
			Employee employee = empDAO.select(empId);
			
			if(employee.getGender().equals("男")) {
				judge = true;
			}
			
			request.setAttribute("judge", judge);
			request.setAttribute("employee", employee);
		}
		
		request.setAttribute("postList", postList);
		request.setAttribute("deparList", deparList);
		request.setAttribute("check", check);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/EmployeeEdit.jsp");
		dispatcher.forward(request, response);
	}
	
	/** 編集、または新規追加した社員情報をデータベースに保存 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String check = request.getParameter("check");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String birthDay = request.getParameter("birthDay");
		String gender = request.getParameter("gender");
		String phoneNumber = request.getParameter("phoneNumber");
		String postalCode = request.getParameter("postalCode");
		String prefectures = request.getParameter("prefectures");
		String address = request.getParameter("address");
		int departmentId = Integer.parseInt(request.getParameter("departmentId"));
		int postId = Integer.parseInt(request.getParameter("postId"));
		String nearestStation = request.getParameter("nearestStation");
		String enteringDay = request.getParameter("enteringDay");
		String leavingDay = request.getParameter("leavingDay");
		Part imageData = request.getPart("imageData");
		EmployeeDAO empDAO = new EmployeeDAO();
		ImageDAO imgDAO = new ImageDAO();
		String result = "成功";
		boolean error = false;
		boolean choice = true;
		
		if(check.equals("編集")) {
			int id = Integer.parseInt(request.getParameter("id"));
			error = empDAO.edit(name, age, birthDay, gender, phoneNumber, postalCode, prefectures, address, departmentId, postId, nearestStation, enteringDay, leavingDay, id);
			imgDAO.edit(imageData.getInputStream(), id);
		}else {
			error = empDAO.create(name, age, birthDay, gender, phoneNumber, postalCode, prefectures, address, departmentId, postId, nearestStation, enteringDay, leavingDay);
			imgDAO.create(imageData.getInputStream());
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