<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<title>勤怠管理</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
<div class ="container">
<h1>勤怠管理システム ログイン</h1>

<c:if test="${not empty error}">
<p>ログイン ID かパスワードが正しくありません。</p>
</c:if>
<form action="" method="post">
 <p>
 <input type="text" name="loginId" placeholder="ログイン ID" />
 </p>
 <p>
 <input type="password" name="loginPass"
 placeholder="パスワード" />
 </p>
 <p>
 <div class="form-group">
 <input type="submit" class="btn-primary" value="ログイン" />
 </div>
 </form>
 </div>
<script src="js/jquery-2.2.4.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>