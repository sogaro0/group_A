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
    <c:import url="/common/sidemenu.jsp"></c:import>
        <section class="mo-4">
            <h2 class="h3 mb-3 fw-norma bg-light bg-opacity-10 py-2 px-4">成績参照</h2>
            <div class="my-2 text-end px-4">
            </div>

            <form action="test_list_subject_execute_action" method="get">
                <div class="border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
                <div class="test-wide col-xl">
                <p>科目情報</p>
                    <div class="col-xl">
                        <label class="form-label" for="student-f1-select">入学年度</label>
                        <select class="form-select" id="student-f1-select" name="f1">
                            <option value= 0>--------</option>
                            <c:forEach var="year" items="${ent_year}">
							<option value=${year.entYear}>${year.entYear}</option>
							</c:forEach>
                        </select>
                    </div>
                    <div class="col-xl">
                        <label class="form-label" for="student-f2-select">クラス</label>
                        <select class="form-select" id="student-f2-select" name="f2">
                            <option value="0">--------</option>
                            <c:forEach var="num" items="${class_num}">
                            <option value=${num.classNum}>${num.classNum}</option>
                            </c:forEach>
                        </select>
                    </div>
					<div class="col-xl">
                        <label class="form-label" for="student-f2-select">科目</label>
                        <select class="form-select" id="student-f2-select" name="f3">
                            <option value="0">--------</option>
						<c:forEach var="subject" items="${subject_name}">
                            <option value=${subject.name}>${subject.name}</option>
                            </c:forEach>
                        </select>
                    </div>
					<div class="col-xl text-center">
                        <button class="btn btn-secondary" id="filter-button">検索</button>
                    </div>
                    <div class="mt-2 text-warning">${errors.get("f1")}</div>
                </div>
                </div>
            </form>



            <form method="get">
                <div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
               <div class="test-wide col-xl">
                <p>学生情報</p>
                    <div class="col-4">
                        <label class="form-label" for="student-f1-select">学生番号</label>

					<input type="text" maxlength="10" name="cd" placeholder="学生番号を入力してください" required="required" value=${""} >
                    </div>
					<div class="col-xl text-center">
                        <button class="btn btn-secondary" id="filter-button">検索</button>
                    </div>
                    <div class="mt-2 text-warning">${errors.get("f1")}</div>
                </div>
                </div>
            </form>
             <!-- リスト表示 -->
				<c:choose>
					<c:when test="${test.size()>0}">
					<div>検索結果:${test.size()}件</div>
                    	<table class="table table-hover">
                        	<tr>
                            	<th>入学年度</th>
                            	<th>クラス</th>
                            	<th>学生番号</th>
                            	<th>氏名</th>
                            	<th>1回</th>
                            	<th>2回</th>
                        	</tr>
                        	<c:forEach var="test" items="${test}">
                            	<tr>
                                	<td>${test.entYear}</td>
                                	<td>${test.classNum}</td>
                                	<td>${test.no}</td>
                                	<td>${test.name}</td>
                                	<td>${test.point}</td>
                                	<td>${test.point2}<td>
                                </tr>
                        	</c:forEach>
                    </table>
					</c:when>
				<c:otherwise>
                    <div>学生情報が存在しませんでした</div>
                </c:otherwise>
				</c:choose>
        </section>
        <p>
        </p>
        </div>
    </c:param>
</c:import>

