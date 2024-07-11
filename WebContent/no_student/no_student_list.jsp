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
            <h2 class="h3 mb-3 fw-norma bg-light bg-opacity-10 py-2 px-4">退学者リスト</h2>
            <div class="my-2 text-end px-4">
            </div>
            <form action="no_student_search" method="get">
                <div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
                    <div class="col-4">
                        <label class="form-label" for="student-f1-select">入学年度</label>
                        <select class="form-select" id="student-f1-select" name="f1">
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
						<label class="form-label" for="student-f2-select">クラス</label>
						<select class="form-select" id="student-f2-select" name="f2">
						<option value="0">--------</option>
						<c:forEach var="class_num" items="${class_num_set}">
						<%-- 現在numと選択されていたがf2が一致していた場合selectedを追記 --%>
						<option value=${class_num.classNum } <c:if test="${class_num.classNum==f2}">selected</c:if>>${class_num.classNum}</option>
						</c:forEach>
						</select>
					</div>

                    <div class="col-2 text-center">
                        <button class="btn btn-secondary" id="filter-button">絞込み</button>
                    </div>


                    <div class="mt-2 text-warning">${errors.get("f1")}</div>
                </div>
            </form>
            <c:choose>
                <c:when test="${students.size()>0}">
                    <div>検索結果:${students.size()}件</div>
                    <table class="table table-hover">
                        <tr>
                            <th>入学年度</th>
                            <th>学生番号</th>
                            <th>氏名</th>
                            <th>クラス</th>
                            <th class="text-center">在学中</th>
                             <th>誕生日<th>
                            <th></th>
                            <th></th>
                        </tr>
                        <c:forEach var="student" items="${students}">
                            <tr>
                                <td>${student.entYear}</td>
                                <td>${student.no}</td>
                                <td>${student.name}</td>
                                <td>${student.classNum}</td>
                                <td class="text-center">
                                    <%-- 在学フラグがたっている場合[〇]それ以外は[×]を表示 --%>
                                    <c:choose>
                                      <c:when test="${student.getIsAttend()}">
                                        〇
                                      </c:when>
                                      <c:otherwise>
                                        ×
                                      </c:otherwise>
                                    </c:choose>
                                </td>
                               	<td>${student.birthDay}</td>
                                <td><a href="../no_student/no_student_update_action?ent_year=${student.entYear}&no=${student.no}&name=${student.name}&classnum=${student.classNum}&birth_day=${student.birthDay}">変更</a></td>
                                <td><a href="no_student_delete.jsp?no=${student.no}">削除</a></td>
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
        ${forward_test}
        ${forward_test2}
        ${name}
        </p>
        </div>
    </c:param>
</c:import>

