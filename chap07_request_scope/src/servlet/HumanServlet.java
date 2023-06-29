package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Human;

@WebServlet("/human")
public class HumanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Human h = new Human("桃太郎", 24);
		request.setAttribute("human", h);
		
		request.getRequestDispatcher("/WEB-INF/human.jsp").forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String _age = request.getParameter("age");
		int age = Integer.parseInt(_age);
		
		Human h = new Human(name, age);
		request.setAttribute("human", h);
		request.getRequestDispatcher("/WEB-INF/human.jsp").forward(request,response);
		
	}
}
