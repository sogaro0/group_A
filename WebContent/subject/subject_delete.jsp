<%-- 学生一覧JSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 文字化けの対策 --%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>


<c:import url="/common/base.jsp">
    <c:param name="title">
        <h1 class="toptitle">得点管理システム</h1>
    </c:param>

    <c:param name="scripts"></c:param>

    <c:param name="content">
    <div class="row">
    <c:import url="/common/sidemenu.jsp">
    </c:import>
        <section class="mo-4">
            <h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目情報削除</h2>


            <form action="../subject/subject_delete" method="get">
			<input type="hidden" value="<%=request.getParameter("cd")%>" name=cd>
			<h2>削除しますか？</h2>

            <button type="submit" class="SubjectDelete.action">
            削除する
            </button>

            </form>
        </section>
	<form action="../subjcet/subject_list_action" method="get">
    <button type="submit" class="SubjectCreate.action">戻る</button>
    </form>

    </div>
    </c:param>
</c:import>
