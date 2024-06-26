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

            <form method="get">
                <div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
                <div class="col-4">
                <p>科目情報</p>
                    <div class="col-4">
                        <label class="form-label" for="student-f1-select">入学年度</label>
                        <select class="form-select" id="student-f1-select" name="f1">
                            <option value="O">--------</option>
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
                            <option value="O">--------</option>
                            <c:forEach var="num" items="${class_num_set}">
                                <%-- 現在numと選択されていたがf2が一致していた場合selectedを追記 --%>
                                <option value="${num}" <c:if test="${num==f2}">selected</c:if>>${num}></option>
                            </c:forEach>
                        </select>
                    </div>
					<div class="col-4">
                        <label class="form-label" for="student-f2-select">科目</label>
                        <select class="form-select" id="student-f2-select" name="f3">
                            <option value="O">--------</option>
                            <c:forEach var="num" items="${class_num_set}">
                                <%-- 現在numと選択されていたがf2が一致していた場合selectedを追記 --%>
                                <option value="${num}" <c:if test="${num==f3}">selected</c:if>>${num}></option>
                            </c:forEach>
                        </select>
                    </div>
					<div class="col-2 text-center">
                        <button class="btn btn-secondary" id="filter-button">検索</button>
                    </div>
                    <div class="mt-2 text-warning">${errors.get("f1")}</div>
                </div>
                </div>
            </form>

            <form method="get">
                <div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
                <div class="col-4">
                <p>学生情報</p>
                    <div class="col-4">
                        <label class="form-label" for="student-f1-select">学生番号</label>
                        <select class="form-select" id="student-f1-select" name="f4">
                            <option value="O">--------</option>
                        </select>
                    </div>
					<div class="col-2 text-center">
                        <button class="btn btn-secondary" id="filter-button">検索</button>
                    </div>
                    <div class="mt-2 text-warning">${errors.get("f1")}</div>
                </div>
                </div>
            </form>
        </section>
        <p>
        </p>
        </div>
    </c:param>
</c:import>

