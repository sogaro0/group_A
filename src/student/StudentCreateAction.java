package student;

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
import dao.ClassNumDAO;


@WebServlet(urlPatterns={"/student/student_create_action"})
public class StudentCreateAction extends HttpServlet {
	public void doGet (
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			try{
				// 現在の年数+-10年のリストを取得
			    Date date = new Date();
				int year = date.getYear() + 1900;
			    System.out.println(year);

			    ArrayList<Integer> year_list = new ArrayList<>();

			    for (int i = year-10; i < year+11; i++){
			    	year_list.add(i);
			    	System.out.println(year_list);
			    	}


				// クラス番号ClassNumテーブルを読ませて、student_create.jspに渡す
				ClassNumDAO dao=new ClassNumDAO();
				List<ClassNum> list=dao.all();

				request.setAttribute("class_num", list);
				request.setAttribute("year_list", year_list);

				request.getRequestDispatcher("student_create.jsp")
				.forward(request,response);

			} catch (Exception e) {
				e.printStackTrace(out);
		}
	}
}