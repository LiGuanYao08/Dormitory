//首加载
$.ajax({
    url: "/getTeacherList",
    success: function (result) {
        console.log(result);
        var str = "";
        var tBody = document.getElementById("tbody");
        for (var i = 0; i < result.length; i++) {
            str += "<tr>" +
                "<td>" + result[i].teaNumber + "</td>" +
                "<td>" + result[i].teaName + "</td>" +
                "<td>" + result[i].teaGender + "</td>" +
                "<td>" + result[i].teaWork + "</td>";
            console.log(result[i].teacherJob);
//                for(var j=0;j<result[i].teacherJob.length;j++){
            str = str + "<td>" + result[i].teacherJob.teaPositionInfo + "</td>";
//                }
            str = str + "<td>" + result[i].teaPhone + "</td>" +
                "<td>" +
                "<button type='button' class='btn btn-xs btn-info' onclick='getTea(" + result[i].id + ")'>查看</button>" +
                "<button type='button' class='btn btn-xs btn-danger' onclick='delTea(" + result[i].id + ")'>删除</button>" +
                "</tr>";
        }
        tBody.innerHTML = str;
    }
});

//搜索
function d() {
    if ($("#dim").val() == "") {
        alert("请先输入关键字再搜索");
    } else {
        $.ajax({
            url: "/getDimTeacherList/" + $("#dim").val() + "",
            success: function (result) {
                var str = "";
                var tBody = document.getElementById("tbody");
                for (var i = 0; i < result.length; i++) {
                    str += "<tr>" +
                        "<td>" + result[i].teaNumber + "</td>" +
                        "<td>" + result[i].teaName + "</td>" +
                        "<td>" + result[i].teaGender + "</td>" +
                        "<td>" + result[i].teaWork + "</td>";
                    console.log(result[i].teacherJob);
                    str = str + "<td>" + result[i].teacherJob.teaPositionInfo + "</td>";
                    str = str + "<td>" + result[i].teaPhone + "</td>" +
                        "<td>" +
                        "<button type='button' class='btn btn-xs btn-info' onclick='getTea(" + result[i].id + ")'>查看</button>" +
                        "<button type='button' class='btn btn-xs btn-danger' onclick='delTea(" + result[i].id + ")'>删除</button>" +
                        "</tr>";
                }
                tBody.innerHTML = str;
            }
        });
    }
};

//删除
function delTea(id) {
    $.ajax({
        type: "POST",
        url: "/deleteTeacher",
        data: {
            _method: "DELETE",
            "id": id
        },
        success: function (result) {
            console.log("删除成功");
            //删除刷新当前页面
            window.location.href = "/teacherList.jsp";
        }
    });
};

//查看跳转
function getTea(id) {
    window.location.href = "/teacherGetInfo.jsp?id=" + id;
}

//添加教师
function addTeacher() {
    window.location.href = "/teacherAdd.jsp";
}