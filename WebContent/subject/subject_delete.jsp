<%-- 学生一覧JSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 文字化けの対策 --%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>


<c:import url="/common/base.jsp">

    <c:param name="scripts"></c:param>

    <c:param name="content">
    <div class="function">
    <c:import url="/common/sidemenu.jsp">
    </c:import>
        <section class="mo-4">
            <h2 class="h3 mb-3 fw-norma subject bg-opacity-10 py-2 px-4">科目情報削除</h2>


            <form class="mx-3" action="../subject/subject_delete" method="get">
			<input type="hidden" value="<%=request.getParameter("cd")%>" name=cd>
			<h2>削除しますか？</h2>

            <button type="submit" class="SubjectDelete.action">
            削除する
            </button>

            </form>
        </section>
	<form class="mx-3" action="../subject/SubjectList.action" method="get">
    <button type="submit" class="SubjectList.action">戻る</button>
    </form>

    </div>
    </c:param>
</c:import>
