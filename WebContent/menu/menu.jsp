<%-- 学生一覧JSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 文字化けの対策 --%>
<% request.setCharacterEncoding("UTF-8"); %>

<c:import url="/common/base.jsp">
    <c:param name="content">
    <c:import url="/common/sidemenu.jsp"></c:import>

    <div class="function">
        <section class="mo-4">
			<h2 class="h3 mb-3 fw-norma bg-light bg-opacisty-10 menu-height px-5">メニュー</h2>
			<div class="box student">

               <form action="../student/StudentList.action" method="get">
                    <button type="submit" class="StudentCreate.action bt">
                    学生管理
                    </button>
                </form>

                <form action="../no_student/NoStudentList.action" method="get">
                    <button type="submit" class="StudentCreate.action bt">
                    退学者リスト
                    </button>
                </form>
             </div>
            <div class="box grade">
                <form action="../test/TestRegist.action" method="get">
                	<button type="submit" class="StudentCreate.action bt2">成績登録</button>
                </form>
             <form action="../test/TestList.action" method="get">
                <button class="TestCreate.action bt2">成績参照</button>
                </form>
             </div>
             <div class="box subject">
              <form action="../subject/SubjectList.action" method="get">
                    <button type="submit" class="SubjectCreate.action bt3">
                    科目管理
                    </button>
                </form>
             </div>
		</section>
		</div>
    </c:param>
    <c:param name="scripts"></c:param>
</c:import>