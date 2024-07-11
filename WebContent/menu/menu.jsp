<%-- 学生一覧JSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 文字化けの対策 --%>
<% request.setCharacterEncoding("UTF-8"); %>

<c:import url="/common/base.jsp">
    <c:param name="title">
        <h1 class="toptitle">得点管理システム</h1>
    </c:param>
    <c:param name="content">
    <div class="row">
    <c:import url="/common/sidemenu.jsp">
    </c:import>

        <section class="col-lg-10">
			<h2 class="h3 mb-3 fw-norma bg-light bg-opacisty-10 py-2 px-4">メニュー</h2>
			<div class="box student">・学生管理<br>

                <form action="../student/student_list_action" method="get">
                    <button type="submit" class="StudentCreate.action">
                    学生管理
                    </button>
                </form>

                <form action="../no_student/no_student_list_action" method="get">
                    <button type="submit" class="StudentCreate.action">
                    退学者リスト
                    </button>
                </form>
             </div>
            <div class="box grade">・成績管理<br>
                <form action="../test/test_regist_action" method="get">
                	<button type="submit" class="StudentCreate.action">成績登録</button>
                </form>
             <form action="../test/test_list_action" method="get">
                <button class="TestCreate.action">成績参照</button>
                </form>
             </div>
             <div class="box subject">・科目管理<br>
              <form action="../subject/subject_list_action" method="get">
                    <button type="submit" class="SubjectCreate.action">
                    科目管理
                    </button>
                </form>
             </div>
		</section>
		</div>
    </c:param>
    <c:param name="scripts"></c:param>
</c:import>