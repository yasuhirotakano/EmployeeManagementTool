package DAO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Image;

/**
 * ImageDAOクラス
 * @author 高野
 * 画像のデータベース操作
 */
public class ImageDAO {
	
	/** ImageDAOクラスのフィールド 定数 */
	public static final String NAME = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost/employeedb";
	public static final String ID = "root";
	public static final String PW = "i-standard";
	
	/**
	 * 画像取得メソッド
	 * @param imgId データベースの画像ID
	 * @return 画像情報が入ってるImage型のインスタンス
	 */
	public Image getImage(int imgId) {
		Image image = new Image();
		Connection conn = null;
		try {
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL,ID,PW);
			String sql = "SELECT * FROM IMAGE WHERE IMAGEID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, imgId);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("IMAGEID");
				InputStream name = rs.getBinaryStream("IMAGEDATA");
				ByteArrayOutputStream bout = new ByteArrayOutputStream();
			    byte [] a = new byte[1024];
			    
			    while(true) {
			        int len = 0;
			        
					try {
						len = name.read(a);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
			        if(len < 0) {
			            break;
			        }
			        
			        bout.write(a, 0, len);
			    }
			    
			    byte[] data = bout.toByteArray();
				image = new Image(id, data);
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
		return image;
	}
	
	/**
	 * 画像編集メソッド
	 * @param imageId データベースの画像ID
	 * @param inputStream 選択した画像データ
	 */
	public void edit(int imageId, InputStream inputStream) {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		byte[] data = new byte[1024];
		Connection conn = null;
		
		try {
			byte[] temp = new byte[1024];
			int size = 0;

			while (size >= 0) {
				size = inputStream.read(temp);

				if (size >= 0) {
					byteOut.write(temp, 0, size);
				}
				
			}
			
			inputStream.close();
			inputStream = null;
			byteOut.close();
			data = byteOut.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try{
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL, ID, PW);
			String sql = "UPDATE IMAGE SET IMAGEDATA=? WHERE IMAGEID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setBytes(1, data);
			pStmt.setInt(2, imageId);
			pStmt.executeUpdate();
			pStmt.close();
		}catch(SQLException e) {
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
	
	/**
	 * 画像新規追加メソッド
	 * @param 選択した画像データ
	 */
	public void create(InputStream inputStream) {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		byte[] data = new byte[1024];
		Connection conn = null;
		
		try {
			byte[] temp = new byte[1024];
			int size = 0;

			while (size >= 0) {
				size = inputStream.read(temp);

				if (size >= 0) {
					byteOut.write(temp, 0, size);
				}
				
			}
			
			inputStream.close();
			inputStream = null;
			byteOut.close();
			data = byteOut.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try{
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL, ID, PW);
			String sql = "INSERT INTO IMAGE(IMAGEDATA) VALUES(?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setBytes(1, data);
			pStmt.executeUpdate();
		}catch(SQLException e) {
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