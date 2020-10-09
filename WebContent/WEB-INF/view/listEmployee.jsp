<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<title>従業員管理</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1>
			<strong>従業員一覧</strong>
		</h1>
		<div class="row">
			<table class="table table-bordered table-hover">

				<tr align="center" bgcolor="orange">
					<th><div class="col-2">ID</div></th>
					<th><div class="col-6">名前</div></th>
					<th><div class="col-2">編集</div></th>
					<th><div class="col-2">削除</div></th>
				</tr>

				<c:forEach items="${employeeList}" var="employee">
					<tr>
						<td><div class="col-2">
								<c:out value="${employee.id}" />
							</div></td>
						<td><div class="col-6">
								<c:out value="${employee.name}" />
							</div></td>
						<td><div class="col-2">
								<a href="editEmployee?id=<c:out value="${employee.id}" />"><input
									type="submit" class="btn-success" value="編集" /></a>
							</div></td>
						<td><div class="col-2">
								<a href="deleteEmployee?id=<c:out value="${employee.id}" />"><input
									type="submit" class="btn-danger" value="削除" /></a>
							</div></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<br>
	<p>
		<a href="addEmployee"><input type="submit" class="btn-warning"
			value="従業員の追加" /> </a>
	</p>
	<p>
		<a href="menu"><input type="submit" class="btn-success"
			value="メニューへ" /> </a>
	</p>
	<p>
		<a href="logout"><input type="submit" class="btn-primary"
			value="ログアウト" /> </a>
		<script src="js/jquery-2.2.4.min.js"></script>
		<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>