package subject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ClassNum;
import dao.ClassNumDAO;
import tool.Action;


public class SubjectCreateAction extends Action {
	public String execute (
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

				// クラス番号ClassNumテーブルを読ませて、subject_create.jspに渡す
				ClassNumDAO dao=new ClassNumDAO();
				List<ClassNum> list=dao.all();


			} catch (Exception e) {
				e.printStackTrace(out);
		}
			return "subject_create.jsp";
	}
}