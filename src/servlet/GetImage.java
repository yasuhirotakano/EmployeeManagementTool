package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ImageDAO;
import model.Image;

/**
 * GetImageサーブレットクラス
 * @author 高野
 * 画像取得用
 */
@WebServlet("/GetImage")
@MultipartConfig()
public class GetImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/** 画像を取得する */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int imgId = Integer.parseInt(request.getParameter("id"));
		ImageDAO imgDAO = new ImageDAO();
		Image img = imgDAO.getImage(imgId);
		byte[] imgByte = img.getImageData();
		response.setContentType("image/jpg");
		ServletOutputStream sos = response.getOutputStream();
		sos.write(imgByte, 0, imgByte.length);
	}
}