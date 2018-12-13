<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加教师</title>
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
                <li class="active"><a href="/teacherList.jsp">教师管理<span
                        class="sr-only">(current)</span></a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="/infoList.jsp">系统设置</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">欢迎使用</h1>
            <div class="row placeholders">
                <!--内容放置-->
                <h2 class="sub-header">添加新任教师</h2>
                <div class="upload"
                     style="width: 280px;margin-left:70px;margin-bottom: 20px">

                    <div class="img_center">
                        <img src="" class="img1-img"
                             style="width: 200px;height:200px;">
                        <%--<from id="fromDate" enctype="multipart/form-data">--%>
                        <input type="file" id="browerfile"
                               style="display: none;" class="test">
                        <%--</from>--%>
                        <input type="button" class="btn"
                               onclick="browerfile.click()" value="上传教职工图片">
                    </div>
                    <span style="color: red">*上传限制10M</span>
                </div>
                <%--<input type="file" id="browerfile" name="file" value="点击"/>--%>
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="teaName" class="col-sm-2 control-label">教工姓名：</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="teaName"
                                   placeholder="请输入教师姓名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="teaNumber" class="col-sm-2 control-label">教工学号：</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control"
                                   id="teaNumber" placeholder="请输入教工工号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="teaPhone" class="col-sm-2 control-label">联系方式：</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control"
                                   id="teaPhone" placeholder="请输入联系方式">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="teaPassword" class="col-sm-2 control-label">初始密码：</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control"
                                   id="teaPassword" placeholder="请输入初始密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="teaCollege" class="col-sm-2 control-label">所在学院：</label>
                        <div class="col-sm-8">
                            <select class="form-control" id="teaCollege">
                                <!--学院集合-->
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="teaMajor" class="col-sm-2 control-label">所在专业：</label>
                        <div class="col-sm-8">
                            <select class="form-control" id="teaMajor">
                                <!--专业集合-->
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="teaGender" class="col-sm-2 control-label">教工性别：</label>
                        <div class="col-sm-8">
                            <select class="form-control" id="teaGender">
                                <option>男</option>
                                <option>女</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="teaJobStatus"
                               class="col-sm-2 control-label">任职职位：</label>
                        <div class="col-sm-8">
                            <select class="form-control" id="teaJobStatus">
                                <!--教工职位-->
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="teaSubjects" class="col-sm-2 control-label">就职科目：</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control"
                                   id="teaSubjects" placeholder="请输入就职科目">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="teaWork" class="col-sm-2 control-label">办公地点：</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="teaWork"
                                   placeholder="请输入办公地点">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="teaInfo">基本情况：</label>
                        <textarea class="form-control" rows="3"
                                  id="teaInfo"></textarea>
                    </div>
                </form>
                <!--增加按钮-->
                <button type="button" class="btn btn-primary"
                        onclick="addTeacher();">添加职工
                </button>
            </div>
        </div>
    </div>
</div>
<script src="/static/js/teacherAdd.js"></script>
<!-- Bootstrap js-->
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>
