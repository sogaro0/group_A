<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<form action="LoginExecute.action" method="post">
<p>ユーザー名<input type="text" name="login"></p>
<p>パスワード<input type="password" name="password"></p>
<p><input type="submit" value="ログイン"></p>
</form>

<%@include file="../footer.html" %>
