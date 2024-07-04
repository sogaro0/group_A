package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ClassNum;
import bean.Student;
import dao.ClassNumDAO;
import dao.StudentDAO;


@WebServlet(urlPatterns={"/student/student_create_excute_action"})
public class StudentCreateExcuteAction extends HttpServlet {
	public void doGet (
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			try{

				String no = request.getParameter("no");
				String name = request.getParameter("name");
				int ent_year = Integer.parseInt(request.getParameter("ent_year"));
				String class_num = request.getParameter("class_num");

				// エラーメッセージの文字列
				String message = "";
				// 正規表現のパターンを用意する
				String regex_num = "^[0-9]+$" ;
				// 正規表現パターンの読み込み
				Pattern p1 = Pattern.compile(regex_num);
				// パターンと文字列の照合
				Matcher m1 = p1.matcher(no);
				// 照合結果をtrueまたはfalseで取得する
			    boolean result = m1.matches();

			    if (result == false){
			    	message = "学生番号は数字を入力してください";
			    }

			    // 学生番号Noに重複があるか調べる
				StudentDAO dao=new StudentDAO();
				List<Student> list=dao.validate(no);
				System.out.println(list);
				// 重複していた場合、メッセージを格納
				if (list != null){
					message = "学生番号が重複しています";
				}
				System.out.println(message);


				// messageにエラー文が格納されていた場合、student_create.jspにフォワードする
				if (message != ""){

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
					ClassNumDAO dao2=new ClassNumDAO();
					List<ClassNum> list1=dao2.all();


					request.setAttribute("class_num", list1);
					request.setAttribute("year_list", year_list);


					request.setAttribute("message", message);
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

					int line =dao.insert(p);

					request.setAttribute("message", message);
					request.getRequestDispatcher("student_create_done.jsp")
					.forward(request,response);
				}


			} catch (Exception e) {
				e.printStackTrace(out);
		}
	}
}