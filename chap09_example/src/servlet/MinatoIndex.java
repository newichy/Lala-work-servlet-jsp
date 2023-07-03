package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SiteEV;
import model.SiteEVLogic;


@WebServlet("/MinatoIndex")
public class MinatoIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// アプリケーションスコープに保存されたサイト評価を取得
		ServletContext application = this.getServletContext();
		SiteEV siteEV = (SiteEV) application.getAttribute("siteEV");
		
		// サイト評価を初期化（初回リクエスト時）
		if(siteEV == null) {	//初回
			siteEV = new SiteEV();
		}
		
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		// サイト評価処理
		SiteEVLogic siteEVLogic = new SiteEVLogic();
		if(action != null && action.equals("like")) {	// 初回アクセス時点での評価はnull
			siteEVLogic.like(siteEV);
		} else if (action != null && action.equals("dislike")) {
			siteEVLogic.dislike(siteEV);
		}
		
		// アプリケーションスコープに保存
		application.setAttribute("siteEV", siteEV);
		
		// フォワード
		String url = "/WEB-INF/jsp/minatoIndex.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
