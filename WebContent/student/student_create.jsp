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
            <h2 class="titlesize h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">学生情報登録</h2>

		<script type="text/javascript">
 			document.getElementById("year").innerHTML = getYear();

 			function getYear() {
 				var now = new Date();
   				var nowYear = now.getFullYear();
   				return nowYear;
		  }
		 </script>

			<p><span id="year"></span></p>

            <form action="../student/student_create_excute_action" method="get">

            <p><label>入学年度<br>
            <select name="ent_year" required="required">
				<option value="">--------</option>
                <c:forEach var="year" items="${year_list}">
				<option value=${year}>${year}</option>
				</c:forEach>
			</select>
			</label></p>

			<p><label>学生番号<br>
			<input type="text" class="textsize" name="no" placeholder="学生番号を入力してください" required="required" value=${no} >
			</label></p>

			<%-- エラー文 --%>
			<div id="error-message">${message}</div>

			<p><label>氏名<br>
			<input type="text" class="textsize" name="name" placeholder="氏名を入力してください" required="required" value=${name} >
			</label></p>


			<p><label>クラス<br>
			<select name="class_num">
			<c:forEach var="class_num" items="${class_num}">
            <option value=${class_num.classNum}>${class_num.classNum}</option>
            </c:forEach>
			</select>
			</label></p>

			<p><label>誕生日<br>
			<input type="text" class="textsize" name="birth_day" placeholder="誕生日を入力してください	" required="required" value=${birthday} >
			</label></p>

            <button type="submit" class="StudentCreate.action">
            登録して終了
            </button>

            </form>


	<form action="../student/student_list_action" method="get">
    <button type="submit" class="StudentCreate.action">戻る</button>
    </form>
     </section>
    </div>
    </c:param>
</c:import>
