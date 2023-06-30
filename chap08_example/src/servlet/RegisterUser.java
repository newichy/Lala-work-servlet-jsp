package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterUserLogic;
import model.User;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// フォワード先
		String forwardPath = null;

		// ★リクエストパラメータから「action」の値を取得	→	処理の切り替え！
		String action = request.getParameter("action");
		
		
		if(action == null) {										// 初回位アクセス時「action」がnull
		
			forwardPath = "/WEB-INF/jsp/registerForm.jsp";			// フォワード先
		
		} else if (action.equals("done")) {							// 「action」がdoneの時
			
			// セッションスコープに保存された登録ユーザーを取得
			HttpSession session = request.getSession();
			User registerUser = (User) session.getAttribute("registerUser");
			
			// 登録処理
			RegisterUserLogic logic = new RegisterUserLogic();
			logic.execute(registerUser);
			
			// 不要となったセッションスコープ内のインスタンスを削除
			session.removeAttribute("registerUser");
			
			// 登録後のフォワード先
			forwardPath = "/WEB-INF/jsp/registerDone.jsp";
		}
		
		// フォワード先にフォワード
		request.getRequestDispatcher(forwardPath).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		// 登録するユーザーの情報を設定
		User registerUser = new User(id,name,pass);
		
		// セッションスコープに登録ユーザーを保存
		HttpSession session = request.getSession();
		session.setAttribute("registerUser", registerUser);
		
		//フォワード
		String url = "/WEB-INF/jsp/registerConfirm.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
