package subject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import dao.SubjectDAO;
import tool.Action;


public class SubjectUpdateAction extends Action {
	public String execute (
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			try{

				SubjectDAO dao2=new SubjectDAO();
				List<Subject> list2=dao2.all();
				//subject_list.jspから受けった値もsubject_update.jspに渡す
				request.getParameter("school_cd");
				request.getParameter("cd");
				request.getParameter("name");

				request.setAttribute("subject", list2);


			} catch (Exception e) {
				e.printStackTrace(out);
		}
			return "subject_update.jsp";
	}
}