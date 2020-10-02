<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<title>日次勤怠記録表示</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
<form action="./Record" method="post">
<input type="date" name="date" value="">
<input type="submit" class="btn-sm btn-warning" value="決定" />
</form>
<form action="./employeeRecord" method="post">
<input type="text" name="name" value="" placeholder="従業員氏名">
<input type="submit" class="btn-sm btn-warning" value="決定" />
</form>
<div class="container">
<h1><strong>日次勤怠記録表示</strong></h1>
<table class="table table-bordered table-hover">
 <th align="center" bgcolor="orange">日付</th>
<c:forEach items="${dailyRecordList}" var="dailyRecord" end="0">
 <td><c:out value="${dailyRecord.date}"/></td>
</c:forEach>
</table>
 <div class="row">
<table class="table table-bordered table-hover">

 <tr align="center" bgcolor="orange">
 <th align="center" width="10%">ID</th>
 <th width="17%">名前</th>
 <th width="12%">出勤時間</th>
 <th width="12%">休憩開始</th>
 <th width="12%">休憩終了</th>
 <th width="12%">退勤時間</th>
 <th width="10%">実働時間</th>
 <th width="10%">休憩時間</th>
 <%-- <th width="10%">編集</th>
 <th width="10%">削除</th>--%>
  </tr>
 <c:forEach items="${dailyRecordList}" var="dailyRecord">
 <tr align="center">
 <td><c:out value="${dailyRecord.employeeId}" /></td>
 <td><c:out value="${dailyRecord.name}" /></td>
 <td><fmt:formatDate value="${dailyRecord.startedWork}" type="TIME" timeStyle="SHORT" /></td>
 <td><fmt:formatDate value="${dailyRecord.startedBreak}" type="TIME" timeStyle="SHORT" /></td>
 <td><fmt:formatDate value="${dailyRecord.endedBreak}" type="TIME" timeStyle="SHORT" /></td>
 <td><fmt:formatDate value="${dailyRecord.endedWork}" type="TIME" timeStyle="SHORT" /></td>
 <td><c:out value="${dailyRecord.totalWork}" /></td>
 <td><c:out value="${dailyRecord.totalBreak}" /></td>
 <%-- <td><a href="editEmployee?id=<c:out value="${employee.id}" />"><input type="submit" class="btn-success" value="編集" /></a></td>
 <td><a href="deleteAttendance?id=<c:out value="${dailyRecord.id}" />"><input type="submit" class="btn-danger" value="削除" /></a></td>
 --%>
 </tr>
 </c:forEach>
</table>
</div>
</div>

<br>

<p>
 <a href="menu"><input type="submit" class="btn-success" value="メニューへ" />
</a>
</p>
<p><a href="logout"><input type="submit" class="btn-primary" value="ログアウト" />
</a>
<script src="js/jquery-2.2.4.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>