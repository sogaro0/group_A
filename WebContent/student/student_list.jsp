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

    <c:import url="/common/sidemenu.jsp"></c:import>

    <div class="function">
        <section class="mo-4">
            <h2 class="h3 mb-3 fw-norma bg-opacity-10 py-2 px-4 student">学生管理</h2>
            <div class="my-2 text-end px-4">
                <a href="../student/StudentCreate.action">新規登録</a>
            </div>
            <form action="student_search" method="get">
                <div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
                    <div class="col-3 select-style">
                        <label class="form-label" for="student-f1-select">入学年度</label><br>
                        <select class="form-select" id="student-f1-select" name="f1">
                            <option value="0">--------　　</option>
                            <c:forEach var="year" items="${year_list}">
							<option value=${year}>${year}</option>
							</c:forEach>
                            <c:forEach var="year" items="${ent_year_set}">
                                <%-- 現在のyearと選択されていたf1が一致していた場合selectedを追記 --%>
                                <option value="${year}" <c:if test="${year==f1}">selected</c:if>>${year}></option>
                            </c:forEach>
                        </select>
                    </div>
    	           <div class="col-2 select-style">
						<label class="form-label" for="student-f2-select">クラス</label><br>
						<select class="form-select" id="student-f2-select" name="f2">
						<option value="0">--------</option>
						<c:forEach var="class_num" items="${class_num_set}">
						<%-- 現在numと選択されていたがf2が一致していた場合selectedを追記 --%>
						<option value=${class_num.classNum } <c:if test="${class_num.classNum==f2}">selected</c:if>>${class_num.classNum}</option>
						</c:forEach>
						</select>
					</div>
                    <div class="col-2 form-check text-center select-style">
                        <label class="form-check-label" for="student-f3-check">在学中
                            <%-- パラメーターf3が存在している場合checkboxを追記 --%>
                            <input class="from-check-input" type="checkbox"
                            id="student-f3-check" name="f3" value="True"
                            <c:if test="${!empty f3}">checked</c:if> />
                        </label>
                    </div>
                    <div class="col-2 text-center select-style">
                        <button class="btn btn-secondary" id="filter-button">絞込み</button>
                    </div>


                    <div class="mt-2 text-warning">${errors.get("f1")}</div>
                </div>
            </form>
            <c:choose>
                <c:when test="${students.size()>0}">
                    <div class="list-style mx-3">検索結果:${students.size()}件</div>
                    <table class="test-table table-hover mx-3">
                        <tr>
                            <th class="test-boder student-table-wide">入学年度</th>
                            <th class="test-boder student-table-wide">学生番号</th>
                            <th class="test-boder student-table-wide">氏名</th>
                            <th class="test-boder student-table-wide">クラス</th>
                            <th class="test-boder student-table-wide">在学中</th>
                            <th class="test-boder student-table-wide3">誕生日
                            <th class="test-boder student-table-wide"></th>
                            <th class="test-boder student-table-wide"></th>
                        </tr>
                        <c:forEach var="student" items="${students}">
                            <tr>
                                <td class="test-boder student-table-wide">${student.entYear}</td>
                                <td class="test-boder student-table-wide">${student.no}</td>
                                <td class="test-boder student-table-wide">${student.name}</td>
                                <td class="test-boder student-table-wide">${student.classNum}</td>
                                <td class="test-boder student-table-wide">
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
                               	<td class="test-boder student-table-wide">${ student.birthDay}</td>
                                <td class="text-center test-boder student-table-wide"><a href="../student/StudentUpdate.action?ent_year=${student.entYear}&no=${student.no}&name=${student.name}&classnum=${student.classNum}&birth_day=${student.birthDay}">変更</a></td>
                                <td class="text-center test-boder student-table-wide"><a href="student_delete.jsp?no=${student.no}">削除</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>
                <c:otherwise>
                   <div class="mx-3">学生情報が存在しませんでした</div>
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

