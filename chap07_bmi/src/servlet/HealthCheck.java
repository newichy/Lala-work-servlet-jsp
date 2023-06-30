package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Health;
import model.HealthCheckLogic;

@WebServlet("/HealthCheck")
public class HealthCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/WEB-INF/jsp/healthCheck.jsp";		// 入力画面へフォワード
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// リクエストパラメータを取得
		String weight = request.getParameter("weight");
		String height = request.getParameter("height");
		
		// 入力値をプロパティに設定（データモデル）
		Health health = new Health();
		health.setHeight(Double.parseDouble(height));		// Double.parseDouble()
		health.setWeight(Double.parseDouble(weight));
		
		// 診断を実行し結果を設定（ロジックモデル）
		HealthCheckLogic HCL = new HealthCheckLogic();
		HCL.execute(health);
		
		// リクエストスコープに保存
		request.setAttribute("health", health);
		
		// フォワード
		String url = "/WEB-INF/jsp/healthCheckResult.jsp";
		request.getRequestDispatcher(url).forward(request, response);	
	}

}
