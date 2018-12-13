<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>查看教师个人信息</title>
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <!-- Bootstrap jq-->
    <script src="/static/bootstrap-3.3.7-dist/jquery/jquery-3.3.1.min.js"></script>
    <!-- Bootstrap css-->
    <link href="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
          rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/static/css/dashboard.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed"
                    data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand"
               href="#">欢迎你：${sessionScope.teacherInfo.teaName} ${sessionScope.teacherInfo.teacherJob.teaPositionInfo}</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/logout">安全退出</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li><a href="/adminIndex.jsp">回到主页</a>
                </li>
                <li class="active"><a href="/teacherInfo.jsp">查看个人信息<span
                        class="sr-only">(current)</span></a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="/studentList.jsp">学生管理</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="/teacherList.jsp">教师管理</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="/infoList.jsp">系统设置</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">欢迎使用</h1>
            <img id="imgURL" class="img-thumbnail"
                 style="width: 200px;height: 200px;margin-left: 0;margin-bottom: 10px">
            <div class="row placeholders">
                <form class="form-inline">
                    <div class="form-group">
                        <label for="exampleInputName2">姓名：</label>
                        <input type="text" class="form-control"
                               id="exampleInputName2" readonly>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputName3">工号：</label>
                        <input type="text" class="form-control"
                               id="exampleInputName3" readonly>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputName4">性别：</label>
                        <input type="text" class="form-control"
                               id="exampleInputName4" readonly>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputName5">密码：</label>
                        <input type="password" class="form-control"
                               id="exampleInputName5" readonly>
                    </div>
                </form>
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="inputText3" class="col-sm-2 control-label">所在学院：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control"
                                   id="inputText3" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputText4" class="col-sm-2 control-label">所在专业：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control"
                                   id="inputText4" readonly>
                        </div>
                    </div>
                </form>
                <form class="form-inline">
                    <div class="form-group">
                        <label for="exampleInputName6">教师职位：</label>
                        <input type="text" class="form-control"
                               id="exampleInputName6" readonly>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputName7">就任科目：</label>
                        <input type="text" class="form-control"
                               id="exampleInputName7" readonly>
                    </div>
                </form>
                <form class="form-inline">
                    <div class="form-group">
                        <label for="exampleInputName8">办公地点：</label>
                        <input type="text" class="form-control"
                               id="exampleInputName8" readonly>
                    </div>
                    <div class="form-group">
                        <label for="teaRegistration">登记时间：</label>
                        <input type="text" class="form-control"
                               id="teaRegistration" readonly>
                    </div>
                </form>
                <textarea class="form-control" id="teaInfo" rows="3"
                          readonly></textarea>
                <input type="hidden" id="teaId"
                       value="${sessionScope.teacherInfo.id}"/>
                <form class="form-horizontal">
                    <div class="form-group">
                        <div class="col-sm-10">
                            <p class="form-control-static" id="teaPhone"></p>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="/static/js/teacherInfo.js"></script>
<!-- Bootstrap js-->
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>
