package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ClassNum;
import bean.Student;
import dao.ClassNumDAO;
import dao.StudentDAO;


@WebServlet(urlPatterns={"/student/student_update_action"})
public class StudentUpdateAction extends HttpServlet {
	public void doGet (
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			try{

				// クラス番号ClassNumテーブルを読ませて、student_update.jspに渡す
				ClassNumDAO dao=new ClassNumDAO();
				List<ClassNum> list=dao.all();

				StudentDAO dao2=new StudentDAO();
				List<Student> list2=dao2.all();
				//student_list.jspから受けった値もstudent_update.jspに渡す
				request.getParameter("entYear");
				request.getParameter("no");
				request.getParameter("name");
				request.getParameter("classnum");

				request.setAttribute("class_num", list);
				request.setAttribute("student", list2);
				request.getRequestDispatcher("student_update.jsp")
				.forward(request,response);


			} catch (Exception e) {
				e.printStackTrace(out);
		}
	}
}