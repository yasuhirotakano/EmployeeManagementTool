package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Employee;

/**
 * EmployeeDAOクラス
 * @author 高野
 * 社員のデータベース操作
 */
public class EmployeeDAO {
	
	/** ImageDAOクラスのフィールド 定数 */
	public static final String NAME = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost/employeedb";
	public static final String ID = "root";
	public static final String PW = "i-standard";
	
	/**
	 * 社員一覧取得メソッド
	 * @return 社員一覧が入ってるEmployee型ArrayList
	 */
	public ArrayList<Employee> list() {
		ArrayList<Employee> empList = new ArrayList<Employee>();
		Connection conn = null;
		
		try {
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL,ID,PW);
			String sql = "SELECT * FROM EMPLOYEE";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				String birthDay = rs.getString("BIRTHDAY");
				String gender = rs.getString("GENDER");
				String phoneNumber = rs.getString("PHONENUMBER");
				String postalCode = rs.getString("POSTALCODE");
				String prefectures = rs.getString("PREFECTURES");
				String address = rs.getString("ADDRESS");
				int departmentId = rs.getInt("DEPARTMENTID");
				int postId = rs.getInt("POSTID");
				String nearestStation = rs.getString("NEARESTSTATION");
				String enteringDay = rs.getString("ENTERINGDAY");
				String leavingDay = rs.getString("LEAVINGDAY");
				Employee employee = new Employee(id, name, age, birthDay, gender, phoneNumber, postalCode, prefectures, address,
						departmentId, postId, nearestStation, enteringDay, leavingDay);
				empList.add(employee);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}finally {
			if(conn != null) {
				
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
				
			}
		}
		return empList;
		
	}
	
	/**
	 * 社員取得メソッド
	 * @param empId 社員情報で登録されてるID
	 * @return 社員情報が入ってるDepartment型のインスタンス
	 */
	public Employee select(int empId) {
		Employee employee = new Employee();
		Connection conn = null;
		
		try {
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL,ID,PW);
			String sql = "SELECT * FROM EMPLOYEE WHERE ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				String birthDay = rs.getString("BIRTHDAY");
				String gender = rs.getString("GENDER");
				String phoneNumber = rs.getString("PHONENUMBER");
				String postalCode = rs.getString("POSTALCODE");
				String prefectures = rs.getString("PREFECTURES");
				String address = rs.getString("ADDRESS");
				int departmentId = rs.getInt("DEPARTMENTID");
				int postId = rs.getInt("POSTID");
				String nearestStation = rs.getString("NEARESTSTATION");
				String enteringDay = rs.getString("ENTERINGDAY");
				String leavingDay = rs.getString("LEAVINGDAY");
				employee = new Employee(id, name, age, birthDay, gender, phoneNumber, postalCode, prefectures, address,
						departmentId, postId, nearestStation, enteringDay, leavingDay);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}finally {
			if(conn != null) {
				
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
				
			}
		}
		return employee;
		
	}
	
	/**
	 * 部署編集メソッド
	 * @param id 入力されてる社員ID
	 * @param name 入力されてる名前
	 * @param age 入力されてる年齢
	 * @param gender 選択されてる性別
	 * @param postalCode 入力されてる郵便番号
	 * @param prefectures 選択されてる都道府県
	 * @param address 入力されてる住所
	 * @param departmentId 選択されてる部署ID
	 * @param enteringDay 入力されてる入社日
	 * @param leavingDay 入力されてる退社日
	 * @param imageId 登録されてる社員情報の部署ID
	 * @return 登録の成功、失敗 true=成功 false=失敗
	 */
	public boolean edit(String name, int age, String birthDay, String gender, String phoneNumber, String postalCode, String prefectures, String address, int departmentId, int postId, String nearestStation, String enteringDay, String leavingDay, int id) {
		Connection conn = null;
		boolean result = false;
		
		try {
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL,ID,PW);
			conn.setAutoCommit(false);
			String sql = "UPDATE EMPLOYEE SET NAME=?, AGE=?, BIRTHDAY=?, GENDER=?, PHONENUMBER=?, POSTALCODE=?, PREFECTURES=?, ADDRESS=?, DEPARTMENTID=?, POSTID=?, NEARESTSTATION=?, ENTERINGDAY=?, LEAVINGDAY=? WHERE ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setInt(2, age);
			pStmt.setString(3, birthDay);
			pStmt.setString(4, gender);
			pStmt.setString(5, phoneNumber);
			pStmt.setString(6, postalCode);
			pStmt.setString(7, prefectures);
			pStmt.setString(8, address);
			pStmt.setInt(9, departmentId);
			pStmt.setInt(10, postId);
			pStmt.setString(11, nearestStation);
			pStmt.setString(12, enteringDay);
			pStmt.setString(13, leavingDay);
			pStmt.setInt(14, id);
			int item = pStmt.executeUpdate();
			result = (item > 0);
			conn.commit();
			
		}catch(SQLException e) {
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				return result;
			}
			
			e.printStackTrace();
			return result;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return result;
		}finally {
			if(conn != null) {
				
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return result;
				}
				
			}
		}
		return result;
		
	}
	
	/**
	 * 部署新規追加メソッド
	 * @param id 入力されてる社員ID
	 * @param name 入力されてる名前
	 * @param age 入力されてる年齢
	 * @param gender 選択されてる性別
	 * @param postalCode 入力されてる郵便番号
	 * @param prefectures 選択されてる都道府県
	 * @param address 入力されてる住所
	 * @param departmentId 選択されてる部署ID
	 * @param enteringDay 入力されてる入社日
	 * @param leavingDay 入力されてる退社日
	 * @return 登録の成功、失敗 true=成功 false=失敗
	 */
	public boolean create(String name, int age, String birthDay, String gender, String phoneNumber, String postalCode, String prefectures, String address, int departmentId, int postId, String nearestStation, String enteringDay, String leavingDay) {
		boolean result = false;
		Connection conn = null;
		
		try {
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL,ID,PW);
			conn.setAutoCommit(false);
			String sql = "INSERT INTO EMPLOYEE(NAME, AGE, BIRTHDAY, GENDER, PHONENUMBER, POSTALCODE, PREFECTURES, ADDRESS, DEPARTMENTID, POSTID, NEARESTSTATION, ENTERINGDAY, LEAVINGDAY) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setInt(2, age);
			pStmt.setString(3, birthDay);
			pStmt.setString(4, gender);
			pStmt.setString(5, phoneNumber);
			pStmt.setString(6, postalCode);
			pStmt.setString(7, prefectures);
			pStmt.setString(8, address);
			pStmt.setInt(9, departmentId);
			pStmt.setInt(10, postId);
			pStmt.setString(11, nearestStation);
			pStmt.setString(12, enteringDay);
			pStmt.setString(13, leavingDay);
			int item = pStmt.executeUpdate();
			result = (item > 0);
			pStmt.close();
			conn.commit();
			
		}catch(SQLException e) {
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				return result;
			}
			
			e.printStackTrace();
			return result;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return result;
		}finally {
			if(conn != null) {
				
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return result;
				}
				
			}
		}
		return result;
		
	}
	
	/**
	 * 社員削除メソッド
	 * @param empId 登録されてる社員ID
	 * @return 削除の成功、失敗 true=成功 false=失敗
	 */
	public boolean delete(int empId) {
		Connection conn = null;
		boolean result = false;
		
		try {
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL,ID,PW);
			conn.setAutoCommit(false);
			String sql = "DELETE FROM EMPLOYEE WHERE ID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empId);
			int item = pstmt.executeUpdate();
			result = (item > 0);
			conn.commit();
			pstmt.close();
		}catch(SQLException e) {
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				return result;
			}
			
			e.printStackTrace();
			return result;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return result;
		}finally {
			if(conn != null) {
				
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return result;
				}
				
			}
		}
		return result;
		
	}
	
	/**
	 * 社員検索メソッド
	 * @param id 入力された社員ID
	 * @param name 入力された名前
	 * @param departmentId 選択された部署ID
	 * @return 検索結果で該当する社員一覧をEmployee型ArrayListに入れてる
	 */
	public ArrayList<Employee> Search(int id, String name, int departmentId) {
		ArrayList<Employee> empList = new ArrayList<Employee>();
		Connection conn = null;
		
		try {
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL,ID,PW);
			String sql = "SELECT ID,NAME FROM EMPLOYEE";
			String sql2 = " WHERE";
			String sql3 = " ID=?";
			String sql4 = " AND";
			String sql5 = " NAME LIKE ?";
			String sql6 = " DEPARTMENTID=?";
			
			if(id != 0 || name != "" || departmentId != 0) {
				sql += sql2;
			}
			
			if(id != 0) {
				sql += sql3;
			}
			
			if(id != 0 && name != "") {
				sql += sql4;
				sql += sql5;
			}else if(name != ""){
				sql += sql5;
			}
			
			if(name != "" && departmentId != 0 || id != 0 && departmentId != 0) {
				sql += sql4;
				sql += sql6;
			}else if(departmentId != 0) {
				sql += sql6;
			}
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			if(id != 0) {
				pStmt.setInt(1, id);
			}
			
			if(id != 0 && name != "") {
				pStmt.setString(2, "%"+name+"%");
			}else if(name != ""){
				pStmt.setString(1, "%"+name+"%");
			}
			
			if(id != 0 && name != "" && departmentId != 0) {
				pStmt.setInt(3, departmentId);
			}else if(name != "" && departmentId != 0 || id != 0 && departmentId != 0) {
				pStmt.setInt(2, departmentId);
			}else if(departmentId != 0) {
				pStmt.setInt(1, departmentId);
			}
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				int intId = rs.getInt("ID");
				String names = rs.getString("NAME");
				Employee employee = new Employee(intId, names);
				empList.add(employee);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}finally {
			if(conn != null) {
				
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
				
			}
		}
		return empList;
		
	}
	
	public boolean selectC(int empId) {
		boolean check;
		Connection conn = null;
		
		try {
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL,ID,PW);
			String sql = "SELECT * FROM EMPLOYEE WHERE ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empId);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				check = true;
			}else {
				check = false;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}finally {
			if(conn != null) {
				
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return false;
				}
				
			}
		}
		return check;
		
	}
}