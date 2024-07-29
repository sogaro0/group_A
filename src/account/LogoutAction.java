package account;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/account/logout_action"})
public class LogoutAction extends HttpServlet{
	public void doGet(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		try{
		HttpSession session=request.getSession();
//		セッションを破棄する
		if(session != null){
			session.invalidate();
			}
		request.getRequestDispatcher("/account/logout_done.jsp")
		.forward(request,response);

	} catch (Exception e) {
		e.printStackTrace(out);
		}
	}
}
