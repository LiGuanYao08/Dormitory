//学生职位状态码
var sta;
//加载信息栏
$.ajax({
    type: "GET",
    url: "/getInfo",
    success: function (result) {
        var str1 = "";
        var str2 = "";
        var str3 = "";
        console.log(result);
        //执行方法
        stu();
        //遍历
        for (var i = 0; i < result.length; i++) {
            if (result[i].infoStatus == 0) {
                //学院集合
                str1 += "<option>" + result[i].message + "</option>";
                document.getElementById("stuCollege").innerHTML = str1;
            } else if (result[i].infoStatus == 1) {
                //专业集合
                str2 += "<option>" + result[i].message + "</option>";
                document.getElementById("stuMajor").innerHTML = str2;
            } else if (result[i].infoStatus == 2) {
                //年级集合
                str3 += "<option>" + result[i].message + "</option>";
                document.getElementById("stuGrade").innerHTML = str3;
            }
        }
    }
});

//加载学生职位信息
function stu() {
    $.ajax({
        type: "GET",
        url: "/getStu",
        success: function (result) {
            var str4 = "";
            console.log(result);
            //遍历
            for (var i = 0; i < result.length; i++) {
                //学生职位集合
                str4 += "<option>" + result[i].stuStatus + "：" + result[i].stuPositionInfo + "</option>";
                document.getElementById("stuJobStatus").innerHTML = str4;
            }
        }
    });
};

//添加学生
function add() {
    var stuJobStatus = document.getElementById("stuJobStatus").value;
    var stuSta = stuJobStatus.substr(0, 1);
    //获取当前时间
    var myDate = new Date();
    //获取当前年-月-日
    var mytime = myDate.getFullYear() + "-" + myDate.getMonth() + "-" + myDate.getDate();
    $.ajax({
        type: "POST",
        url: "/insertStudent",
        data: {
            _method: "POST",
            "stuName": $("#stuName").val(),
            "stuNumber": $("#stuNumber").val(),
            "stuJobStatus": stuSta,
            "stuPhone": $("#stuPhone").val(),
            "stuClass": $("#stuClass").val(),
            "stuCollege": $("#stuCollege").val(),
            "stuMajor": $("#stuMajor").val(),
            "stuGrade": $("#stuGrade").val(),
            "stuGender": $("#stuGender").val(),
            "stuHouseAddress": $("#stuHouseAddress").val(),
            "stuRegistration": mytime,//当前时间，年月日
            "stuRemark": "暂无该生信息"
        },
        success: function (result) {
            console.log("添加成功");
            //删除刷新当前页面
            window.location.href = "/studentList.jsp";
        }
    });
};