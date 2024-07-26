<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<style>
/* フォーム全体のスタイル */
form {
   max-width: 400px;
   margin: auto;
   padding: 20px;
   border: 1px solid #ccc;
   border-radius: 8px;
   box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
   background-color: #f9f9f9;
}
/* 各入力フィールドのスタイル */
input[type="text"],
input[type="password"] {
   width: calc(100% - 22px);
   padding: 10px;
   margin-bottom: 10px;
   border: 1px solid #ddd;
   border-radius: 4px;
   font-size: 16px;
}
/* チェックボックスとラベルのスタイル */
input[type="checkbox"] {
   margin-right: 8px;
}
label {
   font-size: 14px;
   color: #333;
}
/* ボタンのスタイル */
input[type="submit"] {
   background-color: #D3EDFB;
   color: white;
   padding: 10px 20px;
   border: none;
   border-radius: 4px;
   cursor: pointer;
   font-size: 17px;
}
input[type="submit"]:hover {
   background-color: #9FD9F6;
}
</style>

<head>
<link rel="stylesheet" href="../css/style.css">
</head>

<body>
<form action="login_execute_action" method="post">
<p>ID<input type="text" name="id"></p>
<p>パスワード
<input type="password" id="password" name="password">
<input type="checkbox" id="showPassword" onclick="togglePasswordVisibility()">
<label for="showPassword">パスワード表示</label>
</p>
<p id="error-message">${message}</p>
<p><input type="submit" value="ログイン" ></p>
</form>
</body>
<script>
function togglePasswordVisibility() {
   var passwordField = document.getElementById('password');
   var showPasswordCheckbox = document.getElementById('showPassword');
   if (showPasswordCheckbox.checked) {
       passwordField.type = 'text';
   } else {
       passwordField.type = 'password';
   }
}
</script>
<%@include file="../footer.html" %>