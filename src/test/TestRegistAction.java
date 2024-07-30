package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ClassNum;
import bean.Student;
import bean.Subject;
import bean.Test;
import dao.ClassNumDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import dao.TestDAO;
import tool.Action;

public class TestRegistAction extends Action {
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

			    // h2コンソールから学生のリストを取得
				StudentDAO dao=new StudentDAO();
				List<Student> list=dao.all();

				// クラス番号ClassNumテーブルを読ませて、student_list.jspに渡す
				ClassNumDAO dao1=new ClassNumDAO();
				List<ClassNum> list1=dao1.all();

				//h2コンソールから科目のリストを取得
				SubjectDAO dao2=new SubjectDAO();
				List<Subject> list2=dao2.all();

				//テストテーブルから回数を重複しないように取り寄せる
				TestDAO dao3=new TestDAO();
				List<Test> list3=dao3.dup();

				// アトリビュート
				request.setAttribute("year_list", year_list);
				request.setAttribute("students", list);
				request.setAttribute("class_num_set", list1);
				request.setAttribute("subject", list2);
				request.setAttribute("test", list3);

				String boot = request.getParameter("f5");
				String boot2 = "abc";

//				もしもbootがnullでない時次の処理へ
				if (boot != null){
//					もしbootがboot2と同じ文字列だったら次の処理へ
					if (boot.equals(boot2)){

//						test_regist.jspからデータを取り寄せる
						Integer ent_year = Integer.parseInt(request.getParameter("f1"));
						String class_num = request.getParameter("f2");
						String subject = request.getParameter("f3");
						Integer times = Integer.parseInt(request.getParameter("f4"));
						Student p = new Student();

			            if (ent_year == 0 || class_num.equals("0") || subject.equals("0") || times == 0) {

			                request.setAttribute("errorMessage", "入学年度・クラス・科目・回数を選択してください");
			                request.getRequestDispatcher("test_regist.jsp").forward(request, response);
			            }
						p.setClassNum(class_num);
						p.setEntYear(ent_year);

						Test p1 = new Test();
						p1.setSubject(subject);
						p1.setTimes(times);

						SubjectDAO dao7=new SubjectDAO();
						String subject_name=dao7.search_name(subject);

//						TestDAOからデータを取り寄せる
						TestDAO dao4=new TestDAO();
						List<Test> list4=dao4.search(p, p1);
						for(int i = 0; i < list4.size(); i++){
							if (list4.get(i).getPoint() == -1){
								System.out.println("これはnull値です");
							}

				    	};

						request.setAttribute("result", list4);

//					    基準点の初期値設定
					    HttpSession session = request.getSession();
					    Integer judge = (Integer) session.getAttribute("judge");

					    if(judge == null){
					    	judge = 60;
							session.setAttribute("judge", judge);
					    }


							//配列を準備
							List<Integer> point = new ArrayList<Integer>();
					    	List<String> student_no = new ArrayList<String>();

//					    	得点を配列に入れる
					    	for(int i = 0; i < list4.size(); i++){
					    		point.add(list4.get(i).getPoint());
					    	};

//					    	学生番号を配列に入れる
					    	for(int i = 0; i < list4.size(); i++){
					    		student_no.add(list4.get(i).getStudentNum());
					    	};

//					    	回数分処理
						    for(int i = 0; i < point.size(); i++){
							Test p3 = new Test();
							p3.setPoint(point.get(i));
							p3.setStudentNum(student_no.get(i));

							//赤点の場合
							if (point.get(i) < judge){
								TestDAO dao5=new TestDAO();
								int line =dao5.update1(p3);}

							//黒点の場合
							else if(point.get(i) >= judge){
								TestDAO dao5=new TestDAO();
								int line =dao5.update2(p3);}

//							TestDAOからデータを取り寄せる
							TestDAO dao6=new TestDAO();
							List<Test> list5=dao6.search(p, p1);
							request.setAttribute("result", list5);
							request.setAttribute("times", times);
							request.setAttribute("subject_cd", subject);
							request.setAttribute("class_num", class_num);
							request.setAttribute("ent_year", ent_year);
							request.setAttribute("subject_name", subject_name);

							}


					}
				}


			} catch (Exception e) {
				e.printStackTrace(out);
		}
			//	test_regist.jspにデータを送信
			return "test_regist.jsp";
	}
}