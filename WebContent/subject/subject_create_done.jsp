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
            <h2 class="h3 mb-3 fw-norma subject bg-opacity-10 py-2 px-4">科目情報登録</h2>
			<label class="btn-position">登録が完了しました。</label>


			<form class="mx-3" action="../subject/SubjectList.action" method="get">
				<button type="submit" class="SubjectCreate.action">科目一覧</button>
			</form>

			<button class="mx-3"  type="button" onclick="history.back()">戻る</button>

        </section>
        </div>
    </c:param>
</c:import>
