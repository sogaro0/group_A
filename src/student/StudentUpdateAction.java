package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ClassNum;
import bean.Student;
import dao.ClassNumDAO;
import dao.StudentDAO;
import tool.Action;


public class StudentUpdateAction extends Action {
	public String execute (
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


			} catch (Exception e) {
				e.printStackTrace(out);
		}
			return "student_update.jsp";
	}
}