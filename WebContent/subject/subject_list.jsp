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

    <c:import url="/common/sidemenu.jsp"></c:import>

    <div class="function">
        <section class="mo-4">
            <h2 class="h3 mb-3 fw-norma bg-opacity-10 py-2 px-4 C subject">科目管理</h2>
            <div class="my-2 text-end px-4">
                <a href="../subject/SubjectCreate.action">新規登録</a>
            </div>

            <c:choose>
                <c:when test="${subject.size()>0}">
                    <table class="test-table table-hover mx-3">
                        <tr>
                            <th class="subject-boder test-table-wide">科目コード</th>
                            <th class="subject-boder test-table-wide">科目名</th>
                            <th class="subject-boder test-table-width"></th>
                            <th class="subject-boder test-table-width"></th>
                        </tr>
                        <c:forEach var="subject" items="${subject}">
                            <tr>
                                <td class="subject-table-wide test-boder">${subject.cd}</td>
                                <td class="subject-table-wide test-boder">${subject.name}</td>
                                <td class="subject-table-width test-boder"><a href="SubjectUpdate.action?cd=${subject.cd}&name=${subject.name}">変更</a></td>
                                <td class="subject-table-width test-boder"><a href="subject_delete.jsp?cd=${subject.cd}">削除</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>
                <c:otherwise>
                    <div>科目情報が存在しませんでした</div>
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