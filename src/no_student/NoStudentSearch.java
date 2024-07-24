package no_student;

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
import dao.ClassNumDAO;
import dao.StudentSearchDAO;


@WebServlet(urlPatterns={"/no_student/no_student_search"})
public class NoStudentSearch extends HttpServlet {
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

					ClassNumDAO dao1=new ClassNumDAO();
					List<ClassNum> list1=dao1.all();

	            //アトリビュートの中に入れるやつ
	                request.setAttribute("class_num_set", list1);

				// アトリビュート
				request.setAttribute("year_list", year_list);

				int ent_year = Integer.parseInt(request.getParameter("f1"));
				String class_num = request.getParameter("f2");
				boolean is_attend = request.getParameter("f3") != null;

				Student p = new Student();
				p.setEntYear(ent_year);
				p.setClassNum(class_num);
				p.setIsAttend(is_attend);


				//入学年度:なし クラス番号:なし(分類番号:1)
				if(ent_year == 0 && class_num.equals("0") ){
					StudentSearchDAO dao=new StudentSearchDAO();
					List<Student> list=dao.search1(p);
					request.setAttribute("students", list);
				}

				//入学年度:指定 クラス番号:なし(分類番号:2)
				else if(class_num.equals("0")){
				StudentSearchDAO dao=new StudentSearchDAO();
				List<Student> list=dao.search2(p);
				request.setAttribute("students", list);
				}

				//入学年度:なし クラス番号:指定(分類番号:3)
				else if(ent_year == 0){
					StudentSearchDAO dao=new StudentSearchDAO();
					List<Student> list=dao.search3(p);
					request.setAttribute("students", list);
				}



				//入学年度:指定 クラス番号:指定(分類番号:なし)
				else{
					StudentSearchDAO dao=new StudentSearchDAO();
					List<Student> list=dao.search(p);
					request.setAttribute("students", list);
				}

				request.getRequestDispatcher("no_student_list.jsp")
				.forward(request,response);

			} catch (Exception e) {
				e.printStackTrace(out);
		}
	}
}