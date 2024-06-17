package student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;


@WebServlet(urlPatterns={"/student/student_update_excute_action"})
public class StudentUpdateExcuteAction extends HttpServlet {
	public void doGet (
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			try{

				String no = request.getParameter("no");
				String name = request.getParameter("name");
				String class_num = request.getParameter("class_num");
				boolean is_attend = request.getParameter("is_attend") != null;


				Student p = new Student();
				p.setNo(no);
				p.setName(name);
				p.setClassNum(class_num);
				p.setIsAttend(is_attend);

				StudentDAO dao=new StudentDAO();
				int line =dao.update(p);

				request.getRequestDispatcher("student_update_done.jsp")
				.forward(request,response);

			} catch (Exception e) {
				e.printStackTrace(out);
		}
	}
}