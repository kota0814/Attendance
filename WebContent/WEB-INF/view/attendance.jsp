<%@ page pageEncoding="UTF-8" %>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date, java.text.DateFormat" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<title>勤怠登録</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<script>
function clock() {
var myDay = new Array("日","月","火","水","木","金","土");
var now  = new Date();
var year = now.getFullYear(); // 年
var month = now.getMonth()+1; // 月
var date = now.getDate(); // 日
var day = now.getDay();
var hour = now.getHours(); // 時
var min  = now.getMinutes(); // 分
var sec  = now.getSeconds(); // 秒

// 数値が1桁の場合、頭に0を付けて2桁で表示する指定
if(hour < 10) { hour = "0" + hour; }
if(min < 10) { min = "0" + min; }
if(sec < 10) { sec = "0" + sec; }
var clock2 = year + '年' + month + '月' + date + '日' + '（' + myDay[day] + '曜日）'  + hour + '時' + min + '分' + sec + '秒';

document . getElementById( 'clock-02' ) . innerHTML= clock2 . toLocaleString(); // div id="clock-02"

// 1000ミリ秒ごとに処理を実効
window . setTimeout( "clock()", 1000);
}
window . onload = clock;
</script>
</head>
<body>
<div class ="container">
<h1 class="text-center">勤怠登録システム</h1>
 <br>
<font size="6"><div align="center" id="clock-02"></div></font>
 <br>
 <br>


<form action="" method="post">

 <c:if test="${not empty employeeIdError}">
 <p><c:out value="※${employeeIdError}" /></p> </c:if>
 <input type="text" name="employeeId" value="<c:out value="${employeeId}"/>" placeholder="従業員ID" />
 <br>
 <br>
<input type="submit" name="started_work" class="btn-primary btn-block" size="20" value="出勤" pattern="^[0-9]+$"/>
 <br>
 <input type="submit" name="started_break" class="btn-primary btn-block" size="20" value="休憩開始" />
 <br>
 <input type="submit" name="ended_break" class="btn-primary btn-block" size="20" value="休憩終了" />
 <br>
 <input type="submit" name="ended_work" class="btn-primary btn-block" size="80" value="退勤" />
 <br>
 </form></div>
 <p>
 <a href="menu"><input type="submit" class="btn-success" value="メニュー" />
</a>
</p>
<p><a href="logout"><input type="submit" class="btn-warning" value="ログアウト" />
</a></p>
<script src="js/jquery-2.2.4.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>