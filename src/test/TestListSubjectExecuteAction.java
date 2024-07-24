package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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


@WebServlet(urlPatterns={"/test/test_list_subject_execute_action"})
public class TestListSubjectExecuteAction extends HttpServlet {
	private static final Object line = null;

	public void doGet (
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			try{

				// 現在の年数+-10年のリストを取得
			    Date date = new Date();
				int year = date.getYear() + 1900;

			    ArrayList<Integer> year_list = new ArrayList<>();

			    for (int i = year-10; i < year+11; i++){
			    	year_list.add(i);
			    	}

				 // クラス番号ClassNumテーブルを読ませて、student_list.jspに渡す tryの中に入れる文

			    // h2コンソールから入学年度のリストを取得
				StudentDAO dao=new StudentDAO();
				List<Student> list=dao.ent_year();

				// h2コンソールからクラス番号を取得
				ClassNumDAO dao1=new ClassNumDAO();
				List<ClassNum> list1=dao1.all();

				// h2コンソールから科目のリストを取得
				SubjectDAO dao2=new SubjectDAO();
				List<Subject> list2=dao2.all();

				request.setAttribute("ent_year", list);
				request.setAttribute("class_num",list1);
				request.setAttribute("subject_name",list2);


				int ent_year = Integer.parseInt(request.getParameter("f1"));
				String class_num = request.getParameter("f2");
				String subject_name = request.getParameter("f3");
				System.out.print(subject_name);


				Test p = new Test();
				p.setEntYear(ent_year);
				p.setClassNum(class_num);
				p.setName(subject_name);




				TestDAO dao_test=new TestDAO();
				List<Test> list3 = dao_test.search1(p);
				System.out.println(list3);

				request.setAttribute("test",list3);



				request.getRequestDispatcher("test_list.jsp")
				.forward(request,response);

			} catch (Exception e) {
				e.printStackTrace(out);
		}
	}
}