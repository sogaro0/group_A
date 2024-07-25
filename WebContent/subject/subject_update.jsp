<%-- 科目一覧JSP --%>
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
            <h2 class="h3 mb-3 fw-norma subject bg-opacity-10 py-2 px-4">科目情報変更</h2>

		<script type="text/javascript">
 			document.getElementById("year").innerHTML = getYear();

 			function getYear() {
   				var nowYear = now.getFullYear();
   				return nowYear;
		  }
		 </script>

			<p><span id="year"></span></p>

			<form action="../subject/SubjectUpdateExcute.action" method="get">


			<label class="mx-3">科目コード</label><br>
			<input class="mx-3 select-shape3" type="text" value="<%=request.getParameter("cd")%>" name='cd'readonly><br>

			<label class="mx-3">科目名</label><br>
			<input class="select-shape2 mx-3" type="text"  name="name" placeholder="<%=request.getParameter("name")%>"  value="${name}" required="required">

            <button class="mx-3" type="submit" class="SubjectUpdate.action">
            変更
            </button>
			</form>

            <form class="mx-3" action="../subject/SubjectList.action" method="get">
   			<button type="submit" class="SubjectCreate.action">科目一覧</button>
   			</form>


        </section>

    </div>
    </c:param>
</c:import>
