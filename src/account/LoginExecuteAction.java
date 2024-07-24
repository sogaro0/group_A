package account;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.TeacherDAO;

@WebServlet(urlPatterns={"/account/login_excute_action"})
public class LoginExecuteAction extends HttpServlet {

	public void doPost(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		try{

		System.out.println("a");
		HttpSession session=request.getSession();
		String message = "";
		String id=request.getParameter("id");
		String password=request.getParameter("password");

		TeacherDAO dao=new TeacherDAO();
		Teacher teacher=dao.login(id, password);
		System.out.println(teacher);
		System.out.println(teacher.getId());
		System.out.println(teacher.getName());

		// ユーザーデータが格納されている場合
		if (teacher.getId()!=null){
			System.out.println("ユーザーデータが格納されています");
			// ユーザーデータをセッションに格納
			session.setAttribute("teacher_id", teacher.getId());
			session.setAttribute("teacher_name", teacher.getName());
			request.getRequestDispatcher("../menu/menu.jsp")
			.forward(request,response);

		}
		// ユーザーデータが格納されていない場合
		else {
			System.out.println("ユーザーデータが格納されていません");
			message = "IDまたはパスワードが間違っています";
			request.getRequestDispatcher("/login.jsp")
			.forward(request,response);
			}
		}
		catch (Exception e) {
			e.printStackTrace(out);
			}
		}
	}
