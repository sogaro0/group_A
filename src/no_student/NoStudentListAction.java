package no_student;

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
import dao.ClassNumDAO;
import dao.StudentDAO;
import tool.Action;


public class NoStudentListAction extends Action {
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

					ClassNumDAO dao1=new ClassNumDAO();
					List<ClassNum> list1=dao1.all();

	            //アトリビュートの中に入れるやつ
	                request.setAttribute("class_num_set", list1);


			    // h2コンソールから学生のリストを取得
				StudentDAO dao=new StudentDAO();
				List<Student> list=dao.no_all();

				// アトリビュート
				request.setAttribute("students", list);
				request.setAttribute("year_list", year_list);


			} catch (Exception e) {
				e.printStackTrace(out);
		}
			return "no_student_list.jsp";
	}

}
