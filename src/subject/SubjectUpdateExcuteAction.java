package subject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import dao.SubjectDAO;
import tool.Action;


public class SubjectUpdateExcuteAction extends Action {
	public String execute (
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			try{

				String school_cd = request.getParameter("school_cd");
				String name = request.getParameter("name");
				String cd = request.getParameter("cd");


				Subject p = new Subject();
				p.setSchoolCd(school_cd);
				p.setName(name);
				p.setCd(cd);

				SubjectDAO dao=new SubjectDAO();
				int line =dao.update(p);

			} catch (Exception e) {
				e.printStackTrace(out);
		}
			return "subject_update_done.jsp";
	}
}