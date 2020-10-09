<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>メニュー</title>
</head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<body>
	<h1>
		<p class="text-center">
			<font size="5"><strong>メニュー</strong></font>
		</p>
		<h1>


			<p>
				<a href="listEmployee"><input type="submit"
					class="btn-lg btn-block btn-warning" value="従業員一覧" /> </a>
			</p>
			<br>
			<p>
				<a href="attendance"><input type="submit"
					class="btn-lg btn-block btn-success" value="勤怠登録" /> </a>
			</p>
			<br>
			<p>
				<a href="Record"><input type="submit"
					class="btn-lg btn-block btn-info" value="勤怠記録表示選択画面" /> </a>
			</p>
			<br>
			<p>
				<a href="employeeRecord"><input type="submit"
					class="btn-lg btn-block btn-primary" value="個人勤怠記録表示選択画面" /> </a>
			</p>
			<br>
			<p>
				<a href="logout"><input type="submit"
					class="btn-lg btn-block btn-danger" value="ログアウト" /> </a>
			</p>
			<script src="js/jquery-2.2.4.min.js"></script>
			<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>