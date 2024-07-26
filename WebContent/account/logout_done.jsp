<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<style>
.logout-done-container {
   max-width: 400px;
   margin: auto;
   padding: 20px;
   border: 1px solid #ccc;
   border-radius: 8px;
   box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
   background-color: #f9f9f9;
   text-align: center;
}
.logout-done-container h2 {
   font-size: 24px;
   margin-bottom: 20px;
}
.logout-done-container p {
   font-size: 16px;
   margin-bottom: 20px;
}
.logout-done-container a {
   display: inline-block;
   margin-top: 10px;
   background-color: #D3EDFB;
   color: white;
   padding: 10px 20px;
   border: none;
   border-radius: 4px;
   cursor: pointer;
   font-size: 16px;
   text-decoration: none;
}
.logout-done-container a:hover {
   background-color: #9FD9F6;
}
</style>
<div class="logout-done-container">
<h2>ログアウトが完了しました</h2>
<a href="login.jsp">ログインページへ戻る</a>
</div>
<%@include file="../footer.html" %>