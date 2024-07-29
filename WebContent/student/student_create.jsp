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
            <h2 class="titlesize h3 mb-3 fw-norma bg-opacity-10 py-2 px-4 student">学生情報登録</h2>

		<script type="text/javascript">
 			document.getElementById("year").innerHTML = getYear();

 			function getYear() {
 				var now = new Date();
   				var nowYear = now.getFullYear();
   				return nowYear;
		  }
		 </script>

			<p><span id="year"></span></p>

            <form class="mx-3" action="../student/StudentCreateExcute.action" method="get">

            <label>入学年度</label><br>
            <select class="select-shape" name="ent_year" required="required">
				<option value=0>--------</option>
                <c:forEach var="year" items="${year_list}">
				<option value=${year}>${year}</option>
				</c:forEach>
			</select>
			<div id="error-message">${message_ent_year}</div>

			<label>学生番号</label><br>
			<input class="select-shape" type="text" class="textsize" name="no" placeholder="学生番号を入力してください" required="required" value=${no} >


			<%-- エラー文 --%>
			<div id="error-message">${message_student_no}</div>

			<label>氏名</label><br>
			<input class="select-shape" type="text" class="textsize" name="name" placeholder="氏名を入力してください" required="required" value=${name} >

			<label>クラス</label><br>
			<select class="select-shape" name="class_num">
			<c:forEach var="class_num" items="${class_num}">
            <option value=${class_num.classNum}>${class_num.classNum}</option>
            </c:forEach>
			</select>

			<label>誕生日</label><br>
			<input class="select-shape" type="date" class="textsize" name="birth_day" placeholder="誕生日を入力してください	" required="required" value=${birthday} >

            <button type="submit" class="StudentCreate.action">
            登録して終了
            </button>

            </form>


	<form action="../student/StudentList.action" method="get">
    <button class="mx-3" type="submit" class="StudentCreate.action">戻る</button>
    </form>
     </section>
    </div>
    </c:param>
</c:import>
