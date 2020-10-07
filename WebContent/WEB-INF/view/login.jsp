<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<title>勤怠管理</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body id="loginPage">

	<div class="container" align="center">
		<div class="container">
			<div class="row">
				<div class="col-md-offset-3 col-md-6">
					<div class="panel panel-default">
						<div class="panel-heading">勤怠管理システム ログイン</div>
						<div class="panel-body">
							<c:if test="${not empty error}">
								<div class="alert alert-danger">ログイン ID かパスワードが正しくありません。</div>
							</c:if>
							<form action="" method="post">
								<div class="form-group">
									<input type="text" name="loginId" placeholder="ログイン ID"
										class="form-control input-lg" />
								</div>
								<div class="form-group">
									<input type="password" name="loginPass" placeholder="パスワード"
										class="form-control input-lg" />
								</div>
								<div class="form-group">
									<input type="submit" class="btn-lg btn-block btn-primary"
										value="ログイン" />
								</div>
							</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script src="js/jquery-2.2.4.min.js"></script>
		<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>