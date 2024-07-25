<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<style>
.logout-container {
   max-width: 400px;
   margin: auto;
   padding: 20px;
   border: 1px solid #ccc;
   border-radius: 8px;
   box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
   background-color: #f9f9f9;
   text-align: center;
}
.logout-container h2 {
   font-size: 24px;
   margin-bottom: 20px;
}
.logout-container p {
   font-size: 16px;
   margin-bottom: 20px;
}
.logout-container form, .logout-container button {
   display: inline-block;
   margin: 5px;
}
.logout-container input[type="submit"], .logout-container button {
   background-color: #87cefa;
   color: white;
   padding: 10px 20px;
   border: none;
   border-radius: 4px;
   cursor: pointer;
   font-size: 16px;
}
.logout-container input[type="submit"]:hover, .logout-container button:hover {
   background-color: #87c0fa;
}
.logout-container button {
   background-color: #ccc;
   color: black;
}
.logout-container button:hover {
   background-color: #bbb;
}
</style>
<div class="logout-container">
<h2>ログアウト</h2>
<p>本当にログアウトしますか？</p>
<form action="Logout.action" method="post">
<input type="submit" value="ログアウト">
</form>
<button onclick="history.back()">戻る</button>
</div>
<%@include file="../footer.html" %>