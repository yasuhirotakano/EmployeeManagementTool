package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

/**
 * UserDAOクラス
 * @author 高野
 * ユーザーのデータベース操作
 */
public class UserDAO {
	
	/** UserDAOクラスのフィールド 定数 */
	public static final String NAME = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost/employeedb";
	public static final String ID = "root";
	public static final String PW = "i-standard";
	
	public boolean create(int id, String pass) {
		boolean result = false;
		Connection conn = null;
		
		try {
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL,ID,PW);
			conn.setAutoCommit(false);
			String sql = "INSERT INTO USER(ID, PASS) VALUES(?, HEX(AES_ENCRYPT(?, 'i-standard')))";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);
			pStmt.setString(2, pass);
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
	
	public User select(int empId) {
		User user = new User();
		Connection conn = null;
		
		try {
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL,ID,PW);
			String sql = "SELECT ID, CONVERT( AES_DECRYPT( UNHEX( PASS ) , 'i-standard' ) USING utf8 ) PASS FROM USER WHERE ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				String pass = rs.getString("PASS");
				user = new User(id, pass);
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
		return user;
		
	}
	
	public boolean selectC(int empId) {
		boolean check;
		Connection conn = null;
		
		try {
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL,ID,PW);
			String sql = "SELECT * FROM USER WHERE ID = ?";
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
	
	public void delete() {
		Connection conn = null;
		
		try {
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL,ID,PW);
			conn.setAutoCommit(false);
			String sql = "DELETE FROM USER";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
		}catch(SQLException e) {
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
}