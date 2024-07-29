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
            <h2 class="h3 mb-3 fw-norma student bg-opacity-10 py-2 px-4">学生情報変更</h2>
			<label class="btn-position">変更が完了しました。</label>


		<form class="mx-3" action="../student/StudentList.action" method="get">
    	<button type="submit" class="StudentCreate.action">学生一覧</button><br>
   		</form>

        </section>
        </div>
    </c:param>
</c:import>
