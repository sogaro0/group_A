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


@WebServlet(urlPatterns={"/student/student_create_excute_action"})
public class StudentCreateExcuteAction extends HttpServlet {
	public void doGet (
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			try{

				String no = request.getParameter("no");
				String name = request.getParameter("name");
				int ent_year = Integer.parseInt(request.getParameter("ent_year"));
				String class_num = request.getParameter("class_num");


				Student p = new Student();
				p.setNo(no);
				p.setName(name);
				p.setEntYear(ent_year);
				p.setClassNum(class_num);

				StudentDAO dao=new StudentDAO();
				int line =dao.insert(p);

				request.getRequestDispatcher("student_create_done.jsp")
				.forward(request,response);

			} catch (Exception e) {
				e.printStackTrace(out);
		}
	}
}