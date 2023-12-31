package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Human;


@WebServlet("/SampleServlet")
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext application = this.getServletContext();	// thisはこのサーバー
		Human human = new Human("湊 雄介",23);
		application.setAttribute("human", human);
		
		String url = "/WEB-INF/jsp/human.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}


}
