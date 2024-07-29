package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
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
import tool.Action;


public class TestListSubjectExecuteAction extends Action {

	public String execute (
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
				//	入学年度、クラス番号、科目名のいずれかが空の場合、errorMessageにエラー文を格納し
				//	test_list.jspにフォワードする。
	            if (ent_year == 0 || class_num.equals("0") || subject_name.equals("0")) {

	                request.setAttribute("errorMessage", "入学年度とクラスと科目を選択してください");
	                request.getRequestDispatcher("test_list.jsp").forward(request, response);
	            }


				Test p = new Test();
				p.setEntYear(ent_year);
				p.setClassNum(class_num);
				p.setName(subject_name);

				TestDAO dao_test=new TestDAO();
				List<Test> list3 = dao_test.search1(p);
				System.out.println(list3);

				request.setAttribute("test",list3);


			} catch (Exception e) {
				e.printStackTrace(out);
		}
			return "test_list_subject.jsp";
	}
}