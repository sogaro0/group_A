package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//成績, bean, dao
import bean.Test;
import dao.TestDAO;
import tool.Action;


public class TestRegistExecuteAction extends Action {
	public String execute (
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			try{

				//test_regist.jspから値を取得
				String[] student_no = request.getParameterValues("studentNum");
			    String subject_cd = request.getParameter("subject_cd");
			    int times = Integer.parseInt(request.getParameter("times"));
			    String[] point = request.getParameterValues("point");
			    String class_num = request.getParameter("class_num");
			    String[] name = request.getParameterValues("name");
			    int ent_year = Integer.parseInt(request.getParameter("ent_year"));

			    HttpSession session = request.getSession();
			    Integer judge = (Integer) session.getAttribute("judge");

			    //得点のリストをintに変換
			    Integer[] point_int = new Integer[point.length];
			    for (int i = 0; i < point.length; i++) {
			    point_int[i] = Integer.parseInt(point[i]);
			    }

			    for(int i = 0; i < point_int.length; i++){
				Test p = new Test();
				p.setPoint(point_int[i]);
				p.setStudentNum(student_no[i]);
				p.setEntYear(ent_year);
				p.setClassNum(class_num);
				p.setName(name[i]);
				p.setSubject_cd(subject_cd);
				p.setTimes(times);


				TestDAO dao5=new TestDAO();
				Test test_check = dao5.search3(student_no[i], subject_cd, times);

				//データがない(新規登録)の場合
				if(test_check.getSubject_cd() == null){
					TestDAO dao1=new TestDAO();
					int line1 =dao1.insert(p);

						//赤点の場合
						if (point_int[i] < judge){
							TestDAO dao=new TestDAO();
							int line2 =dao.update1(p);}

						//黒点の場合
						else if(point_int[i] >= judge){
							TestDAO dao=new TestDAO();
							int line2 =dao.update2(p);}
				}

				//既にデータがある(更新)の場合
				else{

					//赤点の場合
					if (point_int[i] < judge){
					TestDAO dao=new TestDAO();
					int line =dao.update1(p);}

					//黒点の場合
					else if(point_int[i] >= judge){
						TestDAO dao=new TestDAO();
						int line =dao.update2(p);}
					}
				}

			} catch (Exception e) {
				e.printStackTrace(out);
		}
			return "test_regist_done.jsp";
	}

}