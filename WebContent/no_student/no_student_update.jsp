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
    <div class="function">
    <c:import url="/common/sidemenu.jsp">
    </c:import>
        <section class="mo-4">
            <h2 class="h3 mb-3 fw-norma student bg-opacity-10 py-2 px-4">退学者情報変更</h2>

		<script type="text/javascript">
 			document.getElementById("year").innerHTML = getYear();

 			function getYear() {
   				var nowYear = now.getFullYear();
   				return nowYear;
		  }
		 </script>

			<p><span id="year"></span></p>

			<form action="../no_student/NoStudentUpdateExcute.action" method="get">

            <p><label class="mx-3">入学年度<br>
 			<input type="text" value="<%=request.getParameter("ent_year")%>" name='ent_year' readonly>
			</label></p>

			<p><label class="mx-3">学生番号<br>
			<input type="text" value="<%=request.getParameter("no")%>" name='no'readonly>
			</label></p>

			<label class="mx-3">氏名</label><br>
			<input class="select-shape mx-3" type="text"  name="name" placeholder="<%=request.getParameter("name")%>"  value="${name}" required="required">

			<label class="mx-3">クラス</label><br>
			<select class="select-shape mx-3" name="class_num">
			<c:forEach var="class_num" items="${class_num}">
            <option value=${class_num.classNum}>${class_num.classNum}</option>
            </c:forEach>
			</select>

			<p><label class="mx-3">在学中
    		<input class="mx-3" type="checkbox" name="is_attend" value="ture">
			</label></p>

			<label class="mx-3">誕生日</label><br>
			<input class="select-shape mx-3" type="text" class="textsize" name="birth_day" placeholder="<%=request.getParameter("birth_day")%>" required="required" value=${birthday} >

            <button class="mx-3" type="submit" class="StudentUpdate.action">
            変更
            </button>
			</form>

            <form class="mx-3" action="../no_student/NoStudentList.action" method="get">
   			<button type="submit" class="StudentCreate.action">学生一覧</button>
   			</form>


        </section>

    </div>
    </c:param>
</c:import>
