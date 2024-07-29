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

 		<form class="mx-3" action="../subject/SubjectCreateExcute.action" method="get">

			<label>科目コード</label><br>
			<input class="select-shape" type="text" name="cd" placeholder="科目コードを入力してください" required="required" value=${no} >

			<%-- エラー文 --%>
			<div id="error-message">${message}</div>

			<label>科目名</label><br>
			<input class="select-shape" type="text" name="name" placeholder="科目名を入力してください" required="required" value=${name}>

            <button type="submit" class="SubjectCreate.action">
            登録して終了
            </button>
            </form>


            <button class="mx-3" type="button" onclick="history.back()">戻る</button>

        </section>

    </div>
    </c:param>
</c:import>
