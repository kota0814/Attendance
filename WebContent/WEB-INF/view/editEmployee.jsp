<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>従業員管理</title>
</head>
<body>
	<h1>従業員編集</h1>
	<form action="" method="post">
		<table border="1">
			<tr>
				<th>名前</th>
				<td><c:if test="${not empty nameError}">
						<p>
							<c:out value="※${nameError}" />
						</p>
					</c:if> <input type="text" name="name" value="<c:out value="${name}" />" />
				</td>
			</tr>
		</table>
		<p>
			<input type="submit" value="保存" />
		</p>
	</form>
	<p>
		<a href="listEmployee">従業員一覧へ戻る</a>
	</p>
</body>
</html>