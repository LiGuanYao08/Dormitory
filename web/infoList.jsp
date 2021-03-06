<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>系统设置列表</title>
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
                <li><a href="/teacherInfo.jsp">查看个人信息</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="/studentList.jsp">学生管理</a>
                </li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="/teacherList.jsp">教师管理</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li class="active"><a href="/infoList.jsp">系统设置<span
                        class="sr-only">(current)</span></a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">欢迎使用</h1>
            <div class="row placeholders">
                <!--内容放置-->
                <h2 class="sub-header">系统设置</h2>
                <div class="panel-group" id="accordion">
                    <!--学院设置-->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse"
                                   data-parent="#accordion"
                                   href="#collapseOne">
                                    查看学院设置
                                </a>
                            </h4>
                        </div>
                        <div id="collapseOne"
                             class="panel-collapse collapse in">
                            <!--学院-->
                        </div>
                    </div>
                    <!--专业设置-->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse"
                                   data-parent="#accordion"
                                   href="#collapseTwo">
                                    查看专业设置
                                </a>
                            </h4>
                        </div>
                        <div id="collapseTwo" class="panel-collapse collapse">
                            <!--专业-->
                        </div>
                    </div>
                    <!--年级设置-->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse"
                                   data-parent="#accordion"
                                   href="#collapseThree">
                                    查看年级设置
                                </a>
                            </h4>
                        </div>
                        <div id="collapseThree" class="panel-collapse collapse">
                            <!--年级-->
                        </div>
                    </div>
                </div>
                <!--增加按钮-->
                <button
                        type="button"
                        class="btn btn-primary"
                        onclick="addInfo();">添加新设置
                </button>
            </div>
        </div>
    </div>
</div>

<script src="/static/js/infoList.js"></script>
<!-- Bootstrap js-->
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>
