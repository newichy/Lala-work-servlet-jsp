package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SampleServlet")
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 運勢
		String[] luckArray = {"超スッキリ","スッキリ","最悪"};
		int index = (int)(Math.random()*3);
		String luck = luckArray[index];
		
		// 実行日
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
		String today =sdf.format(date);
		
		// HTML出力
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head><meta charaset='utf-8'>");
		out.print("<title>スッキリ占い</title>");
		out.print("</head><body>");
		out.print("<p>"+ today + "の運勢は「" + luck + "」です。</p>");
		out.print("</body></html>");
	}

}
