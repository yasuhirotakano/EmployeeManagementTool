package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Post;

/**
 * PostDAO
 * @author 高野
 *　役職のデータベース操作
 */
public class PostDAO {
	
	/** PostDAOクラスのフィールド 定数 */
	public static final String NAME = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost/employeedb";
	public static final String ID = "root";
	public static final String PW = "i-standard";
	
	/**
	 * 役職一覧取得メソッド
	 * @return 役職一覧が入ってるPost型ArrayList
	 */
	public ArrayList<Post> list() {
		ArrayList<Post> postList = new ArrayList<Post>();
		Connection conn = null;
		
		try {
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL,ID,PW);
			String sql = "SELECT * FROM POST";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("POSTID");
				String name = rs.getString("POSTNAME");
				Post post = new Post(id, name);
				postList.add(post);
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
		return postList;
		
	}
	
	/**
	 * 役職取得メソッド
	 * @param empId 入力されたPOSTID
	 * @return 役職情報
	 */
	public Post select(int empId) {
		Post post = new Post();
		Connection conn = null;
		try {
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL,ID,PW);
			String sql = "SELECT * FROM POST WHERE POSTID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("POSTID");
				String name = rs.getString("POSTNAME");
				post = new Post(id, name);
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
		return post;
	}
}