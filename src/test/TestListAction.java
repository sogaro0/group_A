package test;

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
import bean.Subject;
import dao.ClassNumDAO;
import dao.StudentDAO;
import dao.SubjectDAO;


@WebServlet(urlPatterns={"/test/test_list_action"})
public class TestListAction extends HttpServlet {
	public void doGet (
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {

			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			try{

			    // h2コンソールから入学年度のリストを取得
				StudentDAO dao=new StudentDAO();
				List<Student> list=dao.ent_year();

				// h2コンソールからクラス番号を取得
				ClassNumDAO dao1=new ClassNumDAO();
				List<ClassNum> list1=dao1.all();

				// h2コンソールから科目のリストを取得
				SubjectDAO dao2=new SubjectDAO();
				List<Subject> list2=dao2.all();


				// アトリビュート
				request.setAttribute("ent_year", list);
				request.setAttribute("class_num",list1);
				request.setAttribute("subject_name",list2);

				request.getRequestDispatcher("test_list.jsp")
				.forward(request,response);

			} catch (Exception e) {
				e.printStackTrace(out);
		}
	}

}