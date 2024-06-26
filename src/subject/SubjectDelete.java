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


@WebServlet(urlPatterns={"/subject/subject_delete"})
public class SubjectDelete extends HttpServlet {
	public void doGet (
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			try{

				String cd = request.getParameter("cd");

				Subject p = new Subject();
				p.setCd(cd);

				SubjectDAO dao=new SubjectDAO();
				int line =dao.delete(p);

				request.getRequestDispatcher("subject_delete_done.jsp")
				.forward(request,response);

			} catch (Exception e) {
				e.printStackTrace(out);
		}
	}
}