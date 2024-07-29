package subject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import dao.SubjectDAO;
import tool.Action;


public class SubjectCreateExcuteAction extends Action {
	public String execute (
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			try{

				String cd = request.getParameter("cd");
				String name = request.getParameter("name");

//				エラーメッセージの文字列
				String message="";
//				科目コードの文字数を調べる
				int count = cd.length();

				if (count > 3){
					message = "科目コードが2文字以上です";

					request.setAttribute("message", message);
					request.getRequestDispatcher("subject_create.jsp")
					.forward(request,response);
				}else if(count < 3){
					message = "科目コードが4文字以下です";

					request.setAttribute("message", message);
					request.getRequestDispatcher("subject_create.jsp")
					.forward(request,response);
				}else{
					Subject p = new Subject();
					p.setCd(cd);
					p.setName(name);

					SubjectDAO dao=new SubjectDAO();
					int line =dao.insert(p);

					request.setAttribute("message", message);
					}

			} catch (Exception e) {
				e.printStackTrace(out);
		}
			return "subject_create_done.jsp";
	}
}