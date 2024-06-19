package subject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import dao.SubjectDAO;


@WebServlet(urlPatterns={"/subject/subject_list_action"})
public class SubjectListAction extends HttpServlet {
	public void doGet (
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
				request.getRequestDispatcher("subject_list.jsp")
				.forward(request,response);

			} catch (Exception e) {
				e.printStackTrace(out);
		}
	}

}
