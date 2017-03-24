package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Post;

public class PostDAO {
	
	public static final String NAME = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost/employeedb";
	public static final String ID = "root";
	public static final String PW = "i-standard";
	
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