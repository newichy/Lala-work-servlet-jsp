package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex.Fruit;


@WebServlet("/FruitServlet")
public class FruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Fruit fruit = new Fruit("いちご",700);
		request.setAttribute("fruit",fruit);
		
		String url = "/WEB-INF/ex/fruit.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
