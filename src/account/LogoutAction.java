package account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class LogoutAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response
			)throws Exception{
		System.out.println("ログアウト画面に遷移");
		HttpSession session=request.getSession();
//		セッションを破棄する
		if(session != null){
			session.invalidate();
			        }

		return "logout.jsp";
	}


}
