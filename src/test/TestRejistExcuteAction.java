package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//成績, bean, dao
import bean.Test;
import dao.TestDAO;


@WebServlet(urlPatterns={"/test/test_rejist_execute_action"})
public class TestRejistExcuteAction extends HttpServlet {
	public void doGet (
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			try{

				//test_rejisrt.jspから値を取得
			    String[] point = request.getParameterValues("point");
			    String[] student_no = request.getParameterValues("studentNum");

			    //得点のリストをintに変換
			    int[] point_int = new int[point.length];
			    for (int i = 0; i < point.length; i++) {
			    point_int[i] = Integer.parseInt(point[i]);
			    }

			    for(int i = 0; i < point_int.length; i++){
				Test p = new Test();
				p.setPoint(point_int[i]);
				p.setStudentNum(student_no[i]);

				//赤点の場合
				if (point_int[i] < 60){
				TestDAO dao=new TestDAO();
				int line =dao.update1(p);}

				//黒点の場合
				else if(point_int[i] >= 60){
					TestDAO dao=new TestDAO();
					int line =dao.update2(p);
				}
				}

				request.getRequestDispatcher("test_rejist_done.jsp")
				.forward(request,response);

			} catch (Exception e) {
				e.printStackTrace(out);
		}
	}

}