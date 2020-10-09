<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<title>個人勤怠記録表示</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1>
			<strong>個人勤怠記録表示</strong>
		</h1>
		<form action="./monthlyEmployeeRecord" method="post">
			<input type="text" name="name" value="" placeholder="従業員氏名">
			<input type="date" name="date1" value="date1">～<input
				type="date" name="date2" value="date2"> <input type="submit"
				class="btn-sm btn-warning" value="決定" />
		</form>
		<br>
		<div class="row">
			<table class="table table-bordered table-hover">
				<tr align="center" bgcolor="orange">
					<th width="15%">従業員ID</th>
					<th width="35%">名前</th>
				</tr>


				<c:forEach items="${dailyRecordList}" var="dailyRecord" end="0">
					<tr>
						<td><c:out value="${dailyRecord.employeeId}" /></td>
						<td><c:out value="${dailyRecord.name}" /></td>
				</c:forEach>
			</table>
		</div>

		<div class="row">
			<table class="table table-bordered table-hover">

				<tr align="center" bgcolor="orange">
					<th width="10%">日付</th>
					<th width="15%">出勤時間</th>
					<th width="15%">休憩開始</th>
					<th width="15%">休憩終了</th>
					<th width="15%">退勤時間</th>
					<th width="10%">実働時間</th>
					<th width="10%">休憩時間</th>
				</tr>

				<c:forEach items="${dailyRecordList}" var="dailyRecord">
					<tr align="center">
						<%--<td><c:out value="${dailyRecord.date}"/></td> --%>
						<td><fmt:formatDate value="${dailyRecord.date}" type="Date"
								timeStyle="SHORT" /></td>
						<td><fmt:formatDate value="${dailyRecord.startedWork}"
								type="TIME" timeStyle="SHORT" /></td>
						<td><fmt:formatDate value="${dailyRecord.startedBreak}"
								type="TIME" timeStyle="SHORT" /></td>
						<td><fmt:formatDate value="${dailyRecord.endedBreak}"
								type="TIME" timeStyle="SHORT" /></td>
						<td><fmt:formatDate value="${dailyRecord.endedWork}"
								type="TIME" timeStyle="SHORT" /></td>
						<td><c:out value="${dailyRecord.totalWork}" /></td>
						<td><c:out value="${dailyRecord.totalBreak}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<br>

	<p>
		<a href="menu"><input type="submit" class="btn-success"
			value="メニュー" /> </a>
	</p>
	<p>
		<a href="logout"><input type="submit" class="btn-primary"
			value="ログアウト" /> </a>
		<script src="js/jquery-2.2.4.min.js"></script>
		<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>