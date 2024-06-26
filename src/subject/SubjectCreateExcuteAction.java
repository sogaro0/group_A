package subject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import dao.SubjectDAO;


@WebServlet(urlPatterns={"/subject/subject_create_excute_action"})
public class SubjectCreateExcuteAction extends HttpServlet {
	public void doGet (
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			try{

				String cd = request.getParameter("cd");
				String name = request.getParameter("name");


				Subject p = new Subject();
				p.setCd(cd);
				p.setName(name);

				SubjectDAO dao=new SubjectDAO();
				int line =dao.insert(p);

				request.getRequestDispatcher("subject_create_done.jsp")
				.forward(request,response);

			} catch (Exception e) {
				e.printStackTrace(out);
		}
	}
}