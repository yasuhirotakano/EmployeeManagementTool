package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Department;

/**
 * DepartmentDAOクラス
 * @author 高野aaa
 * 部署のデータベース操作
 */
public class DepartmentDAO {
	
	/** ImageDAOクラスのフィールド 定数 */
	public static final String NAME = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost/employeedb";
	public static final String ID = "root";
	public static final String PW = "i-standard";
	
	/**
	 * 部署一覧取得メソッド
	 * @return 部署一覧が入ってるDepartment型ArrayList
	 */
	public ArrayList<Department> list() {
		ArrayList<Department> deparList = new ArrayList<Department>();
		Connection conn = null;
		
		try {
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL,ID,PW);
			String sql = "SELECT * FROM DEPARTMENT";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("DEPARTMENTID");
				String name = rs.getString("DEPARTMENTNAME");
				Department department = new Department(id, name);
				deparList.add(department);
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
		return deparList;
		
	}
	
	/**
	 * 部署取得メソッド
	 * @param deparId 社員情報で登録されてる部署ID
	 * @return 部署情報が入ってるDepartment型のインスタンス
	 */
	public Department select(int deparId) {
		Department department = new Department();
		Connection conn = null;
		try {
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL,ID,PW);
			String sql = "SELECT * FROM DEPARTMENT WHERE DEPARTMENTID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deparId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("DEPARTMENTID");
				String name = rs.getString("DEPARTMENTNAME");
				department = new Department(id, name);
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
		return department;
	}
	
	/**
	 * 部署編集メソッド
	 * @param departmentId 登録されてる部署ID
	 * @param departmentName 入力されてる部署名
	 * @return 登録の成功、失敗 true=成功 false=失敗
	 */
	public boolean edit(int departmentId, String departmentName) {
		Connection conn = null;
		boolean result = false;
		
		try {
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL,ID,PW);
			String sql = "UPDATE DEPARTMENT SET DEPARTMENTNAME=? WHERE DEPARTMENTID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, departmentName);
			pstmt.setInt(2, departmentId);
			int item = pstmt.executeUpdate();
			result = (item > 0);
			pstmt.close();
		}catch(SQLException e) {
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
	 * @param departmentName 入力されてる部署名
	 * @return 登録の成功、失敗 true=成功 false=失敗
	 */
	public boolean create(String departmentName) {
		Connection conn = null;
		boolean result = false;
		try {
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL,ID,PW);
			String sql = "INSERT INTO DEPARTMENT(DEPARTMENTNAME) VALUES(?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, departmentName);
			int item = pstmt.executeUpdate();
			result = (item > 0);
			pstmt.close();
		}catch(SQLException e) {
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
	 * 部署削除メソッド
	 * @param departmentId 登録されてる部署ID
	 * @return 削除の成功、失敗 true=成功 false=失敗
	 */
	public boolean delete(int departmentId) {
		Connection conn = null;
		boolean result = false;
		
		try {
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL,ID,PW);
			conn.setAutoCommit(false);
			String sql = "DELETE FROM DEPARTMENT WHERE DEPARTMENTID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, departmentId);
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
}