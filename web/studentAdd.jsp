<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加学生</title>
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
                <li class="active"><a href="/studentList.jsp">学生管理<span
                        class="sr-only">(current)</span></a>
                </li>
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
            <div class="row placeholders">
                <!--内容放置-->
                <h2 class="sub-header">添加新学生</h2>

                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="stuName" class="col-sm-2 control-label">学生姓名：</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="stuName"
                                   placeholder="请输入学生姓名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="stuNumber" class="col-sm-2 control-label">学生学号：</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control"
                                   id="stuNumber" placeholder="请输入学生学号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="stuPhone" class="col-sm-2 control-label">联系方式：</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control"
                                   id="stuPhone" placeholder="请输入联系方式">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="stuClass" class="col-sm-2 control-label">学生班级：</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control"
                                   id="stuClass" placeholder="请输入名字学生班级">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="stuCollege" class="col-sm-2 control-label">所在学院：</label>
                        <div class="col-sm-8">
                            <select class="form-control" id="stuCollege">
                                <!--学院集合-->
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="stuMajor" class="col-sm-2 control-label">所在专业：</label>
                        <div class="col-sm-8">
                            <select class="form-control" id="stuMajor">
                                <!--专业集合-->
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="stuGrade" class="col-sm-2 control-label">所在年级：</label>
                        <div class="col-sm-8">
                            <select class="form-control" id="stuGrade">
                                <!--年级集合-->
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="stuGender" class="col-sm-2 control-label">学生性别：</label>
                        <div class="col-sm-8">
                            <select class="form-control" id="stuGender">
                                <option>男</option>
                                <option>女</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="stuJobStatus"
                               class="col-sm-2 control-label">班级职位：</label>
                        <div class="col-sm-8">
                            <select class="form-control" id="stuJobStatus">
                                <!--学生职位-->
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="stuHouseAddress"
                               class="col-sm-2 control-label">家庭住址：</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control"
                                   id="stuHouseAddress" placeholder="请输入家庭住址">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="stuRemark">学生情况：</label>
                        <textarea class="form-control" rows="3"
                                  id="stuRemark"></textarea>
                    </div>
                </form>

                <!--增加按钮-->
                <button type="button" class="btn btn-primary"
                        onclick="add();">添加学生
                </button>
            </div>
        </div>
    </div>
</div>
<script src="/static/js/studentAdd.js"></script>
<!-- Bootstrap js-->
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>
