package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ClassNum;
import bean.Student;
import dao.ClassNumDAO;
import dao.StudentDAO;
import tool.Action;

public class StudentCreateExcuteAction extends Action {
	public String execute (
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			try{

				String no = request.getParameter("no");
				String name = request.getParameter("name");
				int ent_year = Integer.parseInt(request.getParameter("ent_year"));
				String class_num = request.getParameter("class_num");
				String birth_day_sting = request.getParameter("birth_day");

				//誕生日の型変換
		        Date birth_day= java.sql.Date.valueOf(birth_day_sting);

				// エラーメッセージの文字列
		        String message_ent_year = "";
				String message_student_no = "";
				// 入学年度が未入力の場合、エラーメッセージを格納
				if (ent_year == 0){
					message_ent_year = "入学年度を選択してください";
				}
			    // 学生番号Noに重複があるか調べる
				StudentDAO dao=new StudentDAO();
				String cnt=dao.validate(no);
				// 重複していた場合、エラーメッセージを格納
				if (cnt.equals("1")){
					message_student_no = "学生番号が重複しています";
				}
//				学生番号の文字数を調べる
				int count = no.length();
//				学生番号が11文字以上の場合、メッセージを格納
				if (count > 10){
					message_student_no = "学生番号が11文字以上です";
				}

				// messageにエラー文が格納されていた場合、student_create.jspにフォワードする
				if (message_ent_year != "" || message_student_no != ""){

					// 現在の年数+-10年のリストを取得
				    java.util.Date date =  new java.util.Date();
					int year = date.getYear() + 1900;
				    ArrayList<Integer> year_list = new ArrayList<>();
				    for (int i = year-10; i < year+11; i++){
				    	year_list.add(i);
				    	}

					// クラス番号ClassNumテーブルを読ませて、student_create.jspに渡す
					ClassNumDAO dao2=new ClassNumDAO();
					List<ClassNum> list1=dao2.all();

					request.setAttribute("class_num", list1);
					request.setAttribute("year_list", year_list);

					request.setAttribute("message_ent_year", message_ent_year);
					request.setAttribute("message_student_no", message_student_no);
					request.getRequestDispatcher("student_create.jsp")
					.forward(request,response);
				}
				// messageにエラー文が格納されていない場合、student_create_done.jspにフォワードする
				else {
					// dbに登録
					Student p = new Student();
					p.setNo(no);
					p.setName(name);
					p.setEntYear(ent_year);
					p.setClassNum(class_num);
					p.setBirthDay(birth_day);

					int line =dao.insert(p);

				}


			} catch (Exception e) {
				e.printStackTrace(out);
		}
			return "student_create_done.jsp";
	}
}