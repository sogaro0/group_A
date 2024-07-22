<%@ page contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8" %>

<section>

<div class="side-high">
	<button class="btn-menu">≡</button>
</div>
<div class="side-high2">
  <nav>
  	<form action="../menu/menu.jsp" method="get">
  		<button type="submit" class="StudentCreate.action side_bt">メニュー</button>
  	</form>
  	<form action="../student/student_list_action" method="get">
		<button type="submit" class="StudentCreate.action side_bt2">学生管理</button>
  	</form>
  	<form action="../no_student/no_student_list_action" method="get">
		<button type="submit" class="StudentCreate.action side_bt2">退学者リスト</button>
  	</form>
  	<form action="../test/test_regist_action" method="get">
		<button type="submit" class="StudentCreate.action side_bt2">成績登録</button>
  	</form>
  	<form action="../test/test_list_action" method="get">
		<button class="TestCreate.action side_bt2">成績参照</button>
  	</form>
  	<form action="../subject/subject_list_action" method="get">
		<button type="submit" class="SubjectCreate.action side_bt2">科目管理</button>
  	</form>
  </nav>
</div>

	<script>
	{
		const btn = document.querySelector('.btn-menu');
		const nav = document.querySelector('nav');

		btn.addEventListener('click', () => {
		  nav.classList.toggle('open-menu')
		  // if (btn.innerHTML === 'メニュー') {
		  //   btn.innerHTML = '閉じる';
		  // } else {
		  //   btn.innerHTML = 'メニュー';
		  // }
		  // ↑ これと同じ意味の三項演算子での書き方 ↓
		  btn.innerHTML = btn.innerHTML === '≡'
		    ? '×'
		    : '≡'
		});
	}
	</script>
</section>
