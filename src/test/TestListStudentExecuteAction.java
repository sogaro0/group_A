package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ClassNum;
import bean.Student;
import bean.Subject;
import bean.Test;
import dao.ClassNumDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import dao.TestDAO;


@WebServlet(urlPatterns={"/test/test_list_student_execute_action"})
public class TestListStudentExecuteAction extends HttpServlet {
	public void doGet (
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			try{

			    ArrayList<Integer> year_list = new ArrayList<>();


				 // クラス番号テーブルを読ませて、test_list.jspに渡す tryの中に入れる文

			    //h2より各種を取得
					StudentDAO dao=new StudentDAO();
					List<Student> list=dao.all();

					ClassNumDAO dao1=new ClassNumDAO();
					List<ClassNum> list1=dao1.all();

					SubjectDAO dao2=new SubjectDAO();
					List<Subject> list2=dao2.all();



				// アトリビュート
	                request.setAttribute("year_list", year_list);
					request.setAttribute("students", list);
					request.setAttribute("class_num_set", list1);
					request.setAttribute("subject", list2);


				String student_id = request.getParameter("cd");

				Test p = new Test();
				p.setStudentNum(student_id);



					TestDAO dao3=new TestDAO();
					List<Test> list3=dao3.searchstudentcd(p);
					request.setAttribute("test", list3);

				request.getRequestDispatcher("test_list_student.jsp")
				.forward(request,response);

			} catch (Exception e) {
				e.printStackTrace(out);
		}
	}

}