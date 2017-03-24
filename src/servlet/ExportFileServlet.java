package servlet;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EmployeeDAO;
import model.Employee;

/**
 * ExportFileServletサーブレットクラス
 * @author 高野
 * CSVファイル保存用
 */
@WebServlet("/ExportFileServlet")
public class ExportFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/** CSVファイル保存 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDAO empDAO = new EmployeeDAO();
		ArrayList<Employee> empList = empDAO.list();
		if(empList != null && empList.size() > 0) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(baos));
			String str = "社員ID,名前,年齢,生年月日,性別,電話番号,郵便番号,都道府県,住所,所属部署ID,役職ID,最寄駅,入社日,退社日\n";
			bw.write(str);
			
			for (Employee employee : empList) {
				StringBuffer sb = new StringBuffer();
				sb.append(employee.getId());
				sb.append(",");
				sb.append(employee.getName());
				sb.append(",");
				sb.append(employee.getAge());
				sb.append(",");
				sb.append(employee.getBirthDay());
				sb.append(",");
				sb.append(employee.getGender());
				sb.append(",");
				sb.append(employee.getPhoneNumber());
				sb.append(",");
				sb.append(employee.getPostalCode());
				sb.append(",");
				sb.append(employee.getPrefectures());
				sb.append(",");
				sb.append(employee.getAddress());
				sb.append(",");
				sb.append(employee.getDepartmentId());
				sb.append(",");
				sb.append(employee.getPostId());
				sb.append(",");
				sb.append(employee.getNearestStation());
				sb.append(",");
				String day = employee.getEnteringDay();
				sb.append(day != null ? day : "");
				sb.append(",");
				day = employee.getLeavingDay();
				sb.append(day != null ? day : "");
				sb.append("\n");
				bw.write(sb.toString());
			}
			
			bw.flush();
			bw.close();
			response.setContentType("application/octet-stream; charset=UTF-8");
			response.setHeader("Content-Disposition","attachment; filename=\"employee.csv\"");
			response.setContentLength(baos.size());
			ServletOutputStream os = response.getOutputStream();
			os.write(baos.toByteArray());
			os.close();
		}
	}
}