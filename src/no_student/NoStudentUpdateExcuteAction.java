package no_student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;
import tool.Action;


public class NoStudentUpdateExcuteAction extends Action {
	public String execute (
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			try{

				String no = request.getParameter("no");
				String name = request.getParameter("name");
				String class_num = request.getParameter("class_num");
				boolean is_attend = request.getParameter("is_attend") != null;
				String birth_day_sting = request.getParameter("birth_day");

				//誕生日の型変換
		        Date birth_day= java.sql.Date.valueOf(birth_day_sting);

				Student p = new Student();
				p.setNo(no);
				p.setName(name);
				p.setClassNum(class_num);
				p.setIsAttend(is_attend);
				p.setBirthDay(birth_day);

				StudentDAO dao=new StudentDAO();
				int line =dao.update(p);


			} catch (Exception e) {
				e.printStackTrace(out);
		}
			return "no_student_update_done.jsp";
	}
}