<%-- 成績管理一覧JSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 文字化けの対策 --%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>


<c:import url="/common/base.jsp">
    <c:param name="scripts"></c:param>

	<c:param name="title">
        <h1 class="toptitle">得点管理システム</h1>
    </c:param>

    <c:param name="content">
    <div class="row">
    <c:import url="/common/sidemenu.jsp"></c:import>
        <section class="mo-4">
            <h2 class="h3 mb-3 fw-norma bg-light bg-opacity-10 py-2 px-4">成績管理</h2>
            <form action="../test/test_regist_action" method="get">
                <div class="test-wide border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
                    <div class="col-4">
                        <label class="form-label" for="test-f1-select">入学年度</label><br>
                        <select class="form-select" id="test-f1-select" name="f1">
                            <option value="0">--------</option>
                            <c:forEach var="year" items="${year_list}">
							<option value=${year}>${year}</option>
							</c:forEach>
                            <c:forEach var="year" items="${ent_year_set}">
                                <%-- 現在のyearと選択されていたf1が一致していた場合selectedを追記 --%>
                                <option value="${year}" <c:if test="${year==f1}">selected</c:if>>${year}></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-4">
                        <label class="form-label" for="test-f2-select">クラス</label><br>
                        <select class="form-select" id="test-f2-select" name="f2">
                            <option value="0">--------</option>
                            <c:forEach var="class_num" items="${class_num_set}">
                                <%-- 現在numと選択されていたがf2が一致していた場合selectedを追記 --%>
                                <option value=${class_num.classNum } <c:if test="${class_num.classNum==f2}">selected</c:if>>${class_num.classNum}</option>
                            </c:forEach>
                        </select>
                    </div>
                  <div class="col-4">
                        <label class="form-label" for="test-f3-select">科目</label><br>
                        <select class="form-select" id="test-f3-select" name="f3">
                            <option value="0">--------</option>
                            <c:forEach var="subject" items="${subject}">
                                <%-- 現在numと選択されていたがf3が一致していた場合selectedを追記 --%>
                                <option value=${subject.cd } <c:if test="${subject.name==f3}">selected</c:if>>${subject.name}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="col-4">
                    	<label class="form-label" for="test-f4-select">回数</label><br>
                    	<select class="times" id="test-f4-select" name="f4">
                    		<option value="0">--------</option>
                    		<c:forEach var="test" items="${test}">
                                <%-- 現在numと選択されていたがf4が一致していた場合selectedを追記 --%>
                                <option value=${test.times } <c:if test="${test.times==f4}">selected</c:if>>${test.times}</option>
                            </c:forEach>
                    	</select>
                    </div>
                    <div>
                    	<input type="hidden" name="f5" value="abc">
                    </div>

                    <div class="col-2 text-center">
                        <button class="btn btn-secondary" id="filter-button">検索</button>
                    </div>
                    <div class="mt-2 text-warning">${errors.get("f1")}</div>
                </div>
            </form>

				<!-- リスト表示 -->
				<c:choose>
					<c:when test="${not empty result}">
						<c:forEach var="result" items="${result}" end="0">
							<div>
								<p>科目:${result.subject}(${result.times}回)</p>
	                    	</div>
	                    </c:forEach>
				<form action="test_rejist_execute_action" method="get">
                    <table class="table table-hover">

                        	<tr>
                            	<th>入学年度</th>
                            	<th>クラス</th>
                            	<th>学生番号</th>
                            	<th>氏名</th>
                            	<th>点数</th>
                        	</tr>
                        	<c:forEach var="result" items="${result}">
                            	<tr>
                                	<td>${result.entYear}</td>
                                	<td>${result.classNum}</td>
                                	<td>${result.studentNum}</td>
                                	<td>${result.name}</td>
                                	<td><input type="text" class="point" name="point_${studentNum}" value=${result.point}></td>
                                	<input type="hidden" class="point" name="studentNum" value=${result.studentNum}>
                                </tr>
                        	</c:forEach>
                    </table>
                   	<button type="submit" class="TestRejistExecuteAction">登録して終了</button>
                  </form>
					</c:when>
				</c:choose>

		 </section>
        <p>
        ${forward_test}
        ${forward_test2}
        ${name}
        </p>
        </div>

    </c:param>
</c:import>
