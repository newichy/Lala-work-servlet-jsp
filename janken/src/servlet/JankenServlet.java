package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/play")
public class JankenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/WEB-INF/jsp/game.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int com = (int) Math.floor(Math.random()*3);
		
		request.setCharacterEncoding("UTF-8");
		String _user = request.getParameter("user");
		int user = Integer.parseInt(_user);
		
		String msg = "";
		if(	(user + 1) % 3 == com) {
			msg = "あなたの勝ちです";
		} else if ( user == com ) {
			msg = "あいこ";
		} else {
			msg = "あなたの負けです";
		}
		
		String hand[] = {"グー","チョキ","パー"};
		msg += "<br>あなた　" + hand[user] + "<br>COM　" + hand[com];
		
		/*
		if(user == 0) {
			msg += "<br>USER:グー";
		} else if (user == 1) {
			msg += "<br>USER:チョキ";
		} else {
			msg += "<br>USER:パー";
		}
		
		
		if(com == 0) {
			msg += "<br>COM:グー";
		} else if (com == 1) {
			msg += "<br>COM:チョキ";
		} else {
			msg += "<br>COM:パー";
		}
		*/
		
		request.setAttribute("msg", msg);
		
		String url = "/WEB-INF/jsp/game.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
