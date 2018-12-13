<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>这里是登录界面喔</title>
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <!-- Bootstrap jq-->
    <script src="/static/bootstrap-3.3.7-dist/jquery/jquery-3.3.1.min.js"></script>
    <!-- Bootstrap css-->
    <link href="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
          rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/static/css/signin.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form class="form-signin" action="/login" method="post">
        <h2 class="form-signin-heading">---登录---</h2>
        <label for="inputEmail" class="sr-only">Teachers work Number</label>
        <input type="text" id="inputEmail" name="teaNumber" class="form-control"
               placeholder="Teachers work Number" required autofocus>
        <label for="inputPassword" class="sr-only">Teacher Password</label>
        <input type="password" id="inputPassword" name="teaPassword"
               class="form-control" placeholder="Teacher Password" required>
        <div class="checkbox">
            <label>
                <a href="/index.jsp">回到主页</a>
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登 &nbsp
            录
        </button>
        <span style="color: red">${requestScope.code}</span>
    </form>

</div>
<!-- /container -->
<!-- Bootstrap js-->
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>
