package no_student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;


@WebServlet(urlPatterns={"/no_student/no_student_delete"})
public class No_StudentDelete extends HttpServlet {
	public void doGet (
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			try{

				String no = request.getParameter("no");

				Student p = new Student();
				p.setNo(no);

				StudentDAO dao1=new StudentDAO();
				int line1 =dao1.delete(p);

				StudentDAO dao2=new StudentDAO();
				int line2 =dao2.delete(p);

				request.getRequestDispatcher("no_student_delete_done.jsp")
				.forward(request,response);

			} catch (Exception e) {
				e.printStackTrace(out);
		}
	}
}