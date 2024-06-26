<%@ page contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8" %>

<section class="col-lg-2 side">

<button class="dis_none_bt">×</button>

<div class="display_none active">
<a class="sidemenu_title">サイドメニュー</a>
<div class="my-2 text-end px-4">
<a href="../menu/menu.jsp">メニュー</a>
</div>

	<a class="sidemenu_title">・学生管理</a>
	<div class="my-2 text-end px-4">
	<a href="../student/student_list_action" method="get" class="StudentCreate.action">学生管理</a>
	</div>
	<a class="sidemenu_title">・成績管理</a>
	<div class="my-2 text-end px-4">
	<a href="StudentCreate.action">成績登録</a>
	</div>
	<div class="my-2 text-end px-4">
	<a href="StudentCreate.action">成績参照</a>
	</div>
	<a class="sidemenu_title">・科目管理</a>
	<div class="my-2 text-end px-4">
	<a href="../subject/subject_list_action">科目管理</a>
	</div>
	</div>

	<script>
	{
		const displayNone = document.querySelector('.display_none');
		const dis_none_bt = document.querySelector('.dis_none_bt');
		dis_none_bt.addEventListener('click' ,() =>{
		if(displayNone.classList.contains('active')){
			dis_none_bt.textContent ='≡';
			displayNone.style.display = 'none';
			displayNone.classList.remove('active');
		}

		else {
			dis_none_bt.textContent ='×';
			displayNone.style.display = 'block';
			displayNone.classList.add('active');
		}
		});
	}
	</script>
</section>
