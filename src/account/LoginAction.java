package account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class LoginAction extends Action {

	public String execute(
			HttpServletRequest request, HttpServletResponse response
			)throws Exception{
		System.out.println("ログイン画面に遷移");
		return "login.jsp";
	}
}
