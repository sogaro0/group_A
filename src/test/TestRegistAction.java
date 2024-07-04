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

@WebServlet(urlPatterns={"/test/test_regist_action"})
public class TestRegistAction extends HttpServlet {
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

			    // h2コンソールから学生のリストを取得
				StudentDAO dao=new StudentDAO();
				List<Student> list=dao.all();

				// クラス番号ClassNumテーブルを読ませて、student_list.jspに渡す
				ClassNumDAO dao1=new ClassNumDAO();
				List<ClassNum> list1=dao1.all();

				//h2コンソールから科目のリストを取得
				SubjectDAO dao2=new SubjectDAO();
				List<Subject> list2=dao2.all();

				//テストテーブルから回数を重複しないように取り寄せる
				TestDAO dao3=new TestDAO();
				List<Test> list3=dao3.dup();

				// アトリビュート
				request.setAttribute("year_list", year_list);
				request.setAttribute("students", list);
				request.setAttribute("class_num_set", list1);
				request.setAttribute("subject", list2);
				request.setAttribute("test", list3);

				String boot = request.getParameter("f5");
				String boot2 = "abc";

//				もしもbootがnullでない時次の処理へ
				if (boot != null){

//					もしbootがboot2と同じ文字列だったら次の処理へ
					if (boot.equals(boot2)){

//						test_regist.jspからデータを取り寄せる
						int ent_year = Integer.parseInt(request.getParameter("f1"));
						String class_num = request.getParameter("f2");
						String subject = request.getParameter("f3");
						int times = Integer.parseInt(request.getParameter("f4"));


						Student p = new Student();
						p.setClassNum(class_num);
						p.setEntYear(ent_year);

						Test p1 = new Test();
						p1.setSubject(subject);
						p1.setTimes(times);

//						TestDAOからデータを取り寄せる
						TestDAO dao4=new TestDAO();
						List<Test> list4=dao4.search(p, p1);
						request.setAttribute("result", list4);

//						test_regist.jspに取り寄せたデータを送信
						request.getRequestDispatcher("test_regist.jsp")
						.forward(request,response);
					}
				}

//				test_regist.jspにデータを送信
				request.getRequestDispatcher("test_regist.jsp")
				.forward(request,response);

			} catch (Exception e) {
				e.printStackTrace(out);
		}
	}
}