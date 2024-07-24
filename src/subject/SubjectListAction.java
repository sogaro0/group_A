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


public class SubjectListAction extends Action {
	public String execute (
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {

			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();

			try{

			    // h2コンソールから学生のリストを取得
				SubjectDAO dao=new SubjectDAO();
				List<Subject> list=dao.all();

				// アトリビュート
				request.setAttribute("subject", list);

			} catch (Exception e) {
				e.printStackTrace(out);
		}
			return "subject_list.jsp";
	}

}
