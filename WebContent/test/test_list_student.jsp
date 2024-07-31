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
    <c:import url="/common/sidemenu.jsp"></c:import>
        <section class="mo-4">
            <h2 class="h3 mb-3 fw-norma bg-opacity-10 py-2 px-4 grade">成績参照</h2>
            <div class="my-2 text-end px-4">
            </div>

            <form action="TestListSubjectExecute.action" method="get">
                <div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
                <div class="test-wide mx-3">
                <p>科目情報</p>
                    <div class="col-xl select-wide">
                        <label class="form-label" for="student-f1-select">入学年度</label><br>
                        <select class="form-select" id="student-f1-select" name="f1">
                            <option value=0>--------</option>
                            <c:forEach var="year" items="${ent_year}">
							<option value=${year.entYear}>${year.entYear}</option>
							</c:forEach>
                        </select>
                    </div>
                    <div class="col-xl">
                        <label class="form-label" for="student-f2-select">クラス</label><br>
                        <select class="form-select" id="student-f2-select" name="f2">
                            <option value="0">--------</option>
                            <c:forEach var="num" items="${class_num}">
                            <option value=${num.classNum}>${num.classNum}</option>
                            </c:forEach>
                        </select>
                    </div>
					<div class="col-xl">
                        <label class="form-label" for="student-f2-select">科目</label><br>
                        <select class="form-select" id="student-f2-select" name="f3">
                            <option value="0">--------</option>
						<c:forEach var="subject" items="${subject_name}">
                            <option value=${subject.name}>${subject.name}</option>
                            </c:forEach>
                        </select>
                    </div>
					<div class="col-1 text-center">
                        <button class="btn btn-secondary" id="filter-button">検索</button>
                    </div>
                    <div class="mt-2 text-warning">${errors.get("f1")}</div>
                </div>
                </div>
            </form>

            <form action="TestListStudentExecute.action" method="get">
                <div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
                <div class="test-wide mx-3">
                <p>学生情報</p>
                    <div class="col-xl select-wide">
                        <label class="form-label" for="student-f1-select">学生番号</label><br>

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

                    <c:forEach var="name" items="${test}" end="0">
					   <div class="mx-3">
						<p>氏名:${name.name}(${name.studentNum})</p>
	                   </div>
	                 </c:forEach>

                    <table class="test-table table-hover mx-3">
                        <tr>
                            <th class="test-table-wide test-boder">科目名</th>
                            <th class="test-table-wide test-boder">科目コード</th>
                            <th class="test-table-wide test-boder">回数</th>
                            <th class="test-table-wide test-boder">点数</th>
                            <th class="test-table-wide test-boder text-center">判定</th>

                        </tr>
                        <c:forEach var="test" items="${test}">
                            <tr>
                               <td class="test-table-wide test-boder">${test.subject}</td>
                               <td class="test-table-wide test-boder">${test.subject_cd}</td>
                               <td class="test-table-wide test-boder">${test.no}</td>
                               <td class="test-table-wide test-boder">
                               <c:choose>
                            	<c:when test="${test.point == -1}">
                                －
                            	</c:when>
                            	<c:otherwise>
                                ${test.point}
                            	</c:otherwise>
                        		</c:choose>
                        		<td class="test-table-wide test-boder text-center">
                                    <c:choose>
                                      <c:when test="${test.is_pass==true}">
                                        〇
                                      </c:when>
                                      <c:when test="${test.point == -1}">
                                        －
                                      </c:when>
                                      <c:otherwise>
                                        ×
                                      </c:otherwise>
                                    </c:choose>
                                </td>


                            </tr>
                        </c:forEach>
                    </table>
                </c:when>
                <c:otherwise>
                    <div class="mx-3">成績情報が存在しませんでした</div>
                </c:otherwise>
            </c:choose>
        </section>
        <p>
        </p>
        </div>
    </c:param>
</c:import>
